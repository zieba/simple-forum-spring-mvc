<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h1>${topic.name}</h1>

<strong><a href="<spring:url value="/newpost.html?id=${topic.id}" />" class="btn btn-info">Odpowiedz</a></strong>



<br /><br />

<table class="table table-bordered table-striped">
	<tbody>
		<c:forEach items="${topic.posts}" var="post">
			<tr>
				<td>
					<strong>${post.user.name}</strong>
					<p>Post dodany:</p>
					<p>${post.publishedDate}</p>
					<br />
					<a href="<spring:url value="/post/remove/${post.id}.html" />" class="btn btn-danger btn-sm">Usuń post</a>
				
				</td>
				<td><p>${post.text}</p></td>
			</tr>
		</c:forEach>
	</tbody>

</table>