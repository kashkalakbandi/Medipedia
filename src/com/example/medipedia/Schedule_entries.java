package com.example.medipedia;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Schedule_entries extends Activity {
	
	Button badd,bfin;
	String s1,s2,s3,s4;
	ImageButton sav;
	ArrayList<DataVo> allData;
	Button btnAdd;
	String a = "O";
	String b = "O";
	String c = "O";
	String h ;
	TextView t1;
	EditText editText1;
	EditText editText2;
	final Spinner spinner1 =null;
	String spin;
	public static int count = 1;
	ListView lv;
	SQLiteDatabase db;
	Cursor cr;
	Bundle bn;
	ArrayList<String> al  = new ArrayList<String>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.schedule_entries);
t1=(TextView)findViewById(R.id.textView1);
Bundle b=getIntent().getExtras();
		
		s1=b.getString("heading");
		
		s2=b.getString("problem");
		s3=b.getString("course");
		s4=b.getString("age");
			
		t1.setText(s1);
		
		
	
		db=FlashScreen.db;
		
		
		
		allData = new ArrayList<DataVo>();
		btnAdd = (Button) findViewById(R.id.add_lay);

		btnAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				DataVo vo = new DataVo();
				vo.setName("");
				vo.setQuantity("");
				vo.setTime("");
				vo.setType("");

				ArrayList<String> medicines = new ArrayList<String>();
				medicines.add("Pills");
				medicines.add("Syrups");
				medicines.add("Cream");
				vo.setMedicines(medicines);
				allData.add(vo);

				refreshAdapter();

			}
		});

		
		
		
	
		
		
		DataVo vo = new DataVo();

		for (int i = 0; i < count; i++) {
			vo.setName("");
			vo.setQuantity("");
			vo.setTime("");
			vo.setType("");

			ArrayList<String> medicines = new ArrayList<String>();
		
			
			medicines.add("Pills");
			medicines.add("Syrups");
			medicines.add("Cream");
			vo.setMedicines(medicines);
			allData.add(vo);
		}

		lv = (ListView) findViewById(R.id.listView1);
		ArrayList<String> list = new ArrayList<String>();

		refreshAdapter();

	}

	public void refreshAdapter() {
		lv.setAdapter(new CustomAdapter(Schedule_entries.this, allData));

	}

	class CustomAdapter extends BaseAdapter {

		int checkBoxCount = 0;

		String sessions;

		LayoutInflater inflater;
		ArrayList<DataVo> allData;

		public CustomAdapter(Context context, ArrayList<DataVo> allData) {
			inflater = LayoutInflater.from(context);
			this.allData = allData;

		}

		@Override
		public int getCount() {
			return allData.size();
		}

		@Override
		public Object getItem(int position) {

			return position;
		}

		@Override
		public long getItemId(int position) {

			return 0;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {
			

			convertView = inflater.inflate(R.layout.schedule_entries_ref, null);

		 editText1 = (EditText) convertView
					.findViewById(R.id.editText1);
			editText1.getText();
			
			
		 editText2 = (EditText) convertView
					.findViewById(R.id.editText2);
			editText2.getText();
			
			

			final Spinner spinner1 = (Spinner) convertView
					.findViewById(R.id.spinner1);

			CheckBox checkBox2 = (CheckBox) convertView
					.findViewById(R.id.checkBox2);
			CheckBox checkBox1 = (CheckBox) convertView
					.findViewById(R.id.checkBox1);
			CheckBox checkBox3 = (CheckBox) convertView
					.findViewById(R.id.checkBox3);

			checkBox2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					if (isChecked) {
						a="I";
						h=a+b+c;
					} else {
						a="O";
						h=a+b+c;
						
					}

				}
			});

			checkBox1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					if (isChecked) {
						b="I";
						h=a+b+c;
					} else {
						b="O";
						h=a+b+c;
						
					}

				}
			});

			checkBox3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

				@Override
				public void onCheckedChanged(CompoundButton buttonView,
						boolean isChecked) {
					if (isChecked) {
						c="I";
						h=a+b+c;
					} else {
						c="O";
						h=a+b+c;
						
					}

				}
			});

			h= a+b+c;
			//Toast.makeText(getApplicationContext(), "the last string is " + h,
				//	2000).show();

			spinner1.setAdapter(new ArrayAdapter<String>(
					getApplicationContext(),
					android.R.layout.simple_spinner_dropdown_item, allData.get(position)
							.getMedicines()));

			// Toast.makeText(getApplicationContext(),
			// allData.get(position).getMedicines()+"", 2000).show();

			spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int arg2, long arg3) {
					Toast.makeText(getApplicationContext(),
							spinner1.getItemAtPosition(arg2).toString(), 2000).show();
					
					
					spin=spinner1.getItemAtPosition(arg2).toString();
					
					/*if (arg2 != 0) {
						
						
						//DOUBT HERE AT SPINNER 
						
						Toast.makeText(getApplicationContext(),
								spinner1.getItemAtPosition(position).toString(), 2000).show();
					}*/
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub

				}
			});

			// inal RadioGroup
			// radGroup=(RadioGroup)convertView.findViewById(R.id.radGroup);

			/*
			 * Spinner spin = null;
			 * 
			 * spin.setAdapter(new ArrayAdapter<String>(getApplicationContext(),
			 * android.R.layout.simple_spinner_item,
			 * allData.get(position).getMedicines()));
			 */

			editText1.setText(allData.get(position).getName());

			editText2.setText(allData.get(position).getQuantity());
			
			ImageButton button2 = (ImageButton) convertView
					.findViewById(R.id.save_lay);
			button2.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
				
					String p="";
					
					
					db.execSQL("create table if not exists "+t1.getText().toString()+"(medicinename varchar,typemed varchar,qty varchar,timing varchar);");
					
					Cursor cr = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='"+t1.getText().toString()+"';",null);
				
					if(cr.getCount()==0)
			    	{
			    		showMessage("error","no table found");
			    		return;
			    	}
					else
					{
						showMessage("yepp","found");
					    		
					}
					
			
				
					db.execSQL("insert into " +s1+ " values('" + editText1.getText().toString()
							+ "','" + spin
							+ "','" + editText2.getText().toString()
							+ "','"+h+"')");
					
			
					
Toast.makeText(getApplicationContext(),"Successfully Inserted into "+s1+" "+editText1.getText().toString()+""+spin+""+editText2.getText().toString()+""+h
							, Toast.LENGTH_LONG).show();
					
				
				
				}
			});

			
			bfin=(Button)findViewById(R.id.buttfin);
			bfin.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					
					
					
					
					bn=new Bundle();
					
					bn.putString("p_name" ,editText1.getText().toString());
					bn.putString("p_type" ,spin);
					bn.putString("p_times" ,h);
					bn.putString("person_name" ,s1);			
					bn.putString("person_problem" ,s2);
					bn.putString("person_course" ,s3);
					bn.putString("person_age" ,s4);
					
						//connect bundle to intent and start intent
					Intent intent1=new Intent(Schedule_entries.this,Scheduler_list.class);
					intent1.putExtras(bn);
					startActivity(intent1);
					
					
					
					
					
				}
			});
			
			

			return convertView;
		}

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