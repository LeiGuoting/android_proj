package com.fbc.activity;

import java.io.File;

import com.fbc.util.Log;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.webkit.CacheManager;

/**
 * FBC project parent class    <br/>
 * all of Activity in the project must extend AbstractActivity
 * 
 * @author lei.guoting
 * 
 */
public abstract class AbstractActivity extends Activity {
	protected final String TAG = this.getClass().getName();

	// application name
	protected static final String APP_NAME = "BabyPic";
	// 当前Activity
	protected Activity activity;
	
	public Handler mHandler = null;

	/**
	 * 构�?函数
	 */
	public AbstractActivity() {
		super();

		// 初始�?
		init();
	}

	protected void init() {
		activity = this;

		// 全局异常�?��
		//Thread.setDefaultUncaughtExceptionHandler(new GlobalHandler());
	}

	/**
	 * 
	 * @param context
	 */
	public static void clearAppCache(Context context) {
		try {
		    File file = CacheManager.getCacheFileBaseDir();
		    if(null != file && file.exists() && file.isDirectory()){
		        for (File item : file.listFiles()) {
		    	   item.delete();
		        }
		        file.delete();
		    }
		} catch (Exception e) {
		    //do nothing
		    Log.i("", "Clear app all  cache.");
		}
	}

	/**
	 * Get custom application.
	 * @return
	 */
	public MyApplication getMyApplication() {
	    return (MyApplication) this.getApplication();
	}
	
	/**
	 * Get notice information .
	 * Load or reload notice web page.
	 */
	public  void getNoticeInfo(){}
}
