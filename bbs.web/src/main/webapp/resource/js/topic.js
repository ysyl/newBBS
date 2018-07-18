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
			this.followBtn = this.postListItem.find(".follow-btn");
			
			this.bindCollectEventToBtn();
			this.bindReplyEventToBtn();
			this.bindFollowEventToBtn();
			
			this.isCollected = false;
			this.isFollowed = false;
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
