package x.zieba.forum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.repository.PostRepository;
import x.zieba.forum.repository.TopicRepository;
import x.zieba.forum.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	public Topic findOneTopic(int id) {
		return topicRepository.findOne(id);
	}
	
	@Transactional
	public User findOneWithTopics(int id) {
		User user = findOne(id);
		List<Post> posts = postRepository.findByUser(user);
		for (Post post : posts) {
			Topic topic = findOneTopic(1);
			post.setTopic(topic);
		}
		user.setPosts(posts);
		return user;
	}
}
