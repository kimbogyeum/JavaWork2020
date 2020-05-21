
/* Drop Tables */

DROP TABLE bk_user CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE bk_user
(
	bk_userid number NOT NULL,
	bk_name varchar2(40) NOT NULL,
	bk_age number NOT NULL,
	bk_address clob,
	bk_gender char NOT NULL,
	bk_viewcnt number DEFAULT 0,
	PRIMARY KEY (bk_userid)
);
DROP TABLE BK_USER;

CREATE SEQUENCE BK_USER_SEQ;

SELECT * FROM BK_USER;

INSERT INTO BK_USER VALUES
(BK_USER_SEQ.nextval, '김보겸	', 24, '분당구', 'F' , 0);
INSERT INTO BK_USER VALUES
(BK_USER_SEQ.nextval, '김윤겸	', 22, '강릉시', 'F' , 0);


