# ajax_mvc
- ch03에서 스크립트릿을 이용한 코드를 `mvc` 패턴으로 바꿔보기
- `ajax` 만들기 전에 `ajax`에서 요청할 경로인 파일을 먼저 생성  
`mvc`패턴에서는 요청은 `xxx.do` 로 간다(`model`) 

## 생성 과정
1. `Controller` : `*.do` 를 받는 `controller` 생성
  - uri, conPath, command 세팅
  - viewPage, service : null 값으로 선언
  - 요청받는 `url mapping` 처리하기
  - `RequestDispatcher` 만들고 `forward`
2. `Service` 생성(`Model`)
3. ajax에서 요청할 jsp 파일(불필요한 코드는 뺸다 ex)title)
4. `View` 파일 생성
- `$.ajax` 의 url을 jsp 파일이 아닌 `url mapping`으로 변경


