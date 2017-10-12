/*
	## ȸ�� ��ƼƼ �� �м� : ���̺�� members
	1. ���̵� 		: 	PK	���ڿ�(20)	varchar2(20)	member_id
	2. ��й�ȣ 	:	NN	���ڿ�(20)	varchar2(20)	member_pw
	3. �̸� 		:	NN	���ڿ�(20)	varchar2(20)	member_name
	4. ������� 	:	NN	���ڿ�(10)	varchar2(20)	birth
	5. ����ó 		:	NN	���ڿ�(13)	varchar2(20)	mobile
	6. �ּ� 		:	NN	���ڿ�(100)	varchar2(100)	address
	7. ����Ǽ� 	:		���ڿ�(6)	varchar2(10)	lend_book
	8. ���Ⱑ�ɿ��� :	NN	���ڿ�(8)	varchar2(10)	condition
	9. ��ü�Ⱓ 	:		��¥		date	over_date
*/


-- ���̺� ����
drop table member purge;

-- ȸ������ ���̺� ����
create table member (
member_id varchar2(20),
member_pw varchar2(20) not null,
member_name varchar2(20) not null,
birth varchar2(20) not null,
mobile varchar2(20) not null,
address varchar2(100) not null,
lend_book varchar2(10) default '0/5',
condition varchar2(10) default '���Ⱑ��',
over_date date
);

-- ���̺� �ּ�
comment on table member is 'ȸ������ ���̺�, ȸ�����Խ� �ۼ�';

-- �÷� �ּ�
comment on column member.member_id is '������� ���̵�, primary key';
comment on column member.member_pw is '������� ��й�ȣ, not null';
comment on column member.member_name is '������� �̸�, not null';
comment on column member.birth is '������� �������, not null';
comment on column member.mobile is'������� ����ó, unique, not null';
comment on column member.address is '������� �ּ�, not null';
comment on column member.lend_book is '����ڰ� ������ å�� �Ǽ�, �ִ� 5�Ǳ��� ����';
comment on column member.condition is '������� ���Ⱑ�ɿ���, ��ü�� ����Ұ�';
comment on column member.over_date is '������� ��ü�Ұ��Ⱓ';


-- ���� �߰� ����
alter table member
add constraint pk_member_id primary key(member_id);

alter table member
add constraint u_member_mobile unique(mobile);