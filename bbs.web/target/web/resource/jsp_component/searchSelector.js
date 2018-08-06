$(document).ready(function () {
  class SearchSelector {
    constructor(toggleBtnId) {
      this.toggleBtn = $(toggleBtnId);
      this.status = {};
      this.formSubmitUrl = contextPath+'/search/forum/';
      
      let initStatus = {
    		  论坛: true,
    		  用户: false,
    		  商品: false,
      }
      this.modeMap = {
    		  论坛: contextPath+"/forum/search",
    		  用户: contextPath+"/usercenter/search",
    		  商品: contextPath+"/shop/commody/search",
      }
      
      this.initModeList(this.modeMap);
      this.bindClick(this.toggleBtn);
      this.initStatus();
    }
    
    initStatus() {
    	this.setStatus("论坛");  
    }
    
    setStatus(mode) {
    	console.log("改变搜索栏状态为：" + mode);
    	console.log(this);
    	this.status = {
    		  论坛: false,
    		  用户: false,
    		  商品: false,
    	}
    	this.status[mode] = true;
    	//改变显示
    	Object.entries(this.status).forEach( item => {
    		if (item[1]) {
    			let btnHtml = this.toggleBtn.html();
    			let result = btnHtml.replace(/[\u4e00-\u9fa5]+/, item[0]);
    			this.toggleBtn.html(result);
    			//改变表单提交目标
    			$("#select-searcher").attr("action", this.modeMap[item[0]]);
    		}
    	})
    }
    
    initModeList(modeMap) {
    	let modeList = Object.keys(modeMap); 
    	let template = (modeName, modeUrl) => `
			<li><a href="#">${modeName}</a></li>
    	`;
    	let ul = $(".search-selector-ul");
    	Object.entries(modeMap).forEach( item => {
    		ul.append(template(item[0], item[1]));
    	})
    }

    bindClick(targetElement) {
      let self = this;
      $("#" + targetElement.attr("id") + "+.dropdown-menu a").click(function (e) {
        let selectedValue = $(e.target).html();
        self.setStatus.bind(self)(selectedValue);
      })
    }
  };
  

  let searchSelect = new SearchSelector("#search-selector");
})
