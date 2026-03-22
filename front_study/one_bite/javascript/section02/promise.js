  const promise = new Promise((resolve, reject) => {
    // 비동기 작업 실행 함수
    //executor

    setTimeout(() => {
        console.log('안녕');
        resolve("success!!");
    },2000);
  });  
  const rejectPromise = new Promise((resolve, reject) => {

    setTimeout(() => {
        console.log('안녕');
        reject("fail...");
    },2000);
  });

console.log(promise);
setTimeout(() => {
    console.log(promise);
}, 3000);
setTimeout(() => {
    console.log(rejectPromise);
}, 3000);

const numberPromise = new Promise((resolve, reject) =>{
    const num = 10;
    if (typeof num === 'number'){
        resolve(num + 10);
    }else {
        reject("num이 숫자가 아님.");
    }
});

//then 메서드 -> 그 후에
//성공으로 resolve 반환 할 경우 resolve 내 인자를 가져와 활용하도록 콜백 가능
// catch : 실패 버전의 then
const thenPromise = numberPromise.then((value) =>{
    console.log(value);
}).catch((error) => {
    console.log(error);
});


// 최종 

const add10 = function(value) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (typeof value ==='number'){
                resolve(value + 10);
            } else {
                reject("숫자가 아님.");
            }
        }, 2000);
    }).then((result) => {
        console.log(result);
    }).catch((error) => {
        console.log(error);
    });
}

const p = add10(13);
const p2 = add10('sk');