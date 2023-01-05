-- -- 부서명을 받아 해당 부서 사원(사번 이름 상사이름 급여 급여등급 상사가 없는 사람은 CEO) 출력
SELECT W.EMPNO, W.ENAME, NVL(M.ENAME, 'CEO') MANAGER, W.SAL, GRADE
    FROM EMP W, EMP M, DEPT D, SALGRADE
    WHERE W.MGR=M.EMPNO AND W.DEPTNO=D.DEPTNO AND W.SAL BETWEEN LOSAL AND HISAL
        AND DNAME=UPPER('sales');

select * from dept;
commit;