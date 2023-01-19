# ✨기본문법
## 1. 변수자료형
- string, number, boolean, function, object(array), undefined 
- 'use.strict'; : strict 모드로 구현
    - strict 모드에서 변수 선언 시 var 생략 불가

- undefined : 변수 선언(값 미선언) 시 기본값

## 2. 숫자자료형
###  number 형 : 10진수, 8진수, 16진수, 지수형
```
    document.writeln('10진수 12 : ' + 12 + '<br>');         10진수 12 : 12
    document.writeln('8진수 012 : ' + 012 + '<br>');        8진수 012 : 10
    document.writeln('16진수 0x12 : ' + 0x12 + '<br>');     16진수 0x12 : 18
```

### 실수를 표현하는 방법 : 소수형 + 지수형
```
document.writeln('소수형 : ' + 314123000.9 + '<br>');       소수형 : 314123000.9
document.writeln('지수형 : ' + 0.314230009E+9 + '<br>');    지수형 : 314230009
```

## 3. 복합대입연산자
```
<script>
    document.writeln('<h2>점심시간 후</h2>');
    window.onload = function(){
      let list = '';
      list += '<ul>';
      list += '   <li>HTML</li>';
      list += '   <li>JAVASCRIPT</li>';
      list += '   <li>JQuery&aJax</li>';
      list += '</ul>';
      document.body.innerHTML += list;
    };
  </script>
```
## 4. confirm

## 5. prompt
- 입력값의 type은 무조건 string
- type을 number로 변경하기  -> Number(변수명);  (형변환 불가할 경우 NaN으로 출력)

if (isNaN(변수)){}   : 변수가 숫자일 때 