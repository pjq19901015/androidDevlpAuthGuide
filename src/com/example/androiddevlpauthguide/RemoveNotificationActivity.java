package com.example.androiddevlpauthguide;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;
import android.widget.RemoteViews.RemoteView;
import android.widget.Toast;

public class RemoveNotificationActivity extends Activity {
	private Object obj;
	private NotificationManager notificationManager;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remove_notification);
		 notificationManager = (NotificationManager) 
					getSystemService(NOTIFICATION_SERVICE);
		 String msg = getIntent().getStringExtra("msg");
		 if(msg != null){
			 Toast.makeText(this, msg, 1).show();
		 }
		 Notification notification = new Notification(R.drawable.smile,
				 									  "短信",
				 									  System.currentTimeMillis());
		 RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.custom_notification);
		 notification.contentView =  remoteViews;
		 notificationManager.notify(1, notification);
	}
	
	public void click(View view){
		int id = view.getId();
		switch(id){
		case R.id.remove_notification_button_showmessage: 
			 Notification notification  = new Notification(R.drawable.smile,
					 									   "短信",
					 									   System.currentTimeMillis());
			 Intent intent = new Intent(this,RemoveNotificationActivity.class);
			 intent.putExtra("msg", "消息");
			 PendingIntent pendingIntent = PendingIntent.getActivity(this,
					 												 0, 
					 												 intent,
					 												 0);
			 notification.setLatestEventInfo(this,
					 						 "短信",
					 						 "最近怎么样",
					 						 pendingIntent);
			 notification.flags = Notification.FLAG_NO_CLEAR;
			 notificationManager.notify(1, notification);
			break;
		case R.id.remove_notification_button_clearmessage:
			notificationManager.cancelAll();
			break;
		}
	}
}
