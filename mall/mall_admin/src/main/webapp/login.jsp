<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台登录-X-admin2.0</title>
	<meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="./common/images/wxShare.jpg" type="image/x-icon" />
    <link rel="stylesheet" href="admin/css/font.css">
	<link rel="stylesheet" href="admin/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="admin/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="admin/js/xadmin.js"></script>
</head>
<body class="login-bg">
    
    <div class="login">
        <div class="message">北京航天总医院点菜系统——管理登录</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" class="layui-form">
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required"   placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
            <div>
            <input name="randomCode" id="randomCode" maxlength="4" lay-verType="msg" style="width:160px;float:left;" lay-verify="required" value=""  placeholder="请输入验证码"  type="text" class="layui-input">
            </div>
            <img id="validateCodeImg" onclick="javascript:reloadValidateCode();" style="padding-top: 10px; padding-right: 0px;padding-bottom: 1px;padding-left: 20px;" src="${pageContext.request.contextPath}/validateCode.do" />&nbsp;&nbsp;<a href="#" onclick="javascript:reloadValidateCode();">看不清？</a>
            <hr class="hr15">
            <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
            <hr class="hr20" >
            ${msg}
        </form>
    </div>

    <script>
	    $(function  () {
	        layui.use('form', function(){
	          var form = layui.form;
	          //监听提交
	          form.on('submit(login)', function(data){
	        	  var param = JSON.parse(JSON.stringify(data.field));
            	  $.ajax({
            	        url : "${pageContext.request.contextPath}/login.do",
            	        type : "post",
            	        dataType : "json",
            	        data : param,
            	        cache : false,
            	        async : false,
            	        success : function(data, textStatus, jqXHR) {
            	            if(data.code==0){
            	            	reloadValidateCode();
            	            	$("#randomCode").val("");
            	            	layer.msg(data.msg,{icon: 2,time:1000});
            	            	return false;
            	            }
           	            	layer.msg(data.msg,{time:500}, function(){
           	            		location.href='${pageContext.request.contextPath}/home.do';
           		            });
            	        },
            	        error : function(XMLHttpRequest, textStatus, errorThrown) {
            	            layer.msg("服务器忙,请稍后再试");
            	        }
            	    });
	            return false;
	          });
	        });
    	})
        /* $(function  () {
            layui.use('form', function(){
	          var param = layui.form;
              //监听提交
              form.on('submit(login)', function(data){
				alert("aa");            	  
            	  return false;
              });
            });
        }) */
        function reloadValidateCode(){
            $("#validateCodeImg").attr("src","${pageContext.request.contextPath}/validateCode.do?data=" + new Date() + Math.floor(Math.random()*24));
        }

        
    </script>

    
    <!-- 底部结束 -->
    <script>
    //百度统计可去掉
   /*  var _hmt = _hmt || [];
    (function() {
      var hm = document.createElement("script");
      hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
      var s = document.getElementsByTagName("script")[0]; 
      s.parentNode.insertBefore(hm, s);
    })(); */
    </script>
</body>
</html>