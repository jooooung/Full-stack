-- TABLE & SEQUENCE DROP
DROP TABLE FILEBOARD;
DROP SEQUENCE FILEBOARD_SEQ;
DROP TABLE CUSTOMER;
DROP TABLE BOOK;
DROP SEQUENCE BOOK_SEQ;
-- TABLE & SEQUENCE CREATE
-- CUSTOMER
CREATE TABLE CUSTOMER (
    cID      VARCHAR2(50) PRIMARY KEY,   -- 아이디
    cPW      VARCHAR2(50) NOT NULL,      -- 비밀번호
    cNAME    VARCHAR2(50) NOT NULL,      -- 이름
    cTEL     VARCHAR2(50),               -- 전화번호
    cEMAIL   VARCHAR2(50),               -- 이메일
    cADDRESS VARCHAR2(250),              -- 주소
    cGENDER  VARCHAR2(10),               -- 성별
    cBIRTH   DATE,                       -- 생년월일
    cRDATE   DATE DEFAULT SYSDATE NOT NULL -- 가입시점
);
-- FILEBOARD
CREATE SEQUENCE FILEBOARD_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
CREATE TABLE FILEBOARD(
    fNUM     NUMBER(7, 0) PRIMARY KEY,  -- 글번호
    cID      VARCHAR2(50) REFERENCES CUSTOMER(cID) NOT NULL, -- 아이디
    fSUBJECT VARCHAR2(250) NOT NULL,    -- 글제목
    fCONTENT VARCHAR2(4000),            -- 글내용
    fFILENAME VARCHAR2(50),             -- 첨부파일이름
    fPW      VARCHAR2(50) NOT NULL,     -- 글비밀번호
    fHIT     NUMBER(7, 0) DEFAULT 0 NOT NULL,     -- 조회수
    fREF     NUMBER(7, 0) NOT NULL,     -- 글그룹
    fRE_STEP NUMBER(7) NOT NULL,        -- 그룹내 출력순서
    fRE_LEVEL NUMBER(1) NOT NULL,       -- 들여쓰기
    fIP      VARCHAR2(50) NOT NULL,     -- IP주소
    fRDATE   DATE DEFAULT SYSDATE NOT NULL              -- 글등록시점 
);
-- BOOK
CREATE SEQUENCE BOOK_SEQ
    MAXVALUE 9999999
    NOCACHE
    NOCYCLE;
CREATE TABLE BOOK(
    bID     NUMBER(7, 0) PRIMARY KEY,   -- 책ID
    bTITLE  VARCHAR2(30) NOT NULL,      -- 책제목
    bPRICE  NUMBER(7) NOT NULL,         -- 책가격
    bIMAGE1 VARCHAR2(30) NOT NULL,      -- 표지이미지
    bIMAGE2 VARCHAR2(30) NOT NULL,      -- 부가이미지
    bCONTENT VARCHAR2(4000),            -- 책소개
    bDISCOUNT NUMBER(3) NOT NULL,       -- 할인율
    bRDATE  DATE DEFAULT SYSDATE NOT NULL               -- 책등록시점
);
SELECT * FROM CUSTOMER;
SELECT * FROM FILEBOARD;
SELECT * FROM BOOK;
-- INDEX & VIEW 생성(상황에 따라)