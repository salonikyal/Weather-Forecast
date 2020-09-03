package com.example.redditmeetbeautiful;

import java.text.DecimalFormat;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomListViewActivity extends Activity {
	ListView lstCustomView;
	TextView txtCity;
	ArrayList<Weather> newForecast;

	final String DEGREE = "\u00b0";

	private static String url;

	private static final String TAG_COD = "cod";
	private static final String TAG_LIST = "list";
	private static final String TAG_MAIN = "main";
	private static final String TAG_TEMP = "temp";
	private static final String TAG_MIN = "temp_min";
	private static final String TAG_MAX = "temp_max";
	private static final String TAG_HUMIDITY = "humidity";
	private static final String TAG_WEATHER = "weather";
	private static final String TAG_MAINWEATHER = "main";
	private static final String TAG_DESWEATHER="description";
	private static final String TAG_IdWEATHER = "id";
	private static final String TAG_WIND = "wind";
	private static final String TAG_SPEED = "speed";
	private static final String TAG_CITY = "city";
	private static final String TAG_NAME = "name";
	private static final String TAG_DATE = "dt_txt";
	// private static String cod="";

	JSONArray list = null;
	JSONObject city = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_list_view);

		newForecast = new ArrayList<Weather>();

		Intent intent = getIntent();
		final Bundle val = intent.getExtras();
		String chkCity = val.getString("citi");

		url = "http://api.openweathermap.org/data/2.5/forecast?q=" + chkCity
				+ "&mode=json";

		txtCity = (TextView) findViewById(R.id.txtCity);
		lstCustomView = (ListView) findViewById(R.id.lstCustomView);

		/*
		  Weather weather = new Weather("01-01-2015", "Rainy Day", "34" +
		  DEGREE, "25" + DEGREE);
		  
		  newForecast = new ArrayList<Weather>(); newForecast.add(weather);
		  newForecast.add(new Weather("02-01-2015", "Rainy Day", "35" + DEGREE,
		  "24" + DEGREE)); newForecast.add(new Weather("03-01-2015",
		  "Sunny Day", "38" + DEGREE, "27" + DEGREE)); newForecast.add(new
		  Weather("04-01-2015", "Bright Day", "38" + DEGREE, "29" + DEGREE));
		  newForecast.add(new Weather("05-01-2015", "Sunny Day", "34" + DEGREE,
		  "27" + DEGREE)); newForecast.add(new Weather("06-01-2015",
		  "Rainy Day", "34" + DEGREE, "25" + DEGREE)); newForecast.add(new
		  Weather("07-01-2015", "Humidity", "37" + DEGREE, "29" + DEGREE));
		  newForecast.add(new Weather("08-01-2015", "Rainy Day", "32" + DEGREE,
		  "25" + DEGREE)); newForecast.add(new Weather("09-01-2015",
		  "Sunny Day", "37" + DEGREE, "26" + DEGREE)); newForecast.add(new
		  Weather("10-01-2015", "Rainy Day", "34" + DEGREE, "25" + DEGREE));
		  newForecast.add(new Weather("11-01-2015", "Cloudy Day", "31" +
		  DEGREE, "25" + DEGREE)); newForecast.add(new Weather("12-01-2015",
		  "Rainy Day", "34" + DEGREE, "25" + DEGREE)); newForecast.add(new
		  Weather("13-01-2015", "Sunny Day", "37" + DEGREE, "28" + DEGREE));
		  newForecast.add(new Weather("14-01-2015", "Rainy Day", "34" + DEGREE,
		  "25" + DEGREE)); newForecast.add(new Weather("15-01-2015",
		  "Sunny Day", "40" + DEGREE, "31" + DEGREE));
		 */

		AllTask allTask = new AllTask();
		allTask.execute(url);

		lstCustomView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub

				Intent intent = new Intent(CustomListViewActivity.this,
						MainActivity.class);

				Bundle value = new Bundle();
				value.putString("date", newForecast.get(position).getDate());
				value.putString("weather", newForecast.get(position)
						.getWeather());
				value.putDouble("max", newForecast.get(position).getMax());
				value.putDouble("min", newForecast.get(position).getMin());
				value.putString("city", newForecast.get(position).getCity());
				value.putDouble("speed", newForecast.get(position).getSpeed());
				value.putDouble("humid", newForecast.get(position)
						.getHumidity());
				value.putString("time", newForecast.get(position).getTime());
				value.putDouble("id", newForecast.get(position).getId());
				value.putString("des",newForecast.get(position).getDes() );
				intent.putExtras(value); // intent is merged with bundle
				startActivity(intent);

			}
		});

	}

	class AllTask extends AsyncTask<String, Void, String> {

		String code;

		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub

			super.onPreExecute();
		}

		@Override
		protected String doInBackground(String... params) {

			// TODO Auto-generated method stub
			JSONParser jParser = new JSONParser();

			// getting JSON string from URL
			JSONObject json = jParser.getJSONFromUrl(url);

			try {
				// Getting Array of Contacts
				code = json.getString(TAG_COD);

				city = json.getJSONObject(TAG_CITY);

				String cty = city.getString(TAG_NAME);

				/*
				   System.out.println(code);
				    if(code.equalsIgnoreCase("404"))
				    {
				      Intent intent = new
				      Intent(CustomListViewActivity.this, CheckCityActivity.class);
				      startActivity(intent);
				    }
				 */

				list = json.getJSONArray(TAG_LIST);
				for (int i = 0; i < list.length(); i++) {
					JSONObject c = list.getJSONObject(i);

					String date = c.getString(TAG_DATE);

					JSONObject weathr = c.getJSONObject(TAG_MAIN);
					double temp = weathr.getDouble(TAG_TEMP);
					double min = weathr.getDouble(TAG_MIN);
					double max = weathr.getDouble(TAG_MAX);
					double humidity = weathr.getDouble(TAG_HUMIDITY);

					JSONArray weather = c.getJSONArray(TAG_WEATHER);

					JSONObject a = weather.getJSONObject(0);
					String main = a.getString(TAG_MAINWEATHER);
					double id = a.getDouble(TAG_IdWEATHER);
					String des=a.getString(TAG_DESWEATHER);
					String cap = des.substring(0, 1).toUpperCase() + des.substring(1);
					// System.out.println(id);
					JSONObject wind = c.getJSONObject(TAG_WIND);
					Double speed = wind.getDouble(TAG_SPEED);

					String[] parts = date.split(" ");

					String[] part = parts[1].split(":");
					System.out.println(part[0]);
					System.out.println(part[1]);

					Weather wthr = new Weather();
					wthr.setDate(parts[0]);
					if ((Integer.parseInt(part[0])) == 12) {
						wthr.setTime("12:00 NOON");
					} else if ((Integer.parseInt(part[0])) == 00) {
						wthr.setTime("00:00 AM");
					} else {
						wthr.setTime((Integer.parseInt(part[0]))
								% 12
								+ ":"
								+ part[1]
								+ " "
								+ (((Integer.parseInt(part[0])) >= 12) ? "PM"
										: "AM"));
					}
					wthr.setMax(Double.parseDouble(new DecimalFormat("##.#")
							.format(max - 273)));
					wthr.setMin(Double.parseDouble(new DecimalFormat("##.#")
							.format(min - 273)));
					wthr.setWeather(main);
					//wthr.setCode(code);
					wthr.setDes(cap);
					wthr.setCity(cty);
					wthr.setHumidity(humidity);
					wthr.setSpeed(speed);
					wthr.setId(id);

					newForecast.add(wthr);

				}

			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;

		}

		@Override
		protected void onPostExecute(String result) {

			//txtCity.setText(newForecast.get(0).getCity());

			// System.out.println(code);

			if (code.equalsIgnoreCase("404")) {
				Intent intent = new Intent(CustomListViewActivity.this,
						CheckCityActivity.class);
				startActivity(intent);
				Toast.makeText(CustomListViewActivity.this,
						"Please enter a valid city", Toast.LENGTH_LONG).show();
			} else {

				/*Intent intent = getIntent();
				Bundle val = intent.getExtras();
				txtCity.setText(val.getString("citi"));
*/
				txtCity.setText(newForecast.get(0).getCity());

			}
			/*
			  String c= newForecast.get(0).getCode(); System.out.println(c);
			 */

			/*
			  if(cod=="404") { Toast.makeText(CustomListViewActivity.this,
			  "Please enter a valid city", Toast.LENGTH_LONG).show(); Intent
			  intent = new Intent(CustomListViewActivity.this,
			  CheckCityActivity.class); startActivity(intent); }
			 */

			/*
			  Intent intents = new Intent(CustomListViewActivity.this,
			  CheckCityActivity.class);
			  
			  Bundle values = new Bundle();
			  
			  values.putString("code", code); intents.putExtras(values); //
			  intent is merged with bundle startActivity(intents);
			 */

			CustomAdapter customAdapter = new CustomAdapter(
					CustomListViewActivity.this, newForecast);

			lstCustomView.setAdapter(customAdapter);

		}

	}
}
