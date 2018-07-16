
<script type="text/javascript">
let connectUrl = "<c:url value="/stomp" />";
let subscribeTestBroad = "/topic/testBroad";
let sendToTestBroad = "/app/testBroad";
let subscribeTestSendToUser = "/user/topic/testSendToUser";
let sendToTestSendToUser = "/app/testSendToUser";
let subscribeTestTemplateSendToUser = "/user/verrickt/topic/testTemplateSendToUser";
let sendToTestTemplateSendToUser = "/app/testTemplateSendToUser";

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
        this.subscribeTestTemplateBroad.bind(this)();
        this.subscribeTestSendToUser.bind(this)();
        this.subscribeTestTemplateSendToUser.bind(this)();
        this.sendToTestBroad.bind(this)();
        this.sendToTestSendToUser.bind(this)();
        this.sendToTestTemplateSendToUser.bind(this)();
    }
    
    connectFailureCallback() {
       console.log("failure"); 
    }
    
    subscribeTestTemplateBroad() {
       this.client.subscribe(subscribeTestBroad, this.handleTestCallback.bind(this));
    }

    subscribeTestSendToUser() {
       this.client.subscribe(subscribeTestSendToUser, this.handleTestCallback.bind(this));
    }

    subscribeTestTemplateSendToUser() {
       this.client.subscribe(subscribeTestTemplateSendToUser, this.handleTestCallback.bind(this));
    }

    subscribeTestTemplateBroad() {
       this.client.subscribe(subscribeTestBroad, this.handleNotice.bind(this)) 
    }

    sendToTestBroad() {
        this.client.send(sendToTestBroad, this.handleTestCallback.bind(this));
    }

    sendToTestSendToUser() {
        this.client.send(sendToTestSendToUser, this.handleTestCallback.bind(this));
    }

    sendToTestTemplateSendToUser() {
        this.client.send(sendToTestTemplateSendToUser, this.handleTestCallback.bind(this));
    }
    
    sendToApp() {
        this.client.send(sendToTestBroad, this.handleTestCallback);
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


let noticePanel = new NoticePanel($("#notice-menu-content"));
</script>
