# 반복문

##  배열

- JAVA 와 다르게 JavaScript의 배열 방의 크기는 가변적이다. (자료의 집합)
- 어떤 자료형도 배열에 들어갈 수 있다

### push(), unshift(), pop()

- 배열명.push(값); : 배열 제일 뒤에 값을 추가
- 배열명.unshift(값); : 배열 제일 앞에 값을 추가
- var 변수명 = 배열.pop(); // 마지막 배열방의 값을 return하고 삭제

### for

`var arr = [273,32,'홍길동'];` // 배열 선언

- for-in문 : 확장for문은 배열값을 가져온다면 for-in문은 배열방을 가져온다
idx가 배열값이 아닌 배열방을 가져온다
```
for (var idx in arr) {
    document.write(idx + '번째 : ' + arr[idx] + '<br>');
}
★결과★    
0번째 : 273
1번째 : 32
2번째 : 홍길동
```

- for-Each함수1

```
arr.forEach(function (data, idx) {
    document.write(idx + "번째 : " + data + "<br>");
});
값을 data,  idx(배열방)
★결과★
0번째 : 273
1번째 : 32
2번째 : 홍길동
```

- for-Each함수2
배열값만도 가져올 수 있다
```
arr.forEach(function (data) {
    document.write(data + "<br>");
});
★결과★
273
32
홍길동
```      

### slice(배열추출 vs splice)
- slice : 원본 배열을 바꾸지 않고 새로운 배열을 만든다
`let copyArr = arr.slice(2, 5);` copyArr 배열에 arr배열의 2번째부터 5번째 앞까지 복사
- splice는 원본 배열을 수정 (제거, 대체값 삽입)
```
arr.splice(3, 2);   // arr배열의 3번째부터 2개를 제거
arr.splice(0, 1, '대체');   //arr배열의 0번째부터 1개를 제거후 0번째에 대체값 삽입
```