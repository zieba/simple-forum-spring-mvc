package x.zieba.forum.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import x.zieba.forum.entity.User;
import x.zieba.forum.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@ModelAttribute("user")
	public User construct() {
		return new User();
	}
	
	/*
	@ModelAttribute("user")
	public Post constructFirstPost() {
		return new Post();
	}*/
	
	@RequestMapping("/users")
	public String users(Model model) {
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
	/*
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String firstPost
	*/

}
