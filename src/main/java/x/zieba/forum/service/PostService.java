package x.zieba.forum.service;



import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.repository.PostRepository;
import x.zieba.forum.repository.TopicRepository;
import x.zieba.forum.repository.UserRepository;

@Service
@Transactional
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TopicRepository topicRepository;

	public void save(Post post, String name, int id) {
		User user = userRepository.findByName(name);
		post.setUser(user);
		Topic topic = topicRepository.findOne(id);
		post.setTopic(topic);
		post.setPublishedDate(new Date());
		postRepository.save(post);
	}
	
	public Post findOne(int id) {
		return postRepository.findOne(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	public void delete(@P("topic") Post post) {
		postRepository.delete(post);
	}


}
