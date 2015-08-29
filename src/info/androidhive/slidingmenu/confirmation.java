package info.androidhive.slidingmenu;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class confirmation extends Activity {
	Button b20,b19;
	SQLiteDatabase db1 = null;
	private static String DBNAME = "PERSONS.db";
	String d1,d2,d3,d4 = null;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmation);
 
        db1 = openOrCreateDatabase(DBNAME, Context.MODE_PRIVATE,null);

        Intent i = getIntent();
        final String name = i.getStringExtra("name");
        final String price = i.getStringExtra("price");
        final String sumtotal = i.getStringExtra("sumtotal");

        b20 = (Button) findViewById(R.id.button20);
        b19 = (Button) findViewById(R.id.button19);
        
        TextView txtName = (TextView) findViewById(R.id.textView33);
        txtName.setText(name); 
        
        TextView sum = (TextView) findViewById(R.id.textView34);
        sum.setText(sumtotal);
        
        TextView txtPrice = (TextView) findViewById(R.id.textView35);
        txtPrice.setText("Rs. " + price);
        
        Integer quantity,totalprice;
        Long totalvalue;
        quantity=Integer.valueOf(sumtotal);
        
        totalprice=Integer.valueOf(price);
        
        totalvalue=(long) (quantity*totalprice);
        final String sum1;
        sum1=totalvalue.toString();
        
        TextView sum2 = (TextView) findViewById(R.id.textView37);
        sum2.setText("Rs. " + sum1);
        
        
        d1=name;
		d2=sumtotal;
		d3=price;
		d4=sum1;
		
		
		try{
			db1.execSQL("CREATE TABLE IF NOT EXISTS tabq34(ITEMNAME VARCHAR,QUANTITY INTEGER, PRICE INTEGER, TOTAL INTEGER ); ");
			db1.execSQL("INSERT INTO tabq34 (ITEMNAME,QUANTITY,PRICE,TOTAL)  VALUES ('"+d1+"','"+d2+"','"+d3+"','"+d4+"');");
			} catch(Exception e)
			{
			System.out.println(e);
			}
        
        b20.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View arg0) {
				
				Intent nextScreen = new Intent(getApplicationContext(),payment.class);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                startActivity(nextScreen);
                
                
			}
		});
        b19.setOnClickListener(new OnClickListener() {
       	 
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),MainActivity.class);
                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                startActivity(nextScreen);
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


