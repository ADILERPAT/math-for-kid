package com.standard.mathforkid;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.standard.mathforkid.common.CommonFunctions;
import com.standard.mathforkid.common.Constants;

public class SubtractActivity extends Activity {
	private LinearLayout linearFirst;
	private LinearLayout linearSecond;
	private ImageView imgFirst;
	private ImageView imgSecond;
	private ImageView imgThird;
	private ImageView imgFour;
	private Context context;
	private TextView tvResultFirst;
	private TextView tvResultSecond;
	private TextView tvResultThird;
	private TextView tvResultFour;
	private TextView tvNumberFirst;
	private TextView tvNumberSecond;
	private TextView tvOperation;
	private int level = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		if(Constants.Position == 1)
		{
			setContentView(R.layout.activity_subtract);
		}else{
			setContentView(R.layout.activity_appropriate_number);
		}
		
		linearFirst = (LinearLayout) findViewById(R.id.linear_first);
		linearSecond = (LinearLayout) findViewById(R.id.linear_second);

		
		imgFirst = (ImageView) findViewById(R.id.result_first_img);
		imgSecond = (ImageView) findViewById(R.id.result_second_img);
		imgThird = (ImageView) findViewById(R.id.result_third_img);
		imgFour = (ImageView) findViewById(R.id.result_four_img);

		tvResultFirst = (TextView)findViewById(R.id.result_first_tv);
		tvResultSecond = (TextView)findViewById(R.id.result_second_tv);
		tvResultThird = (TextView)findViewById(R.id.result_third_tv);
		tvResultFour = (TextView)findViewById(R.id.result_four_tv);
		tvNumberFirst = (TextView)findViewById(R.id.number_first_tv);
		tvNumberSecond = (TextView)findViewById(R.id.number_second_tv);
		tvOperation = (TextView)findViewById(R.id.operation_tv);
		
		imgFirst.setOnClickListener(imgFirstOnClick);
		imgSecond.setOnClickListener(imgSecondOnClick);
		imgThird.setOnClickListener(imgThirdOnClick);
		imgFour.setOnClickListener(imgFourOnClick);
		
		initData();
	}
	
	private void initData(){
		
		if(linearFirst.getChildCount() > 0) 
		    linearFirst.removeAllViews(); 
		
		if(linearSecond.getChildCount() > 0) 
		    linearSecond.removeAllViews(); 
		
		int arrayFirst = 0;
		int arraySecond = 0;
		if(Constants.Operation.equals("-"))
		{
			if(level <= 6)
			{
				arrayFirst = CommonFunctions.random(1, 10);
			}else if (level > 6 && level <= 10){
				arrayFirst = CommonFunctions.random(1, 12);
			}else{
				arrayFirst = CommonFunctions.random(5, 20);
			}
			
			arraySecond = CommonFunctions.random(0, arrayFirst);
		}else{
			if(level <= 5)
			{
				arrayFirst = CommonFunctions.random(0, 5);
				arraySecond = CommonFunctions.random(0, 5);
			}else if (level >5 && level <= 8){
				arrayFirst = CommonFunctions.random(1, 7);
				arraySecond = CommonFunctions.random(1, 7);
			}else{
				arrayFirst = CommonFunctions.random(0, 10);
				arraySecond = CommonFunctions.random(0, 10);
			}
		}
		
		for (int i = 0; i < arrayFirst; i++) {
			linearFirst.addView(createImageView(context, R.drawable.star));
		}
		for (int i = 0; i < arraySecond; i++) {
			linearSecond.addView(createImageView(context, R.drawable.star));
		}
		
		tvOperation.setText(Constants.Operation);
		
		tvNumberFirst.setText(String.valueOf(arrayFirst));
		tvNumberSecond.setText(String.valueOf(arraySecond));
		int positionRand = CommonFunctions.random(1, 5);
		int valueSubtract = subtractNumber();
		if(valueSubtract == 0){
			positionRand = 1;
		}
		
		if(valueSubtract == 1){
			positionRand = 2;
		}

		if(valueSubtract == 2){
			positionRand = 2;
		}
		
		switch (positionRand) {
		case 1:
			tvResultFirst.setText(String.valueOf(valueSubtract));
			tvResultSecond.setText(String.valueOf(valueSubtract + 1));
			tvResultThird.setText(String.valueOf(valueSubtract + 2));
			tvResultFour.setText(String.valueOf(valueSubtract + 3));
			break;
		case 2:
			tvResultFirst.setText(String.valueOf(valueSubtract - 1));
			tvResultSecond.setText(String.valueOf(valueSubtract));
			tvResultThird.setText(String.valueOf(valueSubtract + 1));
			tvResultFour.setText(String.valueOf(valueSubtract + 2));
			break;
		case 3:
			tvResultFirst.setText(String.valueOf(valueSubtract - 2));
			tvResultSecond.setText(String.valueOf(valueSubtract - 1));
			tvResultThird.setText(String.valueOf(valueSubtract));
			tvResultFour.setText(String.valueOf(valueSubtract + 1));
			break;
		default:
			tvResultFirst.setText(String.valueOf(valueSubtract - 3));
			tvResultSecond.setText(String.valueOf(valueSubtract - 2));
			tvResultThird.setText(String.valueOf(valueSubtract - 1));
			tvResultFour.setText(String.valueOf(valueSubtract));
			break;
		}
	}

	private OnClickListener imgFirstOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			calculate(Integer.parseInt(tvResultFirst.getText().toString()));
		}
	};
	
	private OnClickListener imgSecondOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			calculate(Integer.parseInt(tvResultSecond.getText().toString()));
		}
	};
	
	private OnClickListener imgThirdOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			calculate(Integer.parseInt(tvResultThird.getText().toString()));
		}
	};
	
	private OnClickListener imgFourOnClick = new OnClickListener() {

		@Override
		public void onClick(View v) {
			calculate(Integer.parseInt(tvResultFour.getText().toString()));
		}
	};

	private ImageView createImageView(Context context, int drawable) {
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(drawable);
		imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		return imageView;
	}
	
	private void calculate(int result){
	
		if(result == subtractNumber())
		{
			level++;
			initData();
			Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
		}
		else{
			Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
		}
	}
	
	private int subtractNumber()
	{
		String numberFirst = tvNumberFirst.getText().toString();
		String numberSecond = tvNumberSecond.getText().toString();
		int intNumberFirst = Integer.parseInt(numberFirst);
		int intNumberSecond = Integer.parseInt(numberSecond);
		if(Constants.Operation.equals("+"))
		{
			return intNumberFirst + intNumberSecond;
		}
		else{
			return intNumberFirst - intNumberSecond;
		}
	}
}