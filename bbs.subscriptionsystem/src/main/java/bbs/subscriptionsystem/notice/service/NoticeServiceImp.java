package bbs.subscriptionsystem.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.utils.NoticeBuilder;
import bbs.subscriptionsystem.service.SubscribedActionService;

@Service
public class NoticeServiceImp implements NoticeService {
	
	private NoticeBuilder noticeBuilder;
	
	private SubscribedActionService subService;

	@Autowired
	public NoticeServiceImp(NoticeBuilder noticeBuilder, SubscribedActionService subService) {
		super();
		this.noticeBuilder = noticeBuilder;
		this.subService = subService;
	}

	@Override
	public List<BaseNotice> getAllNoticeByUid(long uid) {
		// TODO Auto-generated method stub
		return noticeBuilder.transActionListToNotice(subService.getAllActionByUid(uid));
	}

}
