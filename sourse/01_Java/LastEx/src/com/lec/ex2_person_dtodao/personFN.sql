-- 프로그램 요구사항에 필요한 DML
-- 기능별 query 작성 (1, 2, 3)
-- 1. person 입력
INSERT INTO PERSON 
    VALUES (pNO_SEQ.NEXTVAL, '송혜교',
            (SELECT JNO FROM JOB WHERE JNAME='배우'), 100, 100, 100);
--delete from person where pno=6;
-- 2. 직업별 조회
SELECT ROWNUM RN, A.* 
    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM 
            FROM PERSON P, JOB J WHERE P.jNO=J.jNO AND jNAME='배우'
             ORDER BY SUM DESC) A
   ;
-- 3. 전체 조회
SELECT ROWNUM RN, A.* 
    FROM (SELECT pNAME||'('||pNO||'번)' pNO, jNAME, KOR, ENG, MAT, (KOR+ENG+MAT) SUM 
            FROM PERSON P, JOB J WHERE P.jNO=J.jNO 
            ORDER BY SUM DESC) A;
SELECT JNAME FROM JOB;
commit;