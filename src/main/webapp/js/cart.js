/*
/!**
 * Created by Andrey on 26.07.2017.
 *!/
function add(num,name,img,bImg,desc,price,consist,width,height) {

    $.ajax({
        method: "POST",
        url: "/cart",
        data:{num:num, name:name,img:img,
            bImg:bImg,desc:desc,price:price,
            consist:consist,width:width,height:height,
            type_request:"add"},
        success: function () {
            alert("yeah!");
        }
    });
}
*/


function del(product) {

    $.ajax({
        method: "POST",
        url: contextPath + "/cart",
        data:{product:product, type_request:"del"},
        success: function (result) {
            switch (result){
                case "SUCCESS":{
                    window.location.href = contextPath + '/cart';
                    break;
                }
                default: {
                    break;
                }
            }
        }
    });
}

function add(product,infoSuccess,infoBig,infoIncorrect) {

    var quantity = document.getElementById("quantity").value;
    if(quantity >= 1 && quantity <= 3){
        $.ajax({
            method: "POST",
            url: contextPath + "/cart",
            data:{product:product, quantity:quantity,
                type_request:"add"},
            success: function (result) {
                switch (result){
                    case "NON_AUTHORIZED":
                        window.location.href = contextPath + '/auth';
                        break;
                    case "SUCCESS":
                        //alert("product added to cart");
                        document.getElementById("res").innerHTML =
                            "<p style='color:green;'>" + infoSuccess + "</p>";
                           //"${sessionScope.lang['product_in_cart']}";
                        break;
                    case "BIG_QUANTITY": {
                        document.getElementById("res").innerHTML =
                        "<p style='color:darkred;'>" + infoBig + "</p>";
                        break;
                    }
                    case "INCORRECT":{
                        document.getElementById("res").innerHTML =
                            "<p style='color:darkred;'>" + infoIncorrect + "</p>";
                        break;
                    }
                    default:
                        break;
                }
            }
        });
    }else {
        alert("error quantity!");
    }

}