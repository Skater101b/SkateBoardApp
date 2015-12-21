package com.sk8.skateboardsetup;



import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

public class GripChooser extends DialogFragment implements GripTypeAlert.GripTypeAlerting {
	
	GripTypeAlert GripAlerts = new GripTypeAlert();
	
	GripTypeChooser GTCCallBack;
	
	public int gripType;
	
	public interface GripTypeChooser {
        public void OnGripSelected(int position);
        
	}
	@Override
	public void onAttach(Activity activity) {
            super.onAttach(activity);
            
            try{
            	GTCCallBack = (GripTypeChooser) activity;
            	
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement GripTypeChooser");
          }
     }
	
	
	
//public board Tboard;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_grip_chooser, container);
		getDialog().setTitle("Grip Type");
		final ImageButton sixy = (ImageButton) view.findViewById(R.id.imageButton1);
		ImageButton seveny = (ImageButton) view.findViewById(R.id.imageButton2);
		ImageButton eighty = (ImageButton) view.findViewById(R.id.imageButton3);
		
		
		
		sixy.setOnClickListener(new OnClickListener() {	
		@Override
			public void onClick(View v) {
			try {
			setGrips(1);
			 FragmentManager fm = getChildFragmentManager();	
			 GripAlerts.show(fm, "GripTypeAlert");
			// mCallBack.OnModelSelected(1);
			} catch (Exception e) {
				//fail
			}
			 
		}
			});
		seveny.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
			   
			    try {
			    	setGrips(2);
			    	 FragmentManager fm = getChildFragmentManager();	
			    	 GripAlerts.show(fm, "GripTypeAlert");
				//	 mCallBack.OnModelSelected(2);
					} catch (Exception e) {
						//fail
					}
					}
					 
				
					});
		eighty.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					setGrips(3);
					 FragmentManager fm = getChildFragmentManager();	
					 GripAlerts.show(fm, "GripTypeAlert");
				//	 mCallBack.WheelmodelAlert(3);
					} catch (Exception e) {
						//fail
					}
					 
				}
					});
		
		
		 return view;		
	
}
    

    
    public void setGrips(int grip) {
    	gripType = grip;
    }
    
    public int getGrips(){
		return gripType;
	}


	@Override
	public void onGripType(int dialog) {
		// TODO Auto-generated method stub
		GTCCallBack.OnGripSelected(gripType);
	}
	
		
    }
