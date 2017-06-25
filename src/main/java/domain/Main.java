package domain;

public class Main {
	private float temp;
	private int pressure;
	private int humidity;
	private float temp_min;
	private float temp_max;
	
	public float getTemp(){
		return this.temp;
	}
	
	public void setTemp(float temp){
		this.temp = temp;
	}
	
	public int getPressure(){
		return this.pressure;
	}
	
	public void setPressure(int pressure){
		this.pressure = pressure;
	}
	
	public int getHumidity(){
		return this.humidity;
	}
	
	public void setHumidity(int humidity){
		this.humidity = humidity;
	}
	
	public float getTemp_min(){
		return this.temp_min;
	}
	
	public void setTemp_min(float temp_min){
		this.temp_min = temp_min;
	}
	
	public float getTemp_max(){
		return this.temp_max;
	}
	
	public void setTemp_max(float temp_max){
		this.temp_max = temp_max;
	}
}
