package com.standard.mathforkid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import com.standard.mathforkid.common.Constants;

public class MainDisplayActivity extends Activity {
	private ImageButton btnReadNumber;
	private ImageButton btnCountNumber;
	private ImageButton btnCompareMax;

	private ImageButton btnCompareMin;
	private ImageButton btnPlus;
	private ImageButton btnSubtract;
	private ImageButton btnPlusAndSubtract;
	private ImageButton btnRememberNumber;
	
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_display);
		this.context  = getApplicationContext();
		btnReadNumber = (ImageButton) findViewById(R.id.read_number_btn);
		btnCountNumber = (ImageButton) findViewById(R.id.count_number_btn);
		btnCompareMax = (ImageButton) findViewById(R.id.compare_max_btn);

		btnCompareMin = (ImageButton) findViewById(R.id.compare_min_btn);
		btnPlus = (ImageButton) findViewById(R.id.plus_number_btn);
		btnSubtract = (ImageButton) findViewById(R.id.subtract_number_btn);
		btnPlusAndSubtract = (ImageButton) findViewById(R.id.plus_and_subtract_btn);
		btnRememberNumber = (ImageButton) findViewById(R.id.remember_number_btn);

		btnReadNumber.setOnClickListener(btnReadNumberOnClick);
		btnCountNumber.setOnClickListener(btnCountNumberOnClick);
		btnCompareMax.setOnClickListener(btnCompareMaxOnClick);

		btnCompareMin.setOnClickListener(btnCompareMinOnClick);
		btnPlus.setOnClickListener(btnPlusOnClick);
		btnSubtract.setOnClickListener(btnSubtractOnClick);
		btnPlusAndSubtract.setOnClickListener(btnPlusAndSubtractOnClick);
		btnRememberNumber.setOnClickListener(btnRememberNumberOnClick);

	}

	private OnClickListener btnReadNumberOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,ReadNumberActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener btnCountNumberOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,CountNumberActivity.class);
			startActivity(intent);

		}
	};
	private OnClickListener btnCompareMaxOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Constants.IS_MAX = true;
			Intent intent = new Intent(context,CompareNumberActivity.class);
			startActivity(intent);
		}
	};
	private OnClickListener btnCompareMinOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Constants.IS_MAX = false;
			Intent intent = new Intent(context,CompareNumberActivity.class);
			startActivity(intent);

		}
	};
	private OnClickListener btnPlusOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,SubtractActivity.class);
			startActivity(intent);
			Constants.Position = 1;
			Constants.Operation = "+";
			
		}
	};
	private OnClickListener btnSubtractOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,SubtractActivity.class);
			startActivity(intent);
			Constants.Position = 1;
			Constants.Operation = "-";
		}
	};
	private OnClickListener btnPlusAndSubtractOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,AddAndSubtractActivity.class);
			startActivity(intent); 

		}
	};
	private OnClickListener btnRememberNumberOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			Intent intent = new Intent(context,RemeberNumberActivity.class);
			startActivity(intent);

		}
	};
}
