const getData = function (){
    const data = {
        name :"안준섭",
        id : "jsa",
    };
    return new Promise((resolve, reject) => {
        setTimeout(()=> {
            return resolve(data);
         }, 1500);
    });
}

const printData = async function(){
    
    const result =  await getData();
    console.log(result);
}

printData();