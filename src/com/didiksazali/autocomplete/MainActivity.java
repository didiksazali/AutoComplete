package com.didiksazali.autocomplete;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	AutoCompleteTextView autoComplete, autoComplete2;
	Button btnOk;
	TextView pilih, pilih2;
	
	
	//isi autocomplete
	String[] items = {"Di", "Did", "Didi", "Didik",
					  "Sa", "Saza", "Sazali"};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        //contoh 1
        pilih = (TextView)findViewById(R.id.txtHasil);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_dropdown_item_1line, items);
        
        autoComplete = (AutoCompleteTextView)findViewById(R.id.autocomplete);
        autoComplete.setAdapter(adapter);
        
        btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				pilih.setText(autoComplete.getText());
				//String pilihan = (String) spinner.getSelectedItem();
				//pilih.setText(pilihan);
			}
		});
        
        
        //contoh 2
        pilih2 = (TextView) findViewById(R.id.txtHasil2);
        
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_dropdown_item_1line, items);
        
        autoComplete2 = (AutoCompleteTextView)findViewById(R.id.autocomplete2);
        autoComplete2.setAdapter(adapter2);
        autoComplete2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				// TODO Auto-generated method stub
				//String pilihan = (String)arg0.getSelectedItem();
	    		//pilih2.setText(pilihan);
				pilih2.setText(autoComplete2.getText());
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
        	
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
