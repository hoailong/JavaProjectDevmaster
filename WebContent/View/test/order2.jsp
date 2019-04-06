<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<div class="order">
			<div class="caption">
				<h1>Chọn giờ</h1>
				<h2>Bàn ${idTable}</h2> 
			</div>
			<form class="orderFrm selectTime"  action="<%=request.getContextPath()%>/Order3" method="get">
				<input type="hidden" name="tableId" value="${idTable}" /> 
				<c:forEach items="${listTable}" var="time">
					<button name="timeId" value="${time.timeId}" 
						<c:forEach items="${listOrder}" var="order">
							<c:if test="${idTable == order.tableId && time.timeId == order.timeId}">
								id="disabled" disabled="disabled" title="Đã được đặt "
							</c:if>
						</c:forEach>>
						${time.name}
					</button>
				</c:forEach>
			</form>
			<div class="row">
				<a href="<%=request.getContextPath()%>/">Quay Lại</a>
			</div>
		</div>
	</div>
</body>
</html>