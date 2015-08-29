package info.androidhive.slidingmenu;

import info.androidhive.slidingmenu.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuInflater;
import android.view.View.OnClickListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
public class MainActivity extends Activity {
	Button exit;
	ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		exit = (Button) findViewById(R.id.exxxit);
	    
		// get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
 
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);
    
    
	// Listview Group expanded listener
			expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

				@Override
				public void onGroupExpand(int groupPosition) {
					Toast.makeText(getApplicationContext(),
							listDataHeader.get(groupPosition) + " Expanded",
							Toast.LENGTH_SHORT).show();
				}
			});

			// Listview Group collasped listener
			expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

				@Override
				public void onGroupCollapse(int groupPosition) {
					Toast.makeText(getApplicationContext(),
							listDataHeader.get(groupPosition) + " Collapsed",
							Toast.LENGTH_SHORT).show();

				}
			});
			
			expListView.setOnChildClickListener(new OnChildClickListener() {
			
				
				public boolean onChildClick(ExpandableListView parent,View v,
						int groupPosition, int childPosition, long id) {
					// TODO Auto-generated method stub 
					if(groupPosition==0 && childPosition==0){
						Intent Dell = new Intent(getApplicationContext(), DemoFirstScreen.class);
		                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
		                startActivity(Dell);
			        } else if(groupPosition==0 && childPosition==1){
			        	Intent Toshiba=new Intent(getApplicationContext(),DemoSecondScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Toshiba);
			        }else if(groupPosition==0 && childPosition==2){
			        	Intent Lenovo=new Intent(getApplicationContext(),DemoThirdScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Lenovo);
			        }else if(groupPosition==1 && childPosition==0){
			        	Intent Htc=new Intent(getApplicationContext(),DemoFourthScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Htc);
						
			        }else if(groupPosition==1 && childPosition==1){
			        	Intent Nokia=new Intent(getApplicationContext(),DemoFifthScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Nokia);
			        }
			        else if(groupPosition==1 && childPosition==2){
			        	Intent Samsung=new Intent(getApplicationContext(),DemoSixthScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Samsung);
			        
			        }else if(groupPosition==2 && childPosition==0){
			        	Intent Nikon=new Intent(getApplicationContext(),DemoSeventhScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Nikon);
			        }else if(groupPosition==2 && childPosition==1){
			        	Intent Canon=new Intent(getApplicationContext(),DemoEightScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Canon);
			        }else if(groupPosition==2 && childPosition==2){
			        	Intent Sony=new Intent(getApplicationContext(),DemoNinthScreen.class);
			        	Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
						startActivity(Sony);
			        }
					return false;
	                
				}
			});
	}
	private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();
 
        // Adding group data
        listDataHeader.add("Laptop");
        listDataHeader.add("Mobile");
        listDataHeader.add("Camera");
 
        // Adding child data
        List<String> Laptop = new ArrayList<String>();
        Laptop.add("Dell");
        Laptop.add("Toshiba");
        Laptop.add("Lenovo");
        
 
        List<String> Mobile = new ArrayList<String>();
        Mobile.add("HTC");
        Mobile.add("Nokia");
        Mobile.add("Samsung");
        
 
        List<String> Camera = new ArrayList<String>();
        Camera .add("Nikon");
        Camera .add("Canon");
        Camera .add("Sony");
        
 
        listDataChild.put(listDataHeader.get(0), Laptop); 
        listDataChild.put(listDataHeader.get(1), Mobile);
        listDataChild.put(listDataHeader.get(2), Camera );
    

	
	exit.setOnClickListener(new OnClickListener() {
   	 
		@Override
		public void onClick(View arg0) {
			

			System.exit(0);
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

