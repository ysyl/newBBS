$(document).ready(function () {
  class NoticePanel {
	  constructor(noticePanel, newNoticeRemindElement) {
		 this.noticePanel = noticePanel; 
		 this.newNoticeRemindElement = newNoticeRemindElement;
		 this.ws = null;
		 this.client = null;
		 this.connect(connectUrl);
	  }
	  
	  connect (connectUrl) {
		 this.ws = new SockJS(connectUrl); 
		 this.client = webstomp.over(this.ws);
		 this.client.connect({}, this.connectSuccessCallback.bind(this),
				 this.connectFailureCallback.bind(this));
	  }
	  
	  connectSuccessCallback() {
		  this.subscribeTrendNotice.bind(this)();
	  }
	  
	  connectFailureCallback() {
		 console.log("failure"); 
	  }
	  
	  subscribeTrendNotice() {
		 this.client.subscribe(subscribeTrendNoticeUrl, this.handleTrendNotice.bind(this)); 
	  }
	  
	  handleTrendNotice(message) {
		  console.log(message.body);
		  this.newNoticeRemindElement.html("[new]");
	  }
	  
	  DisplayTrendCountNotice(message) {
		  
	  }
  }
  
  let noticePanel = new NoticePanel($("#notice-menu-content"), $("#new-notice-remind"));
})
