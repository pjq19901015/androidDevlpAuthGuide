package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnimationActivity extends Activity {
	private Button buttonOne;
	private Button buttonTwo;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.animation);
		buttonOne = (Button) this.findViewById(R.id.animation_button_one);
		buttonTwo= (Button) this.findViewById(R.id.animation_button_two);
		buttonOne.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new  Intent(AnimationActivity.this,AnimationActivity2.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.fade);
				
			}
		});
		buttonTwo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new  Intent(AnimationActivity.this,AnimationActivity2.class);
				startActivity(intent);
				overridePendingTransition(R.anim.hyperspace, R.anim.hyperspace);
			}
		});
	}
}
