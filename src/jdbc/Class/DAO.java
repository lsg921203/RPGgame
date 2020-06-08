package jdbc.Class;

import java.util.ArrayList;


public interface DAO {
	void insert(Class m);
	
	Class select(String code);
	
	ArrayList<Class> selectAll();
	
	void update(Class m);
	
	void delete(int code);
}
