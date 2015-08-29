package info.androidhive.slidingmenu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Rate extends Activity {
	private RatingBar ratingBar;
	private TextView txtRatingValue;
	Button bb;
	public Integer c;
	TextView t;
	ImageView i1,i2;
	//private Button btnSubmit;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rate);
		addListenerOnRatingBar();
		bb=(Button)findViewById(R.id.but1);

        bb.setOnClickListener(new OnClickListener() {
        	 
			@Override
			public void onClick(View arg0) {
				Intent nextScreen = new Intent(getApplicationContext(),Exit.class);
                //Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();
                startActivity(nextScreen);
			}
		});
		//addListenerOnButton();
	}

  public void addListenerOnRatingBar() {
 
	ratingBar = (RatingBar) findViewById(R.id.ratingBar1);
	t=(TextView)findViewById(R.id.textView2);
	i1=(ImageView)findViewById(R.id.img1);
	//txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);
 
	//if rating value is changed,
	//display the current rating value in the result (textview) automatically
	ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
		public void onRatingChanged(RatingBar ratingBar, float rating,
			boolean fromUser) {
			c=Integer.valueOf((int) ratingBar.getRating());
			if(c==1)
			{
				i1.setImageResource(R.drawable.bigsad);

				t.setText("Rating : "+String.valueOf(ratingBar.getRating()));
			}
			else if(c==2)
			{
				i1.setImageResource(R.drawable.sad);
				t.setText("Rating : "+String.valueOf(ratingBar.getRating()));
			}
			else if(c==5)
			{
				i1.setImageResource(R.drawable.bigsmiley);
				t.setText("Rating : "+String.valueOf(ratingBar.getRating()));
			}
			else
			{
				i1.setImageResource(R.drawable.happy);
				t.setText("Rating : "+String.valueOf(ratingBar.getRating()));

			}
			
			//txtRatingValue.setText(String.valueOf(rating));
			
			Toast.makeText(getApplicationContext(),"Thank You !! You Have Given Rating:"+String.valueOf(ratingBar.getRating()),
				Toast.LENGTH_SHORT).show();
			
		}
	});
  }
	}


