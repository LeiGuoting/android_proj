package com.fbc.util;

import com.fbc.BuildMod;

/**
 * Class for sending log output.
 * 
 * @author lei.guoting
 */
public class Log {

	public static void i(String tag, String msg) {  
	    android.util.Log.i(tag, msg);  
	} 
	
	public static void e(String tag, String msg) {  
	    android.util.Log.e(tag, msg);  
	}  
	
	public static void d(String tag, String msg) {  
	    if (BuildMod.DEBUG) {
	    	android.util.Log.d(tag, msg);  
	    }
	}
	
	public static void v(String tag, String msg) {  
	    android.util.Log.v(tag, msg);  
	}  
	
	public static void w(String tag, String msg) {  
	    android.util.Log.w(tag, msg);  
	}  
}
