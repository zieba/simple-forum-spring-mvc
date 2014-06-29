package x.zieba.forum.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if(result.hasErrors()){
			return "user-register";
		}
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
	public String newTopic(@Valid @ModelAttribute("topic") Topic topic, BindingResult topicResult, @Valid @ModelAttribute("post") Post post, BindingResult postResult, Principal principal){
		if(topicResult.hasErrors() || topicResult.hasErrors()){
			return "newtopic";
		}
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
	public String newPost(@Valid @ModelAttribute("post") Post post, BindingResult result, Principal principal) {
		if(result.hasErrors()) {
			return "newpost";
		}
		String name = principal.getName();
		postService.save(post, name, idTopic);
		return "redirect:/topic/" + idTopic + ".html";
	}
	
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
