    class CollectionBtn {
    	constructor(btn) {
    		this.collectBtn = btn;
    		this.realCollectBtn = $(btn.find(".commody-collect-btn"));
    		this.collected = this.realCollectBtn.hasClass("collected");
    		this.commodyId = this.collectBtn.data("commody-id");
    		this.collectBtn.click( e => {
    			if (!this.collected) {
    				this.collect();
    			}
    			else {
    				this.uncollect();
    			}
    		})
    	}
    	
    	setCollected(collected) {
    		this.collected = collected;
    		collected?
    				this.realCollectBtn.addClass("collected")
    				:this.realCollectBtn.removeClass("collected");
    	}
    	
    	collect() {
    		$.post({
				url: `${contextPath}/usercenter/collect/commody/${this.commodyId}`,
				success: res => {
					this.setCollected(true);
				}
			})	
    	}
    	
    	uncollect() {
    		$.ajax({
    			type: "DELETE",
				url: `${contextPath}/usercenter/collect/commody/${this.commodyId}`,
				success: res => {
					this.setCollected(false);
				}
			})	
    	}
    }
    $(".commody-collect-btn-wrap").each( (i, item) => {new CollectionBtn($(item))});
