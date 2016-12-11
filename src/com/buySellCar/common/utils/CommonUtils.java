package com.buySellCar.common.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommonUtils {
	
	public static String companyName="Aswak Almjd";
	private static String propertiesFileName ="app.properties"  ;
	private static String SERVER_ABSOLUTE_PATH="http://localhost:8080"; //local
//	private static String SERVER_ABSOLUTE_PATH="http://www.aswakelmjd.com";
	public static String forgetPasswordLink=SERVER_ABSOLUTE_PATH+"/usermanagment/forgetPassword.jsp?tc=";
	public static String UPLOAD_FOLDER="/home/smart/tmp/";
	public static final int chatMsgLoadLimit=5;
	public static final int ADMIN_GROUP = 2;
	public static final long CUSTOMER_GROUP = 1;
	
	
	public static String getProperty(String propertyName) throws IOException {
		
		Properties propertiesFile = new Properties();
		InputStream in=null;
		String propertyVal=null;
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		in = classLoader.getResourceAsStream(propertiesFileName);
		
		try {
			propertiesFile.load(in);
			propertyVal = propertiesFile.getProperty(propertyName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}finally{
			in.close();
		}
		
		
		
		return propertyVal;
		
		
	}

}
