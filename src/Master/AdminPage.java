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
			System.out.println("-----====관리자페이지====-----");

			System.out.println("1.이벤트 수정 ");
			System.out.println("2.유저검색 ");
			System.out.println("3.던전 수정 ");
			System.out.println("4.이전화면으로.. ");
			System.out.println("5.종료하기 ");
			System.out.print("메뉴 선택: ");
			admin = sc.nextInt();

			switch (admin) {
			case 1:
				System.out.println("\n1. 이벤트 수정");
				
				//EditEvent editEvent = new EditEvent();
				//editEvent.run();
				EventMenu EM = new EventMenu();
				EM.run(sc);
				
				break;

			case 2:
				System.out.println("2.유저검색");
				//SearchUser sUser = new SearchUser();
				//sUser.run();
				jdbc.IDTable.ServiceImpl IDsi = new jdbc.IDTable.ServiceImpl();
				IDsi.printList();
				break;
			case 3:
				System.out.println("3.던전 수정");
				//EditDungeon eDungeon = new EditDungeon();
				//eDungeon.run();
				MonsterEditMenu MEM = new MonsterEditMenu();
				MEM.run(sc);
				break;

			case 4:
				System.out.println("4.이전화면으로..");
				adminCheck = true;
				break;
			case 5:
				System.exit(0);
				break;
			}
		}

	}

}
