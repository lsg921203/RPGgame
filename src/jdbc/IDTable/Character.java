package jdbc.IDTable;




public class Character {
	protected String ID;
	protected String PW;
	protected String CLS;//캐릭터 직업
	
	protected Inventory Inven;
	protected Status Stat;
	
	
	public Character() {
		// TODO Auto-generated constructor stub
	}
	public Character(String iD, String pW, String cLS, Inventory inven, Status stat) {
		
		ID = iD;
		PW = pW;
		CLS = cLS;
		Inven = inven;
		Stat = stat;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getCLS() {
		return CLS;
	}
	public void setCLS(String cLS) {
		CLS = cLS;
	}
	public Inventory getInven() {
		return Inven;
	}
	public void setInven(Inventory inven) {
		Inven = inven;
	}
	public Status getStat() {
		return Stat;
	}
	public void setStat(Status stat) {
		Stat = stat;
	}
	
	@Override
	public String toString() {
		return "Character [ID=" + ID + ", CLS=" + CLS + ", Inven=" + Inven + ", Stat=" + Stat + "]";
	}
	public void levelUp(){
		Stat.LV++;
	}
	public void updateMoney(int n){
		Inven.Money += n;
	}
	public void updateRP(int n){
		Inven.RedPotion += n;
	}
	public void updateBP(int n){
		Inven.BluePotion += n;
	}
	public void updateBoom(int n){
		Inven.Boom += n;
	}
	public void updateHP(int n){
		Stat.HP += n;
	}
	public void updateMP(int n){
		Stat.MP += n;
	}
	public void updateEXP(int n){
		Stat.Exp += n;
	}
	
	public int attact()
	{
		return 0;
	}
	public int skill()
	{
		return 0;
	}
	public void UseRP(){
		
	}
	public void UseBP(){
		
	}
	public int UseBoom(){
		return 0;
	}
	public void defense(int d){
		
	}
	
	public int getMaxExp() {
		return 0;
	}


	public int getMaxHp() {
		return 0;
	}


	public int getMaxMp() {
		return 0;
	}
	

	public int getDamage() {
		return 0;
	}
}
