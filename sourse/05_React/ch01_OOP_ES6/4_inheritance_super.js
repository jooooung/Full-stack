class Person {
  constructor(name, first, second) {
    // class의 모든 생성자 함수 이름은 constructor
    this.name = name;
    this.first = first;
    this.second = second;
  }
  sum() {
    return this.first + this.second;
  }
} //class

var hong = new Person("홍길동", 100, 90);
console.log("홍길동의 sum : " + hong.sum());

// class를 이용한 상속
class PersonPlus extends Person {
  constructor(name, first, second, third) {
    // 생성자 함수는 무조건 constructor
    super(name, first, second);
    this.third = third;
  }
  sum() {
    // third를 추가하기 위한 override
    return this.first + this.second + this.third;
  }
  avg() {
    return this.sum() / 3;
  }
}

var son = new PersonPlus("손흥민", 100, 100, 100);
console.log("손 sum : " + son.sum());
console.log("손 avg : " + son.avg());
