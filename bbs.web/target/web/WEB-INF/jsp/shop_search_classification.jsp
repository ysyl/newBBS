<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>Bootstrap 101 Template</title>

<!-- Bootstrap -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<c:url value="/resource/css/common.css" />" rel="stylesheet" />
<link href="<c:url value="/resource/css/usercenter.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/jsp_component/topbar.css" />"
	rel="stylesheet" />
<link
	href="<c:url value="/resource/jsp_component/announce-broad.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_common.css" />"
	rel="stylesheet" />
<link href="<c:url value="/resource/css/shop_index.css" />"
	rel="stylesheet" />
<!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
<!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<%@ include file="/resource/jsp_component/topbar.jsp"%>
	<%@ include file="/resource/jsp_component/shop-top-bar.jsp"%>

	<div class="shop-search-body-wrap">
    <div class="crumb-container container">
       <ol class="breadcrumb">
         <span class="crumb-prefix">个人闲置：</span>
         <li><a href="#">全部</a></li>
         <li>游戏</li>
       </ol>
    </div>
    <div class="catelog-filter-wrap container">
      <div class="catelog-filter">
        <div class="row">
          <div class="catalog-tag col-md-3">
            <a href="#">动作冒险（12）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">角色扮演（43）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">第三人称射击（214）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">第一人称射击（2515）</a>
          </div>
        </div>
        <div class="row">
          <div class="catalog-tag col-md-3">
            <a href="#">动作冒险（12）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">角色扮演（43）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">第三人称射击（214）</a>
          </div>
          <div class="catalog-tag col-md-3">
            <a href="#">第一人称射击（2515）</a>
          </div>
        </div>
      </div>
    </div>

    <div class="search-filter-container container clearfix">
      <span class="search-keywords">动作游戏</span>
      <span class="search-filter-tool ">
        <div class="btn-group">
          <button class="btn btn-default" type="button">最新发布</button>
          <button class="price-btn active asc btn btn-default" type="button">价格
            <span class="glyphicon glyphicon-chevron-up"></span>
            <span class="glyphicon glyphicon-chevron-down"></span>
          </button>
        </div>
      </span>
    </div>

    <div class="search-result-list-wrap container">
      <ul class="search-result-list">
        <li class="result-list-item clearfix">
          <div class="commody-info">
            <img src="default-commody.jpg" />
            <h4 class="commody-info-title"><a href="#">商品标题</a></h4>
            <p class="commody-info-price">￥<span class="price-num">555</span></p>
            <p class="commody-info-description">超薄咪洁纸尿片免费送！咪洁羽丝柔护纸尿片，超柔超薄，L码（9−14公斤），58片一包，拆封了只用过几片，当时买60多，不嫌弃的宝妈可领走描述</p>
            <p class="commody-info-pub-time">1分钟前</p>
          </div>
          <div class="user-info">
            <img src="avatar.png" />
            <div class="pull-left">
            <h5 class="user-nickname">
              <a href="#">用户名</a>
              <a href="#"><span class="glyphicon glyphicon-comment"></span></a>
            </h5>
            <p class="user-location">江苏南京</p>
            </div>
          </div>
          <a class="more-commody" href="#">该卖家的商品</a>
        </li>

        <li class="result-list-item clearfix">
          <div class="commody-info">
            <img src="default-commody.jpg" />
            <h4 class="commody-info-title"><a href="#">商品标题</a></h4>
            <p class="commody-info-price">￥<span class="price-num">555</span></p>
            <p class="commody-info-description">超薄咪洁纸尿片免费送！咪洁羽丝柔护纸尿片，超柔超薄，L码（9−14公斤），58片一包，拆封了只用过几片，当时买60多，不嫌弃的宝妈可领走描述</p>
            <p class="commody-info-pub-time">1分钟前</p>
          </div>
          <div class="user-info">
            <img src="avatar.png" />
            <div class="pull-left">
            <h5 class="user-nickname">
              <a href="#">用户名</a>
              <a href="#"><span class="glyphicon glyphicon-comment"></span></a>
            </h5>
            <p class="user-location">江苏南京</p>
            </div>
          </div>
          <a class="more-commody" href="#">该卖家的商品</a>
        </li>

        <li class="result-list-item clearfix">
          <div class="commody-info">
            <img src="default-commody.jpg" />
            <h4 class="commody-info-title"><a href="#">商品标题</a></h4>
            <p class="commody-info-price">￥<span class="price-num">555</span></p>
            <p class="commody-info-description">超薄咪洁纸尿片免费送！咪洁羽丝柔护纸尿片，超柔超薄，L码（9−14公斤），58片一包，拆封了只用过几片，当时买60多，不嫌弃的宝妈可领走描述</p>
            <p class="commody-info-pub-time">1分钟前</p>
          </div>
          <div class="user-info">
            <img src="avatar.png" />
            <div class="pull-left">
            <h5 class="user-nickname">
              <a href="#">用户名</a>
              <a href="#"><span class="glyphicon glyphicon-comment"></span></a>
            </h5>
            <p class="user-location">江苏南京</p>
            </div>
          </div>
          <a class="more-commody" href="#">该卖家的商品</a>
        </li>

      </ul>
    </div>
    </div>

	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
	<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
	<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
	<script
		src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="<c:url value="/resource/js/forum.js" />"></script>
	<script src="<c:url value="/resource/jsp_component/topbar.js" />"></script>
	<script src="<c:url value="/resource/js/usercenter.js" />"></script>
</body>
</html>