package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Delivery extends Activity {
	Button b22;
	String Outstr = null;
	SQLiteDatabase db1; 
	private static String DBNAME = "PERSONS.db";
	
	public int getTotal() {
    	// TODO Auto-generated method stub
    	int sum=0;
    	Cursor cursor = db1.rawQuery(
    	        "SELECT SUM(TOTAL) FROM tabq34 ", null);
    	    cursor.moveToFirst();
    	    if(cursor.getCount()>0) {
    	        sum=cursor.getInt(0);
    	    }
    	    return sum;
    	   }
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery);
        db1 = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
        
        
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String add = i.getStringExtra("add");
        String mobile = i.getStringExtra("mobile");
        String email = i.getStringExtra("email");

        b22 = (Button) findViewById(R.id.button22);
        
        TextView txtName = (TextView) findViewById(R.id.textView49);
        txtName.setText(name); 
        
        TextView address = (TextView) findViewById(R.id.textView51);
        address.setText(add);
        
        TextView phone = (TextView) findViewById(R.id.textView55);
        phone.setText(mobile);
        
        TextView txtemail = (TextView) findViewById(R.id.textView53);
        txtemail.setText(email);
        
        TextView txtoutput = (TextView) findViewById(R.id.textViewoutput);
        Outstr="";
        try{
			Cursor c = db1.rawQuery("SELECT * FROM tabq34", null);
			if(c!= null){
				if (c.moveToFirst()) {
					do {
							//whole data of column is fetched by getColumnIndex()
							String itemname =c.getString(c.getColumnIndex("ITEMNAME"));
							String quantity =c.getString(c.getColumnIndex("QUANTITY"));
							String price =c.getString(c.getColumnIndex("PRICE"));
							String total =c.getString(c.getColumnIndex("TOTAL"));

							System.out.println(itemname+" "+quantity+" "+price+" "+total);

						Outstr+="\n Item Name : "+itemname+"\n Quantity : "+quantity+"\n Price : Rs."+price+"\n Total Price : Rs."+total+"\n";
						}
					while(c.moveToNext());}
			txtoutput.setText(Outstr);
			//db1.close();
			//if you close the database then illegal exception will be occurred...
		}} catch(Exception e){
System.out.println(e);
};


			int sumtotal=getTotal();
			TextView sum = (TextView) findViewById(R.id.textsumtotal1d);
			sum.setText(" Rs. "+sumtotal);
     
        b22.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),Rate.class);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                startActivity(nextScreen);
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

