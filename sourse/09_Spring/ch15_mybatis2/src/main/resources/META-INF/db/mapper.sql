-- Emp.xml id=empList   EMPNO 순 출력
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM EMP ORDER BY EMPNO) A)
    WHERE RN BETWEEN 1 AND 3;
    
-- Emp.xml id=empDeptList
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT E.*, DNAME, LOC FROM EMP E, DEPT D 
                WHERE E.DEPTNO = D.DEPTNO
                ORDER BY EMPNO) A)
    WHERE RN BETWEEN 1 AND 15;
    
-- Emp.xml id=totCnt
SELECT COUNT(*) FROM EMP;

-- Emp.xml id=detail
SELECT * FROM EMP WHERE EMPNO = 7369;

-- Emp.xml id=managerList
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP); 

-- Emp.xml id=insert
INSERT INTO EMP VALUES (7777, '홍', 'MANAGER', 7902, '23/04/11', 3100, 30, 40); 

-- Emp.xml id=update
UPDATE EMP SET ENAME = '홍길동',
               JOB = 'MANAGER',
               MGR = 7902,
               HIREDATE = '23/04/11',
               SAL = 3000,
               COMM = 30,
               DEPTNO = 20
         WHERE EMPNO = 7777;
            
-- Emp.xml id=delete
DELETE FROM EMP WHERE EMPNO = 7777;

-- Dept.xml id=deptList
SELECT * FROM DEPT;
COMMIT;