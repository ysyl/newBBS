package bbs.subscriptionsystem.action.pusher;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bbs.helper.utils.MyLogger;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BbsTrendAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CollectUserAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.BeFollowedSubscription;
import bbs.subscriptionsystem.subscription.entity.FollowingSubscription;
import bbs.subscriptionsystem.subscription.entity.ForumSubscription;
import bbs.subscriptionsystem.subscription.entity.PostSubscription;
import bbs.subscriptionsystem.subscription.entity.TopicSubscription;

public class SubscriptionMatcher {
	
	private List<BaseSubscription<?>> subscriptions;
	
	private List<ForumSubscription> forumSubscriptions = new ArrayList<>();
	
	private List<TopicSubscription> topicSubscriptions = new ArrayList<>();
	
	private List<PostSubscription> postSubscriptions = new ArrayList<>();
	
	private List<FollowingSubscription> followingSubscriptions = new ArrayList<>();
	
	private List<BeFollowedSubscription> beFollowedSubscriptions = new ArrayList<>();
	
	private String username = null;

	public SubscriptionMatcher(String username, List<BaseSubscription<?>> subscriptions) {
		super();
		this.username = username;
		this.freshSubscriptions(subscriptions);
	}
	
	public void freshSubscriptions(List<BaseSubscription<?>> subscriptions) {
		MyLogger.info("\n\n\n刷新之前的forum订阅情况 ： "+this.forumSubscriptions.size());
		MyLogger.info("\n\n\n刷新之前的topic订阅情况 ： "+this.topicSubscriptions.size());
		MyLogger.info("\n\n\n刷新之前的post订阅情况 ： "+this.postSubscriptions.size());
		MyLogger.info("\n\n\n刷新之前的following订阅情况 ： "+this.followingSubscriptions.size());
		MyLogger.info("\n\n\n刷新之前的beFollowing订阅情况 ： "+this.beFollowedSubscriptions.size());
		this.subscriptions = subscriptions;
		this.topicSubscriptions.clear();
		this.forumSubscriptions.clear();
		this.postSubscriptions.clear();
		this.followingSubscriptions.clear();
		this.beFollowedSubscriptions.clear();
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
			else if (subscription instanceof BeFollowedSubscription) {
				beFollowedSubscriptions.add((BeFollowedSubscription) subscription);
			}
		}
				MyLogger.info("\n\n\n刷新后的forum订阅情况 ： "+this.forumSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的topic订阅情况 ： "+this.topicSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的post订阅情况 ： "+this.postSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的following订阅情况 ： "+this.followingSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的beFollowing订阅情况 ： "+this.beFollowedSubscriptions.size());
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
		else if (action instanceof BeFollowedAction) {
			isMatch = matchBeFollowedAction((BeFollowedAction) action);
		}
		MyLogger.info(action.getClass().getSimpleName() + "在 Matcher.match 中的匹配结果" + isMatch);
		return isMatch;
	}
	
	
	private boolean matchBeFollowedAction(BeFollowedAction action) {
		// TODO Auto-generated method stub
		BeFollowedSubscription subscription = beFollowedSubscriptions.get(0);
		if (action.getFollowingUser().getId().equals(subscription.getUser().getId()))
			return true;
		return false;
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
		boolean isMatch = false;
		for (ForumSubscription subscription : forumSubscriptions) {
			isMatch = subscription.getTarget().getId().equals(action.getForum().getId());
			if (isMatch) break;
		}
		return isMatch;
	}
	
	private boolean matchTopicTrendAction(TopicTrendAction action) {
		boolean isMatch = false;
		for (TopicSubscription subscription : topicSubscriptions) {
			MyLogger.info(subscription.getTarget().getTitle() + " action : " + action.getTopic().getTitle());
			isMatch = subscription.getTarget().getId().equals(action.getTopic().getId());
			if (isMatch) break;
		}
		return isMatch;
	}
	
	private boolean matchPostTrendAction(PostTrendAction action) {
		boolean isMatch = false;
		for (PostSubscription subscription : postSubscriptions) {
			isMatch = subscription.getTarget().getId().equals(action.getTargetPost().getId());
			if (isMatch) break;
		}
		return isMatch;
		
	}
}
