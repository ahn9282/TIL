// math 모듈
function add (a,b) {
    return a + b;
}

function sub (a,b) {
    return a - b;
}

export default function multiply (a,b) {
    return a * b;
}

export function divide (a, b) {
    return a / b;
}
/* default는 단일
export default function add5 (a) {
    return a + 5;
}
    */

/* 
commonJs 사용
module.exports = {
    add: add,
    sub: sub,
}
    */

export {add, sub};