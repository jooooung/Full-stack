# `<style>`내에서 css파일 연결하기

## 1. link
- `<link rel="stylesheet" href="css파일명" />`

## 2. @import
  - @import url('css파일위치/파일명');
    - import는 항상 `<style>` 맨 위에 와야한다

# media
- link태그에 media속성을 이용하여 상황에 따른 CSS를 적용할 수 있다

## - 종류
- all : 모든 미디어 타입
- aural : 음성 합성 장치
- braille : 점자 표시 장치
- handheld : 손으로 들고 다니면서 볼 수 있는 작은 스크린에 대응하는 용도
- print : 인쇄 용도
- projection : 프로젝터 표현 용도
- screen : 컴퓨터 스크린을 위한 용도
- tv : 음성과 영상이 동시 출력되는 TV와 같은 장치
- embossed : 페이지에 인쇄된 점자 표지 장치

# 반응형 웹 : 디바이스의 환경에 따른 화면 출력
스마트폰, 태블릿, pc 등 많은 디바이스가 있으므로 디바이스의 화면 크기에 맞는 화면출력 설정을 할 수 있다
```
@media screen and ((min. max)-(device)-width:()px){}
```
- min(max) : 최소(최대) width 설정
- device : device의 최소(최대) width 설정(스마트폰, 태블릿)
- width 설정 시  
각 스마트폰, 태블릿, pc의 width가 겹쳐선 안된다  
ex)
```
/* 스마트폰용 화면 ~ 959 */
@media screen and (max-device-width:959px)
/* 탭용 화면 960 ~ 1200*/
@media screen and (min-device-width:960px) and (max-width:1200px)
/* pc용 화면 1201 ~*/
@media screen and (min-width:1201px)
```