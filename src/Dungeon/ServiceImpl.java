package Dungeon;

import java.util.ArrayList;
import java.util.Scanner;

import jdbc.EventTable.Event;
import jdbc.IDTable.Inventory;
import jdbc.IDTable.Status;

public class ServiceImpl {
	
	private static ServiceImpl serviceimpl = new ServiceImpl();


	ServiceImpl() {
	}

	public static ServiceImpl getInstance() {
		return serviceimpl;
	}

	public int SelectSkill(Scanner sc, jdbc.IDTable.Character c) { //스킬 선택하고 데미지를 반환한다.
		int demage=0;
		final int basicattack = 5;
		final int bombattack = 10;
		
		boolean select = false;
		
		while (select == false) {
			System.out.print("공격입력 (1 : 기본공격	/ 2. 스킬사용 	/  3. 폭탄던지기 	/  4. 빨간물약먹기  	/ 5. 파란물약먹기) : ");
			int attack = sc.nextInt();
			
			if(attack == 1) {
				double dValue = Math.random() + 0.5;
				demage = (int) ((double)(c.attact()) * dValue);
				select = true;
			}
			
			else if(attack == 2) {
				double dValue = Math.random() + 0.5;
				
				if(c.getStat().getMP() >= 20 ){
					demage = (int) ((double)(c.skill()) * dValue);
					c.setStat(new Status(c.getStat().getLV(), c.getStat().getExp(), c.getStat().getHP(), c.getStat().getMP() - 20));
				}else
				{
					demage = (int) ((double)(c.attact()) * dValue);
				}
				select = true;
			}
			
			else if(attack == 3) {
				
				if(c.getInven().getBoom() > 0) {
					c.setInven(new Inventory( c.getInven().getMoney(), c.getInven().getBluePotion(), c.getInven().getRedPotion(), c.getInven().getBoom() - 1));
					
					double dValue = Math.random() + 0.5;
					demage = (int) ((double)(c.getDamage()) * 1.5 * dValue);
					select = true;
				}
				else {
					System.out.println("폭탄이 없습니다.");
				}
			}
			
			
			else if(attack == 4) {
				
				if(c.getInven().getRedPotion() > 0) {
					c.UseRP();
					System.out.println("빨간포션을 마셔 체력을 회복합니다.");
					select = true;
				}
				else {
					System.out.println("빨간포션이 부족합니다.");
				}
			}else if(attack == 5) {
				/* 파랑포션먹기 */
				if(c.getInven().getBluePotion() > 0) {
					c.UseBP();
					System.out.println("파랑포션을 마셔 마나를 회복합니다.");
					select = true;
				}
				else {
					System.out.println("파랑포션이 부족합니다.");
				}
			}
			
			else {
				System.out.println("다시 입력하세요");
			}
			
		}
		//System.out.println("(테스트용) User demage  : " + demage);
		return demage;
	}
	
	public int MonsterSkill (jdbc.Monster.Monster monster) {
		int demage = 0;
		double dValue = Math.random() + 0.5;
		
		demage = (int)(monster.getMonsterPower() * dValue);
		System.out.println("(테스트용) Monster demage  : " + demage);
		return demage;
	}
	
	public void fight(Scanner sc, jdbc.Monster.Monster monster, jdbc.IDTable.Character c) {
		boolean CharacterDie = false;
		boolean MonsterDie = false;
		jdbc.EventTable.ServiceImpl EVTsi = new jdbc.EventTable.ServiceImpl();
		ArrayList<Event> event;
		event = EVTsi.getInfo();
		
		while(true) {
			/*상태 확인*/
			c.getStat().printState();
			monster.printState();
			
			/*유저 공격 턴*/
			int demage = SelectSkill(sc, c);
			int power_up = 1;
			int exp_up = 1;
			int money_up = 1;
			if(event.get(0).isState() == true){
				power_up = 2;
			}
			if(event.get(1).isState() == true){
				exp_up = 2;
			}
			if(event.get(2).isState() == true){
				money_up = 2;
			}
			monster.setMonsterHP(monster.getMonsterHP() - demage*power_up);
			
			if(monster.getMonsterHP() <= 0) {
				System.out.println("사냥성공!");
				
				
				if (c.getStat().getExp() + monster.getRewardEXP() < c.getMaxExp()) {
					c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp() + monster.getRewardEXP()*exp_up, c.getStat().getHP() + 20, c.getStat().getMP()));
					c.setInven(new Inventory( c.getInven().getMoney() + monster.getRewardMoney()*money_up, c.getInven().getBluePotion(), c.getInven().getRedPotion(), c.getInven().getBoom()));
				}
				else { //랩업한 경우
					System.out.println("레벨업!");
					c.setStat(new Status( c.getStat().getLV() + 1, (c.getStat().getExp() + monster.getRewardEXP()*exp_up) % c.getMaxExp(), c.getStat().getHP() + 20, c.getStat().getMP()));
					c.setInven(new Inventory( c.getInven().getMoney() + monster.getRewardMoney()*money_up, c.getInven().getBluePotion(), c.getInven().getRedPotion(), c.getInven().getBoom()));
					c.updateHP(10000);
					c.updateMP(10000);
				}
				
				
				break;
			}
			
			
			/* 몬스터 공격 턴*/
			int MonsterDemage = MonsterSkill(monster);
			
			c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp(), c.getStat().getHP() - MonsterDemage, c.getStat().getMP()));
			if(c.getStat().getHP() <= 0) {
				System.out.println(c.getCLS() + " 사망...");
				c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp(), 100, 0));
				
				
				break;
			}
			
		}
		
		jdbc.IDTable.DAOImpl di = new jdbc.IDTable.DAOImpl();
		di.update(c);
		
		
		
	}
}
