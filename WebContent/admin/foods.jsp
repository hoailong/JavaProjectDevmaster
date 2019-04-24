<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/tablibsheader.jsp"></jsp:include>
<title>Món ăn - Đồ uống</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="common/nav.jsp"></jsp:include>
		<div id="page-wrapper">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Món ăn - Đồ uống <small></small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="<%=request.getContextPath()%>/admin/"><i
								class="fas fa-tachometer-alt"></i> Tổng quan</a></li>
						<li><i class="fas fa-utensils"></i> Món ăn - Đồ uống</li>
					</ol>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<form method="GET"
						action="<%=request.getContextPath()%>/admin-foods">
						<div class="form-group col-lg-4">
							<input size="20" type="text" class="form-control"
								placeholder="Nhập tên món" name="searchName"
								value="${searchName}">
						</div>
						<div class="form-group col-lg-4">
							<select class="form-control" name="groupCode">
								<option value="">Tất cả nhóm thực đơn</option>
								<c:forEach items="${foodgroups}" var="foodgroup">
									<option value="${foodgroup.code}" <c:if test="${foodgroup.code == groupCode}">selected</c:if>>${foodgroup.name}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group col-lg-2">
							<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
						</div>

					</form>
					<div class="col-lg-2">
						<!-- 						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#createFoodGroup" id="btnCreate">Tạo Mới</button> -->
						<button type="button" class="btn btn-primary" id="btnCreate">Tạo
							Mới</button>
					</div>
				</div>

				<div class="row">
					<div class="panel panel-green">
						<div class="panel-heading">
							<h3 class="panel-title">Danh sách thực đơn</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover"
									id="foodGroupTbl">
									<thead>
										<tr>
											<th width="5%">ID</th>
											<th width="25%">Tên món</th>
											<th width="25%">Hình ảnh</th>
											<th width="20%">Nhóm thực đơn</th>
											<th width="10%">Giá</th>
											<th width="15%">Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${foods}" var="food">
											<tr>
												<td class="id">${food.foodId}</td>
												<td class="name">${food.foodName}</td>
												<td class="image">
													<img src="<%=request.getContextPath()%>/resources/images/food/${food.image}" value="${food.image}" width="50%" alt="${food.foodName}">
												</td>
												<td class="group">
													<c:forEach items="${foodgroups}" var="foodgroup">
														<c:if test="${foodgroup.id == food.groupId}">${foodgroup.name}</c:if>
													</c:forEach></td>
												<td class="groupId" style="display:none">${food.groupId}</td>
												<td class="cost">${food.cost}</td>
												<td><button class="btn btn-xs btn-warning btnUpdate">
														<i class="fas fa-edit"></i> Cập nhật
													</button>
													<button class="btn btn-xs btn-danger btnDelete"
														value="${food.foodId}">
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
		<div class="modal fade" id="createFoodGroup" tabindex="-1"
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
						<form id="foodGroupFrm" class="form-horizontal" role="form">
							<!-- <input type="hidden" name="type" value="create"/> -->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="foodName">Tên món</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="foodName" name="foodName"
										placeholder="Tên món" value="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="image">Hình ảnh</label>
								<div class="col-sm-10">
									<input type="file" class="form-control" id="file" name="file" value="no-image.jpg"
										placeholder="Hình ảnh" onchange="loadImage()" />
									<img alt="Image" src="<%=request.getContextPath()%>/resources/images/food/no-image.jpg" id="target" width="auto" height="150px"/>
									
								</div>
							</div>
 							<input type="hidden" id="image" name="image" value="no-image.jpg" />
							<div class="form-group">
								<label class="col-sm-2 control-label" for="groupId">Nhóm thực đơn</label>
								<div class="col-sm-10">
									<select class="form-control" id="groupId" name="groupId">
										<option value="">Chọn nhóm thực đơn</option>
										<c:forEach items="${foodgroups}" var="foodgroup">
											<option value="${foodgroup.id}">${foodgroup.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="cost">Giá</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="cost" name="cost"
										placeholder="Giá" value="" />
								</div>
							</div>
							<input type="hidden" id="foodId" name="foodId" value="" />
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
		
		function checkValidTypeFile() {
			var file = document.querySelector("input[type=file]").files[0];
			if (file == null) {
				return false;
			}
			var allowed_file_types = ['image/png', 'image/gif', 'image/jpeg', 'image/pjpeg']; //allowed file types
			if (allowed_file_types.indexOf(file.type) === -1) {
				return false;
			}
			return true;
		}
		
		function loadImage() {
			var target = document.querySelector("#target");
			if(checkValidTypeFile()) {
				$("#msg").hide();
				var file = document.querySelector("input[type=file]").files[0];
				var reader = new FileReader();
				
				reader.onloadend = function() {
					target.src = reader.result;
				};

				var img = $('#file').val();
				console.log("link-image:" + img);
				$('#image').val(img.substring(img.lastIndexOf('\\')+1));
				//alert($('#image').val());	
				
				if(file) {
					reader.readAsDataURL(file);
				} else {
					target.src = "";
				}
			}
			else {
				$("#msg").html("File không hợp lệ!");
				$("#msg").show();
				//alert("File không hợp lệ!");
				$('#file').val("");
				target.src = "<%=request.getContextPath()%>/resources/images/food/no-image.jpg";
			}
		}
		
		function uploadFoodImage() {
			if(checkValidTypeFile()) {
				var form = $("#foodGroupFrm")[0];
				var form_data = new FormData(form); //Creates new FormData object
				var post_url = "<%=request.getContextPath()%>/upload-food-image";
				//console.log(form_data);
				 //jQuery Ajax to Post form data
				$.ajax({
					url: post_url,
					type: "POST",
					data: form_data,
					contentType: false,
	                processData: false,
					mimeType: "multipart/form-data"
				}).done(function (res) { 
	            	console.log("upload image success");
	            });
			} else {
				console.log("file ko hop le!");
			}
		}
		
		function saveData(typee,data) {
			//console.log(data);
			$.ajax({
				url: "api-admin-foods",
				type: typee,
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data),
				dataType: "json",
				success: function(result) {
					console.log(result);
					if (result.code == "000") {
						$('#createFoodGroup').modal('hide');
						bootbox.alert(result.msg, function(){ 
							window.location.href = 'admin-foods';
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
			
			$('#btnCreate').click(function(e) {
				e.preventDefault();
				$("#msg").hide();
				$('.modal-title').text("Thêm món mới");
				$('#createFoodGroup').modal('show');
				$('#foodName').val("");
				$('#cost').val("");
				$('#file').val("");
				$('#groupId').val("");
				$('#foodId').val("");
				$('#image').val("no-image.jpg");
				$('#target').attr("src","<%=request.getContextPath()%>/resources/images/food/no-image.jpg");
			});
		
			$('.btnUpdate').click(function(e) {
				e.preventDefault();
				$("#msg").hide();
				$('.modal-title').text("Cập nhật món");
				$('#createFoodGroup').modal('show');
				$('#foodId').val($(this).parent().siblings('.id').text());
				$('#foodName').val($(this).parent().siblings('.name').text());
				$('#cost').val($(this).parent().siblings('.cost').text());
				$('#groupId').val($(this).parent().siblings('.groupId').text());
				$('#image').val($(this).parent().siblings('.image').children().attr('value'));
				$('#file').val("");
				$('#target').attr("src","<%=request.getContextPath()%>/resources/images/food/" + $(this).parent().siblings('.image').children().attr('value'));
			});
			
			$('#btnSave').click(function(e) {
				e.preventDefault();
				//thực hiện upload ảnh trước
				uploadFoodImage();
				
				var data = {};
				var formData = 	$('#foodGroupFrm').serializeArray();
				$.each(formData,function(i,val) {
					data[""+val.name+""] = val.value;
				})
				console.log(data);
				var id = $('#foodId').val();
				if (id == "") {
					saveData("POST", data);
				} else {
					saveData("PUT", data);
				}
			});
			
			$('.btnDelete').click(function(e) {
				e.preventDefault();
				var data = {};
				data["foodId"] = $(this).val();
				bootbox.confirm("Bạn có chắc muốn xóa?", function(result){ 
					if(result) {
						saveData("DELETE",data);
					};
				});
			}); 
	</script>
</body>
</html>