package com.example.medipedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Search_pageplusBar2 extends Activity {

	TextView tv, tv2;
	ImageView iv;
	ImageButton b1, b2, b4;
	String s3,s1,s2,s4;
	SQLiteDatabase db;
	Cursor c ;
	EditText et, er;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page_bar2);
		db = openOrCreateDatabase("medipedia", Context.MODE_PRIVATE, null);
		et = (EditText) findViewById(R.id.editText2);
		er = (EditText) findViewById(R.id.editText1);

		b1 = (ImageButton) findViewById(R.id.imageButton1);

		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent it1 = new Intent(Search_pageplusBar2.this,
						Search_mat2.class);
				startActivity(it1);
			}
		});

		b2 = (ImageButton) findViewById(R.id.imageButton2);
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		
		tv = (TextView) findViewById(R.id.header_change);
		tv2 = (TextView) findViewById(R.id.subheading);
		iv = (ImageView) findViewById(R.id.img_chg);
		Bundle b = getIntent().getExtras();

	 s1 = b.getString("heading");
	 s2 = b.getString("pass_heading");
		s3 = b.getString("title");
		s4 = b.getString("srchcntxt");

		
		tv.setText(s1);
		tv2.setText(s3);

		b4 = (ImageButton) findViewById(R.id.imageButton4);
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub

				String text = et.getText().toString().trim();
				if (text.equalsIgnoreCase("")) {

					Toast.makeText(
							getApplicationContext(),
							"Please enter the medicine name in the search here field to search",
							Toast.LENGTH_SHORT).show();

				}

				else {
					
					System.out.println(tv2.getText().toString()+"===========================");
					
					if(tv2.getText().toString().equalsIgnoreCase("Market Stats"))
					{
						 c = db.rawQuery(
									"select * from Medicines_log where medname='"
											+ et.getText() + "'", null);
						 Toast.makeText(getApplicationContext(), c.getString(7),
									Toast.LENGTH_SHORT).show();
						 
						 
							if (c.moveToFirst())
							{
								er.setText(c.getString(7));
							} 
							else
							
							{
								Toast.makeText(getApplicationContext(), tv2.getText()+"of"+ et.getText(),
										Toast.LENGTH_SHORT).show();
							
								showMessage("Error ",
										"it seems the given medicine is not added  ");
								
								et.setText(" ");
							}
					}
					else
					{	

						if(tv2.getText().toString().equalsIgnoreCase("Manufacturer")){

							String a = tv2.getText().toString();
						 c = db.rawQuery(
								"select * from Medicines_log where medname='"
										+ et.getText().toString() + "'", null);
					
						if (c.moveToFirst())
						{
							er.setText(c.getString(2));
						} 
						else
						
						{
							Toast.makeText(getApplicationContext(), tv2.getText()+"of"+ et.getText(),
									Toast.LENGTH_SHORT).show();
						
							showMessage("Error ",
									"it seems the given medicine is not added  ");
							
							et.setText(" ");
						}
						}
						else{
							if(tv2.getText().toString().equalsIgnoreCase("content")){
							String a = tv2.getText().toString();
							
							 c = db.rawQuery(
									"select * from Medicines_log where medname='"
											+ et.getText() + "'", null);
						
							if (c.moveToFirst())
							{
								er.setText(c.getString(3));
							} 
							else
							
							{
								Toast.makeText(getApplicationContext(), tv2.getText()+"of"+ et.getText(),
										Toast.LENGTH_SHORT).show();
							
								showMessage("Error ",
										"it seems the given medicine is not added  ");
								
								et.setText(" ");
							}
							}
							}
					}
				}
			}
		});
		if (s2.equalsIgnoreCase("one")) {

			Drawable myDrawable = getResources().getDrawable(R.drawable.eight);
			Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
			// iv=(ImageView)findViewById(R.id.img_chg);
			iv.setImageBitmap(myLogo);

		}

		if (s2.equalsIgnoreCase("two")) {

			Drawable myDrawable = getResources().getDrawable(R.drawable.six);
			Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
			// iv=(ImageView)findViewById(R.id.img_chg);
			iv.setImageBitmap(myLogo);

		}
		if (s2.equalsIgnoreCase("three")) {

			Drawable myDrawable = getResources().getDrawable(R.drawable.cream);
			Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
			// iv=(ImageView)findViewById(R.id.img_chg);
			iv.setImageBitmap(myLogo);

		}

	}

	public void showMessage(String tit, String msg) {
		Builder bur = new Builder(this);
		bur.setIcon(R.drawable.inv);
		bur.setTitle(tit);
		bur.setMessage(msg);
		bur.setCancelable(true);
		bur.show();
	}
}