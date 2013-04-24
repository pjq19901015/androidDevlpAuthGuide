package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

public class CheckedTextActivity extends Activity {
	private String[] data = new String[]{"android", "java"}; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkedtext);
		ArrayAdapter<String> singleAdaper = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_checked, data);
		
	}
}
