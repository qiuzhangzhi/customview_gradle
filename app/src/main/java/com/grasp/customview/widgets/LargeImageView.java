package com.grasp.customview.widgets;

import com.grasp.customview.activitys.FlakeActivity;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Scroller;

public class LargeImageView extends ImageView{


	private Scroller mScroller;
	
	
	public LargeImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		mScroller = new Scroller(context);
	}

	public LargeImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mScroller = new Scroller(context);
	}

	public LargeImageView(Context context) {
		super(context);
		mScroller = new Scroller(context);
	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		setMeasuredDimension(3200, FlakeActivity.SCREEN_HEIGHT);
	}
	public void scrollToEnd(){
		mScroller.startScroll(0, 0, 3200-FlakeActivity.SCREEN_WIDTH, 0,3000);
		invalidate();
	}
	
	@Override
	public void computeScroll() {	
		if (mScroller.computeScrollOffset()) {
			scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
			postInvalidate();
		}
	}
}
