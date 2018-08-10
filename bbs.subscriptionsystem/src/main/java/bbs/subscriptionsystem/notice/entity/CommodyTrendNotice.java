package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

import bbs.shop.entity.Commody;

public class CommodyTrendNotice extends ShopTrendNotice {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CommodyTrendNotice(int id, Date pubTime, Commody commody) {
		super(id, pubTime);
		this.commody = commody;
		// TODO Auto-generated constructor stub
	}
	
	private Commody commody;

	public Commody getCommody() {
		return commody;
	}

	public void setCommody(Commody commody) {
		this.commody = commody;
	}

}
