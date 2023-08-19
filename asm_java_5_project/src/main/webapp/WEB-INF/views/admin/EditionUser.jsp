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


  <%@ include file="common/_slideBar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">User Edition</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
	  <div class="container-fluid">
	    <!-- Small boxes (Stat box) -->
	    <div class="row">
	      <div class="col-lg-3 col-6">
	        <!-- small box -->
	        <div class="small-box bg-info">
	          <div class="inner">
	            <h3>${listUser.size()}</h3>
	
	            <p>User</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-bag"></i>
	          </div>
	        </div>
	      </div>
	      <!-- ./col -->
	      <div class="col-lg-3 col-6">
	        <!-- small box -->
	        <div class="small-box bg-success">
	          <div class="inner">
	            <h3>${listUserAdmin.size()}</h3>
	            <p>Admin</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-stats-bars"></i>
	          </div>
	        </div>
	      </div>
	      <div class="col-lg-3 col-6">
	        <!-- small box -->
	        <div class="small-box bg-warning">
	          <div class="inner">
	            <h3>${listUserRemove.size()}</h3>
	            <p>User Removed</p>
 	          </div>
	          <div class="icon">
	            <i class="ion ion-person-add"></i>
	          </div>
	        </div>
	      </div>
	      <div class="col-lg-3 col-6">
	        <!-- small box -->
	        <div class="small-box bg-danger">
	          <div class="inner">
	            <h3>${listUserIsActive.size()}</h3>
	
	            <p>User Active</p>
	          </div>
	          <div class="icon">
	            <i class="ion ion-pie-graph"></i>
	          </div>
	        </div>
	      </div>
	    </div>
	  </div>
	</section>
		     
		<div class="card">
                  <div class="card-header">
                    <h3 class="card-title">Admin Member</h3>

                    <div class="card-tools">
                      <span class="badge badge-danger">${listUserAdmin.size()} Members</span>
                      <button type="button" class="btn btn-tool" data-card-widget="collapse">
                        <i class="fas fa-minus"></i>
                      </button>
                      <button type="button" class="btn btn-tool" data-card-widget="remove">
                        <i class="fas fa-times"></i>
                      </button>
                    </div>
                  </div>
                  <!-- /.card-header -->
                  <div class="card-body p-0">
                    <ul class="users-list clearfix">
                      <c:forEach items="${listUserAdmin}" var="admin">
                      		<li>
		                        <img src="AdminTemplates/user/${admin.photo}" alt="${admin.photo}">
		                        <a class="users-list-name" href="#">${admin.fullname}</a>
		                        <span class="users-list-date">${admin.createdate}</span>
		                    </li>
                      </c:forEach>
                    </ul>
                    <!-- /.users-list -->
                  </div>
                  <!-- /.card-body -->
                </div>
                
             <div class="card">
              <div class="card-body">
                <div class="margin">
                  <div class="btn-group">
                   	<button id="type" class="btn btn-primary" onclick="ChangeTable()">Active</button>
                  </div>                 
                </div>
              </div>
              <!-- user active -->
            </div>
             <div class="card">
              <!-- /.card-header -->
              <div class="card-body">
                <table  id="tableUserActive" class="table table-bordered table-striped">
                  <thead>
	                  <tr>
	                    <th>UserName</th>
	                    <th>Full name</th>
	                    <th>PhoneNumber</th>
	                    <th>email</th>
	                    <th>Create Date</th>
	                  </tr>
                  </thead>
                  <tbody>
                 	<c:forEach items="${listUserIsActive}" var="user">
                 		<tr id="${user.username}active">
		                    <td>${user.username}</td>
		                    <td>${user.fullname}</td>
		                    <td>${user.phone_number}</td>
		                    <td>${user.email}</td>
		                    <td>${user.createdate}</td>
		                    <td>
		                    <button type="button" class="btn btn-block bg-gradient-danger" onclick="DeleteUser('${user.username}')">Delete</button>
		                    </td>
		                </tr>
	                 </c:forEach>
                  
                  </tbody>
                  <tfoot>
                  <tr>
                   		<th>UserName</th>
	                    <th>Full name</th>
	                    <th>PhoneNumber</th>
	                    <th>email</th>
	                    <th>Create Date</th>
                  </tr>
                  </tfoot>
                </table>
              </div>
              <!-- /.card-body -->
            </div>
            <div class="card">
              <!-- /.card-header -->
              <div class="card-body">
                <table style="display: none" id="tableUserRemove" class="table table-bordered table-striped">
                  <thead>
	                  <tr>
	                    <th>UserName</th>
	                    <th>Full name</th>
	                    <th>PhoneNumber</th>
	                    <th>email</th>
	                    <th>Create Date</th>
	                  </tr>
                  </thead>
                  <tbody>
                 	<c:forEach items="${listUserRemove}" var="user">
                 		<tr id="${user.username}restore">
		                    <td>${user.username}</td>
		                    <td>${user.fullname}</td>
		                    <td>${user.phone_number}</td>
		                    <td>${user.email}</td>
		                    <td>${user.createdate}</td>
		                    <td>
		                    <button type="button" class="btn btn-block bg-gradient-danger" onclick="Restore('${user.username}')">Restore</button>
		                    </td>
		                </tr>
	                 </c:forEach>
                  
                  </tbody>
                  <tfoot>
                  <tr>
                   		<th>UserName</th>
	                    <th>Full name</th>
	                    <th>PhoneNumber</th>
	                    <th>email</th>
	                    <th>Create Date</th>
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
<script type="text/javascript">

	function Restore(username) {
		$.ajax({
			  url: '/userEdition/restore?username='+username,
			  type: 'POST',
			  success: function(response) {
				  	var userRow =  document.getElementById(username+"restore");
					userRow.remove();
					alert(response);
			  },
			  error: function(xhr, status, error) {
				  alert("restore Thất Bại");	
			  }
		});

	}
	function DeleteUser(username) {
		$.ajax({
			  url: '/userEdition/remove?username='+username,
			  type: 'POST',
			  success: function(response) {
				  	var userRow =  document.getElementById(username+"active");
					userRow.remove();
					alert(response);
			  },
			  error: function(xhr, status, error) {
				  alert("Xóa Thất Bại");	
			  }
		});
	}
	function ChangeTable() {
		var tableUserActive = document.getElementById("tableUserActive");
		var tableUserRemove = document.getElementById("tableUserRemove");
		var type =  document.getElementById("type");
		if(type.innerHTML != "Active"){
			tableUserActive.style.display = 'table';
			tableUserRemove.style.display = 'none';
			type.innerHTML = "Active";
		}else{
			tableUserActive.style.display = 'none';
			tableUserRemove.style.display = 'table';
			type.innerHTML = "Removed";
		}

	}

</script>	