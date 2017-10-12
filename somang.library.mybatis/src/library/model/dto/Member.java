package library.model.dto;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {

	/*
	 * member_id varchar2(20) primary key,
		member_pw varchar2(20) not null,
		member_name varchar2(20) not null,
		birth varchar2(20) not null,
		mobile varchar2(20) not null,
		address varchar2(100) not null,
		lend_book varchar2(10) default '0/5',
		condition varchar2(10) default '���Ⱑ��',
		over_date date
	 */
	
	/** ȸ�� ���̵� : PK, �ʼ�, �ߺ��Ұ� */
	private String memberId;
	/** ȸ�� ��й�ȣ : �ʼ� */
	private String password;
	/** ȸ�� �̸� : �ʼ� */
	private String name;
	/** ȸ�� ������� : �ʼ� */
	private String birth;
	/** ����ó : �ʼ� (ex: 010-1234-1234) */
	private String mobile;
	/** �ּ� : �ʼ� */
	private String address;
	/** ���� �Ǽ� (ex: 0/5) */
	private String lendBook;
	/** ���� ���� ���� ���� (ex: ���Ⱑ�� / ����Ұ�) */
	private String condition;
	/** ����Ұ��Ⱓ */
	private Date overDate;
	
	public Member() {
	}

	/**
	 * @param memberId ȸ�����̵�
	 * @param password ��й�ȣ
	 * @param name ȸ���� �̸�
	 * @param birth �������
	 * @param mobile ����ó
	 * @param address �ּ�
	 */
	public Member(String memberId, String password, String name, String birth, String mobile, String address) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.mobile = mobile;
		this.address = address;
	}

	/**
	 * @param memberId ȸ�����̵�
	 * @param password ��й�ȣ
	 * @param name ȸ���� �̸�
	 * @param birth �������
	 * @param mobile ����ó
	 * @param address �ּ�
	 * @param lendBook ����Ǽ�
	 * @param condition ���Ⱑ�ɿ���
	 * @param overDate ����Ұ��Ⱓ
	 */
	public Member(String memberId, String password, String name, String birth, String mobile,
			String address, String lendBook, String condition, Date overDate) {
		this.memberId = memberId;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.mobile = mobile;
		this.address = address;
		this.lendBook = lendBook;
		this.condition = condition;
		this.overDate = overDate;
	}

	/**
	 * @return the memberId
	 */
	public String getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birth
	 */
	public String getBirth() {
		return birth;
	}

	/**
	 * @param birth the birth to set
	 */
	public void setBirth(String birth) {
		this.birth = birth;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the lendBook
	 */
	public String getLendBook() {
		return lendBook;
	}

	/**
	 * @param lendBook the lendBook to set
	 */
	public void setLendBook(String lendBook) {
		this.lendBook = lendBook;
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
	 * @return the overDate
	 */
	public Date getOverDate() {
		return overDate;
	}

	/**
	 * @param overDate the overDate to set
	 */
	public void setOverDate(Date overDate) {
		this.overDate = overDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
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
		Member other = (Member) obj;
		if (memberId == null) {
			if (other.memberId != null)
				return false;
		} else if (!memberId.equals(other.memberId))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\n���̵� : ");
		builder.append(memberId);
		builder.append("\n��й�ȣ : ");
		builder.append(password);
		builder.append("\n�̸� : ");
		builder.append(name);
		builder.append("\n������� : ");
		builder.append(birth);
		builder.append("\n����ó : ");
		builder.append(mobile);
		builder.append("\n�ּ� : ");
		builder.append(address);
		builder.append("\n����Ǽ� : ");
		builder.append(lendBook);
		builder.append("\n���Ⱑ�ɿ��� : ");
		builder.append(condition);
		builder.append("\n����Ұ��Ⱓ : ");
		builder.append(overDate);
		return builder.toString();
	}
	
	
	
}
