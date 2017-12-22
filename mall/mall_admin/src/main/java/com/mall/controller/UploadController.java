package com.mall.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.sun.jersey.api.client.WebResource;

/**
 * 上传图片
 * 品牌图片
 * 商品图片
 * Fck图片
 * @author lx
 *
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

	//上传图片   商品  品牌  input type file  name pic
	@RequestMapping(value = "/uploadPic")
	public void uploadPic(@RequestParam MultipartFile pic, HttpServletRequest request, HttpServletResponse response){
		
		System.out.println(pic.getOriginalFilename());
		//apache 扩展名
		String ext = FilenameUtils.getExtension(pic.getOriginalFilename());
		
		//53a73....  会不会重复 有可能
		//图片名称的生成策略    yyyy-MM-dd HH:mm:ssSSS   + 随机三位  10以内
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		String name = df.format(new Date());
		// 随机三位
		Random r = new Random();
		for (int i = 0; i < 3; i++) {
			name += r.nextInt(10);
		}
		//图片名称
		
		//使用Jersey框架
		//Client client = new Client();
		com.sun.jersey.api.client.Client client = new com.sun.jersey.api.client.Client();
		
		String path = "upload/" + name + "." + ext;
		String url =  "http://localhost:8082/img-web/" + path;
		//String url=PropertiesUtil.getParameter("IMG_WEB","parameter");
		//发送图片
		WebResource resource = client.resource(url);
		//发送  网线发送  二进制   流  字符串
		try {
			resource.put(String.class, pic.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回路径
		Map<String,String> map = new HashMap<String, String>();
		map.put("url", url);
		map.put("path", path);
		String json = JSON.toJSONString(map);
		
		//url  显示
		//path  保存
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
