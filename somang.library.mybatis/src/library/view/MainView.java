package library.view;

public class MainView {

	public static void main(String[] args) {
	
		MenuView menu = new MenuView();
		String mainNum;
		
		do {
			mainNum = menu.mainMenu();
			
			switch(mainNum) {
			case "1" : //ȸ������
				menu.joining();
				break;
			
			case "2" : //�α���
				String id = menu.logIn();
				
				if(id == null) {
					System.out.println("�������� ���ư��ϴ�.");
					break;
				}
				
				if(id.equals("Manager")) { //������ �޴�
					String manager;
					do {
						manager = menu.managerMenu();
						
						switch(manager) {
						case "1" : //ȸ�� ���� ��ȸ
							menu.selectUsers();
							break;
						
						case "2" : //���� ����ϱ�
							menu.insertBook();
							break;
						
						case "3" : //���� �˻�
							menu.selectBook();
							break;
						
						case "4" : //���� ��� ��ȸ
							menu.selectBooks();
							break;
						
						case "5" : //���� ����/�ݳ�
							String number = menu.lendingMenu();
							switch(number) {
							case "1" : //����
								menu.insertLend();
								break;
							case "2" : //�ݳ�
								menu.updateReturn();
								break;
							case "3" : //����
								menu.updatePeriod();
								break;
							case "4" : //���
								menu.deleteLend();
								break;
							case "5" : //�����ȸ
								menu.selectAllLending();
								break;
							}
							break;
						
						case "6" : //���� �ڷ� ����
							menu.updateLoc();
							break;
						
						case "7" : //���� �ڷ� ����
							menu.deleteBook();
							break;
						
						case "8" : //��й�ȣ ����
							menu.changePw(id);
						}
					} while(!manager.equals("9"));
				
				} else if(!id.isEmpty()) { //����� �޴�
					String user;
					
					do {
						user = menu.userMenu(id);
						
						switch(user) {
						case "1" : //������ Ȯ��
							menu.selectUser(id);
							break;
						
						case "2" : //�����˻�
							menu.selectBook();
							break;
						
						case "3" : //���� ��� ��ȸ
							menu.selectBooks();
							break;
						
						case "4" : //����/�ݳ� Ȯ��
							menu.selectLending(id);
							break;
						
						case "5" : //������ ����
							String update = menu.changeUser(id);
							switch(update) {
							case "1" : //��й�ȣ ����
								menu.changePw(id);
								break;
							case "2" : //����ó ����
								menu.changeMobile(id);
								break;
							case "3" : //�ּ� ����
								menu.changeAddress(id);
							}
							break;
							
						case "6" : //ȸ��Ż��
							user = menu.withdrawUser(id);
						}
					} while(!user.equals("7"));
				}
				break;
			
			case "3" : //���̵�ã��
				menu.selectId();
				break;
				
			case "4" : //��й�ȣã��
				menu.selectPw();
				break;
				
			case "5" : //�����˻�
				menu.selectBook();
				break;
			case "6" : //���� ��� ��ȸ
				menu.selectBooks();
			}
		
		} while(!mainNum.equals("7"));
		
		System.out.println("�����մϴ�.");
	}
	
}
