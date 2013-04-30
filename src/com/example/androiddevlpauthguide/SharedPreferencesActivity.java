package com.example.androiddevlpauthguide;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

import com.example.domian.Product;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SharedPreferencesActivity extends Activity {
	private Button buttonSaveImage; 
	private Button buttonReadImage; 
	private Button buttonSaveObject; 
	private Button buttonReadObject;
	private ImageView imageview;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.shareprefrences);
		buttonSaveImage = (Button) this.findViewById(R.id.shareprefrences_button_saveimage);
		imageview = (ImageView) this.findViewById(R.id.shareprefrences_imageview);
		buttonSaveImage.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View arg0) {
				SharedPreferences sharedPreferences = getSharedPreferences("base64",
																			Activity.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				ByteArrayOutputStream baos  = new ByteArrayOutputStream();
				BitmapFactory.decodeResource(getResources(), R.drawable.flower)
					.compress(CompressFormat.JPEG, 50, baos);
				String strImage = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
				editor.putString("image", strImage);
				editor.commit();
				try {
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		buttonReadImage = (Button) this.findViewById(R.id.shareprefrences_button_readimage);
		buttonReadImage.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sharedPreferences = 
							getSharedPreferences("base64", Activity.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				String strImage = sharedPreferences.getString("image", null);
				byte[] buffer = Base64.decode(strImage, Base64.DEFAULT);
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				imageview.setImageDrawable(Drawable.createFromStream(bais, ""));
				try {
					bais.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		buttonSaveObject = (Button) this.findViewById(R.id.shareprefrences_button_saveobject);
		buttonSaveObject.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Product product = new Product();
				product.name = "pjq";
				product.price = 1000000;
				SharedPreferences sharedPreferences = 
						getSharedPreferences("base65",Activity.MODE_PRIVATE);
				Editor editor = sharedPreferences.edit();
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				try {
					ObjectOutputStream oos = new ObjectOutputStream(baos);
					oos.writeObject(product);
					String strProduct = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
					editor.putString("object", strProduct);
					editor.commit();
					oos.close();
					baos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		buttonReadObject = (Button) this.findViewById(R.id.shareprefrences_button_readobject);
		buttonReadObject.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				SharedPreferences sharedPreferences = 
						getSharedPreferences("base65", Activity.MODE_PRIVATE);
				String strProduct = sharedPreferences.getString("object", "");
				byte[] buffer = Base64.decode(strProduct, Base64.DEFAULT);
				ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
				try {
					ObjectInputStream ois = new ObjectInputStream(bais);
					Product product = (Product) ois.readObject();
					Toast.makeText(SharedPreferencesActivity.this,
							   product.name + " " + product.price,
							   1).show();
				} catch (StreamCorruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
			}
		});
	}
}
