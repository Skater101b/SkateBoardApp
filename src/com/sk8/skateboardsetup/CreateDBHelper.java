package com.sk8.skateboardsetup;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class CreateDBHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "skateBoard.db";
	private static final int DATABASE_VERSION = 1;
	
	private static final String CREATE_TABLE_SKATEBOARD = "create table skateboard (_id integer primary key autoincrement,"
			+ "boardChosen text not null, "
			+ "modelName text, "
			+ "wheels text, "
			+ "WheelModel text,"
			+ "truck text,"
			+ "TruckModel text,"
			+ "grip text);";


public CreateDBHelper (Context context) {
	super(context, DATABASE_NAME, null, DATABASE_VERSION); }

@Override
public void onCreate(SQLiteDatabase database) {
	database.execSQL(CREATE_TABLE_SKATEBOARD); }

	@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
	Log.w(CreateDBHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " 
			+ newVersion + ", which will destroy all old data");
	db.execSQL("DROP TABLE IF EXISTS skateBoard");
}
	

}
