package jdbc.EventTable;

import java.util.ArrayList;

public interface DAO {
	
	void insert(Event e);
	
	Event select(String name);
	
	ArrayList<Event> selectAll();
	
	void update(Event e);
	
	void delete(String name);
}
