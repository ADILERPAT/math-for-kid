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

public class CountNumberActivity extends Activity {
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
	private int result = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		setContentView(R.layout.activity_count_number);
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
		
		int arrayFirst = CommonFunctions.random(1, 9);
		int arraySecond = CommonFunctions.random(1, 9);
		result  = arrayFirst + arraySecond;
		
		for (int i = 0; i < arrayFirst; i++) {
			linearFirst.addView(createImageView(context, R.drawable.flower_png));
		}
		for (int i = 0; i < arraySecond; i++) {
			linearSecond.addView(createImageView(context, R.drawable.flower_png));
		}
		
		int positionRand = CommonFunctions.random(1, 5);
		switch (positionRand) {
		case 1:
			tvResultFirst.setText(String.valueOf(result));
			tvResultSecond.setText(String.valueOf(result + 1));
			tvResultThird.setText(String.valueOf(result + 2));
			tvResultFour.setText(String.valueOf(result + 3));
			break;
		case 2:
			tvResultFirst.setText(String.valueOf(result - 1));
			tvResultSecond.setText(String.valueOf(result));
			tvResultThird.setText(String.valueOf(result + 1));
			tvResultFour.setText(String.valueOf(result + 2));
			break;
		case 3:
			tvResultFirst.setText(String.valueOf(result - 2));
			tvResultSecond.setText(String.valueOf(result - 1));
			tvResultThird.setText(String.valueOf(result));
			tvResultFour.setText(String.valueOf(result + 1));
			break;
		default:
			tvResultFirst.setText(String.valueOf(result - 3));
			tvResultSecond.setText(String.valueOf(result - 2));
			tvResultThird.setText(String.valueOf(result - 1));
			tvResultFour.setText(String.valueOf(result));
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
	
	private void calculate(int choose){
	
		if(choose == result)
		{
			Toast.makeText(context, "Right", Toast.LENGTH_SHORT).show();
			initData();
		}
		else{
			Toast.makeText(context, "Wrong", Toast.LENGTH_SHORT).show();
		}
	}
}