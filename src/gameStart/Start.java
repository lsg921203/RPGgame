package gameStart;

import java.util.Scanner;

import Master.AdminPage;
import User.UserMainLobby;
import jdbc.IDTable.ServiceImpl;

public class Start {
	private Start s = null;
	jdbc.IDTable.Character c = null;
	
	public Start getInstance() {
		if(s == null) {
			s = new Start();
		}
		
		return s;
	}
	
	public void run(Scanner sc) {
		boolean check = false;
		
		while(check == false) {
			System.out.println("���ϴ� �޴��� �����ϼ���. (1. ȸ������   2. �α���   3. ����)");
			int index = sc.nextInt();
			
			ServiceImpl si = new ServiceImpl();
		
			switch (index) {
			case 1 :
				
				si.MakeCharacter(sc);
				break;
				
			case 2 :
				c = si.LogIn(sc);
				//System.out.println(c);/////////
				if (c == null) {break;}
				if(c.getID().equals("Admin")){
					AdminPage ap = AdminPage.getInstance();
					ap.run(sc, c);
					//check = true;
					break;
				}
				
				
				UserMainLobby uml = UserMainLobby.getInstance();
				uml.run(sc, c);
				//check = true;
				break;
			
			case 3 :
				System.out.println("�����մϴ�.");
				check = true;
				break;
		
			default :
				System.out.println("�ùٸ� �޴��� �Է��ϼ���.");
				break;
		}
		}
	}
}
