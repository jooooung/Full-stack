#  web과 html, CSS
## 1. Web이란?
- WWW(world wide web)의 줄임말로 전 세계의 컴퓨터들을 연결하여  
정보 공유를 주 목적으로 한다  
이렇게 컴퓨터들이 연결되어 있는 상태를 네트워크에 연결되어 있다고 한다
- WWW(world wide web)은 인터넷에 연결된 컴퓨터를 통해 사람들이 정보를 공유할 수 있는 정보공간. 인터넷은 전세계를 연결하고 있는 국제 정보통신망이고 웹은 그 위에 작동하는 서비스(기능)
## 인터넷의 기능들
- 프로토콜(Protocol) : 네트워크상에서 약속한 통신규약 (Http, FTP, SMTP, POP, DHCP) 
- ```Http : HyperText Transfer Protocol``` 정보를 가져와 브라우저 화면상에서 봄
- ```FTP : File Transfer Protocol``` 파일을 다운
- ```SMTP, POP``` : 메일 송수신 protocol
- ```DHCP : Dynamic Host Configuration Protocol```   
→ 다이나믹하게 계속 사설 ip 분배해주어 Web을 사용하도록 하는 protocol
- IP : 네트워크상에서 컴퓨터를 식별할 수 있는 주소
- DNS : IP주소를 인간이 쉽게 외우도록 맵핑한 문자열
- Port : IP주소가 컴퓨터를 식별할 수 있게 해준다면   
Port번호는 해당컴퓨터의 구동되고 있는 프로그램을 구분할 수 있는 번호  
 http://www.lec.com:80/abc/def/index.jsp
  - http : 프로토콜
  - www.lec.co.kr : 컴퓨터주소(DNS를 통한 IP주소로변경)
  - 80 : 기본적인 포트번호
  - abc/def/index.jsp : information path

# HTML이란?
- HTML이란, Hyper Text Markup Language의 약자로서 웹문서를 기술하는 언어
- 웹문서를 표현하기 위해 태그들로 구성되어 있습니다.
# CSS란?
- Cascading Style Sheets의 약자로, HTML문서를 디자인적으로 예쁘게 만들어 정보 전달을 좀더 효율적으로 하기 위해 만들어진 문서 입니다.
- HTML은 정보를 가지고 있고, CSS는 화면상의 레이아웃등의 디자인을 컨트롤하는 문서라고 생각 하면 됩니다.
---
# JavaScript
- 동적인 내용 -> jQuery

# HTML, CSS, JS 
- 각 파일을 나누어 HTML에 연결하기
 
```
<head>
CSS -> HTML
<link rel="stylesheet" href="ex.css" type="text/css">

JS -> HTML
<script src="2.js"></script>
</head>
```
## js file 한글 깨짐 현상
- js 파일이 ANSI code 체계로 되어 있어서 한글이 깨지는 현상이 발생하였다
-> js 파일을 메모장으로 열기 - 다른이름으로 저장 - 인코딩=utf-8로 변경  
만약 변경하여도 변경되지 않는다면 chrome 방문기록 삭제해보기
```
cp949(ms949=euc-kr) : 완성형 (요즘은 쓰지 않는다)
utf-8 : 조합형 (깨지는 글씨가 없다)
```