<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="#">Mr.Hoài Restaurant</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Trang chủ
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/thuc-don-chinh">Thực đơn</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="<%=request.getContextPath()%>/Order">Đặt bàn</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Khuyến mãi</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Giới Thiệu</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Liên hệ</a>
          </li>
          <c:if test="${not empty USERMODEL}">
	          <li class="nav-item">
	          	<a class="nav-link" style="color:red">${USERMODEL.fullName}</a>
	       	  </li>
	          <li class="nav-item" style="color:red">
	          	<a class="nav-link" href="<%=request.getContextPath()%>/logout" title="Đăng xuẩt"><i class="fas fa-sign-out-alt"></i></a>
	       	  </li>
          </c:if>
          <c:if test="${empty USERMODEL}">
	          <li class="nav-item">
	            <a class="nav-link" href="<%=request.getContextPath()%>/login">Đăng nhập</a>
	          </li>
          </c:if>
        </ul>
      </div>
    </div>
  </nav>