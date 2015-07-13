package com.grasp.customview.widgets;

import com.grasp.customview.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class CMImageViewButton extends ImageButton {

	

	public CMImageViewButton(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public CMImageViewButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CMImageViewButton(Context context) {
		super(context);
	}

	public void setImages(Drawable nor, Drawable pre){
		StateListDrawable states = new StateListDrawable();
		states.addState(new int[]{android.R.attr.state_pressed}, pre);
		states.addState(new int[]{},  nor);
		setBackgroundDrawable(states);
	}
}
