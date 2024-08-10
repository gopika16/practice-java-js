//callback

function makeCoffee(callback){
    setTimeout(()=> {
        console.log("Make coffee");
        callback(coffeeReady);
    },2000);
}
function coffeeReady(){
    console.log("Coffee Ready");

}

makeCoffee(coffeeReady);

console.log("Read Topics");




