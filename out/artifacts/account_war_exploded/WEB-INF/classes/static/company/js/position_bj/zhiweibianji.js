function ZwMc() {
    window.location.href="/transition/zwmingCheng";
}
function zhiweifuli() {
    window.location.href="/transition/zhiwei_fuli";
}
function zhiweimiaoshu() {
    window.location.href="/transition/zhiwei_miaoshu";
}
function xuanzezhiwei() {
    window.location.href="/transition/dianpu_zhiweixuanze";
}
$(document).ready(function() {
    var position_id = sessionStorage.getItem("position_id");
    if(position_id != null && position_id!=''&& position_id !=""){
        sessionStorage.setItem("positionid",sessionStorage.getItem("position_id"));
        sessionStorage.setItem("position_id","");
    }
    var zwlx = sessionStorage.getItem("zwlx");
    var zwmc = sessionStorage.getItem("zwmc");
    var yx = sessionStorage.getItem("yx");
    var jyyq = sessionStorage.getItem("jyyq");
    var xbyq = sessionStorage.getItem("xbyq");
    var nlyq = sessionStorage.getItem("nlyq");
    var zwfl = sessionStorage.getItem("LLLLzwfl");
    var zwms = sessionStorage.getItem("zwms");
    if(zwlx !="" && zwlx !='' && zwlx !=undefined){
        $("#trigger1").html(zwlx);
    }
    if(zwmc !="" && zwmc !='' && zwmc !=undefined){
        $("#zwmc").html(zwmc);
    }
    if(yx !="" && yx !='' && yx !=undefined){
        $("#trigger2").html(yx);
    }
    if(jyyq !="" && jyyq !='' && jyyq !=undefined){
        $("#trigger3").html(jyyq);
    }
    if(xbyq !="" && xbyq !='' && xbyq !=undefined){
        $("#trigger4").html(xbyq);
    }
    if(nlyq !="" && nlyq !='' && nlyq !=undefined){
        $("#trigger5").html(nlyq);
    }
    if(zwfl !="" && zwfl !='' && zwfl !=undefined){
        var fl = zwfl.substring(0,13)+"...";
        $("#zwfl").html(fl);
    }
    if(zwms !="" && zwms !='' && zwms !=undefined){
        var ms = zwms.substring(0,13)+"...";
        $("#zwms").html(ms);
    }
})
function yulan() {
    sessionStorage.setItem("YuLanOrXiangQing","yulan");
    sessionStorage.setItem("YuLanOrXiangQing_xg","xiugai")
    window.location.href="/transition/zhiwei_xiangqing";
}
function fabuZhiwei() {
    var zwlx = sessionStorage.getItem("zwlx");
    var zwmc = sessionStorage.getItem("zwmc");
    var yx = sessionStorage.getItem("yx");
    var jyyq = sessionStorage.getItem("jyyq");
    var xbyq = sessionStorage.getItem("xbyq");
    var nlyq = sessionStorage.getItem("nlyq");
    var zwfl = sessionStorage.getItem("LLLLzwfl");
    var zwms = sessionStorage.getItem("zwms");
    var positionId = sessionStorage.getItem("positionid");
    console.log(positionId);
    $.ajax({
        url:"/company/AddZhiwei",
        type:"POST",
        data:{zwlx:zwlx,zwmc:zwmc,yx:yx,jyyq:jyyq,xbyq:xbyq,nlyq:nlyq,zwfl:zwfl,zwms:zwms,id:positionId},
        success:function (msg) {
            console.log(msg);
            sessionStorage.setItem("positionid","");
            window.location.href="/transition/zhiweiguanlirenzhneg";
        }
    })

}
