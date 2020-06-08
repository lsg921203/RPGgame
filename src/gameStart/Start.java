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
			System.out.println("원하는 메뉴를 선택하세요. (1. 회원가입   2. 로그인   3. 종료)");
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
				System.out.println("종료합니다.");
				check = true;
				break;
		
			default :
				System.out.println("올바른 메뉴를 입력하세요.");
				break;
		}
		}
	}
}
