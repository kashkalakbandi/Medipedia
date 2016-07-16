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
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Search_pageplusBar extends Activity {

	TextView tv , t1,t2,t3,t4 , t10, t11;
	ImageView iv;
	String s1,search_text;
	EditText et,et5,t7;
	ImageButton btn,delb;
    SQLiteDatabase db;
    Cursor c;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_page_bar);
		db= openOrCreateDatabase("medipedia",Context.MODE_PRIVATE, null);
		et = (EditText) findViewById(R.id.editText2);
		
		t1 = (TextView) findViewById(R.id.textView2);
		t2 = (TextView) findViewById(R.id.textView4);
		t3 = (TextView) findViewById(R.id.textView6);
		t4 = (TextView) findViewById(R.id.textView8);
		et5 = (EditText) findViewById(R.id.editText1);
		t10=(TextView)findViewById(R.id.textView10);
		t11=(TextView)findViewById(R.id.textView11);
		
		tv = (TextView) findViewById(R.id.header_change);
		iv = (ImageView) findViewById(R.id.img_chg);
		Bundle b = getIntent().getExtras();

		s1 = b.getString("header");
		String s2 = b.getString("image");
		tv.setText(s1);
		btn = (ImageButton) findViewById(R.id.imageButton4);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				if (et.getText().toString().length() != 0) {
			//			search_text=et.getText().toString();
					
					 c=db.rawQuery("select * from Medicines_log where medname='"+et.getText()+"'",null);
			    	if(c.moveToFirst())	
			    		
			    	{
			    		Toast.makeText(getApplicationContext(), et.getText(),Toast.LENGTH_SHORT).show();
			    		
			    		t1.setText(c.getString(0));
			    		t2.setText(c.getString(2));
			
			    		et5.setText(c.getString(3));
			    		t3.setText(c.getString(4));
			    		t4.setText(c.getString(5));		  

			    		t11.setText(c.getString(6));
			    		
			    		t10.setText(c.getString(7));
			    		
			    		
			    		et.setText(" ");
			    	}
					
				else{
					
					
					Toast.makeText(
							getApplicationContext(),
							"it seems thatthe medicine you are trying to find is unavailable , please save the edicine details first",
							Toast.LENGTH_SHORT).show();

				}
			    	
			    
			    		

				}
				
				else{
					Toast.makeText(
							getApplicationContext(),
							"Please enter the medicine name in the search here field to search",
							Toast.LENGTH_SHORT).show();

					
					
				}
					

			}

			
		});

		
		
		
		
		
		delb=(ImageButton)findViewById(R.id.imageButton3);
		delb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				
				
				
				
				
				try {
					
					
					int i=	db.delete("Medicines_log", "medname=?", new String[]{t1.getText().toString()});
					if (i>0) {
						showMessage("success", "  record deleted");
						
						Intent a = new Intent(Search_pageplusBar.this,
								Options_matrix.class);
						startActivity(a);
					}
						

						

					} catch (Exception e) {
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
		bur.setIcon(R.drawable.dd);
		bur.setTitle(tit);
		bur.setMessage(msg);
		bur.setCancelable(true);
		bur.show();
	}

	public void showMessage_inv(String tit, String msg) {
		// TODO Auto-generated method stub
		Builder build=new Builder(this);
		build.setIcon(R.drawable.inv);
		build.setTitle(tit);
		build.setMessage(msg);
		build.setCancelable(true);
		build.show();
	}
}