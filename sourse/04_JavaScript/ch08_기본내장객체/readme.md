# ✨ 기본내장객체
## ✔ Object 객체의 메소드
- Object 객체는 최상위 객체이므로 Object 객체의 프로토타입에 속성 또는 메소드를 추가하여 모든 객체에서 활용 가능
1. constructor : 객체의 생성자 함수를 나타낸다 `객체명.constructor`
2. toString : 객체를 문자열로 바꾼다

## ✔ Number
1. toExponential() : 지수형 표현
2. toFixed(number) : 소수점 number 자리까지 추출(number+1의 자리에서 반올림)

## ✔ String
1. str.replace('기존str', '바꿀str') : 처음 나오는 기존 str 하나를 바꾼다
2. str.replaceAll('기존str', '바꿀str') : 모든 기존str을 바꾼다
3. str.substr(a, b) :  a번째부터 b개 글자 추출
4. str.substring(a, b) : a번째부터 b번째 앞까지 추출
5. str.indexOf(a) : 처음 오는 a의 순서를 추출 (a가 없다면 -1 return)
6. str.lastIndexOf(a) : 뒤에서부터의 a 순서를 추출 (a가 없다면 -1 return)
7. str.trim() : 양 끝의 space 없애기 
8. str.replaceAll(' ', '') : `trim()`은 글자 사이의 space를 없애지 못하여 다 없애려면 이 방법 사용

## ✔ 정규식표현을 이용한 패턴
- 패턴
`var 패턴명 = /원하는 정규표현식패턴/` : 정규표현식 패턴 생성
### test : 패턴이 포함되어 있는지 확인
- `정규표현식패턴명.test(변수)`    : 변수에 정규표현식 패턴이 포함되어 있는지 확인 할 수 있다 (true, false)

### match
- `변수.match(정규표현식패턴)` :  정규표현식패턴과 맞는 text를 return, 없으면 null return

## ✔ Array
1. sort() : ascii 코드 순으로 Array를 정렬  
sort를 이용한 오름차순, 내림차순 정렬
```
sort(function(L, R){
    return L - R;   
    // 양수면 1 return (자리 그대로) 내림차순
    // 음수면 -1 return (자리 바뀜) 오름차순
});
```
2. reverse() : 배열 요소 순서를 뒤집는다
3. slice(a, b) : a번째부터 b번째 앞까지 추출한다
4. a.concat(b) : a 와 b 배열을 합친다
5. a.join() : a의 배열 요소를 문자열로 만들어 리턴
6. push() : 배열의 뒤에 추가