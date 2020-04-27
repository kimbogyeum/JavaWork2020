--숫자 관련 단일행 함수들

--ROUND()
SELECT
	'ROUND',
	ROUND(12.34) "(12.34)",
	ROUND(12.536) "(12.536)",
	ROUND(12.536,2) "(12.536,2)",
	ROUND(16.536,-1) "(16.536,-1)"--1의 자리에서 반올림
FROM dual;

-- TRUNC() 함수
SELECT
	'TRUNC',
	TRUNC(12.345) "(12.345)",         -- 소수점 자름 (디폴트)
	TRUNC(12.345, 2) "(12.345, 2)",   -- 소수점 3자리부터 자름
	TRUNC(12.345, -1) "(12.345, -1)"  -- 1의 자리부터 자름
FROM dual;

--ROUND(), CEIL(), TRUNC(), FLOOR() 함수 비교

SELECT
	'12.5'  "12.5",
	ROUND(12.5)	"ROUND",
	TRUNC(12.5) "TRUNC",
	CEIL(12.5) "CEIL",--보다 큰수중에 가자 ㅇ작은수
	FLOOR(12.5) "FLOOR"
FROM dual;

SELECT
	'-12.5'  "-12.5",
	ROUND(-12.5)	"ROUND",
	TRUNC(-12.5) "TRUNC",
	CEIL(-12.5) "CEIL",
	FLOOR(-12.5) "FLOOR"
FROM dual;


--오라클은 % 연산자가 없다.
--MOD(): 나머지 연산

SELECT MOD(12,10) "MOD(12,10)",
	MOD(12.6,4.1) "MOD(12.6,4.1)"
FROM DUAL;

--power():제곱
SELECT POWER(3,2) "POWER(3,2)",
		POWER(-3,3) "POWER(-3,3)",
		POWER(100,-2) "POWER(100,-2)",
		POWER(2,1/2) "sqrt(2,1/2)",
		POWER(27,1/3)
FROM dual;





