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
			let self = this;
			$.ajax({
				url: collectPostUrl + postId, 
				success() {
					self.activeCollect();
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
	
	let bbsEditor = new BbsPostForm("pub-post-form");
	let postList = new Array();
	$(".post-list-item").each( (i, item) => {
		postList.push(new PostListItem($(item), bbsEditor));
	});
