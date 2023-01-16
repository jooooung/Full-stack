# CSS 속성들

## ✨ 1. 단위: em, %, px
- **em** : 배수(문자에서만 사용 가능)
- **%** : 문자, width, height, padding, margin 등 사용 가능
    - 문자 : 원래 사이즈의 %
    - width, height, padding, margin 등 : 부모의 %
- **px** : pixel 크기
---
## ✨ 2. url() : 백그라운드 이미지, 폰트 지정
- **용도** : 로컬font지정할 때, 백그라운드 이미지를 지정할 때  
- **로컬 폰트 설정** 
```
/* 로컬 폰트 넣기 */
@font-face{ 
    font-family: 'NanumSon';    /*프로그램 상 폰트 이름*/
    src: url('나눔손글씨_배은혜체.ttf');    /*폰트 주소*/
}
    *{  /* 전체 폰트 지정 */
        font-family: NanumSon;
        }        
```
- **background-image** : 배경을 지정하는 속성
```
background-image: url('');  /*이미지 지정*/
background-repeat:no-repeat;    /*반복 설정*/
background-position:center;     /*위치 설정*/
background: url('밀크.jpg') center no-repeat;   /*한번에*/
background-size:100%;   /*가로 사이즈 기준*/
```
---
## ✨ 3. display
- **inline**(가로정렬) : 위, 아래 margin 미적용 
- **block**(세로정렬) : 위, 아래 margin 적용 
    - ```inline -> block, block -> inline``` 가능
    - 글씨 주변도 클릭 가능
- **none** : 안보이게(공간도 안보임)
- **inline-block** : 위, 아래 margin 적용
---
## ✨ 4. visibility
- visibility:hidden : 안보이게(공간은확보)
---
## ✨ 5. opacity(투명도) : 투명도를 조절하는 속성
- 0 ~ 1 : 0(완전투명), 1(완전불투명)
---
## ✨ 6. margin과 padding
- margin, padding의 입력 순서 : 위 오른쪽 아래 왼쪽
- width, height를 각 100씩 주고 margin, padding을 10씩 준다면   
크기는 140 * 140이 된다
---
## ✨ 7. box-sizing : 전체 사이즈의 크기를 변경
```
box-sizing:border-box;
/*border가 box안으로(border가 width에 포함)*/
```
---
## ✨ 8. border
- border-left: 2px dashed red;
- border-width : 
- border-style : 
- border-color : 
---
## ✨ 9. 글자 관련
### 1. line-height : 글자의 세로 높이  
글자를 수직 가운데로 -> height와 line-height를 같게 설정 
### 2. font-weight: bold  :: 글씨 진하게
### 3. font-family : 글씨체
### 4. font-style: italic :: 이태릭체(기운 글씨) 
### 4. text-decoration : 선 긋기(underline, overline)
---
## ✨ 10. position
- static :  기본값
- absolute : 절대 좌표
- fixed : 스크롤을 내려도 화면에 고정
- relative : 상대 좌표
- relative와 absolute의 혼합 사용 :
