$(document).ready(function () {
    $.ajax({
        type: "post",
        url: "/company/getRenCaishoucang",
        success: function (msg) {
            var msh = msg.data;
            var htm ="";
            for (var i = 0; i < msh.length; i++) {
                htm+= "<div class='rcxinxis'><div class='rcktops'><div class='reclefs'><img src='";
                if(msg.data[i].avatar != null){
                    htm+=msg.data[i].avatar;
                }else {
                    if(msg.data[i].sex  == "男"){
                        htm+="../../company/images/tupian01.png";
                    }else{
                        htm+="../../company/images/tupian02.png";
                    }
                }
                htm+="'/></div><div class='recryous'><div class='clearfix rcvsise'><div class='fl rminsii'>";
                htm+=msg.data[i].name;
                htm+="<span>";
                if(msg.data[i].sex  == "男"){
                    htm+="<img src='../../company/images/biao05.png '>";
                }
                if(msg.data[i].sex  == "女"){
                    htm+="<img src='../../company/images/biao06.png '>";
                }

                htm+=msg.data[i].age;
                htm+="</span></div><div class='fr ciiuss'>";
                htm+=msg.data[i].expectMoney;
                htm+="</div></div><div class='xnxyusie'> ";
                htm+=msg.data[i].jobExperience;
                htm+=" | ";
                htm+=msg.data[i].state;
                htm+=" | ";
                htm+=msg.data[i].hopeCity;
                htm+="</div></div></div><div class='pxbiuss'> <div class='pxlefts'>";
                htm+=msg.data[i].hopeJob;
                htm+="</div><div class='pxyouls'><a href='tel:";
                htm+=msg.data[i].phone;
                htm+="'><img src='../../company/images/biao07.png' /></a></div></div></div>"
            }
            $("#addid").html(htm);
        }
    })
});

function renfan() {
    window.location.href = "/transition/go_wo_de";
}