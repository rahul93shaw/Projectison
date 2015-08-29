
package info.androidhive.slidingmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class Cartdetails extends Activity {
	Button bremove,bconfirm;
	EditText edit;
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
        setContentView(R.layout.cartdetails);
        db1 = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);
        
        
        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        final String add = i.getStringExtra("add");
        final String mobile = i.getStringExtra("mobile");
        final String email = i.getStringExtra("email");

        bremove = (Button) findViewById(R.id.buttonremove);
        bconfirm = (Button) findViewById(R.id.buttonconfirm);
        
        
        
        TextView txtcart = (TextView) findViewById(R.id.textViewcart);
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
			txtcart.setText(Outstr);
			//db1.close();
			//if you close the database then illegal exception will be occurred...
		}} catch(Exception e){
System.out.println(e);
		}
        
        
        final int sumtotal=getTotal();
		TextView sum = (TextView) findViewById(R.id.textsumtotal1);
		sum.setText(" Rs. "+sumtotal);
		
     
        bconfirm.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View arg0) {
				
				
				if(sumtotal==0)
				{
					 Toast.makeText(getApplicationContext(),"Cart is empty.",Toast.LENGTH_SHORT).show();
				}
				else
				{
				Intent nextScreen = new Intent(getApplicationContext(),Delivery.class);
				
				
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                nextScreen.putExtra("name",name);
                nextScreen.putExtra("add",add);
                nextScreen.putExtra("mobile",mobile);
                nextScreen.putExtra("email",email);
                
                startActivity(nextScreen);
				}
			}
		});
    
    
    bremove.setOnClickListener(new OnClickListener() {
   	 
		@Override
		public void onClick(View arg0) {
			
			edit = (EditText) findViewById(R.id.editTextremove);
			
			String itemremove=edit.getText().toString();
		
			db1.execSQL("DELETE  FROM tabq34 WHERE ITEMNAME='"+itemremove+"';");

			 Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
			 Intent nextScreen = new Intent(getApplicationContext(),Cartdetails.class);
             nextScreen.putExtra("name",name);
             nextScreen.putExtra("add",add);
             nextScreen.putExtra("mobile",mobile);
             nextScreen.putExtra("email",email);
             
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

