package ria.Jun2015.textbooksharing;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

public class MySubmissions extends ListActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_submissions);
        ArrayList<String> allSubmissionsFromFile;
        
        String[] tagNames = new String[]{"NAME", "EMAIL", "BOOKTITLE", "BOOKTYPE"};
        try {
        	ArrayList<HashMap<String, String>> allSubmissions = null;
			allSubmissionsFromFile = getFromFile();
			for(String current : allSubmissionsFromFile)
	        { 
				HashMap<String, String> singleInfo = null;
				String currentString = "";
				int count = 0;
	        	for(int i = 0; i < current.length(); i++)
	        	{
	        		
	        		if(current.charAt(i)==(','))
	        		{
	        			singleInfo.put(tagNames[count], currentString);
	        			count++;
	        			currentString = "";
	        		}
	        		else
	        		{
	        			currentString += current.charAt(i);
	        		}
	        	}
	        	allSubmissions.add(singleInfo);
	        	ListAdapter adapter = new SimpleAdapter(this, allSubmissions, R.layout.single_submission, 
	        			new String[] {"Name", "Email", "BookTitle", "BookType"}, new int[]{R.id.name, R.id.email, R.id.bookTitle, R.id.bookType});
	        	setListAdapter(adapter);
	        
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	
	
	
	}
	private ArrayList<String> getFromFile() throws Exception
 	{
		ArrayList<String> lines = null;
 		try {
 			String filePath = getFilesDir().toString()+ "/submission.txt";
 	 		FileInputStream in = new FileInputStream(filePath);
 	 		BufferedReader f = new BufferedReader(new InputStreamReader(in));
 	 		
			
			
						
			String line;
			lines = new ArrayList<String>();
			while(f.ready())
			{
				line = f.readLine();
				lines.add(line);
			}
			f.close();
 		}catch (Exception e) {
	
			e.printStackTrace();
		}
 		return lines;
 		
 	}
	  // parent.getItemAtPosition(pos)
	    
	


	
	
	

	 
	
}
