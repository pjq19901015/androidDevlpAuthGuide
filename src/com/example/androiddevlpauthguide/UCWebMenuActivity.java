package com.example.androiddevlpauthguide;

import com.example.adapter.AdapterMenu;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class UCWebMenuActivity extends Activity implements OnKeyListener,OnItemClickListener {
	private GridView gridview;
	private PopupWindow popupWindow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		gridview = (GridView) getLayoutInflater().inflate(R.layout.ucweb_menu, null);
		AdapterMenu adapter = new AdapterMenu(this);
		gridview.setAdapter(adapter);
		popupWindow = new PopupWindow(gridview,
									  LayoutParams.MATCH_PARENT,
									  LayoutParams.WRAP_CONTENT);
		gridview.setOnKeyListener(this); 
		gridview.setOnItemClickListener(this);
		popupWindow.setFocusable(true); 
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		popupWindow.dismiss();
		Toast.makeText(this, AdapterMenu.GRID_ITEM_TEXT_LIST[position], 1).show();
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		if(keyCode == KeyEvent.KEYCODE_BACK){
			if(popupWindow.isShowing()){
				popupWindow.dismiss();
			}else{
				finish();
			}
		}
		return false;
	} 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) { 
		menu.add("menu"); 
		return super.onCreateOptionsMenu(menu);
	}
	 
	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		
		if(popupWindow.isShowing()){
			popupWindow.dismiss();
		}else{ 
			View layout = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
			popupWindow.showAtLocation(layout, Gravity.BOTTOM, 0, 0);
		}
		
		return false;  
	}
}
