package bbs.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;
import bbs.subscriptionsystem.notice.service.NoticeService;

@Controller
public class NoticeStompController {
	
	private NoticeService noticeService;
	
	private SecurityHelper helperService;

	@Autowired
	public NoticeStompController(NoticeService noticeService, SecurityHelper helperService) {
		super();
		this.noticeService = noticeService;
		this.helperService = helperService;
	}

	@MessageMapping("/fresh")
	public String freshLastReadTime() {
		Long uid = helperService.getCurrentUserId();
		MyLogger.info("\n\n\n\n进入"+ uid);
		boolean isSuccess = noticeService.freshLastReadTime(uid);
		return isSuccess?"SUCCESS":"ERROR";
	}
}
