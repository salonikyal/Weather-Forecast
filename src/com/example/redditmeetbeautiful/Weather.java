package com.example.redditmeetbeautiful;

public class Weather {
	
	private String date;
	private String weather;
	private double max;
	private double min;
	private String city;
	private double speed;
	private double humidity;
	private String time;
	private double id;
	private String code;
	private String des;
	
	
	public Weather()
	{
		
	}
	
	
	public Weather(String des,String code,double id,String date, String weather, double max, double min,String city,double speed,double humidity,String time) {
		super();
		this.des=des;
		this.code=code;
		this.id=id;
		this.date = date;
		this.time=time;
		this.weather = weather;
		this.max = max;
		this.min = min;
		this.city=city;
		this.humidity=humidity;
		this.speed=speed;
	}
	
	


	public String getDes() {
		return des;
	}


	public void setDes(String des) {
		this.des = des;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public double getId() {
		return id;
	}


	public void setId(double id) {
		this.id = id;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max2) {
		this.max = max2;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}


	public double getHumidity() {
		return humidity;
	}


	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	

}
