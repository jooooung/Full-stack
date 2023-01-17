# 스마트폰 레이아웃
viewport mete 태그
- user-scalable=yes : 스마트폰 화면 확대 축소 가능
- minimum-scale=0.5 : 최소 0.5배까지 축소 
- maximum-scale=1.5 : 최대 1.5배까지 확대



체크박스와 이미지 연결 후
div 안보이게하고
클릭 시 보이게한다
후에 체크박스를 안보이게하여
이미지 클릭시 뜨게
```
<style>
    div{
      width: 100px;
      height: 100px;
      background-color: red;
      display: none;    /* 안 보이게 설정 */
    }
    #toggle:checked ~ div{
      display: block;   /* 체크박스를 체크시 보이게 */
    }
    #toggle{
      display: none;    /* 체크박스 숨기기*/
    }
  </style>
</head>
<body>
  <input type="checkbox" id="toggle">

  <label for="toggle">
    <img src="ex1/menu.png">  <!--체크박스와 이미지 연결하기-->
  </label>
  <div id="gnb">토글부분</div>
</body>
```

# 말줄임 태그(ellipsis)
```
/* 말줄임 태그(ellipsis) */
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
```

# 배경화면 위치 지정하지
`background: url(ex1/bg_image.png) -500px -200px;`
-500px -200px : 시작위치 지정

# 화면 사이즈에 상관없이 이미지 사이즈 고정시키기
