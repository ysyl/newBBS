package bbs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import bbs.helper.utils.MyLogger;
import bbs.security.form.BbsUserForm;
import bbs.security.service.BbsSecurityService;

@Controller
@RequestMapping("/principal")
public class UserPrincipalController {
	
	private BbsSecurityService bbsSecurityService;

	@Autowired
	public UserPrincipalController(BbsSecurityService bbsSecurityService) {
		super();
		this.bbsSecurityService = bbsSecurityService;
	}

	@PostMapping("/register")
	public String registerPost(BbsUserForm form) {
		MyLogger.info("\n 进入注册控制器");
		bbsSecurityService.register(form);
		return "redirect:/";
	}
}
