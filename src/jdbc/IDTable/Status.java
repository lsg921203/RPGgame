package jdbc.IDTable;

public class Status {
	
	protected int LV;
	protected int Exp;
	protected int HP;
	protected int MP;
	
	
	public Status( int lV, int exp, int hP, int mP) {
		
		LV = lV;
		Exp = exp;
		HP = hP;
		MP = mP;
	}
	
	public int getLV() {
		return LV;
	}
	public void setLV(int lV) {
		LV = lV;
	}
	public int getExp() {
		return Exp;
	}
	public void setExp(int exp) {
		Exp = exp;
	}
	public int getHP() {
		return HP;
	}
	public void setHP(int hP) {
		HP = hP;
	}
	public int getMP() {
		return MP;
	}
	public void setMP(int mP) {
		MP = mP;
	}
	public void printState() {
		System.out.println("****************************");
		System.out.println("나의상태");
		System.out.println("HP : \t" + getHP());
		System.out.println("MP : \t" + getMP());
		System.out.println("****************************\n");
	}
	
	@Override
	public String toString() {
		return "Status [LV=" + LV + ", Exp=" + Exp + ", HP=" + HP + ", MP=" + MP + "]";
	}
	
	
}