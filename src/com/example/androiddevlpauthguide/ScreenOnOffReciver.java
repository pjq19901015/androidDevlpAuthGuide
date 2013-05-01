package com.example.androiddevlpauthguide;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenOnOffReciver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if(Intent.ACTION_SCREEN_ON.equals(intent.getAction())){
			Log.i("data", "on");
		}else if(Intent.ACTION_SCREEN_OFF.equals(intent.getAction())){
			Log.i("data", "off");  
		} 
	}

}
