  class NoticePanel {

	  constructor(noticePanelToggleBtn, noticePanel, newNoticeRemindElement, 
			  trendNoticeDisplayPanel) {
		 this.noticePanelToggleBtn = noticePanelToggleBtn;
		 this.noticePanel = noticePanel; 
		 this.trendNoticeDisplayPanel = trendNoticeDisplayPanel;
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
		 
		 // 如果不是第一次打开，则不触发ajax，改成直接显示websocket推送的动作，并用stomp发送刷新订阅时间的请求
		 this.firstOpen = true;
		 this.noticeCount = 0;

		 // 用于拼接通知
		 this.contextPath = null;
		 
		 this.init();
		 

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
		  this.freshForumTrendNoticeHtml();
		  this.freshShopTrendNoticeHtml();
		  this.freshUserTrendNoticeHtml();
		  this.freshBeFollowedNoticeHtml();
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
	  
	  handleClick() {
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
	  
	  freshForumTrendNotice() {
		  
	  }

	  createTopicTrendNotice(notice) {
		  console.log("notice topicTitle : "+notice.topicTitle);
		  let topicTrendNoticeTemplate = 
			  `
			  <div class="post-item clearfix">
                          <a class="post-item-avatar" href="${contextPath}/${}"><img src="./avatar.png"></a>
                          <div class="post-item-content">
                            <h1><a class="nav-link" href="#">trend</a></h1>
                            <p>
                              <a class="author" href="#">verrickt</a>
                              发起了问题 • 1 人关注 • 0 个回复 • 693 次浏览 • 2018-04-03 14:38
                            </p>
                          </div>
              </div>
				`;
		  return topicTrendNoticeTemplate;
	  }
	  
	  createPostTrendNotice(notice) {
		  let postTrendNoticeTemplate = `
		  <div class="post-item clearfix">
	<div class="post-item-content">
		<p>
		  <a class="notice-post-digest"
					href="/topic/${notice.topicId }">${notice.postDigest }</a>
				<span>收到了一条</span>
				<a href="/topic/${notice.topicId }">新回复</a>
		</p>
	</div>
</div>
		  `;
		  return postTrendNoticeTemplate;
	  }
	  
	  createUserTrendNotice(notice) {
		  let userTrendNoticeTemplate = `
		  <div class="post-item clearfix">
	<div class="post-item-content">
		<p>
		  <a class="author" href="#">isUserTrendNotice</a>
				<span>${notice.pubTime }</span>
				<span>${notice.actionType }</span>
				<span>${notice.targetType }</span>
				<a href="">${notice.targetDigest }</a>
				<span>${notice.pubTime }</span>
		</p>
	</div>
</div>
		  `;
		  return userTrendNoticeTemplate;
	  }
  }
  

