package com.sk8.skateboardsetup;

import com.sk8.skateboardsetup.boardChooser.OnBoardChooserListener;

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

public class WheelChooser extends DialogFragment implements WheelModelAert.WmodeldAlert {
	WheelModelAert WMA = new WheelModelAert();
	wheelmodelChooser MCallBack;
	public int Wheel;
	
	public interface wheelmodelChooser {
        public void OnWheelSelected(int position);
        
	}
	@Override
	public void onAttach(Activity activity) {
            super.onAttach(activity);
            
            try{
            	MCallBack = (wheelmodelChooser) activity;
            	
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement wheelmodelChooser");
          }
     }
	
	public board Cboard;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_wheel_chooser, container);
		getDialog().setTitle("Choose Board Maker");
		ImageButton one = (ImageButton) view.findViewById(R.id.imageButton1);
		ImageButton two = (ImageButton) view.findViewById(R.id.imageButton2);
		ImageButton three = (ImageButton) view.findViewById(R.id.imageButton3);
		
		
		one.setOnClickListener(new OnClickListener() {	
		@Override
			public void onClick(View v) {
			try {
			 setwheel(1);
			 FragmentManager fm = getChildFragmentManager();	
			 WMA.show(fm, "WheelmodelAlert");
			// mCallBack.OnModelSelected(1);
			} catch (Exception e) {
				//fail
			}
			 
		}
			});
		two.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
			   
			    try {
			    	setwheel(2);
			    	 FragmentManager fm = getChildFragmentManager();	
				     WMA.show(fm, "WheelmodelAlert");
				//	 mCallBack.OnModelSelected(2);
					} catch (Exception e) {
						//fail
					}
					}
					 
				
					});
		three.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					 setwheel(3);
					 FragmentManager fm = getChildFragmentManager();	
					 WMA.show(fm, "modelAlert");
				//	 mCallBack.WheelmodelAlert(3);
					} catch (Exception e) {
						//fail
					}
					 
				}
					});
		
		
		 return view;		
	
}

	
/// Listener Method from next dialog before saving board
	
	
	public void setwheel(int num) {
		Wheel = num;
		
		
	}
	
	public int getModel(){
		return Wheel;
	}


	@Override
	public void onWheelModelClicking(int dialog) {
		// TODO Auto-generated method stub
		MCallBack.OnWheelSelected(Wheel);
	}


   
   
	
		
    }