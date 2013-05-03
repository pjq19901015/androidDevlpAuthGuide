package com.example.androiddevlpauthguide;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

import com.example.androiddevlpauthguide.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MobileIpActivity extends Activity {
	private TextView textview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.get_wifi_to_mobile_ip);
		textview = (TextView) this.findViewById(R.id.get_wifi_to_mobile_ip_textview);
	}
	
	public void click(View view){
		try {
			Enumeration<NetworkInterface> networkInterfaces = 
								NetworkInterface.getNetworkInterfaces();
			while(networkInterfaces.hasMoreElements()){
				NetworkInterface ni = networkInterfaces.nextElement();
				Enumeration<InetAddress> ia =  ni.getInetAddresses();
				while(ia.hasMoreElements()){
					textview.append(ia.nextElement().getHostAddress() + "\n\n");
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
