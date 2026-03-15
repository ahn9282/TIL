

console.log(getArea(5, 6));
console.log(getArea());
console.log(getArea(0, 0));


// 호이스팅 코드 아래 선언문을 끌어올려서 사용한다. <- 호이스팅
function getArea (width = 10, height = 20){
    let area = width * height;

    return area;
}

const _a = function() {
    console.log("functionA");
}
const _func = function(param) {

    function _innerfunc (){
        console.log("inner function!!");
    }

    console.log("function" + param);
    _innerfunc();
    
    const _arrowFunc = (param) => {
        console.log("arrow function" + param);
    };
    _arrowFunc(param);
}


_func(5);

const _main = function (callback) {
    callback(param);
} 

let param = 10
const _callback =  () => {
    console.log(param);
}

_main(_callback);

const repeat = function(count){
    for (let idx = 1; idx <= count; idx++){
        console.log(idx);
    }
}

const repeatDouble = function(count){
    for (let idx = 1; idx <= count; idx++){
        console.log(idx * 2);
    }
}

repeat(5);
repeatDouble(5);