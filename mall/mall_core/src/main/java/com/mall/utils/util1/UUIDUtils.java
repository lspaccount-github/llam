package com.mall.utils.util1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class UUIDUtils {

	/**
	 * 获取UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("[a-z|-]", "");
	}

	/**
	 * 去掉字母和-
	 * 
	 * @param count
	 *            指定位数
	 */
	public static String getUUID(int count) {
		String s = UUID.randomUUID().toString();
		return s.replaceAll("[a-z|-]", "").substring(0, count);
	}

	public static String getID(){
		Date date = new Date();
        String date1 = new SimpleDateFormat("yyyyMMdd").format(date);  
        String seconds = new SimpleDateFormat("HHmmss").format(date);
        String sss = new SimpleDateFormat("SSS").format(date);
      return date1+seconds+sss+"1"+getTwo()+getTwo()+getUUID(6); 
	} 
	
	public static void main(String[] args) { 
		for (int i = 0; i <100; i++) {
			System.out.println(getID());
		}
		/*Map<String,String> map = new HashMap<String,String>();
		long i = 0;
		while(i<999999999){
			if(i%9999==0){
				System.out.println(i);
			}
			//String id = getUUID();
			String id =getID();
			String string = map.get(id);
			if(null!=string && !"".equals(string) && string.equals(id)){
				System.out.println("有重复"+id);
				return;
			}else{
				map.put(id,id);
			}
			i++;
		}*/
	}  
	/** 
     * 产生随机的2位数 
     * @return 
     */  
    public static String getTwo(){  
        Random rad=new Random();  
        String result  = rad.nextInt(100) +"";  
        if(result.length()==1){  
            result = "0" + result;  
        }  
        return result;  
    }  
}
