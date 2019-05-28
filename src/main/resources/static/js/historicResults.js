var historic = {
	urlLoad: function(){
		var sport = $("#sportFilter").val();
		return "/Results/historical/"+sport;
	},
	loadDataPagination: function(){
		$("#table").bootstrapTable("destroy");
		$("#table").bootstrapTable({
			url: historic.urlLoad(),
			sidePagination: "server",
			pagination: true,
			pageSize: 5,
			pageList: [10, 20, 50, 100, 'All'],
			locale: "es-ES",
			paginationHAlign: "left",
			paginationDetailHAlign: "right",
			showColumns: true,
			showRefresh: true,
			showFullscreen: true,
			showToggle: true,
			iconSize: "sm",
			buttonsClass: "primary",
			showExport: true,
			toolbar: "#toolbar",
			exportTypes: ['json', 'xml', 'csv', 'txt', 'sql', 'excel', 'pdf'],
			classes: "table",
		});
	},
	numberFormat: function(value, row, index){
		var string = ""
		if (value != null && value >= 0){
			string += "<i>" + value.toFixed(2) + "</i>";
		} else if (value != null && value<0) {
			string += "<i style='color:red'>" + value.toFixed(2) + "</i>";
		} else {
			string += "<i class='fas fa-lock fa-sm' title =' " + row.deporte +"' ></i>";
		}
		return string;
	},
	deporteFormat: function(value, row, index){
		var string = "";
		switch (row.deporte){
		case "futbol":
			string += "<i class='fas fa-futbol fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "tenis":
			string += "<i class='fas fa-tennis-ball fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "baloncesto":
			string += "<i class='fas fa-basketball-ball fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "balonmano":
			string += "<i class='fal fa-futbol fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "voleibol":
			string += "<i class='fas fa-volleyball-ball fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "beisbol":
			string += "<i class='fas fa-baseball fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "rugby":
			string += "<i class='fas fa-football-ball fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		case "futbol americano":
			string += "<i class='fas fa-football-helmet fa-sm' title =' " + row.deporte +"' ></i>";
			break;
		default:
			
		}
		return string;
	},
	casaApuestaFormat: function(value, row, index){
		var string = "";
		switch (row.casaApuesta){
		case "Bwin":
			string += "<img src='/img/BwinCom.svg' width='60' height='18' title='BWIN'>";
			break;
		case "888Sport":
			string += "<img src='/img/888sport-logo.png' width='60' height='18' title='888SPORT'>";
			break;
		default:

		}
		return string;
	},		
	botonesFormat: function(value, row, index){
		return "<i onclick='quiz.showDetailMacth("+ row.idPregunta + ")' " +
					" class='fa fa-edit fa-sm' style='cursor:pointer' title='Detalle'>" +
				"</i> " +
				"<i onclick='quiz.deleteMacth(" + row.idPregunta + ")' " +
					" class='fa fa-trash fa-sm' style='cursor:pointer' title='Borrar'> " +
				"</i>";
	},
	loadSport: function(sport){
		$("#sportFilter").val(sport);
		historic.loadDataPagination();
	},
	activateRemoveBotton: function(){
		var ids = $.map($("#table").bootstrapTable("getSelections"), function(row){
			return row.idResultado;
		});
		if (ids>0){
			$("#buttonRemove").attr("class", "btn btn-primary btn-sm");
		}else{
			$("#buttonRemove").attr("class", "btn btn-primary disabled btn-sm");
		}
	},
	remove: function(){
		//lo quita de la tabla pero no lo elimina de la base de datos
		var ids = $.map($("#table").bootstrapTable("getSelections"), function(row){
			return row.idResultado
		})
		$("#table").bootstrapTable("remove", {
			field: "idResultado",
			values: ids
		})
	}
}

$(document).ready(function() {
	historic.loadDataPagination();
	$("#football").on("click",function() { historic.loadSport("futbol"); })
	$("#tennis").on("click",function() { historic.loadSport("tenis"); })
	$("#basketball").on("click",function() { historic.loadSport("baloncesto"); })
	$("#handball").on("click",function() { historic.loadSport("balonmano"); })
	$("#volleiball").on("click",function() { historic.loadSport("voleibol"); })
	$("#baseball").on("click",function() { historic.loadSport("beisbol"); })
	$("#rugby").on("click",function() { historic.loadSport("rugby"); })
	$("#americaFootball").on("click",function() { historic.loadSport("futbol americano"); })
	$("#sportAll").on("click",function() { historic.loadSport("All"); })
	$("#table").on("check.bs.table", function (){
		historic.activateRemoveBotton() });
	$("#table").on("uncheck.bs.table", function (){
		historic.activateRemoveBotton() });
	$("#buttonRemove").on("click",function(){ historic.remove()	})
});