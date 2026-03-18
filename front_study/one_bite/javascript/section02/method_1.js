// 6가지의 요소 조작 메서드
// 1. push
let arr1 = [1, 2, 3, 4];
const newLength = arr1.push(5, 6, 7);
console.log(arr1);
console.log(newLength);

// 2. pop
// 배열의 맨 뒤 요소를 제거 후 반환
let arr2 = [ 1,2,3];
const poppedItem = arr2.pop();
console.log(arr2);
console.log(poppedItem);

// 3. shfit
//배열의 append
let arr3 =[1,2,3];
const shiftedItem = arr3.shift();
console.log(shiftedItem);

// 4. unshift
//배열에 preppend
let arr4 = [1,2,3];
const unshiftedItem = arr4.unshift(0);
console.log(arr4);
console.log(unshiftedItem);

// 5.slice
// 마치 가위처럼 배열의 특정 범위를 잘라내서 새로운 배열로 반환
let arr5 = [1,2,3,4,5];
const sliced = arr5.slice(2,5);
const sliced2 = arr5.slice(2);
const sliced3 = arr5.slice(-1);
console.log(sliced);
console.log(sliced2);
console.log(sliced3);

//6.concat
// 두개의 서로 다른 배열을 이어 붙여서 새로운 배열을 반환
let arr6 = [1,2];
let arr7 = [3,4,5];
let concatedArr = arr6.concat(arr7);
console.log(concatedArr);