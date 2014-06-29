<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Tematy</th>
			<th>Zarządzanie</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${topics}" var="topic">
			<tr>
				<td>
					<a href="<spring:url value="/topic/${topic.id}.html" />">${topic.name}</a>
				</td>
				<td>
					<a href="<spring:url value="/topic/remove/${topic.id}.html" />" class="btn btn-danger btn-sm">Usuń</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>