package com.fbc.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import com.fbc.BuildMod;
import com.fbc.exception.SysException;

/**
 * The class for getting configure's data
 * 
 * @author lei.guoting
 */
public class PropertiesUtil {
      private static final String TAG = "PropertiesUtil";
      private static final String DEBUG_PROP_FILE_PATH = "/assets/debug/properties/";
      private static final String RELEASE_PROP_FILE_PATH = "/assets/release/properties/";
      
      public static final String P_APP_API_CFG = "app_api_cfg.properties";
      public static final String P_APP_BASE_CFG = "app_base_cfg.properties";
      
      private static Properties appApiCfg;
      private static Properties appBaseCfg;  
      
      /**
       * e.g.
       * PropertiesUtil.getValue(PropertiesUtil.P_APP_BASE_CFG, "basic_domain","defaultValue")
       * 
       * @param assManager
       * @param pKey
       * @param key
       * @param defaultValue
       * @return String
       * @throws SysException
       */
      public static String getValue(String pKey,String key,String defaultValue){
	       return getProperties(pKey).getProperty(key,defaultValue);
      }
      
      /**
       * @param assManager
       * @param pKey
       * @param key
       * @return Integer
       */
      public static int getIntValue(String pKey,String key){
	       return Integer.parseInt(getProperties(pKey).getProperty(key).replaceAll("[^0-9.]", ""));
      }
      
      /**
       * e.g.
       * PropertiesUtil.getValue(PropertiesUtil.P_APP_BASE_CFG, "basic_domain")
       * 
       * @param assManager
       * @param pKey
       * @param key
       * @return String
       * @throws SysException
       */
      public static String getValue(String pKey,String key){
	       return getProperties(pKey).getProperty(key);
      }
      
      /**
       * getting Properties object
       * 
       * @param pKey
       * @return Properties 
       */
      public static Properties getProperties(String pKey){
	       if(P_APP_API_CFG.equals(pKey)){
	            return getAppApiObj();
	       }
	       else if(P_APP_BASE_CFG.equals(pKey)){
	            return getAppBaseCfgObj();
	       }
	       
	       return getAppBaseCfgObj();
      }
      
      private static Properties getAppApiObj(){
	       if (null == appApiCfg) {
	           InputStream inStream = null;
	           if(BuildMod.DEBUG){
	        	   inStream = new BufferedInputStream(PropertiesUtil.class.getResourceAsStream(DEBUG_PROP_FILE_PATH + P_APP_API_CFG));
			   }else{
				   inStream = new BufferedInputStream(PropertiesUtil.class.getResourceAsStream(RELEASE_PROP_FILE_PATH + P_APP_API_CFG));
			   }
           
	           appApiCfg = new Properties();
	           try {
	        	   appApiCfg.load(inStream);
	           } catch (IOException e) {
	        	   appApiCfg = null;
	       	        throw new SysException(e);
	           } finally{
	       	        try{
	       	        	inStream.close();
	       	        }catch(IOException e){
	       	            /*do nothing*/
	       	            Log.d(TAG,P_APP_API_CFG+" file close failed !");
	       	        }
	           }
	       }
	       
	       return appApiCfg;
      }
      
      private static Properties getAppBaseCfgObj(){
	       if(null == appBaseCfg){
	           InputStream inStream = null;
	           if(BuildMod.DEBUG){
				    inStream = new BufferedInputStream(PropertiesUtil.class.getResourceAsStream(DEBUG_PROP_FILE_PATH + P_APP_BASE_CFG));
			   }else{
			   	    inStream = new BufferedInputStream(PropertiesUtil.class.getResourceAsStream(RELEASE_PROP_FILE_PATH + P_APP_BASE_CFG));
			   }
	           
	           appBaseCfg = new Properties();
	           try {
		            appBaseCfg.load(inStream);
	           } catch (IOException e) {
		            appBaseCfg = null;
		            throw new SysException(e);
	           } finally{
		            try{
		            	inStream.close();
		            }catch(IOException e){
		                /*do nothing*/
		                Log.d(TAG,P_APP_BASE_CFG+" file close failed !");
		            }
	           }
	       }   
	       
	       return appBaseCfg;
      }
}
