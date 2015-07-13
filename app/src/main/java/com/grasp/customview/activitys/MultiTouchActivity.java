package com.grasp.customview.activitys;

import java.util.ArrayList;
import java.util.List;

import com.grasp.customview.R;
import com.grasp.customview.R.layout;
import com.grasp.customview.model.Pointer;
import com.grasp.customview.widgets.TimerButton;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;

public class MultiTouchActivity extends Activity {

	private TextView mDistance;
	
	private Pointer mPointer1;
	
	private Pointer mPointer2;
	
    private Pointer mPointer3;
	
	private Pointer mPointer4;
	
	private List<Float> distanceList = new ArrayList<Float>();
	
	private List<Pointer> poinerList = new ArrayList<Pointer>();
	
	/* DisplayMetrics dm;
	 float maxX; 
	 float maxY;
	
	 public static float XDPI ;
	 
	 public static float YDPI;
	 double screenInches;*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_multi_touch);
		mDistance = (TextView)findViewById(R.id.distance);
	  /*  dm = new DisplayMetrics();
	    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindowManager().getDefaultDisplay().getRealMetrics(dm);
        } else {
            getWindowManager().getDefaultDisplay().getMetrics(dm);
        }
		mDistance = (TextView)findViewById(R.id.distance);
		maxX= dm.widthPixels/dm.xdpi;
		maxY=dm.heightPixels/dm.densityDpi;
		
		XDPI = dm.widthPixels;
		YDPI = dm.heightPixels;
		
	    double x = Math.pow(maxX,2);
	    double y = Math.pow(maxY,2);
	    screenInches = Math.sqrt(x+y);*/
	    
		/*mPointer1 = new Pointer();
		mPointer2 = new Pointer();*/
/*		mPointer1.setX(2);
		mPointer1.setY(2);
		
		mPointer2.setX(5);
		mPointer2.setY(6);
	
		Log.d("test", "distance:"+Pointer.getPointerDistance(mPointer1, mPointer2)); */	
	}
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if(event.getPointerCount() == 4){
			distanceList.clear();
			poinerList.clear();
			
			for(int i = 0 ; i < 4 ; i++){
				Pointer pointer = new Pointer();
				pointer.setX((event.getX(i)));
				pointer.setY((event.getY(i)));
				poinerList.add(pointer);
			}
			
			float fdistance = Pointer.getPointerDistance(poinerList.get(0), poinerList.get(1));
			
			distanceList.add(fdistance);
			
			for (int i = 2; i < 4; i++) {
				
				float distance = Pointer.getPointerDistance(poinerList.get(0), poinerList.get(i));
				
				int j = 0;
				for(j = 0 ; j < distanceList.size() ; j++){
					if(distance < distanceList.get(j)){
						break;
					}
				}
				distanceList.add(j, distance);
				
			}
			for (int i = 0; i < distanceList.size(); i++) {
				Log.d("test", ""+i+":"+distanceList.get(i));
			}
			mDistance.setText(""+distanceList.get(0)+","+distanceList.get(1)+","+distanceList.get(0)/distanceList.get(1));
		/*	mDistance.setText("distance:"+Pointer.getPointerDistance(mPointer1, mPointer2)+"distanceX£º"+Pointer.getXDistance(mPointer1, mPointer2)
					+"distanceY£º"+Pointer.getYDistance(mPointer1, mPointer2)
					);*/

		}
		return true;
	}
	
/*	public float convertPixelsToDp(float px){
	    Resources resources = MultiTouchActivity.this.getResources();
	    float scale = resources.getDisplayMetrics().density;
	    float dp = (px /scale +0.5f);
	    return dp;
	}*/
	/* public static int px2dip(Context context, float pxValue) {  
	        final float scale = context.getResources().getDisplayMetrics().density;  
	        return (int) (pxValue / scale + 0.5f);  
	    }  */
}
