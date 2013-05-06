package com.example.androiddevlpauthguide;

import java.text.SimpleDateFormat;
import java.util.Date;


import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;  
import android.util.Log;
import android.widget.RemoteViews;

public class MyAppWidgetProvider extends AppWidgetProvider {
	
	public static void updateView(Context context,
			AppWidgetManager appWidgetManager, int mAppWidgetId, String str) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		
		CharSequence strChar = str +  simpleDateFormat.format(new Date());
		RemoteViews views = new RemoteViews(context.getPackageName(), 
										   R.layout.appwidget_provider2);
		views.setTextViewText(R.id.appwidget_provider_textview, strChar); 
		appWidgetManager.updateAppWidget(mAppWidgetId, views);
	}
	
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) { 
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++)
		{
			int appWidgetId = appWidgetIds[i];
			String titlePrefix = ConfigAppWidgetActivity.loadTitle(context);
Log.i("data", titlePrefix);
			updateView(context, appWidgetManager, appWidgetId, titlePrefix);
		}
	}
	  
}
