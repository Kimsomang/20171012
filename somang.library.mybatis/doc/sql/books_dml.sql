-- �����ڷ� �Է�
insert into books(book_no, book_title, author, publisher, publishing_date, ISBN, location, type_code, category)
values(books_no_seq.nextval, '���̾� ��ȭ���� ����', '�����ó� ���̰�', '���빮��', '2012.12.19', '1234567891010', '3�� �ڷ��', '853.27��', '800');

insert into books(book_no, book_title, author, publisher, publishing_date, ISBN, location, type_code, category)
values(books_no_seq.nextval, '��', '�������� ��������', '����å��', '2017.06.08', '1234567891011', '3�� �ڷ��', '853.80��', '800');

insert into books(book_no, book_title, author, publisher, publishing_date, ISBN, location, type_code, category)
values(books_no_seq.nextval, '����� �µ�', '�̱���', '������', '2016.08.19', '1�� �ڷ��', '216.52��', '200');

insert into books(book_no, book_title, author, publisher, publishing_date, ISBN, location, type_code, category)
values(books_no_seq.nextval, '����������', '��ȫ��', '���ö�����', '2016.09.01', '2�� �ڷ��', '465.43��', '400');

insert into books(book_no, book_title, author, publisher, publishing_date, ISBN, location, type_code, category)
values(books_no_seq.nextval, '���뺸��ó�� ��ٴ� �����̾�', '���ȸ', '��', '2017.04.06', '1�� �ڷ��', '217.81��', '200');

-- ������ �Է½� book_no�� ������ ���, condition�� '���Ⱑ��'

-- insert into books values(?,?,?,?,?,?,?,?,?,?);

-- select * from books order by book_no

-- select * from books where book_title like ('%?%')
-- select * from books where author like ('%?%')

-- ����
update books
set condition='������' where book_no = 1;

-- update books set condition = ? where book_no = ?
-- update books set location = ? where book_no = ?

-- ����
delete from books where book_no = 2;

-- delete from books where book_no = ?