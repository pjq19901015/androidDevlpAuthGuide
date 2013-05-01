package com.example.androiddevlpauthguide;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import android.preference.PreferenceActivity;
import android.preference.PreferenceScreen; 

public class CustomPerferencesActivity extends PreferenceActivity 
				implements OnPreferenceChangeListener  {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preference);
		Preference preferenceName = findPreference("name");
		SharedPreferences sharedPreferencesName = preferenceName.getSharedPreferences();
		preferenceName.setSummary(sharedPreferencesName.getString("name", "  "));
		if(sharedPreferencesName.getBoolean("is_save_Indivualmessage", false)){
			preferenceName.setEnabled(true);
		}else{
			preferenceName.setEnabled(false);
		}
		preferenceName.setOnPreferenceChangeListener(this);
	}
	
	@Override
	public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen,
			Preference preference) {
		
		if("is_save_Indivualmessage" .equals(preference.getKey())){ 
			findPreference("name").setEnabled(
					!(findPreference("name").isEnabled()));
		} 	
		return super.onPreferenceTreeClick(preferenceScreen, preference);
	}


	@Override
	public boolean onPreferenceChange(Preference preference, Object newValue) {
		preference.setSummary(newValue.toString());
		return true;
	}


}
