package library.view;

import java.util.Scanner;

import library.controller.Controller;
import library.model.dto.Book;
import library.model.dto.LendReturn;
import library.model.dto.Member;

public class MenuView {
	
	Scanner scan = new Scanner(System.in);
	Controller controller = new Controller();
	
	/**
	 * ���� �޴� ��� �޼ҵ�
	 * @return �޴� �Է°�
	 */
	public String mainMenu() {
		System.out.println("\n*****�Ҹ�������*****");
		System.out.println(" 1. ȸ������");
		System.out.println(" 2. �α���");
		System.out.println(" 3. ���̵�ã��");
		System.out.println(" 4. ��й�ȣã��");
		System.out.println(" 5. ���� �˻�");
		System.out.println(" 6. ���������ȸ");
		System.out.println(" 7. ����");
		System.out.println("********************");
		System.out.print("�޴��� �����ϼ���. : ");
		String num = scan.nextLine();
		
		if(!num.matches("[1-7]")) {
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			num = "0";
		}
		return num;
	}
	
	/**
	 * ����ڸ޴� ��� �޼ҵ�
	 * @param id ȸ�����̵�
	 * @return �޴� �Է°�
	 */
	public String userMenu(String id) {
		System.out.println("\n********************");
		System.out.println(id + "�� ȯ���մϴ�.");
		System.out.println("********************");
		System.out.println(" 1. ������ Ȯ��");
		System.out.println(" 2. �����˻�");
		System.out.println(" 3. ���� ��� ��ȸ");
		System.out.println(" 4. ����/�ݳ� Ȯ��");
		System.out.println(" 5. ������ ����");
		System.out.println(" 6. ȸ��Ż��");
		System.out.println(" 7. �α׾ƿ�");
		System.out.println("********************");
		System.out.print("�޴��� �����ϼ���. : ");
		String num = scan.nextLine();
		
		if(!num.matches("[1-7]")) {
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			num = "0";
		}
			
		return num;
	}
	
	/**
	 * �����ڸ޴� ��� �޼ҵ�
	 * @return �޴� �Է°�
	 */
	public String managerMenu() {
		System.out.println("\n********************");
		System.out.println(" 1. ȸ������ ��ȸ");
		System.out.println(" 2. ���� ����ϱ�");
		System.out.println(" 3. ���� �˻�");
		System.out.println(" 4. ���� ��� ��ȸ");
		System.out.println(" 5. ���� ����/�ݳ�");
		System.out.println(" 6. ���� ��ġ ����");
		System.out.println(" 7. ���� �ڷ� ����");
		System.out.println(" 8. ��й�ȣ ����");
		System.out.println(" 9. �α׾ƿ�");
		System.out.println("********************");
		System.out.print("�޴��� �����ϼ���. : ");
		String num = scan.nextLine();
		
		if(!num.matches("[1-9]")) {
			System.out.println("�߸��� ���� �Է��ϼ̽��ϴ�.");
			num = "0";
		}
		return num;
	}
	
	/**
	 * ȸ������ �޴� ��� �޼ҵ�
	 */
	public void joining() {
		System.out.println("\n********************");
		String id;
		do {
			System.out.print("���̵� : ");
			id = scan.nextLine();
		} while (controller.isMemberId(id));
		
		System.out.print("\n��й�ȣ : ");
		String password = scan.nextLine();
		System.out.print("�̸� : ");
		String name = scan.nextLine();
		System.out.print("�������(ex:1995.01.23) : ");
		String birth = scan.nextLine();
		String mobile;
		do {
			System.out.print("����ó('-'����) : ");
			mobile = scan.nextLine();
		} while (controller.isMobile(mobile));
		
		System.out.print("\n�ּ� : ");
		String address = scan.nextLine();
		
		Member member = new Member(id, password, name, birth, mobile, address);
		System.out.println(controller.insert(member));
	}
	
	/**
	 * �α��� �޴� ��� �޼ҵ�
	 * @return �α��� �� ���̵�
	 */
	public String logIn() {
		System.out.println("\n********************");
		System.out.print("���̵� : ");
		String id = scan.nextLine();
		System.out.print("��й�ȣ : ");
		String password = scan.nextLine();
		
		if(controller.logIn(id, password)) {
			return id;
		} else {
			return null;
		}
	}
	
	/**
	 * ���̵�ã�� �޴� ��� �޼ҵ�
	 */
	public void selectId() {
		System.out.println("\n********************");
		System.out.print("�̸� : ");
		String name = scan.nextLine();
		System.out.print("����ó : ");
		String mobile = scan.nextLine();
		
		String id = controller.selectId(name, mobile);
		
		if(id != null) {
			System.out.println("ã���ô� ���̵�� " + id + " �Դϴ�.");
		} else {
			System.out.println("ã���ô� ���̵� �����ϴ�.");
		}
		
		System.out.println("�������� ���ư��ϴ�.");
	}
	
	/**
	 * ��й�ȣ ã�� �޴� ��� �޼ҵ�
	 */
	public void selectPw() {
		System.out.println("\n********************");
		System.out.print("���̵� : ");
		String id = scan.nextLine();
		System.out.print("�̸� : ");
		String name = scan.nextLine();
		System.out.print("����ó : ");
		String mobile = scan.nextLine();
		StringBuffer pw = controller.selectPw(id, name, mobile);
		if(pw != null) {
			System.out.print("������ ��й�ȣ : ");
			String password = scan.nextLine();
			String msg = controller.changePw(id, password);
			System.out.println(msg);
		} else {
			System.out.println("���̵� �������� �ʽ��ϴ�.");
		}
		System.out.println("�������� ���ư��ϴ�.");
	}
	
	/**
	 * ȸ���� ���� ��ȸ ��� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 */
	public void selectUser(String id) {
		System.out.println("\n********************");
		Member member = controller.selectUser(id);
		if(member != null)
			System.out.println(member.toString());
	}
	
	/**
	 * ȸ������ ��� ��ȸ ��� �޼ҵ�
	 */
	public void selectUsers() {
		System.out.println("\n********************");
		controller.selectAll();
	}
	
	/**
	 * ȸ���� ���� ���� �޴� ��� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 * @return �����ϰ��� �ϴ� �޴� ��ȣ �Է°�
	 */
	public String changeUser(String id) {
		System.out.println("\n********************");
		System.out.println(" 1. ��й�ȣ ����");
		System.out.println(" 2. ����ó ����");
		System.out.println(" 3. �ּ� ����");
		System.out.println("\n********************");
		System.out.print("�޴��� �����ϼ���. : ");
		String num = scan.nextLine();
		return num;
	}
	
	/**
	 * ��й�ȣ ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 */
	public void changePw(String id) {
		boolean flag;
		
		do {
			System.out.println("\n********************");
			System.out.print("��й�ȣ �Է� : ");
			String pw = scan.nextLine();
		
			if(!controller.checkPw(id, pw)) {
				flag = true;
			} else {
				System.out.print("������ ��й�ȣ : ");
				String password = scan.nextLine();
				System.out.println(controller.changePw(id, password));
				flag = false;
			}
		} while(flag);
	}
	
	/**
	 * ����ó ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 */
	public void changeMobile(String id) {
		System.out.println("\n********************");
		System.out.print("������ ����ó : ");
		String mobile = scan.nextLine();
		System.out.println(controller.changeMobile(id, mobile));
	}
	
	/**
	 * �ּ� ���� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 */
	public void changeAddress(String id) {
		System.out.println("\n********************");
		System.out.print("������ �ּ� : ");
		String address = scan.nextLine();
		System.out.println(controller.changeAddress(id, address));
	}
	
	/**
	 * ȸ�� Ż�� �޼ҵ�
	 * @param id ȸ�� ���̵�
	 */
	public String withdrawUser(String id) {
		System.out.println("\n********************");
		System.out.print("���� Ż���Ͻðڽ��ϱ�?(Y/N) : ");
		String answer = scan.nextLine();

		if(answer.equals("y") || answer.equals("Y")) {
			if(controller.withdrawUser(id)) {
				System.out.println("Ż��Ǿ����ϴ�.");
				return "7";
			} else {
				System.out.println("ȸ��Ż�� �����߽��ϴ�.");
				return "0";
			}
		} else {
			System.out.println("�޴�ȭ������ ���ư��ϴ�.");
			return "0";
		}
	}
	
	/**
	 * ������� �޴� ��� �޼ҵ�
	 */
	public void insertBook() {
		System.out.println("\n********************");
		System.out.print("������ : ");
		String title = scan.nextLine();
		System.out.print("���ڸ� : ");
		String author = scan.nextLine();
		System.out.print("���ǻ� : ");
		String publisher = scan.nextLine();
		System.out.print("������(ex:1995.01.23) : ");
		String publishingDate = scan.nextLine();
		System.out.print("ISBN : ");
		String isbn = scan.nextLine();
		System.out.print("������ġ : ");
		String location = scan.nextLine();
		System.out.print("û����ȣ : ");
		String typeCode = scan.nextLine();
		System.out.print("�з���ȣ : ");
		String category = scan.nextLine();
		
		Book book = new Book(title, author, publisher, publishingDate, isbn, location, typeCode, category);
		System.out.println(controller.insertBook(book));
	}
	
	/**
	 * �����˻� ��ȸ ��� �޼ҵ�
	 */
	public void selectBook() {
		System.out.println("\n********************");
		System.out.println("1. ������   2. ���ڸ�   3. ���ǻ�   4. ������   5. �����з�");
		System.out.print("�˻��ϰ��� �ϴ� �׸��� �Է��ϼ���.(���Է½� ��ü��ȸ, ���߼��ð���) : ");
		String category = scan.nextLine();
		System.out.print("�˻��ϰ��� �ϴ� Ű���带 �Է��ϼ���. : ");
		String keyword = scan.nextLine();
			
		controller.selectKeyword(keyword, category);
	}
	
	/**
	 * ���� ��� ��ȸ ��� �޼ҵ�
	 */
	public void selectBooks() {
		System.out.println("\n********************");
		controller.selectBooks();
	}
	
	/**
	 * ���� ������ġ ���� �޴� ��� �޼ҵ�
	 */
	public void updateLoc() {
		System.out.println("\n********************");
		System.out.print("��ġ ������ ������ȣ : ");
		String bookNo = scan.nextLine();
		System.out.print("������ ��ġ : ");
		String location = scan.nextLine();
		System.out.println(controller.updateLoc(bookNo, location));
	}
	
	/**
	 * ���� ���� ���� �޴� ��� �޼ҵ�
	 */
	public void deleteBook() {
		System.out.println("\n********************");
		System.out.print("������ ������ȣ : ");
		String bookNo = scan.nextLine();
		scan.nextLine();
		System.out.println(controller.deleteBook(bookNo));
	}
	
	/**
	 * ���� ����/�ݳ� �޴� ��� �޼ҵ�
	 * @return
	 */
	public String lendingMenu() {
		System.out.println("\n********************");
		System.out.println(" 1. ��������");
		System.out.println(" 2. �����ݳ�");
		System.out.println(" 3. ���ѿ���");
		System.out.println(" 4. �������");
		System.out.println(" 5. �����ȸ");
		System.out.println("********************");
		System.out.print("�޴� ���� : ");
		String select = scan.nextLine();
		return select;
	}
	
	/**
	 * ������� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 * @param id ���̵�
	 */
	public void selectLending(String id) {
		System.out.println("\n********************");
		controller.selectLending(id);
	}
	
	/**
	 * ��� ����/�ݳ� �̷� ��ȸ �޼ҵ�
	 */
	public void selectAllLending() {
		System.out.println("\n********************");
		controller.selectAllLending();
	}
	
	/**
	 * ���� �޴� ��� �޼ҵ�
	 */
	public void insertLend() {
		System.out.println("\n********************");
		System.out.print("������ȣ : ");
		String bookNo = scan.nextLine();
		System.out.print("������ : ");
		String title = scan.nextLine();
		System.out.print("ȸ�����̵� : ");
		String id = scan.nextLine();
		
		LendReturn lending = new LendReturn(bookNo, title, id);
		System.out.println(controller.insertLending(lending));
	}
	
	/**
	 * �ݳ� �޴� ��� �޼ҵ�
	 */
	public void updateReturn() {
		System.out.println("\n********************");
		System.out.print("ȸ�� ���̵� : ");
		String id = scan.nextLine();
		System.out.print("�����ڵ� : ");
		String lendCode = scan.nextLine();
		
		System.out.println(controller.updateReturn(id, lendCode));
	}
	
	/**
	 * ���� ���� �޴� ��� �޼ҵ�
	 */
	public void updatePeriod() {
		System.out.println("\n********************");
		System.out.print("�����ڵ� : ");
		String lendCode = scan.nextLine();
		
		System.out.println(controller.updatePeriod(lendCode));
	}
	
	/**
	 * ������� �޴� ��� �޼ҵ�
	 */
	public void deleteLend() {
		System.out.println("\n********************");
		System.out.print("�����ڵ� : ");
		String lendCode = scan.nextLine();
		
		System.out.println(controller.deleteLend(lendCode));
	}
}
