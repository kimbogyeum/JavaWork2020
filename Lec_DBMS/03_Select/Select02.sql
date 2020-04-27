--산술연산자

SELECT ENAME ,SAL,SAL *1.1
FROM T_EMP;

SELECT ENAME ,SAL ,COMM ,sal+COMM --null과의 산술연산은 무조건 null;
FROM T_EMP;

--WHERE 조건절
SELECT*FROM T_EMP WHERE JOB ='SALESMAN'; --문자열은 대소문자 구분!

SELECT ENAME,SAL,DEPTNO
FROM T_EMP WHERE DEPTNO =10;

--직원 테이블(t_emp) 에서 급여(sal) 가 2000보다 큰 사람의 이름(ename)과 급여(sal)를 출력하세요
SELECT ENAME ,SAL 
FROM T_EMP 
WHERE SAL > 2000;

--직원 테이블(t_emp) 에서 이름이 SCOTT인 사람의 이름(ename)과 사원번호(empno), 급여(sal) 출력
SELECT ENAME , EMPNO , SAL FROM T_EMP WHERE ENAME = 'SCOTT';

--학생 테이블(t_student) 에서 2,3 학년(grade) 학생의  이름(name), 학년(grade) 출력
SELECT NAME,GRADE FROM T_STUDENT WHERE GRADE=2 OR GRADE =3;
SELECT NAME,GRADE FROM T_STUDENT WHERE GRADE IN(2,3);
SELECT NAME,GRADE FROM T_STUDENT WHERE GRADE >1 AND GRADE <4;
SELECT NAME,GRADE FROM T_STUDENT WHERE GRADE NOT IN (1,4);
SELECT NAME,GRADE FROM T_STUDENT WHERE GRADE BETWEEN 2 AND 3;

SELECT NAME ,PAY ,"POSITION" 
FROM T_PROFESSOR WHERE PAY>300 AND "POSITION" ='정교수';

SELECT NAME,POSITION 
FROM T_PROFESSOR WHERE BONUS IS NULL ;

SELECT NAME 
FROM T_PROFESSOR WHERE NAME LIKE '김%';

--LIKE
--교수님 중에서 김씨 성을 가진 교수님의 이름만 출력(LIKE 사용)
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%NE%'; 


--직원 테이블(T_EMP)에서 직원이름(ENAME) 중에 두번쨰 글자가 'A'인 사람의 이름(ENAME)만 출력
SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '_A%';

SELECT ENAME 
FROM T_EMP 
WHERE ENAME LIKE '%L%'
ORDER BY ENAME DESC;

--직원의 이름,직책, 급여를 출력하되 우선은 직책(job) 사전 내림차순으로, 그리고 급여(sal) 오름차순으로 출력
SELECT ENAME ,JOB ,SAL 
FROM T_EMP 
ORDER BY JOB DESC,SAL ASC;

SELECT NAME,GRADE,HEIGHT 
FROM T_STUDENT 
ORDER BY GRADE ASC,HEIGHT DESC ;

--DB03
--
