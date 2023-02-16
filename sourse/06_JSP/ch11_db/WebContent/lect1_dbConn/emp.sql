SELECT * FROM EMP;	-- 실행하고자 하는 SQL문을 블럭잡고 alt+x   ex2_oracle.jsp
-- ex3
SELECT * FROM DEPT;
SELECT * FROM EMP WHERE DEPTNO LIKE '%'||'';

-- example.jsp    
SELECT EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, E.DEPTNO, DNAME
    FROM EMP E, DEPT D 
    WHERE E.DEPTNO = D.DEPTNO AND ENAME LIKE '%'||TRIM(UPPER('s'))||'%';
