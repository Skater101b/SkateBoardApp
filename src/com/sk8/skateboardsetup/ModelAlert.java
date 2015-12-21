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

public class ModelAlert extends DialogFragment {
	
		modeldAlert bListener;
		
		public interface modeldAlert {
	        public void onModelClick(int dialog);
	     
	         }
		
		
		public void onAttach(Activity activity) {
	        super.onAttach(activity);
	        try {
	            // Instantiate the NoticeDialogListener so we can send events to the host
	            bListener = (modeldAlert) activity;
	        } catch (ClassCastException e) {
	            // The activity doesn't implement the interface, throw exception
	            throw new ClassCastException(activity.toString()
	                    + " must implement modeldAlert"); 
	        }
		}

		 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
				final View view = inflater.inflate(R.layout.activity_model_alert, container);
				getDialog().setTitle("Confirmation");
				Button positive = (Button) view.findViewById(R.id.button1);
				Button negative = (Button) view.findViewById(R.id.button2);
				
				positive.setOnClickListener(new OnClickListener() {	
					@Override
						public void onClick(View v) {
						int x = 1;
						setResults(x);
					
					}
				});
				negative.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
					int x = 2;
					
					setResults(x);
				
				}
				
				});
				
				return view;
		 }
			 
		 
		 
		 public void setResults(int Halos) {
			 modeldAlert activity = (modeldAlert) getActivity();
				activity.onModelClick(Halos);
				
	}
	}

