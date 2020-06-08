package jdbc.EventTable;

import java.util.Scanner;

public class EventMenu {
	Service sv = new ServiceImpl(); 
	
	public void run(Scanner sc){
		boolean check = true;
		int menu;
		while(check){
			System.out.println("");
			System.out.println("-이벤트 관리-");
			System.out.println("1. 이벤트 활성화 관리");
			System.out.println("2. 나가기");
			System.out.print("메뉴 선택: ");
			menu = sc.nextInt();
			
			switch(menu){
			case 1:
				sv.Update(sc);
				break;
			case 2:
				check = false;
				break;
			default:
				System.out.println("잘못된 메뉴를 골랐습니다.");
			}
		}
		
	}
}
