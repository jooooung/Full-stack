-- drop & create
DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    cID VARCHAR2(50) PRIMARY KEY,
    cPW VARCHAR2(50) NOT NULL,
    cNAME VARCHAR2(50) NOT NULL,
    cTEL VARCHAR2(50),
    cEMAIL VARCHAR2(50),
    cADDRESS VARCHAR2(250),
    cBIRTH DATE,
    cGENDER VARCHAR2(10) CHECK(cGENDER='m' OR cGENDER='f'),
    cRDATE DATE DEFAULT SYSDATE NOT NULL
);
-- 1. 회원가입시 id 중복체크 : public int confirmID(String cid)
SELECT COUNT(*) FROM CUSTOMER WHERE CID='aaa';

-- 2. 회원가입 : public int joinCustomer(CustomerDto dto)
INSERT INTO CUSTOMER (CID, CPW, CNAME, CTEL, CEMAIL, CADDRESS, CBIRTH, CGENDER)
    VALUES('aaa', '111', '홍', '010-1111-1111', 'GHD@GHD.GHD', '서울',
            '1995-12-12', 'm');
            
-- 3. 로그인 : public int loginCheck(String cid, String cpw)
SELECT * FROM CUSTOMER WHERE CID='aaa' AND CPW='111';

-- 4. cid로 DTO 가져오기 : public CustomerDto getCustomer(String cid)
SELECT * FROM CUSTOMER WHERE CID='aaa';

-- 5. 정보수정 : public int modifyCustomer(CustomerDto dto)
UPDATE CUSTOMER SET CPW='111',
                    CNAME='홍',
                    CTEL='010-2222-2222',
                    CEMAIL='HONG@H.COM',
                    CADDRESS='경기',
                    CBIRTH='1999-01-01',
                    CGENDER='m'
                WHERE CID='aaa';
SELECT * FROM CUSTOMER;
COMMIT;