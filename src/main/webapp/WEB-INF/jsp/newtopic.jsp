<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form action="newtopic.html" method="post">

	<spring:bind path="topic.name">
		<input type="text" name="${status.expression}" value="${status.value}">
		<br />
	</spring:bind>

	<spring:bind path="post.text">
		<input type="text" name="${status.expression}" value="${status.value}">
		<br />
	</spring:bind>

	<input type="submit" value="Create" />
</form>