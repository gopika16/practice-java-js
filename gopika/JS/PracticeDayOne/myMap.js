// Array.prototype.myMap = function(callback) {
//     const resultArray = [];
//     for (let i = 0; i < this.length; i++) {
    //   resultArray.push(callback(this[i], i, this));
//     }
//     return resultArray;
//   };
// const arr = [1,2,5,6,7];
// console.log(arr.myMap(e=>e*2));

Array.prototype.myMap = function(callback) {
    const resultArray = [];
    for (let i = 0; i < this.length; i++) {
        let val = callback(this[i]);
        resultArray.push(val);
    }
    return resultArray;
  };

// const myfun =  e=>e*2;

const arr = [1,2,5,6,7];
// console.log(arr.myMap(myfun))
console.log(arr.myMap(e=>e*2));