package x.zieba.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import x.zieba.forum.service.TopicService;

@Controller
public class IndexController {
	
	@Autowired
	private TopicService topicService;
	
	
	
	@RequestMapping(value = "/topic")
	public String viewTopic(Model model, @RequestParam("id") int id) {
		model.addAttribute("topic", topicService.findOneWithPosts(id));
		return "topic";
	}
}
