<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/tablibsheader.jsp"></jsp:include>
<title>Nhóm thực đơn</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="common/nav.jsp"></jsp:include>
		<div id="page-wrapper">
			<!-- Page Heading -->
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Nhóm thực đơn <small></small>
					</h1>
					<ol class="breadcrumb">
						<li><a href="<%=request.getContextPath()%>/admin/"><i
								class="fas fa-tachometer-alt"></i> Tổng quan</a></li>
						<li><i class="fas fa-layer-group"></i> Nhóm thực đơn</li>
					</ol>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<form method="GET" action="<%=request.getContextPath()%>/admin-foodgroups">
						<div class="form-group col-lg-8">
							<input size="40" type="text" class="form-control"
								placeholder="Nhập tên nhóm thực đơn" name="searchName" value="${searchName}">
						</div>
						<div class="form-group col-lg-2">
							<button type="submit" class="btn btn-primary">Tìm Kiếm</button>
						</div>

					</form>
					<div class="col-lg-2">
<!-- 						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#createFoodGroup" id="btnCreate">Tạo Mới</button> -->
						<button type="button" class="btn btn-primary"  id="btnCreate">Tạo Mới</button>
					</div>
				</div>

				<div class="row">
					<div class="panel panel-green">
						<div class="panel-heading">
							<h3 class="panel-title">Danh sách nhóm thực đơn</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover" id="foodGroupTbl">
									<thead>
										<tr>
											<th width="10%">ID</th>
											<th width="35%">Tên thực đơn</th>
											<th width="35%">Code</th>
											<th width="20%">Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${foodgroups}" var="foodgroup">
											<tr>
												<td class="id">${foodgroup.id}</td>
												<td class="name">${foodgroup.name}</td>
												<td class="code">${foodgroup.code}</td>
												<td><button class="btn btn-xs btn-warning btnUpdate">
														<i class="fas fa-edit"></i> Cập nhật
													</button>
													<button class="btn btn-xs btn-danger btnDelete" value="${foodgroup.id}">
														<i class="fas fa-trash-alt"></i> Xóa
													</button> 
												</td>
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
						<div style="display:none;" id="msg" class="alert alert-danger"></div>
						<form id="foodGroupFrm" class="form-horizontal" role="form">
							<!-- <input type="hidden" name="type" value="create"/> -->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="name">Tên thực đơn</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name"
										placeholder="Tên thực đơn" onkeyup="getCode()" onkeypress="getCode()" value=""/>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="code">Code</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="code" name="code"
										placeholder="Code" value="" />
								</div>
							</div>
						<input type="hidden" id="id" name="id" value=""/>
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
		$('#btnSave').click(function(e) {
			e.preventDefault();
			var data = {};
			var formData = 	$('#foodGroupFrm').serializeArray();
			$.each(formData,function(i,val) {
				data[""+val.name+""] = val.value;
			})
			console.log(data);
			var id = $('#id').val();
			if (id == "") {
				saveData("POST", data);
			} else {
				saveData("PUT", data);
			}
		});
		
 		$('#btnCreate').click(function(e) {
			e.preventDefault();
			$('.modal-title').text("Thêm nhóm thực đơn");
			$('#createFoodGroup').modal('show');
			$('#id').val("");
			$('#name').val("");
			$('#code').val("");
		});
		
		$('.btnUpdate').click(function(e) {
			e.preventDefault();
			$('.modal-title').text("Cập nhật nhóm thực đơn");
			var id = $(this).parent().siblings('.id').text();
			var name = $(this).parent().siblings('.name').text();
			var code = $(this).parent().siblings('.code').text();
			$('#createFoodGroup').modal('show');
			$('#id').val(id);
			$('#name').val(name);
			$('#code').val(code);
		}); 
		

		
		$('.btnDelete').click(function(e) {
			e.preventDefault();
			var data = {};
			data["id"] = $(this).val();
			bootbox.confirm("Bạn có chắc muốn xóa?", function(result){ 
				if(result) {
					saveData("DELETE",data);
				};
			});
		}); 
		
		function saveData(typee,data) {
			$.ajax({
				url: "api-admin-foodgroups",
				type: typee,
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data),
				dataType: "json",
				success: function(result) {
					console.log(result);
					if (result.code == "000") {
						$('#createFoodGroup').modal('hide');
						bootbox.alert(result.msg, function(){ 
							window.location.href = 'admin-foodgroups';
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
		
		function getCode() {
			var str = slug($('#name').val());
			$('#code').val(str);
			console.log($('#name').val());
			console.log(slug($(this).val()));
		};
		
		var slug = function(str) {
			  str = str.replace(/^\s+|\s+$/g, ''); // trim
			  str = str.toLowerCase();

			  // remove accents, swap ñ for n, etc
			  var from = "ẢẠĂẲẶẰẮẴÁÄÂẤẦẨẪẬÀÃÅČÇĆĎẺẸÉĚËÈÊẼĔȆÍÌÎÏŇÑÓÖÒÔÕØŘŔŠŤÚŮÜÙÛÝŸŽáäâàãåčçćďéěëèêẽĕȇíìîïňñóöòôõøðřŕšťúůüùûýÿžþÞĐđßÆaăắằẳẵặâấầẩẫậáàảãạéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởợỡúùủũụưứừửữự·/_,:;";
				var to = "AAAAAAAAAAAAAAAAAAACCCDEEEEEEEEEEIIIINNOOOOOORRSTUUUUUYYZaaaaaacccdeeeeeeeeiiiinnooooooorrstuuuuuyyzbBDdBAaaaaaaaaaaaaaaaaaaeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuu------";
			  for (var i=0, l=from.length ; i<l ; i++) {
			    str = str.replace(new RegExp(from.charAt(i), 'g'), to.charAt(i));
			  }

			  str = str.replace(/[^a-z0-9 -]/g, '') // remove invalid chars
			    .replace(/\s+/g, '-') // collapse whitespace and replace by -
			    .replace(/-+/g, '-'); // collapse dashes

			  return str;
			};
	</script>
</body>
</html>