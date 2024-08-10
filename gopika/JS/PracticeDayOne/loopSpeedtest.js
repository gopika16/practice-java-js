
console.time('for');
for(let item = 0; item < 50000; item++) {
    // console.log(item);
}
console.timeEnd('for');

// for: 528.94091796875 ms


const arr1 = [...Array(50000).keys()];
console.time('forEach');
arr1.forEach(item => {
    // console.log(item);
});
console.timeEnd('forEach');

// forEach: 574.110107421875 ms

const arr2 = [...Array(50000).keys()];
console.time('forOf');
for(const item of arr2) {
    // console.log(item);
}
console.timeEnd('forOf');

// forOf: 535.580322265625 ms


