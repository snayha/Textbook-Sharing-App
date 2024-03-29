package ria.Jun2015.textbooksharing.search;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import ria.Jun2015.textbooksharing.BookSubmissionForm;
import ria.Jun2015.textbooksharing.JSONParser;
import ria.Jun2015.textbooksharing.R;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ScienceSchoolSubject extends ListActivity {

	// Progress Dialog
	private ProgressDialog pDialog;
 
	//php read comments script
    
    //localhost :  
    //testing on your device
    //put your local ip instead,  on windows, run CMD > ipconfig
    //or in mac's terminal type ifconfig and look for the ip under en0 or en1
   // private static final String READ_COMMENTS_URL = "http://xxx.xxx.x.x:1234/webservice/comments.php";
    
    //testing on Emulator:
    private static final String READ_COMMENTS_URL = "http://10.0.2.2:1234/bookSubmission/comments.php";
    
  //testing from a real server:
    //private static final String READ_COMMENTS_URL = "http://www.mybringback.com/webservice/comments.php";
   
  //JSON IDS:
    private static final String TAG_SUCCESS = "success";
    private static final String TAG_POSTS = "posts";
    private static final String TAG_POST_ID = "post_id";
    private static final String TAG_NAME = "name";
    private static final String TAG_BOOKTITLE = "bookTitle";
    private static final String TAG_BOOKTYPESUBCHOICE = "bookTitleSubchoice";
    private static final String TAG_BOOKTYPE = "bookType";
    private static final String TAG_EMAIL = "email";
    //it's important to note that the message is both in the parent branch of 
    //our JSON tree that displays a "Post Available" or a "No Post Available" message,
    //and there is also a message for each individual post, listed under the "posts"
    //category, that displays what the user typed as their message.
    

   //An array of all of our comments
    private JSONArray mComments = null;
    //manages all of our comments in a list.
    private ArrayList<HashMap<String, String>> mCommentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //note that use read_comments.xml instead of our single_post.xml
        setContentView(R.layout.read_comments);   
    }
    
    @Override
    protected void onResume() {
    	// TODO Auto-generated method stub
    	super.onResume();
    	//loading the comments via AsyncTask
    	new LoadComments().execute();
    }

	public void addComment(View v)
    {
        Intent i = new Intent(ScienceSchoolSubject.this, BookSubmissionForm.class);
        startActivity(i);
    }


    public class LoadComments extends AsyncTask<Void, Void, Boolean> {

    	@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(ScienceSchoolSubject.this);
			pDialog.setMessage("Loading Comments...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
        @Override
        protected Boolean doInBackground(Void... arg0) {
        	//we will develop this method in version 2
            updateJSONdata();
            return null;

        }


        @Override
        protected void onPostExecute(Boolean result) {
            super.onPostExecute(result);
            pDialog.dismiss();
          //we will develop this method in version 2
            updateList();
        }
    }
    /**
     * Retrieves recent post data from the server.
     */
    public void updateJSONdata() {

        // Instantiate the arraylist to contain all the JSON data.
    	// we are going to use a bunch of key-value pairs, referring
    	// to the json element name, and the content, for example,
    	// message it the tag, and "I'm awesome" as the content..
    	
        mCommentList = new ArrayList<HashMap<String, String>>();
        
        
        JSONParser jParser = new JSONParser();
        
        JSONObject json = jParser.getJSONFromUrl(READ_COMMENTS_URL);

        //when parsing JSON stuff, we should probably
        //try to catch any exceptions:
        try {
            
        	//I know I said we would check if "Posts were Avail." (success==1)
        	//before we tried to read the individual posts, but I lied...
        	//mComments will tell us how many "posts" or comments are
        	//available
            mComments = json.getJSONArray(TAG_POSTS);

            // looping through all posts according to the json object returned
            for (int i = 0; i < mComments.length(); i++) {
                JSONObject c = mComments.getJSONObject(i);
                if(c.getString(TAG_BOOKTYPE).equals("School Subjects") && c.getString(TAG_BOOKTYPESUBCHOICE).equals("Science"))
                {

	                //gets the content of each tag
                	String name = c.getString(TAG_NAME);
	                String bookTitle = c.getString(TAG_BOOKTITLE);
	                String bookType = c.getString(TAG_BOOKTYPE);
	                String bookTypeSubchoice = c.getString(TAG_BOOKTYPESUBCHOICE);
	                String email = c.getString(TAG_EMAIL);
	                
	
	                // creating new HashMap
	                HashMap<String, String> map = new HashMap<String, String>();
	              
	                map.put(TAG_BOOKTITLE, bookTitle);
	                map.put(TAG_BOOKTYPE, bookType);
	                map.put(TAG_NAME, name);
	                map.put(TAG_EMAIL, email);
	                map.put(TAG_BOOKTYPESUBCHOICE, bookTypeSubchoice);
	                
	                mCommentList.add(map);
                }
                // adding HashList to ArrayList
               
                
                //annndddd, our JSON data is up to date same with our array list
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /**
    	 * Inserts the parsed data into the listview.
    	 */
    	private void updateList() {
    		// For a ListActivity we need to set the List Adapter, and in order to do
    		//that, we need to create a ListAdapter.  This SimpleAdapter,
    		//will utilize our updated Hashmapped ArrayList, 
    		//use our single_post xml template for each item in our list,
    		//and place the appropriate info from the list to the
    		//correct GUI id.  Order is important here.
    		
    		ListAdapter adapter = new SimpleAdapter(this, mCommentList,
    				R.layout.single_submission, new String[] { TAG_BOOKTITLE,
    						TAG_NAME, TAG_EMAIL, TAG_BOOKTYPE, TAG_BOOKTYPESUBCHOICE }, new int[] { R.id.bookTitle, R.id.name,
    						R.id.email, R.id.bookType, R.id.bookTypeSubchoice });

    		// I shouldn't have to comment on this one:
    		setListAdapter(adapter);
    		
    		// Optional: when the user clicks a list item we 
    		//could do something.  However, we will choose
    		//to do nothing...
    		ListView lv = getListView();	
    		lv.setOnItemClickListener(new OnItemClickListener() {

    			@Override
    			public void onItemClick(AdapterView<?> parent, View view,
    					int position, long id) {

    				// This method is triggered if an item is click within our
    				// list. For our example we won't be using this, but
    				// it is useful to know in real life applications.

    			}
    		});
    	}       
    
}