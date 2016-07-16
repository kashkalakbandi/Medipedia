package com.example.medipedia;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
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

public class Options_matrix extends Activity {

	ImageButton ib_close;
	Bundle bn;
	private List<Opt_items> my_option_items=new ArrayList<Opt_items>(); // ref class java name
	
	ImageButton h2_menu, h2_cart;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.option_matrix);
		
		ib_close=(ImageButton)findViewById(R.id.imageButton1);
		ib_close.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			finish();
				
			}
		});
		registerclick();
	populateListView();
	populatehomelist();
}
	
	

	private void populatehomelist() {
		// TODO Auto-generated method stub
		my_option_items.add(new Opt_items("Search Medicines","Search for particular medicine for a problem", R.drawable.search));
		my_option_items.add(new Opt_items("Contents","Know How its made ?", R.drawable.two));
		my_option_items.add(new Opt_items("Market Stats","Know how much it costs .", R.drawable.four));
		my_option_items.add(new Opt_items("Manufacturer","Who made it ?", R.drawable.seven));
		my_option_items.add(new Opt_items("Dosage", "Right dose for children and adults?",R.drawable.ten));
		my_option_items.add(new Opt_items("Add Item", "Missing few ?you might want to add something ?",R.drawable.square));
		my_option_items.add(new Opt_items("Scheduler", "Schedule your medicine course , and all of your family members",R.drawable.calendar));

		my_option_items.add(new Opt_items("Send details","Share medicine details to your friends", R.drawable.eleven));
		
	}
	

	private void populateListView()
	{
		// TODO Auto-generated method stub

		ArrayAdapter<Opt_items> adapter=new MyOptionAdapter();
		ListView list_opt=(ListView)findViewById(R.id.listView1);
		list_opt.setAdapter(adapter);		
	}

	public class MyOptionAdapter extends ArrayAdapter<Opt_items>
	{
		
		
		public MyOptionAdapter(){
			super(Options_matrix.this,R.layout.matrix_option_ref,my_option_items);
		                        }

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itview=convertView;
			if(itview==null)
				{
				itview=getLayoutInflater().inflate(R.layout.matrix_option_ref,parent,false);  //ref xml file name
				}
			
			
			// find the option in home2
			
			Opt_items current_item = my_option_items.get(position);
			
			
			// fill the view for options
			
			ImageView imgv= (ImageView)itview.findViewById(R.id.img_chg);
			imgv.setImageResource(current_item.getIcon_num());
			
			// for text(option descriptions beside the icon)
			
			TextView option_descr=(TextView)itview.findViewById(R.id.subheading);
			option_descr.setText(current_item.getOpt());
			
			TextView option2_descr=(TextView)itview.findViewById(R.id.textView2);
			option2_descr.setText(current_item.getOpt2());
			
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
			
			Opt_items clicked_option= my_option_items.get(pos);
			String k=clicked_option.getOpt();	
			if(k.equals("Search Medicines")){
				Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
				Intent intent1=new Intent(Options_matrix.this,Search_matrix.class);
				String a= "Search ..?" ;
				String  flag= "Search" ;

				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("header" ,flag);

				
				//connect bundle to intent and start intent
				
				intent1.putExtras(bn);
				startActivity(intent1);
			}
			
			if(k.equals("Manufacturer")){
				Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
				Intent intent2=new Intent(Options_matrix.this,Search_mat2.class);
				String a= "Manufacturer" ;
				String  flag="manufacture";

				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("header" ,flag);

				//connect bundle to intent and start intent
				
				intent2.putExtras(bn);
	
				startActivity(intent2);
			}
			
			if(k.equals("Dosage")){
				Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
				Intent intent3=new Intent(Options_matrix.this,Dosage_details.class);
				String a= "Dosage " ;
				String flag="dosage";

				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("header" ,flag);

				
				//connect bundle to intent and start intent
				
				intent3.putExtras(bn);
			
				startActivity(intent3);
			}
			

			if(k.equals("Contents")){
				Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
				Intent intent3=new Intent(Options_matrix.this,Search_mat2.class);
				String a= "content " ;
				String flag="content";

				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("header" ,flag);
				
				//connect bundle to intent and start intent
				
				intent3.putExtras(bn);
			
				startActivity(intent3);
			}
			
			if(k.equals("Market Stats")){
				Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_SHORT).show();
				Intent intent3=new Intent(Options_matrix.this,Search_mat2.class);
				String a= "Market Stats " ;
				String  flag="market";

				bn=new Bundle();
				bn.putString("heading" ,a);
				bn.putString("header" ,flag);

				
				//connect bundle to intent and start intent
				
				intent3.putExtras(bn);
			
				startActivity(intent3);
			}
			
			if(k.equals("Add Item")){
				Toast.makeText(getApplicationContext(), "Add new Medicine Form", Toast.LENGTH_SHORT).show();
				Intent intent4=new Intent(Options_matrix.this,Add_med_form.class);
				startActivity(intent4);
			
			}
			if(k.equals("Send details")){
				Toast.makeText(getApplicationContext(), "Preparing the form , please wait", Toast.LENGTH_SHORT).show();
				Intent intent4=new Intent(Options_matrix.this,Message.class);
				startActivity(intent4);
			
			}
			if(k.equals("Scheduler")){
				Toast.makeText(getApplicationContext(), "Loading scheduler, please wait", Toast.LENGTH_SHORT).show();
				Intent intent4=new Intent(Options_matrix.this,Scheduler_list.class);
				startActivity(intent4);
			
			}
			
			
			
}
		});

}
}
	
	
