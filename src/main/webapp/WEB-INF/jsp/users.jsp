<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<script type="text/javascript">
$(document).ready(function() {
	$('.triggerRemove').click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});
</script>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Użytkownicy</th>
			<th>Zarządzanie</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<a href="<spring:url value="/users/${user.id}.html" />">${user.name}</a>
				</td>
				<td>
					<a href="<spring:url value="/user/remove/${user.id}.html" />" class="btn btn-danger btn-sm triggerRemove">Usuń</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Zamknij</span></button>
        <h4 class="modal-title" id="myModalLabel">Usuń użytkownika</h4>
      </div>
      <div class="modal-body">
        Na pewno chcesz usunąć tego użytkownika? 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
        <a href="" class="btn btn-danger removeBtn">Usuń</a>
      </div>
    </div>
  </div>
</div>
