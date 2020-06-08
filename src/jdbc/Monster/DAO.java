package jdbc.Monster;

import java.util.ArrayList;

public interface DAO {
	void insert(Monster m);
	
	Monster select(int MonsterCode);
	
	ArrayList<Monster> selectAll();
	
	void update(Monster m);
	
	void delete(int MonsterCode);
}
