package x.zieba.forum.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Role;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.repository.PostRepository;
import x.zieba.forum.repository.RoleRepository;
import x.zieba.forum.repository.TopicRepository;
import x.zieba.forum.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	public Topic findOneTopic(int id) {
		return topicRepository.findOne(id);
	}
	
	public User findOneWithTopics(int id) {
		User user = findOne(id);
		PageRequest request = new PageRequest(0, 20, Direction.DESC, "publishedDate");
		List<Post> posts = postRepository.findByUser(user, request);
		for (Post post : posts) {
			Topic topic = findOneTopic(post.getTopic().getId());
			post.setTopic(topic);
		}
		user.setPosts(posts);
		return user;
	}

	public void save(User user) {
		user.setEnabled(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName("ROLE_USER"));
		user.setRoles(roles);
		
		userRepository.save(user);
		
		
		
	}

	public User findOneWithTopics(String name) {
		User user = userRepository.findByName(name);
		return findOneWithTopics(user.getId());
	}

	public void delete(int id) {
		userRepository.delete(id);
	}
}
