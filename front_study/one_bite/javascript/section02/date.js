let date1 = new Date();

let date2 = new Date("1997-09-14");
let date2_2 = new Date("1997.09.14");
let date2_3 = new Date("1997/09/14");
let date2_4 = new Date("1997/09/14/10:10:10");
let date2_5 = new Date(1997, 1, 23, 23, 59, 59);

// 2. timestamp
// 1970.01.01 부터 몇 ms 가 지났는지를 나타내느 숫자 값
let ts1 = date1.getTime();
console.log(ts1);
let date3 = new Date(ts1);
console.log(date1, date3);


//3. 시간 요소 추출
let year = date1.getFullYear();
let month = date1.getMonth();
let date = date1.getDate();

let hour = date1.getHours();
let minutes = date1.getMinutes();
let seconds = date1.getSeconds();
console.log(
    year,
    month,
    date,
    hour,
    minutes,
    seconds
);

//4. 시간 수정
date1.setFullYear(2023);
date1.setMonth(2);
date1.setDate(30);
date1.setHours(23);
date1.setMinutes(59);
date1.setSeconds(59);
console.log(date1);

// 5. 포맷
console.log(date1.toDateString());
console.log(date1.toLocaleString());