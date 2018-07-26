package bbs.subscriptionsystem.notice.service;

import java.util.ArrayList;
import java.util.List;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BbsTrendNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;
import bbs.subscriptionsystem.notice.entity.ShopTrendNotice;

public class NoticeResultMap {
	
	private List<BbsTrendNotice> trend = new ArrayList<>();
	
	private List<BeFollowedNotice> beFollowed = new ArrayList<>();
	
	private List<ShopTrendNotice> shop = new ArrayList<>();

	public List<? extends ShopTrendNotice> getShop() {
		return shop;
	}

	public void setShop(List<ShopTrendNotice> shop) {
		this.shop = shop;
	}

	public List<BbsTrendNotice> getTrend() {
		return trend;
	}

	public void setTrend(List<BbsTrendNotice> trend) {
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
			if (baseNotice instanceof BbsTrendNotice) {
				this.trend.add((BbsTrendNotice) baseNotice);
			}
			else if (baseNotice instanceof BeFollowedNotice) {
				this.beFollowed.add((BeFollowedNotice) baseNotice);
			}
			else if (baseNotice instanceof ShopTrendNotice) {
				this.shop.add((ShopTrendNotice) baseNotice);
			}
		}
	}

}
