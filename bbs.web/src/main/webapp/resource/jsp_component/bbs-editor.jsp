<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form action="<c:url value="/upload/post/${topic.id }"  />"method="post"  accept-charset="utf-8">
<div class="editor-panel panel panel-default">
	<div class="panel-heading clearfix pub-post-form-heading">
		<h4>回复</h4>
    <button class="btn btn-primary " id="submitPost" type="submit" name="submit">提交</button>
	</div>
	<div class="panel-body">
		<div id="editormd">
			<textarea style="display: none;">### Hello Editor.md !</textarea>
		</div>
		</p>
	</div>
</div>
</form>