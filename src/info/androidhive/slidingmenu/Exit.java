package info.androidhive.slidingmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Exit extends Activity {
	Button b23;
	SQLiteDatabase db1; 
	private static String DBNAME = "PERSONS.db";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exit);
        db1 = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
        db1.execSQL("DELETE  FROM tabq34 ;");
        
       
        final AlertDialog.Builder adb=new AlertDialog.Builder(this);
        adb.setMessage("Do you really want to exit from app?");
        adb.setTitle("ALERT!!!");
        /*adb.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
    	
    	public void onClick(DialogInterface dialog, int which) {
    		// TODO Auto-generated method stub
    		Toast.makeText(getApplicationContext(), "Thank You!!!", Toast.LENGTH_LONG).show();
    		Intent exitIntent = new Intent(getApplicationContext(),MainActivity.class);
    		exitIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	    exitIntent.putExtra("Exit me", true);
    	    startActivity(exitIntent);
    		
    	    finish();
    		
    		System.exit(0);
    	}
    });*/
        
        adb.setNegativeButton("Click to go to HOME", new DialogInterface.OnClickListener() {
    	
    	public void onClick(DialogInterface dialog, int which) {
    		// TODO Auto-generated method stub
    		Toast.makeText(getApplicationContext(), "Welcome back!!!", Toast.LENGTH_LONG).show();
    		 Intent intent = new Intent(getApplicationContext(),MainActivity.class);
    		    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
    		    startActivity(intent);
    	}
    });
     adb.setIcon(R.drawable.ic_launcher);


        
        
        b23 = (Button) findViewById(R.id.button23);
        
        b23.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View arg0) {
				

				adb.show();
				
			}
		});
    }
}

