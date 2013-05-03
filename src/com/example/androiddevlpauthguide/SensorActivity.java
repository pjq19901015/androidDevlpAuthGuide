package com.example.androiddevlpauthguide;

import java.util.List;

import android.app.Activity;  
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

public class SensorActivity extends Activity implements SensorEventListener{
	private SensorManager sensorManager;
	private TextView textviewSensorlist;
	private TextView textviewAccelerometer;
	private TextView textviewLight;
	private TextView textviewOrientation;
	private TextView textviewMagentic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sensor);
		textviewSensorlist = (TextView) this.findViewById(R.id.sensor_textview_one);
		textviewAccelerometer = (TextView) this.findViewById(R.id.sensor_textview_two);
		textviewLight = (TextView) this.findViewById(R.id.sensor_textview_three);
		textviewOrientation = (TextView) this.findViewById(R.id.sensor_textview_four);
		textviewMagentic = (TextView) this.findViewById(R.id.sensor_textview_five);
		
		sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
		List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
		for(Sensor sensor: sensorList){
			textviewSensorlist.append(sensor.getName() + "\n");
		}
		
		sensorManager.registerListener(this, 
									   sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
									   SensorManager.SENSOR_DELAY_FASTEST);
		sensorManager.registerListener(this, 
				   sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT),
				   SensorManager.SENSOR_DELAY_FASTEST);
		sensorManager.registerListener(this, 
				   sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
				   SensorManager.SENSOR_DELAY_FASTEST);
		sensorManager.registerListener(this, 
				   sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD),
				   SensorManager.SENSOR_DELAY_FASTEST);
	}
	@Override
	public void onSensorChanged(SensorEvent event) {
		
		switch(event.sensor.getType()){
		case Sensor.TYPE_ACCELEROMETER:
			textviewAccelerometer.setText("加速器\n" +
										  "X: " + event.values[0] + "\n" +
										  "Y: " + event.values[1] + "\n" + 
										  "Z: " + event.values[2] + "\n");
			break;
		case Sensor.TYPE_LIGHT:
			textviewLight.setText("亮度\n" + event.values[0]);
			break;
		case Sensor.TYPE_MAGNETIC_FIELD:
			textviewMagentic.setText("磁场\n" +
								     "X: " + event.values[0] + "\n" +
								     "Y: " + event.values[1] + "\n" + 
								     "Z: " + event.values[2] + "\n");
			break;
		case Sensor.TYPE_ORIENTATION:
			textviewOrientation.setText("方向\n" +
								     "X: " + event.values[0] + "\n" +
								     "Y: " + event.values[1] + "\n" + 
								     "Z: " + event.values[2] + "\n");
			break;
		}
		
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		
		
	}
}
