package com.standard.mathforkid.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public abstract class BaseActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(layoutResources());
		loadControls();
		bindEvents();
	}

	public abstract int layoutResources();

	public abstract void loadControls();

	public abstract void bindEvents();

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		return super.dispatchTouchEvent(ev);
	}

}
