--JOIN

--FROM 절에 테이블에도 별칭(alias)를 줄 수 있다!

--20 레코드
SELECT S.STUDNO,S.NAME,S.DEPTNO1
FROM T_STUDENT S;

--12 레코드
SELECT D.DEPTNO ,D.DNAME
FROM T_DEPARTMENT  D

SELECT S.STUDNO ,S.NAME ,S.DEPTNO1 ,D.DEPTNO, D.DNAME 
FROM T_STUDENT S
CROSS JOIN T_DEPARTMENT D

SELECT S.STUDNO ,S.NAME ,S.DEPTNO1 ,D.DEPTNO, D.DNAME 
FROM T_STUDENT S,T_DEPARTMENT D


--Equi Join(등가 Join)
--Oracle Join 방식
SELECT s.name "학생이름",s.deptno1 "학과번호",d.DNAME "학과이름"
FROM T_STUDENT s,T_DEPARTMENT d
WHERE s.DEPTNO1 =d.DEPTNO; --조건(equi JOIN)

--ANSI 방식
SELECT s.name "학생이름",s.deptno1 "학과번호",d.DNAME "학과이름"
FROM T_STUDENT s 
JOIN T_DEPARTMENT d ON s.DEPTNO1 =d.DEPTNO; --조건(equi JOIN)

SELECT * FROM T_STUDENT ;
SELECT * FROM T_DEPARTMENT;
SELECT * FROM T_PROFESSOR ;

--제2전공은? deptno2
SELECT s.NAME "학생이름",s.DEPTNO1 "학과번호",d.DNAME "제2학과이름"
FROM T_STUDENT s,T_DEPARTMENT d
WHERE s.DEPTNO2 =d.DEPTNO;

--#6102
--oracle방식
SELECT s.name 학생이름, p.PROFNO "지도교수 번호", p.NAME "지도교수이름"
FROM T_STUDENT s,T_PROFESSOR p
WHERE s.PROFNO=p.PROFNO 

--ANSI 방식 
SELECT s.name 학생이름, p.PROFNO "지도교수 번호", p.NAME "지도교수이름"
FROM T_STUDENT s
JOIN T_PROFESSOR p ON s.PROFNO=p.PROFNO 

--#6103
--oracle방식
SELECT s.NAME "학생이름",d.DNAME "학과이름", p.NAME "교수이름"
FROM T_STUDENT s,T_DEPARTMENT d,T_PROFESSOR p
WHERE s.DEPTNO1 =d.DEPTNO AND s.PROFNO =p.PROFNO ;

--ANSI 방식 
SELECT s.NAME "학생이름",d.DNAME "학과이름", p.NAME "교수이름"
FROM T_STUDENT s
	JOIN T_DEPARTMENT d ON s.DEPTNO1 =d.DEPTNO
    JOIN T_PROFESSOR p ON s.PROFNO =p.PROFNO ;
   
SELECT *FROM T_EMP2;
SELECT *FROM T_POST;

--#6104
--oracle방식
SELECT e.NAME 사원이름, e.POST "현재", e.PAY "현재연봉", p.S_PAY "하한금액", p.E_PAY "상한금액"
FROM T_EMP2 e,T_POST p
WHERE e.POST =p.POST ;

--ANSI 방식 
SELECT e.NAME 사원이름, e.POST "현재", e.PAY "현재연봉", p.S_PAY "하한금액", p.E_PAY "상한금액"
FROM T_EMP2 e
JOIN T_POST p
ON e.POST =p.POST ;


--#6105
--oracle방식
SELECT s.NAME "학생이름",p.NAME "교수이름"
FROM T_STUDENT s,T_PROFESSOR p
WHERE s.PROFNO =p.PROFNO  AND s.DEPTNO1 =101;

--ANSI 방식 
SELECT s.NAME "학생이름",p.NAME "교수이름"
FROM T_STUDENT s JOIN T_PROFESSOR p ON s.PROFNO =p.PROFNO 
WHERE s.DEPTNO1 =101; --where 빼고 그냥 and로 연결해도 된다. 


 
   
