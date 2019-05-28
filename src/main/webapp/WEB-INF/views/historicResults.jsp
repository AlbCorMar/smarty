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
<section>
	<div class="inner-information-text">
		<div class="container">
			<h3><s:message code="results.titleHistoric"/></h3>
			<ul class="breadcrumb">
				<li><a href="/home"><s:message code="navBar.Home"/></a></li>
				<li style="padding: 0px 4px 0px 4px"><a href="">/</a></li>
				<li class="active"><s:message code="navBar.Historic"/></li>
			</ul>
		</div>
	</div>
</section>
<section id="contant" class="contant main-heading team">
	<div class="aboutus">
		<div class="container">
			<div class="contact">
				<div class="container">
					<div id="toolbar1" class="row">
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
					<div id="toolbar" class="row">
						<div class="col-md-5">
							<input id="buttonRemove" type="button" value="Eliminar" class="btn btn-primary disabled btn-sm" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<input id = "sportFilter" type="hidden" value="All"/>
							<table id="table" class="table table-condensed">
								<thead>
									<tr>
										<th data-field="estado" data-checkbox="true"></th>
										<th data-field="idResultado" data-visible="false"><s:message code="view.idResult"/></th>
										<th data-field="partido.idPartido" data-visible="false"><s:message code="view.idMatch"/></th>
										<th data-field="partido.local" data-sortable="true"><s:message code="view.local"/></th>
										<th data-field="partido.visitante" data-sortable="true"><s:message code="view.visitor"/></th>
										<th data-field="partido.fecha" data-sortable="true"><s:message code="view.date"/></th>
										<th data-field="valor1" data-formatter="historic.numberFormat" data-sortable="true">
											<s:message code="view.value1"/></th>
										<th data-field="valorx" data-formatter="historic.numberFormat" data-sortable="true">
											<s:message code="view.valuex"/></th>
										<th data-field="valor2" data-formatter="historic.numberFormat" data-sortable="true">
											<s:message code="view.value2"/></th>
										<th data-field="probability1" data-formatter="historic.numberFormat" data-sortable="true"
											data-visible="false"><s:message code="view.prob1"/></th>
										<th data-field="probabilityx" data-formatter="historic.numberFormat" data-sortable="true"
											data-visible="false"><s:message code="view.probx"/></th>
										<th data-field="probability2" data-formatter="historic.numberFormat" data-sortable="true"
											data-visible="false"><s:message code="view.prob2"/></th>
										<th data-field="ev" data-formatter="historic.numberFormat" data-sortable="true"><s:message
												code="view.ev"/></th>
										<th data-field="deporte" data-formatter="historic.deporteFormat" data-sortable="true"><s:message
												code="view.sport"/></th>
										<th data-field="casaApuesta" data-formatter="historic.casaApuestaFormat" data-sortable="true">
											<s:message code="view.house"/></th>
										<th data-formatter="historic.botonesFormat" data-width="20"><s:message code="view.actions"/></th>
									</tr>
								</thead>
							</table>
						</div>
					</div>
			</div>
		</div>
	</div>
</section>
	<%@include file="footer.jsp"%>
	<%@include file="scriptIncludes.jsp"%>
	<script src="/js/historicResults.js" type="text/javascript" charset="utf-8"></script>	
</body>
</html>