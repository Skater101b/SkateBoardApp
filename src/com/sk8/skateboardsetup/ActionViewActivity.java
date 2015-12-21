package com.sk8.skateboardsetup;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

	 
	public class ActionViewActivity extends Activity implements OnPreparedListener {
	 
	//String SrcPath = "rtsp://r4sn-p5qlsu7s.c.youtube.com/CiILENy73wIaGQkweo50bbpIwhMYDSANFEgGUgZ2aWRlb3MM/0/0/0/video.3gp";
	 String url = "https://www.youtube.com/watch?v=wki6bXSOejA";
	 
	   /** Called when the activity is first created. */
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	   //    setContentView(R.layout.action_view);
	     //  VideoView myVideoView = (VideoView)findViewById(R.id.myvideoview);
	    //   myVideoView.setVideoURI(Uri.parse(SrcPath));
	  //     myVideoView.setMediaController(new MediaController(this));
	  //     myVideoView.requestFocus();
	//       myVideoView.start();
	       
	       MediaPlayer mediaPlayer = new MediaPlayer();
	       try {
			mediaPlayer.setDataSource(url);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	       mediaPlayer.setOnPreparedListener(this);     
	       mediaPlayer.prepareAsync();
	       //mediaPlayer.start();
	     
	   }

	@Override
	public void onPrepared(MediaPlayer mediaPlayer) {
		mediaPlayer.start();
	}
	}
