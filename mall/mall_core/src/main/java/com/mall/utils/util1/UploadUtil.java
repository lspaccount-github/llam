package com.mall.utils.util1;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.servlet.ServletException;

public class UploadUtil
{
	
	public static void copyFile(InputStream is, OutputStream os) throws ServletException, IOException
	{
		byte[] bytes = new byte[1024];
		for (;;)
		{
			int count = is.read(bytes, 0, bytes.length);
			if (count == -1)
				break;
			os.write(bytes, 0, count);
		}
	}
	
	public static String getUploadURL(String key)
	{
		Properties pro = new Properties();
		try
		{
			pro.load(UploadUtil.class.getResourceAsStream("/chat-api.properties"));
			return pro.getProperty(key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return "";
		}
	}
	
	public static void deleteFileOrFolder(String path)
	{
 		File file = new File(path);
		if (file.isFile() || file.isDirectory())
		{
			file.delete();  
		}
	}
}
