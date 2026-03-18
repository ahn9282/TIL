// 5가지 배열 변형 메서드
// 1. filter
let arr1 = [
    {name:'이정환', hobby:'럭비'},
    {name:'안준섭', hobby:'런닝'},
    {name:'이정섭', hobby:'개발'},
];
const filtered = arr1.filter((item) =>{
    if(item.hobby === '럭비') return true; 
});
console.log(filtered);

// 2. map
// 배열의 모든 요소를 순회하면서, 각각 콜백 함수를 실행하고 그 결과값들을 모아서 새로운 배열로 반환
let arr2 = [1,2,3];
const mapResult1 = arr2.map((item, idx, arr) => {
    console.log(idx, item);
    return item * 2;
});
console.log(mapResult1);

let names = arr1.map((item) => item.name);
console.log(names);

// 3. sort
let arr3 = ["a",'b','c'];
arr3.sort();
console.log(arr3);
let arr4 = [10, 5, 8];
arr4.sort((a, b) => { 
    if (a > b) {
        //b가 a 앞에 와라
        return 1; // 양수 = 변경
    } else if (a < b) {
        //a가 b에 앞에 와라
        return -1;// 음수 = 뒤로 미루기
    }else {
        // 변경 x
        return 0; // 0 = 미동작
    }
});
console.log(arr4);

// 4. toSorted
// 정렬된 새로운 배열을 반환하는 메서드
let arr6 = ["a", "b", "d", "c"];
const sorted = arr6.toSorted();
console.log(arr6);
console.log(sorted);

// 5. join
let arr7 = ["hello", "world", "!!"];
const joined = arr7.join('-');
console.log(joined);
