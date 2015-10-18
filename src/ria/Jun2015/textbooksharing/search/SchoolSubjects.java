package ria.Jun2015.textbooksharing.search;

import ria.Jun2015.textbooksharing.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SchoolSubjects extends Activity{
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.search_school_subjects);
	        
	        Button english = (Button) findViewById(R.id.english);
	        english.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,EnglishSchoolSubject.class));
				}
			});
	      
	        Button socialStudies = (Button) findViewById(R.id.socialStudies);
	        socialStudies.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,SocialStudiesSchoolSubject.class));
				}
			});
	        Button math = (Button) findViewById(R.id.math);
	        math.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,MathSchoolSubject.class));
				}
			});
	        Button science = (Button) findViewById(R.id.science);
	        science.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,ScienceSchoolSubject.class));
				}
			});
	        Button language = (Button) findViewById(R.id.language);
	        language.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,LanguageSchoolSubject.class));
				}
			});
	        Button other = (Button) findViewById(R.id.other);
	        other.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(SchoolSubjects.this,OtherSchoolSubject.class));
				}
			});
}}
