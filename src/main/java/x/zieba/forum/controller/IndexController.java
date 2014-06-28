package x.zieba.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import x.zieba.forum.service.TopicService;

@Controller
public class IndexController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/index")
	public String users(Model model) {
		model.addAttribute("topics", topicService.findAll());
		return "index";
	}
	
	@RequestMapping("/topic/{id}")
	public String viewTopic(Model model, @PathVariable int id) {
		model.addAttribute("topic", topicService.findOneWithPosts(id));
		return "topic";
	}
}
