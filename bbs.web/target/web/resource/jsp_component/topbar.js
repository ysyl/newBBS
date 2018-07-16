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
	  
	  
	  handleTestCallback(message) {
		 console.log(message.body); 
	  }

	  
	  handleNotice(message) {
		 let noticeList = JSON.parse(message.body); 
		 console.log(noticeList.length);
	  }
	  
	  handleTrendCountNotice(message) {
		  
	  }
  }
  

  let searchSelect = new SearchSelector("#search-selector");
  let noticePanel = new NoticePanel($("#notice-menu-content"));
})
