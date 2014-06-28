<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h1>${topic.name}</h1>

<table class="table table-bordered table-striped">
	<tbody>
		<c:forEach items="${topic.posts}" var="post">
			<tr>
				<td>
					<strong>${post.user.name}</strong>
					<p>${post.publishedDate}</p>
				
				</td>
				<td><p>${post.text}</p></td>
			</tr>
		</c:forEach>
	</tbody>

</table>