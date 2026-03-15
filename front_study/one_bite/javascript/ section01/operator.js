// 1. null 병합 욘산자
// -> 존재 ㄱ값을 추려내는 기능
// null, undefined가 아닌 값을 찾아내는 연산자

let var1;
let var2 = 10;
let var3 = 30;

let var4 = var1 ?? var2;
let var5 = var1 ?? var3;

console.log(var4);
console.log(var5);

// 2. typeof 연산자
// -> 값의 타입을 문자열로 반환하는 기능을 하는 연산자
let var6 = 1;
var6 = "hello";

let t1 = typeof var6;
console.log(typeof t1 === 'string');
console.log(typeof t2 === 'undefined');

// 3. 삼항 연산자
// -> 항을 3개 사용하는 연산자
let var7 = 10;

let res = var7 === 10 ? "짝" : "홀" ;
console.log(res);