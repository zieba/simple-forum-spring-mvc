<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<form action="newpost.html" method="post">

	<spring:bind path="post.text">
		<textarea name="${status.expression}" value="${status.value}" class="form-control" rows="10" placeholder="Twój post"></textarea>
		<form:errors path="text" />
		<br />
	</spring:bind>
	<p>Twój post musi mieć minimum 10 znaków.</p>
	<input type="submit" value="Napisz" class="btn btn-lg btn-primary" />
</form>
