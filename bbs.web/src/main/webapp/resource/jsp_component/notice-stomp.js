$(document).ready(function () {
  class NoticePanel {

	  constructor(noticePanelToggleBtn, noticePanel, newNoticeRemindElement, 
			  trendNoticeDisplayPanel) {
		 this.noticePanelToggleBtn = noticePanelToggleBtn;
		 this.noticePanel = noticePanel; 
		 this.trendNoticeDisplayPanel = trendNoticeDisplayPanel;
		 this.newNoticeRemindElement = newNoticeRemindElement;
		 this.ws = null;
		 this.client = null;
		 this.ajaxNotices = [];
		 this.wsNotices = [];
		 this.notices = [];
		 // 如果不是第一次打开，则不触发ajax，改成直接显示websocket推送的动作，并用stomp发送刷新订阅时间的请求
		 this.firstOpen = true;
		 this.noticeCount = 0;

		 //用于拼接通知
		 this.contextPath = null;
		 
		 this.init();
		 

	  }
	 
	  // 每次设置通知数量时，改变视图
	  setNoticeCount(noticeCount) {
		 this.noticeCount = noticeCount; 
		 this.displayNoticeCount();
	  }
	  
	  setAjaxNotices(ajaxNotices) {
		  this.ajaxNotices = ajaxNotices;
		  this.setNotices(this.ajaxNotices.concat(this.notices));
	  }
	  
	  addWsNotice(wsNotice) {
		  this.wsNotices.push(wsNotice);
		  this.setNotices(this.notices.concat(this.wsNotices.slice(this.wsNotices.length - 1)))
	  }
	  
	  setNotices(notices) {
		  this.notices = notices;
		  this.freshNoticesHtml();
	  }
	  
	  clearNotice() {
		  this.setNotices([]);
		  this.freshNoticeHtml();
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
		  this.addWsNotice(stompMessage);
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

	  
	  stompFreshLastReadTime() {
		  this.client.send(stompFreshLastReadTimeUrl, () => {});
	  }
	  
	  displayNoticeCount() {
		  this.newNoticeRemindElement.html(this.noticeCount);
	  }
	  
	  pullNotices() {
		 let self = this;
		 $.ajax({
			 url: pullNoticesUrl,
			 success: noticeResult => { 
				 this.setAjaxNotices(noticeResult.trend); 
				 this.contextPath = noticeResult.contextPath;
				 }, 
			 failure: e => { console.log(e.message) },
		 }) 
	  }
	  
	  freshNoticesHtml() {
		  let resultHtmls = this.notices.map((notice, index) => this.createAbstractNoticeTemplate(notice));
		 console.log(`ajaxNotices size: ${this.ajaxNotices.length}
				 wsNotices size: ${this.wsNotices.length}
				 resultHtmls size : ${resultHtmls.length}
		 `);
		  this.trendNoticeDisplayPanel.html(resultHtmls.reverse());
	  }
	  
	  
	  createAbstractNoticeTemplate(notice) {
		  let resultTemplate = '';
		 switch(notice.trendNoticeType) {
		 case "TopicTrendNotice":
			 resultTemplate = this.createTopicTrendNotice(notice); 
			 break;
		 case "PostTrendNotice":
			 resultTemplate = this.createPostTrendNotice(notice);
			 break;
		 case "UserTrendNotice":
			 resultTemplate = this.createUserTrendNotice(notice);
			 break;
		 } 
		 console.log("createAbstract: " + notice.trendNoticeType)
		 return resultTemplate;
	  }

	  createTopicTrendNotice(notice) {
		  console.log("notice topicTitle : "+notice.topicTitle);
		  let topicTrendNoticeTemplate = 
			  `
			  <div class="post-item clearfix">
	<div class="post-item-content">
		<p>
			  <a class="notice-topic-title"
					href="${this.contextPath}/topic/${notice.topicId }">
					${notice.topicTitle } </a>
				<span>收到了一条</span>
				<a href="/topic/${notice.topicId }">新回复</a>
				<span>${notice.pubTime }</span>
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
  if (isAuthenticated) {
	  let noticePanel = new NoticePanel($("#notice-panel-toggle"),$("#notice-menu-content"), $("#new-notice-remind"), $("#trend"));
  }
})
