package com.mall.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {
	
	/** 
     * 判断传入的参数是否为数字
     */  
	public static boolean isNumeric(String str){ 
		   Pattern pattern = Pattern.compile("[0-9]*"); 
		   Matcher isNum = pattern.matcher(str);
		   if( !isNum.matches() ){
		       return false; 
		   } 
		   return true; 
		}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(System.nanoTime());
	}
}
