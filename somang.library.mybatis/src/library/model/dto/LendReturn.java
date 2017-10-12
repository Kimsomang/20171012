package library.model.dto;

import java.io.Serializable;
import java.util.Date;

public class LendReturn implements Serializable {

	/*
	 * lend_code varchar2(20),
		book_no varchar2(10) not null,
		book_title varchar2(100) not null,
		member_id varchar2(20) not null,
		lend_date date not null,
		return_date date,
		return_period date not null,
		extension varchar2(10) default '0/1'
	 */
	
	/** ����� �ο��Ǵ� �ڵ� : PK */
	private String lendCode;
	/** ������ ���� ��ȣ : �ʼ� */
	private String bookNo;
	/** ���� �� �ݳ��� ������ : �ʼ� */
	private String bookTitle;
	/** ���� �� �ݳ��� ȸ�����̵� : �ʼ� */
	private String memberId;
	/** ������ : �ʼ� */
	private Date lendDate;
	/** �ݳ��� */
	private Date returnDate;
	/** �ݳ������� : �ʼ�, ������ + 10�� */
	private Date returnPeriod;
	/** ���� : ���尡��Ƚ��, ����� �ݳ������� + 7�� (ex: 0/1) */
	private String extension;
	
	public LendReturn() {
	}

	/**
	 * @param bookNo
	 * @param bookTitle
	 * @param memberId
	 */
	public LendReturn(String bookNo, String bookTitle, String memberId) {
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.memberId = memberId;
	}

	/**
	 * @param lendCode
	 * @param bookNo
	 * @param bookTitle
	 * @param memberId
	 * @param lendDate
	 * @param returnDate
	 * @param returnPeriod
	 * @param extension
	 */
	public LendReturn(String lendCode, String bookNo, String bookTitle, String memberId, Date lendDate, Date returnDate,
			Date returnPeriod, String extension) {
		this.lendCode = lendCode;
		this.bookNo = bookNo;
		this.bookTitle = bookTitle;
		this.memberId = memberId;
		this.lendDate = lendDate;
		this.returnDate = returnDate;
		this.returnPeriod = returnPeriod;
		this.extension = extension;
	}

	
	/**
	 * @return the lendCode
	 */
	public String getLendCode() {
		return lendCode;
	}

	/**
	 * @param lendCode the lendCode to set
	 */
	public void setLendCode(String lendCode) {
		this.lendCode = lendCode;
	}

	/**
	 * @return the returnDate
	 */
	public Date getReturnDate() {
		return returnDate;
	}

	/**
	 * @param returnDate the returnDate to set
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	/**
	 * @return the returnPeriod
	 */
	public Date getReturnPeriod() {
		return returnPeriod;
	}

	/**
	 * @param returnPeriod the returnPeriod to set
	 */
	public void setReturnPeriod(Date returnPeriod) {
		this.returnPeriod = returnPeriod;
	}

	/**
	 * @return the extension
	 */
	public String getExtension() {
		return extension;
	}

	/**
	 * @param extension the extension to set
	 */
	public void setExtension(String extension) {
		this.extension = extension;
	}
	
	/**
	 * @param lendDate the lendDate to set
	 */
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
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
	 * @return the membership
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @return the lendDate
	 */
	public Date getLendDate() {
		return lendDate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((lendCode == null) ? 0 : lendCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LendReturn other = (LendReturn) obj;
		if (lendCode == null) {
			if (other.lendCode != null)
				return false;
		} else if (!lendCode.equals(other.lendCode))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(lendCode);
		builder.append(", ");
		builder.append(bookNo);
		builder.append(", ");
		builder.append(bookTitle);
		builder.append(", ");
		builder.append(memberId);
		builder.append(", ");
		builder.append(lendDate);
		builder.append(", ");
		builder.append(returnDate);
		builder.append(", ");
		builder.append(returnPeriod);
		builder.append(", ");
		builder.append(extension);
		return builder.toString();
	}
	
}
