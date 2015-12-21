package com.sk8.skateboardsetup;



import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class WheelMainActivity extends ActionBarActivity implements WheelCoAlert.wheelAlert, WheelChooser.wheelmodelChooser, WheelModelAert.WmodeldAlert {
	
	WheelChooser WMA = new WheelChooser();
	WheelCoAlert WC = new WheelCoAlert();
	skateboardDataSource WCB = new skateboardDataSource(WheelMainActivity.this);
	public board Cboard;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wheel_main);
	
		
		
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			initContact(extras.getInt("contactid"));
		}
		else {
			Cboard = new board();
		}
		spitFire();
		
	}
	
	public void spitFire() {
	   final ImageButton spitFire = (ImageButton) findViewById(R.id.spitFire);
		spitFire.setOnClickListener(new OnClickListener() {
			String wheel = "Spitfires";
		@Override
		public void onClick(View v) {
			Cboard.setwheelscom(wheel);
			//skateboardDataSource WCBS = new skateboardDataSource(WheelMainActivity.this);
		//	WCBS.open();
			
		FragmentManager fm = getSupportFragmentManager();		
		WC.show(fm, "wheelAlert");	
		}
		});
		
	}
	
	@Override
	public void OnWheelSelected(int position) {
		skateboardDataSource SWheel = new skateboardDataSource(WheelMainActivity.this);
		
		if (position == 1) {
			String WheelBrand = "SomeWheel";
			SWheel.open();
			Cboard.setwheelsmod(WheelBrand);
			SWheel.updateWheelModel(Cboard);
			changeIntent();
		} 
		else { //do something like update contact }
			
		}
		if (position == 2) {
			String WheelBrand = "SomeOtherwheel";
			Cboard.setwheelsmod(WheelBrand);
			SWheel.open();
			SWheel.updateWheelModel(Cboard);
			changeIntent();
		//	int newId = Smodel.getLastContactId();
		//	currentBoard.setContactID(newId);
		} 
		else { //do something like update contact }
			
		}
		if (position == 3) {
			String WheelBrand = "SomeOtherWheelAgain";
			Cboard.setwheelsmod(WheelBrand);
			SWheel.open();
			SWheel.updateWheelModel(Cboard);
		changeIntent();
		} 
		else { //do something like update contact }
			
		}
		if (position == 4) {
			String WheelBrand = "DeathWheel";
			Cboard.setwheelsmod(WheelBrand);
			SWheel.open();
			SWheel.updateWheelModel(Cboard);
			changeIntent();
		} 
		else { //do something like update contact }
			
		}
		SWheel.close();
	}
	
	
	public void changeIntent() {
		int selectedBoard = Cboard.getboardid();
		Intent intent = new Intent(WheelMainActivity.this, TruckHome.class);
		intent.putExtra("contactid", selectedBoard);
		startActivity(intent);
		
	}
	
	
	
	//This method is for chaing the contentview and pulling board from the database. 
	
	
/**	public void interchange(){
		
		Button ch = (Button) findViewById(R.id.check);
		final TextView textView = (TextView) findViewById(R.id.testresults);
		ch.setOnClickListener(new OnClickListener() {	
			@Override
				public void onClick(View v) {
				skateboardDataSource ds = new skateboardDataSource(WheelMainActivity.this);
				ds.open();
			
			   int newId = ds.getLastContactId();
				Cboard.setContactID(newId);
				Cboard = ds.getSpecificBoardId(ds.getLastContactId());
				textView.setText(Cboard.getboardName() + Cboard.getModelName());
				
				
			}
		});
	}
		**/
	
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.grip_main, menu);
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

	@Override
	public void wheelConfirmation(int wheel) {
		if (wheel == 1) {
			boolean wasSuccessful = false;
		//	int newId1 = WCB.getLastContactId();
	//		Cboard.setContactID(newId1);
			WCB.open();
			wasSuccessful = WCB.insertWheelco(Cboard);
			WCB.close();
			
			//Method to save wheel company
			//method to pop up wheel fragment.
			
		//	Pop up wheel chooser on yes
			
			FragmentManager fm = getSupportFragmentManager();		
			WMA.show(fm, "WheelChooser");	
			
		}
		if (wheel == 2) {
			WC.dismiss();
		}
		
	}

	@Override
	public void onWheelModelClicking(int dialog) {
		// TODO Auto-generated method stub
		if (dialog == 1) {
			WMA.onWheelModelClicking(1);
		}
		if (dialog == 2) {
			WMA.WMA.dismiss();
		}
		
	}

	
	public void initContact(int id) {
		WCB.open();
		Cboard = WCB.getSpecificBoardId(id);
		WCB.close();
		
	}
		
		
	


}
