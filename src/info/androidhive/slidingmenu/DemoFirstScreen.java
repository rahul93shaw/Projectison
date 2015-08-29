package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DemoFirstScreen extends MainActivity {
	Button back,btn1;
	String name,price,total,sumtotal,str1="1",str2="2",str3="3";
	EditText quan;
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dell);
        Intent i = getIntent();
        quan = (EditText) findViewById(R.id.text1);
        sumtotal=quan.getText().toString();
        btn1 = (Button) findViewById(R.id.button2);
        back = (Button) findViewById(R.id.button1);
        back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent nextScreen = new Intent(getApplicationContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(),"Back to home",Toast.LENGTH_SHORT).show();
                startActivity(nextScreen);

			}
		});
        btn1.setOnClickListener(new OnClickListener() {
       	 
    			@Override
    			public void onClick(View arg0) {
    				if(quan.getText().toString().equals(str1)||quan.getText().toString().equals(str2)||quan.getText().toString().equals(str3))
    				{
    				 Intent nextScreen = new Intent(getApplicationContext(), confirmation.class);
    	                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
    	                nextScreen.putExtra("name","DELL ULTRABOOK");
    	                nextScreen.putExtra("price","48999");
    	                nextScreen.putExtra("sumtotal",quan.getText().toString());
    	                Log.e("First Screen", quan.getText()+".");
    	                startActivity(nextScreen);
    				}
    				else
    				{
    					Toast.makeText(getApplicationContext(),"INVALID ITEM SELECTED. Please Select 1,2 or 3",Toast.LENGTH_LONG).show();
    				}

    			}
    		});
        }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.acrivity_main_menu, menu);
		return true;
	}
}

