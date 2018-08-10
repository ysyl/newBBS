package bbs.subscriptionsystem.notice.entity;

import java.util.Date;

public class ShopTrendNotice extends BaseNotice {

	public ShopTrendNotice(int id, Date pubTime, ShopTrendNoticeType shopTrendNoticeType) {
		super(id, pubTime, NoticeType.SHOP_TREND_NOTICE);
		this.shopTrendNoticeType = shopTrendNoticeType;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ShopTrendNoticeType shopTrendNoticeType;

	public ShopTrendNoticeType getShopTrendNoticeType() {
		return shopTrendNoticeType;
	}

	public void setShopTrendNoticeType(ShopTrendNoticeType shopTrendNoticeType) {
		this.shopTrendNoticeType = shopTrendNoticeType;
	}

}
