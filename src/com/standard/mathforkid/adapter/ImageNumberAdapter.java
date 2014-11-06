package com.standard.mathforkid.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.standard.mathforkid.R;

public class ImageNumberAdapter extends ArrayAdapter<String>{

	private LayoutInflater mInflater;
	public ImageNumberAdapter(Context context, List<String> objects) {
		super(context, 0, objects);
		init(context);
	}

	private void init(Context context) {
		this.mInflater = LayoutInflater.from(context);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder viewHolder;
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.gridview_image_item, parent, false);
			viewHolder = new ViewHolder(convertView);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}
		
		viewHolder.textView.setText(getItem(position));
		viewHolder.imageView.setImageResource(R.drawable.image_item);
	
		return convertView;
	}

	static class ViewHolder {
		
		TextView textView;
		ImageView imageView;
		private ViewHolder(View rootView) {
			textView = (TextView) rootView.findViewById(R.id.title);
			imageView =(ImageView) rootView.findViewById(R.id.image_list);
		}
	}
}
