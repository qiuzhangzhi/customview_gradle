package com.grasp.customview.activitys;

import com.grasp.customview.R;
import com.grasp.customview.R.layout;
import com.grasp.customview.widgets.TimerButton;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class TimerButtonActivity extends Activity implements OnClickListener{

	private TimerButton mTimerButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_timer_button);
		mTimerButton = (TimerButton) findViewById(R.id.timer_button);
		mTimerButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.timer_button){
			Toast.makeText(this, "¼àÌýµ½ÁË£¡", Toast.LENGTH_SHORT).show();
		}
		
	}
}
