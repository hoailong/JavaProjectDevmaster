<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<style>
		.activeSubLi {
  				background-color: #080808;
		}
		.activeSubLi a{
		    color: #fff !important;
		}
	</style>
<!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath()%>/admin/">Admin Management</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${USERMODEL.fullName} <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Thông tin</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Đổi mật khẩu</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="<%=request.getContextPath()%>/logout"><i class="fa fa-fw fa-power-off"></i> Đăng xuất</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li>
                        <a href="<%=request.getContextPath()%>/"><i class="fas fa-home"></i> Trang chủ</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin"><i class="fas fa-tachometer-alt"></i> Tổng quan</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin-orders"><i class="fas fa-cart-plus"></i> Đặt bàn</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#danhmuc"><i class="fas fa-rocket"></i> Danh mục <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="danhmuc" class="collapse">
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-foods"><i class="fas fa-utensils"></i> Món ăn - Đồ uống</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-foodgroups"><i class="fas fa-layer-group"></i> Nhóm thực đơn</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-times"><i class="fas fa-clock"></i> Thời gian</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-tables"><i class="fas fa-table"></i> Bàn ăn</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-customers"><i class="fas fa-user-tie"></i> Khách hàng</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin-users"><i class="fas fa-users"></i> Tài khoản</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/admin-events"><i class="fas fa-gift"></i> Khuyến mãi</a>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#baocao"><i class="fas fa-chart-bar"></i> Báo cáo <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="baocao" class="collapse">
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-foods"><i class="fas fa-copy"></i> Lợi nhuận</a>
                            </li>
                            <li>
                                <a href="<%=request.getContextPath()%>/admin-foods"><i class="fas fa-copy"></i> Theo tháng</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fas fa-arrows-alt-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                            <li>
                                <a href="#">Dropdown Item</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
            <script>
	           	var nthLi = ${PAGEACTIVE};
            	if (nthLi > 10) {
            		var parent = Math.floor(nthLi/10) + 1;
            		var child = nthLi%10;
                	console.log(parent + " - " + child);
                	$('.side-nav > li:nth-of-type('+ parent +') > a').removeClass('collapsed');
            		$('.side-nav > li:nth-of-type('+ parent +') > a, .side-nav > li:nth-of-type('+ parent +') > ul').attr('aria-expanded', 'true');
            		$('.side-nav > li:nth-of-type('+ parent +') > ul').addClass('in');
            		$('.side-nav > li:nth-of-type('+ parent +') > ul').removeAttr('style');
            		$('.side-nav > li:nth-of-type('+ parent +')').addClass('open');
            		$('.side-nav > li:nth-of-type('+ parent +') > ul > li:nth-of-type('+ child +')').addClass('activeSubLi');
            	}
            	else {
            		$('.side-nav > li:nth-of-type('+ (nthLi+1) +')').addClass('active');
            	}
            </script>
            <!-- /.navbar-collapse -->
        </nav>