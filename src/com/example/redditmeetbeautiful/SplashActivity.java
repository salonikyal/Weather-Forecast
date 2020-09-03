package com.example.redditmeetbeautiful;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {
	
	ProgressBar progressBar1;
	int progressStatus=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		progressBar1=(ProgressBar) findViewById(R.id.progressBar1);
		
		
		final Intent intent = new Intent(this,CheckCityActivity.class);
		Thread splashtimer = new Thread() {
			public void run() {
				int splashtime = 0;
				try {
					while (splashtime < 100) {   //5000
						progressStatus +=1;
						progressBar1.setProgress(progressStatus);
						sleep(100);
						splashtime += 1;   //100

					}
					startActivity(intent);
				}
				catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					finish();
				}

			}
		};
		splashtimer.start();


	}

	}
