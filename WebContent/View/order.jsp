<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common/tablibs.jsp" />
<title>Đặt bàn</title>
</head>
<body>
	<jsp:include page="common/header.jsp" />
	<!-- Page Content -->
	<br />
	<br />
	<br />
	<div class="container">
		<form id="orderFrm" action="<%=request.getContextPath()%>/order" method="POST">
			<div class="text-center">
				<h1>Đặt bàn</h1>
			</div>
			
			<div class="form-row">
				<div class="col-lg-4">
						<input type="date" class="form-control" placeholder="Ngày đặt bàn"  id="dateOrder" name="dateOrder" required>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<select class="form-control" id="timeId" name="timeId" required>
							<option value="">Thời gian</option>
							<c:forEach items="${listTime}" var="time" >
								<option value="${time.timeId}">${time.name}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="col-lg-4">
					<div class="form-group">
						<input type="number" min="1" max="50" class="form-control" placeholder="Số người" id="numberPeople" name="numberPeople" required>
					</div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-lg-12">
					<div class="form-group">
						<textarea class="form-control" rows="3" placeholder="Yêu cầu thêm" id="request" name="request"></textarea>
					</div>
				</div>
			</div>
			 <div class="row justify-content-md-center">
				<div class="col-lg-3 text-center">
					<button type="submit" class="btn btn-lg btn-success" id="btnOrder">Đặt bàn ngay</button>
				</div>
			</div>
			<input type="hidden" id="userId" name="customerId" value="<c:if test="${not empty USERMODEL}">${USERMODEL.userId}</c:if>">
			<input type="hidden" id="orderId" name="orderId" value="">
		</form>
		<br />
		<div class="row col-lg-12" style="overflow:hidden">
			<img alt="Restaurant View" src="<%=request.getContextPath()%>/resources/images/restaurant-order.jpg">
		</div>
	</div>
	<jsp:include page="common/footer.jsp"/>
</body>
</html>