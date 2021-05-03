package com.example.miniproject;

import java.util.ArrayList;
import java.util.Random;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThirdActivity extends Activity {
	
	
	Button op1,op2,op3,op4,playagain;
	TextView timer,res,ques,ans;
	ArrayList<Integer> answers=new ArrayList<Integer>();
	int locofcrt;
	int sc=0;
	int numberofqs=0;
	Boolean gameact=true;
	String level="";
	int a,b;
	int incrtans;
	Random ran=new Random();
	public void playagain(View view)
    {
        sc=0;
        numberofqs=0;
        timer.setText("30s");
        res.setText("0/0");
        ans.setText("");
        playagain.setVisibility(View.INVISIBLE);
        gameact=true;

        generate();

        new CountDownTimer(30100,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
            	if((millisUntilFinished/1000)>=10)
            	{
            		timer.setText(String.valueOf(millisUntilFinished/1000) + "s");
            	}
            	else
            	{
            		timer.setText("0"+String.valueOf(millisUntilFinished/1000) + "s");
            	}
            }

            @Override
            public void onFinish() {
                /*playagain.setVisibility(View.VISIBLE);

                timer.setText("00s");
                
                ans.setText("YOUR SCORE: "+Integer.toString(sc)+"/"+Integer.toString(numberofqs));
                gameact=false;*/
            	
            	gameact=false;
            	timer.setText("00s");
            	Intent i3=new Intent(ThirdActivity.this,PlayAgainActivity.class);
            	i3.putExtra("key1",res.getText());
            	i3.putExtra("key2",level);
            	startActivity(i3);
            	finish();
            }
        }.start();

    }
	
	public void chooseAnswer(View view)
	{
		if(gameact==true)
		{
			if (view.getTag().toString().equals(Integer.toString(locofcrt + 1))) 
			{
	            sc++;
	            ans.setText("CORRECT");
	        } 
			else 
	        {
	            ans.setText("WRONG");
	        }
			numberofqs++;
	        res.setText(Integer.toString(sc) + "/" + Integer.toString(numberofqs));
	        generate();
		}
        
	}
	
	public void generate()
	{
        //Random ran=new Random();
        
        if(level.equals("easy"))
        {
	        a=ran.nextInt(20);                    //0 to 19
	        b=ran.nextInt(20);
        }
        else if(level.equals("medium"))
        {
        	a=20+ran.nextInt(30);                  //20 to 49
            b=20+ran.nextInt(30);
        }
        else if(level.equals("hard"))
        {
        	a=50+ran.nextInt(50);                  //50 to 99
            b=50+ran.nextInt(50);
        }
        
        ques.setText(Integer.toString(a)+" + "+ Integer.toString(b));
        
        locofcrt=ran.nextInt(4);
        
        answers.clear();
        
        
        
        
        for(int i=0;i<4;i++)
        {
            if(i==locofcrt)
                answers.add(a+b);
            else
            {
            	if(level.equals("easy"))
                {
            		incrtans=ran.nextInt(39);
            		while(incrtans==a+b)
                    {
                        incrtans=ran.nextInt(39);
                    }
                }
                else if(level.equals("medium"))
                {
                	incrtans=40+ran.nextInt(59);                //40 to 98
                	while(incrtans==a+b)
                    {
                        incrtans=40+ran.nextInt(59);
                    }
                }
                else if(level.equals("hard"))
                {
                	incrtans=100+ran.nextInt(99);             //100 to 198
                	while(incrtans==a+b)
                    {
                        incrtans=100+ran.nextInt(99);
                    }
                }
               
                answers.add(incrtans);
            }
        }
        op1.setText(Integer.toString(answers.get(0)));
        op2.setText(Integer.toString(answers.get(1)));
        op3.setText(Integer.toString(answers.get(2)));
        op4.setText(Integer.toString(answers.get(3)));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		
		op1=(Button)findViewById(R.id.button1);
        op2=(Button)findViewById(R.id.button2);
        op3=(Button)findViewById(R.id.button3);
        op4=(Button)findViewById(R.id.button4);
        
        ques=(TextView)findViewById(R.id.textView2);
        timer=(TextView)findViewById(R.id.textView1);
        ans=(TextView)findViewById(R.id.textView3);
        res=(TextView)findViewById(R.id.TextView01);
        
        playagain=(Button)findViewById(R.id.playagain);
        
        Intent i1=getIntent();
        level=i1.getStringExtra("key2");
        
        playagain(findViewById(R.id.playagain));
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_third, menu);
		return true;
	}

}
