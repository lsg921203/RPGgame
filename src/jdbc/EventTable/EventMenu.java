package jdbc.EventTable;

import java.util.Scanner;

public class EventMenu {
	Service sv = new ServiceImpl(); 
	
	public void run(Scanner sc){
		boolean check = true;
		int menu;
		while(check){
			System.out.println("");
			System.out.println("-�̺�Ʈ ����-");
			System.out.println("1. �̺�Ʈ Ȱ��ȭ ����");
			System.out.println("2. ������");
			System.out.print("�޴� ����: ");
			menu = sc.nextInt();
			
			switch(menu){
			case 1:
				sv.Update(sc);
				break;
			case 2:
				check = false;
				break;
			default:
				System.out.println("�߸��� �޴��� ������ϴ�.");
			}
		}
		
	}
}
