package com.standard.mathforkid;

import com.standard.mathforkid.common.CommonFunctions;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class ReadNumberActivity extends Activity {

	private Context context;
	private TextView tvNumber;
	private ImageButton btnNext;
	private ImageButton btnBack;
	private int number = 0;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		setContentView(R.layout.activity_read);
		tvNumber = (TextView) findViewById(R.id.number_tv);
		btnBack = (ImageButton) findViewById(R.id.back_btn);
		btnNext = (ImageButton) findViewById(R.id.next_btn);
		btnBack.setOnClickListener(btnBackOnClick);
		btnNext.setOnClickListener(btnNextOnClick);
		tvNumber.setOnClickListener(tvNumberOnclick);
	}

	private OnClickListener btnNextOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			number ++;
			tvNumber.setText(String.valueOf(number));
		   CommonFunctions.playSound(context,"n" + String.valueOf(number));
		}
	};
	
	private OnClickListener btnBackOnClick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			if(number > 0){
				number --;
			}
			tvNumber.setText(String.valueOf(number));
			CommonFunctions.playSound(context,"n" + String.valueOf(number));
		}
	};
	private OnClickListener tvNumberOnclick = new View.OnClickListener() {

		@Override
		public void onClick(View arg0) {
			CommonFunctions.playSound(context,"n" + String.valueOf(number));
		}
	};
	
}