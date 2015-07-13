package com.grasp.customview.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.grasp.customview.R;

/**
 * Created by qzz on 15/7/13.
 */
public class ZoonProgressBar extends RelativeLayout {

    private static final int TYPE_BEFOR = 1;

    private static final int TYPE_AFTER = 2;

    private ImageView mIndicator;

    private ProgressBar mProgressBar;

    private DisplayMetrics dm;

    private float mBorderWidth;
    public ZoonProgressBar(Context context) {
        super(context);
        init();
    }

    public ZoonProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ZoonProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
//        setBackgroundResource(R.drawable.shape_progressbar_bg);
        DisplayMetrics dm = new DisplayMetrics();
        WindowManager wm = (WindowManager)getContext().getSystemService(Context.WINDOW_SERVICE);
        wm.getDefaultDisplay().getMetrics(dm);
        mBorderWidth = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, dm);
//        setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, dm), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6, dm),
//                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, dm), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, dm));
        LayoutInflater.from(getContext()).inflate(R.layout.view_zoon_progressbar,this);
        mIndicator = (ImageView)findViewById(R.id.indicator);
        mProgressBar = (ProgressBar)findViewById(R.id.progress);
    }

    public void setProgress(int progress){
        mProgressBar.setProgress(progress);
        updateIndacatorLocation(TYPE_BEFOR);
    }
    private void updateIndacatorLocation(int type){

        if(type == TYPE_BEFOR) {
            post(new Runnable() {
                @Override
                public void run() {
                    float progressPercentage = mProgressBar.getProgress() / (float) mProgressBar.getMax();

                    float locationXProgress = (getWidth() - 2 * mBorderWidth) * progressPercentage + mBorderWidth - mIndicator.getWidth() / 2;

                    LayoutParams params = (LayoutParams) mIndicator.getLayoutParams();

                    params.leftMargin = (int) locationXProgress;

                    mIndicator.setLayoutParams(params);

                }
            });
        }else {
            post(new Runnable() {
                @Override
                public void run() {
                    float progressPercentage = mProgressBar.getSecondaryProgress() / (float) mProgressBar.getMax();

                    float locationXProgress = (getWidth() - 2 * mBorderWidth) * progressPercentage + mBorderWidth - mIndicator.getWidth() / 2;

                    LayoutParams params = (LayoutParams) mIndicator.getLayoutParams();

                    params.leftMargin = (int) locationXProgress;

                    mIndicator.setLayoutParams(params);

                }
            });
        }
    }


}
