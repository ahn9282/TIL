let arr = new Array(3,6,2,9);

arr.sort();
console.log(arr);

Array.prototype.printLength = function(){
  

console.log("length : "+this.length);
}; //이를 보아 length