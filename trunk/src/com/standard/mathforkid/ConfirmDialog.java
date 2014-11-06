package com.standard.mathforkid;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.standard.mathforkid.globalvariable.GlobalVariable;
import com.standard.mathforkid.globalvariable.SharedPreferencesUtility;
import com.standard.mathforkid.inteface.InputDialogOnclickListener;


public class ConfirmDialog {

    private AlertDialog mAlertDialog;
    private InputDialogOnclickListener mListener;
    
    public void setDialogClickListener(InputDialogOnclickListener listener) {
        mListener = listener;
    }
    
    public ConfirmDialog(final Context context) {
        LayoutInflater li = LayoutInflater.from(context);
        View promptsView = li.inflate(R.layout.comment_dialog, null);
        TextView tvLevel = (TextView)promptsView.findViewById(R.id.score_level);
        TextView tvBestLevel = (TextView)promptsView.findViewById(R.id.best_level);
        tvLevel.setText(String.valueOf(GlobalVariable.level));
        int bestLevel =  SharedPreferencesUtility.getIntPreferences(GlobalVariable.BestLevel, 0, context);
        if(GlobalVariable.level>bestLevel)
        {
        	SharedPreferencesUtility.savePreferences(GlobalVariable.BestLevel, GlobalVariable.level, context);
        	tvBestLevel.setText(String.valueOf(GlobalVariable.level));
        }
        else{
        	tvBestLevel.setText(String.valueOf(bestLevel));
        }
        
        ImageButton btnPlay =(ImageButton) promptsView.findViewById(R.id.btn_submit);
        
        btnPlay.setOnClickListener( new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mListener!=null){					
					 mListener.onSubmitDialogClick("0");
					 mAlertDialog.dismiss();
				}
			}
		});
       
        ImageButton btnCancel = (ImageButton)promptsView.findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mListener!=null){
					mListener.onCancelDialogClick("0");
					mAlertDialog.dismiss();
					
				}
			}
		});
        
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptsView);
        
        // create alert dialog
        mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.setCanceledOnTouchOutside(false);
        mAlertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
			
			@Override
			public void onCancel(DialogInterface dialog) {
				if(mListener!=null){					
					 mListener.onCancelDialogClick("0");
					 mAlertDialog.dismiss();
				}
				
			}
		});
    }
    
    public void show() {
        if (mAlertDialog != null) {
            mAlertDialog.show();
        }
    }
    
    
}
