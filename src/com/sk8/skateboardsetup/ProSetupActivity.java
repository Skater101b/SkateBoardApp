package com.sk8.skateboardsetup;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


public class ProSetupActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro_setup);
		Reynolds();
		Malto();
		Mikey();
		Sheckler();
		prod();
		cole();
		nyjah();
		appleyard();
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pro_setup, menu);
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
	
	void Reynolds() {
		Button Reynolds = (Button) findViewById(R.id.andrewReynolds);
		Reynolds.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=-4fMAmNlSfo")));
				Log.i("Video", "Video Playing....");

	    }
	}); 
	}
	void Malto() {
		Button shawnMalto = (Button) findViewById(R.id.shawnMalto);
		shawnMalto.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=-4fMAmNlSfo")));
				Log.i("Video", "Video Playing....");

	    }
	}); 
	}
	
	void appleyard(){
		Button appleyard = (Button) findViewById(R.id.appleyard);
		appleyard.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=zfcuauBNafc")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
	void nyjah(){
		Button nyjah = (Button) findViewById(R.id.nyjah);
		nyjah.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=PuhIGL-_2Xs")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
	void cole(){
		Button cole = (Button) findViewById(R.id.cole);
		cole.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=VNNQg45PEEQ")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
	void prod(){
		Button prod = (Button) findViewById(R.id.prod);
		prod.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=ltFG5VthZmI")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
	void Sheckler(){
		Button Sheckler = (Button) findViewById(R.id.Sheckler);
		Sheckler.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=uE4b1kP_Dpc")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
	
	void Mikey(){
		Button Mikey = (Button) findViewById(R.id.Mikey);
		Mikey.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=Wgal1qhZJgk")));
				Log.i("Video", "Video Playing....");
	}
	});
	}
	
}

	   
