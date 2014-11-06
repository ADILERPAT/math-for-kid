package com.standard.mathforkid.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseSupportFragment extends Fragment{
	private View view;
	private BaseCommon Common;
	
	protected BaseCommon getCommon() {
		return Common;
	}
	
	protected void setCommon(BaseCommon common) {
		Common = common;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		Common = new BaseCommon(this.getActivity());
		super.onCreate(savedInstanceState);
		// Create your fragment here
	}
	
	@Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		if(layoutResource() != null){
			view  = inflater.inflate(layoutResource(), container, false);
			loadControls();
			bindEvents();
			return view;
		}
		return null;
	}
	
	public abstract Integer layoutResource();
	
	public abstract void loadControls();
	
	public abstract void bindEvents();
}
