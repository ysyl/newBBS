package bbs.subscriptionsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.subscription.DAO.SubscriptionDAO;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;
import bbs.subscriptionsystem.subscription.provider.SubscriptionProvider;

public interface SubscriptionService {

	public void subscribeTopic(long uid, long topicId);

	public void subscribePost(long uid, long postId);

	public void subscribeUserTrend(long uid, long followingId);

	public void subscribeForum(long uid, int forumId);
	
	public void subscribeSelf(long myUid);

	public void unsubscribeForum(long uid, int forumId);

	public void unsubscribePost(long uid, long postId);

	public void unsubscribeTopic(long uid, long topicId);

	public void unsubscribeUser(long uid, long followingId);

	public List<? extends BaseSubscription<?>> getSubscriptions(long uid);

	public void updateLastReadTime(BaseSubscription<?> subscription);

	public void subscribeCommody(Long uid, Long commodyId);

	public void subscribeCommodyComment(Long uid, long commentId);

	public void unsubscribeCommody(long uid, long commodyId);

}
