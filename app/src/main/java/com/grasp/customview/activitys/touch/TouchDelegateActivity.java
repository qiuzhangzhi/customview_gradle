/*
 * Copyright (c) 2012 Wireless Designs, LLC
 *
 * See the file license.txt for copying permission.
 */
package com.grasp.customview.activitys.touch;

import com.grasp.customview.widgets.touch.TouchDelegateLayout;

import android.app.Activity;
import android.os.Bundle;

public class TouchDelegateActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TouchDelegateLayout layout = new TouchDelegateLayout(this);
		setContentView(layout);
	}
}
