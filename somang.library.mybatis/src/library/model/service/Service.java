package library.model.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import library.model.dao.BookDao;
import library.model.dao.LendReturnDao;
import library.model.dao.MemberDao;
import library.model.dto.Book;
import library.model.dto.LendReturn;
import library.model.dto.Member;
import library.test.Utility;

public class Service {

	/** ȸ�����̺� data access ���� ��ü ���� : DAO ��ü Ÿ�� */
	private MemberDao memberDao = MemberDao.getInstance();
	private BookDao bookDao = BookDao.getInstance();
	private LendReturnDao lendDao = LendReturnDao.getInstance();
	private Utility utility = new Utility();
	int lend;
	
	/**
	 * ���̵� �ߺ� Ȯ���� ���� �޼ҵ�
	 * @param id ����ڰ� ���Խõ��� ���̵�
	 * @return ��ϵǾ� �ִ� ���̵��̸� true, �ƴϸ� false ��ȯ
	 */
	public boolean duplicateId(String id) {
		if(memberDao.isMemberId(id))
			return true;
		return false;
	}
	
	/**
	 * ����ó �ߺ� Ȯ���� ���� �޼ҵ�
	 * @param mobile ����ó
	 * @return �ߺ��� ���̸� true, �ƴϸ� false ��ȯ
	 */
	public boolean duplicateMobile(String mobile) {
		if(memberDao.isMobile(mobile))
			return true;
		return false;
	}
	
	/**
	 * ȸ�� ��� ��û ����
	 * @param member ����� ȸ����ü ������
	 * @return ������ �߰� ���� ���, ���н� 0
	 */
	public int insert(Member member) {
		if(!duplicateId(member.getMemberId())) {
			if(!duplicateMobile(member.getMobile())) {
				return memberDao.insert(member);
			}
		}
		return 0;
	}
	
	/**
	 * �α����� ���� ���̵�, ��й�ȣ ��ȸ �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param pw ��й�ȣ
	 * @return �α��� ���� ���� �޼���
	 */
	public String logIn(String id, String pw) {
		String password = memberDao.isLogin(id);
		if(password != null) {
			if(pw.equals(password)) {
				return "1�α��� �Ǽ̽��ϴ�.";
			} else {
				return "2���̵�� ��й�ȣ�� �ٽ� Ȯ���Ͻñ� �ٶ��ϴ�.";
			}
		}
		return null;
	}
	
	/**
	 * ���̵� ã�� ���� �̸�, ����ó ��ȸ �޼ҵ�
	 * @param name ȸ�� �̸�
	 * @param mobile ����ó
	 * @return ���̵�
	 */
	public String selectId(String name, String mobile) {
		if(memberDao.selectId(name, mobile) != null)
			return memberDao.selectId(name, mobile);
		
		return null;
	}
	
	/**
	 * ��й�ȣ�� ã�� ���� ���̵� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 * @return ��й�ȣ
	 */
	public StringBuffer selectPw(String id, String name, String mobile) {
		StringBuffer sb = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		if(memberDao.selectPw(id, name, mobile) != null) {
			String pw = memberDao.selectPw(id, name, mobile);
			sb.append(pw);

			for (int i = 4; i < sb.length(); i++) {
				sb2.append('*');
			}
			sb.replace(4, sb.length(), sb2.toString());
			return sb;
		}
		return null;
	}
	
	/**
	 * ȸ������ ��ȸ�� ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @return ȸ�� ����
	 */
	public Member selectUser(String id) {
		Member member = memberDao.selectUser(id);
		
		if(member != null) {
			int compare = member.getOverDate().compareTo(utility.today());
			if(compare >= 0) {
				memberDao.updateOverDate(member.getMemberId(), null);
			}
			return member;
		}
		return null;
	}
	
	/**
	 * ȸ�� ���� ��ü ��ȸ�� ���� �޼ҵ�
	 * @return ȸ������ ����Ʈ
	 */
	public List<Member> selectAll(){
		List<Member> member = memberDao.selectAll();
		return member;
	}
	
	/**
	 * ��й�ȣ ���� ��û�� ���� �޼ҵ�
	 * @param id ���̵�
	 * @param pw ��й�ȣ
	 * @return ��й�ȣ ���� �����ϸ� true, �����ϸ� false ��ȯ
	 */
	public boolean updatePw(String id, String pw) {
		int update = memberDao.updatePw(id, pw);
		if(update != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ��й�ȣ ��ġ ���� ��ȸ�� ���� �޼ҵ�
	 * @param id ���̵�
	 * @param pw ��й�ȣ
	 * @return ��ġ�ϸ� true, ��ġ���� ������ false;
	 */
	public boolean checkPw(String id, String pw) {
		String password = memberDao.isLogin(id);
		if(password != null) {
			if(password.equals(pw)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * ����ó ���� ��û�� ���� �޼ҵ�
	 * @param id ���̵�
	 * @param mobile ����ó
	 * @return ������ true, ���н� false ��ȯ
	 */
	public boolean updateMobile(String id, String mobile) {
		int update = memberDao.updateMobile(id, mobile);
		if(update != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * �ּ� ���� ��û�� ���� �޼ҵ�
	 * @param id ���̵�
	 * @param address �ּ�
	 * @return ������ true, ���н� false ��ȯ
	 */
	public boolean updateAddress(String id, String address) {
		int update = memberDao.updateAddress(id, address);
		if(update != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ȸ�� Ż�� ��û�� ���� �޼ҵ�
	 * @param id ���̵�
	 * @return ������ true, ���н� false ��ȯ
	 */
	public boolean withdrawUser(String id) {
		if(memberDao.isMemberId(id)) {
			List<LendReturn> list = lendDao.selectLending(id);
			if(list==null) {
				if(memberDao.withdrawUser(id)!=0) {
					return true;
				} else {
					return false;
				}
			}
			for(int i = 0; i < list.size(); i++) {
				if(list.get(i).getReturnDate() == null) {
					System.out.println("�����Ͻ� å�� �ݳ��Ͽ��ּ���.");
					return false;
				}
			}
			if(memberDao.deleteUser(id)!=0) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * ���� ��� ��û�� ���� �޼ҵ�
	 * @param book ��������
	 * @return ��� �����ϸ� true, �����ϸ� false
	 */
	public boolean insertBook(Book book) {
		if(bookDao.insert(book) != 0)
			return true;
		
		return false;
	}

	/**
	 * ���� ���հ˻��� ���� �޼ҵ�
	 * @param searchInfo
	 * @return �˻��� ����Ʈ
	 */
	public List<Book> selectKeyword(HashMap<String, String> searchInfo) {
		return bookDao.selectKeyword(searchInfo);
	}
	/**
	 * ���� ��� ��ȸ ��û�� ���� �޼ҵ�
	 * @return ���� ���� ���
	 */
	public List<Book> selectBooks(){
		List<Book> book = bookDao.selectBooks();
		return book;
	}
	
	/**
	 * ���� ������ġ ���� ��û�� ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @param location ���� ������ġ
	 * @return ���� ������ true, ���н� false ��ȯ
	 */
	public boolean updateLoc(String bookNo, String location) {
		int update = bookDao.updateLoc(bookNo, location);
		if(update != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * ���� ���� ��û�� ���� �޼ҵ�
	 * @param bookNo ���� ��ȣ
	 * @return ���� ������ true, ���н� false ��ȯ
	 */
	public boolean deleteBook(String bookNo) {
		int delete = 0;
		if(lendDao.selectBook(bookNo) == null) {
			delete = bookDao.delete(bookNo);
		} else {
			delete = bookDao.deleteBook(bookNo);
		}
		if(delete != 0) {
			return true;
		}
		return false;
	}

	/**
	 * ������� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 * @param memberId ���̵�
	 * @return ����/�ݳ� �̷� ���
	 */
	public List<LendReturn> selectLending(String memberId){
		List<LendReturn> lending = lendDao.selectLending(memberId);
		return lending;
	}
	
	/**
	 * ��� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 * @return ����/�ݳ� �̷� ���
	 */
	public List<LendReturn> selectAllLending(){
		List<LendReturn> lending = lendDao.selectAll();
		return lending;
	}
	
	/**
	 * ���������ڵ带 �ο��ϱ� ���� �޼ҵ�
	 * @param num �������
	 * @return ���Ŀ� ���� �ڵ� ��ȯ
	 */
	public String toDFormat(int num){
		 DecimalFormat df = new DecimalFormat("000");
		 return df.format(num);
		}
	
	/**
	 * ���� ���� �Է� �޼ҵ�
	 * @param lending �������� ��ü
	 * @return ������ true, ���н� false
	 */
	public boolean insertLending(LendReturn lending) {
		String lendCode = utility.dateNumber()+toDFormat(++lend);
		Date lendDate = utility.today();
		Date periodDate = utility.periodDate(10);
		lending.setLendCode(lendCode);
		lending.setLendDate(lendDate);
		lending.setReturnPeriod(periodDate);
		if(memberDao.isCondition(lending.getMemberId())) {
			if(memberDao.updateLending(lending.getMemberId()) != 0) {
				if(bookDao.updateCondition(lending.getBookNo(), "������") != 0) {
					lendDao.insertLend(lending);
					return true;
				}
			} else { return false; }
		}
		return false;
	}
	
	/**
	 * �ݳ� ���� �Է� �޼ҵ�
	 * @param id ���̵�
	 * @param lendCode �����ڵ�
	 * @return �ݳ� ������ true, ���н� false
	 */
	public boolean updateReturn(String id, String lendCode) {
		Date returnDate = utility.today();
		if(lendDao.updateReturn(id, lendCode, returnDate) != 0) {
			memberDao.updateReturn(id);
			int over = lendDao.isoverdue(lendCode);
			if(over < 0) {
				if(memberDao.updateCondition(id)!=0) {
					Date overdue = utility.periodDate(-over);
					memberDao.updateOverDate(id, overdue);
					System.out.println("��ü�Ⱓ��ŭ ����Ұ� ���°� �˴ϴ�.");
				} else {
						System.out.println("����Ұ� ������ �����߽��ϴ�.");
				}
			}
			return true;
		}
		return false;
	}
	
	/**
	 * �ݳ��Ⱓ ���� �޼ҵ�
	 * @param lendCode �����ڵ�
	 * @return ������ true, ���н� false
	 */
	public boolean updatePeriod(String lendCode) {
		if(lendDao.updatePeriod(lendCode) != 0)
			return true;
		return false;
	}
	
	/**
	 * ���� ��� �޼ҵ�
	 * @param lendCode �����ڵ�
	 * @return ������ true, ���н� false
	 */
	public boolean deleteLend(String lendCode) {
		if(lendDao.deleteLend(lendCode) != 0)
			return true;
		return false;
	}
	
	public boolean updateOverDate(String id, int overdue) {
		Date overdate = utility.periodDate(overdue);
		if(memberDao.updateOverDate(id, overdate) != 0) {
			return true;
		}
		return false;
	}
}
