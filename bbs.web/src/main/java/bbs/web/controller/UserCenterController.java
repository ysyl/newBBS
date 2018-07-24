package bbs.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bbs.form.utils.PageParam;
import bbs.forum.DTO.Topic;
import bbs.forum.DTO.User;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;

@Controller
@RequestMapping("/usercenter")
public class UserCenterController {
	
	private BbsService bbsService;

	@Autowired
	public UserCenterController(BbsService bbsService) {
		super();
		this.bbsService = bbsService;
	}


	@GetMapping("/user/{userId}")
	public String usercenter(@PathVariable("userId") long userId, Model model) {
		User user = bbsService.getUser(userId);
		//temp
		PageParam pageParam = new PageParam(0, 20);
		List<Topic> topics = bbsService.getTopicListByUid(userId, pageParam);
		MyLogger.info(topics.size() + " \n\n\n");
		model.addAttribute("user", user);
		model.addAttribute("topics", topics);
		return "usercenter";
	}
}
