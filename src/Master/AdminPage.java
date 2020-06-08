package Master;

import java.util.Scanner;

import jdbc.EventTable.EventMenu;
import jdbc.Monster.MonsterEditMenu;


public class AdminPage {

	private static AdminPage adminpage = new AdminPage();
	private jdbc.IDTable.Character Admin_character = null;

	private AdminPage() {
	}

	public static AdminPage getInstance() {
		return adminpage;
	}
	
	public void run(Scanner sc, jdbc.IDTable.Character c) {
		
		Admin_character = c;
		int admin;

		boolean adminCheck = false;

		
		while (adminCheck == false) {
			System.out.println("");
			System.out.println("-----====������������====-----");

			System.out.println("1.�̺�Ʈ ���� ");
			System.out.println("2.�����˻� ");
			System.out.println("3.���� ���� ");
			System.out.println("4.����ȭ������.. ");
			System.out.println("5.�����ϱ� ");
			System.out.print("�޴� ����: ");
			admin = sc.nextInt();

			switch (admin) {
			case 1:
				System.out.println("\n1. �̺�Ʈ ����");
				
				//EditEvent editEvent = new EditEvent();
				//editEvent.run();
				EventMenu EM = new EventMenu();
				EM.run(sc);
				
				break;

			case 2:
				System.out.println("2.�����˻�");
				//SearchUser sUser = new SearchUser();
				//sUser.run();
				jdbc.IDTable.ServiceImpl IDsi = new jdbc.IDTable.ServiceImpl();
				IDsi.printList();
				break;
			case 3:
				System.out.println("3.���� ����");
				//EditDungeon eDungeon = new EditDungeon();
				//eDungeon.run();
				MonsterEditMenu MEM = new MonsterEditMenu();
				MEM.run(sc);
				break;

			case 4:
				System.out.println("4.����ȭ������..");
				adminCheck = true;
				break;
			case 5:
				System.exit(0);
				break;
			}
		}

	}

}
