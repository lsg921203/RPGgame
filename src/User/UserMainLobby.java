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
			
			System.out.println("���ϴ� �޴��� �����ϼ��� (1. ����Ȯ��   /  2. ��������   /   3. ��������   /   4. ��ŷȮ��   /   5. �α׾ƿ�)");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				System.out.println("���¸� Ȯ���Ѵ�.");
				System.out.println(character);
				
				break;

			case 2:
				System.out.println("������ ����.");
				ShopMain SM = ShopMain.getInstance();
				SM.run(sc, c);
				
				break;

			case 3:
				System.out.println("������ ����.");
				DungeonMain dm = DungeonMain.getInstance();
				dm.run(sc, character);
				
				break;

			case 4:
				System.out.println("��ŷ�� Ȯ���Ѵ�.");
				jdbc.IDTable.ServiceImpl si = new jdbc.IDTable.ServiceImpl();
				si.CheckRank();
				
				
				break;

			case 5:
				
				correctSelect = true;
				
				break;

			default:
				System.out.println("����� �����ϼ���.");
			}
		}

	}



}
