package bbs.web.controller;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import bbs.forum.DTO.Forum;
import bbs.forum.DTO.Post;
import bbs.forum.service.BbsService;
import bbs.helper.utils.MyLogger;

@Controller
public class IndexController {
	
	private BbsService bbsService;

	@Autowired
	public IndexController(BbsService bbsService) {
		super();
		this.bbsService = bbsService;
	}

	@GetMapping("/")
	public String index(HttpSession session, Model model, Principal principal) {
		List<Forum> forums = bbsService.getAllForums(); 
		Map<Integer, Post> lastPostMap = bbsService.getLastPostInForum();
		model.addAttribute("forums", forums);
		model.addAttribute("lastPostMap", lastPostMap);
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		MyLogger.info("\n进入login控制器");
		return "login";
	}

	@GetMapping("/register")
	public String register() {
		MyLogger.info("\n进入login控制器");
		return "register";
	}
}
