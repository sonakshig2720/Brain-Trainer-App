package com.example.miniproject;

import java.util.List;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class PlayActivity extends Activity {
	
	Button b1;
	MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		
		b1=(Button)findViewById(R.id.button1);
		
		mp=MediaPlayer.create(getApplicationContext(), R.raw.music);
		mp.start();
		mp.setLooping(true);
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i1=new Intent(PlayActivity.this,ModesActivity.class);
				startActivity(i1);
				//finish();
				
			}
		});
		
		
	}
	@Override
	  protected void onPause() {
	    if (this.isFinishing()){ //basically BACK was pressed from this activity
	      mp.stop();
	      //Toast.makeText(xYourClassNamex.this, "YOU PRESSED BACK FROM YOUR 'HOME/MAIN' ACTIVITY", Toast.LENGTH_SHORT).show();
	    }
	    Context context = getApplicationContext();
	    ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
	    List<RunningTaskInfo> taskInfo = am.getRunningTasks(1);
	    if (!taskInfo.isEmpty()) {
	      ComponentName topActivity = taskInfo.get(0).topActivity; 
	      if (!topActivity.getPackageName().equals(context.getPackageName())) {
	        mp.stop();
	        //Toast.makeText(xYourClassNamex.this, "YOU LEFT YOUR APP", Toast.LENGTH_SHORT).show();
	      }
	      else {
	        //Toast.makeText(xYourClassNamex.this, "YOU SWITCHED ACTIVITIES WITHIN YOUR APP", Toast.LENGTH_SHORT).show();
	      }
	    }
	    super.onPause();
	  }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play, menu);
		return true;
	}

}
