package com.example.androiddevlpauthguide;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CustomActionActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.custom_action);

	}
	
	public void click(View view) {
		int id = view.getId();
		switch(id){
		case R.id.custom_action_one:
			Intent intent = new Intent("android.intent.action.MyActivity");
			intent.setType("audio/*");
			startActivity(intent);
			break;
		case R.id.custom_action_two:
			Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
			intent2.setType("audio/*");
			startActivity(intent2);
			break;
		}
	}
}
