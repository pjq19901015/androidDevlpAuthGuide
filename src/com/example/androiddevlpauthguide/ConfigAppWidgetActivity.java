package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfigAppWidgetActivity extends Activity {
	private Button button;
	private EditText editText;
	private int mAppWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app_widget);
		button = (Button) this.findViewById(R.id.app_widget_button);
		editText = (EditText) this.findViewById(R.id.app_widget_edittext);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String str = editText.getText().toString();
				SharedPreferences sharedPreferences = 
						getSharedPreferences("appwidget", Activity.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				editor.putString("input", str);
				editor.commit();
				AppWidgetManager appWidgetManager = 
						AppWidgetManager.getInstance(ConfigAppWidgetActivity.this);
				MyAppWidgetProvider.updateView(ConfigAppWidgetActivity.this, 
											   appWidgetManager,
											   mAppWidgetId,
											   str);    
				finish();
			}
		});
	}
}
