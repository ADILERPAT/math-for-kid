package com.standard.mathforkid;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.standard.mathforkid.adapter.ImageNumberAdapter;
import com.standard.mathforkid.adapter.SpinnerAdapter;
import com.standard.mathforkid.base.BaseActivity;
import com.standard.mathforkid.globalvariable.CommonUtility;
import com.standard.mathforkid.inteface.InputDialogOnclickListener;
import com.startapp.android.publish.StartAppAd;
import com.startapp.android.publish.StartAppSDK;

public class MainActivity extends BaseActivity {
	
	private Activity context;
	private GridView gvResult;
	private TextView tvNumberFirst;
	private TextView tvNumberSecond;
	private TextView tvResult;
	private TextView tvOperation;
	private Spinner spOperation;
	private Spinner spLevel;
	private Button btnNew;
	
	private List<String> listNumber;
	private int result = 3;
	private int positionOrder = 0;
	private String level = "1";
	private String operation = "+";
	private ImageNumberAdapter sizeArrayAdapter;
	
	private int[] listPosition;
	private boolean isFirst = true;
	
	private Timer timer;
	private MyTimerTask myTimerTask;
	
	private StartAppAd startAppAd = new StartAppAd(this);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.context = this;
		StartAppSDK.init(this, "107807268", "208376262", true);
		if(!networkEnabled())
		{
			EnableNetWork();			
		}else{
			startAppAd.showAd();
			startAppAd.loadAd();
		}
		LoadData();
		
	}
	@Override
	public int layoutResources() {
		return R.layout.activity_main;
	}

	@Override
	public void loadControls() {
		gvResult = (GridView)findViewById(R.id.result_gv);
		tvNumberFirst =(TextView)findViewById(R.id.first_number_tv);
		tvNumberSecond =(TextView)findViewById(R.id.second_number_tv);
		tvResult = (TextView)findViewById(R.id.result_tv);
		tvOperation = (TextView)findViewById(R.id.operation_tv);
		spOperation = (Spinner)findViewById(R.id.choose_operation);
		spOperation.setVisibility(View.GONE);
		spLevel = (Spinner)findViewById(R.id.choose_level);
		btnNew = (Button)findViewById(R.id.play_new_btn);
		
	}

	@Override
	public void bindEvents() {
		gvResult.setOnItemClickListener(new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		    	TextView title = (TextView) v.findViewById(R.id.title);
		    	ImageView image = (ImageView)v.findViewById(R.id.image_list);
		    	int answer = Integer.valueOf(title.getText().toString());
		    	if(result == answer && image.getVisibility() == View.VISIBLE){
		    		image.setVisibility(View.INVISIBLE);
		    		title.setVisibility(View.INVISIBLE);
					positionOrder++;
					if(positionOrder < 9){
						getNumberFirstRandom(positionOrder);
					}
					else {
						Toast.makeText(getApplicationContext(), getResources().getString(R.string.congratulation), Toast.LENGTH_LONG).show();
						//showDialog();
					}
		    	}
		    	else{
		    		Toast.makeText(getApplicationContext(), getResources().getString(R.string.choose_wrong), Toast.LENGTH_SHORT).show();
		    	}
		    }
		});
		spLevel.setOnItemSelectedListener(spLevelOnItemSelected);
		spOperation.setOnItemSelectedListener(spOperationOnItemSelected);
		btnNew.setOnClickListener(btnNewOnClickListener);
	}
	private OnClickListener btnNewOnClickListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			positionOrder = 0;
			gvResult.setBackgroundResource(CommonUtility.getBackground(context));
			fillGridView();
		}
	};
	
	private OnItemSelectedListener  spLevelOnItemSelected = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			
			level = parent.getItemAtPosition(position).toString();
			positionOrder = 0;
			fillGridView();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		};
	};
	
	private OnItemSelectedListener spOperationOnItemSelected = new OnItemSelectedListener() {
		public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
			tvOperation.setText(operation);
			if(isFirst){
				isFirst = false;
				return;
			}
			fillGridView();
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {
		};
	};
	
	private void fillGridView(){
		listNumber = new ArrayList<String>();
		listNumber = CommonUtility.listNumber(Integer.valueOf(level),operation);
		listPosition = CommonUtility.createListPosition();
		getNumberFirstRandom(positionOrder);
		
		sizeArrayAdapter = new ImageNumberAdapter(context,listNumber);
		gvResult.setAdapter(sizeArrayAdapter);
	}
	
	private void LoadData(){
		if (timer != null) {
			timer.cancel();
		}

		timer = new Timer();
		myTimerTask = new MyTimerTask();
		timer.schedule(myTimerTask, 1000, 180000);
		
		gvResult.setBackgroundResource(CommonUtility.getBackground(context));
		tvOperation.setText("+");
		
		String[] listLevel = getResources().getStringArray(R.array.level_list);
		ArrayAdapter<String> adapterLevel = new SpinnerAdapter(this, listLevel);
		adapterLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spLevel.setAdapter(adapterLevel);
		
		String[] listOperation = getResources().getStringArray(R.array.operatin_list);
		ArrayAdapter<String> adapterOperation = new SpinnerAdapter(this, listOperation);
		adapterOperation.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spOperation.setAdapter(adapterOperation);
	}

	// =====================
	public void getNumberFirstRandom(int position) {
		result = Integer.valueOf(listNumber.get(listPosition[position]));
		int firstNumber = result;
		if(result != 1){
			firstNumber = CommonUtility.randomNumber(result, 0);
		}
		int secondNumber = result - firstNumber;
		tvNumberFirst.setText(String.valueOf(firstNumber));
		tvNumberSecond.setText(String.valueOf(secondNumber));
		tvResult.setText("?");
	}

	public void showDialog() {
		ConfirmDialog confirmDialog = new ConfirmDialog(context);
		confirmDialog.setDialogClickListener(new InputDialogOnclickListener() {
			@Override
			public boolean onSubmitDialogClick(String receive) {
				positionOrder = 0;
				fillGridView();
				return false;
			}

			@Override
			public boolean onCancelDialogClick(String receive) {
				context.finish();
				return false;
			}
		});
		confirmDialog.show();
	}
	
	public boolean networkEnabled() {

		ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo wifiNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
		if (wifiNetwork != null && wifiNetwork.isConnected()) {
			return true;
		}

		NetworkInfo mobileNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
		if (mobileNetwork != null && mobileNetwork.isConnected()) {
			return true;
		}

		NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
		if (activeNetwork != null && activeNetwork.isConnected()) {
			return true;
		}
		return false;
	}
	
	private void EnableNetWork(){
		ConnectivityManager mgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		Method dataMtd = null;
		try {
			dataMtd = ConnectivityManager.class.getDeclaredMethod("setMobileDataEnabled", boolean.class);
			dataMtd.setAccessible(true);
			dataMtd.invoke(mgr,true);// true/false); 
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	class MyTimerTask extends TimerTask {

		@Override
		public void run() {
			runOnUiThread(new Runnable() {

				@Override
				public void run() {
					
					if (!networkEnabled()) {
						EnableNetWork();
					} else {
						startAppAd.showAd();
						startAppAd.loadAd();
					}
				}
			});
		}

	}
	
	@Override
	public void onBackPressed() {
		startAppAd.onBackPressed();
		super.onBackPressed();
	}
	
	@Override
	protected void onStop() {
		if (timer != null) {
			timer.cancel();
		}
		super.onStop();
	}
}
