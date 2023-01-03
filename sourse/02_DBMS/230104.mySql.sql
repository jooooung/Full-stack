-- Oracle과 다른 점
-- DCL(계정생성, 권한부어, 권한박탈, 계정삭제)
-- DDL(제약조건, 시퀀스 없음)
-- DML(outer join, and;&&, or;||, 일부단일행함수)
-- Java에서 쓸 데이터 넣고 연습해보기

show databases;	-- database들의 리스트
-- ★ DCL ★
create user user01 identified by 'password';
-- create user 아이디 identified by '비밀번호';		-- (계정 만들기 비밀번호를 '' 안에 넣어야함)
grant all on *.* to user01;		-- 권한 부여(dba의 모든 권한)
-- = grant all privileges on *.* to user01;
flush privileges;	
revoke all privileges on *.* from user01;	-- 권한 박탈
drop user user01;	-- 계정 삭제
-- 데이터베이스로 들어가기
show databases;
create database andb;	-- 새로운 데이터베이스 생성
use andb;	-- andb 데이터베이스로 들어감
select database();	-- 현재 들어와 있는 데이터베이스 확인
show tables;	-- 현 데이터베이스 내의 테이블 보기
-- ★ DDL ★
-- 테이블 만들기(제약조건이 옆에)
create table emp(
	empno 	 numeric(4) primary key,
    ename 	 varchar(20) not null,
    nickname varchar(20) unique,	-- null 포함
    sal 	 numeric(7,2) check(sal>0),	-- null 포함
    comm 	 numeric(7,2) default 0
);
desc emp;
drop table if exists emp;	-- table 존재시에만 drop
-- 테이블 만들기 (제약조건이 밑에)
create table emp(
	empno 	 numeric(4),	-- numeric = number
    ename 	 varchar(20) not null,
    nickname varchar(20),	-- null 포함
    sal 	 numeric(7,2),	-- null 포함
    comm 	 numeric(7,2) default 0,
    primary key(empno),
    unique(ename),
    check(sal>0)
);
select * from emp;
insert into emp values (1111, '홍', '천사', 900, null);
drop table if exists emp;

-- MAJOR (mCode;pk 학과번호, mName 학과이름, mOffice 학과사무실)  학과번호를 시퀀스처럼 만들기
-- STUDENT (sNo 학번, sName 이름, mCode 학과번호)
create table major(
	mCode int primary key auto_increment,	-- auto_increment 필드의 경우 타입은 int (시퀀스와 같은 기능)
    mName varchar(30),
    mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
    sName varchar(30),
    mCode int references major(mCode) 	-- 외래키 제약조건을 옆에 쓰면 X
);
show tables;
select * from major;
select * from student;

-- major 데이터 넣기
-- mCode는 auto_increment이기에 자동으로 입력된다
insert into major (mName, mOffice) values ('컴콩', '203호');		
insert into major (mName, mOffice) values ('빅데이터', '303호');
insert into major (mName, mOffice) values ('디자인', '403호');
select * from major;
-- student 데이터 넣기
insert into student values (1111, '홍길동', 1);
insert into student values (1112, '신길동', 3);
insert into student values (1113, '박길동', 4);
select * from student;
-- mCode 가 major에서 받아오지 못하여 mCode=4를 입력해도 오류가 안 난다
-- foreign key가 되게 다시 만들기
drop table major;
drop table student;
create table major(
	mCode int primary key auto_increment,	-- auto_increment 필드의 경우 타입은 int (시퀀스와 같은 기능)
    mName varchar(30),
    mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
    sName varchar(30),
    mCode int,
    foreign key(mCode) references major(mCode)	-- 외래키 제약조건은 아래만
);
insert into major (mName, mOffice) values ('컴콩', '203호');		
insert into major (mName, mOffice) values ('빅데이터', '303호');
insert into major (mName, mOffice) values ('디자인', '403호');
select * from major;
insert into student values (1111, '홍길동', 1);
insert into student values (1112, '신길동', 3);
insert into student values (1113, '박길동', 4);	-- 에러 
select * from student;

	-- ex. 학번, 이름, 학과번호, 학과명, 학과사무실 출력	equi join
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode=m.mCode;
    -- ex. 학번, 이름, 학과번호, 학과명, 학과사무실 출력(학생이 없는 학과도 출력)  outer join
select sNo, sName, s.mCode, mName, mOffice
	from student s right outer join major m
    on s.mCode=m.mCode;
select sNo, sName, length(sName) from student;    

-- ★ ★ 자바(JDBC) 때 쓸 테이블 ★ ★
drop table if exists personal;
drop table if exists division;
create table division(
	dno int,	-- 부서번호
    dname varchar(20), -- 부서이름
    phone varchar(20), -- 부서전화
    position varchar(20), -- 부서위치
    primary key(dno)
);
create table personal(
	pno int,	-- 사번
    pname varchar(20) not null, -- 사원명
    job varchar(20) not null, -- 직책
    manager int,	-- 상사의 사번
    startdate date,	-- 입사일
    pay int,	-- 월급
    bonus int,	-- 상여금
    dno int,		-- 부서번호
    primary key(pno),
    foreign key (dno) references division(dno)
);
select * from division;
-- division 데이터 넣기
insert into division values (10, 'finance', '02-393-4321', '서대문');
insert into division values (20, 'research', '02-555-4321', '강남');
insert into division values (30, 'sales', '02-717-4321', '마포');
insert into division values (40, 'cs', '031-4444-4321', '안양');
-- personal 데이터 넣기
insert into personal values (1111,'smith','manager', 1001, '1990-12-17', 1000, null, 10);
insert into personal values (1112,'ally','salesman',1116,'1991-02-20',1600,500,30);
insert into personal values (1113,'word','salesman',1116,'1992-02-24',1450,300,30);
insert into personal values (1114,'james','manager',1001,'1990-04-12',3975,null,20);
insert into personal values (1001,'bill','president',null,'1989-01-10',7000,null,10);
insert into personal values (1116,'johnson','manager',1001,'1991-05-01',3550,null,30);
insert into personal values (1118,'martin','analyst',1111,'1991-09-09',3450,null,10);
insert into personal values (1121,'kim','clerk',1114,'1990-12-08',4000,null,20);
insert into personal values (1123,'lee','salesman',1116,'1991-09-23',1200,0,30);
insert into personal values (1226,'park','analyst',1111,'1990-01-03',2500,null,10);
select pno, pname, pay, pay*12+ifnull(bonus, 0) from personal;	-- ifnull() = nvl
select pno, pname, pay, pay*12+if(bonus is null, 0, bonus) from personal;  -- if(필드의 조건, 참, 거짓)

-- ★ ★ DML ★ ★