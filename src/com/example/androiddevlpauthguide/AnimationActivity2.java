package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AnimationActivity2 extends Activity {
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.animation_activity);
		
	}
	
	public void click(View view){
		Intent intent = new  Intent(this,AnimationActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.fade, R.anim.fade);
	}
}
