-- ������ �Է�
insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user01', 'password01', 'ȫ�浿', '1991.01.01', '010-1111-2222', '�����');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user02', 'password02', '�����', '1992.02.02', '010-123-1234', '������');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user03', 'password03', '���ֿ�', '1993.03.03', '011-4545-4545', '��õ��');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user04', 'password04', '�̹���', '1994.02.04', '010-2345-2345','ȭ����');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user05', 'password05', '��Ҹ�', '1995.01.23', '010-5656-5656', '���ֽ�');

insert into member(member_id, member_pw, member_name, birth, mobile,address)
values('user06', 'password06', '������', '1996.04.23', '011-5445-4545', '���ֽ�');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user07', 'password07', '������','1997.07.07', '010-1010-1010', 'õ�Ƚ�');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user08', 'password08', '�̼���', '1998.08.08', '010-8520-8520', '���ʽ�');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user09', 'password09', '������', '1999.03.19', '010-4566-4566', '���ֽ�');

insert into member(member_id, member_pw, member_name, birth, mobile, address)
values('user10', 'password10', '���ֿ�', '2000.01.01', '010-9876-9876', '�Ȼ��');

-- ȸ������
-- insert into members values (?, ?, ?, ?, ?, ?, ?, ?)

-- �α���
-- select member_pw from members where member_id = ?

-- ���̵�ã��
-- select member_id from members where member_name = ?, mobile = ?

-- ��й�ȣã��
-- select member_pw from members where member_id = ?, member_name = ?

-- ȸ��������ȸ
-- select * from members where member_id = ?

-- ȸ����ü��� ��ȸ
-- select * from members


-- ������ ����
update members
set lend_book = '1/5' where member_id = 'user10';

-- ȸ�� �������� > ��й�ȣ ����
-- update members set member_pw = ? where member_id = ?

-- ȸ�� �������� > ����ó ����
-- update members set mobile = ? where member_id = ?

-- ȸ�� �������� > �ּ� ����
-- update members set address = ? where member_id = ?

-- ������ ����
delete from members where member_id = 'user09';

-- ȸ�� Ż��
-- delete from members where member_id = ?

