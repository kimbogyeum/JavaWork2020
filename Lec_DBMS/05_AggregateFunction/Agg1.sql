SELECT * FROM T_PROFESSOR;
SELECT COUNT(*),COUNT(hpage) FROM T_PROFESSOR;--그룹함수에서는 null값은 계산에서 제외
SELECT COUNT(bonus),sum(bonus),avg(BONUS) FROM T_PROFESSOR;
SELECT MAX(hiredate),min(HIREDATE ) FROM T_EMP;


--NULL 허용 컬럼의 그룹함수 적용시 
--nvl , nvl2 사용해야한다. 

SELECT AVG(bonus),avg(NVL(BONUS,0))
FROM T_PROFESSOR;

--t_professor 테이블에서 '학과별'로 교수들의 평균 보너스를 출력하세요.
--불가능하다! select절에 group 함수와 group 함수가 아닌것과 함께 출력 불가
--SELECT deptno, avg(BONUS)
--FROM T_PROFESSOR ;

SELECT deptno, ROUND(AVG(nvl(bonus,0)),1) 보너스평균
FROM T_PROFESSOR
GROUP BY DEPTNO


SELECT DEPTNO,"POSITION",AVG(PAY) 평균급여 
FROM  T_PROFESSOR 
GROUP BY DEPTNO ,"POSITION" 
ORDER BY DEPTNO ASC,"POSITION" ASC 

--부서별 평균급여를 출력하되, 평균급여가 450보다 많은 학과만 출력
SELECT DEPTNO ,AVG(pay) 
FROM T_PROFESSOR 
WHERE AVG(pay)>450--그룹함수는 where 절에서 사용 불가 
GROUP BY DEPTNO; 

SELECT DEPTNO ,ROUND(AVG(pay),1) 
FROM T_PROFESSOR  
GROUP BY DEPTNO HAVING AVG(pay)>300; 


--SELECT 쿼리문 순서
--SELECT
--FROM
--WHERE
--GROUP BY 
--HAVING
--ORDER BY 
SELECT *
FROM T_EMP

SELECT *
FROM T_PROFESSOR; 

--#5102
SELECT MGR 매니저,
		COUNT(*) 직원수,
		SUM(SAL) 급여총액,
		TRUNC(AVG(SAL)) 급여평균,
		AVG(NVL(COMM ,0)) 
FROM T_EMP
WHERE job<>'PRESIDENT'
GROUP BY MGR 

--#5103
SELECT DEPTNO,
		COUNT(*) 총인원,
		ROUND(AVG(SYSDATE-HIREDATE),1) 근속평균,
		AVG(pay) 급여평균,
		AVG(NVL(BONUS,0)) 보너스평균
FROM T_PROFESSOR 
WHERE POSITION LIKE '%교수'
GROUP BY DEPTNO; 


--#5104
SELECT DEPTNO1 학과, MAX(WEIGHT)-min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1;

SELECT DEPTNO1 학과, MAX(WEIGHT)-min(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1
HAVING MAX(WEIGHT)-min(WEIGHT)>=30;

