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
					<a href="<spring:url value="/post/remove/${post.id}.html" />" class="btn btn-danger btn-sm triggerRemove">Usuń post</a>
				
				</td>
				<td><p>${post.text}</p></td>
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
        <h4 class="modal-title" id="myModalLabel">Usuń post</h4>
      </div>
      <div class="modal-body">
        Czy na pewno chcesz usunąć ten post? 
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Anuluj</button>
        <a href="" class="btn btn-danger removeBtn">Usuń</a>
      </div>
    </div>
  </div>
</div>