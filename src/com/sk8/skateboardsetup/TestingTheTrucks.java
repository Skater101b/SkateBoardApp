package com.sk8.skateboardsetup;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class TestingTheTrucks extends ActionBarActivity {
	public board Displayboard;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testing_the_trucks);
		interchange();
		seeBoards();
		checkin1();
		proTweet2();
		proCheckOu1t();
		createYourOwn1();
		altBoards();
		Bundle extras = getIntent().getExtras();
		if(extras != null) {
			initContact(extras.getInt("contactid"));
		}
		
		else {
			Displayboard = new board();
		}
		
		
	}
		
		
	private void createYourOwn1() {
		ImageButton create1 = (ImageButton) findViewById(R.id.createboard);
		create1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, SetupActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}
	
	private void proCheckOu1t() {
		ImageButton proCheck1 = (ImageButton) findViewById(R.id.checkoutprosetup);
		proCheck1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, ProSetupActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}
	
	private void proTweet2() {
		ImageButton tweet2 = (ImageButton) findViewById(R.id.checkouttwitter);
		tweet2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, TwitterMain.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}

	private void checkin1() {
		ImageButton checkin = (ImageButton) findViewById(R.id.checkinskatespot);
		checkin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, Checkin.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}
	
	private void seeBoards() {
		ImageButton boardlist = (ImageButton) findViewById(R.id.checkoutboards);
		boardlist.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, BoardFinishList.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}
	
	
	private void altBoards() {
		ImageButton boardlist = (ImageButton) findViewById(R.id.altBoards);
		boardlist.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(TestingTheTrucks.this, Altboardsetup.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	}
	
	
public void interchange(){
		
//		Button check = (Button) findViewById(R.id.check);
//		final TextView textView = (TextView) findViewById(R.id.testresults);
//		check.setOnClickListener(new View.OnClickListener() {
		
			
	//		@Override
	//			public void onClick(View v) {
			//	skateboardDataSource dssss = new skateboardDataSource(TestingTheTrucks.this);
			//	dssss.open();
			
			//    int newId = dssss.getLastContactId();
			 //   Displayboard.setContactID(newId);
			//    Displayboard = dssss.getSpecificBoardIdThree(Displayboard.getboardid());
			//    dssss.close();
			    
			    
//				textView.setText(Displayboard.getboardName() + Displayboard.getModelName() + Displayboard.getWheelscom() + Displayboard.getWheelsmod() + Displayboard.getTruckCompany() + Displayboard.getTruckModel() + Displayboard.getGripest());
				
				
		//	}
//		});
	}
		
private void initContact(int contactid) {
	skateboardDataSource dsss = new skateboardDataSource(TestingTheTrucks.this);
	dsss.open();
	Displayboard = dsss.getSpecificBoardIdThree(contactid);
	dsss.close();
	
	
	 
}
	
	
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.testing_the_trucks, menu);
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
}
