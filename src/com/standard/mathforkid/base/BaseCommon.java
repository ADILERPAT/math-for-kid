package com.standard.mathforkid.base;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class BaseCommon extends Object{
	private Context context;
	private InputMethodManager inputManager;
	
	public BaseCommon(Context context){
		this.context = context;
		inputManager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
	}
	public void processCommonDispatchTouchEvent(MotionEvent ev, View currentFocus)
    {
        // hide keyboard on touch
        if (currentFocus != null && inputManager != null)
        {
            inputManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
