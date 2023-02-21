-- BOARD TABLE DROP & CREATE
DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM     NUMBER(5, 0) PRIMARY KEY,  -- 글번호
    WRITER  VARCHAR2(30) NOT NULL,     -- 작성자
    SUBJECT VARCHAR2(100) NOT NULL,    -- 글제목
    CONTENT VARCHAR2(100) NOT NULL,    -- 본문 (CLOB=글자수 제한 X)
    EMAIL   VARCHAR2(30),              -- 이메일
    READCOUNT NUMBER(5) DEFAULT 0,     -- 글 HIT (조회수)
    PW      VARCHAR2(30) NOT NULL,     -- 글 삭제시 쓸 비밀번호
    REF     NUMBER(5, 0) NOT NULL,     -- 글그룹(원글=글번호/답변글=원글의 REF)
    REF_STEP NUMBER(3) NOT NULL,        -- 글그룹내 출력순서
    REF_INDENT NUMBER(3) NOT NULL,      -- 글 LIST 출력시 제목 들여쓰기정도(원글=0)   
    IP      VARCHAR2(30) NOT NULL,     -- 글 작성 컴퓨터 IP주소
    RDATE   DATE DEFAULT SYSDATE       -- 작성일(날짜+시간)
);
SELECT * FROM BOARD;

-- 1. 글개수
SELECT COUNT(*)FROM BOARD;

-- 2. 글목록(글그룹이 최신인 글이 위로)
SELECT * FROM BOARD ORDER BY REF DESC;

-- 3. 글쓰기(원글) - 글쓴이, 제목, 본분, 이메일, PW
    -- 글번호를 생성
    SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, 
                    PW, REF, REF_STEP, REF_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '홍길동', '제목', '본문', NULL, '111',
            (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '1');
INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, 
                    PW, REF, REF_STEP, REF_INDENT, IP)
    VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '이길동', '제목2', '본문2', NULL, '111',
            (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '1');
            
-- 4. 글번호로 글 상세보기 내용(DTO) 가져오기
SELECT * FROM BOARD WHERE NUM=2;

-- 5. 조회수 올리기
UPDATE BOARD SET READCOUNT = READCOUNT + 1 WHERE NUM=2;

-- 6. 글 수정
UPDATE BOARD SET SUBJECT = '수정 제목1',
                 CONTENT = '수정 본문1',
                 EMAIL   = 'H@H.COM',
                 PW      = '111',
                 IP      = '111.0.0.1'
           WHERE NUM =1;
           
-- 7. 글삭제(비밀번호 맞게 입력한 경우만)
COMMIT;
DELETE FROM BOARD WHERE NUM=1 AND PW='111';
ROLLBACK;
-- 조회수 조작
UPDATE BOARD SET READCOUNT = 11 WHERE NUM=1;
SELECT * FROM BOARD ORDER BY REF DESC;
