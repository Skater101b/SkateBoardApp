package com.sk8.skateboardsetup;





import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Gripsetup extends ActionBarActivity implements GripAlert.GripTapeAlert, GripTypeAlert.GripTypeAlerting, GripChooser.GripTypeChooser {
	public board GripBoard;
	GripChooser GripChoose = new GripChooser();
	GripTypeAlert GTA = new GripTypeAlert();
	GripAlert GA = new GripAlert();
	skateboardDataSource TG = new skateboardDataSource(Gripsetup.this);
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_grip_setup);
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			initContact(extras.getInt("contactid"));
		}
		else {
			GripBoard = new board();
		}
		GripTape();
		
		
	}
		
	void GripTape(){
		final Button grip = (Button) findViewById(R.id.gripButton1);
		grip.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick (View v) {
					
				//	FragmentManager fm = getSupportFragmentManager();		
				//	GripChoose.show(fm, "GripChooser");	
					
					FragmentManager fm = getSupportFragmentManager();		
					GA.show(fm, "GripAlert");	
					}
					});
					
				}
	
	
	public void initContact(int id) {
		TG.open();
		GripBoard = TG.getSpecificBoardIdThree(id);
		TG.close();
		
	}
		

	@Override
	public void gripConfirmation(int grip) {
		if (grip == 1) {
			
			
			FragmentManager fm = getSupportFragmentManager();		
			GripChoose.show(fm, "GripChooser");	
			
		}
		if (grip == 2) {
			GA.dismiss();
		}
		
	}

	@Override
	public void onGripType(int dialog) {
		
		if (dialog == 1) {
			GripChoose.onGripType(1);
		}
		if (dialog == 2) {
			GripChoose.GripAlerts.dismiss();
		}
		
	}
		
		
	

public void changeIntent() {
	int lastBoard = GripBoard.getboardid();
	Intent intent = new Intent(Gripsetup.this, TestingTheTrucks.class);
	intent.putExtra("contactid", lastBoard);
	startActivity(intent);
		
	}

@Override
public void OnGripSelected(int position) {
	skateboardDataSource gripInput = new skateboardDataSource(Gripsetup.this);
	
	if (position == 1) {
		String Grip = "Cool";
		GripBoard.setGripest(Grip);
		gripInput.open();
		gripInput.updateGripType(GripBoard);
	//	Tboard.setwheelsmod(WheelBrand);
	//	TTruck.updateWheelModel(Tboard);
		changeIntent();
	} 
	else { //do something like update contact }
		
	}
	if (position == 2) {
		String Grip = "Cooler";
		GripBoard.setGripest(Grip);
		gripInput.open();
		gripInput.updateGripType(GripBoard);
	//	TTruck.updateWheelModel(Tboard);
		changeIntent();
	//	int newId = Smodel.getLastContactId();
	//	currentBoard.setContactID(newId);
	} 
	else { //do something like update contact }
		
	}
	if (position == 3) {
		String Grip = "Coolest";
		GripBoard.setGripest(Grip);
		gripInput.updateGripType(GripBoard);
	//	gripInput.open();
	//	TTruck.updateWheelModel(Tboard);
	changeIntent();
	} 
	else { //do something like update contact }
		
	}
	if (position == 4) {
		String Grip = "CoolestYet";
		GripBoard.setGripest(Grip);
		gripInput.open();
		gripInput.updateGripType(GripBoard);
	//	TTruck.updateWheelModel(Tboard);
		changeIntent();
	} 
	else { //do something like update contact }
		
	}
	gripInput.close();
}
	
}

