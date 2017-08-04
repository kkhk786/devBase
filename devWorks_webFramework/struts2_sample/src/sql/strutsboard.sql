-- 게시판 테이블  --
create table strutsboard (
	boardnum		number(10) primary key,		--게시판 글번호
	id				varchar2(20) not null,		--작성자 ID
	inputdate		date default sysdate,		--작성일
	viewcount		number(10) default 0,		--조회수
	title			varchar2(500) not null,		--글제목
	content			varchar2(4000) not null,	--글내용
	savedfile		varchar2(100),				--첨부파일명 (실제 저장된 이름)			
	originalfile	varchar2(200)				--첨부파일명 (원래 이름)
);

-- 게시판 글 번호 시퀀스 --
create sequence strutsboard_seq start with 1 increment by 1;

-- 한줄답변 테이블 --
create table strutsreply (
	replynum	number(10) primary key, --리플 테이블의 일련번호
	boardnum	number(10) not null,	--본문 글번호
	id			varchar2(20) not null, 	--리플 쓴 ID
	retext		varchar2(200),			--리플 내용
	inputdate	date default sysdate,	--작성일
	constraint strutsreply_fk 
	foreign key(boardnum) references strutsboard(boardnum)
	on delete cascade
);

-- 한줄답변 테이블의 일련번호
create sequence strutsreply_seq;


