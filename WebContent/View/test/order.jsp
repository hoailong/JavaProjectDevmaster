<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" />
<title>Đặt Bàn</title>
</head>
<body>
<%-- 	<%@ include file = "header.jsp" %> --%>
	<c:if test="${not empty message}">
		<script>
			alert('${message}');	
			window.location.href="<%=request.getContextPath()%>";
		</script>
	</c:if>
	<div class="wrapper">
		<div class="order">
			<div class="caption">
				<h1>Chọn bàn</h1>
			</div>
			<form class="orderFrm"  action="<%=request.getContextPath()%>/Order2" method="get">
				<c:forEach items="${listTable}" var="table">
					<button name="tableId" value="${table.tableId}"><p><b>${table.name}</b></p><p>Số người: ${table.maxPeople}</p></button>
				</c:forEach>
			</form>
		</div>
	</div>
</body>
</html>