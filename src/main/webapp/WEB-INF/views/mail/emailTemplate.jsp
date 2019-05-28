<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../linkIncludes.jsp"%>
    <title>Title</title>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h3 >"<s:message code="Email.Change.Login"/>"</h3>
            </div>
        </div>
        </br>

            <input type="hidden" name="idUsuario" />
            <div class="row">
                <div class="form-group">
                    <label for="passwordForm"><s:message code="user.password"/></label>
                    <input type="text" class="form-control form-control-lg" name="password" id="passwordForm"
                           required="true"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group" id="showRepitPassword">
                    <label for="repitPassword"><s:message code="user.repitPassword"/></label>
                    <input type="text" id="repitPassword" name="repitPassword"
                           class="form-control" required="true"/>
                </div>
            </div>
        <div class="form-group">
            <button class="btn btn-success btn-lg center" id="bottomSave"><s:message code="btn.Save"/></button>
        </div>
    </div>
    <%@include file="../footer.jsp"%>
    <%@include file="../scriptIncludes.jsp"%>
    <script src="/js/emailTemplates.js" type="text/javascript"></script>
</body>
</html>
