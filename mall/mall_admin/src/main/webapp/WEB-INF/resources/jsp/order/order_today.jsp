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
			<form class="layui-form layui-col-md12 x-so">
				<div class="layui-input-inline">
					<select name="contrller">
						<option value="">餐点类型</option>
						<option value="0">早餐</option>
						<option value="1">午餐</option>
						<option value="2">晚餐</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="contrller">
						<option value="">付款状态</option>
						<option value="0">未支付</option>
						<option value="1">已支付</option>
						<option value="2">已退款</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="contrller">
						<option value="">支付方式</option>
						<option value="2">微信支付</option>
						<option value="3">餐卡支付</option>
					</select>
				</div>
				<div class="layui-input-inline">
					<select name="contrller">
						<option value="">订单状态</option>
						<option value="0">待支付</option>
						<option value="1">已取消</option>
						<option value="2">退款中</option>
						<option value="3">已退款</option>
						<option value="4">待确认</option>
						<option value="5">备餐中</option>
						<option value="6">配送中</option>
						<option value="7">已完成</option>
					</select>
				</div>
				<input type="text" name="username" placeholder="请输入订单号"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<!-- <button class="layui-btn layui-btn-danger" onclick="delAll()">
			<i class="layui-icon"></i>批量删除
		</button>
		<button class="layui-btn"
			onclick="x_admin_show('添加用户','./order-add.html')">
			<i class="layui-icon"></i>添加
		</button> -->
		<span class="x-right" style="line-height: 40px">共有数据：88 条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>订单编号</th>
					<th>下单时间</th>
					<th>餐点类型</th>
					<th>收货人</th>
					<th>地址</th>
					<th>订单金额</th>
					<th>支付状态</th>
					<th>支付方式</th>
					<th>订单状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
				<tr>
					<td>20171117114536754550</td>
					<td>2017-08-17 18:22</td>
					<td>午餐</td>
					<td>刘主任:18925139194</td>
					<td>北楼消化科301室</td>
					<td>7854.10</td>
					<td>已支付</td>
					<td>微信支付</td>
					<td>备餐中</td>
					<td class="td-manage"><a title="查看"
						onclick="x_admin_show('编辑','../admin_ui/product-add.html')"
						href="javascript:;"> <i class="layui-icon">&#xe63c;</i>
					</a><!--  <a title="删除" onclick="member_del(this,'要删除的id')"
						href="javascript:;"> <i class="layui-icon">&#xe640;</i>
					</a> --></td>
				</tr>
			</tbody>
		</table>
		<div class="page">
			<div>
				<a class="prev" href="">&lt;&lt;</a> <a class="num" href="">1</a> <span
					class="current">2</span> <a class="num" href="">3</a> <a
					class="num" href="">489</a> <a class="next" href="">&gt;&gt;</a>
			</div>
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

		/*用户-停用*/
		function member_stop(obj, id) {
			layer.confirm('确认要停用吗？', function(index) {

				if ($(obj).attr('title') == '启用') {

					//发异步把用户状态进行更改
					$(obj).attr('title', '停用')
					$(obj).find('i').html('&#xe62f;');

					$(obj).parents("tr").find(".td-status").find('span')
							.addClass('layui-btn-disabled').html('已停用');
					layer.msg('已停用!', {
						icon : 5,
						time : 1000
					});

				} else {
					$(obj).attr('title', '启用')
					$(obj).find('i').html('&#xe601;');

					$(obj).parents("tr").find(".td-status").find('span')
							.removeClass('layui-btn-disabled').html('已启用');
					layer.msg('已启用!', {
						icon : 5,
						time : 1000
					});
				}

			});
		}

		/*用户-删除*/
		function member_del(obj, id) {
			layer.confirm('确认要删除吗？', function(index) {
				//发异步删除数据
				$(obj).parents("tr").remove();
				layer.msg('已删除!', {
					icon : 1,
					time : 1000
				});
			});
		}

		function delAll(argument) {

			var data = tableCheck.getData();

			layer.confirm('确认要删除吗？' + data, function(index) {
				//捉到所有被选中的，发异步进行删除
				layer.msg('删除成功', {
					icon : 1
				});
				$(".layui-form-checked").not('.header').parents('tr').remove();
			});
		}
	</script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>