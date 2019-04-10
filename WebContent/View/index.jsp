<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <!DOCTYPE html>
    <html>

    <head>
      <jsp:include page="common/tablibs.jsp" />
      <title>Trang chủ</title>
    </head>

    <body>
      <jsp:include page="common/header.jsp" />
      <header>
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <!-- Slide One - Set the background image for this slide in the line below -->
            <div class="carousel-item active" style="background-image: url('<%=request.getContextPath()%>/resources/images/slider/slider-2.jpg')">
              <div class="carousel-caption d-none d-md-block">
                <h3>First Slide</h3>
                <p>This is a description for the first slide.</p>
              </div>
            </div>
            <!-- Slide Two - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/resources/images/slider/slider-1.jpg')">
              <div class="carousel-caption d-none d-md-block">
                <h3>Second Slide</h3>
                <p>This is a description for the second slide.</p>
              </div>
            </div>
            <!-- Slide Three - Set the background image for this slide in the line below -->
            <div class="carousel-item" style="background-image: url('<%=request.getContextPath()%>/resources/images/slider/slider-3.jpg')">
              <div class="carousel-caption d-none d-md-block">
                <h3>Third Slide</h3>
                <p>This is a description for the third slide.</p>
              </div>
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
      </header>

      <!-- Page Content -->
      <div class="container">

        <h1 class="my-4">Chào mừng bạn đến với Nhà hàng Mr.Hoài</h1>

        <!-- Marketing Icons Section -->
        <div class="row">
          <div class="col-lg-4 mb-4">
            <div class="card h-100">
              <h4 class="card-header">Giới Thiệu</h4>
              <div class="card-body">
                <a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/gioi-thieu.jpg" alt="Giới Thiệu"></a>
                <p style="margin-top:10px" class="card-text">Chào mừng bạn đến với nhà hàng Mr.Hoài, chuỗi nhà hàng mang phong cách ẩm thực Việt Nam đương đại dựa trên sự chắt lọc tinh hoa của ẩm thực truyền thống Việt Nam và châu Á..</p>
              </div>
              <div class="card-footer">
                <a href="#" class="btn btn-primary">Chi tiết</a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 mb-4">
            <div class="card h-100">
              <h4 class="card-header">Thực Đơn</h4>
              <div class="card-body">
                <a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/thuc-don.jpg" alt="Thực Đơn"></a>
                <p style="margin-top:10px" class="card-text">Thực đơn phong phú 175 món, gồm các món Alacarte và các món trong thực đơn Set Lunch với mức giá hợp lý, mang đậm phong vị Nhật Bản và rất hợp với khẩu vị với người Việt Nam..</p>
              </div>
              <div class="card-footer">
                <a href="<%=request.getContextPath()%>/thuc-don" class="btn btn-primary">Xem thêm</a>
              </div>
            </div>
          </div>
          <div class="col-lg-4 mb-4">
            <div class="card h-100">
              <h4 class="card-header">Đặt Bàn</h4>
              <div class="card-body">
                <a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/dat-ban.jpg" alt="Đặt Bàn"></a>
                <p style="margin-top:10px" class="card-text">Không gian nhà hàng mang tớii cho thực khách cảm giác đậm chất Nhật Bản, đó là sự kết hợp giữa truyền thống và hiện đại. Làm nổi bật lên nét đẹp trong văn hoá ẩm thực Nhật Bản..</p>
              </div>
              <div class="card-footer">
                <a href="<%=request.getContextPath()%>/dat-ban" class="btn btn-primary">Đặt bàn ngay</a>
              </div>
            </div>
          </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Section -->
        <h2>Các Món Mới</h2>

        <div class="row">
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
          <div class="col-lg-4 col-sm-6 portfolio-item">
            <div class="card h-100">
              <div class="food-card card-img">
              	<a href="#"><img class="card-img-top" src="<%=request.getContextPath()%>/resources/images/food/phuong-hoang-lua.jpg" alt=""></a>
              </div>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="#">Phượng hoàng lửa</a>
                </h4>
                <p class="card-text">Món ăn đã được CNN bình chọn là món ngon nhất hành tinh. Hãy đến Mr.Hoài restaurant để được trải nghiệm sự bùng nổ hương vị qua mỗi lần thưởng thức … !!!!</p>
              </div>
            </div>
          </div>
        </div>
        <!-- /.row -->

        <!-- Features Section -->
        <br />
        <div class="row">
          <div class="col-lg-6">
            <h2>Liên Hệ Với Chúng Tôi</h2>
            <p>Liên hệ với chúng tôi khi cần, Nếu có thắc mắc và phản hồi, xin vui lòng gửi email cho chúng tôi tại hoailong129@gmail.com</p>
            <ul>
              <h4>Chuôi nhà hàng</h4>
              <li><strong>Cơ sở 1: </strong> Tầng 3, TTTM Aeon Mall Long Biên, Long Biên, Hà Nội
                <br />Tel: 024.3829.3388</li>
              <li><strong>Cơ sở 2: </strong> M3, M4 số 91 Nguyễn Chí Thanh, Hà Nội
                <br />Tel: 024.7106.7333</li>
              <li><strong>Cơ sở 3: </strong> Tầng 4, TTTM Artemis, Lê Trọng Tấn, Thanh Xuân, Hà Nội
                <br />Tel: 024.7106.7333</li>
              <li><strong>Cơ sở 4: </strong> Tầng 4, TTTM Artemis, Lê Trọng Tấn, Thanh Xuân, Hà Nội
                <br />Tel: 024.7106.7333</li>
              <li><strong>Cơ sở 5: </strong> Tầng 4, TTTM Artemis, Lê Trọng Tấn, Thanh Xuân, Hà Nội
                <br />Tel: 024.7106.7333</li>
            </ul>
            <p>Rất hân hạnh được phục vụ quý khách!</p>
          </div>
          <div class="col-lg-6">
            <img style="height:450px;" class="img-fluid rounded" src="<%=request.getContextPath()%>/resources/images/ban-do.png" alt="Bản đồ">
          </div>
        </div>
        <!-- /.row -->

        <hr>

        <!-- Call to Action Section -->
        <div class="row mb-4">
          <div class="col-md-8">
            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p>
          </div>
          <div class="col-md-4">
            <a class="btn btn-lg btn-secondary btn-block" href="#">Lên đầu trang</a>
          </div>
        </div>

      </div>
      <!-- /.container -->
      <jsp:include page="common/footer.jsp" />
      <c:if test="${not empty msg}">
        <script>
          //bootbox.alert({
          //message: "This is an alert with additional classes!",
          //className: 'rubberBand animated'
          //}); 
          alert('${msg}');

        </script>
      </c:if>
    </body>

    </html>
