<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>User Edition</title>

	<%@ include  file="common/_css.jsp" %>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">



  <!-- Content Wrapper. Contains page content -->
  <div class=" py-2">
    <!-- Content Header (Page header) -->
   

		     
		
           
            <form action="">
            	<p>id: <input name="id" value="${id}"></p>
            	<p>name : <input name="name" value="${name}"> </p>
            	<hr>
            	<button formaction="danhMuc/add" class="btn btn-primary">Add</button>
            	<button formaction="danhMuc/edit" class="btn btn-primary">Edit</button>
            	<button formaction="danhMuc/delete" class="btn btn-primary">Xoa</button>
            	<button type="reset" class="btn btn-primary">Reset</button>            	
            	<p>${message}</p>
            </form>
            <div class="card">
              <!-- /.card-header -->
              <div class="card-body">
                <table id="tableUserRemove" class="table table-bordered table-striped">
                  <thead>
	                  <tr>
	                    <th>id</th>
	                    <th>name</th>
	                    <th>desc</th>
	                    <th>Delete?</th>
	                    <th>Edit?</th>
	                  </tr>
                  </thead>
                  <tbody>
                 	<c:forEach items="${listDanhMuc}" var="item">
                 		<tr>
		                    <td>${item.id}</td>
		                     <td>${item.name}</td>
		                     <td>${item.mota}</td>
		                    <td>
		                    <a type="button" class="btn btn-block bg-gradient-danger" href="danhMuc/delete?id=${item.id}">Delete</a>

		                    </td>
		                    <td>
		                    <a type="button" class="btn btn-block bg-gradient-danger" href="writeForm?id=${item.id}">Edit</a>
		                    	
		                    </td>
		                </tr>
	                 </c:forEach>
                  
                  </tbody>
                  <tfoot>
                   <tr>
	                    <th>id</th>
	                    <th>name</th>
	                    <th>desc</th>
	                    <th>Delete?</th>
	                    <th>Edit?</th>
	                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
        </div>
      </div>
           
<%@ include file="common/_js.jsp" %>
</body>
</html>
	