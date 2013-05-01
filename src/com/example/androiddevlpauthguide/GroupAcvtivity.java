package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class GroupAcvtivity extends ActivityGroup {
	private Button button;
	private LinearLayout linerLayout1;
	private LinearLayout linerLayout2;
	private LinearLayout linerLayout3;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.group_activity);
		button  = (Button) this.findViewById(R.id.group_activity_button_footer);
		linerLayout1 = (LinearLayout) this.findViewById(R.id.group_activity_linearlayout_one);
		linerLayout2 = (LinearLayout) this.findViewById(R.id.group_activity_linearlayout_two);
		linerLayout3 = (LinearLayout) this.findViewById(R.id.group_activity_linearlayout_three);
		
		View activity1 = getLocalActivityManager().startActivity(
				"activity1", new Intent(this,Activity1.class)).getDecorView();
		View activity2 = getLocalActivityManager().startActivity(
				"activity2", new Intent(this,Activity2.class)).getDecorView();
		View activity3 = getLocalActivityManager().startActivity(
				"activity3", new Intent(this,Activity3.class)).getDecorView();
		linerLayout1.addView(activity1);
		linerLayout2.addView(activity2);
		linerLayout3.addView(activity3);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(GroupAcvtivity.this, button.getText(), 1).show();
				
			}
		});
	}
}
