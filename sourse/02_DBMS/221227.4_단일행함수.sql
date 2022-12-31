-- [ IV ] 단일행함수
-- 함수  = 단일행함수, 그룹함수(집계함수)
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY-MM-DD') FROM EMP;   --단일행 단일행 적용
SELECT ENAME, INITCAP(ENAME) FROM EMP;  --첫 글자만 대문자, 단일행함수(INPUT 1행 -> OUTPUT 1행)
SELECT SUM(SAL), AVG(SAL) FROM EMP;  -- 그룹함수(INPUT N행 -> OUTPUT 1행)
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;   -- 그룹함수(INPUT N행 -> OUTPUT 1행)

-- ★단일행 함수의 종류 : 숫자관련함수, 문자관련함수, 날짜관련함수, 형변환함수, NVL(), ETC...
-- 1. 숫자관련함수 
    -- DUAL테이블, DUMMY테이블 : 오라클에서 만든 1행1열 짜리 더미테이블
SELECT * FROM DUAL;
DESC DUAL;
SELECT * FROM DUMMY;
DESC DUMMY;
SELECT ABS(-1) FROM DUAL;  -- ABS() = 절대값 함수
SELECT FLOOR(34.5678) FROM DUAL; --소수점에서 버림
SELECT FLOOR(34.5678*10)/10 FROM DUAL;  -- 소수점 2번째 자리에서 버림
SELECT TRUNC(34.5678, 2) FROM DUAL;     -- 소수점 3번째 자리에서 버림
SELECT TRUNC(34.5678) FROM DUAL;           --소수점에서 버림 
SELECT TRUNC(34.5678, -1) FROM DUAL;    -- 일의 자리에서 내림
    -- ex. EMP테이블에서 이름, 급여(십의 자리에서 내림)
SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;     
SELECT CEIL(34.5678) FROM DUAL;   -- 소수점 일의 자리에서 올림

SELECT ROUND(34.5678) FROM DUAL;    -- 소수점 일의 자리에서 반올림
SELECT ROUND(34.5678, 2) FROM DUAL;  -- 소수점 두번째 자리 다음에서 반올림
SELECT ROUND(34.5678, -1) FROM DUAL;  -- 일의 자리에서 반올림

SELECT MOD(9, 2) FROM DUAL;     -- 나머지 연산자
    -- ex. 홀수년도에 입사한 사원의 모든 정보 출력
SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'RR'), 2) = 1;

-- 2. 문자관련함수
-- ① 대소문자 관련
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL;      -- INITCAP 단어의 첫 글자만 대문자로
SELECT INITCAP('Welcom To Oracle') FROM DUAL;
SELECT UPPER('ABCabc') FROM DUAL; -- 대문자로
SELECT LOWER('ABCabc') FROM DUAL; -- 소문자로
    -- ex. 이름이 SCOTT 인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(ENAME)='SCOTT';
SELECT * FROM EMP WHERE INITCAP(ENAME)='Scott';
    -- ex. job이 MANAGER 인 직원의 모든 필드
SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';
SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';

-- ② 문자연결(concat함수, ||연산자)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
    -- ex. SMITH는 manager다
SELECT CONCAT(CONCAT(ENAME, '는 '), CONCAT(JOB, '다')) FROM EMP;
SELECT ENAME || '는 ' || JOB || '다' FROM EMP;

-- ③ SUBSTR(STR, 시작위치, 문자갯수) : STR을 시작위치부터 문자갯수만큼 문자 추출
                    -- (시작위치가 1부터, 시작위치가 음수이면 끝부터 자리수를 셉니다)
  -- SUBSTRB(STR, 시작바이트위치, 문자바이트수)
SELECT SUBSTR('ORACLE', 3, 2) FROM DUAL; -- 3번째 글자부터 2글자 추출
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL;-- 3번째 바이트부터 2바이트 추출
SELECT SUBSTR('데이터베이스', 4, 3) FROM DUAL; -- 4번째 글자부터 3글자 추출(베이스)
SELECT SUBSTRB('데이터베이스', 4, 3) FROM DUAL;-- 4번째 바이트부터 3바이트 추출(이)
    -- O R A C L E
    -- 1 2 3 4 5 6(위치)
    ---6-5-4-3-2-1(위치)
SELECT SUBSTR('WELCOME TO ORACLE', -1, 1) FROM DUAL; -- 뒤에서 1번째 글자부터 한글자 추출
SELECT SUBSTR('ORACLE', -2, 2) FROM DUAL; -- 마지막 글자 2글자 추출
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- 숫자도 가능(숫자를 문자로 바꿔 2번째 부터 1글자 추출)

    -- ex. 9월에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';      -- 4번째 글자부터 2개 출력, DATE형도 가능
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), 4, 2) = '09';     -- 형변환
    
    -- ex. 9일에 입사한 사원의 모든 필드 'RR/MM/DD'
SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';     --뒤에서 두번째 글자부터 2개 출력
SELECT * FROM EMP WHERE SUBSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), -2, 2) = '09';

-- ④ LENGTH(STR) : STR의 글자수
    -- LENGTHB(STR) : STR의 바이트 수
SELECT LENGTH('ABCD') FROM DUAL;
SELECT LENGTHB('ABCD') FROM DUAL;
SELECT LENGTH('오라클') FROM DUAL;  -- 결과 3(글자수)
SELECT LENGTHB('오라클') FROM DUAL; -- 결과 9(바이트 수)

-- ⑤ INSTR(STR, 찾을문자) : STR에서 첫번째 문자부터 찾을 문자가 나오는 위치(없으면 0)
    -- INSTR(STR, 찾을문자, 시작위치) : STR에서 시작위치 문자부터 찾을 문자가 나오는 위치
SELECT INSTR('ABCABC', 'B') FROM DUAL; -- 처음부터 찾아서 처음나오는 B의 위치 : 2
SELECT INSTR('ABCABC', 'B', 3) FROM DUAL; -- N번째 문자부터 찾아서 처음 나오는 B의 위치 : 5
SELECT INSTR('ABCABC', 'B', -3) FROM DUAL; -- 뒤 N번째부터 뒤로 찾아서 처음 나오는 B의 위치 : 2
SELECT INSTR('ABCABCABC', 'B', -3) FROM DUAL;   -- 뒤 N번째부터 뒤로 찾아서 처음 나오는 B의 위치 : 5

    -- ex. 9월에 입사한 사원(INSTR이용) 'RR/MM/DD'
SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4;
SELECT * FROM EMP WHERE INSTR(TO_CHAR(HIREDATE, 'RR/MM/DD'), '09', 4) = 4;    -- 날짜 형식을 모를 시 형변환

    -- ex. 9일에 입사한 사원의 모든 필드(INSTR이용)
SELECT * FROM EMP WHERE INSTR (HIREDATE, '09', 7) = 7;
    
    -- ex. 9일이 아닌 날에 입사한 사원의 모든 필드(INSTR이용)
SELECT * FROM EMP WHERE INSTR (HIREDATE, '09', 7) = 0;    

-- ⑥ LPAD(STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 왼쪽 빈 자리에 채울문자로 출력
    -- LPAD(STR, 자리수) : STR을 자리수만큼 확보하고 왼쪽 빈 자리에 ' '로 출력
    -- RPAD(STR, 자리수, 채울문자) : STR을 자리수만큼 확보하고 오른쪽 빈 자리에 채울 문자로 출력
    -- RPAD(STR, 자리수) : STR을 자리수만큼 확보하고 오른쪽 빈 자리에 ' '로 출력
SELECT LPAD('OLACLE', 10, '#') FROM DUAL; -- 결과 : ####OLACLE
SELECT RPAD('OLACLE', 10, '*') FROM DUAL; -- 결과 : OLACLE****
SELECT ENAME, SAL FROM EMP;
DESC EMP; -- ENAME은 10문자까지, SAL은 5자리까지 입력 가능
SELECT ENAME, LPAD(SAL, 6, '*') FROM EMP;
SELECT RPAD(ENAME, 10, '#'), LPAD(SAL, 6, '*') FROM EMP;

    -- ex. 사번, 이름(S****)
SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME), '*') ENAME 
    FROM EMP;

    -- ex. 사번 이름 직책(9자리확보), 입사일 
        -- (7369, SMITH, ____****K 80/12/**
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9, '-') JOB, RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') 
    FROM EMP;
SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(JOB, -1, 1), LENGTH(JOB), '*'), 9, '-') JOB, TO_CHAR(HIREDATE, 'RR/MM/') || '**' 
    FROM EMP;    

    -- ex. 이름의 세번째 자리 글자가 R인 사원의 모든 필드 출력
SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) = 'R';  -- SUBSTR
SELECT * FROM EMP WHERE ENAME LIKE '__R%';          -- LIKE
SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3) = 3;   -- INSTR

-- ⑦ 여백제거 : TRIM(STR), LTRIM(STR), RTRIM(STR)
SELECT TRIM('   ORACLE  ') MSG FROM DUAL;
SELECT LTRIM('   ORACLE  ') MSG FROM DUAL;
SELECT RTRIM('   ORACLE  ') MSG FROM DUAL;

-- ⑧ REPLACE(STR, 바꿔야할문자, 바꿀문자) : STR에서 바꿔야할문자를 바꿀문자로 교체
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(SAL, '0', 'X') FROM EMP;
SELECT REPLACE(HIREDATE, '0', 'X') FROM EMP;

-- 3. 날짜 관련 함수 및 예약어
-- ① SYSDATE : 지금 / (SYSTIMESTAMP) 잘 안씀
SELECT SYSDATE FROM DUAL;
    -- 오라클 타입 : 문자, 숫자, 날짜  - 숫자, 날짜 연산 가능(날짜는 + - 만 가능)
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD HH24:MI:SS';
SELECT SYSDATE-1 어제, SYSDATE 오늘, SYSDATE+1 내일 FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';

    -- ex. 반납예정일
SELECT SYSDATE+14 FROM DUAL;

    -- ex. 개강일 ~ 현재까지의 날짜 계산 (개강일 : 22/11/28)
SELECT TRUNC(SYSDATE - TO_DATE('22/11/28', 'RR/MM/DD')) DAY FROM DUAL;

    -- ex. 현재 ~ 수료일까지 며칠 남았는지 (수료일 : 23/05/12)
SELECT TRUNC(TO_DATE('23/05/12', 'RR/MM/DD') - SYSDATE) DAY FROM DUAL;
    
    -- ex. EMP에서 이름, 입사일, 근무일수
SELECT ENAME, HIREDATE, TRUNC(SYSDATE - HIREDATE) DAY FROM EMP;

    -- ex. EMP에서 이름, 입사일, 근무일수, 근무주수, 근무년수
SELECT ENAME, HIREDATE, TRUNC(SYSDATE - HIREDATE) DAY, 
    TRUNC((SYSDATE - HIREDATE)/7) WEEK, TRUNC((SYSDATE - HIREDATE)/365) YEAR 
    FROM EMP;

-- ③ MONTHS_BETWEEN(시점1, 시점2) : 두 시점간의 개월 수
    -- ex. 이름, 입사일, 근무월수
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH FROM EMP; 

    -- ex. 이름, 입사한 이후 회사에서 받은 돈(SAL은 1년에 12번, COMM은 2번)를 출력
SELECT ENAME, SAL*12*TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))
    + NVL(COMM, 0)*2*TRUNC((SYSDATE - HIREDATE)/365) MONEY
    FROM EMP;
    
-- ④ ADD_MONTHS(특정시점, 개월수) : 특정시점부터 몇 개월 후의 날짜 반환
    -- ex. 이름, 입사일, 수습종료시점(수습기간 6개월)
SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
    -- 입사일이 81/08/30이면 수습 종료시점이 82/02/28 (2월은 30일이 없기 때문)
INSERT INTO EMP VALUES (9999, 'HONG', 'MANAGER', NULL, '81/08/30', NULL, NULL, 40);
ROLLBACK;

-- ⑤ NEXT_DAY(특정시점, '요일') : 특정시점부터 처음 도래하는 요일
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

-- ⑥ LAST_DAY(특정시점) : 특정시점의 달의 말일
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    -- ex. 이름 입사일 첫 월급날(월급날은 말일)
SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) "FIRST SAL" FROM EMP;

-- ⑦ ROUND(날짜, XX) : 날짜 반올림(XX = YEAR, MONTH, DAY)  
    -- YEAR : 가까운 년도로, MONTH : 가까운 월로, DAY : 가까운 일요일로  
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL;    -- SYSDATE=22/12/27  결과=23/01/01
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL;   -- SYSDATE=22/12/27  결과=23/01/01(1~15일은 이번달,16일부터는 다음달)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;     -- SYSDATE=22/12/27  결과=22/12/25
SELECT ROUND(SYSDATE) FROM DUAL;            -- 가까운 0시0분으로 (오전=당일, 오후=내일)

-- TRUNC(날짜, XX) : 날짜 버림
SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL;    -- 같은 해 1월 1일
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL;   -- 같은 달 1일
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;     -- 지난 일요일
SELECT TRUNC(SYSDATE) FROM DUAL;            -- 오늘 0시 0분

    -- ex. 이름, 입사일, 첫 월급날(11일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE+5, 'MONTH')+10 FROM EMP;

    -- ex. 이름, 입사일, 첫 월급날(25일)
SELECT ENAME, HIREDATE, ROUND(HIREDATE-9, 'MONTH')+24 FROM EMP;

-- 4. 형변환 함수 (TO_CHAR:문자로 변환, TO_DATE:날짜형으로 변환)
-- ① TO_CHAR(날짜형, '출력형식')  
    -- 출력형식 -> YYYY, YY, RR, MM, DD, DY, HH24, HH12, AM/PM, MI, SS 
    -- 출력형식에 문자를 포함할 경우 -> ""
SELECT ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD HH24:MI:SS') FROM EMP;
SELECT TO_CHAR(SYSDATE, 'YYYY"년"-MM"월"-DD"일" DY"요일" AM HH12"시" MI"분" SS"초"') FROM DUAL;
SELECT TO_CHAR(SYSTIMESTAMP, 'RR-MM-DD AM HH12:MI;SS:FF') FROM DUAL;  -- 밀리세컨까지 표기하는 법

-- ② TO_CHAR(숫자, '출력형식')
    -- 0 : 자릿수, 출력형식의 자릿수가 많으면 0으로 채움
    -- 9 : 자릿수, 출력형식의 자릿수가 많아도 숫자만큼만 출력
    -- , : 세자리마다, 가능
    -- . : 소수점
    -- $ : 통화단위 $ 추가하고자 할 때
    -- L : 지역통화단위를 추가하고자 할 때(OS의 설정 지역)
SELECT TO_CHAR(12345678, '000,000,000.00') FROM DUAL;   -- 012,345,678.00
SELECT TO_CHAR(12345678, '999,999,999.99') FROM DUAL;   -- 12,345,678.00
SELECT TO_CHAR(100.76, '999.9') FROM DUAL;              -- 소수점 자릿수가 부족할 경우 반올림
SELECT TO_CHAR(1200, 'L9,999') FROM DUAL;
SELECT ENAME, SAL, TO_CHAR(SAL, '$99,999') FROM EMP;

-- ③ TO_DATE(문자, '패턴') : 문자를 패턴에 따라 날짜로 변경
SELECT TO_DATE('20221227 14:53', 'YYYYMMDD HH24:MI') FROM DUAL;
    -- 81/05/01 ~ 83/05/01 사이에 입사한 직원의 모든 필드
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('81/05/01', 'RR/MM/DD') 
        AND TO_DATE('83/05/01', 'RR/MM/DD');
        
-- ④ TO_NUMBER(문자, "패턴")
SELECT '3456'+1 FROM DUAL;
SELECT TO_NUMBER('3,456', '9,999')+1 FROM DUAL;

-- 5. NVL(NULL일 수도 있는 데이터, NULL의 변환값) - 매개변수 2개의 타입이 일치해야함
    -- ex. 사원이름, 직속상사이름(직속상사가 없으면 CEO로 출력)
SELECT W.ENAME, NVL(M.ENAME, 'CEO')   
    FROM EMP W, EMP M
    WHERE W.MGR = M.EMPNO(+);
    
    -- ex. 사원이름, 직속상사의 사번(직속상사가 없으면 CEO로 출력)
SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') MGR FROM EMP;

-- 6. ETC
-- ① EXTRACT : 년도, 월, 일만 추출하고자 할 때
SELECT HIREDATE, EXTRACT(YEAR FROM HIREDATE) FROM EMP;  -- 년도만 숫자로 추출
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;    -- 년도만 문자로 추출
SELECT SYSDATE, EXTRACT(MONTH FROM SYSDATE) FROM DUAL;  -- 월만 숫자로 추출
SELECT SYSDATE, TO_CHAR(SYSDATE, 'MM') FROM DUAL;       -- 월만 문자로 추출
SELECT SYSDATE, EXTRACT(DAY FROM SYSDATE) FROM DUAL;    -- 일만 숫자로 추출
SELECT SYSDATE, TO_CHAR(SYSDATE, 'DD') FROM DUAL;       -- 일만 문자로 추출

-- ② 레벨별 출력
SELECT LPAD('ㄴ', (LEVEL*2))|| ENAME FROM EMP
    START WITH MGR IS NULL 
    CONNECT BY PRIOR EMPNO=MGR;
    
-- <총 연습문제>
    -- 1. 현재 날짜를 출력하고 TITLE에 “Current Date”로 출력하는 SELECT 문장을 기술하시오.
SELECT SYSDATE "Current Date" FROM DUAL;

    -- 2. EMP 테이블에서 현재 급여에 15%가 증가된 급여를 계산하여,
    -- 사원번호,이름,업무,급여,증가된 급여(New Salary),증가액(Increase)를 출력하는 SELECT 문장
SELECT EMPNO, ENAME, JOB, SAL*1.15 "New Salary", SAL*0.15 "Increase" FROM EMP;

    --3. 이름, 입사일, 입사일로부터 6개월 후 돌아오는 월요일 구하여 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, HIREDATE, ROUND(ADD_MONTHS(HIREDATE, 6), 'DAY')+1 MON FROM EMP;

    --4. 이름, 입사일, 입사일로부터 현재까지의 개월수, 급여, 입사일부터 현재까지의 받은 급여의 총계를 출력
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTH, SAL, SAL*(TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))) TOTALSAL 
    FROM EMP;
    
    --5. 모든 사원의 이름과 급여(15자리로 출력 좌측의 빈 곳은 “*”로 대치)를 출력
SELECT ENAME, LPAD(SAL, 15, '*') SAL FROM EMP; 

    --6. 모든 사원의 정보를 이름,업무,입사일,입사한 요일을 출력하는 SELECT 문장을 기술하시오.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY')||'요일' DAY FROM EMP;

    --7. 이름의 길이가 6자 이상인 사원의 정보를 이름,이름의 글자수,업무를 출력
SELECT ENAME, ENAME, LENGTH(ENAME) LENGTH, JOB FROM EMP WHERE LENGTH(ENAME) >= 6;

    --8. 모든 사원의 정보를 이름, 업무, 급여, 보너스, 급여+보너스를 출력
SELECT ENAME, JOB, SAL, NVL(COMM, 0) COMM, SAL+NVL(COMM, 0) TOTAL FROM EMP;

    -- 9.사원 테이블의 사원명에서 2번째 문자부터 3개의 문자를 추출하시오. 
SELECT SUBSTR(ENAME, 2, 3) NAME FROM EMP;

    --10. 사원 테이블에서 입사일이 12월인 사원의 사번, 사원명, 입사일을 검색하시오. 
    --  시스템에 따라 DATEFORMAT 다를 수 있으므로 아래의 방법도 알아보자
SELECT EMPNO, ENAME, HIREDATE 
    FROM EMP
    WHERE TO_CHAR(HIREDATE, 'MM') = 12;

    --11. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
    --EMPNO		ENAME		급여
    --7369		       SMITH		*******800
    --7499		       ALLEN		******1600
    --7521		       WARD		******1250
    --……. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') 급여 FROM EMP;

    -- 12. 다음과 같은 결과를 검색할 수 있는 SQL 문장을 작성하시오
    -- EMPNO	 ENAME 	입사일
    -- 7369	  SMITH		1980-12-17
    -- ….
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') 입사일 FROM EMP;

    --13. 사원 테이블에서 부서 번호가 20인 사원의 사번, 이름, 직무, 급여를 출력하시오.
        --(급여는 앞에 $를 삽입하고3자리마다 ,를 출력한다)
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$99,999') SAL FROM EMP WHERE DEPTNO = 20;