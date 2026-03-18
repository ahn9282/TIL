// 5가지 요소 순회 및 탐색 메서드
// 1. forEach
let arr1 = [1,2,3];

arr1.forEach((item, idx, arr) => {
    console.log(idx, item * 2);
});

let doubledArr = [];

arr1.forEach((item, idx) => {
    doubledArr.push(item * 2);
});
console.log(doubledArr);


// 2. includes
// 배열의 특정 요소가 있는지 확ㅇ니하는 그런 메서드
let arr2 = [1,2,3];
let isInclude = arr2.includes(3);

console.log(isInclude);

// 3. IndexOf
// 특정 요소의 인덱스를 찾아서 반환하는 메서드
let arr3 = [2,2,2];
let index = arr3.indexOf(2);
console.log(index);

// 4. findIndex
// 모든 요소를 순회하면서, 콜백함수를 만족하는 그런 특정 요소의 인덱스를(위치를) 반환하는 메서드
// 객체 배열에서 주로 활용 내부 함수를 통해 특정 프로퍼티를 비교하여 골라낼 수 있기 때문
let arr4 = [1,2,3];
const findedIndex = arr4.findIndex((item) => {
    if (item === 2) return true;
});
console.log(findedIndex);
const findedIndex2 = arr4.findIndex((item) => {
    if (item % 2 !== 0) return true;
});
console.log(findedIndex2);

// 5. Find
// 모든 요소를 순회하면서 콜백함수를 만족라는 요소를 찾는데, 요소를 그대로 반환
let arr5 = [
    {name : '안준섭'},
    {name: '이정환'}
];
const finded = arr5.find(
    (item) => {item.name === '안준섭';}
);

console.log(finded);