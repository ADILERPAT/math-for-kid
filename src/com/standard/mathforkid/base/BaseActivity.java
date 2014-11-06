package com.standard.mathforkid.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public abstract class BaseActivity extends Activity {
	
	private BaseCommon Common;

	protected BaseCommon getCommon() {
		return Common;
	}

	protected void setCommon(BaseCommon common) {
		Common = common;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Common = new BaseCommon(this);
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
