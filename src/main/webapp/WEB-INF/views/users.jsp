<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="linkIncludes.jsp"%>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
    <section>
        <div class="inner-information-text">
            <div class="container">
                <h3><s:message code="user.titleCab"/></h3>
                <ul class="breadcrumb">
                    <li><a href="/home"><s:message code="navBar.Home"/></a></li>
                    <li style="padding: 0px 4px 0px 4px"><a href="">/</a></li>
                    <li class="active"><s:message code="navBar.User"/></li>
                </ul>
            </div>
        </div>
    </section>
    <section id="contant" class="contant main-heading team">
        <div class="aboutus">
            <div class="container">
                <div class="contact">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="contact-info">
                                <form id="userForm">
                                    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden"/>
                                    <input type="hidden" name="idUsuario" id="idUsuario"/>
                                    <div class="row">
                                        <div class="col-md-4 pr-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.username"/></label>
                                                <input id="usernameForm" name="userName" type="text" class="form-control"
                                                       required="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-md-1">
                                            <div class="form-group" id="showPassword">
                                                <label><s:message code="user.password"/></label>
                                                <input id="passwordForm" name="password" type="text" class="form-control"
                                                       required="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-md-1">
                                            <div class="form-group" id="showRepitPassword">
                                                <label><s:message code="user.repitPassword"/></label>
                                                <input id="repitPassword" name="repitPassword" type="email"
                                                       class="form-control" required="true"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6 pr-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.firstName"/></label>
                                                <input id="firstName" name="firstName" type="text"
                                                       class="form-control" required="true"/>
                                            </div>
                                        </div>
                                        <div class="col-md-6 pl-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.lastName"/></label>
                                                <input id="lastName" name="lastName" type="text" class="form-control"
                                                       required="true"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12 pr-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.email"/></label>
                                                <input id="email" name="input" type="email" class="form-control" required="true"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label><s:message code="user.address"/></label>
                                                <input id="address" name="address" type="text" class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4 pr-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.city"/></label>
                                                <input id="city" name="city" type="text" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 px-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.country"/></label>
                                                <input id="country" name="country" type="text" class="form-control"/>
                                            </div>
                                        </div>
                                        <div class="col-md-4 pl-md-1">
                                            <div class="form-group">
                                                <label><s:message code="user.postalCode"/></label>
                                                <input id="postalCode" name="postalCode" type="number"
                                                       class="form-control"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label><s:message code="user.aboutMe"/></label>
                                                <textarea id="aboutMe" name="aboutMe" rows="4" cols="80"
                                                          class="form-control"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <label><s:message code="user.roles"/></label>
                                        </div>

                                        <div class="col-md-4">
                                            <input type="checkbox" name="getroles" id="roleAdmin"  value="ROLE_ADMIN"/>
                                            <label><s:message code="user.roleAdmin"/></label>
                                        </div>
                                        <div class="col-md-4">
                                            <input type="checkbox" name="getroles"  value="ROLE_USER"/>
                                            <label><s:message code="user.roleUser"/></label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-top: 10px">

                        <div class="col-md-4 center">
                             <button id="btnSaveForm" type="button" class="btn btn-fill btn-primary"><s:message code="btn.Save"/></button>
                        </div>
                        <div class="col-md-4 center">
                            <sec:authorize access="isAuthenticated()">
                                <button id="btnDeleteForm" type="button" class="btn btn-fill btn-primary"><s:message code="btn.Delete"/></button>
                            </sec:authorize>
                        </div>
                        <div class="col-md-4 center">
                            <button id="btnBackForm" type="button" class="btn btn-fill btn-primary"><s:message code="btn.Back"/></button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <%@include file="footer.jsp"%>
    <%@include file="scriptIncludes.jsp"%>
    <script src="/js/usuario.js" type="text/javascript"></script>
</body>
</html>
