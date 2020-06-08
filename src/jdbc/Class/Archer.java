package jdbc.Class;

import jdbc.IDTable.Character;

public class Archer extends Character {
	private int MaxExp;
	private int MaxHp;
	private int MaxMp;
	private int damage;
	
	public Archer(Character ch, Class cl){
		this.CLS = cl.getClassName();
		this.ID = ch.getID();
		this.PW = ch.getPW();
		this.Inven = ch.getInven();
		this.Stat =ch.getStat();
		
		MaxExp = cl.getInitMaxEXP() + Stat.getLV() *cl.getIncMaxEXP();
		MaxHp = cl.getInitMaxHP() + Stat.getLV() *cl.getIncMaxHP();
		MaxMp = cl.getInitMaxMP() + Stat.getLV() *cl.getIncMaxMP();
		damage = 9 + (Stat.getLV() * 3)/2 ;
		
	}
	
	@Override
	public void updateHP(int n) {
		// TODO Auto-generated method stub
		super.updateHP(n);
		if(MaxHp< Stat.getHP()){
			Stat.setHP(MaxHp);
		}
	}

	@Override
	public void updateMP(int n) {
		// TODO Auto-generated method stub
		super.updateMP(n);
		if(MaxMp< Stat.getMP()){
			Stat.setMP(MaxMp);
		}
	}

	@Override
	public int attact()
	{
		return damage;
	}
	@Override
	public int skill()
	{
		return damage*2;
	}
	@Override
	public void UseRP(){
		if(Inven.getRedPotion() > 0){
			updateRP(-1);
			updateHP(Stat.getHP() / 5);
			if(Stat.getHP()>MaxHp){
				Stat.setHP(MaxHp);
			}
		}
	}
	@Override
	public void UseBP(){
		if(Inven.getBluePotion() > 0 ){
			updateBP(-1);
			updateMP(Stat.getMP() / 5);
			if(Stat.getMP()>MaxMp){
				Stat.setMP(MaxMp);
			}
		}
	}
	@Override
	public int UseBoom(){
		if(Inven.getBoom() > 0){
			return damage*3/2;
		}
		return 0;
	}
	@Override
	public void defense(int d){
		updateHP(-d);
	}
	@Override
	public int getMaxExp() {
		return MaxExp;
	}

	@Override
	public int getMaxHp() {
		return MaxHp;
	}

	@Override
	public int getMaxMp() {
		return MaxMp;
	}
	
	@Override
	public int getDamage() {
		return damage;
	}
}
