<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
</head>
<body>
	<div class="x-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">基本设置</a>
			<a> <cite>参数列表</cite></a>
		</span> <a class="layui-btn layui-btn-small"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="x-body">
		<%-- <div class="layui-row">
			<form class=" layui-col-md12 x-so" action="/mall_admin/admin/adminList.do" method="post">
				<input class="layui-input" placeholder="开始日" name="startTime" id="start" value="${startTime}">
				<input class="layui-input" placeholder="截止日" name="endTime" id="end" value="${endTime}">
				<input type="text" name="loginName" placeholder="请输入登陆名"  value="${loginName}"
					autocomplete="off" class="layui-input">
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div> --%>
		<span class="x-right" style="line-height: 40px">共有数据：${pagination.totalCount} 条</span> </xblock>
		<table class="layui-table">
			<thead>
				<tr>
					<th>参数ID</th>
		            <th>参数名称</th>
		            <th>参数值</th>
		            <th>参数单位</th>
		            <th>创建时间</th>
		            <th>修改人id</th>
		            <th>修改时间</th>
		            <th>参数状态</th>
		            <th>操作</th>
				</tr>
			</thead>
			<tbody>
			<c:choose>
			   <c:when test="${pagination.list!=null && pagination.list.size()>0}">  
			       <c:forEach items="${pagination.list}" var="SysParameter">
						<tr>
						<td>${SysParameter.id}</td>
						<td>${SysParameter.parameterName}</td>
						<td>${SysParameter.parameterValue}</td>
						<td>${SysParameter.parameterCompany}</td>
						<td><fmt:formatDate value="${SysParameter.carTime}" type="both"/></td>
						<td>${SysParameter.updUser}</td>
						<td><fmt:formatDate value="${SysParameter.updTime}" type="both"/></td>
						<td>${SysParameter.parameterStatusView}</td>
						<td class="td-manage">
							<c:if test="${SysParameter.parameterStatus=='2'}">
								<a onclick="parameterStatus_stop('1','${SysParameter.id}')" href="javascript:;"  title="启用">
					                <i class="layui-icon">&#xe601;</i>
					            </a>
							</c:if>
							<c:if test="${SysParameter.parameterStatus=='1'}">
								<a onclick="parameterStatus_stop('2','${SysParameter.id}')" href="javascript:;"  title="停用">
					                <i class="layui-icon">&#xe601;</i>
					            </a>
							</c:if>
							 <%-- <a onclick="x_admin_show('修改密码','${pageContext.request.contextPath}/admin/toUpdatePasswordPage.do?merchantUserId=${merchantUser.merchantUserId}',600,400)" title="修改密码" href="javascript:;">
				                <i class="layui-icon">&#xe631;</i>
				             </a> --%>
			             <a title="修改"  onclick="x_admin_show('修改参数','${pageContext.request.contextPath}/parameter/toUpdateparameterValuePage.do?id=${SysParameter.id}',460,320)" href="javascript:;">
			                <i class="layui-icon">&#xe642;</i>
			              </a>
			             <%--  <a title="删除" onclick="merchantUser_del(this,'${merchantUser.merchantUserId}')" href="javascript:;">
			                <i class="layui-icon">&#xe640;</i>
			              </a> --%>
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
			<c:forEach items="${pagination.pageView}" var="page">
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
		/*用户-停用or启用*/
	      function parameterStatus_stop(flag,id){
				var str = "";
				if("1"==flag){
					str = "启用";
				}else if("2"==flag){
					str = "停用";
				}
				
	          layer.confirm('确认要'+str+'吗？',function(index){
	            //发送ajax
	        	  var dataJson = {"flag":flag,"id":id}; 
	        	  $.ajax({
	  		        url : '${pageContext.request.contextPath}/parameter/stopOrEnd.do',
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
	  		            	//墨绿深蓝风
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