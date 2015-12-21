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

public class GripAlert extends DialogFragment {
	
	GripTapeAlert GListener;
	
	public interface GripTapeAlert {
		public void gripConfirmation(int grip);
	}

	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
        	GListener = (GripTapeAlert) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement GripAlert"); 
        }
	}

	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			final View view = inflater.inflate(R.layout.activity_grip_alert, container);
			getDialog().setTitle("Confirmation");
			Button positivity = (Button) view.findViewById(R.id.button102);
			Button negativity = (Button) view.findViewById(R.id.button203);
			
			positivity.setOnClickListener(new OnClickListener() {	
				
			
				@Override
					public void onClick(View v) {
					int x = 1;
					setGrip(x);
				
				}
			});
			negativity.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
				int x = 2;
				
				setGrip(x);
			
			}
			
			});
			
			return view;
	 }

public void setGrip(int Halosed)  {
	GripTapeAlert activity = (GripTapeAlert) getActivity();
	activity.gripConfirmation(Halosed);
	
}
}