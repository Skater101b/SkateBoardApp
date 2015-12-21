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

public class GripTypeAlert extends DialogFragment {

GripTypeAlerting GripTypeListener;
	
	public interface GripTypeAlerting {
        public void onGripType(int dialog);
     
         }
	
	
	public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
        	GripTypeListener = (GripTypeAlerting) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement GripTypeAlerting"); 
        }
	}
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_grip_type_alert, container);
		getDialog().setTitle("Confirmation");
		Button positived = (Button) view.findViewById(R.id.button1022);
		Button negatived = (Button) view.findViewById(R.id.button2032);
		
		positived.setOnClickListener(new OnClickListener() {	
			@Override
				public void onClick(View v) {
				int x = 1;
				setGripType(x);
			
			}
		});
		negatived.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
			int x = 2;
			
			setGripType(x);
		
		}
		
		});
		
		return view;
 }
	 
 
 
 public void setGripType(int Halos) {
	 GripTypeAlerting activity = (GripTypeAlerting) getActivity();
		activity.onGripType(Halos);
		
}

}
