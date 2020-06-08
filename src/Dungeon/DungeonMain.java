package Dungeon;

import Dungeon.ServiceImpl;
import Shop.ShopMain;

import java.util.ArrayList;
import java.util.Scanner;

import User.UserMainLobby;
import jdbc.IDTable.Character;
import jdbc.Monster.Monster;

public class DungeonMain {
	
	ArrayList<Monster> MonsterList; 
	private jdbc.IDTable.Character character;
	private static DungeonMain dungeonmain = new DungeonMain();
	private jdbc.Monster.ServiceImpl ms = new jdbc.Monster.ServiceImpl();

	private DungeonMain() {
	}

	public static DungeonMain getInstance() {
		return dungeonmain;
	}
	
	public void run(Scanner sc , jdbc.IDTable.Character c) {
		
		int UserSelect;
		boolean Select = false;
		
		// MonsterList = selectAll(); //������ ���̽����� ��� ���͸� ��ȯ�ϴ� �Լ��� ���ؼ� �޾ƿ´�.
		
		/*�Ʒ� �ڵ�� for���� ���� ��������*/
		
		
		
		
		
		
		
		while(Select == false) {
			
			MonsterList = ms.getAll();
			
			System.out.println("���� ���͸� �������ּ���."); 
			for(int i =0; i < MonsterList.size(); i++) {
				System.out.println(MonsterList.get(i).getMonsterNumber() + ". " + MonsterList.get(i).getMonsterName() + " (" +MonsterList.get(i).getRecomLV()+ " ����)");
			}
			//System.out.println("1. �䳢 (1~10LV����)"); // MonsterNumber - MonsterName - recommendLV
			System.out.println((MonsterList.size() + 1)  +". ������");
			
			System.out.print("�Է� : ");
			UserSelect = sc.nextInt();
			
			if(1 <= UserSelect && (MonsterList.size() + 1) >= UserSelect) {
				
				
				if((MonsterList.size() + 1) == UserSelect) {
					//UserMainLobby u = UserMainLobby.getInstance();
					//u.run(sc, c);
					Select = true;
				}
				
				else { //�ο�� ���
					ServiceImpl si = new ServiceImpl().getInstance();
					si.fight(sc, MonsterList.get(UserSelect - 1) ,c);
				}
			}else System.out.println("�߸��� �����Դϴ�.");
		}
	}
}
