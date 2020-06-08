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
			System.out.println("아이디가 존재하지 않습니다.");
			return null;
		}
		System.out.print("PW : ");
		String PW = sc.next();
		
		if(!character.getPW().equals(PW)){
			System.out.println("비밀번호가 일치하지 않습니다.");
			return null;
		}
		
		System.out.println("접속되었습니다.");
		
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
				System.out.println("이미 아이디가 존재합니다.");
				
			}
			else{
				System.out.println("사용가능한 아이디 입니다.");
				check = false;
			}
		}
		
		
		check = true;
		String PW = "";
		while(check){
			System.out.print("PW : ");
			PW = sc.next();
			System.out.print("PW 확인: ");
			if(!PW.equals(sc.next())){
				System.out.println("패스워드가 일치하지 않습니다. 다시 설정해주세요.\n");
				
			}
			else{
				System.out.println("패스워드가 설정되었습니다.");
				check = false;
			}
		}
		String Class;
		
		check = true;
		
		while(check){
			System.out.println("직업을 선택해 주세요.");
			System.out.println("a. 전사");
			System.out.println("b. 마법사");
			System.out.println("c. 궁수");
			System.out.println("d. 영웅");
			
			System.out.print("직업 선택:");
			
			Class = sc.next();
			
			if(Class.equals("a") ||Class.equals("b") ||Class.equals("c") ||Class.equals("d")){
				dao.insert(new Character(ID,PW,Class, new Inventory(0,0,0,0),new Status(1,0,0,0)));
				System.out.println("캐릭터를 생성하였습니다.");
				check = false;
			}
			else{
				System.out.println("해당직업이 없습니다.");
				
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
			System.out.println("아이디가 존재하지 않습니다.");
			return;
		}
		System.out.print("PW : ");
		String PW = sc.next();
		
		if(!character.getPW().equals(PW)){
			System.out.println("비밀번호가 일치하지 않습니다.");
			return;
		}
		System.out.println("캐릭터를 제거하시겠습니까.(Y/N)");
		
		PW = sc.next();
		
		if(PW.equals("Y")){
			dao.delete(ID);
			
			System.out.println("캐릭터가 제거되었습니다.");
		}
		
		System.out.println("캐릭터가 제거가 취소되었습니다.");
		
		return;
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		System.out.println("-캐릭터 리스트-");
		for(Character m : dao.selectAll()){
			System.out.println(m);
		}
		
		return;
	}

	@Override
	public void SaveCharacter(Character character) {
		// TODO Auto-generated method stub
		dao.update(character);
		System.out.println("저장되었습니다.");
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
