package com.example.redditmeetbeautiful;

import java.util.ArrayList;

import com.example.redditmeetbeautiful.Weather;
import com.example.redditmeetbeautiful.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

	Context context;
	ArrayList<Weather> newForecast;

	TextView txtDate;
	TextView txtTime;
	TextView txtWeather;
	TextView txtMax;
	TextView txtMin;
	TextView txtCity;
	String DEGREE = "\u00b0";
	
	
	
	
	

	public CustomAdapter(Context customListViewActivity,
			ArrayList<Weather> newForecast) {

		this.context = customListViewActivity;
		this.newForecast = newForecast;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return newForecast.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return newForecast.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE); // static
																		// method

		convertView = inflater.inflate(R.layout.listitem, null);

		txtDate = (TextView) convertView.findViewById(R.id.txtDate);
		txtTime = (TextView) convertView.findViewById(R.id.txtTime);
		txtWeather = (TextView) convertView.findViewById(R.id.txtWeather);
		txtMax = (TextView) convertView.findViewById(R.id.txtMax);
		txtMin = (TextView) convertView.findViewById(R.id.txtMin);
		

		txtDate.setText(newForecast.get(position).getDate());
		txtTime.setText(newForecast.get(position).getTime());
		
		txtWeather.setText(newForecast.get(position).getWeather());
		txtMax.setText(Double.toString(newForecast.get(position).getMax())+DEGREE+"C");
		txtMin.setText(Double.toString(newForecast.get(position).getMin())+DEGREE+"C");
		

		return convertView;

	}

}
