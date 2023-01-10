# HTML - I
## 태그란
- HTML 문서를 구성하고 있는 요소, 열린태그와 닫힌태그로 나눠진다  
(닫힌태그가 필요 없는 태그도 있다)
- 태그에는 태그이름과 속성, 속성값이 있다

## HTML 구조
```
1. <!DOCTYPE html>
2. <html lang="en" xmlns="http://www.w3.org/1999/xhtml">
3. <head>
    <meta charset="utf-8" />
    <title></title>
	<style>
		body{background-color: #fff000;}
	</style>
</head>
<body>
	<!— 열린 태그, 닫힌 태그가 있고, 이 둘은 쌍이다. 닫힌 태그가 필요없는 태그도 있긴 하다 -- >
	<a href="http://www.daum.net">
<!- 태그 이름 : A, 태그속성 :href, 태그값이 있다 -->
		<img src="img/parkseyoung.jpg" alt="다음" />
	</a>
</body>
</html>
```
### 1. `<!DOCTYPE html>`
- 웹 브라우저가 현재 웹 페이지가 HTML5 문서임을 인식하게 하는 것
- 문서의 가장 첫번째 줄에 있어야 한다
### 2. `<html  lang=”ko”>`
- html태그의 시작을 알리고 lang(언어) 속성을 입력
- 이 lang속성은 실제 웹 브라우저가 동작하는데 어떠한 영향도 끼치지 않는다
### 3. `<head>  …  </head>`
- 이 문서의 정보인 title이나 설정값들인 css, javaScript등의 환경설정에 관한 정보를 넣는다.
- Head 태그 내부에는 다음의 태그들만 넣을 수 있고 그 외 태그를 넣으면 웹 브라우저가 자동으로 해당 태그를 body내부로 옮긴다
### 4. `<body>  …  </body>`
- 사용자에게 보이는 웹 문서 실제 정보
---
## 배경색 설정하기
```
<style>
    body{background-color:#00FF00; /*16진수 R(2)G(2)B(2)*/}
    body{background-color:#00FF0022; /* 투명도*/}
</style>
```

## 글자 관련 태그
- `<h1></h1>` :  제목태그. h1~h6까지 있으며 1이 가장 크고 6이 가장 작다
- `<p></p>` : 단락태그. p태그가 닫히면 자동 개행, 다음 단락까지 약간의 마진(밖여백)이 생긴다
- `&lt; ~ &gt;` : <> (꺽쇠)
- `<br />` : enter
- `%nbsp;` : space   
- `<a></a>` : 하이퍼링크 걸어주는 태그
  - <a href : 링크, target=링크를 열 방법>
  - target 종류 
    - _self: 현재 페이지 (기본값)
    - _blank: 새 탭
- `<i></i>` : 이태릭체
- `<b></b>` : 진하게
- `<sup>` : 윗첨자
- `<sub>` : 아랫첨자
- `<ins>` : 언더라인(밑줄)
- `<del>` : 줄긋기
- `<span>` : 글자에 값 지정(style에서 설정)
```
    <style>
        span {color:#FF0000;} /*span에 색 설정*/
    </style>
```
- `<pre></pre>`
```
<pre>
  pre태그 영역은 브라우저에 그대로 표현됩니다
  화면에 그대로 표현됩니다
  확인해보기
  &lt;abc&gt; 꺽쇠괄호만 예외

    엔터, 스페이스, 탭 다 그대로
</pre>
```

## 목록 태그
- `<ol></ol>` : 순서가 있는 목록 태그, ol type은 닫힌 태그에서 쓴다   
type 종류 : 1, i, I, a, A
- `<ul></ul>` : 순서가 없는 목록  ul type은 열린 태그에서 쓴다  
type 종류 : disc, square, circle
  -  `<li></li>` : 목록 요소
- `<dt></dt>` : 정의목록(definition term)
- `<dd></dd>` : 정의 용어에 대한 상세설명(definition description), 자동 들여쓰기
- summary : 세보정보의 요약이나 제목
- details : 세부정보나 추가 정보를 숨겼다가 펼쳤다가하는 기능(toggle)
---
## 표태그
- `<table></table>` : 표 만들기
  - `<tr></tr>` : 행
    - `<th></th>` : 열
    - `<td></td>` : 제목(진한 글씨, 가운데 정렬)
      - `<th, td colspan>` : 열병합
      - `<th, td rowspan>` : 행병합

## 이미지태그
- src : 이미지의 경로 지정
- alt : 이미지가 없을 때 나오는 글자 지정
- width : 이미지의 너비 지정 (css 부분에 설정해주는 경우가 더 많다)
- height : 이미지의 높이 지정 (css 부분에 설정해주는 경우가 더 많다)
- hr : 페이지에 줄 나누기(color 지정 가능)

## 오디오태그
- src : 오디오 파일의 경로 지정
- preload = (auto, metadata, none) : 오디오를 재생하기 전에 모두 불러올지 지정
- autoplay : 오디오를 자동 재생할지 지정 (인터넷 익스플로어에서 작동)
- loop : 오디오를 반복할지 지정
- conrols : 오디오 재생 도구를 출력할지 지정

## 비디오태그
- poster : 비디오 준비 중일 때의 이미지 파일 경로 지정
- preload = (auto, metadata, none) : 비디오를 재생하기 전에 모두 불러올지 지정
- autoplay : 비디오를 자동 재생할지 지정
- loop : 비디오를 반복 재생할지 지정
- controls : 비디오 재생 도구를 출력할지 지정
- width : 비디오의 너비를 지정
- height : 비디오의 높이를 지정



---
- ```https://www.lipsum.com/``` 더미데이터 가져오는 사이트(영문)  
- ```http://hangul.thefron.me/```더미데이터 가져오는 사이트(한글)