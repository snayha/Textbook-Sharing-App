package ria.Jun2015.textbooksharing.search;
import ria.Jun2015.textbooksharing.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SubjectSAT extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_school_subjects);
        
        Button english = (Button) findViewById(R.id.literature);
        english.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATLiterature.class));
			}
		});
      
        Button ushistory = (Button) findViewById(R.id.ushistory);
        ushistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATUSHistory.class));
			}
		});
        Button worldHistory = (Button) findViewById(R.id.worldhistory);
        worldHistory.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATWorldHistory.class));
			}
		});
        Button math1 = (Button) findViewById(R.id.math1);
        math1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATMath1.class));
			}
		});
      
        Button math2 = (Button) findViewById(R.id.math2);
        math2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATMath2.class));
			}
		});
        Button biology = (Button) findViewById(R.id.biology);
        biology.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATBiology.class));
			}
		});  
        Button chemistry = (Button) findViewById(R.id.chemistry);
        chemistry.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATChemistry.class));
			}
		});  
        Button physics = (Button) findViewById(R.id.physics);
        physics.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATPhysics.class));
			}
		});
        Button language = (Button) findViewById(R.id.language);
        language.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(SubjectSAT.this,SubjectSATLanguage.class));
			}
		});
}

}
