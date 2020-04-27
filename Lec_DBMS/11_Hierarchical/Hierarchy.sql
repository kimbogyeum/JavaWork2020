--계층형 쿼리(Hierarchical Query)
SELECT*FROM t_dept2;--서로의 계층관계 주목!

SELECT LPAD(dname,10,'*') 부서명 FROM T_DEPT2 ;

--LEVEL
SELECT DNAME ,LEVEL 
FROM T_DEPT2 
CONNECT BY PRIOR DCODE=PDEPT
START WITH DCODE =0001;

--반대로 해볼까
SELECT DNAME ,LEVEL 
FROM T_DEPT2 
CONNECT BY DCODE=PRIOR PDEPT--사장실의 부모를 찾아가
START WITH DCODE =0001;

SELECT DCODE,DNAME,PDEPT,LEVEL 
FROM T_DEPT2 
CONNECT BY DCODE=PRIOR PDEPT--사장실의 부모를 찾아가
START WITH DCODE =1005;

SELECT DCODE,DNAME,PDEPT,LEVEL 
FROM T_DEPT2 
CONNECT BY DCODE=PRIOR PDEPT
START WITH DCODE =1011; 

SELECT LPAD(DNAME,LEVEL* 6,'*') 부서명
FROM T_DEPT2
CONNECT BY PRIOR dcode=PDEPT 
START WITH DCODE =0001;

SELECT *FROM T_EMP2 ;

SELECT LPAD(e.NAME ||' '||d.dname||' '|| NVL(e.POST ,'사원'),LEVEL *22,'-') 이름과직급
FROM T_EMP2 e,(SELECT DNAME ,DCODE ,PDEPT FROM T_DEPT2) d
WHERE e.DEPTNO =d.dcode
CONNECT BY PRIOR e.empno=e.PEMPNO
START WITH e.EMPNO =20000101;

SELECT LEVEL -1
FROM dual
CONNECT BY LEVEL <=24
;

--https://programmers.co.kr/learn/courses/30/lessons/59412
select h.hr "HOUR",count(datetime) "COUNT"
from 
    (select level -1 hr from dual connect by level<=24) h
    left outer join animal_outs a 
    on h.hr=to_number(to_char(a.datetime,'hh24'))

group by h.hr
order by 1;

SELECT
FROM 