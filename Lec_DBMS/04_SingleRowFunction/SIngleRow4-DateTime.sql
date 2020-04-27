--날짜 함수
SELECT SYSDATE FROM dual;

--기본적인 날짜 연산
SELECT SYSDATE "오늘",
		SYSDATE+1,--+24시간 뒤
		SYSDATE-2,--그저께
		sysdate+1/24--한시간 뒤
FROM dual; 

--일자차이계산
SELECT SYSDATE "오늘",
		TO_DATE('2020-03-16 09:00:00','yyyy-mm-dd hh:mi:ss') "시작한날",
		SYSDATE - TO_DATE('2020-03-16 09:00:00','yyyy-mm-dd hh:mi:ss') "경과"
FROM  dual;

--MONTHS_BETWEEN: 날짜 사이의 개월수
	--규칙1: 두 날짜 중 큰 날짜를 먼저 써야 양수값으로 나온다. 
SELECT MONTHS_BETWEEN('2012-03-01','2012-01-01') "양수값",
		MONTHS_BETWEEN('2012-01-01','2012-03-01') "음수값",
	--규칙2: 두 날짜가 같은 달에 속해있으면 특정 규칙으로 계산된값
		MONTHS_BETWEEN('2012-02-29','2012-02-01') "28/29",--한달이 안되면 1보다 작은 값이 나온다.
		MONTHS_BETWEEN('2012-04-30','2012-04-01') "29/30",
		MONTHS_BETWEEN('2012-05-31','2012-05-01') "30/31"
FROM DUAL;

--#4501
SELECT NAME 이름,
		TO_CHAR(SYSDATE,'YYYY-MM-DD') 오늘,
		TO_CHAR(HIREDATE,'YYYY-MM-DD') 입사일,
		TO_CHAR(SYSDATE,'YYYY')-TO_CHAR(HIREDATE,'YYYY') 근속연수,
		ROUND(MONTHS_BETWEEN(SYSDATE,HIREDATE),1) 근속개월,
		ROUND(SYSDATE-HIREDATE,1) 근속일
FROM T_PROFESSOR;

--ADD_MONTH() 개월 추가
SELECT SYSDATE,
		LAST_DAY(SYSDATE) "이번달 마지막날",
		NEXT_DAY(SYSDATE,'월') "다음 월요일" 
FROM DUAL;

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.

SELECT 
	SYSDATE,
	ROUND(SYSDATE),
	TRUNC(SYSDATE)
FROM DUAL;

SELECT 
FROM DUAL;

SELECT 
FROM DUAL;

