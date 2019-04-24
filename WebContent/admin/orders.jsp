<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="common/tablibsheader.jsp"></jsp:include>
	<title>Danh sách đặt bàn</title>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="common/nav.jsp"></jsp:include>
		<div id="page-wrapper">
	        <!-- Page Heading -->
	        <div class="row">
	            <div class="col-lg-12">
	                <h1 class="page-header">
	                    Danh sách đặt bàn
	                    <small></small>
	                </h1>
	                <ol class="breadcrumb">
	                    <li>
	                        <a href="<%=request.getContextPath()%>/admin/"><i class="fas fa-tachometer-alt"></i> Tổng quan</a>
	                    </li>
	                    <li>
	                        <i class="fas fa-cart-plus"></i> Đặt bàn
	                    </li>
	                </ol>
	            </div>
	        </div>
	        <div class="container">
	        	<div class="row">
					<div class="panel panel-green">
						<div class="panel-heading">
							<h3 class="panel-title">Danh sách đặt bàn</h3>
						</div>
						<div class="panel-body">
							<div class="table-responsive">
								<table class="table table-bordered table-hover"
									id="foodGroupTbl">
									<thead>
										<tr>
											<th width="5%">ID</th>
											<th width="7%">ID khách</th>
											<th width="15%">Ngày đặt</th>
											<th width="10%">Giờ</th>
											<th width="8%">Số người</th>
											<th width="30%">Yêu cầu</th>
											<th width="10%">Trạng thái</th>
											<th width="15%">Thao tác</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${orders}" var="order">
											<tr>
												<td class="orderId">${order.orderId}</td>
												<td class="customerId">
													<c:if test="${order.customerId == 0}">null</c:if>
													<c:if test="${order.customerId != 0}">${order.customerId}</c:if>
												</td>
												<td class="dateOrder">${order.dateOrder}</td>
												<td class="time">
													<c:forEach items="${times}" var="time">
														<c:if test="${time.timeId == order.timeId}">${time.name}</c:if>
													</c:forEach>
												</td>
												<td class="timeId" style="display:none">${order.timeId}</td>
												<td class="numberPeople">${order.numberPeople}</td>
												<td class="request">${order.request}</td>
												<td class="statusBtn">
													<c:if test="${order.status == 1}"><button type="button" class="btn btn-xs btn-primary">Đặt bàn</button></c:if>
													<c:if test="${order.status == 2}"><button type="button" class="btn btn-xs btn-success">Đã thanh toán</button></c:if>
													<c:if test="${order.status == 0}"><button type="button" class="btn btn-xs radius grey-cascade">Đã hủy</button></c:if>
												</td>
												<td class="status" style="display:none">${order.status}</td>
												<td><button class="btn btn-xs btn-warning btnUpdate">
														<i class="fas fa-edit"></i> Cập nhật
													</button>
													<button class="btn btn-xs btn-danger btnDelete"
														value="${order.orderId}">
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
		<div class="modal fade" id="orderModal" tabindex="-1"
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
						<form id="orderFrm" class="form-horizontal" role="form">
							<!-- <input type="hidden" name="type" value="create"/> -->
							<div class="form-group">
								<label class="col-sm-2 control-label" for="customerId">Khách hàng</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="customerId" name="customerId"
										placeholder="Khách hàng" value="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="dateOrder">Ngày đặt</label>
								<div class="col-sm-10">
									<input type="date" class="form-control" id="dateOrder" name="dateOrder"
										placeholder="Ngày đặt" value="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="timeId">Thời gian</label>
								<div class="col-sm-10">
									<select class="form-control" id="timeId" name="timeId">
										<c:forEach items="${times}" var="time">
											<option value="${time.timeId}">${time.name}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="numberPeople">Số người</label>
								<div class="col-sm-10">
									<input type="number" class="form-control" id="numberPeople" name="numberPeople"
										placeholder="Số người" value="" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="request">Yêu cầu</label>
								<div class="col-sm-10">
									<textarea row="3" class="form-control" id="request" name="request"
										placeholder="Yêu cầu" value=""></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label" for="status">Trạng thái</label>
								<div class="col-sm-10">
									<select class="form-control" id="status" name="status">
										<option value="1">Đặt bàn</option>
										<option value="2">Đã thanh toán</option>
										<option value="0">Đã hủy</option>
									</select>
								</div>
							</div>
							<input type="hidden" id="orderId" name="orderId" value="" />
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
			$('.modal-title').text("Cập nhật Order");
			$('#orderModal').modal('show');
			$('#orderId').val($(this).parent().siblings('.orderId').text());
			$('#customerId').val($(this).parent().siblings('.customerId').text().trim());
			if ($('#customerId').val() == "null") {$('#customerId').val(0)};
			$('#dateOrder').val($(this).parent().siblings('.dateOrder').text());
			$('#numberPeople').val($(this).parent().siblings('.numberPeople').text());
			$('#request').val($(this).parent().siblings('.request').text());
			$('#timeId').val($(this).parent().siblings('.timeId').text());
			$('#status').val($(this).parent().siblings('.status').text());
		});
		
		$('#btnSave').click(function(e) {
			e.preventDefault();
			var data = {};
			var form_data = $('#orderFrm').serializeArray();
			for(var i = 0; i < form_data.length; i++) {
				data[form_data[i].name] = form_data[i].value;
			}
			saveData("PUT",data);
		});
		
		$('.btnDelete').click(function(e) {
			e.preventDefault();
			var data = {};
			data["orderId"] = $(this).val();
			bootbox.confirm("Bạn có chắc muốn xóa?", function(result){ 
				if(result) {
					saveData("DELETE",data);
				};
			});
		}); 	
		
		function saveData(typee, data) {
			console.log(data);
 			$.ajax({
				url: 'api-admin-orders',
				type: typee,
				dataType: 'json',
				contentType: 'application/json; charset=utf-8',
				data: JSON.stringify(data),
				success: function(result) {
					console.log(result);
					if (result.code == "000") {
						$('#orderModal').modal('hide');
						bootbox.alert(result.msg, function(){ 
							window.location.href = 'admin-orders';
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