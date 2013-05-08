package com.example.androiddevlpauthguide;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebviewActivity extends Activity {
	private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webview);
		webview = (WebView) this.findViewById(R.id.webview);
		webview.getSettings().setJavaScriptEnabled(true);
		webview.setWebChromeClient(new WebChromeClient());
		
		String html = readhtml("canvasRect.html");
		webview.loadDataWithBaseURL(null, html, "text/html", "UTF-8", null);
		
	}
	
	private String readhtml(String filename) {
		StringBuilder html = new StringBuilder();  
		try {
			InputStream input = getResources().getAssets().open(filename);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(input,"UTF-8"));
			String s;
			while((s = buffer.readLine()) != null){
				html.append(s + "\n"); 
			}  
			buffer.close();    
			input.close();
		} catch (IOException e) { 
			e.printStackTrace();  
		}
		return html.toString();     
	}   
	
}
