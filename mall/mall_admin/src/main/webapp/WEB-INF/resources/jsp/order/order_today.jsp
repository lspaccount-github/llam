<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">订单管理</a>
			<a> <cite>今日订单</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-col-md12 x-so" action="/mall_admin/order/to_today.do" method="get">
				<div class="layui-input-inline">
					<select class="layui-select" name="orderStatus" value="${order.orderStatus}">
						<option value="">订单状态</option>
						 <c:forEach items="${orderStatusMap}" var="item" varStatus="vs">
							<option value="${item.key}" <c:if test="${item.key eq order.orderStatus}">selected</c:if> >${item.value}</option>
						</c:forEach>
					</select>
				</div>
				<input type="text" name="orderId" value="${order.orderId}" placeholder="请输入订单号"autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
	        <button class="layui-btn layui-btn-danger" onclick="order_confirm('','1')"><i class="layui-icon"></i>批量确认</button>
	        <!-- <button class="layui-btn" onclick="x_admin_show('添加用户','./order-add.html')"><i class="layui-icon"></i>添加</button> -->
	        <span class="x-right" style="line-height: 40px">共有数据：${pagination.totalCount} 条</span> 
      	</xblock>
		<table class="layui-table">
			<thead>
				<tr>
					 <th>
		              <div class="layui-unselect header layui-form-checkbox" lay-skin="primary"><i class="layui-icon">&#xe605;</i></div>
		            </th>
					<th>订单编号</th>
					<th>下单时间</th>
					<th>收货人</th>
					<th>地址</th>
					<th>方位</th>
					<th>订单金额</th>
					<th>支付方式</th>
					<th>订单状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
			   <c:when test="${pagination.list!=null && pagination.list.size()>0}">  
			       <c:forEach items="${pagination.list}" var="order">
						<tr>
						<td>
							<c:if test="${order.orderStatus=='2'}">
								<div class="layui-unselect layui-form-checkbox" lay-skin="primary" data-id='${order.orderId}'><i class="layui-icon">&#xe605;</i></div>
				            </c:if>
			            </td>
						<td>${order.orderId}</td>
						<td><fmt:formatDate value="${order.createTime}" type="both"/></td>
						<td>${order.orderAddress.contacts}:${order.orderAddress.phone}</td>
						<td>${order.orderAddress.detailAddress}</td>
						<td>${order.orderAddress.position}</td>
						<td>${order.orderMoney}</td>
						<td>餐卡支付</td>
						<td>${order.orderStatusView}</td>
						<td class="td-manage">
						<a title="查看详情" 
							onclick="x_admin_show('订单详情','${pageContext.request.contextPath}/order/details.do?orderId=${order.orderId}')"
							href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
						</a>
						<c:if test="${order.orderStatus=='2'}">
							<a title="确认" onclick="order_confirm('${order.orderId}','2')" href="javascript:;">
				                <i class="layui-icon">&#xe618;</i>
				            </a>
			            </c:if>
						</td>
					</tr>
				</c:forEach>
			   </c:when>
			   <c:otherwise> 
			    	<td colspan="9" align="center">没有查询到信息</td>
			   </c:otherwise>
			</c:choose>
			</tbody>
		</table>
		<div class="page">
			<c:forEach items="${pagination.pageView }" var="page">
				${page}
			</c:forEach>
		</div>
	</div>
	<script>
		function order_confirm(orderId,flag){
			var data = tableCheck.getData();
			 layer.confirm('要确认'+orderId+'该笔订单吗？',function(index){
				//发送ajax
				var dataJson = null;
					if(flag=="1"){//批量
						if(0==data.length){
							//信息框
				        	  layer.open({
				        	    content: "请选择订单"
				        	    ,btn: '确定'
				        	  });
		            		return;
						}
						dataJson = {"orderId":data};
					}else if(flag=="2"){//单个
						dataJson = {"orderId":[orderId]};
					}
	        	  $.ajax({
	  		        url : '${pageContext.request.contextPath}/order/orderConfirm.do',
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
	  		            		layer.alert(data.message, {
	  		            		  skin: 'layui-layer-molv' //样式类名
	  		            		  ,closeBtn: 0
	  		            		}, function(){
	  		            			window.location.reload();
	  		            		});
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
	          });
		}
	</script>
	<!-- <script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script> -->
</body>
</html>