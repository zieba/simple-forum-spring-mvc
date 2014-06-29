<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Tematy</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${topics}" var="topic">
			<tr>
				<td>
					<a href="<spring:url value="/topic/${topic.id}.html" />">${topic.name}</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>