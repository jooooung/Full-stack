function sum(x=20, y=10) {  // default 매개변수 지정
    return x+y;
}
console.log('sum(10,2) : ' , sum(10,2));
console.log('sum(10) : ' , sum(10));    // y 미지정시 default 값 들어감
console.log('sum() : ' , sum());        // x y default 값
