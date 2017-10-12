package library.controller;

import java.util.HashMap;
import java.util.List;

import library.model.dto.Book;
import library.model.dto.LendReturn;
import library.model.dto.Member;
import library.model.service.Service;

public class Controller {
	
	private Service service = new Service();
	
	/**
	 * ȸ�����Խ� ���̵� �ߺ� ���� �޼ҵ�
	 * @param id
	 * @return �����߻� �� �ߺ��� true, �ߺ��� �ƴϸ� false ��ȯ
	 */
	public boolean isMemberId(String id) {
		if(id == null || id.trim().length() < 5 || id.trim().length() > 20) {
			System.out.println("Error : ���̵� ���� ����(����/���� 5~20����)\n");
			return true;
		}
		if(id.matches("[0-9a-zA-Z]")) {
			System.out.println("Error : ���̵� ����(����/���ڸ� ����)\n");
			return true;
		}
		if(service.duplicateId(id)) {
			System.out.println("�̹� ��ϵǾ� �ִ� ���̵��Դϴ�.");
			return true;
		}
		System.out.println("��� ������ ���̵��Դϴ�.");
		return false;
	}
	
	/**
	 * ����ó �ߺ� ���� �޼ҵ�
	 * @param mobile
	 * @return �����߻� �� �ߺ��� true, �ߺ��� �ƴϸ� false ��ȯ
	 */
	public boolean isMobile(String mobile) {
		if(mobile == null || mobile.trim().length() == 0) {
			System.out.println("Error : ����ó�� �Էµ��� ����");
			return true;
		}
		if(service.duplicateMobile(mobile)) {
			System.out.println("�̹� ��ϵǾ� �ִ� ����ó�Դϴ�.");
			return true;
		}
		return false;
	}
	
	/**
	 * ȸ������ ��� ������ ���� �޼ҵ�
	 * @param member ȸ�� ��ü
	 * @return ������ ��ûó���� ���� �޽��� ��ȯ(���Ŀ� ���� ���� �� Error �޽��� ��ȯ)
	 */
	public String insert(Member member) {
		StringBuilder value = new StringBuilder();
		
		if(member == null) {
			value.append("Error : ������ �������� ����");
			return value.toString();
		}
		
		String password = member.getPassword();
		String name = member.getName();
		String birth = member.getBirth();
		String address = member.getAddress();
		
		if(password == null || password.trim().length() == 0 || password.trim().length() < 5
				|| password.trim().length() > 20) {
			value.append("Error : ��й�ȣ ���� ����(����/���� 5~20����)\n");
		} else if (password.matches("[0-9a-zA-Z]")) {
			value.append("Error : ��й�ȣ ����(����/���ڸ� ����)");
		}
		
		if(name == null || name.trim().length() == 0 || name.trim().length() > 10)
			value.append("Error : �̸� ���� �ʰ�(�ѱ� 10�ڸ����� �Է� ����)\n");
		
		if(birth == null || birth.trim().length() == 0)
			value.append("Error : ��������� �Էµ��� ����\n");
		
		if(address == null || address.trim().length() == 0)
			value.append("Error : �ּҰ� �Էµ��� ����\n");
		
		if(value.length() != 0)
			return value.toString();
		
		int result = service.insert(member);
		
		if(result == 1) {
			return "Success : ȸ�������� ���� �Ϸ�Ǿ����ϴ�.";
		} else {
			return "Fail : ȸ�������� ���������� �̷������ �ʾҽ��ϴ�.";
		}
	}
	
	/**
	 * �α����� ���� ���̵� ��ȸ �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param pw ��й�ȣ
	 * @return ���̵� �����ϸ� true, �������������� false
	 */
	public boolean logIn(String id, String pw) {
		if(service.logIn(id, pw) == null) {
			System.out.println("���̵�� ��й�ȣ�� �ٽ� Ȯ���Ͻñ� �ٶ��ϴ�.");
			return false;
		} else {
			if(service.logIn(id, pw).startsWith("1")) {
				System.out.println(service.logIn(id, pw).substring(1));
				return true;
			} else {
				System.out.println(service.logIn(id, pw).substring(1));
				return false;
			}
		}
	}
	
	/**
	 * ���̵�ã�⸦ ���� ��ȸ �޼ҵ�
	 * @param name �̸�
	 * @param mobile ����ó
	 * @return ���̵�
	 */
	public String selectId(String name, String mobile) {
		return service.selectId(name, mobile);
	}
	
	/**
	 * ��й�ȣ ã�⸦ ���� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 * @param name �̸�
	 * @return ��й�ȣ ��4�ڸ� + secure�ڵ�
	 */
	public StringBuffer selectPw(String id, String name, String mobile) {
		return service.selectPw(id, name, mobile);
	}
	
	/**
	 * ȸ�� ���� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 */
	public Member selectUser(String id) {
		return service.selectUser(id);
	}
	
	/**
	 * ȸ�� ���� ��ü ��ȸ �޼ҵ�
	 */
	public void selectAll() {
		List<Member> member = service.selectAll();
		if(member != null) {
			for(int i = 0; i < member.size(); i++) {
				System.out.println(member.get(i));
			}
		} else {
			System.out.println("ȸ���� �������� �ʽ��ϴ�.");
		}
	}
	
	/**
	 * ��й�ȣ ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param pw ������ ��й�ȣ
	 * @return ��й�ȣ ���� ���� �޼���
	 */
	public String changePw(String id, String pw) {
		if(service.updatePw(id, pw)) {
			return "��й�ȣ�� ����Ǿ����ϴ�.";
		} else {
			return "��й�ȣ ���濡 �����Ͽ����ϴ�.";
		}
	}
	
	/**
	 * ��й�ȣ Ȯ�� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @param pw ��й�ȣ
	 * @return ��ġ�ϸ� true, ��ġ���� ������ false ��ȯ
	 */
	public boolean checkPw(String id, String pw) {
		if(service.checkPw(id, pw)) {
			return true;
		} else {
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return false;
		}
	}
	
	/**
	 * ����ó ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param mobile ������ ����ó
	 * @return ����ó ���� ���� �޼���
	 */
	public String changeMobile(String id, String mobile) {
		if(service.duplicateMobile(mobile)) {
			return "�̹� ��ϵǾ� �ִ� ����ó�Դϴ�.\n����ó�� �ߺ� ����� �� �����ϴ�.";
		} else {
			if(service.updateMobile(id, mobile)) {
				return "����ó�� ����Ǿ����ϴ�.";
			} else {
				return "����ó ���濡 �����Ͽ����ϴ�.";
			}
		}
	}
	
	/**
	 * �ּ� ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @param address ������ �ּ�
	 * @return �ּ� ���� ���� �޼���
	 */
	public String changeAddress(String id, String address) {
		if(service.updateAddress(id, address)) {
			return "�ּҰ� ����Ǿ����ϴ�.";
		} else {
			return "�ּ� ���濡 �����Ͽ����ϴ�.";
		}
	}
	
	/**
	 * ȸ�� Ż�� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @return ȸ��Ż�� ������ true, ���н� false
	 */
	public boolean withdrawUser(String id) {
		if(service.withdrawUser(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * ���� ��� ������ ���� �޼ҵ�
	 * @param book ���� ��ü
	 * @return ������ ��ûó���� ���� �޽��� ��ȯ(���Ŀ� ���� ���� �� Error �޽��� ��ȯ)
	 */
	public String insertBook(Book book) {
		StringBuilder value = new StringBuilder();
		
		if(book == null) {
			value.append("Error : ������ �������� ����");
			return value.toString();
		}
		
		String title = book.getBookTitle();
		String author = book.getAuthor();
		String publisher = book.getPublisher();
		String publishingDate = book.getPublishingDate();
		String isbn = book.getIsbn();
		String location = book.getLocation();
		String typeCode = book.getTypeCode();
		String category = book.getCategory();
		
		if(title == null || title.trim().length() == 0)
			value.append("Error : �������� �Էµ��� ����\n");
		
		if(author == null || author.trim().length() == 0 || author.trim().length() > 10)
			value.append("Error : ���ڸ� ���� �ʰ�(�ѱ� 15�ڸ����� �Է� ����)\n");
		
		if(publisher == null || publisher.trim().length() == 0)
			value.append("Error : ���ǻ簡 �Էµ��� ����\n");
		
		if(publishingDate == null || publishingDate.trim().length() == 0)
			value.append("Error : �������� �Էµ��� ����\n");
		
		if(isbn == null || isbn.trim().length() == 0)
			value.append("Error : isbn�� �Էµ��� ����\n");
		
		if(location == null || location.trim().length() == 0)
			value.append("Error : ���� ��ġ�� �Էµ��� ����\n");
		
		if(typeCode == null || typeCode.trim().length() == 0)
			value.append("Error : û����ȣ�� �Էµ��� ����\n");
		
		if(category == null || category.trim().length() == 0)
			value.append("Error : �з���ȣ�� �Էµ��� ����\n");
		
		if(value.length() != 0)
			return value.toString();
		
		boolean result = service.insertBook(book);
		
		if(result) {
			return "Success : ��������� ���� �Ϸ�Ǿ����ϴ�.";
		} else {
			return "Fail : ��������� ���������� �̷������ �ʾҽ��ϴ�.";
		}
	}
	
	/**
	 * ���� ���հ˻� ������ ���� �޼ҵ�
	 * @param keyword �˻�Ű����
	 * @param category �˻��׸�
	 */
	public void selectKeyword(String keyword, String category) {
		List<Book> book = service.selectKeyword(setSearchInfo(keyword, category));
		if(book == null || book.isEmpty()) {
			System.out.println("ã���ô� å�� �����ϴ�.");
			return;
		}
		for(int i = 0; i < book.size(); i++) {
			System.out.println(book.get(i));
		}
	}
	
	/**
	 * ���� ��� ��ȸ �޼ҵ�
	 */
	public void selectBooks() {
		List<Book> book = service.selectBooks();
		if(book != null) {
			for(int i = 0; i < book.size(); i++) {
				System.out.println(book.get(i));
			}
		} else {
			System.out.println("���������� �������� �ʽ��ϴ�.");
		}
	}
	
	/**
	 * ���� ������ġ ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @param location ������ġ
	 * @return ������ġ ���� ���� �޼���
	 */
	public String updateLoc(String bookNo, String location) {
		if(service.updateLoc(bookNo, location)) {
			return "������ġ�� ����Ǿ����ϴ�.";
		} else {
			return "������ġ ���濡 �����Ͽ����ϴ�.";
		}
	}
	
	/**
	 * ���� ���� ���� �޼ҵ�
	 * @param bookNo ������ȣ
	 * @return ���� ���� ���� ���� �޼���
	 */
	public String deleteBook(String bookNo) {
		if(service.deleteBook(bookNo)) {
			return "���� ������ �����Ǿ����ϴ�.";
		} else {
			return "���� ���� ������ �����Ͽ����ϴ�.";
		}
	}
	
	/**
	 * ������� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 * @param memberId ���̵�
	 */
	public void selectLending(String memberId) {
		List<LendReturn> lending = service.selectLending(memberId);
		for(int i = 0; i < lending.size(); i++) {
			System.out.println(lending.get(i));
		}
	}
	
	/**
	 * ��� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 */
	public void selectAllLending() {
		List<LendReturn> lending = service.selectAllLending();
		for(int i = 0; i < lending.size(); i++) {
			System.out.println(lending.get(i));
		}
	}
	
	/**
	 * ���� ��û �޼ҵ�
	 * @param lending �������� ��ü
	 * @return ���� ���� �Է� ���� ���� �޼���
	 */
	public String insertLending(LendReturn lending) {
		if(service.insertLending(lending))
			return "���� ��û�� ���������� ó���Ǿ����ϴ�.";
		else
			return "���� ��û�� �����߽��ϴ�.";
	}
	
	/**
	 * �ݳ� ��û �޼ҵ�
	 * @param id ���̵�
	 * @param lendCode �����ڵ�
	 * @return �ݳ� ��û ���� ���� �޼���
	 */
	public String updateReturn(String id, String lendCode) {
		if(service.updateReturn(id, lendCode)) {
			return "�ݳ� ��û�� ���������� ó���Ǿ����ϴ�.";
		} else {
			return "�ݳ� ��û�� �����߽��ϴ�.";
		}
	}
	
	/**
	 * ���� ��û �޼ҵ�
	 * @param lendCode �����ڵ�
	 * @return ���� ��û ���� ���� �޼���
	 */
	public String updatePeriod(String lendCode) {
		if(service.updatePeriod(lendCode)) {
			return "�ݳ� ������ ����Ǿ����ϴ�.";
		} else {
			return "���� ���忡 �����߽��ϴ�.";
		}
	}
	
	/**
	 * ���� ��� ��û �޼ҵ�
	 * @param lendCode �����ڵ�
	 * @return ���� ��� ���� ���� �޼���
	 */
	public String deleteLend(String lendCode) {
		if(service.deleteLend(lendCode)) {
			return "������ ��ҵǾ����ϴ�.";
		} else {
			return "���� ��ҿ� �����߽��ϴ�.";
		}
	}
	
	private HashMap<String, String> setSearchInfo(String keyword, String category) {
		HashMap<String, String> searchInfo = new HashMap<>();
		searchInfo.put("keyword", keyword);
		if(category == null || category.trim().length() == 0) {
			category = "12345";
		}
		char choice[] = category.toCharArray();
		for(char check : choice) {
			switch(check) {
				case '1' :
					searchInfo.put("column1", "book_title");
					break;
				case '2' :
					searchInfo.put("column2", "author");
					break;
				case '3' :
					searchInfo.put("column3", "publisher");
					break;
				case '4' :
					searchInfo.put("column4", "publishing_date");
					break;
				case '5' :
					searchInfo.put("column5", "type_code");
					break;
			}
		}
		return searchInfo;
	}
}
