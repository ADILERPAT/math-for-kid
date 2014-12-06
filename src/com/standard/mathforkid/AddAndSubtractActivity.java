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

public class AddAndSubtractActivity extends Activity {
	private LinearLayout linearFirst;
	private LinearLayout linearSecond;
	private LinearLayout linearThird;
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
	private TextView tvNumberThird;
	private TextView tvOperationFirst;
	private TextView tvOperationSecond;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		setContentView(R.layout.activity_add_and_subtract);
		
		linearFirst = (LinearLayout) findViewById(R.id.linear_first);
		linearSecond = (LinearLayout) findViewById(R.id.linear_second);
		linearThird = (LinearLayout) findViewById(R.id.linear_third);

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
		tvNumberThird = (TextView)findViewById(R.id.number_third_tv);
		tvOperationFirst = (TextView)findViewById(R.id.operation_first_tv);
		tvOperationSecond = (TextView)findViewById(R.id.operation_second_tv);
		
		imgFirst.setOnClickListener(imgFirstOnClick);
		imgSecond.setOnClickListener(imgSecondOnClick);
		imgThird.setOnClickListener(imgThirdOnClick);
		imgFour.setOnClickListener(imgFourOnClick);
		
		initData();
	}
	
	private void initData(){
		int numberFirst = 0;
		int numberSecond = 0;
		int numberThird = 0;
		int operate = CommonFunctions.random(0, 4);
		
		if(operate == 0){
			tvOperationFirst.setText("+");
			tvOperationSecond.setText("-");
		}
		else if(operate == 1) {
			tvOperationFirst.setText("-");
			tvOperationSecond.setText("+");
		}
		else if(operate == 2){
			tvOperationFirst.setText("+");
			tvOperationSecond.setText("+");
		}else{
			tvOperationFirst.setText("-");
			tvOperationSecond.setText("-");
		}
		
		if(linearFirst.getChildCount() > 0) 
		    linearFirst.removeAllViews(); 
		
		if(linearSecond.getChildCount() > 0) 
		    linearSecond.removeAllViews(); 
		
		if(linearThird.getChildCount() > 0) 
		    linearThird.removeAllViews(); 
		
		if (tvOperationFirst.getText().toString().equals("+")) {
			if (tvOperationSecond.getText().toString().equals("+")) {
				numberFirst = CommonFunctions.random(1, 10);
				numberSecond = CommonFunctions.random(1, 10);
				numberThird = CommonFunctions.random(1, 10);
			}
			else{
				numberFirst = CommonFunctions.random(1, 10);
				numberSecond = CommonFunctions.random(1, 10);
	
				int max = numberFirst + numberSecond;
				numberThird = CommonFunctions.random(1, max);
			}
		}else{
			if (tvOperationSecond.getText().toString().equals("+")) {
				numberFirst = CommonFunctions.random(1, 10);
				numberSecond = CommonFunctions.random(0, numberFirst);
				numberThird = CommonFunctions.random(1, 10);
			}
			else{
				numberSecond = CommonFunctions.random(1, 10);
				numberThird = CommonFunctions.random(1, 10);
	
				int min = numberThird + numberSecond;
				int max = CommonFunctions.random(1, 10) + min;
				numberFirst = CommonFunctions.random(min, max);
			}
		}
		for (int i = 0; i < numberFirst; i++) {
			linearFirst.addView(createImageView(context, R.drawable.star));
		}
		for (int i = 0; i < numberSecond; i++) {
			linearSecond.addView(createImageView(context, R.drawable.star));
		}
		for (int i = 0; i < numberThird; i++) {
			linearThird.addView(createImageView(context, R.drawable.star));
		}
		
		tvNumberFirst.setText(String.valueOf(numberFirst));
		tvNumberSecond.setText(String.valueOf(numberSecond));		
		tvNumberThird.setText(String.valueOf(numberThird));
		
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
			Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
			initData();
		}
		else{
			Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
		}
	}
	
	private int subtractNumber()
	{
		String numberFirst = tvNumberFirst.getText().toString();
		String numberSecond = tvNumberSecond.getText().toString();
		String numberThird = tvNumberThird.getText().toString();
		int intNumberFirst = Integer.parseInt(numberFirst);
		int intNumberSecond = Integer.parseInt(numberSecond);
		int intNumberThird = Integer.parseInt(numberThird);
		
		String operationFirst = tvOperationFirst.getText().toString();
		String operationSecond = tvOperationSecond.getText().toString();
		if(operationFirst.equals("+") && operationSecond.equals("+"))
		{
			return intNumberFirst + intNumberSecond + intNumberThird;
		}
		else if(operationFirst.equals("+") && operationSecond.equals("-")){
			return intNumberFirst + intNumberSecond - intNumberThird;
		}
		else if(operationFirst.equals("-") && operationSecond.equals("+")){
			return intNumberFirst - intNumberSecond + intNumberThird;
		}
		else{
			return intNumberFirst - intNumberSecond - intNumberThird;
		}
	}
}