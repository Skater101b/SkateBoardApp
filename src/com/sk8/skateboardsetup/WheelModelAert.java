package com.sk8.skateboardsetup;

import com.sk8.skateboardsetup.ModelAlert.modeldAlert;

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

public class WheelModelAert extends DialogFragment {

	WmodeldAlert QListener;
	
	public interface WmodeldAlert {
        public void onWheelModelClicking(int dialog);
     
         }
	
	
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            QListener = (WmodeldAlert) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement WmodeldAlert"); 
        }
	}

	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			final View view = inflater.inflate(R.layout.activity_wheel_model_aert, container);
			getDialog().setTitle("Confirmation");
			Button positived = (Button) view.findViewById(R.id.button10);
			Button negatived = (Button) view.findViewById(R.id.button20);
			
			positived.setOnClickListener(new OnClickListener() {	
				@Override
					public void onClick(View v) {
					int x = 1;
					setWheelModels(x);
				
				}
			});
			negatived.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				int x = 2;
				
				setWheelModels(x);
			
			}
			
			});
			
			return view;
	 }
		 
	 
	 
	 public void setWheelModels(int Halos) {
		 WmodeldAlert activity = (WmodeldAlert) getActivity();
			activity.onWheelModelClicking(Halos);
			
}

}
