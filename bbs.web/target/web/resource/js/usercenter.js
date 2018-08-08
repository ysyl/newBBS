    class AvatarInput {
      constructor(fileInput, fileNameDisplay, fileBtn, avatarDisplay) {
        this.fileInput = fileInput;
        this.fileNameDisplay = fileNameDisplay;
        this.fileBtn = fileBtn;
        this.avatarDisplay = avatarDisplay;
        this.fileBtn.click(this.clickBtn.bind(this));
        this.fileInput.change(this.displayFileNameAndImg.bind(this))
      }
      clickBtn(e) {
        this.fileInput.click();
      }
      displayFileNameAndImg(e) {
        let file = e.target.files[0];
        let fileName = file.name;
        let fileUrl = window.URL.createObjectURL(file);
        this.displayFileName(fileName);
        this.displayImage(fileUrl);
      }
      displayFileName(fileName) {
        this.fileNameDisplay.attr("value",fileName);
      }
      displayImage(src) {
        this.avatarDisplay.attr("src", src)
      }
    }
    new AvatarInput($("#file-input"), $("#file-name-display"),  $("#file-btn"), $("#avatar-display"));

    class UserCenterPanel {
    	constructor(activePanel, activeCollectionPanel) {
    		this.status = {
    			topic: false,
    			userBroad: false,
    			collection: false,
    			userProfile: false,
    			editUserProfile: false,
    		}
    		this.collectionPanelStatus = {
    				topicCollection : false,
    				postCollection : false,
    				userCollection : false,
    				commodyCollection : false,
    		}
    		this.panelList = Object.keys(this.status);
    		this.panelNavList = {
    				topic: $("a[href='#user-topic']").parent("li"),
    				userBroad: $("a[href='#user-broad']").parent("li"),
    				collection: $("a[href='#collection']").parent("li"),
    				userProfile: $("a[href='#user-profile']").parent("li"),
    				editUserProfile: $("a[href='#edit-user-profile']").parent("li"),
    		}
    		this.panelTabPanelList = {
    				topic: $("#user-topic"),
    				userBroad: $("#user-broad"),
    				collection: $("#collection"),
    				userProfile: $("#user-profile"),
    				editUserProfile: $("#edit-user-profile"),
    		}
    		this.collectionNavList = {
    				topicCollection : $("a[href='#topic-collection']").parent("li"),
    				postCollection : $("a[href='#post-collection']").parent("li"),
    				userCollection : $("a[href='#user-collection']").parent("li"),
    				commodyCollection : $("a[href='#commody-collection']").parent("li"),
    		}
    		this.collectionTabPanelList = {
    				topicCollection : $("#topic-collection"),
    				postCollection : $("#post-collection"),
    				userCollection : $("#user-collection"),
    				commodyCollection : $("#commody-collection"),
    		}
    		
    		this.setActivePanel(activePanel, activeCollectionPanel);
    	}
    	
    	setActivePanel(activePanel, activeCollectionSubPanel) {
    		//此处应该加入验证，如果是不存在的panel则抛出错误
    		console.log("激活panel: " + activePanel + "激活收藏：" + activeCollectionSubPanel);
    		this.status = {
        			topic: false,
        			userBroad: false,
        			collection: false,
        			userProfile: false,
        			editUserProfile: false,
    		}
    		this.status[activePanel] = true;
    		Object.values(this.panelNavList).forEach( item => {
    			item.removeClass("active");
    		})
    		Object.values(this.panelTabPanelList).forEach( tabPanel => {
    			tabPanel.removeClass("active");
    		})
    		this.panelNavList[activePanel].addClass("active");
    		this.panelTabPanelList[activePanel].addClass("active");
    		
    		if (activePanel === "collection") {
    			if (activeCollectionSubPanel) {
    				this.collectionPanelStatus = {
    	    				topicCollection : false,
    	    				postCollection : false,
    	    				userCollection : false,
    	    				commodyCollection : false,
    				}
    				this.collectionPanelStatus[activeCollectionSubPanel] = true;
    				Object.values(this.collectionNavList).forEach( item => {item.removeClass("active")});
    				this.collectionNavList[activeCollectionSubPanel].addClass("active");
    				Object.values(this.collectionTabPanelList).forEach( item => {item.removeClass("active")});
    				this.collectionTabPanelList[activeCollectionSubPanel].addClass("active");
    			}
    		}
    	}
    }
    
    let userCenterPanel = new UserCenterPanel(activePanel, activeCollectionPanel);
