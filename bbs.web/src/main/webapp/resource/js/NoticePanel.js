  class NoticePanel {

	  constructor(noticePanelToggleBtn, noticePanelWrap,noticePanel, newNoticeRemindElement) {

		 this.noticePanelToggleBtn = noticePanelToggleBtn;
		 this.noticePanelWrap = noticePanelWrap;
		 this.noticePanel = noticePanel; 
		 this.newNoticeRemindElement = newNoticeRemindElement;

		 this.ws = null;
		 this.client = null;

		 this.forumTrendNoticeSet = []; 
		 this.shopTrendNoticeSet = []; 
		 this.userTrendNoticeSet = []; 
		 this.beFollowedNoticeSet = []; 
		 
		 this.forumTrendNoticesHtml = null;
		 this.shopTrendNoticesHtml = null;
		 this.userTrendNoticesHtml = null;
		 this.beFollowedTrendNoticesHtml = null;
		 
		 this.forumTrendNoticePanel = $("#forum-trend-notice");
		 this.shopTrendNoticePanel = $("#shop-trend-notice");
		 this.userTrendNoticePanel = $("#user-trend-notice");
		 this.beFollowedTrendNoticePanel = $("#befollowed-notice");
		 
		 this.forumTrendNoticeBadge = $("[href='#forum-trend-notice'] .badge");
		 this.shopTrendNoticeBadge = $("[href='#shop-trend-notice'] .badge");
		 this.userTrendNoticeBadge = $("[href='#user-trend-notice'] .badge");
		 this.beFollowedNoticeBadge = $("[href='#befollowed-notice'] .badge");
		 
		 // 如果不是第一次打开，则不触发ajax，改成直接显示websocket推送的动作，并用stomp发送刷新订阅时间的请求
		 this.firstOpen = true;
		 this.noticeCount = 0;

		 // 用于拼接通知
		 this.contextPath = null;
		 
		 this.init();
		 
	  }
	  
	  display() {
	  }
	  
	  addToForumTrendNoticeSet(notice) {
		  let isContains = this.forumTrendNoticeSet.some( item => item.id === notice.id)
		  if (!isContains) {
			  this.forumTrendNoticeSet.push(notice);
		  }
	  }

	  addToShopTrendNoticeSet(notice) {
		  let isContains = this.shopTrendNoticeSet.some( item => item.id === notice.id)
		  if (!isContains) {
			  this.shopTrendNoticeSet.push(notice);
		  }
	  }

	  addToUserTrendNoticeSet(notice) {
		  let isContains = this.userTrendNoticeSet.some( item => item.id === notice.id)
		  if (!isContains) {
			  this.userTrendNoticeSet.push(notice);
		  }
	  }

	  addToBeFollowedNoticeSet(notice) {
		  let isContains = this.beFollowedNoticeSet.some( item => item.id === notice.id)
		  if (!isContains) {
			  this.beFollowedNoticeSet.push(notice);
		  }
	  }
	 
	  // 每次设置通知数量时，改变视图
	  setNoticeCount(noticeCount) {
		 this.noticeCount = noticeCount; 
		 this.displayNoticeCount();
	  }
	  
	  addToNoticeSet(notice) {
		  switch(notice.noticeType) {
		  case "FORUM_TREND_NOTICE":
			  this.addToForumTrendNoticeSet(notice); 
// this.setForumTrendNoticeHtml();
			  break;
		  case "SHOP_TREND_NOTICE":
			  this.addToShopTrendNoticeSet(notice);
// this.setShopTrendNoticeHtml();
			  break;
		  case "USER_TREND_NOTICE":
			  this.addToUserTrendNoticeSet(notice);
// this.setUserTrendNoticeHtml();
			  break;
		  case "BEFOLLOWED_NOTICE":
			  this.addToBeFollowedNoticeSet(notice);
// this.setBeFollowingNoticeHtml();
			  break;
		  }
		  this.logNoticeSet();
		  this.freshHtml();
	  }
	  
	  logNoticeSet() {
		  console.log("forum " + JSON.stringify(Array.from(this.forumTrendNoticeSet)))
		  console.log("shop " + JSON.stringify(Array.from(this.shopTrendNoticeSet)))
		  console.log("user " + JSON.stringify(Array.from(this.userTrendNoticeSet)))
		  console.log("beFollowing " + JSON.stringify(Array.from(this.beFollowedNoticeSet)))
	  }

	  addAllToNoticeSet(noticeList) {
		  noticeList.forEach( notice => {
			  switch(notice.noticeType) {
			  case "FORUM_TREND_NOTICE":
				  this.addToForumTrendNoticeSet(notice); 
// this.setForumTrendNoticeHtml();
				  break;
			  case "SHOP_TREND_NOTICE":
				  this.addToShopTrendNoticeSet(notice);
// this.setShopTrendNoticeHtml();
				  break;
			  case "USER_TREND_NOTICE":
				  this.addToUserTrendNoticeSet(notice);
// this.setUserTrendNoticeHtml();
				  break;
			  case "BEFOLLOWED_NOTICE":
				  this.addToBeFollowedNoticeSet(notice);
// this.setBeFollowingNoticeHtml();
				  break;;
			  };
		  })
		  this.logNoticeSet();
		  this.freshHtml();
	  }
	  
	  clearNotice() {
		  this.forumTrendNoticeSet = new Set(); 
		  this.shopTrendNoticeSet = new Set(); 
		  this.userTrendNoticeSet = new Set(); 
		  this.beFollowedNoticeSet = new Set(); ;
		  this.freshHtml();
	  }
	  
	  freshHtml() {
		  this.freshForumTrendNoticesHtml();
		  this.freshShopTrendNoticesHtml();
		  this.freshUserTrendNoticesHtml();
		  this.freshBeFollowedNoticesHtml();
	  }
	  
	  
	  init() {
		 /*
			 * 初始化工作包括 先ajax抓取通知数量，再显示 连接websocket，以获取通知数量
			 * 绑定点击事件，点击后先判断时候第一次打开，如果是，则发送ajax拉取通知，如果不是，则直接显示内部notices
			 */
		this.initNoticeCount();
		this.connect(connectUrl);
		this.noticePanelToggleBtn.click(this.handleClick.bind(this));
	  }

	  initNoticeCount() {
			 let self = this;
			 $.ajax({
				 url: pullNoticesCountUrl,
				 success: count => { this.setNoticeCount(count)}, 
				 failure: e => {console.log(e.message)},
			 }) 
		  
	  }
	  
	  
	  connect (connectUrl) {
		 this.ws = new SockJS(connectUrl); 
		 this.client = webstomp.over(this.ws);
		 this.client.connect({}, this.connectSuccessCallback.bind(this),
				 e => { console.log(e.message) });
	  }
	  
	  connectSuccessCallback() {
		  // 连接成功后订阅动态
		  this.subscribeTrendNotice.bind(this)();
	  }

	  subscribeTrendNotice() {
		 this.client.subscribe(subscribeTrendNoticeUrl, this.receiveTrendNotice.bind(this)); 
	  }
	  
	  receiveTrendNotice(frame) {
		  this.setNoticeCount(this.noticeCount + 1);
		  let stompMessage = JSON.parse(frame.body);
		  this.addToNoticeSet(stompMessage);
	  }
	  
	  handleClick(e) {
		  this.display();
		  if(this.firstOpen) {
			  console.log("第一次打开,执行ajax");
			  this.setNoticeCount(0);
			  // 拉取通知后会执行显示通知的方法
			  this.pullNotices();
			  this.firstOpen = false;
		  }
		  else {
			  this.setNoticeCount(0);
			  this.ajaxFreshLastReadTime();
		  }
	  }
	  
	  ajaxFreshLastReadTime() {
		  $.get({
			 url:  ajaxFreshLastReadTimeUrl,
		  })
	  }
	  
	  displayNoticeCount() {
		  this.newNoticeRemindElement.html(this.noticeCount);
	  }
	  
	  pullNotices() {
		 let self = this;
		 $.ajax({
			 url: pullNoticesUrl,
			 success: noticeResult => { 
				 // 得到的通知包含四个键，对应四个tab，每个键有一个noticeList
				 let noticeList = Object.entries(noticeResult)
				 .map( entry => entry[1])
				 .reduce( (prevNoticeList, currNoticeList) => prevNoticeList.concat(currNoticeList) )
				 this.addAllToNoticeSet(noticeList);
				 this.contextPath = noticeResult.contextPath;
				 }, 
			 failure: e => { console.log(e.message) },
		 }) 
	  }
	  
	  freshForumTrendNoticesHtml() {
		  
		  //todo 现在未做公告，因此此函数待定
		 let getForumTrendNoticeHtml = notice => {
			 return `
			 			<div class="post-item clearfix">
                          <div class="post-item-content">
                            	你关注的论坛：<a href="#">${notice}</a> 收到了<a href='#'>5</a>条回复
                          </div>
                        </div>

			 `;
		 }
		  let getTopicTrendNoticeHtml = topicTrendNotice => {
			  return `
			  			<div class="post-item clearfix">
                          <div class="post-item-content">
                            你关注的主题：<a href="#">${topicTrendNotice.topicTitle}</a> 
                           	收到了1条
                           		<a href="${contextPath}/forum/topic/${topicTrendNotice.topicId}">新回复</a>
                          </div>
                        </div>

			  `;
		  }
		  let getPostTrendNoticeHtml = postTrendNotice => {
			  return `
			  			<div class="post-item clearfix">
                          <div class="post-item-content">
                            你关注的回复：<a href="${contextPath}/forum/topic/${postTrendNotice.topicId}">${postTrendNotice.postDigest}</a> 
                           	收到了1条
                           		<a href="${contextPath}/forum/topic/${postTrendNotice.topicId}">
                           			新回复
                           		</a>
                          </div>
                        </div> 
			  `;
		 }
		  
		 this.forumTrendNoticesHtml = this.forumTrendNoticeSet.map( forumNotice => {
			  switch(forumNotice.forumTrendNoticeType) {
				  case "FORUM":
					  return getForumTrendNoticeHtml(forumNotice);
				  case "TOPIC":
					  return getTopicTrendNoticeHtml(forumNotice);
				  case "POST":
					  return getPostTrendNoticeHtml(forumNotice);
			  }
		  });
		 
		 this.forumTrendNoticePanel.html(this.forumTrendNoticesHtml);
		 this.forumTrendNoticeBadge.html(this.forumTrendNoticeSet.length?this.forumTrendNoticeSet.length:'');
	  }

	  freshBeFollowedNoticesHtml() {
		  let getBeFollowedNoticeHtml = beFollowedNotice => {
			  return `
			  <div class="post-item clearfix">
                          <div class="post-item-content">
			  				用户:
                            	<a href="${contextPath}/usercenter/${beFollowedNotice.userId}">
			  						${beFollowedNotice.nickname}</a> 
			  					关注了你
                          </div>
                        </div> 
			  `;
		  }
		  
		  this.beFollowedNoticesHtml = this
		  		.beFollowedNoticeSet.map( notice => getBeFollowedNoticeHtml(notice));

		 this.beFollowedTrendNoticePanel.html(this.beFollowedNoticesHtml);
		 this.beFollowedNoticeBadge.html(this.beFollowedNoticeSet.length?this.beFollowedNoticeSet.length:'');
	  }
		 
	  freshUserTrendNoticesHtml() {
		  let getUserTrendNoticeHtml = userTrendNotice => {
			  return `
			  			<div class="post-item clearfix">
                          <div class="post-item-content">
                            你关注的用户：
                            	<a href="${contextPath}/usercenter/${userTrendNotice.userId}">
			  						${userTrendNotice.nickname}</a> 
			  					${userTrendNotice.actionType}
			  					一个
                           		<a href="${contextPath}/forum/topic/${userTrendNotice.topicId}">
                           			新${userTrendNotice.targetType}
                           		</a>
                          </div>
                        </div> 
			  `;
		  }

		  this.userTrendNoticesHtml = this.userTrendNoticeSet.map( notice => 
		  		getUserTrendNoticeHtml(notice));
		  
		  this.userTrendNoticePanel.html(this.userTrendNoticesHtml);
		  this.userTrendNoticeBadge.html(this.userTrendNoticeSet.length?this.userTrendNoticeSet.length:'');
	  }
	  
	  freshShopTrendNoticesHtml() {
		  
		  let getCommodyCommentNoticeHtml = commodyCommentNotice => {
			  return `
			  			<div class="post-item clearfix">
                          <div class="post-item-content">
                            商品：
			  				<a href="${contextPath}/shop/commody/${commodyCommentNotice.commodyId}">
			  				${commodyCommentNotice.commodyTitle}
			  				</a>
                           	收到了1条
                           		<a href="${contextPath}/shop/commody/${commodyCommentNotice.commodyId}">
                           			新留言
                           		</a>
                          </div>
                        </div> 
			  `;
		  }
		  
		  this.shopTrendNoticesHtml = this.shopTrendNoticeSet.map( shopTrendNotice => {
			  switch(shopTrendNotice.shopTrendNoticeType) {
				  case "COMMODY_COMMENT":
					  return getCommodyCommentNoticeHtml(shopTrendNotice);
				  default:
					  console.log("错误，不匹配的shop通知类型")
					  break;
			  }
		  });
		  
		  this.shopTrendNoticePanel.html(this.shopTrendNoticesHtml);
		  this.shopTrendNoticeBadge.html(this.shopTrendNoticeSet.length?this.shopTrendNoticeSet.length:'');
	}
  }
  

