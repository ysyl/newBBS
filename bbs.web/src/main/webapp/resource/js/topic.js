$(document).ready(function() {
	class BbsPostForm {
		constructor(pubPostFormId) {
			this.form = $(`#${pubPostFormId}`);
			this.header = $("#pub-post-form-header");
			this.subBtn = $("#submitPost");
			this.replyPostId = null;
			this.form.submit(this.changePostName.bind(this));
		}
		
		reply(nickname, postId) {
			this.replyPostId = postId;
			$("#reply-post-input").val(postId);
			this.header.html("回复: " + nickname);
		}
		
		changePostName(e) {
			$("[name=editormd-html-code]").attr("name", "htmlContent");
			console.log(this.replyPostId)
		}
		
		submitPost(e) {
			let content = $("textarea[name='editormd-markdown-doc']").val();
			let htmlContent = $("textarea[name='editormd-html-code']").val();
			let replyPostId = this.replyPostId;
			let postData = {
					content,
					htmlContent,
					replyPostId,
			}
			$.ajax({
				type: "POST",
				url: pubPostUrl,
				data: postData,
				dataType:"json",
			})
		}
	}
	
	class PostListItem {
		constructor(postListItemElement, bbsPostForm) {
			this.postListItem = postListItemElement;
			this.bbsPostForm = bbsPostForm;
			this.collectBtn = this.postListItem.find(".collect-btn");
			this.replyBtn = this.postListItem.find(".reply-btn");
			this.followBtn = this.postListItem.find(".follow-btn");
			
			this.bindCollectEventToBtn();
			this.bindReplyEventToBtn();
			this.bindFollowEventToBtn();
			
			this.isCollected = this.collectBtn.hasClass("collected");
			this.isFollowed = this.followBtn.hasClass("followed");
		}
		
		setCollected(isCollected) {
			this.isCollected = isCollected;
			if (isCollected){
				$(this.collectBtn).addClass("collected");
			}
			else {
				$(this.collectBtn).removeClass("collected");
			}
		}
		
		setFollowed(isFollowed) {
			this.isFollowed = isFollowed;
			if (isFollowed) {
				$(this.followBtn).addClass("followed");
			}
			else {
				$(this.followBtn).removeClass("followed");
			}
		}
		
		bindCollectEventToBtn() {
			this.collectBtn.click(this.collect.bind(this));
		}
		
		bindReplyEventToBtn() {
			this.replyBtn.click(this.reply.bind(this));
		}
		
		bindFollowEventToBtn() {
			this.followBtn.click(this.follow.bind(this));
		}
		
		reply(e) {
				let authorNickname = $(e.target).data("post-author-name");
				let postId = $(e.target).data("post-id");
				this.bbsPostForm.reply.bind(this.bbsPostForm)(authorNickname, postId)
		}
		
		collect(e) {
			let postId = $(e.target).data("post-id");
			let method = "";
			if (!this.isCollected) {
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
						self.setCollected(true);
						break;
					case "delete":
						self.setCollected(false);
						break;
					default:break;
					}
				}
			});
		}
		
		follow(e) {
			let followingId = $(e.target).data("user-id");
			let method = "";
			if (!this.isFollowed) {
				method = "post";
			}
			else {
				method = "delete";
			}
			let self = this;
			$.ajax({
				type: method,
				url : followUserUrl + followingId,
				success() {
					switch(method) {
					case "post":
						self.setFollowed(true);
						break;
					case "delete":
						self.setFollowed(false);
						break;
					default:break;
					}
				}
			})
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
					if(!isCollected) {
						self.activeCollect();
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
})