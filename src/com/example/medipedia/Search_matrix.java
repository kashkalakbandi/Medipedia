package com.example.medipedia;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
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

public class Search_matrix extends Activity {

	ImageButton ib_close,ib_back;
	TextView tv;
	
	Bundle bn;
	ImageView imageview;
	private List<Srch_items> my_search_items=new ArrayList<Srch_items>(); // ref class java name
	
	ImageButton h2_menu, h2_cart;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_matrix);
		
		
		
		Bundle b=getIntent().getExtras();
		
		String s1=b.getString("heading");
		tv=(TextView)findViewById(R.id.headingtv);
		tv.setText(s1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		ib_back=(ImageButton)findViewById(R.id.imageButton2);
		ib_back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				
				Intent intent_back=new Intent(Search_matrix.this,Options_matrix.class);
				startActivity(intent_back);
				
			}
		});
		
		
		
		
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
		my_search_items.add(new Srch_items("Pills and Capsules","Search for particular Pills or capsules", R.drawable.three));
		my_search_items.add(new Srch_items("Syrups and Tonics","Search for particular syrup ", R.drawable.six));
		my_search_items.add(new Srch_items("Creams","Search for particular Skin care Creams.", R.drawable.cream));
				
	}
	

	private void populateListView()
	{
		// TODO Auto-generated method stub

		ArrayAdapter<Srch_items> adapter=new MyOptionAdapter();
		ListView list_opt=(ListView)findViewById(R.id.listView1);
		list_opt.setAdapter(adapter);		
	}

	public class MyOptionAdapter extends ArrayAdapter<Srch_items>
	{
		
		
		public MyOptionAdapter(){
			super(Search_matrix.this,R.layout.matrix_search_ref,my_search_items);
		                        }

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View itview=convertView;
			if(itview==null)
				{
				itview=getLayoutInflater().inflate(R.layout.matrix_option_ref,parent,false);  //ref xml file name
				}
			
			
			// find the option in home2
			
			Srch_items current_item = my_search_items.get(position);
			
			
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
			
			Srch_items clicked_option= my_search_items.get(pos);
			String k=clicked_option.getOpt();	
			if(k.equals("Pills and Capsules")){
				Toast.makeText(getApplicationContext(), "Pills and Capsules", Toast.LENGTH_SHORT).show();
				
				Intent intent1=new Intent(Search_matrix.this,Search_pageplusBar.class);
				String a="Search-Pills";
				String img_flag="one";
				
				
			
				bn=new Bundle();
				bn.putString("header" ,a);
				bn.putString("image", img_flag);
				
				//connect bundle to intent and start intent
				
				intent1.putExtras(bn);
				startActivity(intent1);
			}
			
			if(k.equals("Syrups and Tonics")){
				Toast.makeText(getApplicationContext(), "Search for Syrups and Tonics", Toast.LENGTH_SHORT).show();
				Intent intent2=new Intent(Search_matrix.this,Search_pageplusBar.class);
				String a="Search-Syrups";
				String img_flag="two";

				bn=new Bundle();
			
				bn.putString("header" ,a);
				bn.putString("image", img_flag);
				//connect bundle to intent and start intent
				
				intent2.putExtras(bn);
				startActivity(intent2);
			}
			
			if(k.equals("Creams")){
				Toast.makeText(getApplicationContext(), "Search for Creams", Toast.LENGTH_SHORT).show();
				Intent intent3=new Intent(Search_matrix.this,Search_pageplusBar.class);
				
				
				bn=new Bundle();


				
				
				String a="Search-Creams";
				String img_flag="three";

				bn.putString("header" ,a);
				bn.putString("image", img_flag);
				
				//connect bundle to intent and start intent
				
				intent3.putExtras(bn);
				startActivity(intent3);
			}
			
			
}
		});

}
}
	
