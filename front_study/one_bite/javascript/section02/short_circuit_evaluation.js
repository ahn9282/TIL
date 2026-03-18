function returnFalse() {
    return false;
}

function returnTrue () {
    return true;
}

let arr = [1,2,3];

// let one = arr[0];
// let two = arr[1];
// let three = arr[2];

let [one, two, three] = arr;
console.log(one, two, three);

let person = {
    name : "안준섭",
    age : 28,

}

let {
    age: myAge,
    hobby,
    name,
    extra = "hello",
} = person;

const  func = ({name, age, hobby, extra}) => {
    console.log(name, age, hobby, extra);
};
func(person);