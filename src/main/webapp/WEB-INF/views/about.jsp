<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <%@include file="linkIncludes.jsp"%>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">
</head>
<body>
    <%@include file="header.jsp"%>
    <section>
        <div class="inner-information-text">
            <div class="container">
                <h3><s:message code="about.titleCab"/></h3>
                <ul class="breadcrumb">
                    <li><a href="/home"><s:message code="navBar.Home"/></a></li>
                    <li style="padding: 0px 4px 0px 4px"><a href="">/</a></li>
                    <li class="active"><s:message code="navBar.About"/></li>
                </ul>
            </div>
        </div>
    </section>
    <section id="contant" class="contant main-heading" style="padding-bottom:0;margin-bottom:-1px;position:relative;z-index:1;">
        <div class="aboutus">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 col-sm-7 col-xs-12">
                        <div class="full">
                            <h3><s:message code="about.title"/></h3>
                            <p><s:message code="about.mensaje1"/></p>
                            <ul class="icon-list">
                                <li><i class="fa fa-angle-right"></i> Voluptate illum dolore ita ipsum</li>
                                <li><i class="fa fa-angle-right"></i> Labore admodum ita multos malis ea nam nam tamen fore amet</li>
                                <li><i class="fa fa-angle-right"></i> Voluptate illum dolore ita ipsum</li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-5 col-sm-5 col-xs-12">
                        <img class="img-responsive" height="300" src="images/img-07.jpg" alt="#" />
                    </div>
                </div>
            </div>
        </div>
        <div class="dark-section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12">
                        <div class="heading-main">
                            <h2>Our Testimonials</h2>
                        </div>
                        <div class="testimonial-slider">
                            <div class="carousel slide" data-ride="carousel" id="carousel">
                                <!-- Carousel Slides / Quotes -->
                                <div class="carousel-inner">
                                    <!-- Quote 1 -->
                                    <div class="carousel-item active">
                                        <blockquote>
                                            <div class="row">
                                                <div class="col-sm-8 offset-sm-2">
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. !</p>
                                                    <small>Someone famous</small>
                                                </div>
                                            </div>
                                        </blockquote>
                                    </div>
                                    <!-- Quote 2 -->
                                    <div class="carousel-item">
                                        <blockquote>
                                            <div class="row">
                                                <div class="col-sm-8 offset-sm-2" >
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. </p>
                                                    <small>Someone famous</small>
                                                </div>
                                            </div>
                                        </blockquote>
                                    </div>
                                    <!-- Quote 3 -->
                                    <div class="carousel-item">
                                        <blockquote>
                                            <div class="row">
                                                <div class="col-sm-8 offset-sm-2">
                                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. .</p>
                                                    <small>Someone famous</small>
                                                </div>
                                            </div>
                                        </blockquote>
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>

                                <!-- Bottom Carousel Indicators -->
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel" data-slide-to="0" class="active">
                                    </li>
                                    <li data-target="#carousel" data-slide-to="1">
                                    </li>
                                    <li data-target="#carousel" data-slide-to="2">
                                    </li>
                                </ol>
                                <!-- Carousel Buttons Next/Prev -->

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@include file="footer.jsp"%>
    <%@include file="scriptIncludes.jsp"%>
</body>
</html>
