package jdbc.Class;

public class Class {
	private String ClassCode;
	private String ClassName;
	private int InitMaxHP;
	private int IncMaxHP;
	private int InitMaxMP;
	private int IncMaxMP;
	private int InitMaxEXP;
	private int IncMaxEXP;
	public Class(String classCode, String className, int initMaxHP, int incMaxHP, int initMaxMP, int incMaxMP,
			int initMaxEXP, int incMaxEXP) {
		super();
		ClassCode = classCode;
		ClassName = className;
		InitMaxHP = initMaxHP;
		IncMaxHP = incMaxHP;
		InitMaxMP = initMaxMP;
		IncMaxMP = incMaxMP;
		InitMaxEXP = initMaxEXP;
		IncMaxEXP = incMaxEXP;
	}
	public String getClassCode() {
		return ClassCode;
	}
	public void setClassCode(String classCode) {
		ClassCode = classCode;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public int getInitMaxHP() {
		return InitMaxHP;
	}
	public void setInitMaxHP(int initMaxHP) {
		InitMaxHP = initMaxHP;
	}
	public int getIncMaxHP() {
		return IncMaxHP;
	}
	public void setIncMaxHP(int incMaxHP) {
		IncMaxHP = incMaxHP;
	}
	public int getInitMaxMP() {
		return InitMaxMP;
	}
	public void setInitMaxMP(int initMaxMP) {
		InitMaxMP = initMaxMP;
	}
	public int getIncMaxMP() {
		return IncMaxMP;
	}
	public void setIncMaxMP(int incMaxMP) {
		IncMaxMP = incMaxMP;
	}
	public int getInitMaxEXP() {
		return InitMaxEXP;
	}
	public void setInitMaxEXP(int initMaxEXP) {
		InitMaxEXP = initMaxEXP;
	}
	public int getIncMaxEXP() {
		return IncMaxEXP;
	}
	public void setIncMaxEXP(int incMaxEXP) {
		IncMaxEXP = incMaxEXP;
	}
	
}
