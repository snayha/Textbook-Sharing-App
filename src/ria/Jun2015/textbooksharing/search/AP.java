package ria.Jun2015.textbooksharing.search;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import ria.Jun2015.textbooksharing.R;


public class AP extends Activity {
	protected void onCreate(Bundle savedInstanceState)
	{
	 super.onCreate(savedInstanceState);
     setContentView(R.layout.search_ap);
     
     Button english = (Button) findViewById(R.id.english);
     english.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APEnglish.class));
			}
		});
   
     Button history = (Button) findViewById(R.id.history);
     history.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APHistory.class));
			}
		});
     Button math = (Button) findViewById(R.id.math);
     math.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APMath.class));
			}
		});
     Button science = (Button) findViewById(R.id.science);
     science.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APScience.class));
			}
		});
     Button language = (Button) findViewById(R.id.language);
     language.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APLanguage.class));
			}
		});
     Button art = (Button) findViewById(R.id.arts);
     art.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(AP.this,APArts.class));
			}
		});
}}
