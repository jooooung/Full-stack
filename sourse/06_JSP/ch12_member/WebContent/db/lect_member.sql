-- TABLE DROP & CREATE
DROP TABLE MEMBER CASCADE CONSTRAINTS; 
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    PHONE1 VARCHAR2(5),
    PHONE2 VARCHAR2(5),
    PHONE3 VARCHAR2(5),
    GENDER VARCHAR2(1),
    EMAIL VARCHAR2(30),
    BIRTH DATE,
    ADDRESS VARCHAR2(255),
    RDATE DATE NOT NULL
);
SELECT * FROM MEMBER;
-- 1. 회원가입시 ID 중복체크 : public int confirmId(String id)
SELECT * FROM MEMBER WHERE ID='A';   -- SELECT COUNT(*) FROM MEMBER WHERE ID='A';

-- 2. 회원가입 : public int joinMember(MemberDto dto)
INSERT INTO MEMBER 
     (ID, PW,  NAME, PHONE1, PHONE2, PHONE3, GENDER, EMAIL, BIRTH, ADDRESS, RDATE) 
    VALUES
     ('A', '111', '홍깅동', '02', '111', '2222', 'm', 'h@hong@com', '1995-01-01', '서울', SYSDATE);
     
-- 3. 로그인 : public int loginCheck(String id, String pw)
SELECT * FROM MEMBER WHERE ID='A';  -- ID 확인하기
-- SELECT * FROM MEMBER WHERE ID='A' AND PW='111';     -- ID나 PW 잘못치면 둘 다 확인(어떤게 틀렸는지 모름

-- 4. ID로 dto가져오기 : 로그인 성공시 session에 setAttribute / 회원정보 수정시 회원정보 가져오기
-- public MemberDto getMember(String id)
SELECT * FROM MEMBER WHERE ID='A';

-- 5. 회원정보수정 : public int modifyMember(MemberDto dto)
UPDATE MEMBER SET PW='111',
                  NAME='홍길동', 
                  PHONE1='031',
                  PHONE2='333',
                  PHONE3='4444',
                  GENDER='m',
                  EMAIL='ss@hong.com',
                  BIRTH='2000-02-02',
                  ADDRESS='경기'
            WHERE ID='A';
SELECT * FROM MEMBER;            
COMMIT;            
