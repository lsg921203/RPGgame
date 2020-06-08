package jdbc.EventTable;

import java.util.ArrayList;
import java.util.Scanner;

public interface Service {
	
	void Update(Scanner sc);
	ArrayList<Event> getInfo();
	void printInfo();
	
}
