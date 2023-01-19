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
js 안에서도 list를 만들 수 있다
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
## 4. confirm : 사용자의 확인을 받기 위한 대화상자를 표시
확인 취소 버튼을 이용하여 true false로 정해진 값 출력
- === : 값과 타입이 일치해야 true
- == : 타입이 일치하지 않을 경우 일치시켜서 비교한 후 같으면 true

## 5. prompt : 사용자로 내용을 입력받을 수 있는 대화상자를 표시
- 입력값의 type은 무조건 string
- type을 number로 변경하기  -> Number(변수명);  (형변환 불가할 경우 NaN으로 출력)
- 반환값 = prompt(메시지, 초기값);

if (isNaN(변수)){}   : 변수가 숫자가 아닐 때 

## 숫자형 형변환
```
1. str='100'; i=Number(str);
str타입 : string - 값 : 100
i타입 : number - 값 : 100

2. str='100'; i=parseInt(str);
str타입 : string - 값 : 100
i타입 : number - 값 : 100

3. str='100점'; i=Number(str);
str타입 : string - 값 : 100점
i타입 : number - 값 : NaN

4. str='100점'; i=parseInt(str);
str타입 : string - 값 : 100점
i타입 : number - 값 : 100

5. str='B'; i=Number(str);
str타입 : string - 값 : B
i타입 : number - 값 : NaN

6. str='B'; i=parseInt(str, 16);
str타입 : string - 값 : B
i타입 : number - 값 : 11    // 값이 11이 나온 이유는 16진수이기 때문

7. str=''; i=Number(str);
str타입 : string - 값 :
i타입 : number - 값 : 0

8. str=''; i=parseInt(str);
str타입 : string - 값 :
i타입 : number - 값 : NaN
```

## Boolean 사용시 false 값들
- 0, NaN, '', null, undefined
- ''==false의 결과 : true 
    - ==은 양변의 값이 일치할 경우 true
- ''===false의 결과 : false
    - ===은 양변의 자료형과 값이 일치할 경우 true