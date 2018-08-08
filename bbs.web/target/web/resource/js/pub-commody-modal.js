    class CollectionBtn {
    	constructor(btn) {
    		this.collectBtn = btn;
    		this.collectBtn.click( e => {
    			console.log("点击收藏");
    			let commodyId = this.collectBtn.data('commody-id');
    			$.post({
    				url: `${contextPath}/usercenter/collect/commody/${commodyId}`,
    				success: res => {
    					console.log(res);
    				}
    			})
    		})
    	}
    }
    $(".commody-collect-btn-wrap").each( (i, item) => {new CollectionBtn($(item))});
