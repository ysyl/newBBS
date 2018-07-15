$(document).ready(function () {
  class SearchSelector {
    constructor(toggleBtnId) {
      this.toggleBtn = $(toggleBtnId);
      this.bindChangeValue(this.toggleBtn);
    }

    bindChangeValue(targetElement) {
      $("#" + targetElement.attr("id") + "+.dropdown-menu a").click(function (e) {
        let btnHtml = targetElement.html();
        let selectedValue = $(e.target).html();
        let result = btnHtml.replace(/[\u4e00-\u9fa5]+/, selectedValue);
        targetElement.html(result);
      })
    }
  };
  
  class NoticePanel {
	  constructor(noticePanel) {
		 this.noticePanel = noticePanel; 
		 this.ws = null;
		 this.client = null;
		 connect(connectUrl);
	  }
	  
	  connect (connectUrl) {
		 this.ws = new SockJS(connectUrl); 
		 this.client = Stomp.over(this.ws);
		 this.client.connect({}, this.connectSuccessCallback.bind(this),
				 this.connectFailureCallback.bind(this));
	  }
	  
	  connectSuccessCallback() {
		 console.log("success"); 
		 this.subscribeNotice(subscribeNoticeUrl);
	  }
	  
	  connectFailureCallback() {
		 console.log("failure"); 
	  }

	  subscribeNotice(subscribeNoticeUrl) {
		 this.client.subscribe(subscribeNoticeUrl, handleNotice.bind(this)) 
	  }
	  
	  subscribeNotice(message) {
		 let noticeList = JSON.parse(message.body); 
		 console.log(noticeList.length);
	  }
	  
	  handleTrendCountNotice(message) {
		  
	  }
  }
  

  let searchSelect = new SearchSelector("#search-selector");
  let noticePanel = new NoticePanel($("#notice-menu-content"));
})
