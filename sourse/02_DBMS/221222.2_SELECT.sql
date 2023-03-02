-- [ II ] SELECT 문 - 조회

-- 1. SELECT 문장 작성법
-- 현재계정 (실행 : CTRL+ENTER)
SHOW USER;      -- 연결된 계정 확인
SELECT * FROM TAB;  --현 계정이 가지고 있는 테이블 정보
SELECT * FROM EMP;  --EMP테이블의 모든 열(필드), 모든 행
SELECT * FROM DEPT; --DEPT 테이블의 모든 열(필드), 모든 행
SELECT * FROM SALGRADE;

-- 2. 특정 열만 출력
DESC EMP;   --EMP테이블의 구조
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;     --EMPNO, ENAME, SAL, JOB필드 모든 행 검색
SELECT EMPNO, ENAME, SAL, JOB, MGR, SAL, COMM FROM EMP; 
--필드에 별칭 설정하기(AS 생략 가능, 스페이스가 없다면 "" 생략가능, 보통 영어로 설정)
SELECT EMPNO AS "사 번", ENAME AS "이 름", SAL AS "급여", JOB AS "직책" FROM EMP;
SELECT EMPNO "사 번", ENAME "이 름", SAL "급여", JOB "직책" FROM EMP;
SELECT EMPNO "사 번", ENAME 이름, SAL 급여, JOB 직책 FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY, JOB 
    FROM EMP;  -- 보통 SELECT절 FROM절을 나눈다

-- 3. 특정 행 출력 : WHERE 절(조건) 비교연산자 : 같다(=) 다르다(!=, ^=, <>)
SELECT EMPNO 사번, ENAME 이름, SAL 급여 FROM EMP WHERE SAL = 3000; -- 같다
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL <> 3000; -- 다르다
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL != 3000; -- 다르다
SELECT EMPNO NO, ENAME NAME, SAL FROM EMP WHERE SAL ^= 3000; -- 다르다
DESC EMP;
    -- 비교 연산자는 숫자, 문자, 날짜형 모두 가능
    -- ex1. 사원이름(ENAME)이 'A', 'B', 'C',로 시작하는 사원의 모든 필드
    -- A < AA < AAA < AAAA < AAAAA < AAAAAA < AA...A(10개) < AA...A < A..AB..
SELECT * FROM EMP WHERE ENAME < 'D';  -- ENAME이 D보다 작은걸 출력
    -- ex2. 81년도 이전에 입사한 사원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    -- ex3. 부서번호(DEPTNO)가 10번인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE DEPTNO = '10';
    -- ex4. 이름(ENAME)이 FORD인 직원의 EMPNO, ENAME, MGR(상사의 사번)을 출력
SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';

-- 4. 조건절에 논리연산자 : AND, OR, NOT
    -- ex1. 급여(SAL)가 2000이상 3000이하인 직원의 모든 필드 출력
SELECT * FROM EMP WHERE SAL >= '2000' AND SAL <= '3000';
    -- ex2. 82년도의 입사한 사원의 모든 필드 출력
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE <= '82/12/31';

-- 날짜 표기법 셋팅 변경 (현재 : YY/MM/DD 또는 RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-YYYY';
SELECT * FROM EMP;
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'YY/MM/DD') >= '82/01/01' 
        AND TO_CHAR(HIREDATE, 'YY/MM/DD') <='82/12/31';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
    -- ex3. 연봉이 2400이상인 직원의 ENAME, SAL, 연봉(SAL*12) 출력
SELECT ENAME, SAL, SAL*12 ANNUALSAL -- (3)
    FROM EMP                    -- (1)  
        WHERE SAL*12 >= 2400;   -- (2) WHERE절에는 필드 별칭(ANNUALSAL) 사용 불가
    -- ex4. 연봉이 10,000 이상인 직원의 ENAME, SAL 연봉(연봉순으로) 출력
SELECT ENAME, SAL, SAL*12 연봉  -- (4) 
    FROM EMP                -- (1)
    WHERE SAL*12 >= 10000   -- (2)
    ORDER BY 연봉;           -- (3)  ORDER BY : 오름차순(기본) 
                            --      ORDER BY () ASC 오름차순
                            --      ORDER BY () DESC 내림차순
    -- ex5. 10번 부서(DEPTNO)이거나 JOB이 MANAGER인 직원의 모든 필드 출력
SELECT * FROM EMP WHERE DEPTNO = 10 OR JOB = 'MANAGER';
    -- ex6. 부서번호가 10번 부서가 아닌 직원의 모든 필드 출력
SELECT * FROM EMP WHERE NOT DEPTNO = 10;     -- NOT은 필드명 앞에 온다

-- 5. 산술연산자
SELECT EMPNO, ENAME, SAL, SAL*1.1 UPGRADESAL FROM EMP;      
    -- ex. 모든 사원의 이름(ENAME), 월급(SAL), 상여(COMM), 연봉(SAL*12+COMM)을 출력
SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;
    -- 산술연산의 결과는 NULL 포함 시 결과도 NULL
    -- NVL(NULL일 수도 있는 필드명, 대치값)을 이용 - 유의점 : 필드명과 대치값의 타입이 일치해야 된다.
SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) 연봉 FROM EMP;
    -- ex2. 모든 사원의 ENAME, MGR(상사 사번)을 출력 (상사가 없으면 CEO로 출력)
SELECT ENAME, NVL(MGR, 'CEO') FROM EMP;     -- MGR(숫자)과 CEO(문자)의 타입이 일치하지 않아 오류
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;     
    --MGR을 TO_CHAR(MGR)로 CEO와 타입을 같게 변경하였다. 별칭은 MGR

-- 6. 연결연산자(||) : 필드나 문자를 연결
SELECT ENAME || '은' || JOB RMPLOYEE FROM EMP;
    -- ex. 모든 사원에 대하여 'SMITH : ANNUAL SALARY = XXXX'  포맷으로 출력 (연봉 = SAL*12+COMM)
SELECT ENAME || ': ANNUAL SALARY = ' || (SAL*12+NVL(COMM, 0)) MESSAGE FROM EMP;

-- 7. 중복제거(DISTINCT)
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- ★ 연습문제 ★
    -- 1. emp 테이블의 구조 출력
SELECT * FROM EMP;
    -- 2. emp 테이블의 모든 내용을 출력 
DESC EMP;
    -- 3. 현 scott 계정에서 사용가능한 테이블 출력
SELECT * FROM TAB;
    -- 4. emp 테이블에서 사번, 이름, 급여, 업무, 입사일 출력
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
    -- 5. emp 테이블에서 급여가 2000미만인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL < 2000;
    -- 6. 입사일이 81/02이후에 입사한 사람의 사번, 이름, 업무, 입사일 출력
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP WHERE HIREDATE > '82/02/01';
    -- 7. 업무가 SALESMAN인 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
    -- 8. 업무가 CLERK이 아닌 사람들 모든 자료 출력
SELECT * FROM EMP WHERE JOB <> 'CLERK';
    -- 9. 급여가 1500이상이고 3000이하인 사람의 사번, 이름, 급여 출력
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL >= 1500 AND SAL <= 3000;
    -- 10. 부서코드가 10번이거나 30인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO = 10 OR DEPTNO = 30;
    -- 11. 업무가 SALESMAN이거나 급여가 3000이상인 사람의 사번, 이름, 업무, 부서코드 출력
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB = 'SALESMAN' OR SAL >= 3000;
    -- 12. 급여가 2500이상이고 업무가 MANAGER인 사람의 사번, 이름, 업무, 급여 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL >= 2500 AND JOB = 'MANAGER';
    -- 13.“ename은 XXX 업무이고 연봉은 XX다” 스타일로 모두 출력(연봉은 SAL*12+COMM)
SELECT ENAME || '은 ' || JOB || '업무이고 연봉은' || (SAL*12+NVL(COMM, 0)) || '다' FROM EMP;
    -- CF. "ENAME의 상여금은 800" 출력하기
SELECT ENAME || '의 상여금은' || NVL(COMM, 0) FROM EMP;

-- 8. SQL연산자(BETWEEN, IN, LIKE, ISNULL)
    -- (1) BETWEEN A AND B : A부터 B까지(A B 포함)
        -- ex. SAL이 1500이상 3000이하인 직원의 사번, 이름, 급여
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
        -- ex2. SAL이 1500미만, 3000초과
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
        -- ex3. 이름이 'A', 'B', 'C'로 시작하는 직원의 모든 필드
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'D' AND ENAME != 'D'; 
        -- ex4. 82년도에 입사한 직원의 모든 필드를 출력
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
-- 만약 데이터 셋이 다르면 TO_CHAR(HIREDATE, 'RR/MM/DD') 로 바꿔준다
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';

    -- (2) IN 
        -- ex1. 부서번호가 10, 20, 40번 부서인 직원의 모든 필드
SELECT * FROM EMP WHERE DEPTNO IN (10, 20, 40);
        -- ex2. 부서번호가 10, 20, 40번을 제회한 부서 직원의 모든 필드
SELECT * FROM EMP WHERE NOT DEPTNO IN (10, 20, 40); 
        -- ex3. 사번이 7902, 7788, 7566인 사원의 모든 필드
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);
        -- ex4. 직책이 MANAGER이거나 ANALYST인 사원의 모든 필드
SELECT * FROM EMP WHERE JOB IN ('MANAGER', 'ANALYST');

    -- (3) LIKE %(0글자 이상), _(한글자)를 포함한 패턴
        -- ex1. 이름이 M으로 시작하는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
        -- ex2. 이름에 N이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%';
        -- ex3. 이름에 N이 들어가거나 JOB에 N이 들어가는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%N%' OR JOB LIKE '%N%'; 
        -- ex4. 이름이 S로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE ENAME LIKE '%S';
        -- ex5. SAL이 5로 끝나는 사원의 모든 필드
SELECT * FROM EMP WHERE SAL LIKE '%5';
        -- ex6. 82년도에 입사한 사윈의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
        -- ex7. 1월에 입사한 사원의 모든 필드
SELECT * FROM EMP WHERE HIREDATE LIKE '%/01/%';
        -- ex8. 이름에 '%'가 들어간 사원의 모든 필드
INSERT INTO EMP VALUES (9999, 'LISA%', NULL, NULL, NULL, 6000, 1500, 20);
-- 데이터 추가
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
ROLLBACK; -- DML(데이터 조작어 : 추가, 수정, 삭제)를 취소

    -- (4) IS NULL (NULL인지 검색)
        -- ex1. 상여금이 입력되지 않는 사원의 모든 필드 출력(COMM이 NULL, O)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM = 0;
        -- ex2. 상여금을 받는 사원의 모든 필드(COMM이 NULL이 아니고 0 도 아님
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM != 0;

-- 9. 정렬(오름차순, 내림차순) ORDER BY () (ASC) 오름차순  기본
--                          ORDER BY () DESC 내림차순
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL;
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC;
-- 같은 월급일 시 XX가 먼저인 것 출력(숫자, 문자, 날짜 다 가능)
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY SAL DESC, ENAME;
-- 이름 abcd순으로
SELECT ENAME, SAL, HIREDATE FROM EMP ORDER BY ENAME;
-- ORDER BY 에 식, 함수도 가능하다
SELECT ENAME, SAL, SAL*12+NVL(COMM, 0) ANNUALSAL FROM EMP ORDER BY SAL*12+NVL(COMM, 0);

DESC EMP;  -- 테이블 유형 확인하기
-- 형변환 함수
-- 날짜형(HIREDATE)을 문자형으로 변환 : TO_CHAR(날짜형데이터, 패턴)
SELECT TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;
-- 문자형을 날짜형으로 변환 : TO_DADE(문자테이터, 패턴)
SELECT TO_DATE('01-12-1996', 'MM-DD-YYYY') FROM DUAL;       --DUAL : 한 행만 있는 가상의 더미


-- <연습문제>
--1.	EMP 테이블에서 sal이 3000이상인 사원의 empno, ename, job, sal을 출력
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL >=3000; 
--2.	EMP 테이블에서 empno가 7788인 사원의 ename과 deptno를 출력
SELECT ENAME, DEPTNO   
    FROM EMP 
    WHERE EMPNO = 7788;
--3.	연봉이 24000이상인 사번, 이름, 급여 출력 (급여순정렬)
SELECT EMPNO, ENAME, SAL, SAL*12+NVL(COMM, 0) ANNUALSAL 
    FROM EMP 
    WHERE SAL*12+NVL(COMM, 0) >= 2400 
    ORDER BY SAL;
--4.	입사일이 1981년 2월 20과 1981년 5월 1일 사이에 입사한 사원의 사원명, 직책, 입사일을 출력 (단 hiredate 순으로 출력)
SELECT ENAME, JOB, HIREDATE 
    FROM EMP 
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE;
--5.	deptno가 10,20인 사원의 모든 정보를 출력 (단 ename순으로 정렬)
SELECT * FROM EMP WHERE DEPTNO IN (10, 20) ORDER BY ENAME;
--6.	sal이 1500이상이고 deptno가 10,30인 사원의 ename과 sal를 출력
-- (단 HEADING을 employee과 Monthly Salary로 출력)
SELECT ENAME employee, SAL "Monthly Salary" FROM EMP WHERE SAL >= 1500 AND DEPTNO IN (10, 30);
--7.	hiredate가 1982년인 사원의 모든 정보를 출력
SELECT * FROM EMP WHERE HIREDATE LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YY') = 82;
--8.	이름의 첫자가 C부터  P로 시작하는 사람의 이름, 급여 이름순 정렬
SELECT ENAME, SAL FROM EMP WHERE ENAME BETWEEN 'C' AND 'Q' AND ENAME != 'Q' ORDER BY ENAME;
--9.	comm이 sal보다 10%가 많은 모든 사원에 대하여 이름, 급여, 상여금을 출력하는 SELECT 문을 작성
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM > SAL*1.1;
--10.	job이 CLERK이거나 ANALYST이고 sal이 1000,3000,5000이 아닌 모든 사원의 정보를 출력
SELECT * FROM EMP WHERE JOB IN('CLERK', 'ANALYST') AND NOT SAL IN (1000, 3000, 5000);
--11.	ename에 L이 두 자가 있고 deptno가 30이거나 또는 mgr이 7782인 사원의 
--모든 정보를 출력하는 SELECT 문을 작성하여라.
SELECT * FROM EMP WHERE ENAME LIKE '%L%L%' AND DEPTNO = 30 OR MGR = 7782;
--12.	입사일이 81년도인 직원의 사번,사원명, 입사일, 업무, 급여를 출력
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%%/%%';
--13.	입사일이81년이고 업무가 'SALESMAN'이 아닌 직원의 사번, 사원명, 입사일, 
-- 업무, 급여를 검색하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP WHERE HIREDATE LIKE '81/%%/%%' AND NOT JOB = 'SALESMAN';
--14.	사번, 사원명, 입사일, 업무, 급여를 급여가 높은 순으로 정렬하고, 
-- 급여가 같으면 입사일이 빠른 사원으로 정렬하시오.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP ORDER BY SAL DESC, HIREDATE;
--15.	사원명의 세 번째 알파벳이 'N'인 사원의 사번, 사원명을 검색하시오
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';
--16.	사원명에 'A'가 들어간 사원의 사번, 사원명을 출력
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';
--17.	연봉(SAL*12)이 35000 이상인 사번, 사원명, 연봉을 검색 하시오.  
SELECT EMPNO, ENAME, SAL*12+NVL(COMM, 0) ANNUALSAL FROM EMP WHERE SAL*12+NVL(COMM, 0) >= 35000;
