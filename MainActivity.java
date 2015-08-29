package com.example.sharedpreference;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity {
   
	Button b1, b2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		b1 = (Button) findViewById(R.id.save);
		b2 = (Button) findViewById(R.id.cancel);
		b1.setOnClickListener((OnClickListener) this);
		loadSavedPreferences();
	}
	
	 private void loadSavedPreferences() {
	        SharedPreferences sharedPreferences = PreferenceManager
	                .getDefaultSharedPreferences(this);
	        String item = sharedPreferences.getString("storedItem", "Item");
	 
	        editText.setText(item);
	    }
	 
	 private void my_savePreferences(String key, String value) {
	        SharedPreferences sharedPreferences = PreferenceManager
	                .getDefaultSharedPreferences(this);
	        Editor editor = sharedPreferences.edit();
	        editor.putString(key, value);
	        editor.commit();
	    }
	   public void onClick(View v) {
		   my_savePreferences("storedName", editText.getText().toString());
	   }
	   
	   b2.setOnClickListener(new OnClickListener() {
		   
           @Override
		   public void onClick (View view) {
			   //intent code for returning back to home screen
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
