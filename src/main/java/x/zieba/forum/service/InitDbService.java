package x.zieba.forum.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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

@Transactional
@Service
public class InitDbService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	@PostConstruct
	public void init() {
		if(roleRepository.findByName("ROLE_ADMIN") == null){
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
	
		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("NTPadmin"));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Topic firstTopic = new Topic();
		firstTopic.setName("Pierwszy temat");
		topicRepository.save(firstTopic);
		
		Post post1 = new Post();
		post1.setTopic(firstTopic);
		post1.setUser(userAdmin);
		post1.setText("Pierwszy post!");
		post1.setPublishedDate(new Date());
		postRepository.save(post1);
		
		Post post2 = new Post();
		post2.setTopic(firstTopic);
		post2.setUser(userAdmin);
		post2.setText("Drugi post!");
		post2.setPublishedDate(new Date());
		postRepository.save(post2);
		}
	}
	

}
