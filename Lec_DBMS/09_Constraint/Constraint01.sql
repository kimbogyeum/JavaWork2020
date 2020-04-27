--제약조건(Constraint)
--테이블 생성시 동시에 설정하기


--t_dept2.dcode 참조예정
SELECT *FROM t_dept2;  --dcode:0001,1000,1001,...1011

--#9001
--동시에 제약조건 명시하기
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
	NO number(4) PRIMARY key,
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL UNIQUE,
	area number(1) CHECK(area<5),
	deptno varchar2(6) REFERENCES t_dept2(dcode)
);

--별도의 항목으로 제약조건 명시
DROP TABLE t_emp4 CASCADE CONSTRAINT;
CREATE TABLE t_emp4(
	no number(4),
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL,
	area number(1),
	deptno varchar2(6),
	PRIMARY key(no),
	unique(jumin),
	check(area<5),
	FOREIGN key(deptno) REFERENCES t_dept2(dcode)
);


--#9002
--제약조건명을 명시하여 정의 
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
	NO number(4) CONSTRAINT emp3_no_pk PRIMARY key,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL
		CONSTRAINT emp3_name_uk UNIQUE,
	area number(1) CONSTRAINT emp3_name_ck CHECK(area<5),
	deptno varchar2(6) CONSTRAINT emp3_name_fk REFERENCES t_dept2(dcode)
);

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3(
	NO number(4),
	name varchar2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL,
	area number(1),
	deptno varchar2(6),
	CONSTRAINT emp3_no_pk PRIMARY key(no),
	CONSTRAINT emp3_jumin_uk UNIQUE(jumin),
	CONSTRAINT emp3_area_ck CHECK (area<5),
	CONSTRAINT emp3_deptno_fk FOREIGN key(deptno) REFERENCES t_dept2(dcode)
	);

--#9003 제약조건 조회하기
SELECT owner,CONSTRAINT_NAME ,CONSTRAINT_TYPE ,STATUS 
FROM user_constraints
WHERE table_name='T_EMP4'; --테이블명 대문자로!

SELECT owner,CONSTRAINT_NAME ,CONSTRAINT_TYPE ,STATUS 
FROM user_constraints
WHERE table_name='T_EMP3';

--#9005:제약조건에 맞는/위배되는 DML 시도해보기 
INSERT INTO t_emp3 values(1,'오라클','123456789',4,1000);
--두번 실행하면 오류!unique constraint (SCOTT0316.EMP3_NO_PK) violated
INSERT INTO t_emp3 values(2,'오라클','123456789',4,1000);
--unique constraint (SCOTT0316.EMP3_JUMIN_UK) violated
INSERT INTO t_emp3 values(2,'오라클','22222222222',10,1000);
--check오류: value larger than specified precision allowed for this column
INSERT INTO t_emp3 values(2,'오라클','22222222222',3,2000);
--foreign key 오류: ORA-02291: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found
INSERT INTO t_emp3 (NO,jumin,area,deptno) VALUES (2,'22222222222',4,1001);
--nn오류: cannot insert NULL into ("SCOTT0316"."T_EMP3"."NAME")
UPDATE t_emp3 SET area=10 WHERE NO=1;--check 값 오류

SELECT * FROM t_emp3;
DELETE FROM T_DEPT2  WHERE DCODE =1000;--참고하고 있는 부모는 삭제 불가
-- ORA-02292: integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - child record found

--#9005) 테이블 생성후에 ALTER 명령 사용하여 제약조건 추가 가능!
--t_emp4 의 name 컬럼 unique 제약조건 추가 
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_uk unique(name);

--#9006)
--t_emp4 테이블의 area 컬럼에 not null 제약조건 추가
--이미 컬럼의 기본값인 null 로 되어있기 때문에 ADD가 아닌 modify로 해야한다. 
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_area_nn NOT NULL;

ALTER TABLE t_emp4 MODIFY(area CONSTRAINT emp4_area_nn NOT null);


--#9007)
--t_emp4테이블의 no컬럼이 t_emp2테이블의 
--empno 컬럼값을 참조하도록 참조키 제약조건을 설정하세요
ALTER TABLE t_emp4 ADD CONSTRAINT emp4_name_fk FOREIGN key(name) REFERENCES t_emp2(name);
--그냥 실행하면 에러다.  ORA-02270: no matching unique or primary key for this column-list
-- 참조된 부모테이블의 컬럼은 primarykey이거나 unique해야한다. 

--일단 부모테이블의 name을 unique로 바꾼 뒤 위의 쿼리를 다시 실행해 보세요
ALTER TABLE T_EMP2;
ADD CONSTRAINT emp2_name_uk unique(name);

DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY KEY,
	name VARCHAR2(10) CONSTRAINT emp3_name_nn NOT NULL,
	jumin VARCHAR2(13) 
		CONSTRAINT emp3_jumin_nn NOT NULL 
		CONSTRAINT emp3_jumin_uk UNIQUE,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area < 5),
	deptno VARCHAR2(6) 
		CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
		ON DELETE CASCADE  -- 부모 삭제되면 자식도 삭제
		-- ON DELETE SET NULL -- 부모 삭제되면 NULL 값으로
);

-- #9009
-- t_emp4 테이블의 name 필드의 제약조건 에
-- 부모테이블이 삭제되면 NULL 이 되도록 설정하기 (ALTER 사용)

ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk;--일단 기존 제약조건 삭제
ALTER TABLE t_emp4
ADD CONSTRAINT emp4_name_fk FOREIGN key(name)
	REFERENCES t_emp2(name)
	ON DELETE SET NULL -- 부모 삭제되면 자식은 null 로 변환
	;

---------------------------------
--DISABLE NOVALIDATE

--#9010
SELECT * FROM t_novalidate;
SELECT * FROM t_validate;

SELECT OWNER, CONSTRAINT_NAME , CONSTRAINT_TYPE, STATUS 
FROM USER_CONSTRAINTS 
WHERE table_name = 'T_VALIDATE';

INSERT INTO t_validate VALUES(1, 'DDD');  -- 처음에는 에러!  PK니까!

SELECT owner,CONSTRAINT_name,constraint_type,status
FROM USER_CONSTRAINTS 
WHERE TABLE_NAME ='T_novalidate';

ALTER TABLE T_NOVALIDATE 
disable novalidate CONSTRAINT SYS_C007031;

INSERT INTO t_novalidate values(1,'DDD');

ALTER TABLE T_NOVALIDATE 
enable novalidate CONSTRAINT SYS_C007031;

DELETE FROM T_NOVALIDATE WHERE name='DDD';