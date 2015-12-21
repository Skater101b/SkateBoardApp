package com.sk8.skateboardsetup;



import com.sk8.skateboardsetup.WheelChooser.wheelmodelChooser;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TruckChooser extends DialogFragment implements TruckModelAlert.truckModelAlert {
	TruckModelAlert TMA = new TruckModelAlert();
	TruckModelChooser TCallBack;
	public int Truckmodel;
	private Animator mCurrentAnimator;  // save a spot for this
	private int mShortAnimationDuration; // save a spot for this
	public interface TruckModelChooser {
        public void onTruckModel(int position);
        
	}
	
	@Override
	public void onAttach(Activity activity) {
            super.onAttach(activity);
            
            try{
            	TCallBack = (TruckModelChooser) activity;
            	
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement TruckModelChooser");
          }
     }
	

	

	
public board Tboard;
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final View view = inflater.inflate(R.layout.activity_truck_chooser, container);
		getDialog().setTitle("Choose Board Maker");
		final ImageButton six = (ImageButton) view.findViewById(R.id.imageButton111);
		ImageButton seven = (ImageButton) view.findViewById(R.id.imageButton211);
		ImageButton eight = (ImageButton) view.findViewById(R.id.imageButton311);
		
		
		
		six.setOnClickListener(new OnClickListener() {	
		@Override
			public void onClick(View v) {
			try {
			setTruck(1);
			 FragmentManager fm = getChildFragmentManager();	
			 TMA.show(fm, "TruckModelAlert");
			// mCallBack.OnModelSelected(1);
			} catch (Exception e) {
				//fail
			}
			 
		}
			});
		seven.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
			   
			    try {
			    	setTruck(2);
			    	 FragmentManager fm = getChildFragmentManager();	
				     TMA.show(fm, "TruckModelAlert");
				//	 mCallBack.OnModelSelected(2);
					} catch (Exception e) {
						//fail
					}
					}
					 
				
					});
		eight.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				try {
					setTruck(3);
					 FragmentManager fm = getChildFragmentManager();	
					 TMA.show(fm, "TruckModelAlert");
				//	 mCallBack.WheelmodelAlert(3);
					} catch (Exception e) {
						//fail
					}
					 
				}
					});
		
		
		 return view;		
	
}
    

    
    public void setTruck(int truck) {
    		Truckmodel = truck;
    }
    
    public int getTruckModel(){
		return Truckmodel;
	}

	@Override
	public void onTruckModelSelected(int dialog) {
		// TODO Auto-generated method stub
		TCallBack.onTruckModel(Truckmodel);
	}
	
		
    }

	