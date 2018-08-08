class PubCommodyCommentModal {
	constructor(modal, commodyId) {
		this.modal = modal;
		this.replyCommentId = null;
		this.replyUsername = null;
		// 回复类型有两种，用字符串表示，1：Primary, 2: Reply
		this.commentTypeList = ["Primary", "Reply"];
		// 提交回复需要使用id字段
		this.commodyId = commodyId;
		this.pubCommentUrlMap = {
				Primary: `${contextPath}/upload/commodycomment/primary/commody/${commodyId}` ,
				Reply: `${contextPath}/upload/commodycomment/reply/commody/${commodyId}`,
		}
		this.commentType = this.commentTypeList[0];
		
	}
	
	show() {
		this.modal.modal("show");
	}
	
	// 无论回复哪个，最后提交的都是reply-commody-comment,只有点击发表回复按键才能回复 primaryCommodyComment;
	setReply(replyCommentId, replyUsername, belongPrimaryCommentId) {
		this.replyCommentId = replyCommentId;
		this.replyUsername = replyUsername;
		console.log("回复归属的回复：" + belongPrimaryCommentId);
		//设置belongPrimaryCommentId字段
		$(this.modal.find("[name='belongPrimaryCommentId']")).attr("value", belongPrimaryCommentId);
		//设置replyCommentId字段
		$(this.modal.find("[name='replyTargetCommentId']")).attr("value", replyCommentId);
		
		this.toggleToReply();
	}
	
	toggleToReply()	{
		this.setCommentType(1);
		$(this.modal.find(".modal-title")).html(`发表评论，并回复${this.replyUsername}`);
	}
	
	toggleToPrimary() {
		this.setCommentType(0);
		$(this.modal.find(".modal-title")).html(`发表回复`);
		//设置belongPrimaryCommentId字段
		$(this.modal.find("[name='belongPrimaryCommentId']")).attr("value", null);
		//设置replyCommentId字段
		$(this.modal.find("[name='replyTargetCommentId']")).attr("value", null);
	}

	setCommentType(index) {
		this.commentType = this.commentTypeList[index];
		$(this.modal.find("#pub-commodycomment-form")).attr("action", this.pubCommentUrlMap[this.commentType]);
	}
	
	pubComment() {
		$.post({
			url: this.pubCommentUrlMap[this.commentType],
			success: res => {
			}
		})
	}
}

class CommentPanel  {
	constructor() {
		this.panel = $("#comment");
		this.toggleBtn = $("#comment_panel_toggle_btn");
		this.commentList = [];
		
		this.toggleBtn.click( e => {
			this.getComments();
		})
	}
	
	setCommentList(commentList) {
		this.commentList = commentList;
		this.showComment();
	}
	
	showComment() {
		let commentList = this.commentList;
		let primaryCommentTemplate = comment => replyCommentTemplateList => {
			let primaryTemplate = `
            <li class="primary-comment">
            <div class="primary-comment-wrap container-fluent row">
                <div class="primary-comment-user-info col-md-3">
                    <img class="user-avatar" src="${contextPath}/resource/img/${comment.user.avatar}" />
                    <h5 class="user-nickname">
                        <a href="${contextPath}/usercenter/user/${comment.user.id}">${comment.user.nickname}</a>
                    </h5>
                </div>
                <div class="primary-comment-content col-md-9">
                    <a href="javascript:void(0)" class="primary-comment-content-reply-btn"
                    	data-primary-comment-id="${comment.id}"
                    	data-username = "${comment.user.nickname}"
                    	>回复</a>
                    <p class="primary-comment-content">${comment.content}</p>
                </div>
            </div>
		`;	
		let primaryCommentTemplateSuffix = "</li>"; 
		  return primaryTemplate + replyCommentTemplateList + primaryCommentTemplateSuffix;
		}	
		
		let replyCommentTemplateList = (belongPrimaryComment, replyCommentList) => {
			  	let getReplyCommentTemplate = replyComment => `
	              <li class="reply-comment row">
			  	    <div class="reply-comment-user-info col-md-3">
                        <img class="user-avatar" src="${contextPath}/resource/img/${replyComment.user.avatar}" />
                        <h5 class="user-nickname">${replyComment.user.nickname}</h5>
                    </div>
                    <div class="reply-comment-content col-md-9">
			  			<a href="javascription:void(0)" class="reply-comment-content-reply-btn" 
			  				data-reply-comment-id="${replyComment.id}"
                    		data-username = "${replyComment.user.nickname}"
                    		data-belong-primary-comment-id = "${belongPrimaryComment.id}"
			  				>回复</a>
                        <p class="reply-comment-content">
                        	${replyComment.replyTargetComment?'回复 '+  replyComment.replyTargetComment.user.nickname + '：':""}
                        	${replyComment.content}
                        </p>
                    </div> 
                  </li>
			  	`;  
			  	let ulTemplatePrefix = `<ul class="reply-comment-list clearfix">`;
			  	let ulTemplateSuffix = `</ul>`;
			  	let resultTemplate = ulTemplatePrefix;
			  	for (var i = 0; i < replyCommentList.length; i++) {
			  	    let tempReplyCommentTemplate= getReplyCommentTemplate(replyCommentList[i]);
			  	   resultTemplate += tempReplyCommentTemplate;	
			  	}
			  	resultTemplate += ulTemplateSuffix;
			  	return resultTemplate;
		}
		
		// 把回复拼接到留言上
		let tempTemplate = commentList.map( 
				item => primaryCommentTemplate(item)(replyCommentTemplateList(item,item.replyComments)+"</li>")
				).join();
		$("#comment-list").html(tempTemplate);
		
		// 给回复按钮绑定事件
		this.handleReply();
	}  

		// 给回复按键绑定事件
	handleReply() {
			this.pubCommodyCommentModal = new PubCommodyCommentModal($("#pub-commodycomment-modal"), commodyId);
			let self = this;
			$(".pub-commodycomment-btn").click( e => {
				this.pubCommodyCommentModal.toggleToPrimary();
				this.pubCommodyCommentModal.show();
			})
			$(".primary-comment-content-reply-btn").each( (index, elem) => {
				console.log("绑定回复按键");
				$(elem).click( e => { 
					// 设置modal的回复信息
					e.preventDefault();
					let replyCommentId = $(e.target).data("primary-comment-id");
					let replyUsername = $(e.target).data("username");
					self.pubCommodyCommentModal.setReply(replyCommentId, replyUsername, replyCommentId);
					self.pubCommodyCommentModal.show();
				})
			});
			$(".reply-comment-content-reply-btn").each( (index,elem) => {
				console.log("绑定reply的回复按键");
				$(elem).click( e => { 
					// 设置modal的回复信息
					e.preventDefault();
					let replyCommentId = $(e.target).data("reply-comment-id");
					let replyUsername = $(e.target).data("username");
					let belongPrimaryCommentId = $(e.target).data("belong-primary-comment-id");
					 
					console.log("belongPrimaryCommentId " + belongPrimaryCommentId);
					this.pubCommodyCommentModal.setReply(replyCommentId, replyUsername, belongPrimaryCommentId);
					this.pubCommodyCommentModal.show();
				})
			});
		}
	getComments() {
		let self = this;
		$.get({
			url: `${contextPath}/shop/commodycomment/${commodyId}`,
		    success: function(data) {
		    	self.setCommentList(data);
		    }
		});	
	}
}

