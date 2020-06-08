package jdbc.IDTable;

import java.util.ArrayList;



public interface DAO {
	void insert(Character m);
	
	Character select(String ID);
	
	ArrayList<Character> selectAll();
	
	void update(Character m);
	
	void delete(String ID);
}
