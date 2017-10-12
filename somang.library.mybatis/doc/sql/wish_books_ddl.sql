/*
	## ������� ��û �Խ��� ��ƼƼ �� �м� : ���̺�� wish_books
	1. �Խù�ȣ 	:	PK		number			wish_no
	2. ���̵� 		:	FK,NN	varchar2(20)	member_id
	3. ����(������) : 	NN		varchar2(100)	book_title
	4. ���� 		:	NN		varchar2(30)	author
	5. ���ǻ� 		:	NN		varchar2(20)	publisher
	6. ������ 		:			varchar2(10)	publishing_date
	7. ó������ 	:	NN		varchar2(10)	condition
*/

-- ���̺� ����
drop table wish_books purge;

-- ���̺� ����
create table wish_books(
wish_no number,
member_id varchar2(20) not null,
book_title varchar2(100) not null,
author varchar2(30) not null,
publisher varchar2(20) not null,
publishing_date varchar2(10),
condition varchar2(10) not null
);

-- ���̺� �ּ�
comment on table wish_books is '������� ��û �Խ��� ���̺�';

-- �÷� �ּ�
comment on column wish_books.wish_no is '������� ��û �Խñ� �ۼ��� �ڵ����� �ο��Ǵ� �Խù�ȣ, primary key';
comment on column wish_books.member_id is '������� ��û �Խñ��� �ۼ��� ȸ���� ���̵�, not null';
comment on column wish_books.book_title is '������� ��û �Խñ� ����, ������, not null';
comment on column wish_books.author is '��������� ����, not null';
comment on column wish_books.publisher is '��������� ���ǻ�, not null';
comment on column wish_books.publishing_date is '��������� ������';
comment on column wish_books.condition is '������� ��û ���� (��û��, ��û�Ϸ� ��)';

-- ���� �߰� ����
alter table wish_books
add constraint pk_wishbooks_no primary key(wish_no);