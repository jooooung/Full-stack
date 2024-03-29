﻿-- [XI] INDEX : 조회를 빠르게 하는 인덱스
SELECT * FROM USER_INDEXES; 
DROP TABLE EMP01;
CREATE TABLE EMP01 AS SELECT * FROM EMP; -- EMP테이블과 같은 내용의  EMP01;
SELECT * FROM EMP01; -- 14행
INSERT INTO EMP01 SELECT * FROM EMP01; -- ★데이터뻥튀기 1번(28) 2번(56행)
SELECT COUNT(*) FROM EMP01;
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;  -- 11번 실행 (약 11만개)
INSERT INTO EMP01 SELECT * FROM EMP01;
INSERT INTO EMP01 (EMPNO, ENAME, DEPTNO) VALUES (1111, 'HONG', 40);
INSERT INTO EMP01 SELECT * FROM EMP01;    -- 1번 실행(22만) 2번실행(44만)

-- 인덱스 생성 전 조회 
SELECT * FROM EMP01 WHERE ENAME='HONG';   -- 인덱스 생성 전 조회 시간(0.02초)
-- 인덱스 생성
CREATE INDEX IDX_EMP01_ENAME ON EMP01(ENAME);
-- 인덱스 생성 후 조회
SELECT * FROM EMP01 WHERE ENAME='HONG';    -- 인덱스 생성 후 조회 시간(0.002초)
COMMIT;

-- 인덱스 생성 후 91만->182만개로 INSERT 시간 : 36초
INSERT INTO EMP01 SELECT * FROM EMP01;
SELECT TO_CHAR(COUNT(*), '9,999,999') FROM EMP01;
ROLLBACK;   -- 18초
-- 인덱스 삭제 후 INSERT 해보기
DROP INDEX IDX_EMP01_ENAME;
INSERT INTO EMP01 SELECT * FROM EMP01;  -- 인덱스 제거 후 91만->182만개로 INSERT 시간 : 3초

SELECT * FROM USER_INDEXES WHERE TABLE_NAME='EMP01';
DROP TABLE EMP01;   -- 테이블을 지우면 인덱스도 자동 삭제