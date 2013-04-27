package com.example.adapter;


import com.example.androiddevlpauthguide.R;
import com.example.androiddevlpauthguide.R.id;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterMenu extends BaseAdapter {
	private Context context;
	public  int[] GRID_ITEM_ICON_ID_LIST = new int[]
			{ R.drawable.intercept_list, R.drawable.intercept_rule, R.drawable.intercepted_record, 
					R.drawable.location, R.drawable.incoming_and_outgoing_setting,
					R.drawable.privacy_manager, R.drawable.ip, R.drawable.dial,
					R.drawable.useful}; 

	public  static String[] GRID_ITEM_TEXT_LIST = new String[]
	{ "拦截名单", "拦截规则","拦截记录" , "归属地查询", "来去电设置", "隐私管理", "IP电话设置", "通讯记录", "常用号码"
					};
	
	public AdapterMenu(Context context) {
		this.context = context;
	}
	@Override
	public int getCount() {
		return GRID_ITEM_ICON_ID_LIST.length;
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if(convertView == null){
			convertView = LayoutInflater.from(context).inflate(R.layout.ucweb_menu_item, null);  
		}
		ImageView imageview = (ImageView) convertView.findViewById(R.id.ucweb_menu_item_imageview);
		TextView textview = (TextView) convertView.findViewById(R.id.ucweb_menu_item_textview);
		imageview.setImageResource(GRID_ITEM_ICON_ID_LIST[position]);
		textview.setText(GRID_ITEM_TEXT_LIST[position]);
		return convertView;
	}

	private class TempView{
		ImageView imageview;
		TextView textView;
	}
}
