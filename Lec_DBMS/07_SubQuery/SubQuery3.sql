CREATE TABLE test_emp_a(
	emp_id NUMBER,
	emp_name varchar(100)
);

CREATE TABLE test_emp_b(
	emp_id NUMBER,
	emp_name varchar(100)
);


DELETE FROM TEST_EMP_a ;
DELETE FROM TEST_EMP_b ;

INSERT INTO test_emp_a values(101,'장윤성');
INSERT INTO test_emp_b values(201,'고유성');

--동시에 여러개 테이블에 INSERT 하기 
--다중 테이블 INSERT 구문에 sub Query 필요 

INSERT ALL
	INTO TEST_EMP_A values(102,'조현주')
	INTO TEST_EMP_B values(202,'최현주')
SELECT * FROM dual;

--sub query로 Insert 가능
INSERT INTO TEST_EMP_A (SELECT 400,'안성원' FROM DUAL);
INSERT INTO TEST_EMP_b (SELECT 500,'안성원' FROM DUAL);

--테이블 묻고 더블로!
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A);

INSERT INTO TEST_EMP_B (emp_name)(SELECT emp_name FROM TEST_EMP_A );



SELECT * FROM TEST_EMP_A;
SELECT * FROM TEST_EMP_B;


