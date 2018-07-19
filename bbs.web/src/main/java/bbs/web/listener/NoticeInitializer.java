package bbs.web.listener;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.security.helper.SecurityHelper;
import bbs.subscriptionsystem.notice.service.NoticeService;


@Component
public class NoticeInitializer {

	private NoticeService noticeService;
	
	private SecurityHelper helperService;
	
	public static final String NOTICE_COUNT_NAME = "initNoticeCount";
	
	@Autowired
	public NoticeInitializer(NoticeService noticeService, SecurityHelper helperService) {
		super();
		this.noticeService = noticeService;
		this.helperService = helperService;
	}

	public void initNoticeStatus(HttpSession session) {
		Long uid = helperService.getCurrentUserId();
		Integer count = noticeService.getNoticeCountByUid(uid);
		session.setAttribute(this.NOTICE_COUNT_NAME, count);
		MyLogger.info("\n\n\n登录成功后测试取出count:"+ count);
	}
}
