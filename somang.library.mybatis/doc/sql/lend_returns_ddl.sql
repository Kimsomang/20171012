/*
	## ����ݳ� ���� ���̺� �� �м� : ���̺�� lend_returns
	1. �����ڵ� :	PK		���ڿ�(20)	varchar2(20)	lend_code
	2. ������ȣ :	FK,NN	���ڿ�(10)	varchar2(10)	book_no
	3. ������ 	:	NN		���ڿ�(100)	varchar2(100)	book_title
	4. ���̵� 	:	FK,NN	���ڿ�(20)	varchar2(20)	member_id
	5. ������ 	:	NN		��¥		date		lend_date
	6. �ݳ��� 	:			��¥		date			return_date
	7. �ݳ������� :	NN		��¥		date			return_period
	8. ���� 	:			���ڿ�(3)	varchar2(5)		extension
*/

-- ���̺� ����
drop table lend_returns purge;

-- ����ݳ����� ���̺� ����
create table lend_returns (
lend_code varchar2(20),
book_no varchar2(10) not null,
book_title varchar2(100) not null,
member_id varchar2(20) not null,
lend_date date not null,
return_date date,
return_period date not null,
extension varchar2(5) default '0/1'
);

-- ���̺� �ּ�
comment on table lend_returns is 'ȸ������ ���� ����ݳ� ���� ���̺�';

-- �÷� �ּ�
comment on column lend_returns.lend_code is '����� �ο��Ǵ� �ڵ��ȣ, primary key';
comment on column lend_returns.book_no is '����� ������ ������ȣ, not null';
comment on column lend_returns.book_title is '����� ������, not null';
comment on column lend_returns.member_id is '������ ������ ȸ���� ���̵�, not null';
comment on column lend_returns.lend_date is '������ ��¥, not null';
comment on column lend_returns.return_date is '�ݳ��� ��¥';
comment on column lend_returns.return_period is '�ݳ�������, �����Ϸκ��� 10�� ��, not null';
comment on column lend_returns.extension is '�ݳ��� ���� Ƚ��, �ִ� 1��, ����� �ݳ� ������+7��';

-- ���� �߰� ����
alter table lend_returns
add constraint pk_lendreturns_code primary key(lend_code);

alter table lend_returns
add constraint fk_lendreturns_no foreign key(book_no) references books(book_no);

alter table lend_returns
add constraint fk_lendreturns_member_id foreign key(member_id) references member(member_id);

/*-------------------------------------------
	����, �ּ� DATA DICTIONARY 
	-- user_constraints
	-- user_cons_columns
	-- user_tab_comments
	-- user_col_comments
--------------------------------------------*/

-- ���̺� �ּ� ��ȸ
select table_name, comments from user_tab_comments
where table_name in ('MEMBERS', 'LEND_RETURNS')
order by table_name;

-- ȸ�� ���̺� �÷� �ּ�
select column_name, comments
from user_col_comments
where table_name in ('MEMBERS');

-- �Խñ� ���̺� �÷� �ּ�
select column_name, comments
from user_col_comments
where table_name in ('LEND_RETURNS');