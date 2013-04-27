package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.widget.TextView;

public class DialogActivity extends Activity {
	private String[] privences = new String[]{"上海市", "北京市","香港","澳门"};
	private TextView textview;
	private int index;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		textview = (TextView) this.findViewById(R.id.activity_main_textview);
		/*new AlertDialog.Builder(this).setTitle("列表对话框")
			.setItems(privences, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					textview.setText(privences[which]);
					
				}
			}).show();*/
		/*new AlertDialog.Builder(this).setTitle("单选列表框")
			.setSingleChoiceItems(privences, 0, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					index = which;
					
				}
			})
			.setPositiveButton("确定", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					textview.setText(privences[index]);  
				}
			}).show();*/
		/*new AlertDialog.Builder(this).setTitle("单选列表框")
		.setMultiChoiceItems(privences, null, new OnMultiChoiceClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which,
					boolean isChecked) {
				
				
			}
			
			
		})
		.setPositiveButton("确定", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				textview.setText(privences[index]);  
			}
		}).show();*/
	}
}
