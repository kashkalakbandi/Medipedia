package com.example.medipedia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;

public class FlashScreen extends Activity {

	private boolean backpress;
	private static final int SPLASH_DUR = 5000;
	private Handler myhandler;
	public static SQLiteDatabase db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flash_screen);

		db = openOrCreateDatabase("medipedia", Context.MODE_PRIVATE, null);
		
		db.execSQL("create table if not exists Medicines_log(medname varchar,type varchar,manufacture varchar,content varchar,prescribed varchar,dosec varchar,dosea varchar,market varchar);");
		db.execSQL("create table if not exists Schedules_log(pername varchar,prob varchar,course varchar,age varchar);");
		//db.execSQL("create table if not exists Sch_details_log(pername varchar , medicinename varchar,typemed varchar,qty varchar,timing varchar);");

		
		
		myhandler = new Handler();
		myhandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				finish();

				if (!backpress) {

					Intent i = new Intent(FlashScreen.this,
							ViewFlipperMainActivity.class);
					FlashScreen.this.startActivity(i);
				}

			}
		}, SPLASH_DUR);

	}

	public void onBackPressed() {

		backpress = true;
		super.onBackPressed();

	}

}
