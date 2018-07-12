package bbs.subscriptionsystem.subscription.provider;

import java.util.List;

import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

public interface SubscriptionProvider<T extends BaseSubscription<?>> {
	List<T> getSubscriptionByUid(long uid);
}
