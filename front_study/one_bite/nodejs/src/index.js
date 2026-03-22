/* 
commonJs 사용

const mathModule = require("./math");

const {add, sub} = require("./math");

console.log(mathModule.add(1,2));
console.log(mathModule.sub(1,2));
onsole.log(add(4,2));
console.log(sub(4,2)); 
*/
//import add5 from "./math.js";
import mul, {add, sub, divide} from "./math.js";
console.log(add(4,2));
console.log(sub(4,2)); 
console.log(mul(4,2)); 
console.log(divide(4,2)); 
//console.log(add5(4)); 

import randomColor from "randomcolor";

const color = randomColor();
console.log(color); 
const color2 = randomColor({    
    luminosity: "light",    hue: "blue",
});
console.log(color2);