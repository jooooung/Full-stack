// class ECMA script6 이상을 지원하는 브라우저에서만 가능
// https://caniuse.com 지원 브라우저 확인 사이트
class Person{
    constructor(name, first, second){// class의 모든 생성자 함수 이름은 constructor
        console.log('생성자 함수 호출');
        this.name = name;
        this.first = first;
        this.second = second;
    }   
    sum(){
        return this.first + this.second;
    }
}//class
var kim = new Person('kim', 10, 20);
kim.sum = function (){
    return '수정된 kim의 sum : ' + (this.first+this.second);
};
var lee = new Person('lee', 30, 40);
console.log(kim.name, ', ', kim.first, ', ' , kim.second, ', ', kim.sum());
console.log(lee.name, ', ', lee.first, ', ' , lee.second, ', ', lee.sum());
