package jdbc.Monster;

import java.util.Scanner;

public class MonsterEditMenu {
	Service sv = new ServiceImpl();
	
	public void run(Scanner sc){
		
		boolean check = true;
		
		while(check){
			System.out.println("1. ���� ����");
			System.out.println("2. ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ����Ʈ");
			System.out.println("5. ���� �޴�");
			
			System.out.print("\n �޴����� : ");
			int menu = sc.nextInt();
			switch (menu){
			case 1:
				sv.addMonster(sc);
				break;
			case 2:
				sv.updateMonster(sc);
				break;
			case 3:
				sv.deleteMonster(sc);
				break;
			case 4:
				sv.printAll();
				break;
			case 5:
				check = false;
				break;
				default:
					System.out.println("�߸���");
					break;
			}
		}
		
		
		
	}
}
