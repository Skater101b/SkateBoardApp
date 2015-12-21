package com.sk8.skateboardsetup;

import com.sk8.skateboardsetup.ModelAlert.modeldAlert;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class boardChooser extends DialogFragment implements modeldAlert {
	
	OnBoardChooserListener mCallBack;
	ModelAlert BB = new ModelAlert();
	public int model;
	
	
	
	public interface OnBoardChooserListener {
        public void OnModelSelected(int position);
        
	}
	@Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            
            try{
            	mCallBack = (OnBoardChooserListener) activity;
            	
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString()
                        + " must implement OnHeadlineSelectedListener");
          }
     }
	
	public board currentBoard;
	
	    @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			final View view = inflater.inflate(R.layout.pick_board, container);
			getDialog().setTitle("Choose Board Maker");
			ImageButton one = (ImageButton) view.findViewById(R.id.imageButton1);
			ImageButton two = (ImageButton) view.findViewById(R.id.imageButton2);
			ImageButton three = (ImageButton) view.findViewById(R.id.imageButton3);
			
			
			one.setOnClickListener(new OnClickListener() {	
			@Override
				public void onClick(View v) {
				try {
				 setModel(1);
				 FragmentManager fm = getChildFragmentManager();	
				 BB.show(fm, "modelAlert");
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
				    	setModel(2);
				    	 FragmentManager fm = getChildFragmentManager();	
						 BB.show(fm, "modelAlert");
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
						 setModel(3);
						 FragmentManager fm = getChildFragmentManager();	
						 BB.show(fm, "modelAlert");
					//	 mCallBack.OnModelSelected(3);
						} catch (Exception e) {
							//fail
						}
						 
					}
						});
			
			
			 return view;		
		
	}

		@Override
		public void onModelClick(int dialog) {
				mCallBack.OnModelSelected(getModel());
			}
		
		
		public void setModel(int num) {
			model = num;
			
			
		}
		
		public int getModel(){
			return model;
		}
	   
	   
		
			
	    }
