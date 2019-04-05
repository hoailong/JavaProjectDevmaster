<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="tablibsheader.jsp"></jsp:include>
	<title>Quản lý tài khoản</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="nav.jsp"></jsp:include>
		<div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Quản lý tài khoản
                            <small></small>
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <a href="<%=request.getContextPath()%>/Admin/"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
                            </li>
                            <li class="active">
                                <i class="fas fa-users"></i></i> User Accounts
                            </li>
                        </ol>
                    </div>
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2><i class="fas fa-user-shield"></i> Quản Trị</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Mật khẩu</th>
                                        <th>Họ và tên</th>
                                        <th>Email</th>
                                        <th>Số điện thoại</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${admins}" var="admin">
	                                    <tr>
	                                        <td>${admin.userId}</td>
	                                        <td>${admin.userName}</td>
	                                        <td>${admin.password}</td>
	                                        <td>${admin.fullName}</td>
	                                        <td>${admin.email}</td>
	                                        <td>${admin.phone}</td>
	                                        <td>
	                                        	<a href="<c:url value="/admin-users?type=edit&id=${admin.userId}" />"><button class="btn btn-xs btn-warning"><i class="fas fa-edit"></i> Sửa</button></a> | 
	                                        	<button class="btn btn-xs btn-danger btnDelUser" value="${admin.userId}"><i class="fas fa-trash-alt"></i> Xóa</button>  
	                                        	<%-- <a href="<c:url value="/admin-users?type=add" />"><button><i class="fas fa-plus-circle"></i></button></a> --%>
	                                        </td>
	                                    </tr>
	                            
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr><td colspan="7"><a href="<c:url value="/admin-users?type=add" />"><button class="btn btn-success"><i class="fas fa-plus-circle"></i> Thêm mới</button></a></td></tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                   </div>
                <div class="row">
                    <div class="col-lg-12">
                        <h2><i class="fas fa-user-friends"></i> Khách hàng</h2>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Tên đăng nhập</th>
                                        <th>Mật khẩu</th>
                                        <th>Họ và tên</th>
                                        <th>Email</th>
                                        <th>Số điện thoại</th>
                                        <th>Thao tác</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${customers}" var="customer">
	                                    <tr>
	                                        <td>${customer.userId}</td>
	                                        <td>${customer.userName}</td>
	                                        <td>${customer.password}</td>
	                                        <td>${customer.fullName}</td>
	                                        <td>${customer.email}</td>
	                                        <td>${customer.phone}</td>
	                                        <td>
	                                        	<a href="<c:url value="/admin-users?type=edit&id=${customer.userId}"/>"><button class="btn btn-xs btn-warning"><i class="fas fa-edit"></i> Sửa</button></a> | 
	                                        	<button class="btn btn-xs btn-danger btnDelUser" value="${customer.userId}"><i class="fas fa-trash-alt"></i> Xóa</button> 
	                                        </td>
	                                    </tr>
                                    </c:forEach>
                                </tbody>
                                <tfoot>
                                	<tr><td colspan="7"><a href="<c:url value="/admin-users?type=add" />"><button class="btn btn-success"><i class="fas fa-plus-circle"></i> Thêm mới</button></a></td></tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                   </div>

            </div>
            <!-- /.container-fluid -->

        </div>
	</div>
	<jsp:include page="tablibsfooter.jsp"></jsp:include>
	<script>
		$('.btnDelUser').click(function(e) {
			e.preventDefault();
			var data = {};
			data["userId"] = $(this).val();
			console.log(data);
			bootbox.confirm("Bạn có chắc muốn xóa?", function(result){ 
				if(result) {
					$.ajax({
						url : "api-admin-user",
						type : 'DELETE',
						contentType : 'application/json; charset=utf-8',
						data : JSON.stringify(data),
						dataType: 'json',
						success: function(result) {
							console.log(result);
							window.location.href = 'admin-users';
							//bootbox.alert("Xóa thành công!");
						},
						error: function(error) {
							console.log(error);
							bootbox.alert("Lỗi: " + error, function(){ 
								window.location.href = 'admin-users';
							});
						}
					}); 
				}
			});
		});
	</script>
</body>
</html>