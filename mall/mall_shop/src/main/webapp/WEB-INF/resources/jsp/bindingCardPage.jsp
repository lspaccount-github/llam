<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>餐卡绑定</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/base.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/js/layer_mobile/need/layer.css">	
		<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/common/js/layer_mobile/layer.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container">
      <div class="card">
      	<form action="#">
      		<ul>
      		    <li><span>姓名</span><input type="text" id="name" name="name" placeholder="请输入姓名"></li>
      		    <li><span>人员编号</span><input type="text" id="hospitalCardCode" name="hospitalCardCode" placeholder="请输入餐卡卡号"></li>
      	    </ul>
      	    <div class="btn"><a herf="javascript:void(0);" onclick="submitCard();">确定</a></div>
      	</form>
      </div>
	</div>
</body>
<script>
 var orderId=${orderId}; 

	function submitCard(){
		var name=$("#name").val();
		if(""==name || null==name || undefined==name){
			layer.open({
        	    content: "请输入姓名!"
        	    ,btn: '确定'
        	  });
			return;
		}
		var hospitalCardCode=$("#hospitalCardCode").val();
		if(""==hospitalCardCode || null==hospitalCardCode || undefined==hospitalCardCode){
			layer.open({
        	    content: "请输入餐卡卡号!"
        	    ,btn: '确定'
        	  });
			return;
		}
		var paymentPassword=$("#paymentPassword").val();
		if(""==paymentPassword || null==paymentPassword || undefined==paymentPassword){
			layer.open({
        	    content: "请输入支付密码!"
        	    ,btn: '确定'
        	  });
			return;
		}
		var confirmPassword=$("#confirmPassword").val();
		if(""==confirmPassword || null==confirmPassword || undefined==confirmPassword){
			layer.open({
        	    content: "请输入确认密码!"
        	    ,btn: '确定'
        	  });
			return;
		}
		
		if(paymentPassword!=confirmPassword){
			layer.open({
        	    content: "您输入的支付密码与确认密码不一致，请修改!"
        	    ,btn: '确定'
        	  });
			return;
		}
		var dataJson = {"name":name,"hospitalCardCode":hospitalCardCode,"paymentPassword":paymentPassword};
		 $.ajax({
		        url : '${pageContext.request.contextPath}/BindingCard/addBindingCard.html',
		        type : "post",
		        dataType : "json",
		        data:dataJson,
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
		            	}else if(data.flag=="1"){
		            		window.location.href="${pageContext.request.contextPath}/order/goToOrderDtail.html?orderId="+orderId;
		            		return;
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
</html>

