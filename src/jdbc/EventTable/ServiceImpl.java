package jdbc.EventTable;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceImpl implements Service {
	DAO dao = new DAOImpl();
	


	@Override
	public void Update(Scanner sc) {
		// TODO Auto-generated method stub
		printInfo();
		
		ArrayList<Event> list;
		list = dao.selectAll();
		while(true){
			System.out.print("활성/비활성 할 이벤트의 번호를 입력하세요(1~3): ");
			int choiceEvent = sc.nextInt();
			if (choiceEvent>=1 && choiceEvent<=3){
				list.get(choiceEvent-1).toggle();
				dao.update(list.get(choiceEvent-1));
				break;
			}
			else{
				System.out.println("1~3 사이에서 선택하세요.");
			}
		}
		
	}

	@Override
	public ArrayList<Event> getInfo() {
		// TODO Auto-generated method stub
		ArrayList<Event> list;
		list = dao.selectAll();
		
		return list;
		
	}

	@Override
	public void printInfo() {
		// TODO Auto-generated method stub
		ArrayList<Event> list;
		list = dao.selectAll();
		System.out.println("---------------------");
		for(int i = 0 ; i < list.size(); i++ ){
			System.out.println((i+1)+". "+list.get(i));
		}
		
		System.out.println("---------------------");
	}

}
