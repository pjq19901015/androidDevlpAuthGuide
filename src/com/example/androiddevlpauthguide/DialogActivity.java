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
	private String[] privences = new String[]{"�Ϻ���", "������","���","����"};
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
		/*new AlertDialog.Builder(this).setTitle("�б�Ի���")
			.setItems(privences, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					textview.setText(privences[which]);
					
				}
			}).show();*/
		/*new AlertDialog.Builder(this).setTitle("��ѡ�б��")
			.setSingleChoiceItems(privences, 0, new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					index = which;
					
				}
			})
			.setPositiveButton("ȷ��", new OnClickListener() {
				
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
					progressDialog.setTitle("ˮƽ������");
					progressDialog.setMessage("�����У����Ժ�");
					progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);   
					progressDialog.setButton("��ͣ", new OnClickListener(){

						@Override
						public void onClick(DialogInterface dialog, int which) {
							progress = progressDialog.getProgress();  
							progressDialog.dismiss();
							handler.removeMessages(1);
						}
					
					});
					progressDialog.setButton2("ȡ��", new OnClickListener(){  
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
			.setTitle("��¼��")
			.setView(LayoutInflater.from(this).inflate(R.layout.login, null))
			.setPositiveButton("��¼", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			})
			.setNegativeButton("ȡ��", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) { 
				}
			}).show();*/
		mainView = LayoutInflater.from(this).inflate(R.layout.activity_dialog, null);
	}
	
	public void create(){
		AlertDialog alertDialog = new AlertDialog.Builder(this)
			.setTitle("��ѡ�б��")
			.setMultiChoiceItems(privences, null, new OnMultiChoiceClickListener() { 
				@Override
				public void onClick(DialogInterface dialog, int which,
						boolean isChecked) { 
				} 
			})
			.setPositiveButton("ȷ��", new OnClickListener() {
				
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
				.setTitle("������!")
				.setMessage("�Ի�������")
				.setPositiveButton("ȷ��", null)
				.setNegativeButton("ȡ��", new OnClickListener() {
					
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
			.setTitle("������!")
			.setMessage("�Ի�������")
			.setPositiveButton("ȷ��", new OnClickListener() {
				
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
			.setNegativeButton("ȡ��", new OnClickListener() {
				
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
						Html.fromHtml("������<img src=''/>��á�",new ImageGetter() {
							
							@Override
							public Drawable getDrawable(String source) {
								Drawable drawable = getResources().getDrawable(R.drawable.face);
								drawable.setBounds(0,0,32,32);
								return drawable;
							}
						}, null))
				.setPositiveButton(
							Html.fromHtml("<img src=''/>ȷ����",new ImageGetter() {
							
							@Override
							public Drawable getDrawable(String source) {
								Drawable drawable = getResources().getDrawable(R.drawable.ok);
								drawable.setBounds(0,0,32,32);
								return drawable;
							}
						}, null),null )
				.setNegativeButton(
							Html.fromHtml("<img src=''/>ȡ��",new ImageGetter() {
							
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
			.setTitle("�ײ��Ի���")
			.setPositiveButton("ȷ��", null)
			.create();
		Window window1 = dialog1.getWindow();
		window1.setGravity(Gravity.BOTTOM);
		dialog1.show();
			break;
		case R.id.stop_dialog_button_three:
			AlertDialog dialog2 = new AlertDialog.Builder(this)
			.setTitle("������λ����ʾ�Ի���")
			.setPositiveButton("ȷ��", null)
			.create();
		Window window2 = dialog2.getWindow();
		window2.setGravity(Gravity.TOP);
		WindowManager.LayoutParams layoutParams = window2.getAttributes();
		layoutParams.alpha = 0.5f;
		window2.setAttributes(layoutParams);
		dialog2.show();
		AlertDialog dialog3 = new AlertDialog.Builder(this)
		.setTitle("������λ����ʾ�Ի���")
		.setPositiveButton("ȷ��", null)
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
			.setTitle("�Ƿ�ɾ���ļ�")
			.setPositiveButton("ȷ��", new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					new AlertDialog.Builder(DialogActivity.this)
						.setMessage("���Ѿ�ѡ��ɾ���ļ���").show();
				}
			}).setNegativeButton("ȡ��",new OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					Toast.makeText(DialogActivity.this, "���Ѿ�ȡ��ɾ���ļ�", 1).show(); 
				}
			}).show();
			break;
		case 2:
			new AlertDialog.Builder(this)
				.setTitle("ѡ��ʡ��")
				.setItems(privences, null)
				.show();
			break;
		case 3:
			new AlertDialog.Builder(this)
				.setTitle("ѡ��ʡ��")
				.setSingleChoiceItems(privences, 2, null)
				.setPositiveButton("ȷ��", null)
				.setNegativeButton("ȡ��",null)
				.show();
			break;
		case 4:
			new AlertDialog.Builder(this)
				.setTitle("ѡ��ʡ��")
				.setIcon(R.drawable.image)
				.setMultiChoiceItems(privences, 
									 new boolean[]{false,true,false,true},
									 null)
				.setPositiveButton("ȷ��", null)
				.setNegativeButton("ȡ��",null)
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
