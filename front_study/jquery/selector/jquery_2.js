$(function(){
    $("button").click(function(){
        $("[href]").css("background-color","gold");
    })
})
$(function(){
    $("#btn2").click(function(){
        $("a[href='http://daum.net']").css("background-color","red");
    })
})