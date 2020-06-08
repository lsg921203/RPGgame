package jdbc.IDTable;

public class Inventory {
	protected int Money;
	protected int BluePotion;
	protected int RedPotion;
	protected int Boom;
	public Inventory(int money, int bluePotion, int redPotion, int boom) {
		Money = money;
		BluePotion = bluePotion;
		RedPotion = redPotion;
		Boom = boom;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public int getBluePotion() {
		return BluePotion;
	}
	public void setBluePotion(int bluePotion) {
		BluePotion = bluePotion;
	}
	public int getRedPotion() {
		return RedPotion;
	}
	public void setRedPotion(int redPotion) {
		RedPotion = redPotion;
	}
	public int getBoom() {
		return Boom;
	}
	public void setBoom(int boom) {
		Boom = boom;
	}
	@Override
	public String toString() {
		return "Inventory [Money=" + Money + ", BluePotion=" + BluePotion + ", RedPotion=" + RedPotion + ", Boom="
				+ Boom + "]";
	}
	
	
}