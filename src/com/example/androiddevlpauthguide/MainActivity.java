package com.example.androiddevlpauthguide;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.PopupWindow;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity  {
	private Button buttonAddMenu;
	private Menu menu;
	private int state;
	private PopupWindow popwindow;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAddMenu = (Button) this.findViewById(R.id.main_button_addmenu);
        buttonAddMenu.setOnClickListener(new View.OnClickListener(){ 
			@Override
			public void onClick(View v) {
				if(menu != null){
					for(int i = 10; i < 15; i++){
						menu.add(1, i, i, "菜单" + i);
					}
				}    
			} 
        });
        registerForContextMenu(buttonAddMenu);
    }
    
   /*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    this.menu = menu;
		MenuItem fileitem = menu.add(1,1,1,"文件");
		fileitem.setIcon(R.drawable.star);
		fileitem.setIntent(new Intent(this,CheckedTextActivity.class));
	   	MenuItem menuitemExit = menu.add(1,2,3,"退出");
	   	//menuitemExit.setOnMenuItemClickListener(this);
	   	menu.add(1,3,2,"更新");
	   	SubMenu submenu = menu.addSubMenu(1, 4, 4, "子菜单");
	   	submenu.setIcon(R.drawable.file);
	   	submenu.setHeaderIcon(R.drawable.headerfile);
	   	submenu.add(2, 5, 5, "新建");
	   	submenu.add(2, 6, 6, "打开");
	   	submenu.add(2, 7, 7, "退出");
	   	submenu.setGroupCheckable(2, true, false);
	   	getMenuInflater().inflate(R.menu.file_menu, menu);
	   	return super.onCreateOptionsMenu(menu);
	}*/

	/*@Override
	public boolean onMenuItemClick(MenuItem item) {
		finish();
		return false;
	}
   
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		super.onMenuItemSelected(featureId, item);
		if(item.getItemId() == 2){
			finish();
		}
		Log.i("data", "onMenuItemSelected");
		return true;
	}*/
	
	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i("data", "onOptionsItemSelected");
		if(item.getItemId() == 2){
			finish();
		}
		return super.onOptionsItemSelected(item);
	}*/
  /*  @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.setHeaderTitle("上下文菜单");
    	menu.setHeaderIcon(R.drawable.file);
    	menu.add(1, 1, 1, "菜单1");
    }*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    	
    	 
    	if(keyCode == KeyEvent.KEYCODE_MENU){
    		View layout = getLayoutInflater().inflate(R.layout.custom_menu, null);
    		popwindow = new PopupWindow(layout,
    				getWindowManager().getDefaultDisplay().getWidth(),
    				getWindowManager().getDefaultDisplay().getHeight());
Log.i("data", "width:" + getWindowManager().getDefaultDisplay().getWidth() + 
			  "height: " + getWindowManager().getDefaultDisplay().getHeight());
    		popwindow.showAtLocation(layout,Gravity.BOTTOM , 0, 0);
    		state = 1;
    		return true;
    	}else if(keyCode == KeyEvent.KEYCODE_BACK){
    		if(state == 1){
    			popwindow.dismiss();
    			state = 2; 
    		}else if(state == 2){
    			finish();
    		}
    		return true;
    	}
    	return super.onKeyDown(keyCode, event);
    }

}
