package x.zieba.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.service.PostService;
import x.zieba.forum.service.TopicService;
import x.zieba.forum.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	TopicService topicService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	PostService postService;

	
	@RequestMapping("/topic/remove/{id}")
	public String removeTopic(@PathVariable int id) {
		Topic topic = topicService.findOne(id);
		topicService.delete(topic);
		return "redirect:/index.html";
	}
	
	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable int id) {
		User user = userService.findOne(id);
		userService.delete(user);
		return "redirect:/users.html";
	}
	
	@RequestMapping("/post/remove/{id}")
	public String removePost(@PathVariable int id){
		Post post = postService.findOne(id);
		postService.delete(post);
		return "redirect:/index.html";
	}

}
