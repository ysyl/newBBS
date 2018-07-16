$(document).ready(function () {
  class SearchSelector {
    constructor(toggleBtnId) {
      this.toggleBtn = $(toggleBtnId);
      this.bindChangeValue(this.toggleBtn);
    }

    bindChangeValue(targetElement) {
      $("#" + targetElement.attr("id") + "+.dropdown-menu a").click(function (e) {
        let btnHtml = targetElement.html();
        let selectedValue = $(e.target).html();
        let result = btnHtml.replace(/[\u4e00-\u9fa5]+/, selectedValue);
        targetElement.html(result);
      })
    }
  };
  

  let searchSelect = new SearchSelector("#search-selector");
})
