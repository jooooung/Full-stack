# 스마트폰 레이아웃
## viewport mete 태그
```
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=yes,
                                minimum-scale=0.7, maximum-scale=1.5">
```
- user-scalable=yes(no) : 스마트폰 화면 확대 축소 가능(불가능)
- minimum-scale=0.5 : 최소 0.5배까지 축소 
- maximum-scale=1.5 : 최대 1.5배까지 확대

## menu 클릭시 숨겨진 서브메뉴 나오기
1. body - checkbox type인 input을 만든다
2. body - label을 checkbox와 연결
3. style - 서브메뉴 -> display: none으로 숨기기
4. style - #toggle:checked ~ 서브메뉴{
    - checkbox가 checked일 때 서브메뉴 display: block (보이게)}
5. style - #toggle{display: none} : 체크박스 숨기기
```
<style>
    서브메뉴{  
      display: none;    /* 3. 안 보이게 설정 */
    }
    #toggle:checked ~ 서브메뉴{
      display: block;  4. /* 체크박스를 체크시 보이게 */
    }
    #toggle{
      display: none;   5. /* 체크박스 숨기기*/
    }
  </style>
</head>
<body>
  1. <input type="checkbox" id="toggle">
  <header>
    <a href="#left" class="left">
      <img src="ex1/category.png">
    </a>
    <h1>Mobile</h1>
        2.  <label for="toggle" class="right">
      <img src="ex1/menu.png">
    </label>
    </header>
</body>
```

# 말줄임 태그(ellipsis)
화면의 width보다 긴 문장은 끝에 ...으로 생략됨(style)
```
/* 말줄임 태그(ellipsis) */
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
```

# 배경화면 위치 지정하지
`background: url(ex1/bg_image.png) -500px -200px;`  
- 500px -200px : 배경의 시작위치 지정

# 화면 사이즈에 상관없이 이미지 사이즈 고정시키기
- 부모 단에서 position: relative : 부모 안으로 위치 설정
- 자식 단에서 position: absolute
- 위치 지정하기 ex) top: 0;    right: 0;
