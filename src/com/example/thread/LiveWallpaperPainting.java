package com.example.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.androiddevlpauthguide.R;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint; 
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.WindowManager;  

public class LiveWallpaperPainting extends Thread {
	
	private SurfaceHolder holder;
	private Context context;
	private Paint paint;
	private static  int SCREENWIDTH;
	private static  int SCREENHEIGHT;
	private List<Point> points = new ArrayList<Point>();
	public LiveWallpaperPainting(SurfaceHolder holder,Context context) {
		this.holder = holder;
		this.context = context;   
		paint = new Paint();  
		WindowManager winManager =  
				(WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		SCREENWIDTH = winManager.getDefaultDisplay().getWidth(); 
		SCREENHEIGHT = winManager.getDefaultDisplay().getHeight();
	}     
	@Override
	public void run() {    
		Canvas canvas;    
		while(true){
			canvas = holder.lockCanvas(null); 
				draw(canvas);    
			if(canvas != null){  
				holder.unlockCanvasAndPost(canvas);
			} 
		}  
		   
	}    
	 
	public void draw(Canvas canvas){  
		Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), 
											 		 R.drawable.background); 
		Matrix matrix = new Matrix();    
		float scaleWidth = (float)SCREENWIDTH/(float)bitmap.getWidth();
		float scaleHeight = (float)SCREENHEIGHT/(float)bitmap.getHeight();
		matrix.postScale(scaleWidth, scaleHeight);
		bitmap = bitmap.createBitmap(   
				bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),matrix,true);             
		canvas.drawBitmap(bitmap,0,0,paint);
		for(Point point : points){
			paint.setColor(point.color);
			canvas.drawCircle(point.xPonit, point.yPoint, point.radius, paint);
		}   
	}
	
	public void doOntouchEvent(MotionEvent event) {
		int color = new Random().nextInt(Integer.MAX_VALUE);
		Point point = new Point(event.getX(),event.getY(),5,color);
		points.add(point); 		
	}    
	 
	private class Point{
		float xPonit;     
		float yPoint;
		int radius;
		int color;
		public Point(float xPonit, float yPoint, int radius, int color) { 
			this.xPonit = xPonit;
			this.yPoint = yPoint;  
			this.radius = radius;
			this.color = color;
		} 
	}
}
