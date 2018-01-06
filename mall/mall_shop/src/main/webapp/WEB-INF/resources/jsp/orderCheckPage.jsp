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
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/js/layer_mobile/need/layer.css">	
		<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/common/js/layer_mobile/layer.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container">
	   <div class="container_box">
	   		<ol class="boxwindow">
	   			<c:forEach items="${orderConfirms}" var="orderConfirms" varStatus="vs">
					<li>
	   				<span>${orderConfirms.product.productName}</span>
	   		        <span>X<b>${orderConfirms.num}</b></span>
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
	   	 <form action="${pageContext.request.contextPath}/order/submitOrder.html" method="post" id="submitOrder">
	   	 <ul>
	   		<li>
	   			<span>姓名</span>
	   		    <input type="text" name="contacts" id="name" maxlength="20" style="color:#999;"  value="${orderAddress.contacts}">  			
	   		</li>
	   		<li>
	   			<span>联系电话</span>	   			
	   			<input type="tel" name="phone" id="phone" maxlength="11" style="color:#999;"  value="${orderAddress.phone}">	
	   		</li>
	   		<li>
	   			<span>订单备注</span>	   			
	   			<input type="text" name="remark" id="remark" maxlength="11" style="color:#000;"  value="">	
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
	   	<input type="hidden" id="productinfoh1" name="productinfo" value="" />
	   	</form>
	   </div>
	  <div class="container_bottom">
	  	<a href="javascript:void(0);" onclick="returnMerchantHomePageFun();"  class="return">返回</a>
	  	<span>应付款<i>￥${totalPrice}</i></span>
	  	<a href="javascript:void(0);" onclick="submitOrder();" class="sure">确认订单</a>
	  </div>
	</div>
	<!-- 隐藏form 用户返回按钮 -->
	<form action="${pageContext.request.contextPath}/merchantHomePage/orderPage.html" method="post" id="returnMerchantHomePage">
		<input type="hidden" name="merchantId" value="20171112185000001" />
		<input type="hidden" id="productinfoh2" name="productinfo" value="" />
	</form>
</body>
</html>

<script>
	var name = '${orderAddress.contacts}';
	var phone = '${orderAddress.phone}';
	//获取焦点
 	$('#name').on('focus',function(){
 		if($('#name').val()=="" || $('#name').val()==null || $('#name').val()=="请输入姓名" || $('#name').val()==name){
 			$('#name').val("");
 		}
 		$('#name').css('color','#000');
 	});
 	//失去焦点
 	$('#name').on('blur',function(){
 		if($('#name').val()=="" || $('#name').val()==null || $('#name').val()=="请输入姓名" || $('#name').val()==name){
 			$('#name').val(name);
 			$('#name').css('color','#999');
 		}else{
 			$('#name').css('color','#000');
 		}
 	});
 	
 	//获取焦点
 	$('#phone').on('focus',function(){
 		if($('#phone').val()=="" || $('#phone').val()==null || $('#phone').val()=="请输入联系电话" || $('#phone').val()==phone){
 			$('#phone').val("");
 		}
 		$('#phone').css('color','#000');
 	});
 	//失去焦点
 	$('#phone').on('blur',function(){
 		if($('#phone').val()=="" || $('#phone').val()==null|| $('#phone').val()=="请输入联系电话" || $('#phone').val()==phone){
 			$('#phone').val(phone);
 			$('#phone').css('color','#999');
 		}else{
 			$('#phone').css('color','#000');
 		}
 	});
 	
 	$('#phone').keyup(function(){  
        var c=$(this);  
        if(/[^\d]/.test(c.val())){//替换非数字字符  
          var temp_amount=c.val().replace(/[^\d]/g,'');  
          $(this).val(temp_amount);  
        }  
     })   
 	
	var productinfoStr = ${productInfo};
	//返回上一页方法
	function returnMerchantHomePageFun(){
		$("#productinfoh2").val(JSON.stringify(productinfoStr).replace(/\"/g,"'"));
		$("#returnMerchantHomePage").submit();
	}	
	
	//提交订单
	function submitOrder(){
		if($('#name').val()=="" || $('#name').val()==null || $('#name').val()=="请输入姓名"){
			//信息框
	      	  layer.open({
	      	    content: '请输入姓名！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		if($('#phone').val()=="" || $('#phone').val()==null || $('#phone').val()=="请输入联系电话"){
			//信息框
	      	  layer.open({
	      	    content: '请输入联系电话！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		$("#productinfoh1").val(JSON.stringify(productinfoStr).replace(/\"/g,"'"));
		/* $("#submitOrder").submit(); */
		///////////////////////////////////////////////////
		var param = {"contacts":$('#name').val(),"phone":$('#phone').val(),"remark":$('#remark').val(),"productinfo":$("#productinfoh1").val(),"position1":$("#position1").val(),"position2":$("#position2").val()};
		 $.ajax({
		        url : '${pageContext.request.contextPath}/order/submitOrder.html',
		        type : "post",
		        dataType : "json",
		        data : param,
		        cache : false,
		        async : false,
		        success : function(data, textStatus, jqXHR) {
		            if ('success' == textStatus) {
		            	if(data.flag=="0"){
		            		//信息框
				        	  layer.open({
				        	    content: data.message
				        	    ,btn: '确定'
				        	  });
		            		return;
		            	}else{
		            		window.location.href = "${pageContext.request.contextPath}/order/goToOrderPay.html?orderId="+data.orderId;
		            	}
		            }
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown) {
		        	//信息框
		        	  layer.open({
		        	    content: '系统异常,请稍后重试！'
		        	    ,btn: '确定'
		        	  });
		        }
		    });
	}
</script>