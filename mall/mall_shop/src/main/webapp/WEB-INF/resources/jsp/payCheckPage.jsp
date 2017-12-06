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
		<link rel="stylesheet"  href="${pageContext.request.contextPath}/common/css/lanren.css">	
		<link rel="stylesheet" href="${pageContext.request.contextPath}/common/js/layer_mobile/need/layer.css">	
		<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/common/js/layer_mobile/layer.js" type="text/javascript"></script>
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
                              <label><input name="Fruit" type="radio"  checked="checked"/></label>
                        </dd>
                       <!--  <dd>
                              <span>微信支付</span>
                              <label><input name="Fruit" type="radio" value="" /></label>
                      </dd> -->
                  </dl>
                 </form>
            </div>
            <div class="btn"><button id="button_id">确定</button></div>
	     
	     
       <!--浮动层-->

<div class="ftc_wzsf">
  <div class="srzfmm_box">
    <div class="qsrzfmm_bt clear_wl"> <img src="${pageContext.request.contextPath}/common/images/xx_03.jpg" class="tx close fl" > <span>支付</span> </div>
    <div class="zfmmxx_shop">
      <div class="mz">卡号<span id="cardNum">123456789101</span></div>
      <div class="wxzf_price">￥${totalPrice}</div>
    </div>

    <ul class="mm_box">
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
    <!-- <button class="btn1">确定</button> -->
  </div>
  <div class="numb_box">
    <div class="xiaq_tb"> <img src="${pageContext.request.contextPath}/common/images/jftc_14.jpg" height="10"> </div>
    <ul class="nub_ggg">
      <li><a href="javascript:void(0);">1</a></li>
      <li><a href="javascript:void(0);" class="zj_x">2</a></li>
      <li><a href="javascript:void(0);">3</a></li>
      <li><a href="javascript:void(0);">4</a></li>
      <li><a href="javascript:void(0);" class="zj_x">5</a></li>
      <li><a href="javascript:void(0);">6</a></li>
      <li><a href="javascript:void(0);">7</a></li>
      <li><a href="javascript:void(0);" class="zj_x">8</a></li>
      <li><a href="javascript:void(0);">9</a></li>
      <li><span></span></li>
      <li><a href="javascript:void(0);" class="zj_x">0</a></li>
      <li><span  class="del"> <img src="${pageContext.request.contextPath}/common/images/jftc_18.jpg"/></span></li>
    </ul>
  </div>
  <div class="hbbj"></div>
</div>     
</div>
<input type="text" id="payPassWord" style="display:none" value=""/>
</body>
</html>

<style>
.layui-m-layerbtn{width: 100%;border:none;background: #fff;margin-bottom: 8px;}
.layui-m-layerbtn span[yes]{width: 90%;margin:0 auto;background: #da4231;border-radius: 5px;height:40px;line-height:40px;color: #fff;font-size:18px;font-weight: bold;}
.layui-m-layercont {padding: 25px 30px;line-height:27px;text-align:left;font-size:19px;}
</style>

<script>
var orderId = ${orderId};//订单id
//var createTime = ${createTime};//创建时间
var totalPrice = ${totalPrice};//订单总价格
var timeDifference = ${timeDifference};//毫秒时间差
$(function(){
	pushHistory(); 
	window.addEventListener("popstate", function(e) { 
		window.location.href = "${pageContext.request.contextPath}/order/goToOrderDtail.html?orderId=${orderId}";
	}, false); 
	t=timeDifference;
	startDaoJiShiTimer();
	//============支付弹窗开始============
	//出现浮动层
	  $(".btn").click(function(){
		  //弹出支付窗口，需要去校验该用户是否绑卡，如果没有绑卡，则弹出绑卡按钮
		   $.ajax({
		        url : '${pageContext.request.contextPath}/BindingCard/check.html',
		        type : "post",
		        dataType : "json",
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
		            		$("#cardNum").html(data.hospitalCardCode);
		            		$(".ftc_wzsf").show();
		            		return;
		            	}else if(data.flag=="2"){
		            		layer.open({
		            			className: '../layer_mobile/need/aaa'
		            			,content: '<p>'+data.message+'<p>'
		            			,btn: ['确定']
		            			,shade: 'background-color: rgba(0,0,0,.5)'
		            			,shadeClose:false
		            			,success: function(elem){
		            			 console.log("layer");
		            			}  
		            			,yes: function(index){
		            			  //alert('确定');跳转绑卡页面
		            			  window.location.href="${pageContext.request.contextPath}/BindingCard/bindingCardPage.html?orderId="+orderId;
		            			  layer.close(index);
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
	    });
	  //关闭浮动
	  $(".close").click(function(){
	    $(".ftc_wzsf").hide();
	    });
	    //数字显示隐藏
	    $(".xiaq_tb").click(function(){
	    $(".numb_box").slideUp(500);
	    });
	    $(".mm_box").click(function(){
	    $(".numb_box").slideDown(500);
	    });
	    //----
	    var i = 0;
	    $(".nub_ggg li a").click(function(){
	      i++;
	      if(i<6){
	        $(".mm_box li").eq(i-1).addClass("mmdd");
		       var ps = $(this).text();
		       var payPassWord = $("#payPassWord").val(); 
		       $("#payPassWord").val(payPassWord+ps);
	        
	        }else if(i>6){
	        	//i回归为0，清空输入的所有密码
	        	for(var j = i;j>=0;j--){
	        		$(".mm_box li").eq(j).removeClass("mmdd");
				}
	        	i=0;
	        	$("#payPassWord").val("");
	        }else{
	          $(".mm_box li").eq(i-1).addClass("mmdd");
	          var ps = $(this).text();
		      var payPassWord = $("#payPassWord").val(); 
		      $("#payPassWord").val(payPassWord+ps);
	          setTimeout(function(){
	        	  //alert("调用ajax校验支付密码，并进行支付操作");
	        	  //ajax扣款操作
	        	  var dataJson = {"password":$("#payPassWord").val(),"orderId":orderId}; 
	        	  $.ajax({
	  		        url : '${pageContext.request.contextPath}/BindingCard/debit.html',
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
	  		            		alert("支付成功");
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
	          },500);
	       }
	    });
	    
	    $(".nub_ggg li .del").click(function(){
	      if(i>0){
	        i--;
	        var payPassWord = $("#payPassWord").val(); 
		    $("#payPassWord").val(payPassWord.substring(0,payPassWord.Length-1));
	        $(".mm_box li").eq(i).removeClass("mmdd");
	      }else{
	    	 //i回归为0，清空输入的所有密码
	        for(var j = 0;j < 6;j++){
	        	$(".mm_box li").eq(j).removeClass("mmdd");
			}
	        $("#payPassWord").val("");
	    	  i=0;
	    	  return;
	      }
	    });
	  //============支付弹窗结束============    
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
		$("#button_id").attr('disabled',true);
		$('#button_id').css('border','1px solid #999');
		$('#button_id').css('background','#999');
	}
}

//关闭倒计时
function endDaoJiShiTimer(){
	window.clearTimeout(daoJiShiTimer);
} 


</script>