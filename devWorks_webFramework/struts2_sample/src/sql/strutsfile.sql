//파일테이블생성
CREATE TABLE STRUTSFILE (
FILENUM NUMBER(10) PRIMARY KEY,
BOARDNUM NUMBER(10), 
SAVEDFILE VARCHAR2(100),
originalfile varchar2(200));

//파일테이블시퀀스 생성
CREATE SEQUENCE STRUTSFILE_SEQ
START WITH 1
INCREMENT BY 1;
