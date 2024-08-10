// // const array1 = [5, 1, 8, 130, 44];

// // const found = array1.find(element => element > 10);

// // console.log(found);

// const words = ['spray', 'limit', 'elite', 'exuberant', 'destruction', 'present'];

// const result = words.filter(word => word.length > 6);

// console.log(result);
// // Expected output: Array ["exuberant", "destruction", "present"]

// const isBelowThreshold = (currentValue) => currentValue < 40;

// const array1 = [1, 0, 39, 88,29, 355,10, 13];

// console.log(array1.every(isBelowThreshold));

// const array12 = ['a', 'b', 'c'];

// const iterator1 = array12.entries();

// console.log(iterator1.next().value);
// // Expected output: Array [0, "a"]

// console.log(iterator1.next().value);
// // Expected output: Array [1, "b"]


// const isLargeNumber = (element) => element > 13;

// console.log(array1.findIndex(isLargeNumber));

// const found = array1.findLast((element) => element > 45);

// console.log(found);
// const isLargeNumber2 = (element) => element > 45;

// console.log(array1.findLastIndex(isLargeNumber2));

// const arr1 = [0, 1, 2, [3, 4]];

// console.log(arr1.flat());
// // Expected output: Array [0, 1, 2, 3, 4]

// const arr2 = [0, 1, 2, [[[3, 4]]]];

// console.log(arr2.flat(2));
// // Expected output: Array [0, 1, 2, Array [3, 4]]

// const arr1 = [1, 2, [3], [4, 5], 6, []];

// const flattened = arr1.flatMap(num => num);

// console.log(flattened);
// const array1 = ['a', 'b', 'c'];

// array1.forEach(element => console.log(element));

// console.log(Array.from('foo'));
// // Expected output: Array ["f", "o", "o"]

// console.log(Array.from([1, 2, 3,4,5,6,7], x => x + x));



// const array1 = [1, 2, 3];

// console.log(array1.includes(2));
// // Expected output: true

// const pets = ['cat', 'dog', 'bat'];

// console.log(pets.includes('cat'));
// // Expected output: true

// console.log(pets.includes('at'));
// // Expected output: false
// console.log(pets.indexOf('cat'));
// Expected output: -1

// const elements = ['Fire', 'Air', 'Water'];

// console.log(elements.join());
// // Expected output: "Fire,Air,Water"

// console.log(elements.join(''));
// // Expected output: "FireAirWater"

// console.log(elements.join('-'));
// // Expected output: "Fire-Air-Water


// const array1 = ['a', 'b', 'c','a', 'b', 'c'];
// const iterator = array1.keys();

// for (const key of iterator) {
//   console.log(key);
// }


// const animals = ['Dodo', 'Tiger', 'Penguin', 'Dodo'];

// // console.log(animals.lastIndexOf('Dodo'));
// // Expected output: 3

// console.log(animals.lastIndexOf('Penguin'));
// // Expected output: 1



// const months = ['March', 'Jan', 'Feb', 'Dec'];
// months.sort();
// console.log(months);
// // Expected output: Array ["Dec", "Feb", "Jan", "March"]

// const array1 = [12,3,4,6,76,232,12,5];
// array1.sort();
// console.log(array1);

// const array1 = [1, 'a', new Date('21 Dec 1997 14:12:00 UTC')];
// const localeString = array1.toLocaleString('en', { timeZone: 'UTC' });

// console.log(localeString);

// const array1 = [1, 2, 'a', '1a'];

// console.log(array1.toString());
// // Expected output: "1,2,a,1a"

// const array1 = [1, 2, 3];

// console.log(array1.unshift(4, 5));
// // Expected output: 5

// console.log(array1);
// Expected output: Array [4, 5, 1, 2, 3]




