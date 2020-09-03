package com.example.redditmeetbeautiful;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class CheckCityActivity extends Activity {

	private static final int progress = 0 * 1;

	// private ProgressBar mProgress;
	// int mprogressStatus=0;
	// private Handler mHandler = new Handler();

	// private static String url;
	Button btnSubmit;
	EditText edtCity;

	// private static final String TAG_COD = "cod";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_check_city);

		/*
		  mProgress=(ProgressBar) findViewById(R.id.progressBarSmall);
		  mProgress.setVisibility(View.GONE);
		 

		/*
		  new Thread(new Runnable() {
		  
		  @Override public void run() { // TODO Auto-generated method stub
		  
		  while(mprogressStatus<100) { mprogressStatus= doWork();
		  
		  mHandler.post(new Runnable() {
		  
		  @Override public void run() { // TODO Auto-generated method stub
		  
		  mProgress.setProgress(mprogressStatus);
		  
		  } }); }
		  
		  }
		  
		  
		  }).start();
		 */

		// url =
		// "http://api.openweathermap.org/data/2.5/forecast?q=kolkata&mode=json";

		// TODO Auto-generated method stub
		// JSONParser jParser = new JSONParser();

		// getting JSON string from URL
		// JSONObject json = jParser.getJSONFromUrl(url);

		/*
		  try { String cod= json.getString(TAG_COD); System.out.println(cod); }
		  catch (JSONException e) { // TODO Auto-generated catch block
		  e.printStackTrace(); }
		 */

		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		edtCity = (EditText) findViewById(R.id.edtCity);

		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				/*
				 * Intent intent = getIntent(); Bundle val = intent.getExtras();
				 * String codes=val.getString("code");
				 * if(codes.equalsIgnoreCase("404")) {
				 * Toast.makeText(CheckCityActivity.this,
				 * "Please enter a valid city name", Toast.LENGTH_SHORT).show();
				 * }
				 */

				// mProgress.setVisibility(View.VISIBLE);

				final Intent i = new Intent(CheckCityActivity.this,
						CustomListViewActivity.class);
				Bundle value = new Bundle();
				value.putString("citi", edtCity.getText().toString());
				i.putExtras(value); // intent is merged with bundle
				startActivity(i);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.check_city, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
