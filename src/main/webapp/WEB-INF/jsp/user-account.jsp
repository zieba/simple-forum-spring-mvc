<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>


<strong><p>Wszystkie Twoje posty:</p></strong>


<table class="table table-bordered table-striped">
		<c:forEach items="${user.posts}" var="post">
			<tr>
				<td><strong>
					<a href="<spring:url value="/topic/${post.topic.id}.html" />"><c:out value="${post.topic.name}" /></a>
				</strong></td>
			</tr>
			<tr>
				<td><p><c:out value="${post.text}" /></p></td>
			</tr>
		</c:forEach>
</table>