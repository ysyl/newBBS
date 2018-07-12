package bbs.subscriptionsystem.action.pusher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;
import bbs.subscriptionsystem.subscription.manager.SubscriptionManager;

public class SubscriptionMatcher {
	
	private List<BaseSubscription<?>> subscriptions;
	
	private List<ForumSubscription> forumSubscriptions = new ArrayList<>();
	
	private List<TopicSubscription> topicSubscriptions = new ArrayList<>();
	
	private List<PostSubscription> postSubscriptions = new ArrayList<>();
	
	private List<FollowingSubscription> followingSubscriptions = new ArrayList<>();
	
	private String username = null;

	public SubscriptionMatcher(String username, List<BaseSubscription<?>> subscriptions) {
		super();
		this.username = username;
		this.subscriptions = subscriptions;
		for (BaseSubscription<?> subscription : subscriptions) {
			if (subscription instanceof ForumSubscription) {
				forumSubscriptions.add((ForumSubscription) subscription);
			}
			else if (subscription instanceof TopicSubscription) {
				topicSubscriptions.add((TopicSubscription) subscription);
			}
			else if (subscription instanceof PostSubscription) {
				postSubscriptions.add((PostSubscription) subscription);
			}
			else if (subscription instanceof FollowingSubscription) {
				followingSubscriptions.add((FollowingSubscription) subscription);
			}
		}
	}

	boolean match(BaseAction action) {
		boolean isMatch = false;
		if (action instanceof ForumTrendAction) {
			isMatch = matchForumTrendAction((ForumTrendAction) action);
		}
		else if (action instanceof TopicTrendAction) {
			isMatch = matchTopicTrendAction((TopicTrendAction) action);
		}
		else if (action instanceof PostTrendAction) {
			isMatch = matchPostTrendAction((PostTrendAction) action);
		}
		else if (action instanceof UserTrendAction) {
			isMatch = matchUserTrendAction((UserTrendAction<?>)action);
		}
		System.out.println(isMatch);
		return isMatch;
	}
	
	private boolean matchUserTrendAction(UserTrendAction<?> action) {
		// TODO Auto-generated method stub
		for (FollowingSubscription subscription : followingSubscriptions) {
			Long followingId = subscription.getTarget().getId();
			if (followingId.equals(action.getUser().getId()))
				return true;
		}
		return false;
	}

	private boolean matchForumTrendAction(ForumTrendAction action) {
		for (ForumSubscription subscription : forumSubscriptions) {
			return subscription.getTarget().getId().equals(action.getForum().getId());
		}
		return false;
	}
	
	private boolean matchTopicTrendAction(TopicTrendAction action) {
		for (TopicSubscription subscription : topicSubscriptions) {
			System.out.println(subscription.getTarget().getTitle() + " action : " + action.getTopic().getTitle());
			return subscription.getTarget().getId().equals(action.getTopic().getId());
		}
		return false;
	}
	
	private boolean matchPostTrendAction(PostTrendAction action) {
		for (PostSubscription subscription : postSubscriptions) {
			return subscription.getTarget().getId().equals(action.getTargetPost().getId());
		}
		return false;
		
	}
}
