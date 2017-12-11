<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">支付信息</a>
			<a> <cite>支付流水</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class="layui-col-md12 x-so" action="/mall_admin/payment_record/tolist.do" method="get">
				<input class="layui-input" placeholder="开始日" name="startTime" id="start" value="${startTime}">
				<input class="layui-input" placeholder="截止日" name="endTime" id="end" value="${endTime}">
				<!-- <div class="layui-input-inline">
					<select name="contrller">
						<option value="">支付方式</option>
						<option value="0">微信支付</option>
						<option value="1">餐卡支付</option>
					</select>
				</div> -->
				<!-- <div class="layui-input-inline">
					<select name="contrller">
						<option value="">支付状态</option>
						<option value="0">支付处理中</option>
						<option value="1">支付成功</option>
						<option value="2">支付失败</option>
					</select>
				</div> -->
				<input type="text" name="hospitalCardCode" placeholder="请输入餐卡编号" value="${paymentRecord.hospitalCardCode}"
					autocomplete="off" class="layui-input">
				<input type="text" name="orderId" placeholder="请输入订单编号" value="${paymentRecord.orderId}"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<span class="x-right" style="line-height: 40px">共有数据：${pagination.totalCount}条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>支付流水编号</th>
					<th>餐卡编号</th>
					<th>订单编号</th>
					<th>支付时间</th>
					<th>付款会员</th>
					<th>支付金额</th>
					<!-- <th>支付方式</th> -->
					<!-- <th>支付状态</th> -->
					<!-- <th>操作</th> -->
				</tr>
			</thead>
			<tbody>
				<c:choose>
			   <c:when test="${pagination.list!=null && pagination.list.size()>0}">  
			       <c:forEach items="${pagination.list}" var="paymentRecord">
						<tr>
						<td>${paymentRecord.payCode}</td>
						<td>${paymentRecord.hospitalCardCode}</td>
						<td>${paymentRecord.orderId}</td>
						<td><fmt:formatDate value="${paymentRecord.payTime}" type="both"/></td>
						<td>${paymentRecord.hospitalCard.name}</td>
						<td>${paymentRecord.payMoney}</td>
					</tr>
				</c:forEach>
			   </c:when>
			   <c:otherwise> 
			    	<td colspan="6" align="center">没有查询到信息</td>
			   </c:otherwise>
			</c:choose>
				<!-- <tr>
					<td>20171117114536754550</td>
					<td>20171117114536754551</td>
					<td>20171117114536754552</td>
					<td>2017-08-17 18:22</td>
					<td>XiaoMei</td>
					<td>餐卡支付</td>
					<td>支付成功</td>
					<td class="td-manage">
						<a title="查看" onclick="x_admin_show('编辑','../admin_ui/product-add.html')" href="javascript:;"> 
							<i class="layui-icon">&#xe63c;</i>
						</a>
					</td>
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
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#start' //指定元素
			});

			//执行一个laydate实例
			laydate.render({
				elem : '#end' //指定元素
			});
		});
	</script>
	<script>
		/* var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})(); */
	</script>
</body>
</html>