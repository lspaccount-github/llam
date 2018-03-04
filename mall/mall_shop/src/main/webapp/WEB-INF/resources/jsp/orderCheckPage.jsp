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
	   <div class="container_box" id="addProductDiv">
	   		<ol class="boxwindow" id="addProduct">
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
	   	 <ul id="addLi-ul">
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
	   			<input type="text" name="remark" id="remark" maxlength="30" style="color:#999;"  value="请输入订单备注">	
	   		</li>
	   		<li>
	   			<span>详细地址</span>	   			
	   			<input type="text" name="detailAddress" id="detailAddress" maxlength="50" style="color:#999;"  value="${orderAddress.detailAddress}">	
	   		</li>
	   		<li>
	   			<span>方位</span>
	   			 <div>
	   			 <select name="position" id="position">
	   				<option value="0">请选择</option>
	   			 	<option value="1">门诊一区</option>
	   			 	<option value="2">门诊二区</option>
	   			 	<option value="3">一号住院楼</option>
	   			 	<option value="4">二号住院楼</option>
	   			 	<option value="5">三号住院楼</option>
	   			 	<option value="6">职防楼</option>
	   			 	<option value="7">手术楼</option>
	   			 	<option value="8">影像中心</option>
	   			 </select>
	   			</div>
	   		</li>
	   		<li>
	   			<span>是否配送</span>
	   			 <div>
	   			 <select name="isDistribution" id="isDistribution">
	   				<option value="0">请选择</option>
	   			 	<option value="1">是</option>
	   			 	<option value="2">否</option>
	   			 	
	   			 </select>
	   			</div>
	   		</li>
	   		<li>
	   			<span>是否需要餐具</span>
	   			 <div>
	   			 <select name="isTableware" id="isTableware">
	   				<option value="0">请选择</option>
	   			 	<option value="1">是</option>
	   			 	<option value="2">否</option>
	   			 	
	   			 </select>
	   			</div>
	   		</li>
	   		<!-- <li>
	   			 <div>
	   			 <select name="position2" id="position2">
	   			 	<option value="1">保卫部</option>
	   			 	<option value="2">科技部</option>
	   			 	<option value="3">后勤部</option>
	   			 </select>
	   			</div>
	   		</li> -->
	   	</ul>
	   	<input type="hidden" id="productinfoh1" name="productinfo" value="" />
	   	</form>
	   </div>
	  <div class="container_bottom">
	  	<a href="javascript:void(0);" onclick="returnMerchantHomePageFun();"  class="return">返回</a>
	  	<span>应付款<i id="Payable">￥${totalPrice}</i></span>
	  	<input type="hidden" id="PayableHidden" value="${totalPrice}"><!-- 计算金额使用 -->
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
	var detailAddress = '${orderAddress.detailAddress}';
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
 	//获取焦点
 	$('#detailAddress').on('focus',function(){
 		if($('#detailAddress').val()=="" || $('#detailAddress').val()==null || $('#detailAddress').val()=="请输入详细地址" || $('#detailAddress').val()==detailAddress){
 			$('#detailAddress').val("");
 		}
 		$('#detailAddress').css('color','#000');
 	});
 	//失去焦点
 	$('#detailAddress').on('blur',function(){
 		if($('#detailAddress').val()=="" || $('#detailAddress').val()==null|| $('#detailAddress').val()=="请输入详细地址" || $('#detailAddress').val()==detailAddress){
 			$('#detailAddress').val(detailAddress);
 			$('#detailAddress').css('color','#999');
 		}else{
 			$('#detailAddress').css('color','#000');
 		}
 	});
 	
 	//获取焦点
 	$('#remark').on('focus',function(){
 		if($('#remark').val()=="" || $('#remark').val()==null || $('#remark').val()=="请输入订单备注" || $('#remark').val()==remark){
 			$('#remark').val("");
 		}
 		$('#remark').css('color','#000');
 	});
 	//失去焦点
 	$('#remark').on('blur',function(){
 		if($('#remark').val()=="" || $('#remark').val()==null|| $('#remark').val()=="请输入订单备注" || $('#remark').val()==remark){
 			$('#remark').val("请输入订单备注");
 			$('#remark').css('color','#999');
 		}else{
 			$('#remark').css('color','#000');
 		}
 	});
 	
 	//餐具输入框的Keyup事件
 	function tablewareNumKeyup(){ 
 		var c=$("#tablewareNum");  
        if(/[^\d]/.test(c.val())){//替换非数字字符  
          var temp_amount=c.val().replace(/[^\d]/g,''); 
          $("#tablewareNum").val(temp_amount);  
        } 
 	}
 	//餐具输入框的获取焦点事件
 	function tablewareNumFocus(){ 
 		if($('#tablewareNum').val()=="" || $('#tablewareNum').val()==null || $('#tablewareNum').val()=="请输入餐具数量"){
 			$('#tablewareNum').val("");
 		}
 		$('#tablewareNum').css('color','#000');
 	}
 	//餐具输入框的失去焦点事件
 	function tablewareNumBlur(){ 
 		if($('#tablewareNum').val()=="" || $('#tablewareNum').val()==null|| $('#tablewareNum').val()=="请输入餐具数量" || $('#tablewareNum').val()==0){
 			$('#tablewareNum').val("请输入餐具数量");
 			$('#tablewareNum').css('color','#999');
 		}else{
 			$('#tablewareNum').css('color','#000');
 			//查询餐具的费用，显示餐具费
 			var parent=document.getElementById("addProductDiv");
			var parent1=document.getElementById("addProduct");
			var child=document.getElementById("tablewareNumLi");    
		
			var bool=isDOMContains(parent1,child,parent);
			
 			var url = "${pageContext.request.contextPath}/order/SysParameter.html";
	        $.post(url,{"id":"2"},function(data){
	        	if(bool){
					var parent=document.getElementById("addProduct");
					var child=document.getElementById("tablewareNumLi");
					parent.removeChild(child);
					$("#Payable").text("￥"+(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNumPro').text())));
					$("#PayableHidden").val(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNumPro').text()));
				}
	        	//addProduct
				var htmlCode="<li id='tablewareNumLi'><span>"+data.sysParameter.parameterName+"</span><span>X<b id='tablewareNumPro'>"+$('#tablewareNum').val()+"</b></span><span>￥"+$('#tablewareNum').val()*data.sysParameter.parameterValue+"</span></li>";
	        	var html = document.getElementById("addProduct").innerHTML;
				//再跟你想追加的代码加到一起插入div中
				document.getElementById("addProduct").innerHTML = html + htmlCode;
				//修改应付款金额
    			$("#Payable").text("￥"+(parseFloat($("#PayableHidden").val())+parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNum').val())));
    			$("#PayableHidden").val(parseFloat($("#PayableHidden").val())+parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNum').val()));
	        }) 
 		}
 	}
 	
 	
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
	
	//判断一个元素是否包含一个指定节点
	function isDOMContains(parentEle,ele,container){
	    //parentEle: 要判断节点的父级节点
	    //ele:要判断的子节点
	    //container : 二者的父级节点
	    
	    //如果parentEle h和ele传的值一样，那么两个节点相同
	    if(parentEle == ele){
	        return true
	    }
	    if(!ele || !ele.nodeType || ele.nodeType != 1){
	        return false;
	    }
	    //如果浏览器支持contains
	    if(parentEle.contains){
	        return parentEle.contains(ele)
	    }
	    //火狐支持
	    if(parentEle.compareDocumentPosition){
	        return !!(parentEle.compareDocumentPosition(ele)&16);
	    }

	    //获取ele的父节点
	    var parEle = ele.parentNode;
	    while(parEle && parEle != container){
	       if(parEle == parentEle){
	        return true;
	       }
	       parEle = parEle.parentNode;
	    }
	    return false;
	}
	
	
	//选择是否需要配送
	$("#isDistribution").bind("change",function(){
		var parent=document.getElementById("addProductDiv");
		var parent1=document.getElementById("addProduct");
		var child=document.getElementById("distributionLi");    
		
		var bool=isDOMContains(parent1,child,parent);//判断商品类表div中是否包含配送费的子节点
		
		var url = "${pageContext.request.contextPath}/order/SysParameter.html";
        $.post(url,{"id":"1"},function(data){
        	var dis = $("#isDistribution").val();
    		if("1"==dis){//需要配送
    			if(bool){
    				var parent=document.getElementById("addProduct");
    				var child=document.getElementById("distributionLi");
    				parent.removeChild(child);
    			}

        		
            	//addProduct
    			var htmlCode="<li id='distributionLi'><span>"+data.sysParameter.parameterName+"</span><span>X<b>1</b></span><span>￥"+data.sysParameter.parameterValue+"</span></li>";
            	var html = document.getElementById("addProduct").innerHTML;
    			//再跟你想追加的代码加到一起插入div中
    			document.getElementById("addProduct").innerHTML = html + htmlCode;
    			//修改应付款金额
    			$("#Payable").text("￥"+(parseFloat($("#PayableHidden").val())+parseFloat(data.sysParameter.parameterValue)));
    			$("#PayableHidden").val(parseFloat($("#PayableHidden").val())+parseFloat(data.sysParameter.parameterValue));
    			
    		}else{//不需要配送
    			if(bool){
    				var parent=document.getElementById("addProduct");
    				var child=document.getElementById("distributionLi");
    				parent.removeChild(child);
    				$("#Payable").text("￥"+(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue)));
    				$("#PayableHidden").val(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue));
    			}
    		}
        })
    });
	
	//选择是否需要餐具
	$("#isTableware").bind("change",function(){
		var parent=document.getElementById("submitOrder");
		var parent1=document.getElementById("addLi-ul");
		var child=document.getElementById("tablewareLi");    
		var bool=isDOMContains(parent1,child,parent);
		
		var dis = $("#isTableware").val();
		if("1"==dis){//需要餐具
			if(bool){
				var parent=document.getElementById("addLi");
				var child=document.getElementById("tablewareNum");
				parent.removeChild(child);
			}
			var htmlCode="<li id='tablewareLi'><span>餐具数量</span><input type='text' onkeyup='tablewareNumKeyup()' onfocus='tablewareNumFocus()' onblur='tablewareNumBlur()' name='tablewareNum' id='tablewareNum' maxlength='5' style='color:#999;'  value='请输入餐具数量'>	</li>";
			$("#addLi-ul").append(htmlCode);
		}else{//不需要餐具
			if(bool){
				var parent=document.getElementById("addLi-ul");
				var child=document.getElementById("tablewareLi");
				parent.removeChild(child);
			}
			var parent=document.getElementById("addProductDiv");
			var parent1=document.getElementById("addProduct");
			var child=document.getElementById("tablewareNumLi");    
		
			var bool=isDOMContains(parent1,child,parent);
			if(bool){
				var url = "${pageContext.request.contextPath}/order/SysParameter.html";
		        $.post(url,{"id":"2"},function(data){
					//修改应付款金额
					$("#Payable").text("￥"+(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNumPro').text())));
					$("#PayableHidden").val(parseFloat($("#PayableHidden").val())-parseFloat(data.sysParameter.parameterValue)*parseFloat($('#tablewareNumPro').text()));
					
					var parent=document.getElementById("addProduct");
					var child=document.getElementById("tablewareNumLi");
					parent.removeChild(child);

		        })
			}
		}
    });
	
	
	
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
		if($('#remark').val()=="" || $('#remark').val()==null || $('#remark').val()=="请输入订单备注"){
			//信息框
	      	  layer.open({
	      	    content: '请输入订单备注！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		if($('#detailAddress').val()=="" || $('#detailAddress').val()==null || $('#detailAddress').val()=="请输入详细地址"){
			//信息框
	      	  layer.open({
	      	    content: '请输入详细地址！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		if($('#position').val()=="0"){
			//信息框
	      	  layer.open({
	      	    content: '请选择方位！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		if($('#isDistribution').val()=="0"){
			//信息框
	      	  layer.open({
	      	    content: '请选择是否配送！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}
		if($('#isTableware').val()=="0"){
			//信息框
	      	  layer.open({
	      	    content: '请选择是否需要餐具！'
	      	    ,btn: '确定'
	      	  });
			return;
 		}else if($('#isTableware').val()=="1"){
 			//需要餐具
 			if($("#tablewareNum").val()=="" || $("#tablewareNum").val()==null || $("#tablewareNum").val()==0 || $("#tablewareNum").val()=="请输入餐具数量"){
 				//信息框
 		      	  layer.open({
 		      	    content: '请输入餐具数量！'
 		      	    ,btn: '确定'
 		      	  });
 				return;
 			}
 		}
		
		
		
		$("#productinfoh1").val(JSON.stringify(productinfoStr).replace(/\"/g,"'"));
		/* $("#submitOrder").submit(); */
		///////////////////////////////////////////////////
		/* var param = {"contacts":$('#name').val(),"phone":$('#phone').val(),"remark":$('#remark').val(),"productinfo":$("#productinfoh1").val(),"position1":$("#position1").val(),"detailAddress":$("#detailAddress").val()}; */
		var param = {"contacts":$('#name').val(),"phone":$('#phone').val(),"remark":$('#remark').val(),"productinfo":$("#productinfoh1").val(),"detailAddress":$("#detailAddress").val(),"position":$("#position").find("option:selected").text(),"isDistribution":$("#isDistribution").val(),"isTableware":$("#isTableware").val(),"tablewareNum":$("#tablewareNum").val()};
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