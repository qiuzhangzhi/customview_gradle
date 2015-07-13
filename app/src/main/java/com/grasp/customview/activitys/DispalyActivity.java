package com.grasp.customview.activitys;

import com.grasp.customview.R;
import com.grasp.customview.R.id;
import com.grasp.customview.R.layout;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class DispalyActivity extends Activity {

	TextView mTextDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dispaly);
		mTextDisplay = (TextView)findViewById(R.id.display);
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		mTextDisplay.setText("density:"+dm.density+"  densityDpi:"+dm.densityDpi +" heightPixels:"+dm.heightPixels
				+" widthPixels:"+dm.widthPixels +"   xdpi:"+dm.xdpi+"  ydpi:"+dm.ydpi+"  scaledDensity:"+dm.scaledDensity
				+" screenWidth:"+dm.widthPixels/dm.xdpi+" screenHeight:"+dm.heightPixels/dm.ydpi
				);
	}
}
