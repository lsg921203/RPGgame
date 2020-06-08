package jdbc.Monster;

public class Monster {
	int MonsterNumber;
	String MonsterName;
	String recomLV;
	int MonsterHP;
	int MonsterPower;
	
	int rewardEXP;
	int rewardMoney;
	
	
	public Monster() {
		// TODO Auto-generated constructor stub
	}
	public Monster(int monsterNumber, String monsterName, String recomLV, int mosterHP, int monsterPower, int rewardEXP,
			int rewardMoney) {
		
		MonsterNumber = monsterNumber;
		MonsterName = monsterName;
		this.recomLV = recomLV;
		MonsterHP = mosterHP;
		MonsterPower = monsterPower;
		this.rewardEXP = rewardEXP;
		this.rewardMoney = rewardMoney;
	}
	public int getMonsterNumber() {
		return MonsterNumber;
	}
	public void setMonsterNumber(int monsterNumber) {
		MonsterNumber = monsterNumber;
	}
	public String getMonsterName() {
		return MonsterName;
	}
	public void setMonsterName(String monsterName) {
		MonsterName = monsterName;
	}
	public String getRecomLV() {
		return recomLV;
	}
	public void setRecomLV(String recomLV) {
		this.recomLV = recomLV;
	}
	public int getMonsterHP() {
		return MonsterHP;
	}
	public void setMonsterHP(int mosterHP) {
		MonsterHP = mosterHP;
	}
	public int getMonsterPower() {
		return MonsterPower;
	}
	public void setMonsterPower(int monsterPower) {
		MonsterPower = monsterPower;
	}
	public int getRewardEXP() {
		return rewardEXP;
	}
	public void setRewardEXP(int rewardEXP) {
		this.rewardEXP = rewardEXP;
	}
	public int getRewardMoney() {
		return rewardMoney;
	}
	public void setRewardMoney(int rewardMoney) {
		this.rewardMoney = rewardMoney;
	}
	public void printState() {
		System.out.println("****************************");
		System.out.println(this.MonsterName + "ป๓ลย");
		System.out.println("HP : \t" + MonsterHP);
		System.out.println("****************************");
	}
	
	@Override
	public String toString() {
		return "Monster [" + MonsterNumber + ". MonsterName=" + MonsterName + ", recomLV=" + recomLV
				+ ", MosterHP=" + MonsterHP + ", MonsterPower=" + MonsterPower + ", rewardEXP=" + rewardEXP
				+ ", rewardMoney=" + rewardMoney + "]";
	}
	
	
	
}
