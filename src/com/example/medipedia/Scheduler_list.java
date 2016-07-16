package com.example.medipedia;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Scheduler_list extends Activity {

	ImageButton ib_close;
	Bundle bn;
	 String x1,x2,x3,x4,y1,y2,y3,y4,y5,y6,y7;
	String s1_per_name,s2_per_prob,s3_per_cou,s4_per_age;
	String s1_med_name,s2_med_type,s3_med_time;
	SQLiteDatabase db;
	Cursor cr;
	private List<Sch_items> my_sch_items=new ArrayList<Sch_items>(); // ref class java name
	
	ImageButton opt_mat, crt;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.scheduler_list);
		
	Bundle bg = getIntent().getExtras();
		
    	db=FlashScreen.db; //instantiate database (from flashscreen.java file)

		opt_mat=(ImageButton)findViewById(R.id.imageButton2);
		opt_mat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it1=new Intent(Scheduler_list.this, Options_matrix.class);
				startActivity(it1);
			}
		});
		crt=(ImageButton)findViewById(R.id.imageButton3);
crt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent it2=new Intent(Scheduler_list.this, New_sch.class);
				startActivity(it2);
			}
		});
		ib_close=(ImageButton)findViewById(R.id.imageButton1);
ib_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
finish();			}
		});

		populatehomelist();
		registerclick();
		populateListView();
}
	private void populatehomelist() {
		
		
		
		
		
		Cursor c =db.rawQuery("select * from Schedules_log",null);
		System.out.println(c.getCount());
    	if(c.getCount()==0)
    	{
    		showMessage("error","no records found");
    		return;
    	}
    	StringBuffer sb = new StringBuffer();
    	while(c.moveToNext())
    	{
    		
    		 x1=c.getString(0);
    		 x2=c.getString(1);
    		  x3=c.getString(2);
    		 x4=c.getString(3);
    		 
    		 
    		my_sch_items.add(new Sch_items("Name :"+x1,"Problem :"+x2, R.drawable.people,"Days of Course :"+x3+" Days",R.drawable.sider));

		
		
    	}

	}
	

	private void populateListView()
	{
		// TODO Auto-generated method stub

		ArrayAdapter<Sch_items> adapter=new MyOptionAdapter();
		ListView list_opt=(ListView)findViewById(R.id.listView1);
		list_opt.setAdapter(adapter);		
	}

	public class MyOptionAdapter extends ArrayAdapter<Sch_items>
	{
		
		
		public MyOptionAdapter(){
			super(Scheduler_list.this,R.layout.sch_lis_ref,my_sch_items);
		                        }

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itview=convertView;
			if(itview==null)
				{
				itview=getLayoutInflater().inflate(R.layout.sch_lis_ref,parent,false);  //ref xml file name
				}
			
			
			// find the option in home2
			
			Sch_items current_item = my_sch_items.get(position);
			
			
			// fill the view for options
			
			ImageView imgv1= (ImageView)itview.findViewById(R.id.imageView1);
			imgv1.setImageResource(current_item.getIcon_num1());
			
			ImageView imgb=(ImageView)itview.findViewById(R.id.delb);
			imgb.setImageResource(current_item.getIgb());
			
			
			
			// for text(option descriptions beside the icon)
			
			TextView option_descr=(TextView)itview.findViewById(R.id.textView1);
			option_descr.setText(current_item.getOpt());
			TextView option_descr1=(TextView)itview.findViewById(R.id.textView2);
			option_descr1.setText(current_item.getOpt2());
			
			TextView option_descr2=(TextView)itview.findViewById(R.id.textView3);
			option_descr2.setText(current_item.getIcon_num2());
			
			
			
			return itview;
		} 
	}
	
	private void registerclick() {

	// TODO Auto-generated method stub

	ListView list=(ListView)findViewById(R.id.listView1);
	list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
	
		@Override
		public void onItemClick(AdapterView<?> parent, View viewclicked, int pos,
				long id) {
			
			Sch_items clicked_option= my_sch_items.get(pos);
			String k=clicked_option.getOpt();	
//			 Toast.makeText(getApplicationContext(),k,Toast.LENGTH_LONG).show();
 
		//	String name_of="Name :"+x1;
			
			StringTokenizer st=new StringTokenizer(k,":");
			String ss=st.nextToken();   // we will get before part of :
			String sa=st.nextToken();	// we will get after part of :
			System.out.println("================="+ss+"and"+sa);

			
			// select query from schedule_log tabel with user name 	
				Cursor c =db.rawQuery("select *  from Schedules_log where pername='"+sa+"' ",null);
				
				System.out.println("================="+c.getCount());
		 if(c.getCount()==0)
		    	{
		    		showMessage("error","no records found");
		    		return;
		    	}
		    	
		    	
		    	while(c.moveToNext())
		    	{
		    		y1=c.getString(0);
		    		y2=c.getString(1);
		    		y3=c.getString(2);
		    		y4=c.getString(3);
		    		
				
				
		    	}
//		    	Toast.makeText(getApplicationContext(), y1+"--"+y2+"--"+y3+"--"+y4, Toast.LENGTH_LONG).show();

		    	

		  	
		    	Bundle b = new Bundle();
		    	b.putString("s1_per_name" ,y1);
		    	b.putString("s2_per_prob" ,y2);
		    	b.putString("s3_per_cou" ,y3);
		    	b.putString("s4_per_age" ,y4);
		    	Intent intent4=new Intent(Scheduler_list.this,Particular_list.class);
				intent4.putExtras(b);
				startActivity(intent4);
		

}
		});


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