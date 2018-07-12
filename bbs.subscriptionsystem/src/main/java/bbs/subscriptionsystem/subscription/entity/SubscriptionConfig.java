package bbs.subscriptionsystem.subscription.entity;

import java.io.Serializable;

public class SubscriptionConfig implements Serializable {

	private long uid;
	
	private boolean receiveLike;
	
	private boolean receivePub;

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	public boolean isReceiveLike() {
		return receiveLike;
	}

	public void setReceiveLike(boolean receiveLike) {
		this.receiveLike = receiveLike;
	}

	public boolean isReceivePub() {
		return receivePub;
	}

	public void setReceivePub(boolean receivePub) {
		this.receivePub = receivePub;
	}
}
