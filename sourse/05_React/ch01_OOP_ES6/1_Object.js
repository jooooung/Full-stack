"use strict"
// 배열복사
let memberArray = ['egoing', 'grapgittie', 'leezhce'];
var copyArray = [...memberArray];    // 객체의 깊은 복사
var copyArray = Array.from(memberArray);    // 배열의 깊은 복사
copyArray[0] = '홍길동';
copyArray[1] = '바꿈';
copyArray[2] = '카피';


console.group('memberArray for-loop');
for (var i=0 ; i<memberArray.length ; i++){
    console.log(i +'번째 : ' + memberArray[i]);
}
console.groupEnd('memberArray for-loop');
console.groupEnd('copyArray for-loop');
copyArray.forEach(function(data, idx){
    console.log(idx + '번째 : ' + copyArray[idx]);
});
console.groupEnd('copyArray for-loop');

// 객체복사
var memberObject = {
    name : '홍길동',
    age : 20.
};
// var copyObject = { ... memberObject};   // 객체의 깊은 복사
var copyObject = Object.assign({}, memberObject);   // 객체의 깊은 복사

var copyObject = Object.assign({id:1}, memberObject);

copyObject['name'] =  '바끔';
console.group('memberObject for-in');
for(var key in memberObject){
    console.log(key + ' : ' + memberObject[key]);
}
console.groupEnd('memberObject for-in');

console.group('copyObject for-in');
for(var key in copyObject){
    console.log(key + ' : ' + copyObject[key]);
}
console.groupEnd('copyObject for-in');