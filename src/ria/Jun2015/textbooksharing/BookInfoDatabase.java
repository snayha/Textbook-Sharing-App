package ria.Jun2015.textbooksharing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookInfoDatabase extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DICTIONARY_TABLE_NAME = "Book_Info_Table";
    
	private static final String DATABASE_NAME = "BookInfo.db";
	private static final String COL_1 = "STUDENT";
	//private static final String COL_2 = "SAT";
	//private static final String COL_3 = "Subject SAT";
	//private static final String COL_4 = "AP";
	//private static final String COL_5 = "Other";
	private static final String DICTIONARY_TABLE_CREATE =
            "CREATE TABLE " + DICTIONARY_TABLE_NAME +
             " (ID INTEGER PRIMARY KEY AUTOINCREMENT, STUDENT singleBookInfo;";
            
    BookInfoDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DICTIONARY_TABLE_CREATE);
    }

	

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + DICTIONARY_TABLE_NAME);
		onCreate(db);
		// TODO Auto-generated method stub
		
	}
}
//CREATE TABLE BOOK INFO (BOOK TEXT, BOOK TEXT);