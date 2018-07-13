<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form id="pub-topic-form" action="<c:url value="/upload/topic/${forum.id }"  />"method="post"  accept-charset="utf-8">
<div class="editor-panel panel panel-default">
	<div class="panel-heading clearfix pub-topic-form-heading">
		<h4 id="pub-topic-form-header">发帖</h4>
		<div class="input-group">
		<span class="input-group-addon">标题</span>
		<input class="form-control" type="text" name="title" id="pub-topic-title-input" />
		<span class="input-group-btn">
            <button class=" btn btn-primary " id="submitTopic" type="submit" name="submit">提交</button>
		</span>
    </div>
	</div>
	<div class="panel-body" >
		<div id="editormd">
			<textarea style="display: none;">### Hello Editor.md !</textarea>
		</div>
		</p>
	</div>
</div>
</form>