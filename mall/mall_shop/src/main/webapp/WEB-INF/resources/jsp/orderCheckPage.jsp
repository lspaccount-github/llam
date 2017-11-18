<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>请点餐</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/base.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">	
	<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container">
	   <div class="container_box">
	   		<ol class="boxwindow">
	   			<c:forEach items="${orderConfirms}" var="orderConfirms" varStatus="vs">
					<li>
	   				<span>${orderConfirms.product.productName}</span>
	   		        <span>*<b>${orderConfirms.num}</b></span>
	   		        <span>￥${orderConfirms.price}</span>
	   		    </li>
				</c:forEach>
	   			<!-- <li>
	   				<span>窗口取餐（三荤一素）</span>
	   		        <span>*<b>5</b></span>
	   		        <span>￥10.00</span>
	   		    </li>
	   		    <li>
	   				<span>窗口取餐（三荤一素）</span>
	   		        <span>*<b>5</b></span>
	   		        <span>￥10.00</span>
	   		    </li>
	   		    <li>
	   				<span>窗口取餐（三荤一素）</span>
	   		        <span>*<b>5</b></span>
	   		        <span>￥10.00</span>
	   		    </li> -->
	   		</ol>
	   	 <form action="">
	   	 <ul>
	   		<li>
	   			<span>姓名</span>
	   		    <input type="text" name="contacts" id=""  placeholder="杨蜜儿">  			
	   		</li>
	   		<li>
	   			<span>联系电话</span>	   			
	   			<input type="text" name="phone" id="" placeholder="123321123321">	
	   		</li>
	   		<li>
	   			<span>方位</span>
	   			 <div>
	   			 <select name="position1" id="position1">
	   			 	<option value="1">东楼</option>
	   			 	<option value="2">西楼</option>
	   			 	<option value="3">南楼</option>
	   			 	<option value="4">北楼</option>
	   			 </select>
	   			</div>
	   		</li>
	   		<li>
	   			 <div>
	   			 <select name="position2" id="position2">
	   			 	<option value="1">保卫部</option>
	   			 	<option value="2">科技部</option>
	   			 	<option value="3">后勤部</option>
	   			 </select>
	   			</div>
	   		</li>
	   	</ul>
	   	</form>
	   </div>
	  <div class="container_bottom">
	  	<a href="javascript:void(0);" onclick="returnMerchantHomePageFun();"  class="return">返回</a>
	  	<span>应付款<i>￥${totalPrice}</i></span>
	  	<a href="javascript:void(0);" class="sure">确认订单</a>
	  </div>
	</div>
	<!-- 隐藏form 用户返回按钮 -->
	<form action="${pageContext.request.contextPath}/merchantHomePage/orderPage.html" method="post" id="returnMerchantHomePage">
		<input type="hidden" name="merchantId" value="20171112185000001" />
		<input type="hidden" id="productinfoh1" name="productinfo" value="" />
	</form>
</body>
</html>

<script>
	var productinfoStr = ${productInfo};
	function returnMerchantHomePageFun(){
		$("#productinfoh1").val(JSON.stringify(productinfoStr).replace(/\"/g,"'"));
		$("#returnMerchantHomePage").submit();
	}		
</script>