package com.fbc.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;
import android.app.Application;

/**
 * System Application
 * 
 * @author lei.guoting
 * 
 */
public class MyApplication extends Application {
	private final HashMap<String, Object> attributes = new HashMap<String, Object>();
	private final HashMap<String, String> cookies = new HashMap<String, String>();// save
																					// cookies

	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	public Object remAttribute(String name) {
		return attributes.remove(name);
	}

	public void clearAttributes() {
		attributes.clear();
	}

	public void saveCookie(String name, String value) {
		if (cookies.containsKey(name))
			return;
		cookies.put(name, value);
	}

	public String getCookie(String name) {
		if (!cookies.containsKey(name))
			return null;
		return cookies.get(name);
	}

	public List<String[]> getAllCookies() {
		Set<Entry<String, String>> result = cookies.entrySet();
		List<String[]> list = new ArrayList<String[]>();
		for (Entry<String, String> entry : result)
			list.add(new String[] { entry.getKey(), entry.getValue() });
		return list;
	}

	/**
	 * Contribute date.
	 * 
	 * @author Hao Cheng
	 */
	public String contributeDate = null;
	
	public String takePictureUri = null;
	
	public String bitmapFromCrop = null;
	
	public static final String  CUSTOM_APP_PROTOCOL = "babypic-app";
}
