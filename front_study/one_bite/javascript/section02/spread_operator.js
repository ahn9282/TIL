let arr1 = [1,2,3];
let arr2 = [4,5,6];

let obj1 = {
    a:1,
    b:2,
}
let obj2 = {
    ...obj1,
    c:3,
    d:4,
}
console.log(obj2);

function funcA(p1,p2,p3){
    console.log(p1,p2,p3);
}

funcA(...arr1);