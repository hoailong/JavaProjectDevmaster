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
	                    Nhóm thực đơn
	                    <small></small>
	                </h1>
	                <ol class="breadcrumb">
	                    <li>
	                        <a href="<%=request.getContextPath()%>/admin/"><i class="fas fa-tachometer-alt"></i> Tổng quan</a>
	                    </li>
	                    <li>
	                        <i class="fas fa-layer-group"></i> Nhóm thực đơn
	                    </li>
	                </ol>
	            </div>
	        </div>
	        <div class="container">
	       </div>
        </div>
		<jsp:include page="common/tablibsfooter.jsp"></jsp:include>
	</div>
	<script>
	
	</script>
</body>
</html>