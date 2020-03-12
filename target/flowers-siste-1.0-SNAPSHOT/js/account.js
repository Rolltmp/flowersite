/**
 * Created by Vlad on 27.07.2017.
 */


function changePassword(success,incorrect,match) {

    var pass = document.getElementById("password").value;
    var pass2 = document.getElementById("password_2").value;

    var res = document.getElementById("res_change");

    $.ajax({
       method:"POST",
        url: "/account",
        data:{
            password:pass,
            password2:pass2,
            type_request:"change"
        },
        success: function (result) {
            switch (result){
                case "SUCCESS":{
                    res.innerHTML = "<p style='color:green;'>" + success + "</p>";
                    break;
                }
                case "NOT_MATCH":{
                    res.innerHTML = "<p style='color:darkred;'>" + match + "</p>";
                    break;
                }
                case "NON_AUTHORIZED":{
                    window.location.href = '/auth';
                    break;
                }
                case "INCORRECT":{
                    res.innerHTML = "<p style='color:darkred;'>" + incorrect + "</p>";
                    break;
                }
                case "ERROR":{
                    res.innerHTML = "<p style='color:red;'>" + "Exception. See log" + "</p>";
                    break;
                }
            }
        }
    });

}

function edit(success,incorrect) {

    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;

    var res = document.getElementById("res_update");
    $.ajax({
        method: "POST",
        url: "/account",
        data:{
            name:name,
            phone:phone,
            type_request:"edit"
        },
        success: function (result) {

            switch (result){

                case "SUCCESS":{
                    res.innerHTML = "<p style='color:green;'>" + success + "</p>";
                    break;
                }
                case "INCORRECT":{
                    res.innerHTML = "<p style='color:darkred;'>" + incorrect +"</p>";
                    break;
                }
                case "ERROR":{
                    res.innerHTML = "<p style='color:red;'>" + "Exception. See log" + "</p>";
                    break;
                }
                case "NON_AUTHORIZED":{
                    window.location.href = '/auth';
                    break;
                }
            }
        }
    });

}