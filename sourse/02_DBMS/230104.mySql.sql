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
create database kimdb;	-- 새로운 데이터베이스 생성
use kimdb;	-- andb 데이터베이스로 들어감
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
commit;
-- ★ ★ DML ★ ★
use kimdb;
select database();

select * from personal;
select * from division;
-- ★ 연습문제 ★
-- 1. 사번, 이름, 급여를 출력
select pno, pname, pay from personal;
-- 2. 급여가 2000~5000 사이 모든 직원의 모든 필드
select * from personal where pay between 2000 and 5000;
-- 3. 부서번호가 10또는 20인 사원의 사번, 이름, 부서번호
select pno, pname, dno from personal where dno in (10, 20);
-- 4. 보너스가 null인 사원의 사번, 이름, 급여 급여 큰 순정렬
select pno, pname, pay from personal where bonus is null order by pay desc;
-- 5. 사번, 이름, 부서번호, 급여. 부서코드 순 정렬 같으면 PAY 큰순
select pno, pname, dno, pay, dno from personal order by dno, pay desc;
-- 6. 사번, 이름, 부서명
select pno, pname, dname from personal p, division d
	where p.dno=d.dno;
-- 7. 사번, 이름, 상사이름
select p1.pno, p1.pname worker, p2.pname manager 
	from personal p1, personal p2
	where p1.manager=p2.pno;
-- 8. 사번, 이름, 상사이름(상사가 없는 사람도 출력)
select p1.pno, p1.pname worker, p2.pname manager 
	from personal p1 left outer join personal p2
	on p1.manager=p2.pno;
-- 8-1. 사번, 이름, 상사이름(상사가 없는 사람도 출력)+부서명
select p1.pno, p1.pname worker, p2.pname manager, dname
	from division d, personal p1 left outer join personal p2
	on p1.manager=p2.pno
    where p1.dno=d.dno;
-- 9. 이름이 s로 시작하는 사원 이름
select pname from personal
	where pname like 's%';
-- 10. 사번, 이름, 급여, 부서명, 상사이름
select p1.pno, p1.pname pname, p1.pay, dname, p2.pname manager
	from personal p1, personal p2, division d
    where p1.manager=p2.pno and p1.dno=d.dno;
-- 11. 부서코드, 급여합계, 최대급여
select dno, sum(pay) sumpay, max(pay) maxpay
	from personal
    group by dno;
-- 12. 부서명, 급여평균, 인원수
select dname, avg(pay), count(*) 
	from personal p, division d
    where p.dno=d.dno
    group by dname;
-- 13. 부서코드, 급여합계, 인원수 인원수가 4명 이상인 부서만 출력
select dno, sum(pay), count(*)
	from personal
    group by dno
    having count(*) >=4;
-- 14. 사번, 이름, 급여 회사에서 제일 급여를 많이 받는 사람
select pno, pname, pay
	from personal
    where pay = (select max(pay) from personal);
-- 15. 회사 평균보다 급여를 많이 받는 사람 이름, 급여, 부서번호
select pname, pay, dno
	from personal
	where pay > (select avg(pay) from personal);
-- 16. 회사 평균 급여보다 많이 받는 사원의 사번, 이름, 급여, 부서명을 출력(부서명순 정열 같으면 급여 큰순 정렬)
select pno, pname, pay, dname
	from personal p, division d
	where p.dno=d.dno
		and pay > (select avg(pay) from personal)
	order by dname, pay desc;
-- 17. 자신이 속한 부서의 평균보다 많인 받는 사람의 이름, 금여, 부서번호, 반올림한 해당부서평균
select p.pname, p.pay, p.dno, round(avgpay) avg
	from personal p, (select dno, avg(pay) avgpay from personal group by dno) a
    where p.dno=a.dno and p.pay> avgpay;
-- 18. 입사가 가장 빠른 사람의 이름, 급여, 부서명
 select pname, pay, dname
	from personal p, division d
    where p.dno=d.dno and startdate = (select min(startdate) from personal); 
-- 19. 이름, 급여, 해당부서평균
select pname, pay, round(dpay)
	from personal p, (select dno, avg(pay) dpay from personal group by dno) a
    where p.dno=a.dno;
-- 20. 이름, 급여, 부서명, 해당부서평균
select pname, pay, dname, round(dpay)
	from personal p, division d, (select dno, avg(pay) dpay from personal group by dno) a
    where p.dno=a.dno and p.dno=d.dno;
    
-- ★ ★ Oracle에서의 단일행함수와 다른 부분 ★ ★
select curdate();
insert into personal values (1000, '홍길동', 'manager', 1001, curdate(), null, null, 40);
select * from personal where pno=1000;
set sql_safe_updates = 0;
delete from personal where pname='홍길동';

	-- ex. "이름은 job이다"
select concat(pname, '은 ', job, '이다') msg from personal;	-- mysql은 concat 안에 두 개 이상도 가능
select round(23.456);	-- from 절이 없어도 실행 가능

-- 시스템으로부터 현재 시점,  현재 날짜, 현재 시간
select sysdate();
select now();
select year(sysdate()), month(now()), day(now());	-- 원하는 날짜 형식
select case weekday(now())
	when '0' then '월요일'
    when '1' then '화요일'
    when '2' then '수요일'
    when '3' then '목요일'
    when '4' then '금요일'
    when '5' then '토요일'
    when '6' then '일요일' end dayofweek;		-- 요일(한글)
select dayname(now());	-- 요일(영어)
select monthname(now());	-- 달 (영어)
select pname, dayname(startdate) from personal;		-- 입사일의 요일 
select pname, year(startdate), month(startdate), day(startdate) from personal;

-- 시스템으로부터 현재 날짜
select curdate();
-- 시스템으로부터 현재 시간
select curtime();

-- date_format(날짜/시간, 포맷) -> 문자
-- date_format(문자, 포맷) -> 날짜
	-- 포맷 : %Y 2023(년도 4자리) %y(년도2자리)
	-- 		 %m (01월, 02월..), %c(1월 2월)  %M (월이름(영어)), %b(짧은 월이름(Jan))
	-- 		 %d (01 02일..), %e(1, 2, 3일)
    -- 		 %H (24시간)	%h(12시간)	%p(오전 오후)	%i(분) %s(초)
select date_format(now(), '%Y년 %c월 %e일 %p %h시 %i분 %s초') now;
select * from personal where startdate < date_format('1990-08-10', '%Y-%m-%d');

-- format(숫자, 소수점 자리수) -> 문자 	자동으로 세자리마다 ,
select pname, format(pay, 2) from personal;

-- 이름, 급여, 금여 3000 이상인지 여부
select pname, pay, if(pay>=3000, '이상', '이하') result from personal;
select pname, pay, bonus, if(bonus is null, 0, bonus) from personal;
select pname, bonus, ifnull(bonus, 0) from personal;

-- ★ ★ top-n 구문 ★ ★
select pname, pay from personal order by pay desc;
-- limit n (1~n등)
select pname, pay from personal order by pay desc limit 5;	-- 1등 ~ 5등
-- limit n1, n2 (n1번째부터 n2개, 첫번째는 0번째)
select pname, pay from personal order by pay desc limit 0, 5;	-- 1등부터 5개  1~5등
select pname, pay from personal order by pay desc limit 5, 5;	-- 6등부터 5개  6~10등
select pname, pay from personal order by pay desc limit 6, 3;	-- 7등부터 3개  7~9등
