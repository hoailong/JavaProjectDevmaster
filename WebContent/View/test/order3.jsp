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
				<h1>Bạn đã đặt bàn thành công!</h1>
				<h2><span style="color:red">Mã bàn: ${tableId} - Mã thời gian: ${timeId}</span></h2>
			</div>
			<div class="row">
				<a href="<%=request.getContextPath()%>/Cancer?tableId=${tableId}&timeId=${timeId}">Hủy</a>
				<a href="<%=request.getContextPath()%>/">Trang Chủ</a>
			</div>
		</div>
	</div>
</body>
</html>