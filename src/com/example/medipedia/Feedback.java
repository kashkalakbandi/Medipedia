package com.example.medipedia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class Feedback extends Activity{
	
	ImageButton i1,i2;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		
		i1=(ImageButton)findViewById(R.id.imageButton2);
		i1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(Feedback.this,Options_matrix.class);
				startActivity(intent);
				
				
			}
		});
		i2=(ImageButton)findViewById(R.id.imageButton1);
		i2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
}
}