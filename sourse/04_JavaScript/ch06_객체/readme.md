# ✨객체

## ✔ 객체의 속성과 메소드
속성 변수에 function을 넣을 수 있다 -> 메소드화
객체 안에 있는 메소드에서 속성변수를 가져올 때는 this를 써야한다
```
    let person = {
        name : '홍길동',    // 속성 변수
        age : 20,
        eat : function(food){   // 메소드
            var msg = this.age + '살' + this.name + '님은' + food + '를 먹습니다';
            alert(msg);
        },
    };
```

## ✔  toString 구현 방식
`arr = [10, 20, 30];`   배열출력
- 1. for-in
```
for(var idx in arr){
    document.write(arr[idx] + '<br>');
}
```
- 2. for-of
```
for(var data of arr){
    document.write(data + '<br>');
}
```
## replace, replaceAll
- `string.replace(oldStr, newStr);` string에서 oldStr을 newStr로 교체(처음 하나만)
- replaceAll이라는 메소드를 만들어 모든 oldStr를 newStr로 변경할 수 있다
```
function replaceAll(str, oldSrt, newStr) {
    return str.split(oldSrt).join(newStr);
}

```

## ✔ 
## ✔
## ✔
## ✔