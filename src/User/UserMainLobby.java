package User;

import java.util.Scanner;

import Dungeon.DungeonMain;
import Shop.ShopMain;



public class UserMainLobby {
	private static UserMainLobby usermainlobby = new UserMainLobby();
	private jdbc.IDTable.Character character;

	private UserMainLobby() {
	}

	public static UserMainLobby getInstance() {
		return usermainlobby;
	}


	public void run(Scanner sc , jdbc.IDTable.Character c) {
		int select = 1;
		boolean correctSelect = false;
		
		//character = c;
		jdbc.Class.Class cl;
		
		jdbc.Class.DAOImpl dao = new jdbc.Class.DAOImpl();
		
		
		cl = dao.select(c.getCLS());
		
		
		switch(c.getCLS()){
		case "a":
			character = new jdbc.Class.Warrior(c,cl);
			break;
		case "b":
			character = new jdbc.Class.Wizard(c,cl);
			break;
		case "c":
			character = new jdbc.Class.Archer(c,cl);
			break;
		case "d":
			character = new jdbc.Class.Hero(c,cl);
			break;
			//c = new Warrior(c,)
		}
		character.updateHP(10000);
		character.updateMP(10000);
		

		while (correctSelect == false) {
			
			System.out.println("원하는 메뉴를 선택하세요 (1. 상태확인   /  2. 상점가기   /   3. 던전입장   /   4. 랭킹확인   /   5. 로그아웃)");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				System.out.println("상태를 확인한다.");
				System.out.println(character);
				
				break;

			case 2:
				System.out.println("상점을 간다.");
				ShopMain SM = ShopMain.getInstance();
				SM.run(sc, c);
				
				break;

			case 3:
				System.out.println("던전에 간다.");
				DungeonMain dm = DungeonMain.getInstance();
				dm.run(sc, character);
				
				break;

			case 4:
				System.out.println("랭킹을 확인한다.");
				jdbc.IDTable.ServiceImpl si = new jdbc.IDTable.ServiceImpl();
				si.CheckRank();
				
				
				break;

			case 5:
				
				correctSelect = true;
				
				break;

			default:
				System.out.println("제대로 선택하세요.");
			}
		}

	}



}
