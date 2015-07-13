package com.grasp.customview.activitys;

import com.grasp.customview.R;
import com.grasp.customview.widgets.FlakeView;
import com.grasp.customview.widgets.LargeImageView;

import android.R.integer;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

public class FlakeActivity extends Activity {

	FlakeView flakeView;
    public static int SCREEN_WIDTH ;
    
    public static int SCREEN_HEIGHT;
    
    private Button mScroll;
    
    private LargeImageView mImageView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flake);
        DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        LinearLayout container = (LinearLayout) findViewById(R.id.container);
        flakeView = new FlakeView(this);
        container.addView(flakeView);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.BLACK));
        mImageView = (LargeImageView)findViewById(R.id.sweet_bg);
        mScroll = (Button)findViewById(R.id.scroll);
        mScroll.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mImageView.scrollToEnd();
				flakeView.stop();
			}
		});
    /*    Button more = (Button) findViewById(R.id.more);
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flakeView.addFlakes(flakeView.getNumFlakes());
            }
        });
        Button less = (Button) findViewById(R.id.less);
        less.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flakeView.subtractFlakes(flakeView.getNumFlakes() / 2);
            }
        });*/
       /* if (Integer.parseInt(Build.VERSION.SDK) >= Build.VERSION_CODES.HONEYCOMB) {
            HoneycombHelper.setup(this);
        }*/
    }
/*
    private static final class HoneycombHelper {
        static void setup(final FlakeActivity activity) {
            CheckBox accelerated = (CheckBox) activity.findViewById(R.id.accelerated);
            accelerated.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    activity.flakeView.setLayerType(
                            isChecked ? View.LAYER_TYPE_NONE : View.LAYER_TYPE_SOFTWARE, null);
                }
            });
        }
    }*/

    @Override
    protected void onPause() {
        super.onPause();
        flakeView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        flakeView.resume();
    }

}
