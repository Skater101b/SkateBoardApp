package com.sk8.skateboardsetup;


import java.io.PrintStream;
import java.util.ArrayList;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.format.Time;


public class skateboardDataSource {	
	
	private SQLiteDatabase database;
	private CreateDBHelper dbHelper;
	public skateboardDataSource(Context context) {
		dbHelper = new CreateDBHelper(context);
	}
		


	public void open() throws SQLException {
		database = dbHelper.getWritableDatabase();
	}
	public void close() {
		dbHelper.close();
	
	}
	
	public boolean insertWheelco(board b) {
		boolean didSucceed = false;
		try {
			Long rowId = Long.valueOf(b.getboardid());
			ContentValues updateWheels = new ContentValues();
			updateWheels.put("wheels", b.getWheelscom());
			didSucceed = database.update("skateboard", updateWheels, "_id=" + rowId, null) > 0;
		}
		catch (Exception e) {
				}
		return didSucceed;
	}

	public boolean insertTruckCo(board b) {
		boolean didSucceed = false;
		try {
			Long rowId = Long.valueOf(b.getboardid());
			ContentValues updateTrucks = new ContentValues();
			updateTrucks.put("truck", b.getTruckCompany());
			didSucceed = database.update("skateboard", updateTrucks, "_id=" + rowId, null) > 0;
		}
		catch (Exception e) {
				}
		return didSucceed;
	}
	
	public boolean insertContact(board b) {
		boolean didSucceed = false;
		try {
			ContentValues initialValues = new ContentValues();
			initialValues.put("boardChosen", b.getboardName());
	//		initialValues.put("modelName", b.getModelName());
		
			didSucceed = database.insert("skateBoard", null, initialValues) > 0;
		}
		catch (Exception e) {
			//Do nothing will return false if there is an exception
		}
			return didSucceed;
		}
	
	
	public boolean updateWheelModel(board b) {
		boolean didSucceed = false;
		try {
		Long rowId = Long.valueOf(b.getboardid());
		ContentValues updateValues = new ContentValues();
	//	updateValues.put("boardChosen", b.getboardName());
		updateValues.put("WheelModel", b.getWheelsmod());
		didSucceed = database.update("skateBoard", updateValues, "_id=" + rowId, null) > 0;
	}
	catch  (Exception e) {
			//do nothing 
		}
		return didSucceed;
	}
	
	
	public boolean updateGripType(board b) {
		boolean didSucceed = false;
		try {
		Long rowId = Long.valueOf(b.getboardid());
		ContentValues updateValues = new ContentValues();
	//	updateValues.put("boardChosen", b.getboardName());
		updateValues.put("grip", b.getGripest());
		didSucceed = database.update("skateBoard", updateValues, "_id=" + rowId, null) > 0;
	}
	catch  (Exception e) {
			//do nothing 
		}
		return didSucceed;
	}
	
	public boolean updateTruckModel(board b) {
		boolean didSucceed = false;
		try {
		Long rowId = Long.valueOf(b.getboardid());
		ContentValues updateTruckValues = new ContentValues();
	//	updateValues.put("boardChosen", b.getboardName());
		updateTruckValues.put("TruckModel", b.getWheelsmod());
		didSucceed = database.update("skateBoard", updateTruckValues, "_id=" + rowId, null) > 0;
	}
	catch  (Exception e) {
			//do nothing 
		}
		return didSucceed;
	}
	
	
	public boolean updateContact(board b) {
		boolean didSucceed = false;
		try {
		Long rowId = Long.valueOf(b.getboardid());
		ContentValues updateValues = new ContentValues();
	//	updateValues.put("boardChosen", b.getboardName());
		updateValues.put("modelName", b.getModelName());
		didSucceed = database.update("skateBoard", updateValues, "_id=" + rowId, null) > 0;
	}
	catch  (Exception e) {
			//do nothing 
		}
		return didSucceed;
	}
	
	public board getSpecificBoardId(int contactId) {
		board board = new board();
		String query = "SELECT * FROM skateBoard WHERE _id =" + contactId;
			Cursor cursor = database.rawQuery(query, null);
		
		if (cursor.moveToFirst()) {
			board.setContactID(cursor.getInt(0));
			board.setBoardName(cursor.getString(1));
			board.setModelName(cursor.getString(2));
		
			cursor.close();
			
		}
		
		return board;
	}
		
		public board getSpecificBoardIdTwo(int contactId) {
			board board = new board();
			String query = "SELECT * FROM skateBoard WHERE _id =" + contactId;
				Cursor cursor = database.rawQuery(query, null);
			
			if (cursor.moveToFirst()) {
				board.setContactID(cursor.getInt(0));
				board.setBoardName(cursor.getString(1));
				board.setModelName(cursor.getString(2));
				board.setwheelscom(cursor.getString(3));
				board.setwheelsmod(cursor.getString(4));
				cursor.close();
				
			}
			
			return board;
	}
		public board getSpecificBoardIdThree(int contactId) {
			board board = new board();
			String query = "SELECT * FROM skateBoard WHERE _id =" + contactId;
				Cursor cursor = database.rawQuery(query, null);
			
			if (cursor.moveToFirst()) {
				board.setContactID(cursor.getInt(0));
				board.setBoardName(cursor.getString(1));
				board.setModelName(cursor.getString(2));
				board.setwheelscom(cursor.getString(3));
				board.setwheelsmod(cursor.getString(4));
				board.setTruckCompany(cursor.getString(5));
				board.setTruckModel(cursor.getString(6));
				board.setGripest(cursor.getString(7));
				cursor.close();
				
			}
			
			return board;
	}
		
		public ArrayList<String> getBoardSelection() {
			ArrayList<String> BoardSelection = new ArrayList<String>();
			try {
				String query = "SELECT * from skateboard";
				Cursor cursor = database.rawQuery(query, null);
				
				cursor.moveToFirst();
				while(!cursor.isAfterLast()) {
					
				//	newBoard.setContactID(cursor.getInt(0));
					String value = cursor.getString(0);
					String boardName = cursor.getString(1);
					String boardModel = cursor.getString(2);
					String wheel = cursor.getString(3);
					BoardSelection.add(value + " " + boardName + " " + boardModel + " " + wheel);
				//	BoardSelection.add(cursor.getString(0));
					
				//	BoardSelection.add(cursor.getString(0));
				//	BoardSelection.add(cursor.getString(1));
			//		BoardSelection.add(newBoard);
					cursor.moveToNext();
					
					
				}
				cursor.close();
			} catch (Exception e) {
		    	e.printStackTrace();
    }
			return BoardSelection;
				}
					
		
		
		
		
	public int getLastContactId() {
		int lastId = 0;
		try { String query = "Select MAX(_id) from skateBoard";
		Cursor cursor = database.rawQuery(query, null);
		cursor.moveToFirst();
		lastId = cursor.getInt(0);
		cursor.close(); 
		}
		catch (Exception e) {
			lastId = -1; }
		return lastId;
	}
	
	public void Display(){
		
	}

}