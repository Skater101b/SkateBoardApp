package com.sk8.skateboardsetup;





import android.support.v4.app.DialogFragment;
import android.text.format.Time;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class BoardalertMainActivity extends DialogFragment {
	boardAlert mListener;
	
	public interface boardAlert {
        public void onDialogClick(int dialog);
     
        
    }
	
	
	@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mListener = (boardAlert) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener"); 
        }
	}

	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			final View view = inflater.inflate(R.layout.boardalert_main, container);
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
		 
	 
	 
	 public void setResults(int Halo) {
		 int z = Halo;
		 boardAlert activity = (boardAlert) getActivity();
			activity.onDialogClick(z);
			
}
}
