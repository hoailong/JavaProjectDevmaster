<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" href="<%=request.getContextPath()%>/images/restaurant-icon-4.png" type="image/x-icon" />
<%-- <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/style.css" /> --%>
<title>Insert title here</title>
<style>
header {
  width:100%;
  height:100px;
  background:#ff7317;
  position:absolute;
  top: 0;
  left:0;
  overflow: hidden;

}
.container {
  margin: 0 10%;
}
.logo {
  margin: 0 30px;
    float:left;
}

.logo img {
  width:100px;
  height:auto;
}

.nav {
  font-family: tahoma;
  float:right;
  height: 100%;
}

.nav ul {
  align-items: center;
  justify-content: center;
  display: flex;
  list-style: none;
}

.nav ul li {
  display: block;
  position: relative;
}
.nav ul li a {
  text-decoration: none;
  color: white;
  padding:15px;
  line-height: 100px;
  text-transform: uppercase;
}

.nav ul li a:hover {
  text-decoration: underline;
}

</style>
</head>
<body>
	<header>
    <div class="container">
  		<div class="logo">
          <img src="http://lauphan.com/images/logo.jpg" alt="Trang Chủ">
      </div>
      <div class="nav">
        <ul>
          <li><a href="#">Trang Chủ</a></li>
          <li><a href="#">Thực Đơn</a></li>
          <li><a href="#">Đặt Bàn</a></li>
          <li><a href="#">Khuyến Mãi</a></li>
          <li><a href="#">Giới Thiệu</a></li>
          <li><a href="#">Liên Hệ</a></li>
        </ul>
      </div>
    </div>
	</header>
</body>

</html>