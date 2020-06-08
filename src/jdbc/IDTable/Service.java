package jdbc.IDTable;


import java.util.Scanner;

public interface Service {
	
	
	Character LogIn(Scanner sc);
	
	void MakeCharacter(Scanner sc);
	
	void DeleteCharacter(Scanner sc);
	
	void printList();
	
	void SaveCharacter(Character character);
	
	Character getCharinfo(String ID); 
	
	public void CheckRank();
}
