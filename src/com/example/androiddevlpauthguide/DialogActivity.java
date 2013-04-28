package com.example.androiddevlpauthguide;

import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Html.ImageGetter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class DialogActivity extends Activity {
	private String[] privences = new String[]{"上海市", "北京市","香港","澳门"};
	private TextView textview;
	private int index;
	private ListView listView;
	private Handler handler;
	private int progress= 0;
	private Button button;
	private View mainView;
	private AlertDialog dialog2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stop_dialog);
		//textview = (TextView) this.findViewById(R.id.activity_main_textview);
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
		//create();
		/*button = (Button) this.findViewById(R.id.main_button_addmenu);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					final ProgressDialog progressDialog = new ProgressDialog(DialogActivity.this);
					progressDialog.setIcon(R.drawable.wait);
					progressDialog.setTitle("水平进度条");
					progressDialog.setMessage("加载中，请稍后：");
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);   
					progressDialog.setButton("暂停", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							progress = progressDialog.getProgress();  
							progressDialog.dismiss();
							handler.removeMessages(1);
						}
					
					});
					progressDialog.setButton2("取消", new OnClickListener(){  
						@Override
						public void onClick(DialogInterface dialog, int which) {
							progressDialog.dismiss(); 
						}
					
					});
					handler = new Handler(){
						@Override
						public void handleMessage(Message msg) {
							super.handleMessage(msg);
							if(progressDialog.getProgress() == 100){
								progressDialog.dismiss();
								progress = 0;
							}else{
								progressDialog.incrementProgressBy(5);
								handler.sendEmptyMessageDelayed(1, 50 + new Random().nextInt(500));
							}
						}
					}; 
					progressDialog.show();
					progressDialog.setProgress(progress);
					handler.sendEmptyMessage(1);
				}
		}); */
			
		/*new AlertDialog.Builder(this)
			.setIcon(R.drawable.login)
			.setTitle("登录框")
			.setView(LayoutInflater.from(this).inflate(R.layout.login, null))
			.setPositiveButton("登录", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.setNegativeButton("取消", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) { 
				}
			}).show();*/
		mainView = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null);
	}
	
	public void create(){
		AlertDialog alertDialog = new AlertDialog.Builder(this)
			.setTitle("多选列表框")
			.setMultiChoiceItems(privences, null, new OnMultiChoiceClickListener() { 
				@Override
				public void onClick(DialogInterface dialog, int which,
						boolean isChecked) { 
				} 
			})
			.setPositiveButton("确定", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					StringBuilder str = new StringBuilder();
					for(int i = 0; i < listView.getCount(); i++){
						if(listView.getCheckedItemPositions().get(i)){
							str.append(i + " " + listView.getAdapter().getItem(i));
						}
					}
					textview.setText(str.toString());  
				}
			}).create();
		listView = alertDialog.getListView();
		alertDialog.show();
	}
	
	/*public void click(View view){
		int id = view.getId();
		switch(id){
		case R.id.activity_dialog_one:
			showDialog(1);
			break;
		case R.id.activity_dialog_two:
			showDialog(2);
			break;
		case R.id.activity_dialog_three:
			showDialog(3);
			break;
		case R.id.activity_dialog_four:
			showDialog(4);
			break;
		case R.id.activity_dialog_five:
			break;
		}
	}*/
	/*public void click(View view){
		int id = view.getId();
		switch(id){
		case R.id.stop_dialog_button_one:
			AlertDialog dialog = new AlertDialog.Builder(this)
				.setIcon(R.drawable.icon)
				.setTitle("我来了!")
				.setMessage("对话框内容")
				.setPositiveButton("确定", null)
				.setNegativeButton("取消", new OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss(); 
					}
				})
				.create();
			try {
				Field field = dialog.getClass().getDeclaredField("mAlert");
				field.setAccessible(true);
				Object obj = field.get(dialog);
				field = obj.getClass().getDeclaredField("mHandler");
				field.setAccessible(true);
				field.set(obj, new ButtonHandler(dialog));
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dialog.show();
			break;
		case R.id.stop_dialog_button_two:
			 dialog2 = new AlertDialog.Builder(this)
			.setIcon(R.drawable.icon)
			.setTitle("我来了!")
			.setMessage("对话框内容")
			.setPositiveButton("确定", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which){
					try {
						Field field = dialog2.getClass().getSuperclass()
											.getDeclaredField("mShowing");
						field.setAccessible(true);
						field.set(dialog2, true);
					} catch (SecurityException e) { 
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			})
			.setNegativeButton("取消", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which){
					try {
						Field field = dialog2.getClass().getSuperclass()
											.getDeclaredField("mShowing");
						field.setAccessible(true);
						field.set(dialog2, false);
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).create();
			 dialog2.show();
			break;
		}
	}*/
	public void click(View view){
		int id = view.getId();
		switch(id){
		case R.id.stop_dialog_button_one:
			AlertDialog dialog = new AlertDialog.Builder(this)
				.setMessage(
						Html.fromHtml("哈哈，<img src=''/>你好。",new ImageGetter() {
							
							@Override
							public Drawable getDrawable(String source) {
								Drawable drawable = getResources().getDrawable(R.drawable.face);
								drawable.setBounds(0,0,32,32);
								return drawable;
							}
						}, null))
				.setPositiveButton(
							Html.fromHtml("<img src=''/>确定。",new ImageGetter() {
							
							@Override
							public Drawable getDrawable(String source) {
								Drawable drawable = getResources().getDrawable(R.drawable.ok);
								drawable.setBounds(0,0,32,32);
								return drawable;
							}
						}, null),null )
				.setNegativeButton(
							Html.fromHtml("<img src=''/>取消",new ImageGetter() {
							
							@Override
							public Drawable getDrawable(String source) {
								Drawable drawable = getResources().getDrawable(R.drawable.cancel);
								drawable.setBounds(0,0,32,32);
								return drawable;
							}
						}, null), null)
				
				
				.create();
			Window window = dialog.getWindow();
			window.setGravity(Gravity.TOP);
			dialog.show();
			break;
		case R.id.stop_dialog_button_two:
			AlertDialog dialog1 = new AlertDialog.Builder(this)
			.setTitle("底部对话框")
			.setPositiveButton("确定", null)
			.create();
		Window window1 = dialog1.getWindow();
		window1.setGravity(Gravity.BOTTOM);
		dialog1.show();
			break;
		case R.id.stop_dialog_button_three:
			AlertDialog dialog2 = new AlertDialog.Builder(this)
			.setTitle("在任意位置显示对话框")
			.setPositiveButton("确定", null)
			.create();
		Window window2 = dialog2.getWindow();
		window2.setGravity(Gravity.TOP);
		WindowManager.LayoutParams layoutParams = window2.getAttributes();
		layoutParams.alpha = 0.5f;
		window2.setAttributes(layoutParams);
		dialog2.show();
		AlertDialog dialog3 = new AlertDialog.Builder(this)
		.setTitle("在任意位置显示对话框")
		.setPositiveButton("确定", null)
		.create();
		Window window3 = dialog3.getWindow();
		window3.setGravity(Gravity.TOP);
		WindowManager.LayoutParams layoutParams2 = window3.getAttributes();
		layoutParams.alpha = 1.0f;
		window3.setAttributes(layoutParams2);
		dialog3.show();
			break;
		}
	}
	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id){
		case 1:
			new AlertDialog.Builder(this)
			.setIcon(R.drawable.question)
			.setTitle("是否删除文件")
			.setPositiveButton("确定", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					new AlertDialog.Builder(DialogActivity.this)
						.setMessage("您已经选择删除文件了").show();
				}
			}).setNegativeButton("取消",new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(DialogActivity.this, "您已经取消删除文件", 1).show(); 
				}
			}).show();
			break;
		case 2:
			new AlertDialog.Builder(this)
				.setTitle("选择省份")
				.setItems(privences, null)
				.show();
			break;
		case 3:
			new AlertDialog.Builder(this)
				.setTitle("选择省份")
				.setSingleChoiceItems(privences, 2, null)
				.setPositiveButton("确定", null)
				.setNegativeButton("取消",null)
				.show();
			break;
		case 4:
			new AlertDialog.Builder(this)
				.setTitle("选择省份")
				.setIcon(R.drawable.image)
				.setMultiChoiceItems(privences, 
									 new boolean[]{false,true,false,true},
									 null)
				.setPositiveButton("确定", null)
				.setNegativeButton("取消",null)
				.show();
			break;
		case 5:
			break;
		
		}
		return super.onCreateDialog(id);
	}
	
	class ButtonHandler extends Handler
	{
		private WeakReference<DialogInterface> mDialog;

		public ButtonHandler(DialogInterface dialog)
		{
			mDialog = new WeakReference<DialogInterface>(dialog);
		}  
		@Override
		public void handleMessage(Message msg)
		{
			switch (msg.what)
			{ 
				case DialogInterface.BUTTON_POSITIVE:
				case DialogInterface.BUTTON_NEGATIVE:
				case DialogInterface.BUTTON_NEUTRAL:
					((DialogInterface.OnClickListener) msg.obj).onClick(
							mDialog.get(), msg.what);
					break;
			}
		}
	}
}
