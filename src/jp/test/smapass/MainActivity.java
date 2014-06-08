package jp.test.smapass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
    private static final String TAG = MainActivity.class.getSimpleName();


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			//2way Sync 機能呼び出し
			Button button1 = (Button)rootView.findViewById(R.id.button1);
			button1.setOnClickListener(new OnClickListener() {
				@Override
	            public void onClick(View v) {
					Intent i = new Intent();
//					i.setClassName("jibe.android.activity", "jibe.android.activity.LoginActivity");
					i.setClassName("jp.test.fndummy", "jp.test.fndummy.LoginActivity");
					i.putExtra("sync_mode", "2WaySync");
					i.putExtra("auto_signup_mode", "1");
					try {
						startActivityForResult(i, 0);
					} catch (Exception e) {
						Toast.makeText(getActivity().getApplicationContext(), "対象のアプリがありません", Toast.LENGTH_SHORT).show();
					}
	            }
	        });

			Button button2 = (Button)rootView.findViewById(R.id.button2);
			button2.setOnClickListener(new OnClickListener() {
				@Override
	            public void onClick(View v) {
					Intent i = new Intent();
					i.setClassName("jibe.android.activity",
					 "jibe.android.activity.setAutoSyncActivity");
					i.putExtra("sync_mode", "2WaySync");
					i.putExtra("auto_signup_mode", "1");
					try {
						startActivityForResult(i, 0);
					} catch (Exception e) {
						Toast.makeText(getActivity().getApplicationContext(), "対象のアプリがありません", Toast.LENGTH_SHORT).show();
					}
				}
	        });
			
						
			Button button3 = (Button)rootView.findViewById(R.id.button3);
			button3.setOnClickListener(new OnClickListener() {
				@Override
	            public void onClick(View v) {
					Intent i = new Intent();
//					i.setClassName("jibe.android.activity",
//					 "jibe.android.activity.LoginActivity");
					i.setClassName("jp.test.fndummy", "jp.test.fndummy.LoginActivity");
					i.putExtra("sync_mode", "fetchNumber");
					i.putExtra("auto_signup_mode", "1");
					try {
						startActivityForResult(i, 0);
					} catch (Exception e) {
						Toast.makeText(getActivity().getApplicationContext(), "対象のアプリがありません", Toast.LENGTH_SHORT).show();
					}
				}
	        });

			
			Button button4 = (Button)rootView.findViewById(R.id.button4);
			button4.setOnClickListener(new OnClickListener() {
				@Override
	            public void onClick(View v) {
					Intent i = new Intent();
//					i.setClassName("jibe.android.activity",
//					 "jibe.android.activity.LoginActivity");
					i.setClassName("jp.test.fndummy", "jp.test.fndummy.LoginActivity");
					i.putExtra("sync_mode", "statusCheck");
					i.putExtra("auto_signup_mode", "1");
					try {
						startActivityForResult(i, 0);
					} catch (Exception e) {
						Toast.makeText(getActivity().getApplicationContext(), "対象のアプリがありません", Toast.LENGTH_SHORT).show();
					}
				}
	        });

			return rootView;
		}
	}

	@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        android.util.Log.v(TAG,"onActivityResult resultCode = " + resultCode );
//      if (requestCode == 0) {
	      if (resultCode == RESULT_OK) { 
	      	// 処理成功時
	          if (data.getAction().equals("jibe.android.notification.2WAY_SYNC_RESULT")){
	          	// 処理成功時
	              Toast.makeText(this, 
	                  "処理受付完了" + data.getAction(), 
	                  Toast.LENGTH_LONG).show();
	          }else if (data.getAction().equals("jibe.android.notification.FETCH_NUMBER_RESULT")){
	              Toast.makeText(this, 
		               "処理受付完了" + data.getAction(), 
		               Toast.LENGTH_LONG).show();
	          }else if (data.getAction().equals("jibe.android.notification.BACKUP_STATUS_RESULT")){
	              Toast.makeText(this, 
		               "処理受付完了" + data.getAction(), 
		               Toast.LENGTH_LONG).show();
	          }
	          
	      }else {
	      	// 処理失敗時
	          Toast.makeText(this, "処理受付失敗", Toast.LENGTH_LONG).show();
	      }
//      }
          
        

        
	}

}