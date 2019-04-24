<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common/tablibsheader.jsp"></jsp:include>
	<title>Thời gian mở cửa</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="common/nav.jsp"></jsp:include>
		<div id="page-wrapper">
	        <!-- Page Heading -->
	        <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header">
	                    Thời gian mở cửa
	                    <small></small>
	                </h1>
	                <ol class="breadcrumb">
	                    <li>
	                        <a href="<%=request.getContextPath()%>/admin/"><i class="fas fa-tachometer-alt"></i> Tổng quan</a>
	                    </li>
	                    <li>
	                        <i class="fas fa-clock"></i> Thời gian mở cửa
	                    </li>
	                </ol>
	            </div>
	        </div>
	        <div class="container">
	        	<div class="row" style="margin-bottom:10px" >
	        		<button class="btn btn-primary" id="btnCreate"><i class="fas fa-plus-circle"></i> Thêm mới</button>
	        	</div>
	        	<div class="row">
					<div class="panel panel-green">
						<div class="panel-heading">
							<h3 class="panel-title">Danh sách thời gian mở cửa</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover"
									id="foodGroupTbl">
									<thead>
										<tr>
											<th width="30%">ID</th>
											<th width="30%">Thời gian</th>
											<th width="40%">Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${times}" var="time">
											<tr>
												<td class="timeId">${time.timeId}</td>
												<td class="name">${time.name}</td>
												<td><button class="btn btn-xs btn-warning btnUpdate">
														<i class="fas fa-edit"></i> Cập nhật
													</button>
													<button class="btn btn-xs btn-danger btnDelete"
														value="${time.timeId}">
														<i class="fas fa-trash-alt"></i> Xóa
													</button></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
	       </div>
        </div>
        		<!-- Modal -->
		<div class="modal fade" id="timeModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Modal Header -->
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Modal title</h4>
					</div>

					<!-- Modal Body -->
					<div class="modal-body">
						<div style="display: none;" id="msg" class="alert alert-danger"></div>
						<form id="timeFrm" class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name">Thời gian</label>
								<div class="col-sm-10">
									<input type="time" class="form-control" id="name" name="name"
										placeholder="Thời gian" value="" />
								</div>
							</div>
							<input type="hidden" id="timeId" name="timeId" value="" />
						</form>
					</div>

					<!-- Modal Footer -->
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							Hủy</button>
						<button type="button" class="btn btn-primary" id="btnSave">Lưu</button>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="common/tablibsfooter.jsp"></jsp:include>
	</div>
	<script>
		$('.btnUpdate').click(function(e) {
			e.preventDefault();
			$('.modal-title').text("Cập nhật thời gian");
			$('#timeModal').modal('show');
			$('#timeId').val($(this).parent().siblings('.timeId').text());
			$('#name').val($(this).parent().siblings('.name').text());
		});
		
 		$('#btnCreate').click(function(e) {
			e.preventDefault();
			$('.modal-title').text("Thêm thời gian");
			$('#timeModal').modal('show');
			$('#timeId').val("");
			$('#name').val("");
		});
 		
		$('#btnSave').click(function(e) {
			e.preventDefault();
			var data = {};
			var form_data = $('#timeFrm').serializeArray();
			for(var i = 0; i < form_data.length; i++) {
				data[form_data[i].name] = form_data[i].value;
			}
			saveData("PUT",data);
		});
		
		$('.btnDelete').click(function(e) {
			e.preventDefault();
			var data = {};
			data["timeId"] = $(this).val();
			bootbox.confirm("Bạn có chắc muốn xóa?", function(result){ 
				if(result) {
					saveData("DELETE",data);
				};
			});
		}); 	
		
		function saveData(typee, data) {
			console.log(data);
 			$.ajax({
				url: 'api-admin-times',
				type: typee,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data),
				success: function(result) {
					console.log(result);
					if (result.code == "000") {
						$('#timeModal').modal('hide');
						bootbox.alert(result.msg, function(){ 
							window.location.href = 'admin-times';
						});
					} else {
						$("#msg").html(result.msg);
						$("#msg").show();
					}
				},
				error: function(error) {
					console.log(error);					
				}
			}); 
		}
	</script>
</body>
</html>