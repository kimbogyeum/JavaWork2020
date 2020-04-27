SELECT *FROM T_PROFESSOR;

--null 값 과의 산술 연산 결과는 null이다. 
SELECT NAME ,PAY ,BONUS ,pay+BONUS 
FROM T_PROFESSOR ;

--그룹함수에서는 동작, null은 연산에서 제외되어 동작 
SELECT sum(pay),sum(BONUS) 
FROM T_PROFESSOR;

--nvl 함수
SELECT name , PAY , BONUS ,PAY+BONUS 총지급액, PAY +NVL(BONUS ,0) 총지급액 
FROM T_PROFESSOR;

--#4201
SELECT name,pay,NVL2(BONUS,bonus,0) BONUS,NVL2(BONUS,pay*12+BONUS,pay*12) 연봉
FROM T_PROFESSOR
WHERE DEPTNO =101;

