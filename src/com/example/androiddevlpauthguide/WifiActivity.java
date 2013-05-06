package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Parcelable;

public class WifiActivity extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onStart(Intent intent, int startId) {  
		Intent intentWifi = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
		intentWifi.putExtra(Intent.EXTRA_SHORTCUT_NAME,"wifi" );
		Parcelable parcelable = Intent.ShortcutIconResource
									  .fromContext(this, R.drawable.smile);
		intentWifi.putExtra(Intent.EXTRA_SHORTCUT_ICON, parcelable);
		Intent intentWifiSetting = new Intent("android.settings.WIFI_SETTINGS");
		intentWifi.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intentWifiSetting);
		sendBroadcast(intentWifi);
		super.onStart(intent, startId);  
	}
	
}
