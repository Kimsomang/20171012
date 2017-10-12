/*
	## �������� ���̺� �� �м� : ���̺�� books
	1. ������ȣ :	PK	���ڿ�(10)	varchar2(10)	book_no
	2. ������ 	:	NN	���ڿ�(100)	varchar2(100)	book_title
	3. ����	 	:	NN	���ڿ�(30)	varchar2(30)	author
	4. ���ǻ� 	:	NN	���ڿ�(20)	varchar2(20)	publisher
	5. ������ 	:	NN	���ڿ�(10)	varchar2(10)	publishing_date
	6. ISBN		:	NN	���ڿ�(13)	varchar2(13)	ISBN
	7. �ڷ���� :		���ڿ�(8)	varchar2(10)	condition
	8. ������ġ :	NN	���ڿ�(9)	varchar2(20)	location
	9. û����ȣ :	NN	���ڿ�(8)	varchar2(10)	type_code
	10.�����з� :	NN	���ڿ�(8)	varchar2(10)	category
*/

--���̺� ����
drop table books purge;

-- �������� ���̺� ����
create table books (
book_no varchar2(10) not null,
book_title varchar2(100) not null,
author varchar2(30) not null,
publisher varchar2(20) not null,
publishing_date varchar2(10) not null,
ISBN	varchar2(13) not null,
condition varchar2(10) default '���Ⱑ��',
location varchar2(20) not null,
type_code varchar2(10) not null,
category varchar2(10) not null
);

-- ���̺� �ּ�
comment on table books is '�������� ��ϵǾ� �ִ� �������� �����ϴ� ���̺�';

-- �÷� �ּ�
comment on column books.book_no is '���� ��Ͻ� �ο��Ǵ� ������ȣ, primary key';
comment on column books.book_title is '������, ��������, not null';
comment on column books.author is '������ ���ڸ�, not null';
comment on column books.publisher is '������ ���ǻ�, not null';
comment on column books.publishing_date is '������ ������, not null';
comment on column books.ISBN is '���� ����ǥ�ص�����ȣ, not null';
comment on column books.condition is '������ ���Ⱑ�� ����, default ���Ⱑ��';
comment on column books.location is '������ ������ġ, not null';
comment on column books.type_code is '������ �оߺ� û����ȣ, not null';
comment on column books.category is '������ ����ǥ�з��� ���� �о� �з�, not null';

-- ���� �߰� ����
alter table books
add constraint pk_books_no primary key(book_no);
