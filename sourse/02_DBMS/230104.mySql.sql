-- Oracle怨??ㅻⅨ ??
-- DCL(怨꾩젙?앹꽦, 沅뚰븳遺?? 沅뚰븳諛뺥깉, 怨꾩젙??젣)
-- DDL(?쒖빟議곌굔, ?쒗???놁쓬)
-- DML(outer join, and;&&, or;||, ?쇰??⑥씪?됲븿??
-- Java?먯꽌 ???곗씠???ｊ퀬 ?곗뒿?대낫湲?

show databases;	-- database?ㅼ쓽 由ъ뒪??
-- ??DCL ??
create user user01 identified by 'password';
-- create user ?꾩씠??identified by '鍮꾨?踰덊샇';		-- (怨꾩젙 留뚮뱾湲?鍮꾨?踰덊샇瑜?'' ?덉뿉 ?ｌ뼱?쇳븿)
grant all on *.* to user01;		-- 沅뚰븳 遺??dba??紐⑤뱺 沅뚰븳)
-- = grant all privileges on *.* to user01;
flush privileges;	
revoke all privileges on *.* from user01;	-- 沅뚰븳 諛뺥깉
drop user user01;	-- 怨꾩젙 ??젣
-- ?곗씠?곕쿋?댁뒪濡??ㅼ뼱媛湲?
show databases;
create database kimdb;	-- ?덈줈???곗씠?곕쿋?댁뒪 ?앹꽦
use kimdb;	-- andb ?곗씠?곕쿋?댁뒪濡??ㅼ뼱媛?
select database();	-- ?꾩옱 ?ㅼ뼱? ?덈뒗 ?곗씠?곕쿋?댁뒪 ?뺤씤
show tables;	-- ???곗씠?곕쿋?댁뒪 ?댁쓽 ?뚯씠釉?蹂닿린
-- ??DDL ??
-- ?뚯씠釉?留뚮뱾湲??쒖빟議곌굔???놁뿉)
create table emp(
	empno 	 numeric(4) primary key,
    ename 	 varchar(20) not null,
    nickname varchar(20) unique,	-- null ?ы븿
    sal 	 numeric(7,2) check(sal>0),	-- null ?ы븿
    comm 	 numeric(7,2) default 0
);
desc emp;
drop table if exists emp;	-- table 議댁옱?쒖뿉留?drop
-- ?뚯씠釉?留뚮뱾湲?(?쒖빟議곌굔??諛묒뿉)
create table emp(
	empno 	 numeric(4),	-- numeric = number
    ename 	 varchar(20) not null,
    nickname varchar(20),	-- null ?ы븿
    sal 	 numeric(7,2),	-- null ?ы븿
    comm 	 numeric(7,2) default 0,
    primary key(empno),
    unique(ename),
    check(sal>0)
);
select * from emp;
insert into emp values (1111, '??, '泥쒖궗', 900, null);
drop table if exists emp;

-- MAJOR (mCode;pk ?숆낵踰덊샇, mName ?숆낵?대쫫, mOffice ?숆낵?щТ??  ?숆낵踰덊샇瑜??쒗?ㅼ쿂??留뚮뱾湲?
-- STUDENT (sNo ?숇쾲, sName ?대쫫, mCode ?숆낵踰덊샇)
create table major(
	mCode int primary key auto_increment,	-- auto_increment ?꾨뱶??寃쎌슦 ??낆? int (?쒗?ㅼ? 媛숈? 湲곕뒫)
    mName varchar(30),
    mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
    sName varchar(30),
    mCode int references major(mCode) 	-- ?몃옒???쒖빟議곌굔???놁뿉 ?곕㈃ X
);
show tables;
select * from major;
select * from student;

-- major ?곗씠???ｊ린
-- mCode??auto_increment?닿린???먮룞?쇰줈 ?낅젰?쒕떎
insert into major (mName, mOffice) values ('而댁쉘', '203??);		
insert into major (mName, mOffice) values ('鍮낅뜲?댄꽣', '303??);
insert into major (mName, mOffice) values ('?붿옄??, '403??);
select * from major;
-- student ?곗씠???ｊ린
insert into student values (1111, '?띻만??, 1);
insert into student values (1112, '?좉만??, 3);
insert into student values (1113, '諛뺢만??, 4);
select * from student;
-- mCode 媛 major?먯꽌 諛쏆븘?ㅼ? 紐삵븯??mCode=4瑜??낅젰?대룄 ?ㅻ쪟媛 ???쒕떎
-- foreign key媛 ?섍쾶 ?ㅼ떆 留뚮뱾湲?
drop table major;
drop table student;
create table major(
	mCode int primary key auto_increment,	-- auto_increment ?꾨뱶??寃쎌슦 ??낆? int (?쒗?ㅼ? 媛숈? 湲곕뒫)
    mName varchar(30),
    mOffice varchar(30)
);
create table student(
	sNo numeric(4) primary key,
    sName varchar(30),
    mCode int,
    foreign key(mCode) references major(mCode)	-- ?몃옒???쒖빟議곌굔? ?꾨옒留?
);
insert into major (mName, mOffice) values ('而댁쉘', '203??);		
insert into major (mName, mOffice) values ('鍮낅뜲?댄꽣', '303??);
insert into major (mName, mOffice) values ('?붿옄??, '403??);
select * from major;
insert into student values (1111, '?띻만??, 1);
insert into student values (1112, '?좉만??, 3);
insert into student values (1113, '諛뺢만??, 4);	-- ?먮윭 
select * from student;

	-- ex. ?숇쾲, ?대쫫, ?숆낵踰덊샇, ?숆낵紐? ?숆낵?щТ??異쒕젰	equi join
select sNo, sName, s.mCode, mName, mOffice
	from student s, major m
    where s.mCode=m.mCode;
    -- ex. ?숇쾲, ?대쫫, ?숆낵踰덊샇, ?숆낵紐? ?숆낵?щТ??異쒕젰(?숈깮???녿뒗 ?숆낵??異쒕젰)  outer join
select sNo, sName, s.mCode, mName, mOffice
	from student s right outer join major m
    on s.mCode=m.mCode;
select sNo, sName, length(sName) from student;    

-- ?????먮컮(JDBC) ?????뚯씠釉?????
drop table if exists personal;
drop table if exists division;
create table division(
	dno int,	-- 遺?쒕쾲??
    dname varchar(20), -- 遺?쒖씠由?
    phone varchar(20), -- 遺?쒖쟾??
    position varchar(20), -- 遺?쒖쐞移?
    primary key(dno)
);
create table personal(
	pno int,	-- ?щ쾲
    pname varchar(20) not null, -- ?ъ썝紐?
    job varchar(20) not null, -- 吏곸콉
    manager int,	-- ?곸궗???щ쾲
    startdate date,	-- ?낆궗??
    pay int,	-- ?붽툒
    bonus int,	-- ?곸뿬湲?
    dno int,		-- 遺?쒕쾲??
    primary key(pno),
    foreign key (dno) references division(dno)
);
select * from division;
-- division ?곗씠???ｊ린
insert into division values (10, 'finance', '02-393-4321', '?쒕?臾?);
insert into division values (20, 'research', '02-555-4321', '媛뺣궓');
insert into division values (30, 'sales', '02-717-4321', '留덊룷');
insert into division values (40, 'cs', '031-4444-4321', '?덉뼇');
-- personal ?곗씠???ｊ린
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
select pno, pname, pay, pay*12+if(bonus is null, 0, bonus) from personal;  -- if(?꾨뱶??議곌굔, 李? 嫄곗쭞)
commit;
-- ????DML ????
use kimdb;
select database();

select * from personal;
select * from division;
-- ???곗뒿臾몄젣 ??
-- 1. ?щ쾲, ?대쫫, 湲됱뿬瑜?異쒕젰
select pno, pname, pay from personal;
-- 2. 湲됱뿬媛 2000~5000 ?ъ씠 紐⑤뱺 吏곸썝??紐⑤뱺 ?꾨뱶
select * from personal where pay between 2000 and 5000;
-- 3. 遺?쒕쾲?멸? 10?먮뒗 20???ъ썝???щ쾲, ?대쫫, 遺?쒕쾲??
select pno, pname, dno from personal where dno in (10, 20);
-- 4. 蹂대꼫?ㅺ? null???ъ썝???щ쾲, ?대쫫, 湲됱뿬 湲됱뿬 ???쒖젙??
select pno, pname, pay from personal where bonus is null order by pay desc;
-- 5. ?щ쾲, ?대쫫, 遺?쒕쾲?? 湲됱뿬. 遺?쒖퐫?????뺣젹 媛숈쑝硫?PAY ?곗닚
select pno, pname, dno, pay, dno from personal order by dno, pay desc;
-- 6. ?щ쾲, ?대쫫, 遺?쒕챸
select pno, pname, dname from personal p, division d
	where p.dno=d.dno;
-- 7. ?щ쾲, ?대쫫, ?곸궗?대쫫
select p1.pno, p1.pname worker, p2.pname manager 
	from personal p1, personal p2
	where p1.manager=p2.pno;
-- 8. ?щ쾲, ?대쫫, ?곸궗?대쫫(?곸궗媛 ?녿뒗 ?щ엺??異쒕젰)
select p1.pno, p1.pname worker, p2.pname manager 
	from personal p1 left outer join personal p2
	on p1.manager=p2.pno;
-- 8-1. ?щ쾲, ?대쫫, ?곸궗?대쫫(?곸궗媛 ?녿뒗 ?щ엺??異쒕젰)+遺?쒕챸
select p1.pno, p1.pname worker, p2.pname manager, dname
	from division d, personal p1 left outer join personal p2
	on p1.manager=p2.pno
    where p1.dno=d.dno;
-- 9. ?대쫫??s濡??쒖옉?섎뒗 ?ъ썝 ?대쫫
select pname from personal
	where pname like 's%';
-- 10. ?щ쾲, ?대쫫, 湲됱뿬, 遺?쒕챸, ?곸궗?대쫫
select p1.pno, p1.pname pname, p1.pay, dname, p2.pname manager
	from personal p1, personal p2, division d
    where p1.manager=p2.pno and p1.dno=d.dno;
-- 11. 遺?쒖퐫?? 湲됱뿬?⑷퀎, 理쒕?湲됱뿬
select dno, sum(pay) sumpay, max(pay) maxpay
	from personal
    group by dno;
-- 12. 遺?쒕챸, 湲됱뿬?됯퇏, ?몄썝??
select dname, avg(pay), count(*) 
	from personal p, division d
    where p.dno=d.dno
    group by dname;
-- 13. 遺?쒖퐫?? 湲됱뿬?⑷퀎, ?몄썝???몄썝?섍? 4紐??댁긽??遺?쒕쭔 異쒕젰
select dno, sum(pay), count(*)
	from personal
    group by dno
    having count(*) >=4;
-- 14. ?щ쾲, ?대쫫, 湲됱뿬 ?뚯궗?먯꽌 ?쒖씪 湲됱뿬瑜?留롮씠 諛쏅뒗 ?щ엺
select pno, pname, pay
	from personal
    where pay = (select max(pay) from personal);
-- 15. ?뚯궗 ?됯퇏蹂대떎 湲됱뿬瑜?留롮씠 諛쏅뒗 ?щ엺 ?대쫫, 湲됱뿬, 遺?쒕쾲??
select pname, pay, dno
	from personal
	where pay > (select avg(pay) from personal);
-- 16. ?뚯궗 ?됯퇏 湲됱뿬蹂대떎 留롮씠 諛쏅뒗 ?ъ썝???щ쾲, ?대쫫, 湲됱뿬, 遺?쒕챸??異쒕젰(遺?쒕챸???뺤뿴 媛숈쑝硫?湲됱뿬 ?곗닚 ?뺣젹)
select pno, pname, pay, dname
	from personal p, division d
	where p.dno=d.dno
		and pay > (select avg(pay) from personal)
	order by dname, pay desc;
-- 17. ?먯떊???랁븳 遺?쒖쓽 ?됯퇏蹂대떎 留롮씤 諛쏅뒗 ?щ엺???대쫫, 湲덉뿬, 遺?쒕쾲?? 諛섏삱由쇳븳 ?대떦遺?쒗룊洹?
select p.pname, p.pay, p.dno, round(avgpay) avg
	from personal p, (select dno, avg(pay) avgpay from personal group by dno) a
    where p.dno=a.dno and p.pay> avgpay;
-- 18. ?낆궗媛 媛??鍮좊Ⅸ ?щ엺???대쫫, 湲됱뿬, 遺?쒕챸
 select pname, pay, dname
	from personal p, division d
    where p.dno=d.dno and startdate = (select min(startdate) from personal); 
-- 19. ?대쫫, 湲됱뿬, ?대떦遺?쒗룊洹?
select pname, pay, round(dpay)
	from personal p, (select dno, avg(pay) dpay from personal group by dno) a
    where p.dno=a.dno;
-- 20. ?대쫫, 湲됱뿬, 遺?쒕챸, ?대떦遺?쒗룊洹?
select pname, pay, dname, round(dpay)
	from personal p, division d, (select dno, avg(pay) dpay from personal group by dno) a
    where p.dno=a.dno and p.dno=d.dno;
    
-- ????Oracle?먯꽌???⑥씪?됲븿?섏? ?ㅻⅨ 遺遺?????
select curdate();
insert into personal values (1000, '?띻만??, 'manager', 1001, curdate(), null, null, 40);
select * from personal where pno=1000;
set sql_safe_updates = 0;
delete from personal where pname='?띻만??;

	-- ex. "?대쫫? job?대떎"
select concat(pname, '? ', job, '?대떎') msg from personal;	-- mysql? concat ?덉뿉 ??媛??댁긽??媛??
select round(23.456);	-- from ?덉씠 ?놁뼱???ㅽ뻾 媛??

-- ?쒖뒪?쒖쑝濡쒕????꾩옱 ?쒖젏,  ?꾩옱 ?좎쭨, ?꾩옱 ?쒓컙
select sysdate();
select now();
select year(sysdate()), month(now()), day(now());	-- ?먰븯???좎쭨 ?뺤떇
select case weekday(now())
	when '0' then '?붿슂??
    when '1' then '?붿슂??
    when '2' then '?섏슂??
    when '3' then '紐⑹슂??
    when '4' then '湲덉슂??
    when '5' then '?좎슂??
    when '6' then '?쇱슂?? end dayofweek;		-- ?붿씪(?쒓?)
select dayname(now());	-- ?붿씪(?곸뼱)
select monthname(now());	-- ??(?곸뼱)
select pname, dayname(startdate) from personal;		-- ?낆궗?쇱쓽 ?붿씪 
select pname, year(startdate), month(startdate), day(startdate) from personal;

-- ?쒖뒪?쒖쑝濡쒕????꾩옱 ?좎쭨
select curdate();
-- ?쒖뒪?쒖쑝濡쒕????꾩옱 ?쒓컙
select curtime();

-- date_format(?좎쭨/?쒓컙, ?щ㎎) -> 臾몄옄
-- date_format(臾몄옄, ?щ㎎) -> ?좎쭨
	-- ?щ㎎ : %Y 2023(?꾨룄 4?먮━) %y(?꾨룄2?먮━)
	-- 		 %m (01?? 02??.), %c(1??2??  %M (?붿씠由??곸뼱)), %b(吏㏃? ?붿씠由?Jan))
	-- 		 %d (01 02??.), %e(1, 2, 3??
    -- 		 %H (24?쒓컙)	%h(12?쒓컙)	%p(?ㅼ쟾 ?ㅽ썑)	%i(遺? %s(珥?
select date_format(now(), '%Y??%c??%e??%p %h??%i遺?%s珥?) now;
select * from personal where startdate < date_format('1990-08-10', '%Y-%m-%d');

-- format(?レ옄, ?뚯닔???먮━?? -> 臾몄옄 	?먮룞?쇰줈 ?몄옄由щ쭏??,
select pname, format(pay, 2) from personal;

-- ?대쫫, 湲됱뿬, 湲덉뿬 3000 ?댁긽?몄? ?щ?
select pname, pay, if(pay>=3000, '?댁긽', '?댄븯') result from personal;
select pname, pay, bonus, if(bonus is null, 0, bonus) from personal;
select pname, bonus, ifnull(bonus, 0) from personal;

-- ????top-n 援щЦ ????
select pname, pay from personal order by pay desc;
-- limit n (1~n??
select pname, pay from personal order by pay desc limit 5;	-- 1??~ 5??
-- limit n1, n2 (n1踰덉㎏遺??n2媛? 泥ル쾲吏몃뒗 0踰덉㎏)
select pname, pay from personal order by pay desc limit 0, 5;	-- 1?깅???5媛? 1~5??
select pname, pay from personal order by pay desc limit 5, 5;	-- 6?깅???5媛? 6~10??
select pname, pay from personal order by pay desc limit 6, 3;	-- 7?깅???3媛? 7~9??
