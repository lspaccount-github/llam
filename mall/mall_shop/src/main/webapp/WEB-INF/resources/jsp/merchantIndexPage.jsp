<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
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
		<script src="${pageContext.request.contextPath}/common/js/Tools.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container">
		<div class="Leftside">
			<ul>
				<c:forEach items="${productClassifyList}" var="productClassify" varStatus="vs">
					<c:if test="${vs.count == 1}">
	       				<li class="current1"  onClick="getProduct(this,'${productClassify.classifyId}')"><a href="javascript:void(0);">${productClassify.classifyName}</a></li>
	       				<input id="initClassifyId" type="hidden" value="${productClassify.classifyId}"/>
					</c:if>
					<c:if test="${vs.count != 1}">
	       				<li onClick="getProduct(this,'${productClassify.classifyId}')"><a href="javascript:void(0);">${productClassify.classifyName}</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div class="Rightside">
		  <div class="R_box current" id="ProductHtml">
				<dl>
					<dt><img src="../images/food.jpg" alt=""></dt>
					<dd><p>窗口套餐（三荤一素）</p></dd>
					<dd><span>￥10.00</span><span>/份</span></dd>
					<dd class="aa"><a href="#"  class="minus"></a><span>1</span> <a href="#" class="plus"></a></dd>
				</dl>
			</div>
		</div>

		<div class="order">
			<span>
				<%-- <img src="${pageContext.request.contextPath}/common/images/n-cart.png" style="width: 36px;height: 36px;" alt=""> --%>
				<i id="totalPrice">${totalPrice}</i>元
			</span>
			<a href="javascript:void(0)" onclick="toConfirmOrder();">去下单</a>
		</div>
	</div>
	<form action="${pageContext.request.contextPath}/order/goToOrderConfirmPage.html" method="post" id="productSubmit">
		<input type="hidden" name="productInfo" value="" id="productInfo"/>
	</form>
</body>
</html>

<script>
//初始化
$(function(){ 
	var classifyId=$("#initClassifyId").val();
	getProductAjax(classifyId);
}); 
	
	function getProduct(objThis,classifyId){
		var liClass= $(objThis).attr('class');
		if("current1"==liClass){
			return;
		}else{
			$('.current1').attr('class','');
			$(objThis).attr('class','current1');
			getProductAjax(classifyId);
		}
	}
	
	var shopCartPrice = ${totalPrice};
	var shopCartObj = null;
	var pi =  ${productinfo};
	if(pi=="" || null ==pi || pi=="null"){
		shopCartObj = [];	
	}else{
		shopCartObj = pi;
	}
	function jia(event){
		var productId=event|| window.event;
		var shopCartLength = shopCartObj.length;
		if(shopCartLength>0){
			var bool = false;
			for(var i = 0;i<shopCartLength;i++){
				if(shopCartObj[i].productId == productId){
					shopCartObj[i].num = shopCartObj[i].num+1;
					bool = true;
					$("#"+productId+"num").text(shopCartObj[i].num);
					shopCartPrice = toDecimalNum(shopCartPrice)+toDecimalNum($("#"+productId+"price").text());//+计算
					shopCartPrice=toDecimalStr(shopCartPrice);
					$("#totalPrice").text(shopCartPrice);
				}
			}
			if(!bool){
				var prodJson = {"productId":productId,"num":1,"price":$("#"+productId+"price").text()};
				shopCartObj.push(prodJson);
				$("#"+productId+"num").text(1);
				shopCartPrice = toDecimalNum(shopCartPrice)+toDecimalNum($("#"+productId+"price").text());//+计算
				shopCartPrice=toDecimalStr(shopCartPrice);
				$("#totalPrice").text(shopCartPrice);
			}
		}else{
			var prodJson = {"productId":productId,"num":1,"price":$("#"+productId+"price").text()};
			shopCartObj.push(prodJson);
			$("#"+productId+"num").text(1);
			shopCartPrice = toDecimalNum(shopCartPrice)+toDecimalNum($("#"+productId+"price").text());//+计算
			shopCartPrice=toDecimalStr(shopCartPrice);
			$("#totalPrice").text(shopCartPrice);
		}
	}
	
	function jian(event){
		var productId=event|| window.event;
		var shopCartLength = shopCartObj.length;
		if(shopCartLength>0){
			for(var i = 0;i<shopCartLength;i++){
				if(shopCartObj[i].productId == productId){
					if(shopCartObj[i].num==1){
						shopCartObj.splice(i,1)
						$("#"+productId+"num").text(0);
						shopCartPrice = toDecimalNum(shopCartPrice)-toDecimalNum($("#"+productId+"price").text());//-计算
						shopCartPrice=toDecimalStr(shopCartPrice);
						$("#totalPrice").text(shopCartPrice);
						break;
					}else if(shopCartObj[i].num<=0){
						$("#"+productId+"num").text(0);
					}else{
						shopCartObj[i].num = shopCartObj[i].num -1;
						$("#"+productId+"num").text(shopCartObj[i].num);
						shopCartPrice = toDecimalNum(shopCartPrice)-toDecimalNum($("#"+productId+"price").text());//-计算
						shopCartPrice=toDecimalStr(shopCartPrice);
						$("#totalPrice").text(shopCartPrice);
					}
				}
			}
		}else{
			return;
		}
	}
	
	
	function getProductAjax(classifyId){
		$("#ProductHtml").html("");
		var param = {"productClassifyId":classifyId};
		var htmlCode = "";
		 $.ajax({
		        url : '${pageContext.request.contextPath}/merchantHomePage/getProductByProductClassifyId.do',
		        type : "post",
		        dataType : "json",
		        data : param,
		        cache : false,
		        async : false,
		        success : function(data, textStatus, jqXHR) {
		            if ('success' == textStatus) {
		            	if(data.flag=="0"){
		            		//$("#ProductHtml").html(data.message);
		            		//信息框
				        	  layer.open({
				        	    content: data.message
				        	    ,btn: '确定'
				        	  });
		            		return;
		            	}else{
		            		var productList = eval('(' + data.productList + ')'); 
		            		var shopCartLength = shopCartObj.length;
		            		for(var i=0; i<productList.length; i++){
		            			var num = 0;
		            			if(shopCartLength>0){
		            				for(var j = 0;j<shopCartLength;j++){
		            					if(shopCartObj[j].productId == productList[i].productId){
		            						num = shopCartObj[j].num;
		            					}
		            				}	
		            			}
		            			htmlCode +='<dl><dt><img src="'+data.IMG_WEB+productList[i].pictureUrl+'"></dt>';
		            			htmlCode +='<dd><p>'+productList[i].productName+'</p></dd>';
		            			htmlCode +='<dd><span>￥<i id="'+productList[i].productId+'price">'+productList[i].productSpecList[0].price+'<i/></span><span>/'+productList[i].productUnit+'</span></dd>';
		            			htmlCode +='<dd class="aa"><a href="javascript:void(0)" onclick="jian('+"'"+productList[i].productId+"'"+');" class="minus"></a><span id="'+productList[i].productId+'num">'+num+'</span> <a href="javascript:void(0)" onclick="jia('+"'"+productList[i].productId+"'"+');" class="plus"></a></dd></dl>';
		            		}
		            		$("#ProductHtml").html("");
		            		$("#ProductHtml").html(htmlCode);
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
	
	function toConfirmOrder(){
		var shopCartLength = shopCartObj.length;
		if(shopCartLength>0){
			var strify = JSON.stringify(shopCartObj);
			$("#productInfo").val(strify);
			$("#productSubmit").submit();
		}else{
		  //信息框
      	  layer.open({
      	    content: '请选择商品！'
      	    ,btn: '确定'
      	  });
		}
	}
</script>