﻿DROP TABLE ORDERDETAIL;
DROP TABLE ORDER_;
DROP TABLE CART;
DROP TABLE MEMBER;
DROP TABLE PRODUCT;

CREATE TABLE MEMBER (
    mID VARCHAR2(100) PRIMARY KEY,
    mNAME VARCHAR2(40) NOT NULL,
    mEMAIL VARCHAR2(250) NOT NULL,
    UNIQUE(mEMAIL)
);
SELECT * FROM MEMBER;

CREATE TABLE ORDER_ (
    oNO NUMBER(30) PRIMARY KEY,
    mID VARCHAR2(100) NOT NULL,
    oNAME VARCHAR2(40) NOT NULL,
    oADDRESS VARCHAR2(250) NOT NULL,
    oTEL VARCHAR2(30) NOT NULL,
    oDATE DATE DEFAULT SYSDATE,
    FOREIGN KEY (mID) REFERENCES MEMBER(mID)
);
SELECT * FROM ORDER_;

CREATE TABLE PRODUCT (
    pCODE VARCHAR2(250) PRIMARY KEY,
    pNAME VARCHAR2(250) NOT NULL,
    pPRICE NUMBER(10) NOT NULL,
    CHECK(pPRICE >= 0)
);
SELECT * FROM PRODUCT;

CREATE TABLE ORDERDETAIL (
    oNO NUMBER(30) NOT NULL,
    pCODE VARCHAR2(250) NOT NULL,
    QTY NUMBER(4) NOT NULL,
    COST NUMBER(10) NOT NULL,
    FOREIGN KEY (oNO) REFERENCES ORDER_(oNO),
    FOREIGN KEY (pCODE) REFERENCES PRODUCT(pCODE),
    CHECK(QTY >= 0),
    CHECK(COST >= 0)
);
SELECT * FROM ORDERDETAIL;

CREATE TABLE CART (
    mID VARCHAR2(100) NOT NULL,
    pCODE VARCHAR2(250) NOT NULL,
    QTY2 NUMBER(4) NOT NULL,
    COST2 NUMBER(10) NOT NULL,
    FOREIGN KEY (mID) REFERENCES MEMBER(mID),
    FOREIGN KEY (pCODE) REFERENCES PRODUCT(pCODE),
    CHECK(QTY2>= 0),
    CHECK(COST2>= 0)
);
SELECT * FROM CART;

DROP SEQUENCE oNO_SEQ;
CREATE SEQUENCE oNO_SEQ
    START WITH 001
    MAXVALUE 999
    NOCACHE
    NOCYCLE;

-- MEMBER
INSERT INTO MEMBER VALUES ('abc', '홍길동', 'HONG@HONG@COM');
INSERT INTO MEMBER VALUES ('def', '김길동', 'KIM@KIM.COM');

-- PRODUCT
INSERT INTO PRODUCT VALUES ('A1', '맥주', 3000);
INSERT INTO PRODUCT VALUES ('A2', '마스크', 200);
INSERT INTO PRODUCT VALUES ('B1', '땅콩', 3000);
INSERT INTO PRODUCT VALUES ('B2', '오징어', 5000);
INSERT INTO PRODUCT VALUES ('C1', '소독약', 7000);

-- CART
INSERT INTO CART VALUES ('abc', 'A1', 3, 3000);

-- ORDER_
INSERT INTO ORDER_ 
    VALUES (TO_NUMBER(230110)||oNO_SEQ.NEXTVAL, 'abc', '홍길동', '서울시 서대문구 대현동', '010-9999-9999', TO_DATE('20230110', 'YYYYMMDD'));

SELECT ONO "주문번호 : ", TO_CHAR(ODATE, 'YYYY"년" MM"월" DD"일"') "주문일 : ", MID "고객번호 : ", ONAME "배송받을 분 : ", OADDRESS "배송 주소 : ", OTEL "배송지 전화 : "
    FROM ORDER_;

SELECT O.pCODE "상품코드", P.pNAME "상품명", P.pPRICE "단가", O.QTY "수량", O.COST "금액"  
    FROM ORDERDETAIL O, PRODUCT P
    WHERE O.pCODE = P.pCODE
        AND O.COST = P.pPRICE * O.QTY;