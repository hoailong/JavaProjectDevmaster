<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="tablibsheader.jsp"></jsp:include>
	<title>Thêm mới - Chỉnh sửa tài khoản</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="nav.jsp"></jsp:include>
		<div id="page-wrapper">
	        <!-- Page Heading -->
	        <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header">
	                    Quản lý tài khoản
	                    <small></small>
	                </h1>
	                <ol class="breadcrumb">
	                    <li>
	                        <a href="<%=request.getContextPath()%>/admin/"><i class="fas fa-tachometer-alt"></i> Dashboard</a>
	                    </li>
	                    <li>
	                        <a href="<%=request.getContextPath()%>/admin-users"><i class="fas fa-users"></i> User Accounts</a>
	                    </li>
	                    <li class="active">
	                        <i class="fas fa-user-plus"></i> Edit - Add
	                    </li>
	                </ol>
	            </div>
	        </div>
	        <div class="row">
	        	<div class="col-lg-1"></div>
	        	<div class="col-lg-8">
	        		<form id="userFrm">
		        		<div style="display:none;" id="msg" class="alert alert-danger">
						</div>
	       		        <div class="form-group">
	                              <label>Tên đăng nhập </label>
	                              <input type="text" class="form-control" placeholder="Tên đăng nhập" name="userName" id="userName" value="${user.userName}">
	                     </div>
	                     <div class="form-group">
	                              <label>Mật khẩu </label>
	                              <input type="password" class="form-control" placeholder="Mật khẩu" name="password" id="password" value="${user.password}">
	                     </div>
	                     <div class="form-group">
	                              <label>Họ và tên </label>
	                              <input type="text" class="form-control" placeholder="Họ và tên" name="fullName" id="fullName" value="${user.fullName}">
	                     </div>
	                     <div class="form-group">
	                              <label>Email </label>
	                              <input type="text" class="form-control" placeholder="Email" name="email" id="email" value="${user.email}">
	                     </div>
	                     <div class="form-group">
	                              <label>Số điện thoại </label>
	                              <input type="text" class="form-control" placeholder="Số điện thoại" id="phone" name="phone" value="${user.phone}">
	                     </div>
	                     <div class="form-group">
		                    <label>Phân Quyền</label>
		                    <select class="form-control" id="groupId" name="groupId">
		                    	<c:if test="${empty user.groupId}">
			                        <option value="">Chọn quyền</option>
				                    <c:forEach items="${roles}" var="role">
				                    	<option value="${role.id}" <c:if test=""></c:if>>${role.name}</option>
				                    </c:forEach>	                    	
		                    	</c:if>
		                    	<c:if test="${not empty user.groupId}">
			                        <option value="">Chọn quyền</option>
				                    <c:forEach items="${roles}" var="role">
				                    	<option value="${role.id}" <c:if test="${user.groupId == role.id}">selected="selected"</c:if>>${role.name}</option>
				                    </c:forEach>
			                   	</c:if>
		                    </select>
		                </div>
		                <button type="button" class="btn btn-primary" id="btnSaveUser"><i class="fas fa-save"></i> Lưu</button>
		                <input type="hidden" name="userId" id="userId" value="${user.userId}"> 
	                </form>
	        	</div>
	        </div>
        </div>
		<jsp:include page="tablibsfooter.jsp"></jsp:include>
	</div>
	<script>
		$('#btnSaveUser').click(function (e) {
			e.preventDefault();
			//lấy dữ liệu
//			var userName = $('#userName').val();
//			var password = $('#password').val();
//			var fullName = $('#fullName').val();
//			var email = $('#email').val();
//			var phone = $('#phone').val();
//			var groupId = $('#groupId').val(); 
			var data = {};
			//lấy tất cả value trên form cho vào 1 mảng
			var formData = $('#userFrm').serializeArray();
			$.each(formData,function(i, val) {
				data[""+val.name+""] = val.value;
			});
//			console.log(data);

			//kiểm tra xem insert hay update
			var id = $('#userId	').val();
			var typee;
			var msg;
			if (id == "") {
				typee = "POST";
				msg = "Thêm mới";
			} else {
				typee = "PUT";
				msg = "Cập nhật";
			}
			
			saveData(data, typee, msg);
			
			function saveData(data, typee, msg) {
				$.ajax({
					url : "api-admin-user",
					type : typee,
					contentType : 'application/json; charset=utf-8',
					data : JSON.stringify(data),
					dataType: 'json',
					success: function(result) {
						console.log(result);
						if (result.code == "000") {
							bootbox.alert(msg + " tài khoản thành công!", function(){ 
								window.location.href = 'admin-users';
							});
						} else {
							$("#msg").html(result.msg);
							$("#msg").show();
						}
						
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
	</script>
</body>
</html>