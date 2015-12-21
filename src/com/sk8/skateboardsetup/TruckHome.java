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
import android.widget.ImageView;
import android.widget.TextView;

public class TruckHome extends ActionBarActivity implements TruckAlert.TruckCoAlert, TruckChooser.TruckModelChooser, TruckModelAlert.truckModelAlert {
	public board Trucks;
	skateboardDataSource TB = new skateboardDataSource(TruckHome.this);
	public board Tboard;
	TruckChooser Tchoose = new TruckChooser();
	TruckAlert TA = new TruckAlert();
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_truck_home);
	//	interchange();
		
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			initContact(extras.getInt("contactid"));
		}
		else {
			Trucks = new board();
		}
		Fury();
		
		
	}
		
	
	

	/**
	public void interchange(){
		
		Button check = (Button) findViewById(R.id.check);
		final TextView textView = (TextView) findViewById(R.id.testresults);
		check.setOnClickListener(new View.OnClickListener() {
		
			
			@Override
				public void onClick(View v) {
				skateboardDataSource ds = new skateboardDataSource(TruckHome.this);
				ds.open();
			
			    int newId = ds.getLastContactId();
			    Trucks.setContactID(newId);
			    Trucks = ds.getSpecificBoardIdTwo(newId);
			    
			    
				textView.setText(Trucks.getboardName() + Trucks.getModelName() + Trucks.getWheelscom() + Trucks.getWheelsmod());
				
				
			}
		});
	}
	
	**/
	
	void Fury(){
		final ImageButton fury = (ImageButton) findViewById(R.id.fury);
		fury.setOnClickListener(new View.OnClickListener() {
		String truck = "fury";	
				@Override
				public void onClick (View v) {
					Tboard.setTruckCompany(truck);
					
					FragmentManager fm = getSupportFragmentManager();		
					TA.show(fm, "TruckAlert");	
					}
					});
					
				}
				
					////  create object to set truck to and set it. Then open db and put it in at the same id as before.
					
					
					
				//	alert.show();
			//		currentBoard.setboardChosen(Type);
			//		skateboardDataSource SDC = new skateboardDataSource(SetupActivity.this);
			//		SDC.open();
			//		boolean wasSuccessful = false;
				//	if (currentBoard.getboardid()==-1) {
			//			wasSuccessful = SDC.insertContact(currentBoard);
			//			int newId = SDC.getLastContactId();
			//			currentBoard.setContactID(newId);
					
		
			//		SDC.close();
					
			//		FragmentManager fm = getSupportFragmentManager();		
				//	BoardalertMainActivity BC = new BoardalertMainActivity();
			//		BC.show(fm, "BoardAlert");
			//		
	//			}
	//		});
			
	//	}
	
	public void initContact(int id) {
		TB.open();
		Tboard = TB.getSpecificBoardId(id);
		TB.close();
		
	}




	@Override
	public void TruckConfirmation(int Truck) {
		if (Truck == 1) {
			boolean wasSuccessful = false;
		//	int newId1 = WCB.getLastContactId();
	//		Cboard.setContactID(newId1);
			TB.open();
			wasSuccessful = TB.insertTruckCo(Tboard);
			TB.close();
			
			//Method to save wheel company
			//method to pop up wheel fragment.
			
		//	Pop up wheel chooser on yes
			
			FragmentManager fm = getSupportFragmentManager();		
			Tchoose.show(fm, "TruckChooser");	
			
		}
		if (Truck == 2) {
			Tchoose.dismiss();
		}
		
	}




	@Override
	public void onTruckModelSelected(int dialog) {
		if (dialog == 1) {
			Tchoose.onTruckModelSelected(1);
		}
		if (dialog == 2) {
			Tchoose.TMA.dismiss();
		}
		
	}
	
	
	
	public void onTruckModel(int position) {
		skateboardDataSource TTruck = new skateboardDataSource(TruckHome.this);
	
	if (position == 1) {
		String WheelBrand = "fury1";
		TTruck.open();
		Tboard.setwheelsmod(WheelBrand);
		TTruck.updateWheelModel(Tboard);
		changeIntent();
	} 
	else { //do something like update contact }
		
	}
	if (position == 2) {
		String TruckBrand = "fury2";
		Tboard.setwheelsmod(TruckBrand);
		TTruck.open();
		TTruck.updateWheelModel(Tboard);
		changeIntent();
	//	int newId = Smodel.getLastContactId();
	//	currentBoard.setContactID(newId);
	} 
	else { //do something like update contact }
		
	}
	if (position == 3) {
		String TruckBrand = "fury3";
		Tboard.setwheelsmod(TruckBrand);
		TTruck.open();
		TTruck.updateWheelModel(Tboard);
	changeIntent();
	} 
	else { //do something like update contact }
		
	}
	if (position == 4) {
		String TruckBrand = "fury4";
		Tboard.setwheelsmod(TruckBrand);
		TTruck.open();
		TTruck.updateWheelModel(Tboard);
		changeIntent();
	} 
	else { //do something like update contact }
		
	}
	TTruck.close();
}

	public void changeIntent() {
		int selectedBoard = Tboard.getboardid();
		Intent intent = new Intent(TruckHome.this, Gripsetup.class);
		intent.putExtra("contactid", selectedBoard);
		startActivity(intent);
		
	
	
}
}	



	