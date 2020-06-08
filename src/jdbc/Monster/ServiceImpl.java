package jdbc.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service {
	DAOImpl dao;
	
	public ServiceImpl(){
		dao = new DAOImpl();
	}
	
	@Override
	public void addMonster(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("\n-Add Monster-");
		System.out.print("���� ��ȣ:");
		int m_num = sc.nextInt();
		System.out.print("���� �̸�:");
		String m_name = sc.next();
		System.out.print("��õ����:");
		String m_rec = sc.next();
		System.out.print("���� ü��:");
		int m_hp = sc.nextInt();
		System.out.print("���� ���ݷ�:");
		int m_power = sc.nextInt();
		System.out.print("���� ������:");
		int m_money = sc.nextInt();
		System.out.print("���� ����ġ:");
		int m_exp = sc.nextInt();
		
		Monster m = new Monster(m_num, m_name,m_rec,m_hp,m_power,m_exp,m_money);
		dao.insert(m);
	}

	@Override
	public void deleteMonster(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("\n-Remove Monster-");
		System.out.print("���� ��ȣ:");
		int m_num = sc.nextInt();
		
		dao.delete(m_num);
	}

	@Override
	public void updateMonster(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("\n-Add Monster-");
		System.out.print("���� ��ȣ:");
		int m_num = sc.nextInt();
		System.out.print("���� �̸�:");
		String m_name = sc.next();
		System.out.print("��õ����:");
		String m_rec = sc.next();
		System.out.print("���� ü��:");
		int m_hp = sc.nextInt();
		System.out.print("���� ���ݷ�:");
		int m_power = sc.nextInt();
		System.out.print("���� ������:");
		int m_money = sc.nextInt();
		System.out.print("���� ����ġ:");
		int m_exp = sc.nextInt();
		
		Monster m = new Monster(m_num, m_name,m_rec,m_hp,m_power,m_exp,m_money);
		dao.update(m);
	}

	@Override
	public Monster getMonster(int monCode) {
		// TODO Auto-generated method stub
		System.out.println("\n-select Monster-");
		
		return dao.select(monCode);
	}

	@Override
	public ArrayList<Monster> getAll() {
		// TODO Auto-generated method stub
		
		return dao.selectAll();
	}

	@Override
	public void printAll() {
		// TODO Auto-generated method stub
		System.out.println("\n-Monster list-");
		ArrayList<Monster> list;
		list = dao.selectAll();
		for(Monster m : list){
			System.out.println(m);
		}
	}

}
