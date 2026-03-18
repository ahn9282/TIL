let p1 = 1;
let p2 = p1;
p2 = 2;

let o1 = {name:"안준섭"};
let o2 = {...o1};

o2.name = "홍길동";
 
let ob1 = o1;
let ob2 = {...o1};

console.log(o1 === ob1);
console.log(o1 === ob2);
console.log(o1 == ob2);
console.log(JSON.stringify(ob1) == JSON.stringify(ob2));
console.log(JSON.stringify(ob1) == JSON.stringify(o1));