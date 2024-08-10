// Define a custom `bind()` method on the Function prototype
Function.prototype.myBind = function(thisArg) {
    // Store a reference to the current function
    const fn = this;
  
    // Return a new function that wraps the original function and sets the `this` value
    return function(...args) {
      return fn.apply(thisArg, args);
    }
  };
  
  // Example usage
  const person = {
    name: 'John',
    sayHi: function() {
      console.log(`Hi, my name is ${this.name}.`);
    }
  };
  
  const sayHi = person.sayHi.myBind(person); // creates a new function with `person` as `this`
  sayHi(); // output: "Hi, my name is John."
  
/* We define a new function called myBind() on the Function.prototype object, so that all functions will inherit this method.

Inside the myBind() function, we first store a reference to the current function using the this keyword, 
which refers to the function that called the myBind() method.

We then create a new function using the return keyword, which will be returned from the myBind() function.
 This new function wraps the original function and sets the this value to the thisArg parameter passed to myBind().

Inside the new function, we use the spread operator (...args) to capture any arguments 
that are passed when the new function is called.

We then call the apply() method on the original function (fn) and pass in the thisArg value as the first argument,
and the args array as the second argument. This sets the this value of the original function to thisArg, 
and passes in any arguments that were captured by the spread operator.

Finally, we return the result of calling the apply() method on the original function, 
with the this value set to thisArg and any arguments passed in through the new function.

In summary, the myBind() method creates a new function that has the same functionality as the original function, 
but with a specific value for this.
 It achieves this by wrapping the original function inside a new function that sets the this value to the thisArg parameter, 
 and then calling the original function using the apply() method
  with the new this value and any arguments passed in through the new function.


 */

// console.log(a);
// console.log(b);
// var a;
// var b;
// console.log(a);


// var a = 10;
// var a = 20;
// console.log(a);

// const a = [1,2];
// a.push(3);
// console.log(a);
// a[0]=2;
// a.pop();
// a.pop();
// a.pop();
// a.pop();
// console.log(typeof null);


// const a = {age : 20};
// a.age = 30;

// console.log(a);
var counter = 10;
console.log(global.counter); // 10


