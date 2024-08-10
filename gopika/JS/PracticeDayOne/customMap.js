Array.prototype.myMap = function(callback) {
    const result = [];
    for (let i = 0; i < this.length; i++) {
        const val = callback(this[i]);
        result.push(val);
    }
    return result;
  };

const arr = [1,2,5,6,7];
console.log(arr.myMap(e=>e*3));