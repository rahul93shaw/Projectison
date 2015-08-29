package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class payment extends Activity {
	Button b21;
	Spinner sp;
	Spinner sp2;
	Spinner sp3;
	EditText pname,padd,pmob,ppincode,pemail;
	ArrayAdapter<String> adapter;
    String states[] = { "ODISHA", "WEST BENGAL" };
    static String city,state;
    
    public void chooseodisha(){
   	 sp2= (Spinner) findViewById(R.id.spinner2);
   	 ArrayAdapter<String> adapter1;
   	 final String cities[] = { "BHUBANESHWAR", "CUTTACK","PURI" };
   	 adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cities);
   	 adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	     sp2.setAdapter(adapter1);
	     
	     sp2.setOnItemSelectedListener(new OnItemSelectedListener() {
	    	@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
	    		
	    		//Toast.makeText(getApplicationContext(), "Item selected "+ cities[arg2] , Toast.LENGTH_SHORT).show();
	    		city=cities[arg2];
	    	}

			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Nothing selected..." , Toast.LENGTH_SHORT).show();
			}
			
	
		});
   
   }
    
    private void choosewb(){
      	 sp3= (Spinner) findViewById(R.id.spinner2);
      	 ArrayAdapter<String> adapter2;
      	final String cities[] = { "ALIPURDUAR", "KOLKATA","HOWRAH" };
      	 adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cities);
      	 adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
   	     sp3.setAdapter(adapter2);
   	     
   	     
   	     sp3.setOnItemSelectedListener(new OnItemSelectedListener() {
   		    	@Override
   				public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
   						long arg3) {
   					// TODO Auto-generated method stub
   		    		
   		    		//Toast.makeText(getApplicationContext(), "Item selected "+ cities[arg2] , Toast.LENGTH_SHORT).show();
   		    		city=cities[arg2];
   		    	}

   				public void onNothingSelected(AdapterView<?> arg0) {
   					// TODO Auto-generated method stub
   					Toast.makeText(getApplicationContext(), "Nothing selected..." , Toast.LENGTH_SHORT).show();
   				}
   	
   			});
      }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment);
 
        pname = (EditText) findViewById(R.id.textname1);
        padd = (EditText) findViewById(R.id.textaddress1);
        ppincode = (EditText) findViewById(R.id.pincode1);
        pmob =  (EditText) findViewById(R.id.mob_num);
        pemail = (EditText) findViewById(R.id.emailID);
        
        sp = (Spinner) findViewById(R.id.spinner1);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, states);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    sp.setAdapter(adapter);   
        Intent i = getIntent();
        
        
        
        sp.setOnItemSelectedListener(new OnItemSelectedListener() 
        {
	    	@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
	    	{
				// TODO Auto-generated method stub
	    		
	    		//Toast.makeText(getApplicationContext(), "Item selected "+ states[arg2] , Toast.LENGTH_LONG).show();
	    		state=states[arg2];
	    		if(arg2==0)
	    		{
	    			chooseodisha();
	    		}
	    		else
	    		{
	    			choosewb();
	    		}
	    				
			}

			public void onNothingSelected(AdapterView<?> arg0) 
			{
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "Nothing selected..." , Toast.LENGTH_LONG).show();
			}
		});
        b21 = (Button) findViewById(R.id.done);

        b21.setOnClickListener(new OnClickListener() 
        {
        	 
			@Override
			public void onClick(View arg0) 
			{
				if(( pname.getText().toString().trim().equals(""))||( pemail.getText().toString().trim().equals(""))||(padd.getText().toString().trim().equals(""))||(ppincode.getText().toString().trim().equals(""))||(pmob.getText().toString().trim().equals("")))
				{    
					Toast.makeText(getApplicationContext(),"Complete all the fields.",Toast.LENGTH_SHORT).show();
				}
				else
				{
				
				Intent nextScreen = new Intent(getApplicationContext(),Cartdetails.class);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                nextScreen.putExtra("name",pname.getText().toString());
                nextScreen.putExtra("add",(padd.getText().toString()+"\nCity : "+city+"\nState : "+state +" \nPincode : "+ppincode.getText().toString()));
                nextScreen.putExtra("mobile",pmob.getText().toString());
                nextScreen.putExtra("email",pemail.getText().toString());
                Log.e("First Screen", pname.getText()+".");
                startActivity(nextScreen);
				}
			}
		});
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.acrivity_main_menu, menu);
        return super.onCreateOptionsMenu(menu);
	}
}

