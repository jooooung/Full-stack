-- book.xml
-- id = mainList(신간도서순)
SELECT * FROM BOOK ORDER BY BRDATE DESC;
-- id = bookList(startRow - endRow schItem에 따라 schWord로 검색한 제목순)
-- (1) schItem이 null 또는 ''일 때
SELECT * 
  FROM (SELECT B.*, ROWNUM RN 
    FROM (SELECT * FROM BOOK ORDER BY BTITLE) B) 
    WHERE RN BETWEEN 1 AND 5;
-- (2) schItem이 'all'일 때
SELECT * 
  FROM (SELECT B.*, ROWNUM RN 
    FROM (SELECT * FROM BOOK 
            WHERE BTITLE LIKE '%'||'J'||'%' OR BWRITER LIKE '%'||'A'||'%' ORDER BY BTITLE) B) 
    WHERE RN BETWEEN 1 AND 5;
-- (3) schItem이 'btitle'일 때
SELECT * 
  FROM (SELECT B.*, ROWNUM RN 
    FROM (SELECT * FROM BOOK 
            WHERE BTITLE LIKE '%'||'J'||'%' ORDER BY BTITLE) B) 
    WHERE RN BETWEEN 1 AND 5;
-- (4) schItem이 'bwriter'일 때
SELECT * 
  FROM (SELECT B.*, ROWNUM RN 
    FROM (SELECT * FROM BOOK 
            WHERE BWRITER LIKE '%'||'홍'||'%' ORDER BY BTITLE) B) 
    WHERE RN BETWEEN 1 AND 5;
    
-- id = totCntBook(책개수)
    -- (1) schItem이 null 또는 ''일 때
SELECT COUNT(*) FROM BOOK;
    -- (2) schItem이 'all'일 때
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%' OR BWRITER LIKE '%'||'A'||'%';
    -- (3) schItem이 'btitle'일 때
SELECT COUNT(*) FROM BOOK WHERE BTITLE LIKE '%'||'J'||'%';
    -- (4) schItem이 'bwriter'일 때
SELECT COUNT(*) FROM BOOK WHERE BWRITER LIKE '%'||'A'||'%';
-- id = getDetailBook (책번호로 dto 가져오기)
SELECT * FROM BOOK WHERE BNUM = 1;
-- id = registerBook (책등록)
INSERT INTO BOOK VALUES (BOOK_SQ.NEXTVAL, 'SPRING','김작가',SYSDATE, 'noImg.png','noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'ORACLE','홍작가','23/04/13', 'noImg.png', 'noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG2, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'ORACLE','홍작가','23/04/13', 'noImg.png','스프링개념서');
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bINFO)
    VALUES (BOOK_SQ.NEXTVAL, 'JAVA','이자바',SYSDATE, '스프링개념서');
-- id = modifyBook (책수정)
UPDATE BOOK SET BTITLE = 'JAVA',
                BWRITER = '이자바',
                BRDATE = SYSDATE,
                BIMG1 = 'noImg.png',
                BIMG2 = 'noImg.png',
                BINFO = '스프링 개념서'
        WHERE BNUM = 3;
    
-- member.xml
-- id = idConfirm(mid가 id인 데이터 개수)
SELECT COUNT(*) FROM MEMBER WHERE MID = 'aaa';
-- id = joinMember(회원가입)
INSERT INTO MEMBER VALUES ('b','1','박길동','BARK@naver.com','12345','서울');
-- id = getDetailMember(mid로 member Dto 가져오기)
SELECT * FROM MEMBER WHERE MID = 'b';
-- id = modifyMember(회원정보 수정)
UPDATE MEMBER SET MPW = '1',
                  MNAME = '박길동',
                  MMAIL = 'BARK@naver.com',
                  MPOST = '12345',
                  MADDR = '서울'
            WHERE MID = 'b';
COMMIT;