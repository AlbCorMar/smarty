<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="linkIncludes.jsp"%>
        <title>Historico</title>
    </head>
    <body>
        <%@include file="header.jsp"%>
            <!-- LOADER -->
        <%--<div id="preloader">
            <img class="preloader" src="images/loading-img.gif" alt="">
        </div>--%>
        <section>
            <div class="inner-information-text">
                <div class="container">
                    <h3><s:message code="home.titleHome"/></h3>
                    <ul class="breadcrumb">
                        <li class="active"><s:message code="navBar.Home"/></li>
                    </ul>
                </div>
            </div>
        </section>

        <section id="contant" class="contant main-heading team">
            <div class="aboutus">
                <div class="container">
                    <div class="contact">
                        <br class="container">
                            <div id="toolbar" class="row">
                                <div class="container">
                                    <div class="col-md-12">
                                        <div class="columns columns-center btn-group float-center">
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="football"
                                                    title ="<s:message code="Home.Sport.Football"/>">
                                                <i class="fas fa-futbol fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="tennis"
                                                    title ="<s:message code="Home.Sport.Tenis"/>">
                                                <i class="fas fa-tennis-ball fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="basketball"
                                                    title ="<s:message code="Home.Sport.Basketball"/>">
                                                <i class="fas fa-basketball-ball fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="handball"
                                                    title ="<s:message code="Home.Sport.Handball"/>">
                                                <i class="fal fa-futbol fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="volleiball"
                                                    title ="<s:message code="Home.Sport.Volleiball"/>">
                                                <i class="fas fa-volleyball-ball fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="baseball"
                                                    title ="<s:message code="Home.Sport.Baseball"/>">
                                                <i class="fas fa-baseball fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="rugby"
                                                    title ="<s:message code="Home.Sport.rugby"/>">
                                                <i class="fas fa-football-ball fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="americaFootball"
                                                    title ="<s:message code="Home.Sport.AmericaFootball"/>">
                                                <i class="fas fa-football-helmet fa-w-16 fa-2x"></i>
                                            </button>
                                            <button class="btn btn-primary btn-sm facebook" type="button" id="sportAll">
                                                <s:message code="Home.Sport.All"/>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </br>
                            <div class="row">
                                <div class="col-md-12">
                                    <input id = "sportFilter" type="hidden" value="All"/>
                                    <table id="table" class="table table-condensed">
                                        <thead>
                                        <tr>
                                            <th data-field="idResultado" data-visible="false"><s:message code="view.idResult"/></th>
                                            <th data-field="deporte" data-formatter="home.deporteFormat" data-sortable="true"><s:message
                                                    code="view.sport"/></th>
                                            <th data-field="partido.idPartido" data-visible="false"><s:message code="view.idMatch"/></th>
                                            <th data-field="partido.local" data-sortable="true"><s:message code="view.local"/></th>
                                            <th data-field="partido.visitante" data-sortable="true"><s:message code="view.visitor"/></th>
                                            <th data-field="partido.fecha" data-sortable="true" data-visible="false"><s:message code="view.date"/></th>
                                            <th data-field="valor1" data-formatter="home.numberFormat" data-sortable="true"
                                                data-visible="false"><s:message code="view.value1"/></th>
                                            <th data-field="valorx" data-formatter="home.numberFormat" data-sortable="true"
                                                data-visible="false"><s:message code="view.valuex"/></th>
                                            <th data-field="valor2" data-formatter="home.numberFormat" data-sortable="true"
                                                data-visible="false"><s:message code="view.value2"/></th>
                                            <th data-field="probability1" data-sortable="true"
                                                data-visible="false"><s:message code="view.prob1"/></th>
                                            <th data-field="probabilityx" data-sortable="true"
                                                data-visible="false"><s:message code="view.probx"/></th>
                                            <th data-field="probability2" data-sortable="true"
                                                data-visible="false"><s:message code="view.prob2"/></th>
                                            <th data-field="ev" data-formatter="home.numberFormat" data-sortable="true"><s:message
                                                    code="view.ev"/></th>

                                            <th data-field="casaApuesta" data-formatter="home.casaApuestaFormat" data-sortable="true">
                                                <s:message code="view.house"/></th>
                                        </tr>
                                        </thead>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
        <div id="plantillaEnlaceInfo" style="display:none">
            <a href="#" style="color: #222;" onclick="home.showDetail(%local%, %visitante%, %value1%, %valuex%, %value2%, %prob1%, %probx%, %prob2%, %sport%)">
                <i class='fas fa-info-circle'></i>
            </a>
        </div>
        <div id="infoModal" class ="modal fade" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content modal-lg">
                    <div class="modal-header">
                            <div clas="container">
                                <div class="row justify-content-center">
                                    <h2 ><s:message code="Home.Detail"/></h2>
                                </div>
                                <div class="row justify-content-center">
                                    <h3 style="color: red; padding-left: 60px"> %local% vs %visitante%</h3>
                                </div>
                            </div>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">&times;</button>
                    </div>
                    <div class="modal-body">
                        <table id="tableProbability" class="table table-condensed">
                            <thead>
                                <tr>
                                    <th><s:message code="view.value1"/></th>
                                    <th id="vx"><s:message code="view.valuex"/></th>
                                    <th><s:message code="view.value1"/></th>
                                    <th><s:message code="view.prob1"/></th>
                                    <th id="px"><s:message code="view.probx"/></th>
                                    <th><s:message code="view.prob2"/></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>%value1%</td>
                                    <td id="cvx">%valuex%</td>
                                    <td>%value2%</td>
                                    <td>%prob1%</td>
                                    <td id="cpx">%probx%</td>
                                    <td>%prob2%</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp"%>
        <%@include file="scriptIncludes.jsp"%>
        <script src="/js/home.js" type="text/javascript" charset="utf-8"></script>
    </body>
</html>