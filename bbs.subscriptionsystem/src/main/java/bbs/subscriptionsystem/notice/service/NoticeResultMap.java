package bbs.subscriptionsystem.notice.service;

import java.util.ArrayList;
import java.util.List;

import bbs.subscriptionsystem.notice.entity.BaseNotice;
import bbs.subscriptionsystem.notice.entity.BbsTrendNotice;
import bbs.subscriptionsystem.notice.entity.BeFollowedNotice;
import bbs.subscriptionsystem.notice.entity.ShopTrendNotice;
import bbs.subscriptionsystem.notice.entity.UserTrendNotice;

public class NoticeResultMap {
	
	private List<BbsTrendNotice> forum = new ArrayList<>();
	
	private List<BeFollowedNotice> beFollowed = new ArrayList<>();

	private List<UserTrendNotice> user = new ArrayList<>();
	
	private List<ShopTrendNotice> shop = new ArrayList<>();

	public List<? extends ShopTrendNotice> getShop() {
		return shop;
	}

	public void setShop(List<ShopTrendNotice> shop) {
		this.shop = shop;
	}

	public List<BeFollowedNotice> getBeFollowed() {
		return beFollowed;
	}

	public void setBeFollowed(List<BeFollowedNotice> beFollowed) {
		this.beFollowed = beFollowed;
	}

	public List<BbsTrendNotice> getForum() {
		return forum;
	}

	public void setForum(List<BbsTrendNotice> forum) {
		this.forum = forum;
	}

	public List<UserTrendNotice> getUser() {
		return user;
	}

	public void setUser(List<UserTrendNotice> user) {
		this.user = user;
	}

	public NoticeResultMap(List<? extends BaseNotice> noticeList) {
		super();
		for (BaseNotice baseNotice : noticeList) {
			if (baseNotice instanceof UserTrendNotice) {
				this.user.add((UserTrendNotice) baseNotice);
			}
			if (baseNotice instanceof BbsTrendNotice) {
				this.forum.add((BbsTrendNotice) baseNotice);
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
