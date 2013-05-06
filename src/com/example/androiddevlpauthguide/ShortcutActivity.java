package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

public class ShortcutActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		if(Intent.ACTION_CREATE_SHORTCUT.equals(getIntent().getAction())){
			Intent intentAddShortcut = new Intent();
			intentAddShortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, "´òµç»°2");
			Parcelable parcelable = Intent.ShortcutIconResource
										  .fromContext(this,R.drawable.star);
			intentAddShortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, parcelable);
			Intent intentCall = new Intent(Intent.ACTION_DIAL,Uri.parse("12345678"));
			intentAddShortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, intentCall);
			startService(new Intent(this,WifiActivity.class));
			setResult(RESULT_OK, intentAddShortcut);
			
		}else{   
			setResult(RESULT_CANCELED);
		}
		finish();  
	}
}
