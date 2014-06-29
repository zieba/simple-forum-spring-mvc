<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form action="newpost.html" method="post">

	<spring:bind path="post.text">
		<textarea name="${status.expression}" value="${status.value}" class="form-control" rows="10" placeholder="Twój post"></textarea>
		<br />
	</spring:bind>

	<input type="submit" value="Napisz" class="btn btn-lg btn-primary" />
</form>