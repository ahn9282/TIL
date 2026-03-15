const obj1 = new Object();
const obj2 = {};

let person = {
    name: 'jas',
    age: 30,
    hobby: "운동",
    extra:{},
    10: 20,
};

let name = person.name;
console.log(name);

let age = person['age'];
console.log(age);

let property = "hobby";
const hobby = person[property];
console.log(hobby);

person.job = "developer";
person['favorite'] = 'chicken';
console.log(person.job);
console.log(person.favorite);

delete person.job;

console.log(person['job']);

let result1 = "name" in person;
console.log('person has name property - ', result1);
console.log('person has cat property - ', 'cat' in person);