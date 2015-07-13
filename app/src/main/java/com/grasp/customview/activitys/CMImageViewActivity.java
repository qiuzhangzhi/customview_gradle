package com.grasp.customview.activitys;

import java.io.IOException;
import java.io.InputStream;

import com.grasp.customview.R;
import com.grasp.customview.widgets.CMImageViewButton;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class CMImageViewActivity extends Activity {

	private CMImageViewButton mButton;
	
    @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cmimage_view);
		mButton = (CMImageViewButton)findViewById(R.id.button);
    	/*StateListDrawable states = new StateListDrawable();
    	states.addState(new int[]{android.R.attr.state_pressed}, getResources().getDrawable(R.drawable.pre));
		states.addState(new int[]{},  getResources().getDrawable(R.drawable.nor));*/
		
		//mButton.setBackgroundDrawable(states);
		mButton.setImages(getAssetImage(1),getAssetImage(2));
	}
	
	public Drawable getAssetImage(int type) {
		InputStream is = null;
		Bitmap bitmap = null;
		try {
			if(type == 1){
				is = getAssets().open("nor.png");
			}else {
				is = getAssets().open("pre.png");
			}
			
			bitmap = BitmapFactory.decodeStream(is);
		} catch (Exception e) {
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return new BitmapDrawable(bitmap);
	 
	}
}
