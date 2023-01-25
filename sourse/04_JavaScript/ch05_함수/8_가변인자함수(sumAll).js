

function sumAll() {
    var result = 0;
    if(arguments.length == 0){
        result = -999;
    } else {
        for (let i = 0; i < arguments.length; i++) {
            result += arguments[i];
        }
    }
    return result;
}
console.log(sumAll());
console.log(sumAll(1));
console.log(sumAll(1, 2, 3));
