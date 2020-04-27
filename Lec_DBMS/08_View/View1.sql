CREATE VIEW v_prof
AS
SELECT profno, name, email, hpage
FROM T_PROFESSOR ;

SELECT * FROM v_prof ;
SELECT tname FROM tab; --테이블 목록에 view가 생성된 걸 알 수 있지. 

--View 생성시 별도의 컬럼이름을 지정해줄 수 있다.
CREATE OR REPLACE VIEW v_prof(pfno,nm,em,hp)
AS
SELECT profno, name, email, hpage
FROM T_PROFESSOR ;

--#8102
CREATE VIEW v_prof_dept
AS
SELECT p.PROFNO 교수번호,p.NAME 교수이름,d.DNAME 소속학과명
FROM T_PROFESSOR p,T_DEPARTMENT d
WHERE p.DEPTNO =d.DEPTNO ;

SELECT * FROM v_prof_dept;

--#8103
SELECT 
	d.DNAME 학과명, MAX(HEIGHT) 최대키, MAX(WEIGHT) 최대몸무게 
FROM T_STUDENT s,T_DEPARTMENT d
WHERE d.DEPTNO =s.DEPTNO1 
GROUP BY d.DNAME ;

--#8104
SELECT * FROM T_STUDENT;
SELECT * FROM T_DEPARTMENT ;

SELECT d.DNAME 학과명, a.max_height 최대키,s.NAME 학생이름, s.HEIGHT  키
FROM (SELECT DEPTNO1, MAX(HEIGHT) max_height FROM T_STUDENT GROUP BY DEPTNO1) a,t_student s,T_DEPARTMENT d
WHERE s.DEPTNO1 =a.deptno1 AND s.HEIGHT =a.max_height AND s.DEPTNO1 =d.DEPTNO;

--#8105
SELECT s.GRADE 학년, s.NAME 이름,s.HEIGHT 키,a.avg_height 평균키
FROM (SELECT grade, AVG(height) avg_height FROM  T_STUDENT  GROUP BY grade)a,t_student s
WHERE a.grade=s.GRADE  AND s.HEIGHT >a.avg_height
ORDER BY 1 ASC;

