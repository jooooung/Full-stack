-- CustomerDao(아이디중복체크, 회원가입, 로그인, 상세보기(pk로 dto가져오기) 정보수정, 리스트(topN), 회원수)
-- 1. 아이디중복체크
SELECT * FROM CUSTOMER WHERE cID='aaa';
-- 2. 회원가입
INSERT INTO CUSTOMER(cID, cPW, cNAME, cTEL, cEMAIL, cADDRESS, cGENDER, cBIRTH)
    VALUES ('ggg', 'ggg', '마동석', '010-7777-7777', 'g@g.com', '부천', 'm', '2000-09-01');
-- 3. 로그인
SELECT * FROM CUSTOMER WHERE cID='aaa' AND cPW='aaa';
-- 4. 상세보기
SELECT * FROM CUSTOMER WHERE cID='aaa';
-- 5. 정보수정
UPDATE CUSTOMER SET cPW='aaa',
                    cNAME='홍길동', 
                    cTEL='010-1111-1111', 
                    cEMAIL='a@a.com', 
                    cADDRESS='서울', 
                    cGENDER='m', 
                    cBIRTH='1999-02-12' 
            WHERE cID='aaa';
-- 6. 리스트
SELECT * 
    FROM (SELECT ROWNUM RN, CID, CPW, CNAME, CEMAIL, CADDRESS
            FROM (SELECT * FROM CUSTOMER ORDER BY CID))
    WHERE RN BETWEEN 1 AND 3;
-- 7. 회원수
SELECT COUNT(*) CUSTOMERCNT FROM CUSTOMER;

-- FileboardDao(top-N 리스트(글목록), 글 개수, 글쓰기(원글query1개,답변글-query2개), hit올리기, 글상세보기, 글수정, 글삭제)
-- 1. 글목록
SELECT *
    FROM(SELECT ROWNUM RN, A.*
            FROM (SELECT F.*, CNAME, CEMAIL
                    FROM CUSTOMER C, FILEBOARD F
                    WHERE C.cID=F.cID
                    ORDER BY fREF DESC, fRE_STEP)A )
    WHERE RN BETWEEN 1 AND 3;
-- 2. 글개수
SELECT COUNT(*) FROM FILEBOARD;
-- 3. 글쓰기
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'ddd', '글C', '글D 내용', NULL, 'ddd', 0, FILEBOARD_SEQ.CURRVAL, 0, 0, '192.0.1.1');     -- 원글
-- 답글 쓰기전 STEP    
UPDATE FILEBOARD SET fRE_STEP = fRE_STEP + 1 WHERE fREF=4 AND fRE_STEP>0;
-- 답글
INSERT INTO FILEBOARD (fNUM, cID, fSUBJECT, fCONTENT, fFILENAME, fPW, fHIT, fREF, fRE_STEP, fRE_LEVEL, fIP)
    VALUES (FILEBOARD_SEQ.NEXTVAL, 'fff', '글C-1', '글C-1 내용', NULL, 'fff', 0, 3, 1, 1, '192.0.0.6');     -- 답글
-- 4. HIT 올리기
UPDATE FILEBOARD SET fHIT=fHIT+1 WHERE fNUM=1;
-- 5. 글상세보기
SELECT F.*, CNAME, CEMAIL FROM FILEBOARD F, CUSTOMER C WHERE F.CID=C.CID AND fNUM=147;
-- 6. 글수정
UPDATE FILEBOARD SET fSUBJECT='글A 수정', 
                     fCONTENT='A수정내용', 
                     fFILENAME=NULL
                 WHERE fNUM=1;
-- 7. 글삭제
COMMIT;
DELETE FROM FILEBOARD WHERE cID='fff' AND fPW='fff';
ROLLBACK;

-- BookDao(top-N 리스트, 책개수, 책등록, 책상세보기)
-- 1. 리스트
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
            FROM (SELECT * FROM BOOK ORDER BY bRDATE DESC) A )
    WHERE RN BETWEEN 1 AND 2;
-- 2. 책개수
SELECT COUNT(*) FROM BOOK;
-- 3. 책등록
INSERT INTO BOOK (bID, bTITLE, bPRICE, bIMAGE1, bIMAGE2, bCONTENT, bDISCOUNT)
    VALUES (BOOK_SEQ.NEXTVAL, '아무거나',16000,'100.jpg','noImg.png','좋아',10);
-- 4. 책상세보기
SELECT * FROM BOOK WHERE bID=1;
COMMIT;