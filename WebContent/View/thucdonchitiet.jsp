<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 	
<!DOCTYPE html>
<html>
<head>
  <jsp:include page="common/tablibs.jsp"/>
  <title>Thực Đơn</title>
</head>
<body>

  <jsp:include page="common/header.jsp"/>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4"><a href="<%=request.getContextPath()%>">THỰC ĐƠN</a></h1>
        <div class="list-group">
	        <c:forEach items="${listFoodGroup}" var="foodGroup">
	        	<a href="thuc-don?code=${foodGroup.code}" class="list-group-item">${foodGroup.name}</a>
	        </c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://amthucsanvuon18.com.vn//assets/images/am-thuc-san-vuon-18-thuc-don.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://amthucsanvuon18.com.vn//assets/images/am-thuc-san-vuon-18-dau-bep.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://amthucsanvuon18.com.vn//assets/images/am-thuc-san-vuon-18-cac-mon-an.jpg" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>
	  	<a href="${groupCode}"><h1 style= "text-align:center">${groupName}</h1></a>
	  	<hr/>
	  	
        <div class="row">
        <c:forEach items="${listFood}" var="food">
          <div class="col-lg-4 col-md-6 mb-4">
              <div class="card h-100">
	              <div class="card-img">
	              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/${food.image}" alt=""></a>
	              </div>
	              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">${food.foodName}</a>
                </h4>
                <h5>${food.cost} VNĐ</h5>
              </div>
            </div>
          </div>
		</c:forEach>
        </div>
      </div>
    </div>

  </div>
  <!-- /.container -->
  <jsp:include page="common/footer.jsp"/>

</body>

</html>