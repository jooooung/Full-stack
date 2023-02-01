# ✨OOP_ES6

## ✔ 1. Object
### 배열 복사
1. `let 복사 배열 = [...원본배열]; ` // 객체의 깊은 복사(실무에서 많이 사용)
2. `var 복사 배열 = Array.from(원본배열);` // 배열의 깊은 복사

### 객체복사
`var 복사객체 = {...원본객체};`  // 객체의 깊은 복사(실무에서 많이 사용)  
`var 복사객체 = Object.assign({}, 원본객체);`   // 객체의 깊은 복사

## ✔ 2-1.objectMake(단순객체생성)
kim 객체를 생성하고 name, first, second 객체값, sum() 함수를 넣었다
```
let kim = {
    name : 'kim',
    first : 10,
    second : 20,
    sum : function(){
        return this.first + this.second;
    },
};
```

## ✔ 2-2.constructorFunction(생성자 함수를 이용한 객체 생성)
1. `function 생성자함수명(매개변수){}`  
2. `생성자함수명.prototype.함수명 = function(){};`
```
function Person(name, first, second) {
  this.name = name;
  this.first = first;
  this.second = second;
}

Person.prototype.sum = function () {
  return this.first + this.second;
};
```

## ✔ 3.class(class를 이용한 객체 생성)
```
class class명{
    constructor(매개변수){  // class의 모든 생성자 함수 이름은 constructor
        this.매개변수 = 매개변수;
    }   
}
```

생성자 함수에는 데이터만 추가,  
function 추가 시 class 밖에다 `함수명(){}`


## ✔ 4.inheritance_super(상속)
JavaScript는 함수 overloading 불가  
 -> 매개변수가 다른 동일한 생성자 함수 여려개 생성 불가 (마지막 함수만 유효)

```
class (상속할 class) extends (상속받을 class){
    constructor(매개변수){      // 생성자 함수는 무조건 constructor
        super(상속받은 매개변수);
        this.추가한 매개변수 = 추가한 매개변수;
    }
    // 추가된 매개변수 사용을 위한 함수 override
    함수명(){
        return (override할 내용);
    } 
}
```

## ✔ 5_object_inheritance_proto(객체의 상속)
`상속받을객체.__proto__ = 상속객체;`
- 표준으로 인정받지는 못한 방법

### debugger
- JS를 일시중지하면서 F12에서 객체 상태를 모니터링할 수 있다  
- Watch에 볼 객체를 추가하여 볼 수 있다

## 