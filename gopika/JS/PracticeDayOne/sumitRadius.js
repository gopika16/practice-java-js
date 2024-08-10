
let circle=[ 2,4,8,16,7];

function area(radius){
    return Math.PI*radius*radius;
}

function circumference(radius){
    return 2*Math.PI*radius;
}

function diameter(radius){
    return 2*Math.PI*radius;
}

function traverse(circle,operation,operationName){
    console.log(operationName);
    for(let i=0;i<circle.length;i++){
        console.log(operation(circle[i]));
    }
}

traverse(circle,diameter,"diameter:");
console.log("......................");
traverse(circle,area,"area:");
console.log("......................");
traverse(circle,circumference,"circumference");