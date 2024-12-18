$(function(){
    $("button").click(function(){
        $("ul li:last-child").css("background-color","gold");
        $("ul li:first-child").css("background-color","red");
        $("ul li:first").css("background-color","blue");
    })
})
