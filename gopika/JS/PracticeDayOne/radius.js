// const radius = [1,2,3]
// area , circumference , diameter
const radius = [1, 2, 3, 4, 9];
const two = 2;

function calculate(values, operation) {
  const resultSet =[];
  values.forEach((element) => {
    const value = operation(element);
    // resultSet=[...resultSet,Number(value.toFixed(2))];
    resultSet.push(Number(value.toFixed(2)));
  });
  return resultSet;
}
function area(radius) {
  return Math.PI * radius ** two;
}
function circumference(radius) {
  return two * Math.PI * radius;
}
function diameter(radius) {
  return two * radius;
}

console.log("AREA           > ",calculate(radius, area));

console.log("CIRCUMFERENCE  > ",calculate(radius, circumference));

console.log("DIAMETER       > ",calculate(radius, diameter));

