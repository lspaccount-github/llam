<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<style>
.layui-form-label {
	font-size: 16px;
	margin-top: 26px;
}

.layui-table td:nth-child(1) {
	width: 10%;
}
</style>
<!-- .layui-table{background: #eaeaea;} -->
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="x-body">
		<form class="layui-form">
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 订单详情 </label><br>
				<div class="layui-input-block">
					<table class="layui-table">
						<tbody>
							<tr>
								<td>订单id</td>
								<td>${order.orderId}</td>
							</tr>
							<tr>
								<td>订单状态</td>
								<td>${order.orderStatusView}</td>
							</tr>
							<tr>
								<td>订单金额</td>
								<td>${order.orderMoney}元</td>
							</tr>
							<tr>
								<td>支付方式</td>
								<td>餐卡支付</td>
							</tr>
							<tr>
								<td>完成时间</td>
								<td><fmt:formatDate value="${order.completeTime}" type="both"/></td>
							</tr>
							<tr>
								<td>创建时间</td>
								<td><fmt:formatDate value="${order.createTime}" type="both"/></td>
							</tr>
							<!-- <tr>
								<td>商户id</td>
								<td>238989807</td>
							</tr> -->
							<tr>
								<td>订单备注</td>
								<td>${order.remark}</td>
							</tr>

						</tbody>
					</table>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 收货人信息 </label><br>
				<div class="layui-input-block">
					<table class="layui-table">
						<tbody>
							<tr>
								<td>联系人</td>
								<td>${order.orderAddress.contacts}</td>
							</tr>
							<tr>
								<td>电话</td>
								<td>${order.orderAddress.phone}</td>
							</tr>
							<tr>
								<td>详细地址</td>
								<td>${order.orderAddress.contacts}</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="layui-form-item layui-form-text">
				<label for="desc" class="layui-form-label"> 商品信息 </label>
				<div class="layui-input-block">
					<table class="layui-table">
						<tbody>
							<tr>
								<td>商品ID</td>
								<td>图片</td>
								<td>商品名称</td>
								<td>商品分类名称</td>
								<td>商品规格名称</td>
								<td>单位</td>
								<td>价格</td>
								<td>数量</td>
							</tr>
							<c:forEach items="${order.orderProducts}" var="orderProduct">
								<tr>
								<td>${orderProduct.orderProductId}</td>
								<td><img src="${IMG_WEB}${orderProduct.pictureUrl}" id="allUrl" alt=""
									height="100" width="100" class="input-img"
									style="border: 1px solid #eaeaea;"></td>
								<td>${orderProduct.productName}</td>
								<td>${orderProduct.classifyName}</td>
								<td>${orderProduct.spceName}</td>
								<td>${orderProduct.productUnit}</td>
								<td>${orderProduct.price}</td>
								<td>${orderProduct.buyProductNum}</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</form>
	</div>
	<script>
       
    </script>
	<script>
   /*  var _hmt = _hmt || []; (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?b393d153aeb26b46e9431fabaf0f6190";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })(); */
    </script>
</body>
</html>