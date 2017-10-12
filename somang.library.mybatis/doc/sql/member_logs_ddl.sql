/*
	## ȸ�� �α����� ��ƼƼ �� �м� : ���̺�� member_logs
	1. �α׹�ȣ :	PK		number			log_no
	2. ���̵� 	:	FK,NN	varchar2(20)	member_id
	3. �α��νð� :			date			login_time
	4. �α׾ƿ��ð� :		date			logout_time
	5. �α� �÷��� :		varchar2(20)	log_flag
*/

-- ���̺� ����
drop table member_logs purge;

-- ���̺� ����
create table member_logs(
log_no number,
member_id varchar2(20) not null,
login_time date,
logout_time date,
log_flag varchar2(20)
);

-- ���̺� �ּ�
comment on table member_logs is 'ȸ������ �α� ��/�ƿ� ���� ���̺�';

-- �÷� �ּ�
comment on column member_logs.log_no is '���� �α� �ڵ�, primary key';
comment on column member_logs.member_id is '�α��� �õ��� ȸ���� ���̵�, not null';
comment on column member_logs.login_time is '�α��� ������ �α��� �� �ð�';
comment on column member_logs.logout_time is '�α׾ƿ��� �α׾ƿ� �� �ð�';
comment on column member_logs.log_flag is '�α���/�ƿ� ���� �� �������� ����/���� ���';

-- ���� �߰� ����
alter table member_logs
add constraint pk_memberlogs_no primary key(member_no);

alter table member_logs
add constraint fk_memberlogs_id foreign key(member_id) references members(member_id);