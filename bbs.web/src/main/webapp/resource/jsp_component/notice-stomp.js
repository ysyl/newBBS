$(document).ready(function () {
  class NoticePanel {
	  constructor(noticePanel) {
		 this.noticePanel = noticePanel; 
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
	  }
	  
	  connectFailureCallback() {
		 console.log("failure"); 
	  }
	  
	  handleTrendNotice(message) {
		  console.log(message.body);
	  }
	  
	  DisplayTrendCountNotice(message) {
		  
	  }
  }
})
