<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>


<h1>${topic.name}</h1>

	<!-- Button trigger modal -->
<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Dodaj odpowiedź
</button>

<form:form commandName="post" cssClass="form-horizontal">


<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel">Napisz nowy post</h4>
      </div>
      <div class="modal-body">
      
      <div class="form-group">
		<label for="name" class="col-sm-2 control-label">Twój post:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" />
		</div>
	</div>
     <div class="form-group">
		<div class="col-sm-2">
			
		</div>
	</div> 
      
      
      
      
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" value="Napisz" class="btn btn-lg btn-primary" />
      </div>
    </div>
  </div>
</div>
</form:form>

<br /><br />

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