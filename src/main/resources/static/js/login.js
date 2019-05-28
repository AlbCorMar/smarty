var header = {
    loadModalLogin: function(){
        $("#loginModal").modal();
    },
    login: function(){
        $.post({
            url: "/Auth/Login",
            data: $("#formLogin").serialize(),
            success: function(json){
                if (json.error!=null){
                    bootbox.alert(json.error);
                } else {
                    location.reload();
                }
            },
            error: function(err){
                bootbox.alert("Error cargar página");
            }
        })
    },
    showDetailUserLoged: function(){
        window.location.href = "/user"
    },
    logout: function() {
        $.getJSON({
            url: "/Auth/Logout",
            success: function(json){
                if (json.error!=null){
                    bootbox.alert(json.error);
                } else {
                    location.reload();
                }
            },
            error: function(err){
                bootbox.alert("Error cargar página");
            }
        })
    }
}
$(document).ready(function() {
    $("#login").on("click", function () {header.loadModalLogin(); });
    $("#bottomLogin").on("click", function () { header.login(); });
    $("#showUser").on("click", function () { header.showDetailUserLoged(); });
    $("#logOut").on("click", function () { header.logout(); })
})