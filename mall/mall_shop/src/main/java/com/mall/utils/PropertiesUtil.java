package com.mall.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	/**
	 * 
	 * @Title: getParameter 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param key
	 * @param @param propertyFileName
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getParameter(String key, String propertyFileName) {
		Properties pro = new Properties();
		InputStream in = PropertiesUtil.class.getClassLoader().getResourceAsStream("properties/" + propertyFileName + ".properties");
		String parameter = "";
		try {
			pro.load(in);
			parameter = pro.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parameter;
	}
}
