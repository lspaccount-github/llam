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
          <div class="order_status">
            <div><img src="${pageContext.request.contextPath}/common/images/name.png" alt=""></div>
            <div>
              <p>姓名: <span>${order.orderAddress.contacts}</span></p>
              <p>电话: <span>${order.orderAddress.phone}</span></p>
              <p>送餐地址：<span>${order.orderAddress.detailAddress}</span></p>
            </div>
            <div class="handle">${order.orderStatus}</div>
          </div>  
          <div class="calculate">
            <ul>
            	<c:forEach items="${order.orderProducts}" var="orderProduct" varStatus="vs">
              		<li><span>${orderProduct.productName}<i>x${orderProduct.buyProductNum}</i></span> <span>￥${orderProduct.price}</span></li>
              	</c:forEach>	
            </ul>
            <div>总金额 : <span>￥${order.orderMoney}</span></div>
          </div>
      </div>
</body>
</html>

<script>
	
</script>