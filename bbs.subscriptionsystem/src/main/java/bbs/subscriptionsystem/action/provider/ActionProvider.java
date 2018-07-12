package bbs.subscriptionsystem.action.provider;

import java.util.List;

import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;

public interface ActionProvider {

	List<? extends BaseAction> getAllActionBySubscription(BaseSubscription<?> subscription);

	boolean support(Class<? extends BaseSubscription<?>> subscriptionClass);
}
