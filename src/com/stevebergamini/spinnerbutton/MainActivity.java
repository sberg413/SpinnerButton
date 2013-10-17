package com.stevebergamini.spinnerbutton;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	Spinner spinner1;
	Button button1;
	AlertDialog ad;
	String[] countries;
	
	int selected = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		button1 = (Button) findViewById(R.id.button1);
		
		countries = getResources().getStringArray(R.array.country_names);
		
		//  You can also use an adapter for the allert dialog if you'd like
		//  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, countries);		
		
		ad = new AlertDialog.Builder(MainActivity.this).setSingleChoiceItems(countries, selected,  
				new  DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							button1.setText(countries[which]);
							selected = which;
							ad.dismiss();
							
						}}).setTitle(R.string.select_country).create();	
		
		
		button1.setOnClickListener( new OnClickListener(){
						
			@Override
			public void onClick(View v) {
				ad.getListView().setSelection(selected);
				ad.show();				
			}});
		
	}

}
