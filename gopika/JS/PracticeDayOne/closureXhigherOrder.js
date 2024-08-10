// const radius = [1,2,3]
// area , circumference , diameter

const values = [1, 2, 3, 4, 9];
const two = 2;

function calculate() {
    return {
      getArea: function(){
        const expression = (element) =>  Math.PI * element ** two;
        return process(expression);
      },
      getCircumference : function(){
        const expression = (element) => two * Math.PI * element;
        return process(expression);
      },
      getDiameter : function(){
        const expression = (element) => two * element;
        return process(expression);
      }
    };
  }

  function process(expression){
    return values.map(expression);
  }

//   function area() {
//     return values.map((element) => (Math.PI * element ** two).toPrecision(5));
//   }
//   function circumference() {
//     return values.map((element) => (two * Math.PI * element).toPrecision(5));
//   }
//   function diameter() {
//     return values.map((element) => two * element);
//   }

  let result = calculate();
  console.log(result.getArea());
  console.log(result.getCircumference());
  console.log(result.getDiameter());


