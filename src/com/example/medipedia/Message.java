package com.example.medipedia;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Message extends Activity {
	
	
	
		ImageButton sendBtn,cancbtn,back;
	   EditText txtphoneNo;
	   EditText txtMessage;
	   EditText medname;
	   SQLiteDatabase db;
	   Cursor c;
	   @Override
	   protected void onCreate(Bundle savedInstanceState) {
	      super.onCreate(savedInstanceState);
	      setContentView(R.layout.message);
db=FlashScreen.db;
	      sendBtn = (ImageButton) findViewById(R.id.buttonsend);
	      cancbtn=(ImageButton)findViewById(R.id.imageButton3);
	      back=(ImageButton)findViewById(R.id.imageButton1);
	      back.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
			
				Intent imsg= new Intent(getApplicationContext(), Options_matrix.class);
				startActivity(imsg);
				
				
			}
		});
	      
	      
	      
	      txtphoneNo = (EditText) findViewById(R.id.editText1);
	      medname=(EditText)findViewById(R.id.editText2);
	      txtMessage = (EditText) findViewById(R.id.editText3);

	      sendBtn.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View view) {
	            sendSMSMessage();
	         }
	      });
	   }
	   protected void sendSMSMessage() {
		   if(medname.getText().toString().length()!=0){
			   if(txtphoneNo.getText().toString().length()!=0){
	      Log.i("Send SMS", "");
	      String phoneNo = txtphoneNo.getText().toString();
	      
	      // select query here
	      c=db.rawQuery("select * from Medicines_log where medname='"+medname.getText()+"'",null);
	    	if(c.moveToFirst())	
	    		
	    	{
	    		Toast.makeText(getApplicationContext(), medname.getText(),Toast.LENGTH_SHORT).show();
	    		
	    		
					txtMessage.setText(c.getString(0) + "--" + c.getString(1)
							+ "--" + c.getString(2) + "--" + c.getString(3)
							+ "--" + c.getString(4) + "--" + c.getString(5)
							+ "--" + c.getString(6) + "--" + c.getString(7));	    		
	    		
	    	}
			
		else{
			
			
			Toast.makeText(
					getApplicationContext(),
					"it seems that the medicine you are trying to find is unavailable , please add and save the medicine details first",
					Toast.LENGTH_SHORT).show();

		}
	      
	      
	      
	      
	      
	      
	      String message = txtMessage.getText().toString();
		   
	      try {
	         SmsManager smsManager = SmsManager.getDefault();
	         smsManager.sendTextMessage(phoneNo, null, message, null, null);
	         Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
	      } 
	      
	      catch (Exception e) {
	         Toast.makeText(getApplicationContext(), "SMS failed, please try again.", Toast.LENGTH_LONG).show();
	         e.printStackTrace();
	      }
	   }
		   else
		   {
			   ShowMessage("Send Failed" , "Please enter mobile number to send");
		   }
	   }
		   else
		   {
			   ShowMessage("Send Failed" , "Please type the medicine name to send");
		   }
	   }

	   
	   
	   
	   public void ShowMessage(String tit, String msg) {
			Builder bur = new Builder(this);
			bur.setIcon(R.drawable.connection);
			bur.setTitle(tit);
			bur.setMessage(msg);
			bur.setCancelable(true);
			bur.show();
		}
}
