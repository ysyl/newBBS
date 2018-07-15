package bbs.web.controller;

import org.springframework.stereotype.Controller;

import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherFactory;
import bbs.subscriptionsystem.action.pusher.SubscriptionMatcherHolder;

public class NoticeStompController {

	private SubscriptionMatcherHolder matcherHolder;
	
	private SubscriptionMatcherFactory matcherFactory;
	
}
