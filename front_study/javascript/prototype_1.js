
function Mouse(){

    rightClick = function(){
        console.log("딸깍(우)");
    };
    leftClick = function(){
        console.log("딸깎(좌좌)");
    };
    port = "USB";
    MADE_IN="CHINA";
    
};

let myMouse = new Mouse();


Mouse.prototype.brand = "Razor"

