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
		
		// MonsterList = selectAll(); //데이터 베이스에서 모든 몬스터를 반환하는 함수를 통해서 받아온다.
		
		/*아래 코드는 for문을 통해 구현예정*/
		
		
		
		
		
		
		
		while(Select == false) {
			
			MonsterList = ms.getAll();
			
			System.out.println("잡을 몬스터를 선택해주세요."); 
			for(int i =0; i < MonsterList.size(); i++) {
				System.out.println(MonsterList.get(i).getMonsterNumber() + ". " + MonsterList.get(i).getMonsterName() + " (" +MonsterList.get(i).getRecomLV()+ " 권장)");
			}
			//System.out.println("1. 토끼 (1~10LV권장)"); // MonsterNumber - MonsterName - recommendLV
			System.out.println((MonsterList.size() + 1)  +". 나가기");
			
			System.out.print("입력 : ");
			UserSelect = sc.nextInt();
			
			if(1 <= UserSelect && (MonsterList.size() + 1) >= UserSelect) {
				
				
				if((MonsterList.size() + 1) == UserSelect) {
					//UserMainLobby u = UserMainLobby.getInstance();
					//u.run(sc, c);
					Select = true;
				}
				
				else { //싸우는 경우
					ServiceImpl si = new ServiceImpl().getInstance();
					si.fight(sc, MonsterList.get(UserSelect - 1) ,c);
				}
			}else System.out.println("잘못된 선택입니다.");
		}
	}
}
