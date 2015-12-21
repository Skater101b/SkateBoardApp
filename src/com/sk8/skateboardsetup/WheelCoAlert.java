package com.sk8.skateboardsetup;

import com.sk8.skateboardsetup.BoardalertMainActivity.boardAlert;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Build;

public class WheelCoAlert extends DialogFragment {

	wheelAlert wListener;
	
	public interface wheelAlert {
		public void wheelConfirmation(int wheel);
	}
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            wListener = (wheelAlert) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement wheelAlert"); 
        }
	}
		 @Override
		    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
				final View view = inflater.inflate(R.layout.wheel_co_alert, container);
				getDialog().setTitle("Confirmation");
				Button positives = (Button) view.findViewById(R.id.button3);
				Button negatives = (Button) view.findViewById(R.id.button4);
				
				positives.setOnClickListener(new OnClickListener() {	
					
				
					@Override
						public void onClick(View v) {
						int x = 1;
						setwheel(x);
					
					}
				});
				negatives.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					int x = 2;
					
					setwheel(x);
				
				}
				
				});
				
				return view;
		 }

public void setwheel(int Halos)  {
	 wheelAlert activity = (wheelAlert) getActivity();
		activity.wheelConfirmation(Halos);
		
}
}
