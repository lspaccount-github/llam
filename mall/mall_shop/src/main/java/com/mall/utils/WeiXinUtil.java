package com.mall.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.security.SecureRandom;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JavaIdentifierTransformer;

import org.apache.log4j.Logger;
import org.omg.CORBA.portable.OutputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mall.exception.BusinessException;
import com.mall.pojo.user.User;
import com.mall.pojo.weixin.UserInfo;


/**
 * 微信开发工具类
 * @ClassName: WeiXinUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author ShenWei 
 * @date 2017年12月2日 上午12:42:54
 *
 */
public class WeiXinUtil {
	
	private static Logger logger = Logger.getLogger(WeiXinUtil.class); 
	static ObjectMapper objectMapper=new ObjectMapper();
	/**
	 * @Title: httpRequest 
	 * @Description: java发送http请求
	 * @param @param requestUrl 请求路径
	 * @param @param requestMethod 请求方式
	 * @param @param outputStr
	 * @param @return    设定文件 
	 * @return JSONObject    返回类型 
	 * @throws
	 */
	public static JSONObject httpRequest(String requestUrl, String requestMethod, String outputStr)  
	  {  
	    JSONObject jsonObject = null;  
	    StringBuffer buffer = new StringBuffer();  
	    try  
	    {  
	      TrustManager[] tm = { new MyX509TrustManager() };  
	      SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
	      sslContext.init(null, tm, new SecureRandom());  
	  
	      SSLSocketFactory ssf = sslContext.getSocketFactory();  
	  
	      URL url = new URL(requestUrl);  
	      HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();  
	      httpUrlConn.setSSLSocketFactory(ssf);  
	  
	      httpUrlConn.setDoOutput(true);  
	      httpUrlConn.setDoInput(true);  
	      httpUrlConn.setUseCaches(false);  
	  
	      httpUrlConn.setRequestMethod(requestMethod);  
	  
	      if ("GET".equalsIgnoreCase(requestMethod)) {  
	        httpUrlConn.connect();  
	      }  
	  
	      if (outputStr != null) {  
	        OutputStream outputStream = (OutputStream) httpUrlConn.getOutputStream();  
	  
	        outputStream.write(outputStr.getBytes("UTF-8"));  
	        outputStream.close();  
	      }  
	  
	      InputStream inputStream = httpUrlConn.getInputStream();  
	      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
	      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
	  
	      String str = null;  
	      while ((str = bufferedReader.readLine()) != null) {  
	        buffer.append(str);  
	      }  
	      bufferedReader.close();  
	      inputStreamReader.close();  
	  
	      inputStream.close();  
	      inputStream = null;  
	      httpUrlConn.disconnect();  
	      jsonObject = JSONObject.fromObject(buffer.toString());  
	    } catch (ConnectException ce) {  
	      //logger.error("");  
	    	System.out.println("Weixin server connection timed out.");
	    } catch (Exception e) {  
	      System.err.println("https request error:"+ e);
	    }  
	    return jsonObject;  
	  } 
	
	/**
	 * 
	 * @Title: getAccessToken 
	 * @Description: 微信获取AccessToken
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String getAccessToken(){
		//获取access_token
		 String access_token ="";
		try {
   	        String CORPID = PropertiesUtil.getParameter("CORPID","parameter");
   	        String Secret=PropertiesUtil.getParameter("Secret","parameter");
   	        //需要获取access_token
   	        String url = PropertiesUtil.getParameter("CODE_TO_GETTOKEN","parameter");
   	        url = url.replace("CORPID", CORPID).replace("SECRET", Secret);
   	        
   	        JSONObject jsonobjectToken = WeiXinUtil.httpRequest(url, "GET", null);
   	        
   	        if(null!=jsonobjectToken){  
   	        	access_token = jsonobjectToken.getString("access_token");  
   	            if(!"".equals(access_token)){  
   	            	logger.info("获取access_token成功，o(∩_∩)o ————access_token:"+access_token);
   	            }else{  
   	                int errorrcode = jsonobjectToken.getInt("errcode");    
   	                String errmsg = jsonobjectToken.getString("errmsg");  
   	                logger.info("获取access_token错误码："+errorrcode+"————"+"错误信息："+errmsg);
   	                throw new BusinessException("系统异常，请联系管理员！");
   	            }  
   	        }else{  
   	        	logger.error("获取access_token失败，返回jsonobjectToken为空！");
   	        	throw new BusinessException("系统异常，请联系管理员！");
   	        } 
		} catch (Exception e) {
			logger.error(e);
			throw new BusinessException("系统异常，请联系管理员！");
		}
		return access_token;
	}

	/**
	 * 
	 * @Title: getUserInfo 
	 * @Description: 微信验证获取用户信息
	 * @param @param access_token
	 * @param @param code
	 * @param @return    设定文件 
	 * @return UserInfo    返回类型 
	 * @throws
	 */
	public static UserInfo getUserInfo(String access_token,String code){
		UserInfo userInfo = null;
		try {
			 //获取UserId
  	      	 String UserId = "";
  	      	 String url=PropertiesUtil.getParameter("CODE_TO_USERINFO","parameter");
  	      	 url = url.replace("ACCESS_TOKEN", access_token).replace("CODE", code);  
  	         JSONObject jsonobject = WeiXinUtil.httpRequest(url, "GET", null);
  	        if(null!=jsonobject){  
  	            UserId = jsonobject.getString("UserId");  
  	            if(!"".equals(UserId)){ 
  	            	logger.info("获取信息成功，o(∩_∩)o ————UserID:"+UserId);
  	            	//转换json为对象
  	            	JsonConfig config = new JsonConfig();
  	            	config.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
  		            @Override
  		            public String transformToJavaIdentifier(String str) {
  		                char[] chars = str.toCharArray();
  		                chars[0] = Character.toLowerCase(chars[0]);
  		                return new String(chars);
  		            }

  		        });
  		        config.setRootClass(UserInfo.class);
  		        userInfo = new UserInfo();
  		        userInfo = (UserInfo) JSONObject.toBean(jsonobject, config);
  	            //userInfo=objectMapper.readValue(jsonobject.toString(), UserInfo.class);
  	            }else{
  	            	String OpenId = jsonobject.getString("OpenId");    
  	            	if(null!=OpenId && !"".equals(OpenId)){
  	            		logger.info("非企业成员授权OpenId:"+OpenId);
  	            		JsonConfig config = new JsonConfig();
  	  	            	config.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {
  	  		            @Override
  	  		            public String transformToJavaIdentifier(String str) {
  	  		                char[] chars = str.toCharArray();
  	  		                chars[0] = Character.toLowerCase(chars[0]);
  	  		                return new String(chars);
  	  		            }

  	  		        });
  	  		        config.setRootClass(UserInfo.class);
  	  		        userInfo = new UserInfo();
  	  		        userInfo = (UserInfo) JSONObject.toBean(jsonobject, config);
  	  	            	//userInfo=objectMapper.readValue(jsonobject.toString(), UserInfo.class);
  	            	}else{
  	            		int errorrcode = jsonobject.getInt("errcode");    
  	  	                String errmsg = jsonobject.getString("errmsg");  
  	  	                logger.info("错误码："+errorrcode+"————"+"错误信息："+errmsg);
  	  	                throw new BusinessException("微信验证UserInfo错误，请稍后重试！");
  	            	}
  	            }  
  	        }else{  
  	        	logger.info("微信验证getUserInfo返回数据为空！");
  	        	throw new BusinessException("微信验证错误，请稍后重试！");
  	        } 
		} catch (Exception e) {
			logger.error(e);
			throw new BusinessException("微信验证错误，请稍后重试！");
		}
		
		return userInfo;
	}

	public static User getUserDetail(String access_token,String userid){
		User user = null;
		try {
			//获取用户信息
			 String url=PropertiesUtil.getParameter("CODE_TO_USERDETAIL","parameter");
			 url = url.replace("ACCESS_TOKEN", access_token).replace("USERID", userid);  
	        JSONObject jsonobject = WeiXinUtil.httpRequest(url, "GET", null);
	        
	        if(null!=jsonobject){  
	            String name = jsonobject.getString("name"); 
	            String useridstr = jsonobject.getString("userid"); 
	            if(!"".equals(name) && !"".equals(useridstr)){ 
	            	logger.info("获取UserDetail信息成功，o(∩_∩)o ————name:"+name);
	            	//转换json为对象,因为该处返回的数据比较多，只拾取数据库中想要的数据
  	            	user = new User();
  	            	user.setUserid(useridstr);
  	            	user.setName(name);
  	            	user.setGender(jsonobject.getInt("gender"));
  	            	user.setDepartment(jsonobject.getString("department"));
  	            	user.setPosition(jsonobject.getString("position"));
  	            	user.setAvatar(jsonobject.getString("avatar"));
  	            	user.setMobile(jsonobject.getString("mobile"));
  	            	user.setEmail(jsonobject.getString("email"));
  	            	
  	            	//user =(User) JSONObject.toBean(jsonobject,  User.class);
  	            	//user=objectMapper.readValue(jsonobject., User.class);
	            }else{  
	                int errorrcode = jsonobject.getInt("errcode");    
	                String errmsg = jsonobject.getString("errmsg"); 
	                logger.info("微信验证getUserDetail返回信息为空，userid："+userid+"错误码："+errorrcode+"————"+"错误信息："+errmsg);
	                throw new BusinessException("微信验证错误，请稍后重试！");
	            }  
	        }else{ 
	        	logger.info("微信验证getUserDetail返回数据为空！");
  	        	throw new BusinessException("微信验证错误，请稍后重试！");
	        } 
		} catch (Exception e) {
			logger.error(e);
			throw new BusinessException("微信验证错误，请稍后重试！");
		}
		return user;
	}
	
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		User userInfo = new User();
		String json = "{'errcode':0,'errmsg':'ok','userid':'15811025389','name':'申威','department':[6],'position':'','mobile':'15811025389','gender':'1','email':'','avatar':'http://p.qlogo.cn/bizmail/ObW8rPcn8icRtD3Hh8vUprZpV20UZ9RtZ9JfyjIFjnKoeMeZWeq0HKQ/0','status':1,'isleader':0,'extattr':{'attrs':[{'name':'员工生日','value':''}]},'english_name':'','telephone':'','enable':1,'hide_mobile':0,'order':[0]}";
		  JSONObject jsonObj1 = JSONObject.fromObject(json);
	        JsonConfig config = new JsonConfig();
	        config.setJavaIdentifierTransformer(new JavaIdentifierTransformer() {

	            @Override
	            public String transformToJavaIdentifier(String str) {
	                char[] chars = str.toCharArray();
	                chars[0] = Character.toLowerCase(chars[0]);
	                return new String(chars);
	            }

	        });
	        config.setRootClass(User.class);
	        User p2 = (User) JSONObject.toBean(jsonObj1, config);
	        System.out.println(p2.getUserid());
	}
}
