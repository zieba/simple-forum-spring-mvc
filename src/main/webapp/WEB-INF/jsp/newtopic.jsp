<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form action="newtopic.html" method="post">

	<spring:bind path="topic.name">
		<input type="text" name="${status.expression}" value="${status.value}" class="form-control" placeholder="Nazwa tematu">
		<br />
	</spring:bind>

	<spring:bind path="post.text">
		<textarea name="${status.expression}" value="${status.value}" class="form-control" rows="10" placeholder="Twój post"></textarea>
		<br />
	</spring:bind>

	<input type="submit" value="Utwórz" class="btn btn-lg btn-primary" />
</form>