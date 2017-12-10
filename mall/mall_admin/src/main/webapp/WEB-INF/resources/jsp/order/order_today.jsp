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
				<!-- <div class="layui-input-inline">
					<select name="contrller">
						<option value="">餐点类型</option>
						<option value="0">早餐</option>
						<option value="1">午餐</option>
						<option value="2">晚餐</option>
					</select>
				</div> -->
				<!-- <div class="layui-input-inline">
					<select name="contrller">
						<option value="">付款状态</option>
						<option value="0">未支付</option>
						<option value="1">已支付</option>
						<option value="2">已退款</option>
					</select>
				</div> -->
				<!-- <div class="layui-input-inline">
					<select name="contrller">
						<option value="">支付方式</option>
						<option value="2">微信支付</option>
						<option value="3">餐卡支付</option>
					</select>
				</div> -->
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
		<span class="x-right" style="line-height: 40px">共有数据：${pagination.totalCount} 条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>下单时间</th>
					<th>收货人</th>
					<th>地址</th>
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
						<td>${order.orderId}</td>
						<td><fmt:formatDate value="${order.createTime}" type="both"/></td>
						<td>${order.orderAddress.contacts}:${order.orderAddress.phone}</td>
						<td>${order.orderAddress.detailAddress}</td>
						<td>${order.orderMoney}</td>
						<td>餐卡支付</td>
						<td>${order.orderStatusView}</td>
						<td class="td-manage"><a title="查看详情"
							onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
							href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
						</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
							href="javascript:;"> <i class="layui-icon">&#xe640;</i>
						</a> --></td>
					</tr>
				</c:forEach>
			   </c:when>
			   <c:otherwise> 
			    	<td colspan="8" align="center">没有查询到信息</td>
			   </c:otherwise>
			</c:choose>
				<!-- <tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a> <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a></td>
				</tr> -->
				
			</tbody>
		</table>
		<div class="page">
			<c:forEach items="${pagination.pageView }" var="page">
				${page}
			</c:forEach>
		</div>
	</div>
	<script>
		
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