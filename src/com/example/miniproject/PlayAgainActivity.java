package com.example.miniproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class PlayAgainActivity extends Activity {
	
	Button b1,b2;
	TextView t3;
	String level;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play_again);
		
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		t3=(TextView)findViewById(R.id.textView3);
		
		Intent i1=getIntent();
		String result=i1.getStringExtra("key1");
		level=i1.getStringExtra("key2");
		t3.setText(result);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i2=new Intent(PlayAgainActivity.this,ModesActivity.class);
				i2.putExtra("key", level);
				startActivity(i2);
				finish();
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent i1=new Intent(PlayAgainActivity.this,PlayActivity.class);
				startActivity(i1);
				finish();
			}
		});
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_play_again, menu);
		return true;
	}
}
