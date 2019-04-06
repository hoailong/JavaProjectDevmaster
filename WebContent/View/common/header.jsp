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
          <li class="nav-item <c:if test="${PAGEACTIVE == 1}">active</c:if>">
            <a class="nav-link" href="<%=request.getContextPath()%>">Trang chủ
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item <c:if test="${PAGEACTIVE == 2}">active</c:if>">
            <a class="nav-link" href="<%=request.getContextPath()%>/thuc-don">Thực đơn</a>
          </li>
          <li class="nav-item <c:if test="${PAGEACTIVE == 3}">active</c:if>">
            <a class="nav-link" href="<%=request.getContextPath()%>/order">Đặt bàn</a>
          </li>
          <li class="nav-item <c:if test="${PAGEACTIVE == 4}">active</c:if>">
            <a class="nav-link" href="#">Khuyến mãi</a>
          </li>
          <li class="nav-item <c:if test="${PAGEACTIVE == 5}">active</c:if>">
            <a class="nav-link" href="#">Giới Thiệu</a>
          </li>
          <li class="nav-item <c:if test="${PAGEACTIVE == 6}">active</c:if>">
            <a class="nav-link" href="#">Liên hệ</a>
          </li>
          <c:if test="${not empty USERMODEL}">
	       <li class="nav-item dropdown">
	            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownBlog" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="color:red">
	              [ <b>${USERMODEL.fullName}</b> ]
	            </a>
	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownBlog">
	              <a class="dropdown-item" href="#">Thông tin</a>
	              <a class="dropdown-item" href="#">Lịch sử</a>
                  <div class="dropdown-divider"></div>
	              <a class="dropdown-item" href="<%=request.getContextPath()%>/logout">Đăng xuất <i class="fas fa-sign-out-alt"></i></a>
            </div>
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