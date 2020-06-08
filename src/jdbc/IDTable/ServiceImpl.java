package jdbc.IDTable;


import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service {

	private DAOImpl dao;
	
	public ServiceImpl(){
		dao = new DAOImpl();
	}
	
	@Override
	public Character LogIn(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("-LogIn-");
		System.out.print("ID : ");
		String ID = sc.next();
		
		Character character = dao.select(ID);
		
		if(character == null){
			System.out.println("���̵� �������� �ʽ��ϴ�.");
			return null;
		}
		System.out.print("PW : ");
		String PW = sc.next();
		
		if(!character.getPW().equals(PW)){
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return null;
		}
		
		System.out.println("���ӵǾ����ϴ�.");
		
		return character;
	}

	@Override
	public void MakeCharacter(Scanner sc) {
		// TODO Auto-generated method stub
		boolean check = true;
		String ID ="";
		while(check){
			
			System.out.println("-Make Character-");
			System.out.print("ID : ");
			ID = sc.next();
			
			Character character = dao.select(ID);
			
			if(character != null){
				System.out.println("�̹� ���̵� �����մϴ�.");
				
			}
			else{
				System.out.println("��밡���� ���̵� �Դϴ�.");
				check = false;
			}
		}
		
		
		check = true;
		String PW = "";
		while(check){
			System.out.print("PW : ");
			PW = sc.next();
			System.out.print("PW Ȯ��: ");
			if(!PW.equals(sc.next())){
				System.out.println("�н����尡 ��ġ���� �ʽ��ϴ�. �ٽ� �������ּ���.\n");
				
			}
			else{
				System.out.println("�н����尡 �����Ǿ����ϴ�.");
				check = false;
			}
		}
		String Class;
		
		check = true;
		
		while(check){
			System.out.println("������ ������ �ּ���.");
			System.out.println("a. ����");
			System.out.println("b. ������");
			System.out.println("c. �ü�");
			System.out.println("d. ����");
			
			System.out.print("���� ����:");
			
			Class = sc.next();
			
			if(Class.equals("a") ||Class.equals("b") ||Class.equals("c") ||Class.equals("d")){
				dao.insert(new Character(ID,PW,Class, new Inventory(0,0,0,0),new Status(1,0,0,0)));
				System.out.println("ĳ���͸� �����Ͽ����ϴ�.");
				check = false;
			}
			else{
				System.out.println("�ش������� �����ϴ�.");
				
			}
		}
		
		//
		
	}

	@Override
	public void DeleteCharacter(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.println("-Delete Character-");
		System.out.print("ID : ");
		String ID = sc.next();
		
		Character character = dao.select(ID);
		
		if(character == null){
			System.out.println("���̵� �������� �ʽ��ϴ�.");
			return;
		}
		System.out.print("PW : ");
		String PW = sc.next();
		
		if(!character.getPW().equals(PW)){
			System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			return;
		}
		System.out.println("ĳ���͸� �����Ͻðڽ��ϱ�.(Y/N)");
		
		PW = sc.next();
		
		if(PW.equals("Y")){
			dao.delete(ID);
			
			System.out.println("ĳ���Ͱ� ���ŵǾ����ϴ�.");
		}
		
		System.out.println("ĳ���Ͱ� ���Ű� ��ҵǾ����ϴ�.");
		
		return;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println("-ĳ���� ����Ʈ-");
		for(Character m : dao.selectAll()){
			System.out.println(m);
		}
		
		return;
	}

	@Override
	public void SaveCharacter(Character character) {
		// TODO Auto-generated method stub
		dao.update(character);
		System.out.println("����Ǿ����ϴ�.");
	}

	@Override
	public Character getCharinfo(String ID) {
		// TODO Auto-generated method stub
		Character character = dao.select(ID);
		Character characterOut = new Character(character.getID(),"",character.getCLS(),character.getInven(),character.getStat());
		return characterOut;
	}
	
	@Override
	public void CheckRank() {
		ArrayList<Character> Clist = new ArrayList<Character>();
		Clist = dao.selectAll();
		
		for(int i = 0; i < Clist.size(); i++) {
			System.out.println("#" + (i+1));
			System.out.println(Clist.get(i));
		}
	}
}
