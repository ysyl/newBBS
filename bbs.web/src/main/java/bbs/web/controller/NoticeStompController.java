package bbs.web.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import security.core.DTO.CustomUser;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.notice.service.NoticeService;

@Controller
public class NoticeStompController {
	
	private NoticeService noticeService;
	
	@Autowired
	public NoticeStompController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}

	@MessageMapping("/fresh")
	public String freshLastReadTime(Principal principal) {
		Long uid = ((CustomUser) principal).getId();
		MyLogger.info("\n\n\n\n进入"+ uid);
		boolean isSuccess = noticeService.freshLastReadTime(uid);
		return isSuccess?"SUCCESS":"ERROR";
	}
}
