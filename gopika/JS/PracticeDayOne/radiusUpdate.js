// const radius = [1,2,3]
// area , circumference , diameter

const radius = [1, 2, 3, 4, 9];
const two = 2;

function calculate(values) {
    return {
      area: function() {
        return values.map((element) => (Math.PI * element ** two).toPrecision(5));
      },
      circumference: function() {
        return values.map((element) => (two * Math.PI * element).toPrecision(5));
      },
      diameter: function() {
        return values.map((element) => two * element);
      }
    };
  }

  let result = calculate(radius);
  console.log(result.area());
  console.log(result.circumference());
  console.log(result.diameter());
