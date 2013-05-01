package com.example.androiddevlpauthguide;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SqliteActivity extends Activity {
	@Override
	protected void onCreate(Bundle arg0) { 
		super.onCreate(arg0);
		setContentView(R.layout.publish_sqlite);
	}
	
	public void click(View view) {
		int id = view.getId();
		switch(id){
		case R.id.publish_sqlite_one:
			InputStream is = getResources().openRawResource(R.raw.apk_test);
			FileOutputStream fileOS;
			try {
				fileOS = new FileOutputStream("/sdcard/apk_test.db");
				byte[] buffer = new byte[8192];
				int count;
				while((count = is.read(buffer)) >= 0 ){
					fileOS.write(buffer,0,count);
				}
				fileOS.close();
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			SQLiteDatabase sqLiteDatabase = 
					SQLiteDatabase.openOrCreateDatabase("/sdcard/apk_test.db", null);
			Cursor cursor = sqLiteDatabase.rawQuery("select * from t_test", null);
			if(cursor.moveToFirst()){
				Toast.makeText(SqliteActivity.this, cursor.getString(1), 1).show();
			}
			cursor.close();
			sqLiteDatabase.close();
			break;
		case R.id.publish_sqlite_two:
			InputStream is2 = getResources().openRawResource(R.raw.apk_test_large);
			try {
				FileOutputStream fileOS2 = new FileOutputStream("/sdcard/apk_test_large.db");
				byte[] buffer = new byte[8291];
				int count;
				while((count = is2.read(buffer)) >= 0){
					fileOS2.write(buffer,0,count);
				}
				fileOS2.close();
				is2.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SQLiteDatabase sqLiteDatabase2 = 
					SQLiteDatabase.openOrCreateDatabase("/sdcard/apk_test_large.db",null);
			Cursor cursor2 = sqLiteDatabase2.rawQuery("select * from t_test limit 1,1",null);
			if(cursor2.moveToFirst()){
				Toast.makeText(this, cursor2.getString(1), 1).show();
			}
			break;
		}
	}
}
