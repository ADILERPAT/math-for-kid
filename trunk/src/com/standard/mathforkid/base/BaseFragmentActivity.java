package com.standard.mathforkid.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MotionEvent;

public abstract class BaseFragmentActivity extends FragmentActivity{
	
	private BaseCommon Common;
	
	protected BaseCommon getCommon() {
		return Common;
	}
	protected void setCommon(BaseCommon common) {
		Common = common;
	}
	
	@Override
	protected void onCreate(Bundle bundle) {
		if(bundle == null){
			bundle = new Bundle();
		}
		super.onCreate(bundle);
		
		Common = new BaseCommon(this);
		
	}
	
	public abstract int layoutResource();
	
	public abstract void loadControls();
	
	public abstract void bindEvens();
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Common.processCommonDispatchTouchEvent(ev, this.getCurrentFocus());
		return super.dispatchTouchEvent(ev);
	}
}
