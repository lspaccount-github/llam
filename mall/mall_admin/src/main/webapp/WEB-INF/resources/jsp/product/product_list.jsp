<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">菜品管理</a>
			<a> <cite>菜品列表</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<div class="layui-row">
			<form class=" layui-col-md12 x-so" action="/mall_admin/product/tolist.do" method="post">
			
					<input type="text" name="productName" placeholder="请输入商品名称"  value="${product.productName}"
					autocomplete="off" class="layui-input">
					<div class="layui-input-inline">
						<select class="layui-select" name="productStatus" value="${product.productStatus}">
							<option value="">商品状态</option>
							 <c:forEach items="${orderStatusMap}" var="item" varStatus="vs">
								<option value="${item.key}" <c:if test="${item.key eq product.productStatus}">selected</c:if> >${item.value}</option>
							</c:forEach>
						</select>
					</div>
					<div class="layui-input-inline">
						<select class="layui-select" name="classifyId" value="${product.classifyId}">
							<option value="">菜品分类</option>
							 <c:forEach items="${productClassifyList}" var="item" varStatus="vs">
								<option value="${item.classifyId}" <c:if test="${item.classifyId eq product.classifyId}">selected</c:if> >${item.classifyName}</option>
							</c:forEach>
						</select>
					</div>
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<xblock>
	        <button class="layui-btn" onclick="x_admin_show('添加菜品','${pageContext.request.contextPath}/product/editOrAddToPage.do')"><i class="layui-icon"></i>添加</button>
	        <span class="x-right" style="line-height:40px">共有数据：${pagination.totalCount} 条</span>
        </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>商品分类名称</th>
					<th>商品单位</th>
					<th>规格名称</th>
					<th>价格</th>
					<th>当前库存</th>
					<th>最大库存</th>
					<th>商品状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
			   <c:when test="${pagination.list!=null && pagination.list.size()>0}">  
			       <c:forEach items="${pagination.list}" var="product">
						<tr>
						<td>${product.productName}</td>
						<td>${product.productClassify.classifyName}</td>
						<td>${product.productUnit}</td>
						<td>${product.productSpecList.get(0).spceName}</td>
						<td>${product.productSpecList.get(0).price}</td>
						<td>${product.productSpecList.get(0).currentInventory}</td>
						<td>${product.productSpecList.get(0).maxInventory}</td>
						<td>${product.productStatusView}</td>
						
						
						<td class="td-manage">
							<c:if test="${product.productStatus=='1'}">
								<a onclick="product_stop('2','${product.productId}')" href="javascript:;"  title="下架">
					                <i class="layui-icon">&#xe601;</i>
					            </a>
							</c:if>
							<c:if test="${product.productStatus=='2'}">
								<a onclick="product_stop('1','${product.productId}')" href="javascript:;"  title="上架">
					                <i class="layui-icon">&#xe601;</i>
					            </a>
							</c:if>
							 <a title="编辑"  onclick="x_admin_show('编辑菜品','${pageContext.request.contextPath}/product/editOrAddToPage.do?productId=${product.productId}')" href="javascript:;">
				                <i class="layui-icon">&#xe642;</i>
				              </a>
				              <a title="删除" onclick="product_del('${product.productId}')" href="javascript:;">
				                <i class="layui-icon">&#xe640;</i>
				              </a>
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
		
		/*菜品分类-停用or启用*/
	      function product_stop(flag,productId){
				var str = "";
				if("1"==flag){
					str = "上架";
				}else if("2"==flag){
					str = "下架";
				}
				
	          layer.confirm('确认要'+str+'吗？',function(index){
	            //发送ajax
	        	  var dataJson = {"flag":flag,"productId":productId}; 
	        	  $.ajax({
	  		        url : '${pageContext.request.contextPath}/product/stopOrEnd.do',
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
		
	      /*用户-删除*/
	      function product_del(productId){
	          layer.confirm('确认要删除吗？',function(index){
	        	//发送ajax
	        	  var dataJson = {"productId":productId}; 
	        	  $.ajax({
	  		        url : '${pageContext.request.contextPath}/product/deleteProduct.do',
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