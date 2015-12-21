package com.sk8.skateboardsetup;





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

public class TruckAlert extends DialogFragment {
	
TruckCoAlert truckListener;

	
	public interface TruckCoAlert {
		public void TruckConfirmation(int Truck);
	}
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
        	truckListener = (TruckCoAlert) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement truckListener"); 
        }
	}
	
	
	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			final View view = inflater.inflate(R.layout.activity_truck_alert, container);
			getDialog().setTitle("Confirmation");
			Button positives = (Button) view.findViewById(R.id.button4);
			Button negatives = (Button) view.findViewById(R.id.button5);
			
			positives.setOnClickListener(new OnClickListener() {	
				
			
				@Override
					public void onClick(View v) {
					int x = 1;
					setTruck(x);
				
				}
			});
			negatives.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				int x = 2;
				
				setTruck(x);
			
			}
			
			});
			
			return view;
	 }

public void setTruck(int Haloss)  {
	TruckCoAlert activity = (TruckCoAlert) getActivity();
	activity.TruckConfirmation(Haloss);
	
}
}