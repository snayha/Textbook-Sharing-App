package ria.Jun2015.textbooksharing.search;




import ria.Jun2015.textbooksharing.R;
import ria.Jun2015.textbooksharing.R.id;
import ria.Jun2015.textbooksharing.R.layout;
import ria.Jun2015.textbooksharing.R.menu;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemSelectedListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


public class MainSearchPage extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_search_page);
        Button schoolText = (Button) findViewById(R.id.button5);
        schoolText.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,SchoolSubjects.class));
			}
		});
        Button act = (Button) findViewById(R.id.button1);
        act.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,ACT.class));
			}
		});
        Button sat = (Button) findViewById(R.id.button2);
        sat.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,SAT.class));
			}
		});
        Button subjectSAT = (Button) findViewById(R.id.button3);
        subjectSAT.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,SubjectSAT.class));
			}
		});
        Button ap = (Button) findViewById(R.id.button4);
        ap.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,AP.class));
			}
		});
        Button other = (Button) findViewById(R.id.button6);
        other.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainSearchPage.this,Other.class));
			}
		});
        
        




    } 


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



   
}

