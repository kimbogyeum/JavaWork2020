CREATE TABLE PHONEBOOK1 (
	id NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	phone varchar2(100),
	email varchar2(100),
	age NUMBER DEFAULT 21,
	memo clob,
	regdate date
);

INSERT INTO phonebook1(id,name,phone,email,age,memo) values(1,'김보겸','010-2873-5198','kimbogyeum1@naver.com',25,'안녕');

SELECT *FROM PHONEBOOK1;
SELECT id,name FROM phonebook1;

CREATE SEQUENCE phonebook1_seq;
SELECT * FROM seq WHERE sequence_name='PHONEBOOK_SEQ';

INSERT INTO PHONEBOOK1(ID,NAME,PHONE,EMAIL,MEMO) VALUES(PHONEBOOK_SEQ.NEXTVAL,'김철수', '010-1111-2222', 'ssamsung@test.com',  SYSDATE);
INSERT INTO PHONEBOOK1(ID,NAME,PHONE,EMAIL,MEMO) VALUES(2,'유겸','030-20303-20303','KJDKFJ@NDKFJLDF',' ');
UPDATE PHONEBOOK1 SET NAME='윤겸' WHERE ID=2;
DELETE FROM PHONEBOOK1 WHERE ID=1;


SELECT NAME ||'-'||POSITION  연결
FROM T_PROFESSOR  ;

SELECT  
FROM 
WHERE 


