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