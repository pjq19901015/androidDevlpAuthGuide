package com.example.androiddevlpauthguide;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ControlToastActivity extends Activity {
	private Object obj;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.control_toast);
	}
	
	public void click(View view){
		int id = view.getId();
		switch(id){
		case R.id.control_toast_button_showtoast:
			Toast toast = Toast.makeText(ControlToastActivity.this, "ÓÀ²»¹Ø±ÕµÄToast", 1);
			try {
				Field field = toast.getClass().getDeclaredField("mTN");
				field.setAccessible(true);
				obj = field.get(toast);
				Method method = obj.getClass().getDeclaredMethod("show", null);
				method.invoke(obj, null);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case R.id.control_toast_button_closetoast:
			try {
				Method method = obj.getClass().getDeclaredMethod("hide", null);
				method.invoke(obj, null);
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			break;
		}
	}
}
