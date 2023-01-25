// cf. 가변인자함수 : 매개변수 개수에 따라 변하는 함수
// 내장 함수 : Array()를 이용하여 가변인자 함수 array()를 생성
var arr1 = [273, 2, 3, 'Hello',];       // , 뒤에 y-space등이 있으면 무시된다
var arr2 = Array(273, 2, 3, 'Hello');
var arr3 = [ , , , ];                   // 방4개가 아닌 3개짜리 빈 배열
var arr4 = Array(3);                    // 방 3개짜리 빈 배열
var arr5 = [];                          // 방의 개수가 0인 배열
var arr6 = Array();                     // 방의 개수가 0인 배열

console.log('arr1=', arr1, '- 방의 개수 = ', arr1.length);
console.log('arr2=', arr2, '- 방의 개수 = ', arr2.length);
console.log('arr3=', arr3, '- 방의 개수 = ', arr3.length);
console.log('arr4=', arr4, '- 방의 개수 = ', arr4.length);
console.log('arr5=', arr4, '- 방의 개수 = ', arr5.length);
console.log('arr6=', arr6, '- 방의 개수 = ', arr6.length);






// var sum = (x, y) => {       //화살표 함수
//     return x+y;
// }

// var sum = function () {  익명함수
//     return x+y;
// }

// function sum (x, y) {    선언적함수
//     return x+y;
// }