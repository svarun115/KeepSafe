package com.droidappdevs.keepsafe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.widget.CheckBox;

public class StartPage extends Activity {	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkbox);		          	 
        Intent bootIntent = new Intent(getApplicationContext(), LaunchActivity.class);
        bootIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startService(bootIntent);
        getApplicationContext().stopService(bootIntent);      	
        //uncommnet send sms.
        ActionStartsHere();
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_page, menu);
		return true;
	}
	public void ActionStartsHere()
	{
		if(LaunchActivity.done!=true)
			againStartGPSAndSendFile();
	}

	public void againStartGPSAndSendFile()
	{
	new CountDownTimer(11000,10000)
	    {
	        @Override
	        public void onTick(long millisUntilFinished)
	        {
	        	final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
	        	final CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
	        	final CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
	        	final CheckBox checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
	        	final CheckBox checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
	        	final CheckBox checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
	        	final CheckBox checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
	        	if(LaunchActivity.data==true)
	        		checkBox2.setChecked(true);
	        	if(LaunchActivity.audio==true)
	        		checkBox3.setChecked(true);
	        	if(LaunchActivity.call==true)
	        		checkBox5.setChecked(true);
	        	if(LaunchActivity.gps==true)
	        		checkBox4.setChecked(true);
	        	if(LaunchActivity.zip==true)
	        		checkBox6.setChecked(true);
	        	if(LaunchActivity.send==true)
	        		checkBox7.setChecked(true);
	        	if(LaunchActivity.done==true)
	        		checkBox8.setChecked(true);
	        	
	        
	        }
	        @Override
	        public void onFinish()
	        {
	            ActionStartsHere();
	        }

	    }.start();
	}   

}
