$(function(){
    $("#btn").click(function(){
        let display = $("p").css("display");
        let p_tag = $("p");
        if(display == "none"){
                    p_tag.show();
        }else{
            p_tag.hide();
        }
        
    });
    $("p").mouseenter(function () { 
        $(this).css("background-color","gray");
    });
    $("p").mouseleave(function () { 
        $(this).css("background-color","white");
    });
    $("p").mousedown(function () { 
        $(this).css("background-color","gold");
    });
    $("p").mouseup(function () { 
        $(this).css("background-color","pink");
    });
    $("p").hover(function () {
            $(this).css("font-size","1.2em");
        }, function () {
            $(this).css("font-size","1em");
        }
    );
});