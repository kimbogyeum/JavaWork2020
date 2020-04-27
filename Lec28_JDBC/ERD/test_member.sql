
/* Drop Tables */

DROP TABLE test_member CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_member
(
	mb_no number,
	mb_name varchar2(40) NOT NULL,
	mb_birthdate date
);
SELECT * FROM TEST_MEMBER ;

--시퀀스 
DROP SEQUENCE TEST_MEMBER_SEQ;
CREATE SEQUENCE test_member_seq;

DELETE FROM TEST_MEMBER ;
SELECT * FROM TEST_MEMBER ORDER BY MB_NO DESC;



