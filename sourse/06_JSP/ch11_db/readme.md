# db
## db 연동시 (oracle, mysql) 
1. C:\Program Files\Java\jre1.8.0_351\lib\ext 위치에 두 파일 넣기
    - mysql-connector(mysql db연결을 위한 파일)  
    - ojdbc(oracle db연결을 위한 파일)
2. eclipse에서 jre에 두 파일 추가


sqld 없이 oracle db 연동
- Data Sourse Explorer - Database Connections 우클릭 new - oracle  
- next - + - Oracle Thin Driver 11 - 위의 JAR List에서 기존 지우고 ojdbc6.jar추가 - OK 클릭 - SID 체크 : xe - Host:localhost - 포트넘버:1521 - 유저ID:scott - 비밀번호-tiger