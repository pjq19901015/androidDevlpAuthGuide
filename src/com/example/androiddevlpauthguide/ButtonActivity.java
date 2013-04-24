package com.example.androiddevlpauthguide;

import java.lang.reflect.Field;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.Button;

public class ButtonActivity extends Activity {
	private Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_button);
		button = (Button) this.findViewById(R.id.activity_button_bt_five);
		setButtonTextAndImage(button);
	}
	
	private void setButtonTextAndImage(Button button) {
		Bitmap bmLeft = BitmapFactory.decodeResource(getResources(), R.drawable.image_left);
		Bitmap bmRight = BitmapFactory.decodeResource(getResources(), R.drawable.image_right);
		ImageSpan leftImageSpan = new ImageSpan(ButtonActivity.this, bmLeft);
		ImageSpan rightImageSpan = new ImageSpan(ButtonActivity.this, bmRight);
		SpannableString leftSpannableString = new SpannableString("1");
		leftSpannableString.setSpan(leftImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		SpannableString rightSpannableString = new SpannableString("2");
		rightSpannableString.setSpan(rightImageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
		button.append(leftSpannableString);
		button.append("°´Å¥5");
		button.append(rightSpannableString);
	}
	
	
}
