package library.model.dto;

import java.io.Serializable;

public class Book implements Serializable {

	/*
	 * book_no varchar2(10) not null,
		book_title varchar2(100) not null,
		author varchar2(20) not null,
		publisher varchar2(20) not null,
		publishing_date varchar2(10) not null,
		ISBN varchar2(13) not null,
		condition varchar2(10) default '���Ⱑ��',
		location varchar2(20) not null,
		type_code varchar2(20) not null,
		category varchar2(10) not null
	 */
	
	/** ������ ���� ��ȣ : PK */
	private String bookNo;
	/** ������ : �ʼ� */
	private String bookTitle;
	/** ���ڸ� : �ʼ� */
	private String author;
	/** ���ǻ� : �ʼ� */
	private String publisher;
	/** ������ : �ʼ� */
	private String publishingDate;
	/** ������ ����ǥ�غз���ȣ */
	private String isbn;
	/** �������� (ex: ������ / ���Ⱑ��) */
	private String condition;
	/** ������ ���� ��ġ */
	private String location;
	/** ������ �о� �ڵ�(û����ȣ) (ex: 853.46��) */
	private String typeCode;
	/** ������ �����з�ǥ�� ���� �з� */
	private String category;
	
	public Book() {
	}
	
	/**
	 * @param bookTitle ������
	 * @param author ����
	 * @param publisher ���ǻ�
	 * @param publishingDate ������
	 * @param condition �ڷ����
	 * @param location ������ġ
	 * @param typeCode �о��ڵ�(û����ȣ)
	 */
	public Book(String bookTitle, String author, String publisher, String publishingDate, String isbn, String location, String typeCode, String category) {
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.publishingDate = publishingDate;
		this.isbn = isbn;
		this.location = location;
		this.typeCode = typeCode;
		this.category = category;
	}

	/**
	 * @param bookNo ������ȣ
	 * @param bookTitle ������
	 * @param author ����
	 * @param publisher ���ǻ�
	 * @param publishingDate ������
	 * @param condition �ڷ����
	 * @param location ���� ��ġ
	 * @param typeCode �о��ڵ�(û����ȣ)
	 */
	public Book(String bookNo, String bookTitle, String author, String publisher, String publishingDate, String isbn, String condition,
			String location, String typeCode, String category) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.author = author;
		this.publisher = publisher;
		this.publishingDate = publishingDate;
		this.isbn = isbn;
		this.condition = condition;
		this.location = location;
		this.typeCode = typeCode;
		this.category = category;
	}

	/**
	 * @return the bookNo
	 */
	public String getBookNo() {
		return bookNo;
	}

	/**
	 * @return the bookTitle
	 */
	public String getBookTitle() {
		return bookTitle;
	}

	/**
	 * @param bookTitle the bookTitle to set
	 */
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	/**
	 * @return the publishingDate
	 */
	public String getPublishingDate() {
		return publishingDate;
	}

	/**
	 * @param publishingDate the publishingDate to set
	 */
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}

	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookNo == null) ? 0 : bookNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookNo == null) {
			if (other.bookNo != null)
				return false;
		} else if (!bookNo.equals(other.bookNo))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(bookNo);
		builder.append(", ");
		builder.append(bookTitle);
		builder.append(", ");
		builder.append(author);
		builder.append(", ");
		builder.append(publisher);
		builder.append(", ");
		builder.append(publishingDate);
		builder.append(", ");
		builder.append(isbn);
		builder.append(", ");
		builder.append(condition);
		builder.append(", ");
		builder.append(location);
		builder.append(", ");
		builder.append(typeCode);
		builder.append(", ");
		builder.append(category);
		return builder.toString();
	}
	
}
