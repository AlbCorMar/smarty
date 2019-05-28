<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <title>Index</title>
    <%@include file="linkIncludes.jsp"%>
</head>
<body>
<!-- LOADER -->
<%--<div id="preloader">
    <img class="preloader" src="images/loading-img.gif" alt="">
</div>--%>
<%@include file="header.jsp"%>
    <section>
        <div class="inner-information-text">
            <div class="container">
                <h3><s:message code="contact.title"/></h3>
                <ul class="breadcrumb">
                    <li><a href="/home"><s:message code="navBar.Home"/></a></li>
                    <li style="padding: 0px 4px 0px 4px"><a href="">/</a></li>
                    <li class="active"><s:message code="navBar.Contact"/></li>
                </ul>
            </div>
        </div>
    </section>
    <section id="contant" class="contant main-heading team">
        <div class="aboutus">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="full">
                            <h3><s:message code="contact.title"/></h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="contact">
                        <div class="col-md-12">
                            <div class="map">
                                <iframe width="600" height="450" src="https://maps.google.com/maps?width=100%&height=600&hl=es&coord=41.65290593733854,-0.8843994140625001&q=Zaragoza+(Mi%20nombre%20de%20egocios)&ie=UTF8&t=&z=14&iwloc=B&output=embed" frameborder="0" style="border:0" allowfullscreen></iframe>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="contact">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="contact-info">
                                <div class="kode-section-title">
                                    <h3><s:message code="contact.contactInfo"/></h3>
                                </div>
                                <div class="kode-forminfo">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam aliquip..</p>
                                    <ul class="kode-form-list">
                                        <li>
                                            <i class="fa fa-home"></i>
                                            <p><strong><s:message code="contact.contactAddress"/>:</strong> 805 consectetur adipiscing elit, sed do eiusmod tempor</p>
                                        </li>
                                        <li>
                                            <i class="fa fa-phone"></i>
                                            <p><strong><s:message code="contact.contactPhone"/>:</strong>  123 456 7890</p>
                                        </li>
                                        <li>
                                            <i class="fa fa-envelope-o"></i>
                                            <p><strong><s:message code="contact.contactEmail"/>:</strong> Info@sportyleague.com</p>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="contact-us">
                                <form method="post" class="comments-form" id="contactform">
                                    <ul>
                                        <li><input type="text" id="name" name="name" class="required" placeholder=<s:message code="contact.contactName"/>></li>
                                        <li><input type="text" id="email" name="email" class="required email" placeholder=<s:message code="contact.contactEmail"/>></li>
                                        <li><input type="text" name="address" id="address" placeholder=<s:message code="contact.contactAddress"/>></li>
                                        <li><textarea name="message" id="message" placeholder=<s:message code="contact.contactMessage"/>></textarea></li>
                                        <li><input class="thbg-color" type="submit" value=<s:message code="contact.contactSend"/>></li>
                                    </ul>
                                    <div class="hidden-me" id="contact_form_responce">
                                        <p></p>
                                    </div>
                                </form>
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
