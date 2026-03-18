let numbers = [1,2,3,4];

for (let i = 0; i < numbers.length; i++) {
    const element = numbers[i];
    console.log(element);
}

let arr2 = [5,6,7,8];

for (const num of arr2) {
    console.log(num);
}


let person = {
    name: "안준섭",
    age: 29,
    hobby: "run",
};

const keys = Object.keys(person);
console.log(keys);

for (const key of keys) {
    const value = person[key];
    console.log(key, value);
}

const values = Object.values(person);
console.log(values);

for (const value in values) {
    console.log(value);
    
}