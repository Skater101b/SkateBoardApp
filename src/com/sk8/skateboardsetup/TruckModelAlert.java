package com.sk8.skateboardsetup;

import com.sk8.skateboardsetup.WheelModelAert.WmodeldAlert;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TruckModelAlert extends DialogFragment {
	
truckModelAlert TMListener;

public interface truckModelAlert {
    public void onTruckModelSelected(int dialog);
 
     }
public void onAttach(Activity activity) {
    super.onAttach(activity);
    try {
        // Instantiate the NoticeDialogListener so we can send events to the host
    	TMListener = (truckModelAlert) activity;
    } catch (ClassCastException e) {
        // The activity doesn't implement the interface, throw exception
        throw new ClassCastException(activity.toString()
                + " must implement truckModelAlert"); 
    }
}

public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	final View view = inflater.inflate(R.layout.activity_truck_model_alert, container);
	getDialog().setTitle("Confirmation");
	Button positived1 = (Button) view.findViewById(R.id.buttonpros);
	Button negatived2 = (Button) view.findViewById(R.id.buttonneg);
	
	positived1.setOnClickListener(new OnClickListener() {	
		@Override
			public void onClick(View v) {
			int x = 1;
			setTM(x);
		
		}
	});
	negatived2.setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
		int x = 2;
		
		setTM(x);
	
	}
	
	});
	
	return view;
}
 


public void setTM(int Halos) {
	truckModelAlert activity = (truckModelAlert) getActivity();
	activity.onTruckModelSelected(Halos);
	
}

}
