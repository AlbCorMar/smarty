var usuarios = {
    load: function(){
        var s = $("#userRegistred").val();
        if (s!=""){
            $.getJSON({
                url: "/User/Get/"+ $("#userRegistred").val(),
                success: function(json){
                    if (json.error!=null){
                        bootbox.alert(json.error);
                    }
                    $("#idUsuario").val(json.data.idUsuario);
                    $("#usernameForm").val(json.data.userName);
                    $("#showPassword").hide();
                    $("#showRepitPassword").hide();
                    $("#firstName").val(json.data.firstName);
                    $("#lastName").val(json.data.lastName);
                    $("#email").val(json.data.email);
                    $("#address").val(json.data.address);
                    $("#city").val(json.data.city);
                    $("#country").val(json.data.country);
                    $("#postalCode").val(json.data.postalCode);
                    $("#aboutMe").val(json.data.aboutMe);
                    usuarios.getRoles(json.data.roles);
                },
                error: function(){
                    bootbox.alert("Error");
                }
            });
        }
    },
    getRoles: function (roles){
        for (var i=0; i<roles.length; i++){
            if ("ROLE_ADMIN" === roles[i].role){
                $("#roleAdmin").prop("checked", true);
            }
            if ("ROLE_USER" === roles[i].role){
                $("#roleAdmin").prop("checked", true);
            }
        }
    },
    leerUsuario: function(username){
        $.getJSON({
            url: "/User/Get/{"+username+"}",
            success: function(json){
                if (json.error!=null){
                    bootbox.alert(json.error);
                }
                /*falta deserializar valores*/
            },
            error: function(){
                bootbox.alert("Error");
            }
        })
    },
    enviarForm: function(){
        $.post({
            url: "/User/Save",
            data: $("#userForm").serialize(),
            success: function(json){
                if(json.error!=null){
                    bootbox.alert(json.error);
                } else {
                    bootbox.alert("<p>success</p>")
                }

            },
            error: function(er){
                var errors = er.responseJSON.errors;
                if (errors != null || errors != undefined){
                    var string = "";
                    for (var i=0; i<errors.length;i++){
                        string = string + "<p>"+ errors[i].defaultMessage + "</p>";

                    }
                    bootbox.alert(string);
                }else{
                    bootbox.alert(er.error);
                }

            }
        })
    },
    borrarUsuario: function(){
        $.getJSON({
            url: "/User/Delete/{"+ $("#usernameForm") +"}",
            succes: function(json){
                if (json.error!=null){
                    bootbox.alert(json.error);
                }
                window.location.href="/home";
            },
            error: function(){
                bootbox.alert("Error");
            }
        })
    },
    back: function(){
        window.history.back();
    }
}
$(document).ready(function(){
    usuarios.load();
})

$("#btnSaveForm").on("click", function(){ usuarios.enviarForm(); })
$("#btnDeleteForm").on("click", function(){ usuarios.borrarUsuario(); })
$("#btnBackForm").on("click", function(){ usuarios.back(); })







