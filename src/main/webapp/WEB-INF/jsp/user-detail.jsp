<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h1>${user.name}</h1>

<p>20 ostatnich postów</p>




<table class="table table-bordered table-striped">
	<tbody>
		<c:forEach items="${user.posts}" var="post">
			<tr>
				<td><h1>${post.topic.name}</h1></td>
			</tr>
			<tr>
				<td><p>${post.text}</p></td>
			</tr>
		</c:forEach>
	</tbody>

</table>