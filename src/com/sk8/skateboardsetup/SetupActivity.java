package com.sk8.skateboardsetup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class SetupActivity extends FragmentActivity implements boardChooser.OnBoardChooserListener, BoardalertMainActivity.boardAlert, ModelAlert.modeldAlert {
	
	public board currentBoard;
	BoardalertMainActivity BC = new BoardalertMainActivity();
	boardChooser BA = new boardChooser();
	
	int ids;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setup);
		Flip();
		Baker();
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			initContact(extras.getInt("contactid"));
		}
		else {
			currentBoard = new board();
		}
		
		
	}

				
				
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.setup, menu);
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
	
	void Flip(){
		final ImageButton flip = (ImageButton) findViewById(R.id.flip);
		flip.setOnClickListener(new View.OnClickListener() {
		String Type = "Flip";	
				@Override
				public void onClick (View v) {
				//	alert.show();
					currentBoard.setboardChosen(Type);
					skateboardDataSource SDC = new skateboardDataSource(SetupActivity.this);
					SDC.open();
					boolean wasSuccessful = false;
				//	if (currentBoard.getboardid()==-1) {
						wasSuccessful = SDC.insertContact(currentBoard);
						int newId = SDC.getLastContactId();
						currentBoard.setContactID(newId);
					
		
					SDC.close();
					
					FragmentManager fm = getSupportFragmentManager();		
				//	BoardalertMainActivity BC = new BoardalertMainActivity();
					BC.show(fm, "BoardAlert");
					
				}
			});
			
		}
	
	
		

	void Baker(){
		final ImageButton baker = (ImageButton) findViewById(R.id.baker);
		baker.setOnClickListener(new View.OnClickListener() {
		String Type = "Baker";	
				@Override
				public void onClick (View v) {	
					currentBoard.setboardChosen(Type);
					skateboardDataSource SDC = new skateboardDataSource(SetupActivity.this);
					SDC.open();
					boolean wasSuccessful = false;
				//	if (currentBoard.getboardid()==-1) {
						wasSuccessful = SDC.insertContact(currentBoard);
						int newId = SDC.getLastContactId();
						currentBoard.setContactID(newId);
					
		
					SDC.close();
					
					FragmentManager fm = getSupportFragmentManager();		
				//	BoardalertMainActivity BC = new BoardalertMainActivity();
					BC.show(fm, "BoardAlert");
					
				}
			});
			
		}


	@Override
	public void OnModelSelected(int position) {
		skateboardDataSource Smodel = new skateboardDataSource(SetupActivity.this);
		
		if (position == 1) {
			String boardModel = "Appleyard";
			Smodel.open();
			currentBoard.setModelChosen(boardModel);
			Smodel.updateContact(currentBoard);
			changeIntent();
		} 
		else { //do something like update contact }
			
		}
		if (position == 2) {
			String boardModel = "Arto";
			currentBoard.setModelChosen(boardModel);
			Smodel.open();
			Smodel.updateContact(currentBoard);
			
			changeIntent();
		//	int newId = Smodel.getLastContactId();
		//	currentBoard.setContactID(newId);
		} 
		else { //do something like update contact }
			
		}
		if (position == 3) {
			String boardModel = "Penny";
			currentBoard.setModelChosen(boardModel);
			Smodel.open();
			Smodel.updateContact(currentBoard);
			
		changeIntent();
		} 
		else { //do something like update contact }
			
		}
		if (position == 4) {
			String boardModel = "sex";
			currentBoard.setModelChosen(boardModel);
			Smodel.open();
			Smodel.updateContact(currentBoard);
			
			changeIntent();
		} 
		else { //do something like update contact }
			
		}
		Smodel.close();
	}
	
	
	public void changeIntent() {
		int selectedBoard = currentBoard.getboardid();
		Intent intent = new Intent(SetupActivity.this, WheelMainActivity.class);
		intent.putExtra("contactid", selectedBoard);
		startActivity(intent);
		
	}
	
	private void initContact(int contactid) {
		skateboardDataSource ds = new skateboardDataSource(SetupActivity.this);
		ds.open();
		currentBoard = ds.getSpecificBoardId(contactid);
		ds.close();
		
		
		 
	}



	@Override
	public void onDialogClick(int dialog) {
		int check = dialog;
		if (check == 1) {
			FragmentManager fm = getSupportFragmentManager();		
		//	boardChooser BA = new boardChooser();
			BA.show(fm, "BoardPick");
		}
			
		if (check == 2) {
			
			// need to get the last board I submitted and delete it.
			BC.dismiss();
			
		}
		
	}
	@Override
	public void onModelClick(int dialog) {
		if (dialog == 1) {
		BA.onModelClick(1);
		}
		if (dialog == 2) {
			BA.BB.dismiss();
		}
		
	}
	
		
	}
	
	

	
	
	


	

	

