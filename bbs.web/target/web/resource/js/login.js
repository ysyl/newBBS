$(function () {
  function getTemplate(title) {
    let template = `
                        <div class="post-item clearfix">
                          <a class="post-item-avatar" href="#"><img src="${avatar}" /></a>
                          <div class="post-item-content">
                            <h1><a class="nav-link" href="#">${title}</a></h1>
                            <p>
                              <a class="author" href="#">verrickt</a>
                              发起了问题 • 1 人关注 • 0 个回复 • 693 次浏览 • 2018-04-03 14:38
                            </p>
                          </div>
                        </div>
                        `;
    return template;
  }

  $("#main-content>.tab-panel").each(function (i, item) {
    let id = item.id;
    let content = new Array(10).fill(getTemplate(id));
    $(item).html(content);
  });

  $("#notice-menu .tab-panel").each(function (i, item) {
    let id = item.id;
    let content = new Array(5).fill(getTemplate(id));
    $(item).html(content);
  })

  //防止通知框点击就消失
  
})
