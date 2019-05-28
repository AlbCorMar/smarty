var home = {

    urlLoad: function(){
        var sport = $("#sportFilter").val();
        return "/Home/"+sport;
    },
    load: function(){
        $("#table").bootstrapTable("destroy");
        $("#table").bootstrapTable({
            url: home.urlLoad(),
            sidePagination: "server",
            pagination: true,
            pageSize: 10,
            pageList: [10, 20, 30, 50, 'All'],
            locale: "es-ES",
            paginationHAlign: "left",
            paginationDetailHAlign: "right",
            iconSize: "sm",
            buttonsClass: "primary",
            classes: "table",
        });
    },
    numberFormat: function(value, row, index){
        var string = ""
        if (value != null && value >= 0){
            string += "<i>" + value.toFixed(2) + "</i>";
            string += "&nbsp&nbsp";
            string += home.copyPlantilla(row.partido.local, row.partido.visitante, row.valor1,row.valorx,row.valor2,row.probability2,row.probabilityx,row.probability1, row.deporte);
        } else if (value != null && value<0) {
            string += "<i style='color:red'>" + value.toFixed(2) + "</i>";
            string += "&nbsp&nbsp";
            string += home.copyPlantilla(row.partido.local, row.partido.visitante, row.valor1,row.valorx,row.valor2,row.probability2,row.probabilityx,row.probability1 ,row.deporte);
        } else {
            string += "<i class='fas fa-lock fa-sm' title =' " + row.deporte +"' ></i>";
        }
        return string;
    },
    copyPlantilla: function(local, visitante, value1, valuex, value2, prob1, probx, prob2, sport){
        var v = $("#plantillaEnlaceInfo").html();
        v=v.replace("%local%", "'"+local+"'");
        v=v.replace("%visitante%", "'"+visitante+"'");
        v=v.replace("%value1%", value1);
        v=v.replace("%valuex%", valuex);
        v=v.replace("%value2%", value2);
        v=v.replace("%prob1%", prob1!=null?prob1.toFixed(2):prob1);
        v=v.replace("%probx%", probx!=null?probx.toFixed(2):probx);
        v=v.replace("%prob2%", prob2!=null?prob2.toFixed(2):prob2);
        v=v.replace("%sport%", "'"+sport+"'");
        return v;
    },
    showDetail: function (local, visitante, value1, valuex, value2, prob1, probx, prob2, sport ){
        var v = $("#infoModal").html();
        v=v.replace("%local%", local);
        v=v.replace("%visitante%", visitante);
        v=v.replace("%value1%", value1);
        v=v.replace("%valuex%", valuex);
        v=v.replace("%value2%", value2);
        v=v.replace("%prob1%", prob1);
        v=v.replace("%probx%", probx);
        v=v.replace("%prob2%", prob2);
        $("#infoModal").html(v);
        $("#infoModal").modal();
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
    loadSport: function(sport){
        $("#sportFilter").val(sport);
        home.load();
    }
}

$(document).ready(function() {
    home.load();
    $("#football").on("click",function() { home.loadSport("futbol"); })
    $("#tennis").on("click",function() { home.loadSport("tenis"); })
    $("#basketball").on("click",function() { home.loadSport("baloncesto"); })
    $("#handball").on("click",function() { home.loadSport("balonmano"); })
    $("#volleiball").on("click",function() { home.loadSport("voleibol"); })
    $("#baseball").on("click",function() { home.loadSport("beisbol"); })
    $("#rugby").on("click",function() { home.loadSport("rugby"); })
    $("#americaFootball").on("click",function() { home.loadSport("futbol americano"); })
    $("#sportAll").on("click",function() { home.loadSport("All"); })
});