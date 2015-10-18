package ria.Jun2015.textbooksharing;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class BookSubmissionForm extends Activity  implements OnItemSelectedListener, OnClickListener

{
	
	String myBookType = "bla";
	String myName = "bla";
	String myEmail = "bla";
	String myBookTitle = "bla";
	String myBookTypeSubchoice = "bla";
	
	Spinner spinner;

	private ProgressDialog pDialog;
	private static final String POST_COMMENT_URL = "http://10.0.2.2/bookSubmission/android_bookSubmission/booksubmission.php";
	private static final String TAG_SUCCESS = "success";
    private static final String TAG_MESSAGE = "message";
	
	//String[] sources_array= {"ACT", "SAT", "Subject SAT", "AP", "School Subject", "Other"};
	// Progress Dialog
    
 
    
   
    //private int byGetOrPost = 0;
  
	 protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        
	        setContentView(R.layout.book_entry_form);
	       spinner = (Spinner) findViewById(R.id.bookTypeChoices);

	        
	        // Create an ArrayAdapter using the string array and a default spinner layout
	        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	                R.array.sources_array, android.R.layout.simple_spinner_item);
	        // Specify the layout to use when the list of choices appears
	        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	        // Apply the adapter to the spinner
	        spinner.setAdapter(adapter);
	        spinner.setOnItemSelectedListener(this);
	        
	        Button b = (Button) findViewById(R.id.buttonSubmit);
	        b.setOnClickListener(this);
	        
	        		
	        		
	        		
	        
	 }
	 public void onItemSelected(AdapterView<?> parent, View view, 
	            int pos, long id) {
	       
	        if(parent.getItemAtPosition(pos).equals("AP"))
	        	{
	        		
					Spinner apChoice = (Spinner) findViewById(R.id.subChoiceSpinner);
			        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
			                R.array.apChoices_array, android.R.layout.simple_spinner_item);
			       adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			        apChoice.setAdapter(adapter1);  
	        	}
	        else if(parent.getItemAtPosition(pos).equals("Subject SAT"))
     	{    		
				Spinner sat = (Spinner) findViewById(R.id.subChoiceSpinner);				 
		        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
		                R.array.subjectSat_array, android.R.layout.simple_spinner_item);		        
		       adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		        
		        sat.setAdapter(adapter1);		        
     	}
	        else if(parent.getItemAtPosition(pos).equals("School Subjects"))
     	{     		
				Spinner schoolSubject = (Spinner) findViewById(R.id.subChoiceSpinner);				 
		        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
		                R.array.schoolsubject_array, android.R.layout.simple_spinner_item);		        
		       adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);		        
		        schoolSubject.setAdapter(adapter1);
		        
     	}
	    }

	    public void onNothingSelected(AdapterView<?> parent) {
	        // Another interface callback
	    }
	 @Override
	 public void onClick(View v) {
		 
		 final EditText editTextName = (EditText) findViewById(R.id.editText1);
	        final EditText editTextEmail = (EditText) findViewById(R.id.editText2);
	        final EditText editTextBookTitle = (EditText) findViewById(R.id.editText3);
	        if(editTextName.getText().toString()!=null || editTextEmail.getText().toString() !=null ||
	     			editTextBookTitle.getText().toString()!=null)
	        {
	        	if(spinner.getSelectedItem().toString().equals("Subject SAT") || spinner.getSelectedItem().toString().equals("School Subjects")
	        			|| spinner.getSelectedItem().toString().equals("AP"))
	        	{
	        		Spinner subchoiceSpinner = (Spinner) findViewById(R.id.subChoiceSpinner);
	        		myBookTypeSubchoice = (subchoiceSpinner).getSelectedItem().toString();
	        	}
	        	else
	        	{
	        		myBookTypeSubchoice = "none";
	        	}
     		myName = (editTextName.getText().toString());
     		myEmail= (editTextEmail.getText().toString());
     		myBookTitle=(editTextBookTitle.getText().toString());
     		myBookType = spinner.getSelectedItem().toString();
     		Log.v("Inputed Stuff", myName+ ", " + myEmail + ", " +myBookTitle + ", " +myBookType);
     			try {
					saveToFile(myName+ "," + myEmail+ "," + myBookTitle + "," + myBookType + "," + myBookTypeSubchoice);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
	            new PostComment().execute();
	        }
	       
	 
	     }
	 	private void saveToFile(String message) throws Exception
	 	{
	 		String filePath = getFilesDir().toString()+ "/submission.txt";
	 		FileOutputStream out = new FileOutputStream(filePath, true);
	 		out.write(message.getBytes());
	 		out.close();
	 	}
		
		class PostComment extends AsyncTask<String, String, String> {
			
	        @Override
	        protected void onPreExecute() {
	            super.onPreExecute();
	            pDialog = new ProgressDialog(BookSubmissionForm.this);
	            pDialog.setMessage("Posting Comment...");
	            pDialog.setIndeterminate(false);
	            pDialog.setCancelable(true);
	            //pDialog.show();
	        }

			@Override
			protected String doInBackground(String... args) {
				// TODO Auto-generated method stub
				 // Check for success tag
	         int success;
	         
	         
	         
	         
	         try {
	             // Building Parameters
	             List<NameValuePair> params = new ArrayList<NameValuePair>();
	             params.add(new BasicNameValuePair("name", myName));
	             params.add(new BasicNameValuePair("book title", myBookTitle));
	             params.add(new BasicNameValuePair("book type", myBookType));
	             params.add(new BasicNameValuePair("book type subchoice", myBookTypeSubchoice));
	             params.add(new BasicNameValuePair("email", myEmail));
	             

	             Log.d("request!", "starting");
	             
	             //Posting user data to script 
	             JSONParser jsonParser= new JSONParser();
	             jsonParser.toString();
	             
	             JSONObject json = jsonParser.makeHttpRequest(
	             		POST_COMMENT_URL, "POST", params);
	            
	            
	             // full json response
	             Log.d("Post Comment attempt", json.toString());

	             // json success element
	             success = json.getInt(TAG_SUCCESS);
	             if (success == 1) {
	            	 
	             	Log.d("Comment Added!", json.toString());    
	             	finish();
	             	Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
	             }else{
	             	Log.d("Comment Failure!", json.getString(TAG_MESSAGE));
	             	return json.getString(TAG_MESSAGE);
	             	
	             }
	         } catch (JSONException e) {
	             e.printStackTrace();
	         }

	         return null;
			}

		}	
		 protected void onPostExecute(String file_url) {
	            // dismiss the dialog once product deleted
	            pDialog.dismiss();
	            if (file_url != null){
	            	Toast.makeText(BookSubmissionForm.this, file_url, Toast.LENGTH_LONG).show();
	            }
	 
	        }
		
		  
			
		}
	 





