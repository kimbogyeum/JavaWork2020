SELECT *
FROM T_CUSTOMER 

SELECT *
FROM T_GIFT;

--#6201
--Oracle 방식
SELECT c.C_NAME "고객명", c.C_POINT "POINT",g.G_NAME "상품명"
FROM T_CUSTOMER c,T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END ;

--ANSI 방식
SELECT c.C_NAME "고객명", c.C_POINT "POINT",g.G_NAME "상품명"
FROM T_CUSTOMER c JOIN T_GIFT g ON c.C_POINT BETWEEN g.G_START AND g.G_END ;

--#6202
--Oracle 방식
SELECT g.G_NAME "상품명", COUNT(g.G_NAME ) "필요수량"
FROM T_CUSTOMER c,T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START AND g.G_END
GROUP BY g.G_NAME;

--ANSI 방식
SELECT  g.G_NAME "상품명", COUNT(g.G_NAME ) "필요수량"
FROM T_CUSTOMER c JOIN T_GIFT g ON c.C_POINT BETWEEN g.G_START AND g.G_END 
GROUP BY g.G_NAME;



SELECT *FROM T_STUDENT ;
SELECT *FROM T_EXAM01 ;
SELECT *FROM T_CREDIT ;

--#6203
--Oracle 방식
SELECT s.NAME "학생이름", e.TOTAL "점수", c.GRADE "학점"
FROM T_STUDENT s,T_EXAM01 e,T_CREDIT c
WHERE s.STUDNO =e.STUDNO AND e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT ;

--ANSI 방식
SELECT s.NAME "학생이름", e.TOTAL "점수", c.GRADE "학점"
FROM T_STUDENT s
JOIN T_EXAM01 e ON  s.STUDNO =e.STUDNO
JOIN T_CREDIT c ON e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT ;


--#6204
--Oracle 방식
SELECT c.C_NAME  "고객명", c.C_POINT "POINT" ,g.G_NAME "상품명"
FROM T_CUSTOMER c,T_GIFT g
WHERE c.C_POINT >=g.G_START AND g.G_NAME ='산악용자전거';

--ANSI 방식
SELECT c.C_NAME  "고객명", c.C_POINT "POINT" ,g.G_NAME "상품명"
FROM T_CUSTOMER c
JOIN T_GIFT g ON c.C_POINT >=g.G_START AND g.G_NAME ='산악용자전거';


SELECT*FROM T_GIFT ;
SELECT *FROM T_EMP2 ;
SELECT *FROM T_POST ;


--#6205
--Oracle 방식
SELECT e.NAME 이름,
		(TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(e.BIRTHDAY ,'YYYY')+1) 현재나이,
		NVL(e.POST,' ') 현재직급,
		p.POST "예상직급" 
FROM T_EMP2 e, T_POST p
WHERE (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(e.BIRTHDAY ,'YYYY')+1) 
BETWEEN p.S_AGE AND p.E_AGE ;


--ANSI 방식
SELECT e.NAME 이름,
		(TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(e.BIRTHDAY ,'YYYY')+1) 현재나이,
		NVL(e.POST,' ') 현재직급,
		p.POST "예상직급" 
FROM T_EMP2 e
JOIN T_POST p ON (TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(e.BIRTHDAY ,'YYYY')+1) 
BETWEEN p.S_AGE AND p.E_AGE ;


﻿--OUTER JOIN
-- #6206)
--t_student 테이블과 t_professor 테이블 Join : 
--학생이름과 지도교수 이름을 출력하세요. 
--단! 지도교수가 결정되지 않은 학생의 명단도 함께 출력하세요

--** 기존의 INNER Join 방식으로 먼저 만들어 보고 OUTER Join 을 해보고 비교해보자

SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s LEFT OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;

-- #6207
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s RIGHT OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;

-- #6208
SELECT s.name "학생이름", p.name "교수이름"
FROM t_student s FULL OUTER JOIN t_professor p
	ON s.profno = p.PROFNO
;

------------------------------------------------
-- self join

-- #6209) 
-- t_dept2 테이블에서 
-- 부서명 과 그 부서의 상위부서명을 출력하세요

SELECT * FROM T_DEPT2 

SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1, t_dept2 d2
WHERE d1.pdept = d2.dcode;

-- ANSI
SELECT d1.dname "부서명", d2.dname "상위부서명"
FROM t_dept2 d1 JOIN t_dept2 d2
	ON d1.pdept = d2.dcode;


SELECT * FROM T_PROFESSOR;

SELECT p1.PROFNO "교수번호", 
		p1.NAME "교수명", 
		p1.HIREDATE "입사일",
		COUNT(p2.HIREDATE ) 빠른사람
FROM 
	T_PROFESSOR p1 LEFT OUTER JOIN T_PROFESSOR  p2
	ON p2.HIREDATE <p1.HIREDATE 
GROUP BY p1.PROFNO,p1.NAME,p1.HIREDATE
ORDER BY 4;--4번쨰 컬럼






