package com.example.androiddevlpauthguide.service;

import com.example.thread.LiveWallpaperPainting; 
import android.service.wallpaper.WallpaperService;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class LiveWallpaperService extends WallpaperService {

	@Override
	public Engine onCreateEngine() {  
		
		return new WallpaperEngine();
	}
	
	private class WallpaperEngine extends Engine{   
		private LiveWallpaperPainting painting; 
		public WallpaperEngine() {  
			SurfaceHolder holder = getSurfaceHolder(); 
			painting = new LiveWallpaperPainting(holder,getApplicationContext());
		}   
		
		@Override
		public void onCreate(SurfaceHolder surfaceHolder) {
			super.onCreate(surfaceHolder);
			setTouchEventsEnabled(true);
		}
		@Override 
		public void onSurfaceCreated(SurfaceHolder holder) {
			super.onSurfaceCreated(holder); 
			painting.start();
		}
		
		@Override
		public void onTouchEvent(MotionEvent event) {
			super.onTouchEvent(event);
			painting.doOntouchEvent(event);
		}
	}

}
