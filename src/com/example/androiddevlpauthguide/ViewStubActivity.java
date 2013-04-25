package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class ViewStubActivity extends Activity {
	private Button btShow;
	private ViewStub vsOne;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewstub);
		btShow = (Button) this.findViewById(R.id.activity_viewstub_bt_show);
		vsOne = (ViewStub) this.findViewById(R.id.activity_viewstub_vs_one);
		btShow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				vsOne.setVisibility(View.VISIBLE); 
			}
		});
	}
}
