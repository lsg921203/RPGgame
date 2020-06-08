package jdbc.Monster;

import java.util.ArrayList;
import java.util.Scanner;

public interface Service {
	void addMonster (Scanner sc);
	void deleteMonster (Scanner sc);
	void updateMonster(Scanner sc);
	Monster getMonster(int monCode);
	ArrayList<Monster> getAll();
	void printAll();
}
