package com.grasp.customview.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.grasp.customview.R;
import com.grasp.customview.widgets.ZoonProgressBar;

public class ProgressbarActivity extends Activity {

    ZoonProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progressbar);
        mProgressBar = (ZoonProgressBar)findViewById(R.id.zoonprogressbar);
        mProgressBar.setProgress(20);
    }

}
