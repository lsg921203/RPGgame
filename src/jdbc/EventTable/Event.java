package jdbc.EventTable;

public class Event {
	protected String name;
	protected boolean state;
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Event(String name, boolean state) {
		super();
		this.name = name;
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	@Override
	public String toString() {
		String onOff="on";
		if(!state){
			onOff="off";
		}
		return " [" + name + " enent state : " + onOff + "]";
	}
	
	public void toggle(){
		state = !state;
		if(state){
			System.out.println(name+" �̺�Ʈ�� Ȱ��ȭ �Ǿ����ϴ�.");
		}else{
			System.out.println(name+" �̺�Ʈ�� ��Ȱ��ȭ �Ǿ����ϴ�.");
		}
	}
	
	
}
