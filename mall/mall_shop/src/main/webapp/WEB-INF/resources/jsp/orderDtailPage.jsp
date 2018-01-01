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
            <div><img src="${avatar}" alt=""></div>
            <div>
              <p>姓名: <span>${order.orderAddress.contacts}</span></p>
              <p>电话: <span>${order.orderAddress.phone}</span></p>
              <p>送餐地址：<span>${order.orderAddress.detailAddress}</span></p>
            </div>
           <%--  ${order.orderStatus} --%>
            <div class="handle">${order.orderStatusView}</div>
          </div>  
          <div class="calculate">
            <ul>
            	<c:forEach items="${order.orderProducts}" var="orderProduct" varStatus="vs">
              		<li><span>${orderProduct.productName}<i>x${orderProduct.buyProductNum}</i></span> <span>￥${orderProduct.price}</span></li>
              	</c:forEach>	
            </ul>
            <div>总金额 : <span>￥${order.orderMoney}</span></div>
          </div>
        <c:if test="${order.orderStatus == 1}">  
	          <div class="cancle">
	              <span><a href="javascript:void(0);" onclick="cancelOrder('${order.orderId}')">取消订单</a></span>
	              <c:if test="${timeDifference > 3}">
	              		<span><a href="${pageContext.request.contextPath}/order/goToOrderPay.html?orderId=${order.orderId}" id="goToPay">去支付(还剩<em id="d_m">0</em>分<em id="d_s">00</em>秒)</a></span>
	              </c:if>
	              <c:if test="${timeDifference < 3}">
	              		<span><a href="javascript:void(0);"  disabled="true" style="border:1px solid #999;background:#999;">去支付<em>(还剩0分0秒)</em></a></span>
	              </c:if>
	          </div>
        </c:if> 
        <c:if test="${order.orderStatus == 3}">  
	          <div class="cancle">
	              <span><a href="javascript:void(0);" onclick="confirmOrder('${order.orderId}')">确认订单已完成</a></span>
	          </div>
        </c:if> 
      </div>
</body>
</html>

<script>
var timeDifference = ${timeDifference};//毫秒时间差
$(function(){
	pushHistory(); 
	window.addEventListener("popstate", function(e) { 
		window.location.href = "${pageContext.request.contextPath}/order/goToOrderDtail.html?orderId=${order.orderId}";
	}, false); 
	t=timeDifference;
	startDaoJiShiTimer();   
})
function pushHistory() { 
	var state = { 
	title: "title", 
	url: "#"
	}; 
	window.history.pushState(state, "title", "#"); 
} 
var daoJiShiTimer;
var time=1000;//一秒时间
var t = 0;

//开启倒计时
function startDaoJiShiTimer(){
	//清除页面定时器
	window.clearTimeout(daoJiShiTimer);
	//定时器
	daoJiShiTimer = setInterval(getRTime,time);
}

function getRTime(){
	t = parseInt(t);
	var d = Math.floor(t/1000/60/60/24);
	var h = Math.floor(t/1000/60/60%24);
	var m = Math.floor(t/1000/60%60);
	var s = Math.floor(t/1000%60);
	
	//$("#d_d").html(d);
	if(s<0 || m<0 || h<0 || d<0){
		$("#d_h").html("00");
		$("#d_m").html("00");
		$("#d_s").html("00");
	}else{
		$("#d_h").html(h);
		$("#d_m").html(m);
		$("#d_s").html(s);
	}
	
	
	t = t-time;
	if(t<0){
		//关闭倒计时
		endDaoJiShiTimer();
		$("#goToPay").attr('disabled',true);
		$('#goToPay').css('border','1px solid #999');
		$('#goToPay').css('background','#999');
	}
}

//关闭倒计时
function endDaoJiShiTimer(){
	window.clearTimeout(daoJiShiTimer);
}


//取消订单方法
	function cancelOrder(orderId){
		//询问框
		  layer.open({
		    content: '您确定要取消该订单吗？'
		    ,btn: ['确定', '取消']
		    ,yes: function(index){
		      layer.close(index);
		      var param = {"orderId":orderId};
				 $.ajax({
				        url : '${pageContext.request.contextPath}/order/cancelOrder.html',
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
				            		layer.open({
				            			  title:'提示'
				            			  ,content: data.message
				            			  ,btn: '确定',
				            			  shadeClose: false,
				            			  yes: function(){
				            				  location.reload();
				            			  }
				            			});
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
		  });
	}
	
	
			//确认订单方法
			function confirmOrder(orderId){
				//询问框
				  layer.open({
				    content: '您确定要确认该订单吗？'
				    ,btn: ['确定', '取消']
				    ,yes: function(index){
				      layer.close(index);
				      var param = {"orderId":orderId};
						 $.ajax({
						        url : '${pageContext.request.contextPath}/order/confirmOrder.html',
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
						            		layer.open({
						            			  title:'提示'
						            			  ,content: data.message
						            			  ,btn: '确定',
						            			  shadeClose: false,
						            			  yes: function(){
						            				  location.reload();
						            			  }
						            			});
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
				  });
			}
</script>