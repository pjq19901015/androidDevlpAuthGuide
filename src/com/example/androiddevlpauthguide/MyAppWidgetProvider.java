package com.example.androiddevlpauthguide;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.SharedPreferences; 
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {

	public static void updateView(Context context,
			AppWidgetManager appWidgetManager, int mAppWidgetId, String str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		SharedPreferences sharedPreferences = 
				context.getSharedPreferences("appwidget", Activity.MODE_PRIVATE);
		//String str2 = sharedPreferences.getString("input", "") + "\n";
		str += simpleDateFormat.format(new Date());
		RemoteViews views = new RemoteViews(context.getPackageName(), 
										   R.layout.appwidget_provider);
		views.setTextViewText(R.id.appwidget_provider_textview, str);
		appWidgetManager.updateAppWidget(mAppWidgetId, views);
	}
	
}
