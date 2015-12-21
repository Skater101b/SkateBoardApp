package com.sk8.skateboardsetup;

import java.util.List;



import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import android.app.Activity;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class TwitterMain extends Activity {
	TextView textViewCountChars, textViewTimeline;
	EditText editTextTweet, editTextUsername;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_twitter_main);
		editTextTweet = (EditText) findViewById(R.id.editTextTweet);
		editTextTweet.addTextChangedListener(new MyTextWatcher());
		textViewCountChars = (TextView) findViewById(R.id.textViewCountChars);
		editTextUsername = (EditText) findViewById(R.id.editTextUsername);
		textViewTimeline = (TextView) findViewById(R.id.textViewTimeline);
		textViewTimeline.setMovementMethod(new ScrollingMovementMethod());
		
		
	}
	// button click listeners
	
	public void onTweetButtonClick(View view) {
		new MyAsyncTaskTweet().execute(editTextTweet.getText().toString());
		
	}
	
	public void onTimelineButtonClick(View view) {
		new MyAsyncTaskTimeline().execute(editTextUsername.getText().toString());
	}

	class MyTextWatcher implements TextWatcher {
		@Override
		public void afterTextChanged(Editable s) {
			textViewCountChars.setText("" + editTextTweet.getText().length());
		}
		
		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
		}
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
		
	}
	}
	
	//The AsycTask classes
	
	public class MyAsyncTaskTweet extends AsyncTask<String, Void, String> {
		
		@Override
		protected String doInBackground(String... tweet) {
			String result = "";
			
			Twitter twitter = TwitterFactory.getSingleton();
			try {
				twitter.updateStatus(tweet[0]);
				result = getResources().getString(R.string.worked);
			}catch (TwitterException twitterException) {
				result = getResources().getString(R.string.failed);
			}
			return result;
		}
		@Override
		protected void onPostExecute(String result) {
			editTextTweet.setHint(result);
			editTextTweet.setText("");
		}
		
	}
	
	public class MyAsyncTaskTimeline extends AsyncTask<String, Void, String> {
		@Override
		protected String doInBackground(String... username) {
			String result = new String("");
			List<twitter4j.Status> statuses = null;
			
			Twitter twitter = TwitterFactory.getSingleton();
			try {
				statuses = twitter.getUserTimeline(username[0]);
			}catch (TwitterException twitterException) {
				twitterException.printStackTrace();
				
			}
			
			for (twitter4j.Status status : statuses) {
				result += status.getText();
				result += "/n";
			}
			return result;
		}
		
		@Override
		protected void onPostExecute(String result) {
			editTextUsername.setText("");
			textViewTimeline.setText(result);
			
		}
		
	}
}