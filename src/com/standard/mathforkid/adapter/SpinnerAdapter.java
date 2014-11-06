package com.standard.mathforkid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.standard.mathforkid.R;

public class SpinnerAdapter extends ArrayAdapter<String> {

	private LayoutInflater mInflater;

	public SpinnerAdapter(Context context, String[] listSize) {
		super(context, 0, listSize);
		init(context);
	}

	private void init(Context context) {
		this.mInflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.spinner_item, parent,false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		viewHolder.textSize.setText(getItem(position));

		return convertView;
	}

	static class ViewHolder {
		TextView textSize;

		private ViewHolder(View rootView) {
			textSize = (TextView) rootView.findViewById(R.id.text_size);
		}
	}
}
