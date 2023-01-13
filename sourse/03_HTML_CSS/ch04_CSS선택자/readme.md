# ✔CSS  선택자
- 선택자란 : HTML 문서 중 특정 부분을 선택하여 속성을 변경하는 목적
- style은 위에서부터 아래로 차례대로 적용

## ✨ 태그선택자 : 특정 태그를 선택하여 CSS속성을 적용
```
header, footer{   /*header, footer 태그를 동시에 속성 적용*/
    color: blue; border:1px solid gray;
}
```

## ✨ 전체선택자 : 페이지 초기화 용도, 전체 페이지의 디자인 초기화
```
* {  /* * : 전체선택 */  
   margin:0;    /*밖여백*/
   padding:0;   /*안여백*/
}
```

## 블록태그를 수평으로 출력        
```
        nav ul{overflow:hidden;} /*수평으로 할 태그의 부모태그에 적용*/
        nav ul li{   /*nav의 ul의 li*/
            float:left;     /*왼쪽으로 출력*/
            list-style:none;    /*ul의 circle 없애기*/
            margin:10px 27px;
        }
        section{clear:both;} /*더이상 안 뜰 곳*/
        /*float속성을 clear.   부모태그 overflow:hidden했으면 생략가능*/
```        
## ✨ ID & Class선택자
- id는 중복 불가  class는 중복 가능  
보통 큰 영역은 id  작은 영역은 class 사용  
- CSS 영역에서 id선택자는 #id명 / class선택자는 .class명

## ✨ 혼합선택자
`h1#id1{} : id가 id1인 h1태그의 스타일 설정`
- div(태그), #wrap(id), #content(id), ul(태그), li(태그), li.memu1(class)   
모두 혼합하여 사용 가능
```
div #wrap #content ul li.memu1 { /*li.memu1 = li중에 menu1 / li .memu1 = li밑의 menu1*/
   font-size: 1.5em; /*원래 글씨 크기의 1.5배*/
}
```
## ✨ 속성선택자
- `(=)` 같은것 : input[type='password']{} = (input의 type이 password인 것의 속성 설정)
- `(^=)` 시작하는것 : input[type^='te']{} = (input의 type이 te로 시작하는 것)
- `($=)` 끝나는것 : input[name$='me']{} = (input의 name이 me로 끝나는 것)            

## ✨ 후손선택자
- 자손선택자를 포함한다
```
div p{ /*후손선택자*/
        font-size: 15px;
}
div > p{  /*자손선택자*/
        color:rebeccapurple;
}
```            
## ✨ 동위(형제) 선택자 : 태그의 동등한 위치를 판단하여 CSS속성 설정 가능
- `+` : 바로 다음에 오는 형제 1개   (태그1 + 태그2 : 태그1 다음에 오는 태그2의 형제 하나)
- `~` : 다음에 오는 형제 전부   (태그1 ~ 태그2 : 태그1 다음에 오는 태그2의 형제 전부)

## ✨ 반응선택자 : 마우스를 올려 놓았을 때(hover상태)의 반응에 따른 속성을 설정 가능
- hover설정할 것 : hover{}
```
#nav ul li:hover{
     color:lightpink;
     font-weight:bold;   
}
```        

## ✨ 상태선택자 : 상태에 따라 CSS속성이 변화하는 설정 가능

```
- ():focus 
input:focus{
    background-color:#6cd719;
}

- ():enabled
- ():read-only
- ():disabled
```

## ✨ 구조 선택자 : 구조에 따라 CSS 속성이 변화하는 설정 가능
```
- ():nth-child(2n+1) : 홀수번째의 () 
- ():nth-child(2n) : 짝수번째의 ()
- ():first-child : 첫번째의 ()
- ():last-child : 마지막의 ()
```

## ✨ 문자선택자
```
#content p:nth-child(2)::first-line     /*첫번째 줄*/
#content p:nth-child(2)::first-letter   /*첫번째 글자*/
#content p:nth-child(2)::selection      /*드래그 시*/
```

## ✨ 링크 선택자 : 문서에 링크(href) 되어 있는 문자를 선택하여, CSS 속성 설정 가능
```
 #content ul li a::after{
    content: '-' attr(href)
}
```                

## ✨ 부정선택자
```
#content ul li a::after{
    content: '-' attr(href)
}
```                