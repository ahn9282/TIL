// 1. 묵시적 형 변환
// -> 자바스크립트 엔진이 알아서 형 변환 하는 것

let num = 10;
let str = "20";

const result = num + str;
console.log(result);

// 2. 명시적 형변환
// -> 프로그래머가 형을 변환(내장함수 사용)
let str1 = "10";
let strToNum1 = Number(str1);

let str2 = "10개";
// 에러 발생 
//parseInt() 사용 시
let strToNum2 = parseInt(str2);
console.log(strToNum2);

//숫자 -> 문자열
let num1 = 20;
let numToStr1 = String(num1);
console.log(typeof numToStr1);

