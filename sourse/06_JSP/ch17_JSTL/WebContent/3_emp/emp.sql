-- EmpDao에 들어갈 query
-- 전체리스트 public ArrayList<EmpDto> getListEmp()
SELECT * FROM EMP;

-- 이름과 직업 검색 리스트 public ArrayList<EmpDto> listEmp(String schName, String schJob)
SELECT * FROM EMP 
    WHERE ENAME LIKE '%'||TRIM(UPPER(' s '))||'%'
        AND JOB LIKE '%'||TRIM(UPPER(' s '))||'%';