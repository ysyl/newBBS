package bbs.subscriptionsystem.action.pusher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bbs.helper.utils.MyLogger;
import bbs.shop.entity.PrimaryCommodyComment;
import bbs.shop.entity.ReplyCommodyComment;
import bbs.subscriptionsystem.action.entity.AbstractCollectAction;
import bbs.subscriptionsystem.action.entity.BaseAction;
import bbs.subscriptionsystem.action.entity.BbsTrendAction;
import bbs.subscriptionsystem.action.entity.BeFollowedAction;
import bbs.subscriptionsystem.action.entity.CollectUserAction;
import bbs.subscriptionsystem.action.entity.CommodyCommentAction;
import bbs.subscriptionsystem.action.entity.CommodyTrendAction;
import bbs.subscriptionsystem.action.entity.ForumTrendAction;
import bbs.subscriptionsystem.action.entity.PostTrendAction;
import bbs.subscriptionsystem.action.entity.ShopTrendAction;
import bbs.subscriptionsystem.action.entity.TopicTrendAction;
import bbs.subscriptionsystem.action.entity.UserTrendAction;
import bbs.subscriptionsystem.subscription.entity.BaseSubscription;
import bbs.subscriptionsystem.subscription.entity.BeFollowedSubscription;
import bbs.subscriptionsystem.subscription.entity.CommodyCommentSubscription;
import bbs.subscriptionsystem.subscription.entity.CommodySubscription;
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
	
	private List<CommodySubscription> commodySubscriptions = new ArrayList<>();

	private List<CommodyCommentSubscription> commodyCommentSubscriptions = new ArrayList<>();
	
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
		MyLogger.info("\n\n\n刷新之前的Commody订阅情况 ： "+this.commodySubscriptions.size());
		MyLogger.info("\n\n\n刷新之前的CommodyComment订阅情况 ： "+this.commodyCommentSubscriptions.size());
		this.subscriptions = subscriptions;
		this.topicSubscriptions.clear();
		this.forumSubscriptions.clear();
		this.postSubscriptions.clear();
		this.followingSubscriptions.clear();
		this.beFollowedSubscriptions.clear();
		this.commodySubscriptions.clear();
		this.commodyCommentSubscriptions.clear();
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
			else if (subscription instanceof CommodySubscription) {
				commodySubscriptions.add((CommodySubscription) subscription);
			}
			else if (subscription instanceof CommodyCommentSubscription) {
				commodyCommentSubscriptions.add((CommodyCommentSubscription) subscription);
			}
		}
				MyLogger.info("\n\n\n刷新后的forum订阅情况 ： "+this.forumSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的topic订阅情况 ： "+this.topicSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的post订阅情况 ： "+this.postSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的following订阅情况 ： "+this.followingSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的beFollowing订阅情况 ： "+this.beFollowedSubscriptions.size());
				MyLogger.info("\n\n\n刷新后的Commody订阅情况 ： "+this.commodySubscriptions.size());
				MyLogger.info("\n\n\n刷新后的CommodyComment订阅情况 ： "+this.commodyCommentSubscriptions.size());
	}

	Map<String, BaseAction> match(Map<String, BaseAction> actionMap) {
		BaseAction action = actionMap.get("raw");
		if (action instanceof ForumTrendAction) {
			if (matchForumTrendAction((ForumTrendAction) action))
				this.putActionToMap(actionMap, action);
		}
		else if (action instanceof TopicTrendAction) {
			if (matchTopicTrendAction((TopicTrendAction) action)) 
				this.putActionToMap(actionMap, action);
		}
		else if (action instanceof PostTrendAction) {
			if (matchPostTrendAction((PostTrendAction) action))
				this.putActionToMap(actionMap, action);
		}
		else if (action instanceof UserTrendAction) {
		//UserTrendAction中的CollectionAction单独判断
			if (action instanceof AbstractCollectAction) {
		//判断是否是关注自己的Action
				if (action instanceof CollectUserAction) {
					BeFollowedAction beFollowedAction = new BeFollowedAction((CollectUserAction) action);
					if (matchBeFollowedAction(beFollowedAction)) {
						this.putActionToMap(actionMap, beFollowedAction);
					//此处必须返回，否则下面会覆盖。
						return actionMap;
					}
				}
			}
		//判断是否是自己关注的用户发布的Action
			if (matchUserTrendAction((UserTrendAction<?>)action))
				this.putActionToMap(actionMap, action);
		}
		else if (action instanceof ShopTrendAction) {
			if (action instanceof CommodyTrendAction) {
				if(action instanceof CommodyCommentAction) {
					if(matchAction((CommodyCommentAction) action))
						this.putActionToMap(actionMap, action);
				}
			}
		}
		MyLogger.info(action.getClass().getSimpleName() + "在 Matcher.match 中的匹配结果" + actionMap.get("new") != null);
		return actionMap;
	}
	
	private void putActionToMap(Map<String, BaseAction> actionMap, BaseAction action) {
		MyLogger.infoln(this.getClass(), "插入action: " + action.getClass().getSimpleName());
		actionMap.put("new", action);
	}
	
	
	private boolean matchAction(CommodyCommentAction action) {
		// TODO Auto-generated method stub
		//commodySubscription 和 commodyCommentSubscription皆可以收到CommodyCommentAction
		for(CommodySubscription commodySubscription : commodySubscriptions) {
			return commodySubscription.getTarget().getId() == action.getCommody().getId();
		}
		for (CommodyCommentSubscription commentSubscription : commodyCommentSubscriptions) {
			//如果action中包含的评论不是Primary，那么一定不符合
			//因为订阅一个PrimaryComment后，收到的一定是楼中楼回复
			if (!(action.getComment() instanceof ReplyCommodyComment)) break;
			return commentSubscription.getTarget().getId()
					.equals( ((ReplyCommodyComment) action.getComment()).getReplyTargetComment().getId());
		}
		return false;
	}

	private boolean matchBeFollowedAction(BeFollowedAction action) {
		// TODO Auto-generated method stub
		MyLogger.infoln(this.getClass(), "检测到BeFollowedAction");
		BeFollowedSubscription subscription = beFollowedSubscriptions.get(0);
		if (action.getFollowingUser().getId().equals(subscription.getUser().getId()))
			return true;
		MyLogger.infoln(this.getClass(), "BeFollowedAction 没有匹配");
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
