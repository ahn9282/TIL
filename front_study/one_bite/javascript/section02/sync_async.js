 console.log(1);

 setTimeout(() => {
    console.log(2);

 }, 3000);

 console.log(3);

 function add(a,b, callback) {
    setTimeout(() => {
        const sum = a + b;
        console.log(sum);
        callback(sum);
    }, 3000);
 }

 add(1,2, (value) => {
    console.log('value is ' + value  );
 });

 function orderFood (callback) {
    setTimeout(() => {
        const food = "치킨";
        callback(food);
    }, 3000);
 }

 function coolDownFood (food, callback) {
    setTimeout(() => {
        const coolDownedFood = `식은 ${food}`;
        callback(coolDownedFood);
    }, 1500);
 }

 function freezeFood (food, callback) {
    setTimeout(() => {
        const freezedFood = `냉동된 ${food}`;
        callback(freezedFood)
    }, 3000);
 }

 orderFood((value) => {
    console.log(value);
    coolDownFood(value, (value) => {
        console.log(value);
        freezeFood(value, (value) => {
            console.log(value);
        });
    });
 })
