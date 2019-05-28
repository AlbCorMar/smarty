var email= {
    enviarForm: function(){
        $.post({
            url: "/User/Save/NewLogin",
            data: $("#form").serialize(),
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
    }
}

$("#bottomSave").on("click", function(){ email.enviarForm(); })