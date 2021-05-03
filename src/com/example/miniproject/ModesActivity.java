package com.example.miniproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ModesActivity extends Activity {
	
	Button b1,b2,b3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_modes);
		
		b1=(Button)findViewById(R.id.button1);
		b2=(Button)findViewById(R.id.button2);
		b3=(Button)findViewById(R.id.button3);
		
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(ModesActivity.this,SecondActivity.class);
				//Intent i2=new Intent(ModesActivity.this,ThirdActivity.class);
				String level;
				level="easy";
				i1.putExtra("key", level);
				startActivity(i1);
				finish();
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(ModesActivity.this,SecondActivity.class);
				//Intent i2=new Intent(ModesActivity.this,ThirdActivity.class);
				String level;
				level="medium";
				i1.putExtra("key", level);
				startActivity(i1);
				finish();
			}
		});

		b3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i1=new Intent(ModesActivity.this,SecondActivity.class);
				//Intent i2=new Intent(ModesActivity.this,ThirdActivity.class);
				String level;
				level="hard";
				i1.putExtra("key", level);
				startActivity(i1);
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_modes, menu);
		return true;
	}

}
