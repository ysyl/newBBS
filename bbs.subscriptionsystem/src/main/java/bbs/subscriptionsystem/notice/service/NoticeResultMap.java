package bbs.subscriptionsystem.notice.service;

import java.util.ArrayList;
import java.util.List;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BaseTrendNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;

public class NoticeResultMap {
	
	private List<BaseTrendNotice> trend = new ArrayList<>();
	
	private List<BeFollowedNotice> beFollowed = new ArrayList<>();

	public List<BaseTrendNotice> getTrend() {
		return trend;
	}

	public void setTrend(List<BaseTrendNotice> trend) {
		this.trend = trend;
	}

	public List<BeFollowedNotice> getBeFollowed() {
		return beFollowed;
	}

	public void setBeFollowed(List<BeFollowedNotice> beFollowed) {
		this.beFollowed = beFollowed;
	}

	public NoticeResultMap(List<? extends BaseNotice> noticeList) {
		super();
		for (BaseNotice baseNotice : noticeList) {
			if (baseNotice instanceof BaseTrendNotice) {
				this.trend.add((BaseTrendNotice) baseNotice);
			}
			else if (baseNotice instanceof BeFollowedNotice) {
				this.beFollowed.add((BeFollowedNotice) baseNotice);
			}
		}
	}

}
