-- 회원 테이블  --
create table strutsmember (
	id			varchar2(20) primary key,	-- 아이디
	password	varchar2(20) not null,		-- 비밀번호
	name		varchar2(20) not null,		-- 이름
	zipcode		varchar2(10),				-- 우편번호
	address1	varchar2(100),				-- 주소
	address2	varchar2(100),				-- 상세주소
	phone		varchar2(50),				-- 전화번호
	email		varchar2(100),				-- 이메일
	inputdate	date default sysdate		-- 가입일
);

-- 데이터 입력 예
insert into strutsmember (id, password, name, zipcode, address1, address2, phone, email)
values ('aaa', 'aaa', '홍길동', '111-222', '서울시 강남구 삼성동', '1번지', '010-111-2222', 'aaa@bbb.com');

