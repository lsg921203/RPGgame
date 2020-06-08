package jdbc.Monster;

import java.util.Scanner;

public class MonsterEditMenu {
	Service sv = new ServiceImpl();
	
	public void run(Scanner sc){
		
		boolean check = true;
		
		while(check){
			System.out.println("1. 몬스터 생성");
			System.out.println("2. 몬스터 수정");
			System.out.println("3. 몬스터 삭제");
			System.out.println("4. 몬스터 리스트");
			System.out.println("5. 이전 메뉴");
			
			System.out.print("\n 메뉴선택 : ");
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
					System.out.println("잘못고름");
					break;
			}
		}
		
		
		
	}
}
