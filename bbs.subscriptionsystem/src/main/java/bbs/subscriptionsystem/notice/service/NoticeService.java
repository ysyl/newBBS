package bbs.subscriptionsystem.notice.service;

import java.util.List;

import bbs.subscriptionsystem.notice.entity.BaseNotice;

public interface NoticeService {

	public List<BaseNotice> getAllNoticeByUid(long uid);
	
	public Integer getNoticeCountByUid(long uid);

	boolean freshLastReadTime(long uid);
}
