// async function* foo() {
//     yield await Promise.resolve('a');
//     yield await Promise.resolve('b');
//     yield await Promise.resolve('c');
//   }
  
//   let str = '';
  
//   async function generate() {
//     for await (const val of foo()) {
//       str = str + val;
//     }
//     console.log(str);
//   }
  
//   generate();

// a promise
let promise = new Promise(function (resolve, reject) {
    setTimeout(function () {
        console.log("insettimout");
    resolve('Promise----resolved'),reject("rejected")}, 400); 
});

// async function
async function asyncFunc() {

    console.log("hello3");
    // wait until the promise resolves 
    let result = await promise; 
    console.log("print result");
    console.log(result);
    console.log('out');

    return result;
}

// calling the async function
console.log("hello");
console.log("asynfun ",asyncFunc()," out val");
console.log("hello2");

// // simple promise
// function getData() {
//     return new Promise((resolve, reject) => {
//       setTimeout(() => {
//         const data = [1, 2, 3, 4];
//         if (data.length > 0) {
//           resolve(data);
//         } else {
//           reject('No data found.');
//         }
//       }, 2000);
//     });
//   }
  
//   getData()
//     .then(data => console.log(data))
//     .catch(error => console.error(error));

// chained promise

function getData() {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const data = null;
        if (data?.length > 0) {
          resolve(data);
        } else {
          reject('No data found.');
        }
      }, 200);
    });
  }
  
  function processData(data) {
    return new Promise((resolve, reject) => {
      setTimeout(() => {
        const processedData = data.map(item => item * 2);
        if (processedData.length > 0) {
          resolve(processedData);
        } 
        else {
          reject('Error processing data.');
        }
      }, 200);
    });
  }
  
  getData()
    .then(data => processData(data))
    .then(processedData => console.log(processedData))
    .catch(error => console.error(error));
  
  

