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

	public int SelectSkill(Scanner sc, jdbc.IDTable.Character c) { //��ų �����ϰ� �������� ��ȯ�Ѵ�.
		int demage=0;
		final int basicattack = 5;
		final int bombattack = 10;
		
		boolean select = false;
		
		while (select == false) {
			System.out.print("�����Է� (1 : �⺻����	/ 2. ��ų��� 	/  3. ��ź������ 	/  4. ��������Ա�  	/ 5. �Ķ�����Ա�) : ");
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
					System.out.println("��ź�� �����ϴ�.");
				}
			}
			
			
			else if(attack == 4) {
				
				if(c.getInven().getRedPotion() > 0) {
					c.UseRP();
					System.out.println("���������� ���� ü���� ȸ���մϴ�.");
					select = true;
				}
				else {
					System.out.println("���������� �����մϴ�.");
				}
			}else if(attack == 5) {
				/* �Ķ����ǸԱ� */
				if(c.getInven().getBluePotion() > 0) {
					c.UseBP();
					System.out.println("�Ķ������� ���� ������ ȸ���մϴ�.");
					select = true;
				}
				else {
					System.out.println("�Ķ������� �����մϴ�.");
				}
			}
			
			else {
				System.out.println("�ٽ� �Է��ϼ���");
			}
			
		}
		//System.out.println("(�׽�Ʈ��) User demage  : " + demage);
		return demage;
	}
	
	public int MonsterSkill (jdbc.Monster.Monster monster) {
		int demage = 0;
		double dValue = Math.random() + 0.5;
		
		demage = (int)(monster.getMonsterPower() * dValue);
		System.out.println("(�׽�Ʈ��) Monster demage  : " + demage);
		return demage;
	}
	
	public void fight(Scanner sc, jdbc.Monster.Monster monster, jdbc.IDTable.Character c) {
		boolean CharacterDie = false;
		boolean MonsterDie = false;
		jdbc.EventTable.ServiceImpl EVTsi = new jdbc.EventTable.ServiceImpl();
		ArrayList<Event> event;
		event = EVTsi.getInfo();
		
		while(true) {
			/*���� Ȯ��*/
			c.getStat().printState();
			monster.printState();
			
			/*���� ���� ��*/
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
				System.out.println("��ɼ���!");
				
				
				if (c.getStat().getExp() + monster.getRewardEXP() < c.getMaxExp()) {
					c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp() + monster.getRewardEXP()*exp_up, c.getStat().getHP() + 20, c.getStat().getMP()));
					c.setInven(new Inventory( c.getInven().getMoney() + monster.getRewardMoney()*money_up, c.getInven().getBluePotion(), c.getInven().getRedPotion(), c.getInven().getBoom()));
				}
				else { //������ ���
					System.out.println("������!");
					c.setStat(new Status( c.getStat().getLV() + 1, (c.getStat().getExp() + monster.getRewardEXP()*exp_up) % c.getMaxExp(), c.getStat().getHP() + 20, c.getStat().getMP()));
					c.setInven(new Inventory( c.getInven().getMoney() + monster.getRewardMoney()*money_up, c.getInven().getBluePotion(), c.getInven().getRedPotion(), c.getInven().getBoom()));
					c.updateHP(10000);
					c.updateMP(10000);
				}
				
				
				break;
			}
			
			
			/* ���� ���� ��*/
			int MonsterDemage = MonsterSkill(monster);
			
			c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp(), c.getStat().getHP() - MonsterDemage, c.getStat().getMP()));
			if(c.getStat().getHP() <= 0) {
				System.out.println(c.getCLS() + " ���...");
				c.setStat(new Status( c.getStat().getLV(), c.getStat().getExp(), 100, 0));
				
				
				break;
			}
			
		}
		
		jdbc.IDTable.DAOImpl di = new jdbc.IDTable.DAOImpl();
		di.update(c);
		
		
		
	}
}
