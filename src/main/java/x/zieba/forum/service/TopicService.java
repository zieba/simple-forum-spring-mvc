package x.zieba.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.repository.PostRepository;
import x.zieba.forum.repository.TopicRepository;
import x.zieba.forum.repository.UserRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Topic> findAll() {
		return topicRepository.findAll();
	}
	
	public Topic findOne(int id) {
		return topicRepository.findOne(id);
	}

	public Topic findOneWithPosts(int id) {
		 Topic topic = findOne(id);
		 List<Post> posts = postRepository.findByTopic(topic);
		 for (Post post : posts) {
			 User user = userRepository.findOne(post.getUser().getId());
			 post.setUser(user); 
		 }
		 topic.setPosts(posts);
		 return topic;
	}

}
