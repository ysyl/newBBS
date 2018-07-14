	class BbsPostForm {
		constructor(pubPostFormId) {
			this.form = $(`#${pubPostFormId}`);
			this.header = this.form.find("#pub-post-form-header");
		}
		
		reply(nickname, postId) {
			$(this.form).find("#reply-post-input").attr("value", postId);
			this.header.html("replyTo: " + nickname);
		}
	}
	
	class PostListItem {
		constructor(postListItemElement, bbsPostForm) {
			this.postListItem = postListItemElement;
			this.bbsPostForm = bbsPostForm;
			this.collectBtn = this.postListItem.find(".collect-btn");
			this.replyBtn = this.postListItem.find(".reply-btn");
			
			this.bindCollectEventToBtn(this.collectBtn);
			this.bindReplyEventToBtn(this.replyBtn);
		}
		
		bindCollectEventToBtn(collectBtn) {
			collectBtn.click(this.collect.bind(this));
		}
		
		bindReplyEventToBtn(replyBtn) {
			replyBtn.click(this.reply.bind(this));
		}
		
		reply(e) {
				let authorNickname = $(e.target).data("post-author-name");
				let postId = $(e.target).data("post-id");
				this.bbsPostForm.reply.bind(this.bbsPostForm)(authorNickname, postId)
		}
		
		collect(e) {
			let postId = $(e.target).data("post-id");
			let isCollected = $(this.collectBtn).hasClass("collected");
			let method = "";
			if (!isCollected) {
				method = "post";
			}
			else {
				method="delete";
			}
			let self = this;
			$.ajax({
				type: method,
				url: collectPostUrl + postId, 
				success() {
					switch(method){
					case "post":
						self.activeCollect();
						break;
					case "delete":
						self.unactiveCollect();
						break;
					default:break;
					}
				}
			});
		}
		
		activeCollect() {
			this.collectBtn.addClass("collected");
		}
		
		unactiveCollect() {
			this.collectBtn.removeClass("collected");
		}
		
	}
	
	class CollectTopicBtn {
		constructor(btnElement) {
			this.btn = btnElement;
			this.bindCollectToBtn(this.btn);
		}
		
		bindCollectToBtn(btn) {
			btn.click(this.toggleCollect.bind(this));
		}
		
		toggleCollect(e) {
			let topicId = $(e.target).data("topic-id");
			let isCollected = $(e.target).hasClass("collected");
			let method = "";
			if (isCollected) {
				method = "delete";
			}
			else {
				method = "post";
			}
			let self = this;
			
			$.ajax({
				type: method,
				url: collectTopicUrl + topicId,
				success: function() {
					if(isCollected) {
						self.aciveCollect();
					}
					else {
						self.unactiveCollect();
					}
				}
			})
		}
	
		activeCollect(){
			this.btn.addClass("collected");
		}
		unactiveCollect(){
			this.btn.removeClass("collected");
		}
	}
	
	let bbsEditor = new BbsPostForm("pub-post-form");
	let postList = new Array();
	$(".post-list-item").each( (i, item) => {
		postList.push(new PostListItem($(item), bbsEditor));
	});
	let collectTopicBtn = new CollectTopicBtn($("#collect-topic-btn"));
