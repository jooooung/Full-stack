------------ MemberDao에 들어갈 Query----------------
-- DAO에 들어갈 QUERY
    -- 1. ID중복체크
SELECT COUNT(*) FROM MVC_MEMBER WHERE MID = 'c';
    -- EMAIL 중복체크
SELECT COUNT(*) FROM MVC_MEMBER WHERE MEMAIL = 'S@S.COM';
    -- 2. JOIN
INSERT INTO MVC_MEMBER (MID, MPW, MNAME, MEMAIL, MPHOTO, MBIRTH, MADDRESS, MRDATE)
    VALUES ('c', 'c', '이', 'a@a.com', 'NOIMG.png', '1999-01-01', '서울', '2000-12-12');
    -- 3. LOGIN CHECK
SELECT * FROM MVC_MEMBER WHERE MID = 'a' AND MPW = 'a';
    -- 4. mID로 MemberDto 가져오기
SELECT * FROM MVC_MEMBER WHERE MID = 'a';
    -- 5. 회원정보수정
UPDATE MVC_MEMBER 
    SET MPW='1',
        MNAME='송',
        MEMAIL='S@S.COM',
        MPHOTO='NOIMG.png',
        MBIRTH='1993-02-15',
        MADDRESS='부산'
    WHERE MID='a';

    -- 6. 회원리스트(top-n)mID순
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT * FROM MVC_MEMBER ORDER BY MRDATE DESC) A)
    WHERE RN BETWEEN 1 AND 3;
    -- 7. 전체회원 수
SELECT COUNT(*) CNT FROM MVC_MEMBER;
    -- 8. 회원탈퇴
DELETE FROM MVC_MEMBER WHERE MID = 't';

------------ FileboardDao에 들어갈 Query----------------
-- 1. 글목록(startRow, endRow)
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M
  WHERE F.MID=M.MID 
  ORDER BY FGROUP DESC, FSTEP;
SELECT * 
    FROM (SELECT ROWNUM RN, A.* 
        FROM (SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M
                WHERE F.MID = M.MID
                ORDER BY FGROUP DESC, FSTEP) A)
    WHERE RN BETWEEN 1 AND 3;
-- 2. 글개수
SELECT COUNT(*) FROM FILEBOARD;
-- 3. 글쓰기(원글)
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP) VALUES
    (FILEBOARD_SEQ.NEXTVAL, 'a', '제목4', '4본문', 'NOIMG.png', FILEBOARD_SEQ.CURRVAL, 0, 0, '192.0.0.1');
-- 4. 조회수 올리기
UPDATE FILEBOARD SET FHIT = FHIT + 1 WHERE FID=1; 
-- 5. fID로 상세보기
SELECT F.*, MNAME FROM FILEBOARD F, MVC_MEMBER M  
    WHERE F.MID = M.MID AND FID = 1;
-- 6. 글수정(fid, ftitle, fcontent, ffilename, frdate(SYSDATA), fip)
UPDATE FILEBOARD 
    SET FTITLE = '수정제목',
        FCONTENT = '수정본문',
        FFILENAME = 'NOIMG.png',
        FRDATE = '2023-03-15',
        FIP = '192.0.2.1'
    WHERE FID = 1;
-- 7. 글삭제
DELETE FROM FILEBOARD WHERE FID = 2;
-- 8. 답변글 쓰기 전 단계(원글의 FGROUP과 같고 FSTEP보다 크면 FSTEP을 하나 증가)
UPDATE FILEBOARD SET FSTEP = FSTEP + 1
    WHERE FGROUP = 1 AND FSTEP > 0;
-- 9. 답변글 쓰기
INSERT INTO FILEBOARD (FID, MID, FTITLE, FCONTENT, FFILENAME, FGROUP, FSTEP, FINDENT, FIP) VALUES
    (FILEBOARD_SEQ.NEXTVAL, 'f', '제목5', '5본문', 'NOIMG.png', 1, 1, 1, '192.0.0.1');
-- 10. 회원탈퇴시 탈퇴회원(mID) 글 삭제 
DELETE FROM FILEBOARD WHERE MID = 'b';
------------ AdminDao에 들어갈 Query----------------
-- 1. 로그인
SELECT * FROM ADMIN WHERE AID = 'admin' AND APW = 1;
-- 2. 로그인 후 세션에 넣을 용도 aid로 AdminDto 가져오기
SELECT * FROM ADMIN WHERE AID = 'admin';
COMMIT;