package com.example.redditmeetbeautiful;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView txtDate;
	TextView txtWeather;
	TextView txtDes;
	TextView txtTim;
	TextView txtMax;
	TextView txtMin;
	TextView txtMinS;
	TextView txtCity;
	TextView txtspeed;
	TextView txthumid;
	ImageView imgWthr;
	
	final String DEGREE = "\u00b0";
	
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtDate = (TextView) findViewById(R.id.txtDate);
		txtWeather = (TextView) findViewById(R.id.txtWeather);
		txtDes = (TextView) findViewById(R.id.txtDes);
		txtTim = (TextView) findViewById(R.id.txtTim);
		txtMax = (TextView) findViewById(R.id.txtMax);
		txtMin = (TextView) findViewById(R.id.txtMin);
		txtMinS = (TextView) findViewById(R.id.txtMinS);
		txtCity = (TextView) findViewById(R.id.txtCity);
		txtspeed = (TextView) findViewById(R.id.txtspeed);
		txthumid = (TextView) findViewById(R.id.txthumid);
		imgWthr=(ImageView) findViewById(R.id.imgWthr);
		//background=(LinearLayout)findViewById(R.id.linback);
		
		 LinearLayout ll = (LinearLayout) findViewById(R.id.linBack);
		 ll.setBackgroundResource(R.drawable.sky);
		
		
		Intent intent = getIntent();
		Bundle val = intent.getExtras();

		Double idd=val.getDouble("id");
		
		if((idd>=200)&&(idd<=232))
		{
			imgWthr.setImageResource(R.drawable.thunder);
			
		}
		
		else if((idd>=300&&idd<=321)||(idd>=520&&idd<=522))
		{
			imgWthr.setImageResource(R.drawable.drizzle);
		}
		
		else if(idd>=500&&idd<=504)
		{
			imgWthr.setImageResource(R.drawable.rain);
		}
		
		else if(idd==511)
		{
			imgWthr.setImageResource(R.drawable.snowr);
		}
		
		else if((idd>=600&&idd<=602)||(idd==611)||(idd==621))
		{
			imgWthr.setImageResource(R.drawable.rain);
		}
		
		else if(idd==800)
		{
			imgWthr.setImageResource(R.drawable.clear_day);
		}
		
		else if(idd==801)
		{
			imgWthr.setImageResource(R.drawable.fewclouds);
		}
		
		else if(idd==802)
		{
			imgWthr.setImageResource(R.drawable.clouds);
		}
		
		else if(idd==803||idd==804)
		{
			imgWthr.setImageResource(R.drawable.dark);
		}
		
		else 
		{
			imgWthr.setImageResource(R.drawable.fog);
		}
		
		
		
		
		
		if (val.getString("date") != null)
		{

			txtDate.setText(val.getString("date"));
		
		}
		if (val.getString("weather") != null) 
		{
			txtWeather.setText(val.getString("weather"));
		}
		
		if (val.getDouble("max") != 0) 
		{
			txtMax.setText(Double.toString(val.getDouble("max"))+DEGREE+"C");
		}
		
		if (val.getDouble("min") != 0) 
		{
			txtMin.setText(Double.toString(val.getDouble("min"))+DEGREE+"C");
		}
		
		if (val.getDouble("min") != 0) 
		{
			txtMinS.setText(Double.toString(val.getDouble("min"))+DEGREE+"C");
		}
		
		if (val.getString("city") != null) 
		{
			txtCity.setText(val.getString("city"));
		}
	
		txtspeed.setText(Double.toString(val.getDouble("speed"))+" mph N");
		txthumid.setText(Double.toString(val.getDouble("humid"))+"%");
		txtTim.setText(val.getString("time"));
		txtDes.setText(val.getString("des"));
		
		
		
	}

	
}
