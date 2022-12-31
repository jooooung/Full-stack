-- 만들었다 지운 계정 데이터 확인해 본 파일

SELECT * FROM TAB;
SELECT * FROM USER_TABLES;  -- 내 권한이 갖고 있는 테이블
SELECT * FROM DBA_TABLES; -- DBA 권한 가진 USER만 사용 가능
SELECT * FROM ALL_TABLES   -- 내가 접근할 수 있는 테이블
    WHERE TABLE_NAME='EMP';
SELECT * FROM SCOTT.EMP;    -- EMP의 권한을 받았기에 사용 가능
SELECT * FROM SCOTT.DEPT;   -- DEPT의 권한을 받았기에 사용 가능
EXIT;