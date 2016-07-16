package com.example.medipedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class New_sch extends Activity{

	
	Button b1;
	Bundle bn;
	ImageButton b2,b3,b4;
	SQLiteDatabase db;
	Cursor c ;
	EditText e1,e2,e3,e4;
	String a,b,cc,d;
	
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.new_sch);
		db = openOrCreateDatabase("medipedia", Context.MODE_PRIVATE, null);
		
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		e3=(EditText)findViewById(R.id.editText3);
		e4=(EditText)findViewById(R.id.editText5);
		
		
		b1=(Button)findViewById(R.id.button1);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(),e1.getText().toString()+"\n"+e2.getText().toString()+"\n" +e3.getText().toString()+"\n" + e4.getText().toString(), Toast.LENGTH_SHORT).show();			
				db.execSQL("insert into Schedules_log values('" + e1.getText().toString()
						+ "','" + e2.getText().toString()
						+ "','" + e3.getText().toString()
						+ "','" + e4.getText().toString()
						+ "')");
				
				showMessage("Success", "Schedule  details saved !");
				a=e1.getText().toString();
				b=e1.getText().toString();
				cc=e1.getText().toString();
				d=e1.getText().toString();
				
				
				Toast.makeText(getApplicationContext(),a+"-"+b+"-"+cc+"-"+d, Toast.LENGTH_SHORT).show();			
				
				Intent i=new Intent(New_sch.this , Schedule_entries.class);
				
				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("problem" ,b);
				bn.putString("course" ,cc);
				bn.putString("age" ,d);
				
				

				
				//connect bundle to intent and start intent
				
				i.putExtras(bn);
				startActivity(i);
				
				
				
				
			}
		});
		//Schedule_entries.count=3;
		
		
		
		
}
	
	
	public void showMessage(String tit, String msg) {
		// TODO Auto-generated method stub
		Builder bur = new Builder(this);
		bur.setIcon(R.drawable.builder_save);
		bur.setTitle(tit);
		bur.setMessage(msg);
		bur.setCancelable(true);
		bur.show();
	}
}