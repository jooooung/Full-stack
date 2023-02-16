# ✨웹프로그래밍 데이터베이스
## JDBC(Java Database Connectivity)
- JAVA 프로그램에서 SQL문을 실행하여 데이터를 관리하기 위한 JAVA API.
- 하나의 프로그램으로 데이터 베이스를 관리 할 수 있는 이점이 있다.
- 데이터베이스 연결 순서
1. JDBC 드라이버 로드
2. 데이터 베이스 연결
3. SQL문 실행
4. 데이터베이스 연결 해제

## Statement 객체
- `executeQuery()` : SQL문 실행 후 여러 개의 결과값 생기는 경우 사용 ex. Select
- `executeUpdate()` : SQL문 실행 후 테이블의 내용만 변경되는 경우 사용 ex. insert, delete, update
- `executeQuery()` : 실행 후 반환되는 레코드 셋
- `ResultSet.next()` : 다음 레코드로 이동
- `ResultSet.previous()` : 이전 레코드로 이동
- `ResultSet.first()` : 처음 레코드로 이동
- `ResultSet.last()` : 마지막 레코드로 이동
- get메소드 : `getString`, `getInt`

## db 연동시 (oracle, mysql) 
1. C:\Program Files\Java\jre1.8.0_351\lib\ext 위치에 두 파일 넣기
    - mysql-connector(mysql db연결을 위한 파일)  
    - ojdbc(oracle db연결을 위한 파일)
2. eclipse에서 jre에 두 파일 추가


## sql 없이 oracle db 연동하기
1. eclipse내의 Data Sourse Explorer - Database Connections 우클릭
2. new - oracle - next - '+'클릭
3. Oracle Thin Driver 11 - 위의 JAR List에서 기존 지우고 ojdbc6.jar추가 - OK 클릭
4. SID 체크 : xe - Host:localhost - 포트넘버:1521 - 유저ID 입력 - 비밀번호 입력