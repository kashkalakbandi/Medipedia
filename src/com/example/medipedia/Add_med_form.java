package com.example.medipedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Add_med_form extends Activity {

	ImageButton img_b1, img_b2, img_b3, img_b4;
	SQLiteDatabase db;
	EditText et1, et2, et3, et4, et5, et6 , et7;
	RadioGroup rgp;
	RadioButton rbtn;
	String type;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_med_form);
		db= openOrCreateDatabase("medipedia",Context.MODE_PRIVATE, null);
		rgp = (RadioGroup) findViewById(R.id.radiogrp);
		rgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() 
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.radioButton1:
                    	type="Pills";
                    break;

                    case R.id.radioButton2:
                    	type="Syrup";
                        // do operations specific to this selection
                    break;

                    case R.id.radioButton3:
                        // do operations specific to this selection
                    	type="Cream";
                    break;

                }


            }
        });

		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		et4 = (EditText) findViewById(R.id.editText4);
		et5 = (EditText) findViewById(R.id.editText5);
		et6 = (EditText) findViewById(R.id.editText6);
		et7=(EditText)findViewById(R.id.editText7);
		img_b1 = (ImageButton) findViewById(R.id.imageButton2);
		img_b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent int_back = new Intent(Add_med_form.this,
						Options_matrix.class);
				startActivity(int_back);
			}
		});
		img_b2 = (ImageButton) findViewById(R.id.imageButton1);
		img_b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				et1.setText(" ");
				et2.setText(" ");
				et3.setText(" ");
				et4.setText(" ");
				et5.setText(" ");
				et6.setText(" ");
				et7.setText(" ");
			}
		});

		img_b3 = (ImageButton) findViewById(R.id.imageButton3);
		img_b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		img_b4 = (ImageButton) findViewById(R.id.imageButton4);
		img_b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// SUBMIT
			db.execSQL("insert into Medicines_log values('" + et1.getText().toString()
					+ "','" + type + "','" + et2.getText().toString()
						+ "','" + et3.getText().toString() + "','" + et4.getText().toString() + "','"
						+ et5.getText().toString() + "','" + et7.getText().toString() + "','" + et6.getText().toString() + "')");
				
				Toast.makeText(getApplicationContext(),et1.getText().toString()+"\n" +type+"\n" +et3.getText().toString()+"\n" + et4.getText().toString()+"\n" + et5.getText().toString()+"\n" + et5.getText().toString()+"\n" + et6.getText().toString(), Toast.LENGTH_SHORT).show();
			
				
				
		
			
		
			showMessage("Success", "Medicine details saved !");

			et1.setText(" ");
			et2.setText(" ");
			et3.setText(" ");
			et4.setText(" ");
			et5.setText(" ");
			et6.setText(" ");
			et7.setText(" ");
			}
		});

	}

	public void showMessage(String tit, String msg) {
		Builder bur = new Builder(this);
		bur.setIcon(R.drawable.builder_save);
		bur.setTitle(tit);
		bur.setMessage(msg);
		bur.setCancelable(true);
		bur.show();
	}

}