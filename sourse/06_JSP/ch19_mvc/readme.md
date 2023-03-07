# ✨MVC
## ✔1. table, query
## ✔2. dto, dao

## ✔3. service
  - 3-1. service(interface) : 추상 메소드 생성
  - 3-2. MemberJoinService(class) : 파라미터 받아 join 로직 생성
  - 3-3. MemberListService(class) : memberList.do 로직 생성

## ✔4. controller(servlet)
- `URL mapping` : *.do 로 변경
- `command` 생성
- 들어온 요청 판별 후 (service.execute호출) viewPage로 `forward`

## ✔5. 
