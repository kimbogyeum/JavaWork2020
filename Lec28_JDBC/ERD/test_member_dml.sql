SELECT * FROM test_member;

INSERT INTO test_member values(10,'남윤주',sysdate);
INSERT INTO test_member values(22,'이승환','1994-02-21');
INSERT INTO test_member values(17,'윤종섭','2019-08-03');
--INSERT INTO test_member values('','이예지','');--비어있는 ''를 insert하면 null값 처리
--INSERT INTO test_member values(10,'',sysdate);
INSERT INTO test_member values(null,'문상현','2017-01-01');

--dBeaver 에서는 기본적으로 auto-commit 수행

SELECT * FROM  TEST_MEMBER ;


