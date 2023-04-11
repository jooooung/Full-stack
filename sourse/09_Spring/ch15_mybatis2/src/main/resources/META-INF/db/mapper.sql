-- Emp.xml id=empList
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM EMP) A)
    WHERE RN BETWEEN 1 AND 3;
-- Emp.xml id=empDeptList

-- Emp.xml id=totCnt

-- Emp.xml id=detail

-- Emp.xml id=managerList

-- Emp.xml id=insert

-- Emp.xml id=update

-- Emp.xml id=delete

-- Dept.xml id=deptList