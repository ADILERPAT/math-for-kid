package com.standard.mathforkid;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.standard.mathforkid.common.CommonFunctions;
import com.standard.mathforkid.common.Constants;

public class CompareNumberActivity extends Activity {

	private Context context;
	private ImageView imgFirst;
	private ImageView imgSecond;
	
	private TextView tvCompare;
	private TextView tvNumberFirst;
	private TextView tvNumberSecond;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		setContentView(R.layout.activity_compare);
		imgFirst = (ImageView) findViewById(R.id.number_first_img);
		imgSecond = (ImageView) findViewById(R.id.number_second_img);

		tvCompare = (TextView)findViewById(R.id.compare_tv);
		tvNumberFirst = (TextView)findViewById(R.id.number_first_tv);
		tvNumberSecond = (TextView)findViewById(R.id.number_second_tv);
		imgFirst.setOnClickListener(imgFirstOnClick);
		imgSecond.setOnClickListener(imgSecondOnClick);
		initData();

	}
	
	private void initData(){
        if(Constants.IS_MAX)
        {
        	tvCompare.setText(getResources().getString(R.string.choose_max));
        }
        else{
        	tvCompare.setText(getResources().getString(R.string.choose_min));
        }
        int firstNumber = CommonFunctions.random(1, 20);
        tvNumberFirst.setText(String.valueOf(firstNumber));
        int secondNumber = CommonFunctions.randomEx(1, 20,firstNumber);
        tvNumberSecond.setText(String.valueOf(secondNumber));
	}
	
	private OnClickListener imgFirstOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if(calculate()){
				Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
				initData();
			}else{
				Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private OnClickListener imgSecondOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			if(!calculate()){
				Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
				initData();
			}else{
				Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
			}
		}
	};
	
	private boolean calculate(){
		String numberFirst = tvNumberFirst.getText().toString();
		String numberSecond = tvNumberSecond.getText().toString();
		
		int intNumberFirst = Integer.parseInt(numberFirst);
		int intNumberSecond = Integer.parseInt(numberSecond);
		boolean result;
		if(Constants.IS_MAX)
		{
			result= (intNumberFirst > intNumberSecond) ? true : false;
		}
		else
		{
			result= (intNumberSecond > intNumberFirst) ? true : false;
		}
		
		return result;
	}
}
	