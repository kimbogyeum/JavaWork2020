-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT empno,ename,sal FROM t_emp;

--자동으로 오라클에서 붙여주는 행번호 객체(ROWNUM)
SELECT rownum, empno,ename,sal FROM t_emp ORDER BY empno DESC ;

--상위 5개만!
SELECT  empno,ename,sal FROM t_emp
WHERE rownum<=5 ORDER BY empno DESC;

-->5는 동작 안함. ROWNUM 범위가 1이 포함이 안되면 동작 안함. 
SELECT  empno,ename,sal FROM t_emp
WHERE rownum>=1 AND rownum <1+5 ORDER BY empno DESC;

--(2page)
SELECT  empno,ename,sal FROM t_emp
WHERE rownum>=6 AND rownum <6+5 ORDER BY empno DESC;--안나온다.

--phonebook 뻥튀기..
SELECT * FROM PHONEBOOK; 
INSERT INTO PHONEBOOK (SELECT*FROM PHONEBOOK);--phonebook에 primary key인 uid때문에 안됨. 

INSERT INTO PHONEBOOK 
	(SELECT phonebook_seq.nextval,PB_NAME , PB_PHONENUM ,PB_MEMO ,SYSDATE FROM PHONEBOOK);

---rownum rev.
SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC;

SELECT T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)
T;

SELECT ROWNUM AS RNUM,T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)
T;


SELECT ROWNUM AS RNUM,T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)
T;
--한페이지당 5개 데이터
--2번째 페이지
SELECT * FROM 
(
SELECT ROWNUM AS RNUM,T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)T)WHERE rnum>=6 AND rnum<6+5;


SELECT * FROM 
(
SELECT ROWNUM AS RNUM,T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)T)WHERE rnum>=11 AND rnum<11+5;

SELECT * FROM 
(
SELECT ROWNUM AS RNUM,T.*
FROM (SELECT pb_uid,pb_name,pb_phonenum FROM PHONEBOOK ORDER BY PB_UID DESC)T)WHERE rnum>=21 AND rnum<21+10;

WHERE rnum>=? AND rnum<?+?