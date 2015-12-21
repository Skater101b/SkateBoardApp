package com.sk8.skateboardsetup;



import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator; 
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Build;

public class Altboardsetup extends FragmentActivity {
	
	private Animator mCurrentAnimator;  // save a spot for this
	private int mShortAnimationDuration; // save a spot for this

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_altboardsetup); 
		
		final View thumb1View = findViewById(R.id.thumb_button_1);
		final View thumb2View = findViewById(R.id.thumb_button_2);
		final View thumb3View = findViewById(R.id.thumb_button_3);
		final View thumb4View = findViewById(R.id.thumb_button_4);
		final View thumb5View = findViewById(R.id.thumb_button_5);
		final View thumb6View = findViewById(R.id.thumb_button_6);
		final View thumb7View = findViewById(R.id.thumb_button_7);
		final View thumb8View = findViewById(R.id.thumb_button_8);
		
		
		
		// instantiate thumbView by calling the view the image button
		thumb1View.setOnClickListener(new View.OnClickListener() { // set onclick listener
			
			@Override
			public void onClick(View view) {  
				zoomImageFromThumb(thumb1View, R.drawable.flip1); // this takes the thumbView from above and assigns it a picture.
			}
		});
		
		thumb2View.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				zoomImageFromThumb(thumb2View, R.drawable.flip2);
			}
			
		});
		
		thumb3View.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				zoomImageFromThumb(thumb3View, R.drawable.flipe3);
			}
		});
		
		thumb4View.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				zoomImageFromThumb(thumb4View, R.drawable.flipe4);
			}
		});

		thumb5View.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		zoomImageFromThumb(thumb5View, R.drawable.flipe5);
	}
});


		thumb6View.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View view) {
		zoomImageFromThumb(thumb6View, R.drawable.flipe6);
	}
});
		
		thumb7View.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				zoomImageFromThumb(thumb7View, R.drawable.flip7);
			}
		});
		
		thumb8View.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View view) {
				zoomImageFromThumb(thumb8View, R.drawable.flip8);
			}
		});
		
		mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);  // This gets the animation time
	}
	
	@SuppressLint("NewApi")  // surpress for different API
	
	
	private void zoomImageFromThumb(final View thumbView, int imageResId) { // this method is called. Since the onClick calls a zoomImageFromThumb button. 
		if (mCurrentAnimator != null) {   // if animator is going already, cancel it
				mCurrentAnimator.cancel();
				
		}
		
		final ImageView expandedImageView = (ImageView) findViewById(R.id.expanded_image); // we instantiat the image and tell it where to put it on the layout.
		expandedImageView.setImageResource(imageResId); // we take that layout spot and we set the imageresource to imageResId
		
		final Button checkPlus = (Button) findViewById(R.id.buttonForYes);
		checkPlus.setOnClickListener(new OnClickListener() {	
			@Override
				public void onClick(View v) {
				Intent intent = new Intent(Altboardsetup.this, AltboardsetupOne.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	
		
		final Button checkNo = (Button) findViewById(R.id.buttonForNo);
		checkNo.setOnClickListener(new OnClickListener() {	
			@Override
			public void onClick(View v) {
				// For no we reload same intent.
				Intent intent = new Intent(Altboardsetup.this, Altboardsetup.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
		});
	
		
		
		
		final Rect startBounds = new Rect();   // here we get the startBounds
		final Rect finalBounds = new Rect();  // the finalBounds
		final Point globalOffset = new Point();  // globalOffset (means the screen)
		
		
		
		thumbView.getGlobalVisibleRect(startBounds);  // we take our thumbView and we getthe visible Rect where startBounds is.
		findViewById(R.id.container).getGlobalVisibleRect(finalBounds, globalOffset);  // find the view by container(fragment) and getglobalvisibleRECt(finalbounds and globalOffset
		startBounds.offset(-globalOffset.x, -globalOffset.y); // this is the start bounds
		finalBounds.offset(-globalOffset.x, -globalOffset.y); // this is the final bounds
		
		//Above makes it so that I can find the start and end of the picture. I get the start bounds by the visibleRec of the view. Then I find the container and I get visisbleRect finalBounds and globaloffset
		//This makes it so I can set the final to the size of the container or screen holding the image. 
		
		
		
		// Now I need the scale the image. This makes it so that the image is not distorted based on the image. If the image was sideways for example. I blew it up. If it fit the screen it would only expand so wide and 
		//it would fill the entire hieght. Which would cause my image to look stupid. This is done with the crop technique
		float startScale;
		if ((float) finalBounds.width() / finalBounds.height() > (float) startBounds.width() / startBounds.height()) { // take final bounds width / height creater that startbounds width/height
			startScale = (float) startBounds.height() / finalBounds.height(); // start scale will - startbounds.height / finalbounds.height
			float startWidth = startScale * finalBounds.width(); // float startWidth = startScale * finalbounds.width
			float deltaWidth = (startWidth - startBounds.width()) / 2; // float deltaWidth - start width - startbounds.width
			startBounds.left -=deltaWidth; // start left to delta
			startBounds.right += deltaWidth; // start right deltawidth
		} else {
			startScale = (float) startBounds.width() / finalBounds.width(); // startScale start bounds widht / finalbound.widht
	        float startHeight = startScale * finalBounds.height(); // set values
	        float deltaHeight = (startHeight - startBounds.height()) / 2; //set values
	        startBounds.top -= deltaHeight; // set values
	        startBounds.bottom += deltaHeight; // set values
	    }
		
		// hid the thumbnail and show the zoomed in view when animation begins it will position the zoom in in place of the thumbnail
		thumbView.setAlpha(0f);
		expandedImageView.setVisibility(View.VISIBLE);
		checkPlus.setVisibility(View.VISIBLE);
		checkNo.setVisibility(View.VISIBLE);
		expandedImageView.setPivotX(0f); // pivot points for the SCALE X and SCALE Y - the default is the center.
		expandedImageView.setPivotY(0f);
		
		AnimatorSet set = new AnimatorSet(); // allows us to run it all at the same exact time. 
		set.play(ObjectAnimator.ofFloat(expandedImageView, View.X, startBounds.left, finalBounds.left)).with(ObjectAnimator.ofFloat(expandedImageView, View.Y, startBounds.top, finalBounds.top)).with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X, startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_Y, startScale, 1f));
		
		 set.setDuration(mShortAnimationDuration);
		    set.setInterpolator(new DecelerateInterpolator());
		    set.addListener(new AnimatorListenerAdapter() {
		        @Override
		        public void onAnimationEnd(Animator animation) {
		            mCurrentAnimator = null;
		        }
		        @Override
		        public void onAnimationCancel(Animator animation) {
		            mCurrentAnimator = null;
		        }
		    });
		    set.start();
		    mCurrentAnimator = set;
		    
		    // now click again we should go backwards
		    
		    final float startScaleFinal = startScale;
		    expandedImageView.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View view) {
		            if (mCurrentAnimator != null) {
		                mCurrentAnimator.cancel();
		            }

		            // Animate the four positioning/sizing properties in parallel,
		            // back to their original values.
		            AnimatorSet set = new AnimatorSet();
		            set.play(ObjectAnimator
		                        .ofFloat(expandedImageView, View.X, startBounds.left))
		                        .with(ObjectAnimator
		                                .ofFloat(expandedImageView, 
		                                        View.Y,startBounds.top))
		                        .with(ObjectAnimator
		                                .ofFloat(expandedImageView, 
		                                        View.SCALE_X, startScaleFinal))
		                        .with(ObjectAnimator
		                                .ofFloat(expandedImageView, 
		                                        View.SCALE_Y, startScaleFinal));
		            set.setDuration(mShortAnimationDuration);
		            set.setInterpolator(new DecelerateInterpolator());
		            set.addListener(new AnimatorListenerAdapter() {
		                @Override
		                public void onAnimationEnd(Animator animation) {
		                    thumbView.setAlpha(1f);
		                    expandedImageView.setVisibility(View.GONE);
		                    checkPlus.setVisibility(View.GONE);
		                    checkNo.setVisibility(View.GONE);
		                    mCurrentAnimator = null;
		                }

		                @Override
		                public void onAnimationCancel(Animator animation) {
		                    thumbView.setAlpha(1f);
		                    checkPlus.setVisibility(View.GONE);
		                    expandedImageView.setVisibility(View.GONE);
		                    checkNo.setVisibility(View.GONE);
		                    mCurrentAnimator = null;
		                }
		            });
		            set.start();
		            mCurrentAnimator = set;
		        }
		    });
		}

		}

	