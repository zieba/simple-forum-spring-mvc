package x.zieba.forum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import x.zieba.forum.entity.Post;
import x.zieba.forum.entity.Topic;
import x.zieba.forum.entity.User;
import x.zieba.forum.service.PostService;
import x.zieba.forum.service.TopicService;
import x.zieba.forum.service.UserService;

@Controller
public class UserController {
	
	private int idTopic;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private TopicService topicService;
	
	@ModelAttribute("user")
	public User constructUser() {
		return new User();
	}
	
	@ModelAttribute("topic")
	public Topic constructTopic() {
		return new Topic();
	}
	
	@ModelAttribute("post")
	public Post constructPost() {
		return new Post();
	}
	
	@RequestMapping("/users")
	public String allUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping("/users/{id}")
	public String detail(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneWithTopics(id));
		return "user-detail";
	}
	
	@RequestMapping("/register")
	public String showRegister() {
		return "user-register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/register.html?success=true";
	}
	
	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneWithTopics(name));
		return "user-detail";
	}
	
	@RequestMapping("/index")
	public String topics(Model model) {
		model.addAttribute("topics", topicService.findAll());
		return "index";
	}
	
	@RequestMapping("/newtopic")
	public String showTopicForm(ModelMap map) {
		Topic topic = new Topic();
		Post post = new Post();
		map.addAttribute("topic", topic);
		map.addAttribute("post", post);
		return "newtopic";
	}
	
	@RequestMapping(value="/newtopic", method=RequestMethod.POST)
	public String newTopic(@ModelAttribute("topic") Topic topic, @ModelAttribute("post") Post post, Principal principal){
		String name = principal.getName();
		topicService.saveTopic(topic, post, name);
		return "redirect:/index.html";
	}
	
	@RequestMapping(value = "/topic/{id}")
	public String viewTopic(Model model, @PathVariable int id) {
		model.addAttribute("topic", topicService.findOneWithPosts(id));
		return "topic";
	}
	
	@RequestMapping("/newpost")
	public String showPostForm(Model model, @RequestParam("id") int id){
		idTopic = id;
		Post post = new Post();
		model.addAttribute("post", post);
		return "newpost";
	}
	
	@RequestMapping(value="/newpost", method=RequestMethod.POST)
	public String newPost(@ModelAttribute("post") Post post, Principal principal) {
		String name = principal.getName();
		postService.save(post, name, idTopic);
		return "redirect:/topic/" + idTopic + ".html";
	}
	
	@RequestMapping("/topic/remove/{id}")
	public String removeTopic(@PathVariable int id) {
		topicService.delete(id);
		return "redirect:/index.html";
	}
	
	@RequestMapping("/user/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/users.html";
	}
	
	@RequestMapping("/post/remove/{id}")
	public String removePost(@PathVariable int id){
		postService.delete(id);
		return "redirect:/index.html";
	}

}
