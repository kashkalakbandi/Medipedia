package com.example.medipedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Dosage_details extends Activity {
RadioGroup rgrp;
String type;
ImageButton ib1;
SQLiteDatabase db;
Cursor c ;
TextView t2,t4;
EditText ets;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dosage);
		db = openOrCreateDatabase("medipedia", Context.MODE_PRIVATE, null);
		t2=(TextView)findViewById(R.id.textView2);
		t4=(TextView)findViewById(R.id.textView4);
		
		rgrp = (RadioGroup) findViewById(R.id.rdgrp);
		rgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() 
        {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.btn1:
                    	type="Pills";
                    break;

                    case R.id.btn2:
                    	type="Syrup";
                        // do operations specific to this selection
                    break;

                    case R.id.btn3:
                        // do operations specific to this selection
                    	type="Cream";
                    break;

                }


            }
        });
		
		
		ets=(EditText)findViewById(R.id.editText1);
		ib1=(ImageButton)findViewById(R.id.srch);
		ib1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(ets.getText().toString().trim().length()!=0){
					
					String a = ets.getText().toString();
					 c = db.rawQuery(
							"select * from Medicines_log where medname='"
									+ ets.getText() + "' and type='"+type+"' ", null);
					 
				
					if (c.moveToFirst())
					{
						t4.setText(c.getString(5));

						t2.setText(c.getString(6));
						
					} 
					else
					{
					showMessage("Error","It seems the medicine you are searching for is not saved");
					}
				}
				else
				{
					showMessage("Error", "Please enter a keyword for searching");

				}
				
				
				
			}

			
		});
		
		
	

}
	
	public void showMessage(String tit, String msg) {
		// TODO Auto-generated method stub
		Builder bur = new Builder(this);
		bur.setIcon(R.drawable.inv);
		bur.setTitle(tit);
		bur.setMessage(msg);
		bur.setCancelable(true);
		bur.show();
	}
}