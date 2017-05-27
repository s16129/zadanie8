package domain;

public class Rate {

	private int id;
	private int value = 0;
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public void setValue(int value){
		this.value = value;
	}

}
