<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>我的订餐</title>
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
           <div class="myorder">
             <ul>
             <c:forEach items="${orderList}" var="order" varStatus="vs">
	               <li onclick="goToOrderDtail('${order.orderId}');">
	                 <div class="left">
	                   <div><span>${order.orderProducts.get(0).productName}</span> <span>x${order.orderProducts.get(0).buyProductNum}</span></div>
	                   <div><span><fmt:formatDate value="${order.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/></span><span>医院食堂</span></div>
	                 </div>
	                 <div class="right">
	                   <div>${order.orderStatusView}</div>
	                   <span>￥${order.orderMoney}</span>
	                 </div>
	               </li>
              </c:forEach> 
             </ul>
           </div>
      </div>
</body>
</html>

<script>
	//跳转订单详情页
	function goToOrderDtail(orderId){
		window.location.href = "${pageContext.request.contextPath}/order/goToOrderDtail.html?orderId="+orderId;
	}
</script>