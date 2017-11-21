package com.mall.utils.util1;

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

	public static void main(String[] args) {
		System.out.println(getUUID());
		System.out.println(getUUID(15));
	}
}
