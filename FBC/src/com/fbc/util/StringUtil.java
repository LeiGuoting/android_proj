package com.fbc.util;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * String tools
 * 
 * @author lei.guoting
 */
public class StringUtil {
	private static final String TAG = "StringUtil";

	/**
	 * to sort token's String
	 * 
	 * @param src
	 * @param token
	 * @return String
	 */
	public static String sortTheToken(String src, String token) {
		// split
		StringTokenizer sTokenizer = new StringTokenizer(src, token);
		String[] tokens = new String[sTokenizer.countTokens()];
		for (int i = 0; i < tokens.length && sTokenizer.hasMoreTokens(); i++) {
			tokens[i] = sTokenizer.nextToken();
		}

		// sort â€”â? ASC
		Arrays.sort(tokens);
		StringBuffer sBuffer = new StringBuffer();

		// join
		for (String str : tokens) {
			sBuffer.append(str);
			sBuffer.append(token);
		}
		String rest = sBuffer.substring(0, sBuffer.length() - 1);
		Log.d(TAG, "rest:" + rest);
		return rest;
	}

	/**
	 * to get relative path
	 * 
	 * @param url
	 * @return relative path
	 */
	public static String getRelativePath(String url) {
		String tStr = url.substring(url.indexOf("//") + 2);
		return tStr.substring(tStr.indexOf("/"));
	}

	/**
	 * @param src
	 * @return boolean it's to return true when the string is null or ""
	 */
	public static boolean isNull(String src) {
		if (null == src || "".equals(src)) {
			return true;
		} else {
			return false;
		}
	}
}
