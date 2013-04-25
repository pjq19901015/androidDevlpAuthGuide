package com.example.androiddevlpauthguide;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class CheckedTextActivity extends Activity {
	private String[] data = new String[]{"android", "java"};
	private ListView lvChecked;
	private ListView lvRadio;
	private ListView lvMultiple;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkedtext);
		lvChecked = (ListView) this.findViewById(R.id.activity_checkedtext_listview_check);
		lvRadio = (ListView) this.findViewById(R.id.activity_checkedtext_listview_radio);
		lvMultiple = (ListView) this.findViewById(R.id.activity_checkedtext_listview_multiple);
		ArrayAdapter<String> singleAdaper = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_checked, data);
		lvChecked.setAdapter(singleAdaper);
		lvChecked.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		ArrayAdapter<String> radioAdaper = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_single_choice, data);
		lvRadio.setAdapter(radioAdaper);
		lvRadio.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		ArrayAdapter<String> multipleAdaper = new ArrayAdapter<String>(
				this, android.R.layout.simple_list_item_multiple_choice, data);
		lvMultiple.setAdapter(multipleAdaper);
		lvMultiple.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}
}
