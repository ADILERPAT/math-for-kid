package com.standard.mathforkid;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.standard.mathforkid.common.CommonFunctions;

public class RemeberNumberActivity extends Activity {

	private Context context;
	private TextView tvFirst;
	private TextView tvSecond;
	private TextView tvThird;
	private TextView tvFour;
	private TextView tvFive;
	private TextView tvSix;
	private TextView tvSeven;
	private TextView tvEight;
	private TextView tvNine;
	private TextView tvTen;
	private TextView tvEleven;
	private TextView tvTwelve;

	private ImageView imgFirst;
	private ImageView imgSecond;
	private ImageView imgThird;
	private ImageView imgFour;
	private ImageView imgFive;
	private ImageView imgSix;
	private ImageView imgSeven;
	private ImageView imgEight;
	private ImageView imgNine;
	private ImageView imgTen;
	private ImageView imgEleven;
	private ImageView imgTwelve;
	
	private int positionClick = 0;
	private String valueClick;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = getApplicationContext();
		setContentView(R.layout.activity_remember);
		tvFirst = (TextView) findViewById(R.id.first_tv);
		tvSecond = (TextView) findViewById(R.id.second_tv);
		tvThird = (TextView) findViewById(R.id.third_tv);
		tvFour = (TextView) findViewById(R.id.four_tv);
		tvFive = (TextView) findViewById(R.id.five_tv);
		tvSix = (TextView) findViewById(R.id.six_tv);
		tvSeven = (TextView) findViewById(R.id.seven_tv);
		tvEight = (TextView) findViewById(R.id.eight_tv);
		tvNine = (TextView) findViewById(R.id.nine_tv);
		tvTen = (TextView) findViewById(R.id.ten_tv);
		tvEleven = (TextView) findViewById(R.id.eleven_tv);
		tvTwelve = (TextView) findViewById(R.id.twelve_tv);

		imgFirst = (ImageView) findViewById(R.id.first_img);
		imgSecond = (ImageView) findViewById(R.id.second_img);
		imgThird = (ImageView) findViewById(R.id.third_img);
		imgFour = (ImageView) findViewById(R.id.four_img);
		imgFive = (ImageView) findViewById(R.id.five_img);
		imgSix = (ImageView) findViewById(R.id.six_img);
		imgSeven = (ImageView) findViewById(R.id.seven_img);
		imgEight = (ImageView) findViewById(R.id.eight_img);
		imgNine = (ImageView) findViewById(R.id.nine_img);
		imgTen = (ImageView) findViewById(R.id.ten_img);
		imgEleven = (ImageView) findViewById(R.id.eleven_img);
		imgTwelve = (ImageView) findViewById(R.id.twelve_img);

		imgFirst.setOnClickListener(imgFirstOnClick);
		imgSecond.setOnClickListener(imgSecondOnClick);
		imgThird.setOnClickListener(imgThirdOnClick);
		imgFour.setOnClickListener(imgFourOnClick);
		imgFive.setOnClickListener(imgFiveOnClick);
		imgSix.setOnClickListener(imgSixOnClick);
		imgSeven.setOnClickListener(imgSevenOnClick);
		imgEight.setOnClickListener(imgEightOnClick);
		imgNine.setOnClickListener(imgNineOnClick);
		imgTen.setOnClickListener(imgTenOnClick);
		imgEleven.setOnClickListener(imgElevenOnClick);
		imgTwelve.setOnClickListener(imgTwelveOnClick);
		initData();
	}

	private void initData(){
		ArrayList<Integer> exceptList = new ArrayList<Integer>();
		int first = CommonFunctions.random(1, 10);
		tvFirst.setText(String.valueOf(first));;
		exceptList.add(first);
		int second = CommonFunctions.randomEx(1, 10,exceptList);
		tvSecond.setText(String.valueOf(second));
		exceptList.add(second);
		int third = CommonFunctions.randomEx(1, 10,exceptList);
		tvThird.setText(String.valueOf(third));
		exceptList.add(third);
		int four = CommonFunctions.randomEx(1, 10,exceptList);
		tvFour.setText(String.valueOf(four));
		exceptList.add(four);
		int five = CommonFunctions.randomEx(1, 10,exceptList);
		tvFive.setText(String.valueOf(five));
		exceptList.add(five);
		int six = CommonFunctions.randomEx(1, 10,exceptList);
		tvSix.setText(String.valueOf(six));
		exceptList.add(six);
		
		
		ArrayList<Integer> arrayExeption = new ArrayList<Integer>();
		int seven = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvSeven.setText(String.valueOf(exceptList.get(seven)));
		arrayExeption.add(seven);
		int eight = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvEight.setText(String.valueOf(exceptList.get(eight)));
		arrayExeption.add(eight);
		int nine = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvNine.setText(String.valueOf(exceptList.get(nine)));
		arrayExeption.add(nine);
		int ten = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvTen.setText(String.valueOf(exceptList.get(ten)));
		arrayExeption.add(ten);
		int eleven = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvEleven.setText(String.valueOf(exceptList.get(eleven)));
		arrayExeption.add(eleven);
		int twelve = CommonFunctions.randomInArray(exceptList,arrayExeption);
		tvTwelve.setText(String.valueOf(exceptList.get(twelve)));
	
	}
	
	private OnClickListener imgFirstOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 1;
			tvFirst.setVisibility(View.GONE);
			imgFirst.setVisibility(View.GONE);
		}
	};
	private OnClickListener imgSecondOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 2;
		}
	};
	private OnClickListener imgThirdOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 3;
		}
	};
	private OnClickListener imgFourOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 4;
		}
	};
	private OnClickListener imgFiveOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 5;
		}
	};
	private OnClickListener imgSixOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
			positionClick = 6;
		}
	};
	private OnClickListener imgSevenOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

		}
	};
	private OnClickListener imgEightOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
		}
	};
	private OnClickListener imgNineOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {
		}
	};
	private OnClickListener imgTenOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

		}
	};
	private OnClickListener imgElevenOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

		}
	};
	private OnClickListener imgTwelveOnClick = new OnClickListener() {

		@Override
		public void onClick(View arg0) {

		}
	};

}