package com.example.medipedia;

import java.util.ArrayList;
import java.util.List;

import com.example.medipedia.Options_matrix.MyOptionAdapter;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Particular_list extends Activity {

	SQLiteDatabase db;
	Cursor cr;
	String s1, s2, s3, s4, s5, s6, s7, s8, z1, z2, z3, z4;
	TextView tt1, tt2, tt3, tt4;
	ImageButton ih;
	Button bdel, bex;

	private List<Particular_ref> ref_items = new ArrayList<Particular_ref>();

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.particulars_list);

		ih = (ImageButton) findViewById(R.id.imagebtn);
		ih.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub

				Intent ij = new Intent(Particular_list.this,
						Scheduler_list.class);
				startActivity(ij);

			}
		});

		bex = (Button) findViewById(R.id.button2);

		tt1 = (TextView) findViewById(R.id.textView1);
		tt2 = (TextView) findViewById(R.id.textView2);
		tt3 = (TextView) findViewById(R.id.textView4);
		tt4 = (TextView) findViewById(R.id.textView3);

		db = openOrCreateDatabase("medipedia", Context.MODE_PRIVATE, null);

		populateListView();
		populatehomelist();

	}

	private void populatehomelist() {

		Bundle b = getIntent().getExtras();

		s1 = b.getString("s1_per_name");
		s2 = b.getString("s2_per_prob");
		s3 = b.getString("s3_per_cou");
		s4 = b.getString("s4_per_age");

		s5 = b.getString("y5");
		s6 = b.getString("y6");
		tt1.setText(s1);
		tt2.setText(s4);
		tt3.setText(s4);
		tt4.setText(s2);

		Cursor c = db.rawQuery("select *  from " + s1 + " ", null);

		System.out.println("=================" + c.getCount());
		if (c.getCount() == 0) {
			showMessage("error", "no records found");
			return;
		}

		while (c.moveToNext()) {
			z1 = c.getString(0);
			z2 = c.getString(1);
			z3 = c.getString(2);
			z4 = c.getString(3);

			if (z4.equalsIgnoreCase("OOI")) {
				ref_items
						.add(new Particular_ref(R.drawable.allmedds, "" + z1,
								R.drawable.dose, "" + z3, "Times per day",
								R.drawable.cloud2, R.drawable.summer2,
								R.drawable.moon));

			}
			if (z4.equalsIgnoreCase("OII")) {
				ref_items.add(new Particular_ref(R.drawable.allmedds, "" + z1,
						R.drawable.dose, "" + z3, "Times per day",
						R.drawable.cloud2, R.drawable.summer, R.drawable.moon));

			}
			if (z4.equalsIgnoreCase("III")) {

				Toast.makeText(getApplicationContext(), "YEPPPiii",
						Toast.LENGTH_LONG).show();
				ref_items.add(new Particular_ref(R.drawable.allmedds, "" + z1,
						R.drawable.dose, "" + z3, "Times per day",
						R.drawable.cloud, R.drawable.summer, R.drawable.moon));

			}
			if (z4.equalsIgnoreCase("IIO")) {

				ref_items.add(new Particular_ref(R.drawable.allmedds, "" + z1,
						R.drawable.dose, "" + z3, "Times per day",
						R.drawable.cloud, R.drawable.summer, R.drawable.moon2));

			}
			if (z4.equalsIgnoreCase("IOI")) {
				ref_items.add(new Particular_ref(R.drawable.allmedds, "" + z1,
						R.drawable.dose, "" + z3, "Times per day",
						R.drawable.cloud, R.drawable.summer2, R.drawable.moon));

			}
			if (z4.equalsIgnoreCase("OIO")) {
				ref_items
						.add(new Particular_ref(R.drawable.allmedds, "" + z1,
								R.drawable.dose, "" + z3, "Times per day",
								R.drawable.cloud2, R.drawable.summer,
								R.drawable.moon2));

			}
			if (z4.equalsIgnoreCase("IOO")) {
				ref_items
						.add(new Particular_ref(R.drawable.allmedds, "" + z1,
								R.drawable.dose, "" + z3, "Times per day",
								R.drawable.cloud, R.drawable.summer2,
								R.drawable.moon2));

			}

			// ref_items.add(new Particular_ref( R.drawable.allmedds,""+z1,
			// R.drawable.dose,""+z3,"Times per day",
			// R.drawable.line,R.drawable.line,R.drawable.line));

		}
		/*
		 * Toast.makeText(getApplicationContext(),
		 * z1+"---"+z2+"---"+z3+"---"+z4, Toast.LENGTH_LONG).show();
		 * Toast.makeText(getApplicationContext(), "icons"+z4,
		 * Toast.LENGTH_LONG).show();
		 */

		bdel = (Button) findViewById(R.id.button1);
		bdel.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				// Toast.makeText(getApplicationContext(), s1,
				// Toast.LENGTH_LONG).show();

				try {
					
					
				int i=	db.delete("Schedules_log", "pername=?", new String[]{s1});
				if (i>0) {
					showMessage("success", "  record deleted-" + s1);
					db.execSQL("DROP TABLE IF EXISTS " + s1);
					Intent a = new Intent(Particular_list.this,
							Scheduler_list.class);
					startActivity(a);
				}
					/*db.execSQL("delete from Schedules_log where pername=" +s1
							+ "");
					db.execSQL("DROP TABLE IF EXISTS " + s1);
					*/

					

				} catch (Exception e) {
				}

			}
		});

	}

	private void populateListView() {
		// TODO Auto-generated method stub

		ArrayAdapter<Particular_ref> adapter = new MyOptionAdapter();
		ListView list_opt = (ListView) findViewById(R.id.listView1);
		list_opt.setAdapter(adapter);
	}

	public class MyOptionAdapter extends ArrayAdapter<Particular_ref> {
		public MyOptionAdapter() {
			super(Particular_list.this, R.layout.particular_ref, ref_items);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View itview = convertView;
			if (itview == null) {
				itview = getLayoutInflater().inflate(R.layout.particular_ref,
						parent, false); // ref xml file name
			}

			// find the option in home2

			Particular_ref current_item = ref_items.get(position);

			// fill the view for options

			ImageView imgv1 = (ImageView) itview.findViewById(R.id.imageView1);
			imgv1.setImageResource(current_item.getIcon_num1());
			TextView option_descr1 = (TextView) itview
					.findViewById(R.id.textView1);
			option_descr1.setText(current_item.getOpt1());
			ImageView imgv2 = (ImageView) itview.findViewById(R.id.imageView2);
			imgv2.setImageResource(current_item.getIcon_num2());
			TextView option_descr2 = (TextView) itview
					.findViewById(R.id.textView2);
			option_descr2.setText(current_item.getOpt2());
			TextView option2_descr3 = (TextView) itview
					.findViewById(R.id.textView3);
			option2_descr3.setText(current_item.getOpt3());

			ImageView imgv4 = (ImageView) itview.findViewById(R.id.imageView4);
			imgv4.setImageResource(current_item.getIcon_num4());

			ImageView imgv5 = (ImageView) itview.findViewById(R.id.imageView3);
			imgv5.setImageResource(current_item.getIcon_num5());

			ImageView imgv6 = (ImageView) itview.findViewById(R.id.imageView5);
			imgv6.setImageResource(current_item.getIcon_num6());
			// for text(option descriptions beside the icon)

			return itview;

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
