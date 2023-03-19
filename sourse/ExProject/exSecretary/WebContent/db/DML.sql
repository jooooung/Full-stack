--------------- MEMBER ---------------
-- 1. ID 중복체크
SELECT * FROM MEMBER WHERE MID = 'member1';
-- 2. 회원가입
INSERT INTO MEMBER 
    VALUES ('member4', 'member4', '박지우', null, null, null, 'f', null, '0');
-- 3. 로그인
SELECT * FROM MEMBER WHERE MID = 'member1' AND MPW = 'member1';
-- 4. 상세보기(MID로 DTO 가져오기)
SELECT * FROM MEMBER WHERE MID = 'member1';
-- 5. 회원정보 수정
UPDATE MEMBER SET MPW = 'member1',
                  MNAME = '김아중',
                  MPHOTO = NULL,
                  MTEL = '010-2943-1182',
                  MEMAIL = 'M@google.com',
                  MGENDER = 'f',
                  MBIRTH = '1992-01-11'
            WHERE MID = 'member1';
-- 6. 회원 리스트(top-N)
SELECT * 
    FROM (SELECT ROWNUM RN, A.*
        FROM (SELECT * FROM MEMBER ORDER BY MNAME) A)
    WHERE RN BETWEEN 1 AND 2;
-- 7. 전체 회원 수 
SELECT COUNT(*) CNT FROM MEMBER;

-- 8. 회원탈퇴
DELETE FROM EX WHERE MID = 'member1';
DELETE FROM BCOMMENT WHERE MID = 'member1';
DELETE FROM EXBOARD WHERE MID = 'member1';
DELETE FROM INBODY WHERE MID = 'member1';
DELETE FROM MEMBER WHERE MID = 'member1';
ROLLBACK;

--------------- ADMIN ---------------
-- 1 admin 로그인
SELECT * FROM ADMIN WHERE AID='admin' AND APW='admin';
-- 2 로그인 후 세션에 넣을 용도 : admin aid로 dto 가져오기
SELECT * FROM ADMIN WHERE AID='admin';

--------------- EXBOARD ---------------
-- 1. 글목록(paging)
SELECT * FROM
  (SELECT ROWNUM RN, A.* FROM 
    (SELECT B.*, MNAME FROM EXBOARD B, MEMBER M 
      WHERE B.MID = M.MID ORDER BY BGROUP DESC, BSTEP) A)
  WHERE RN BETWEEN 1 AND 4;
-- 2. 글개수
SELECT * FROM EXBOARD;
-- 3. 글쓰기(원글)
INSERT INTO EXBOARD 
    VALUES (EXBOARD_SEQ.NEXTVAL, 'member1', '오운완!!', '오늘은 하체', NULL, SYSDATE, 0, EXBOARD_SEQ.CURRVAL, 0, 0, '192.0.0.1');
-- 4. 조회수 올리기
UPDATE EXBOARD SET BHIT = BHIT + 1 WHERE BNUM = 1;
-- 5. 상세보기(BNUM로 DTO 가져오기)
SELECT * FROM EXBOARD WHERE BNUM = 1;
-- 6. 글 수정하기(BTITLE, BCONTENT, BPHOTO, BDATE(SYSDATE), BIP)
UPDATE EXBOARD SET BTITLE = '오늘은 글렀네요',
                   BCONTENT = '운동 하기 귀찮아요',
                   BPHOTO = NULL,
                   BDATE = SYSDATE,
                   BIP = '192.1.2.3'
             WHERE BNUM = 1;
-- 7. 글 삭제(삭제된 글이라고 UPDATE)
UPDATE EXBOARD SET BTITLE = '삭제된 글입니다',
                   BCONTENT = NULL,
                   BPHOTO = NULL,
                   BHIT = 0
             WHERE BNUM = 1;
-- 8. 답글 쓰기 전 단계(원글과 BGROUP이 같고 원글의 BSTEP보다 크면 BSTEP 하나 증가)
UPDATE EXBOARD SET BSTEP = BSTEP + 1
    WHERE BGROUP = 1 AND BSTEP>0;
-- 9. 회원 탈퇴 시 탈퇴한 회원이 쓴 글 바꾸기
UPDATE EXBOARD B SET BTITLE = '탈퇴한 회원입니다',
                     BCONTENT = NULL,
                     BPHOTO = NULL,
                     BHIT = 0
               WHERE MID = 'member1';
