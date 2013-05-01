package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.TextView;

public class BatteryActivity extends Activity {
	private TextView textview;
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		
		@Override
		public void onReceive(Context context, Intent intent) {
			if(Intent.ACTION_BATTERY_CHANGED.equals(intent.getAction())){
				int cuurent = intent.getIntExtra("level", 0);
				int lenghth = intent.getIntExtra("scale", 100);
				textview.setText("电池总量为：" + (cuurent*100)/lenghth + "%");
			}  
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.battery);
		textview = (TextView) this.findViewById(R.id.battery_textview);
		registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
	}
}
