package com.grasp.customview.widgets;

import java.lang.ref.WeakReference;

import com.grasp.customview.R;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;;


public class TimerButton extends Button implements OnClickListener{
	
	private static final int DELY = 1000;
	
	private static final int WHAT = 0;
	
	private String unClickText;
	
	private String clickedText;
	
	private int initTime ;
	
	private int finalTime;
	
	private int curTime ;
	
	private TimerHandler mTimerHandler;
	
	private OnClickListener mOutListener;
	
	public TimerButton(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	private void init(Context context, AttributeSet atts){
		
		mTimerHandler = new TimerHandler(this);
		
		TypedArray mTypedArray = context.obtainStyledAttributes(atts, R.styleable.TimerButton);
		
		unClickText = mTypedArray.getString(R.styleable.TimerButton_unClickText);
		clickedText = mTypedArray.getString(R.styleable.TimerButton_clickedText);
		finalTime = mTypedArray.getInteger(R.styleable.TimerButton_time, 0);
		
		mTypedArray.recycle();
		
		super.setOnClickListener(this);
		initTime = finalTime ;
		if(unClickText != null){
		   setText(unClickText);
		}
		
	}
	
	@Override
	public void onClick(View v) {
		if(clickedText != null && !getText().equals(clickedText)){
			setText(clickedText);
			setClickable(false);
			finalTime = (int)System.currentTimeMillis()/1000+initTime ;
			mTimerHandler.sendEmptyMessage(WHAT);
			if(mOutListener != null){
				mOutListener.onClick(v);
			}
		}
	}


	private void updateTime(){
		
		curTime = finalTime - (int)System.currentTimeMillis()/1000;
		Log.d("timerButton","time:" +curTime );
		setText(String.format(clickedText,curTime));
		mTimerHandler.removeMessages(WHAT);
		if(curTime > 0){
			mTimerHandler.sendEmptyMessageDelayed(WHAT, DELY);
		}else {
			setClickable(true);
			setText(unClickText);
		}
	}
	private static final class TimerHandler extends Handler{
		
		private WeakReference<TimerButton> mReference;
		
		public TimerHandler(TimerButton reference) {
			mReference = new WeakReference<TimerButton>(reference);
		}
		@Override
		public void handleMessage(Message msg) {
			mReference.get().updateTime();
		}
	}

	@Override
	public void setOnClickListener(OnClickListener l) {
		
		mOutListener = l;
	}

	
}
