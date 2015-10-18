package ria.Jun2015.textbooksharing;

import ria.Jun2015.textbooksharing.search.MainSearchPage;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenu extends Activity{
	  @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main_menu);
	        
	        Button find = (Button) findViewById(R.id.findBook);
	        Button upload = (Button) findViewById(R.id.uploadBook);
	        Button submissions = (Button) findViewById(R.id.submitBook);
	        find.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.v("tag1", "wha");
					startActivity(new Intent(MainMenu.this, MainSearchPage.class));
			        Log.v("tag2", "what");

				}
			});
	        upload.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Log.v("tag1", "wha");
					startActivity(new Intent(MainMenu.this, BookSubmissionForm.class));
					Log.v("tag2", "what");

				}
	        });
	        submissions.setOnClickListener(new OnClickListener() {
	
	        	@Override
	        	public void onClick(View v) {
	        		Log.v("tag1", "wha");
	        		startActivity(new Intent(MainMenu.this, MySubmissions.class));
	        		Log.v("tag2", "what");

	        	}
	        });
	    	}
}
