<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>支付</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/base.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/css/index.css">	
	<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
	</head>
<body>
	<div class="container">
            <div class="pay_time">
                  <p>支付剩余时间</p>
                  <div class="pay_timer"><span id="d_h">00</span>：<span id="d_m">00</span>：<span id="d_s">00</span></div>
                  <div class="pay_money"><span>支付金额</span><span>￥${totalPrice}</span></div>
            </div>
            <div class="pay_style">
                 <form action="">
                     <dl>
                        <dt>支付方式</dt>
                        <dd>
                              <span>餐卡支付</span>
                              <label><input name="Fruit" type="radio" value="" /></label>
                        </dd>
                       <!--  <dd>
                              <span>微信支付</span>
                              <label><input name="Fruit" type="radio" value="" /></label>
                      </dd> -->
                  </dl>
                 </form>
            </div>
            <div class="btn"><button>确定</button></div>
	     
      </div>
</body>
</html>

<script>
var orderId = ${orderId};//订单id
//var createTime = ${createTime};//创建时间
var totalPrice = ${totalPrice};//订单总价格
var timeDifference = ${timeDifference};//毫秒时间差
$(function(){
	t=timeDifference;
	startDaoJiShiTimer();
})
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
	$("#d_h").html(h);
	$("#d_m").html(m);
	$("#d_s").html(s);
	
	t = t-time;
	if(t<0){
		//关闭倒计时
		endDaoJiShiTimer();
		alert("结束了");
	}
}

//关闭倒计时
function endDaoJiShiTimer(){
	window.clearTimeout(daoJiShiTimer);
} 

</script>