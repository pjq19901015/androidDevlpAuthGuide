package com.example.androiddevlpauthguide;

import java.util.Collections;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.domian.EventData;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class TemplateActivity extends Activity {
	private TextView textView;
	private Handler handler = new Handler(){
		public void handleMessage(Message msg) {
			Bundle bundle = msg.getData();
			String str = bundle.getString("a");
			textView.setText(str);
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		textView = (TextView) this.findViewById(R.id.activity_main_textview);
		//textView.setText(userRestTemplate()); 	
		//userRestTemplate();
		getJsonData();
	}
	
	private void userRestTemplate(){
		new Thread(new Runnable() { 
			@Override
			public void run() {
				String url = "http://10.94.5.71:8080/server";
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
				String result = restTemplate.getForObject(url, String.class);
				Message message = new Message();
				Bundle bundle = new Bundle();
				bundle.putString("a", result);
				message.setData(bundle);
				handler.sendMessage(message);
			}
		}).start();
		
	}
	
	private void getJsonData(){
		new Thread(new Runnable(){
			public void run(){
				String url = "http://180.168.35.37:8080/exhibition/api/exhibitions/CCBN";
				
				HttpHeaders requestHeaders = new HttpHeaders();
				requestHeaders.setAccept(Collections.singletonList(
						new MediaType("application","json")));
				HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
				
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.getMessageConverters().add(new GsonHttpMessageConverter());
				
				ResponseEntity<EventData> responseEntity = restTemplate.exchange(
						url, HttpMethod.GET, requestEntity, EventData.class);
				EventData data = responseEntity.getBody();
			}
		}).start();
	}
}
