<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <div class="left-nav">
	<div id="side-nav">
	  <ul id="nav">
	  	  <li>
	          <a href="javascript:;">
	              <i class="iconfont">&#xe726;</i>
	              <cite>管理员管理</cite>
	              <i class="iconfont nav_right">&#xe697;</i>
	          </a>
	          <ul class="sub-menu">
	              <li>
	                  <a _href="${pageContext.request.contextPath}/admin/adminList.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>管理员列表</cite>
	                  </a>
	              </li >
	              <!-- <li>
	                  <a _href="./admin/admin-role.html">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>角色管理</cite>
	                  </a>
	              </li >
	              <li>
	                  <a _href="./admin/admin-cate.html">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>权限分类</cite>
	                  </a>
	              </li >
	              <li>
	                  <a _href="./admin/admin-rule.html">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>权限管理</cite>
	                  </a>
	              </li > -->
	          </ul>
	      </li>
	      <li>
	          <a href="javascript:;">
	              <i class="iconfont">&#xe723;</i>
	              <cite>菜品管理</cite>
	              <i class="iconfont nav_right">&#xe697;</i>
	          </a>
	          <ul class="sub-menu">
	              <li>
	                  <a _href="${pageContext.request.contextPath}/productClassify/tolist.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>菜品分类</cite>
	                  </a>
	              </li >
	              <li>
	                  <a _href="${pageContext.request.contextPath}/product/tolist.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>菜品列表</cite>
	                  </a>
	              </li >
	          </ul>
	      </li>
	      <li>
	          <a href="javascript:;">
	              <i class="iconfont">&#xe723;</i>
	              <cite>订单管理</cite>
	              <i class="iconfont nav_right">&#xe697;</i>
	          </a>
	          <ul class="sub-menu">
	              <li>
	                  <a _href="${pageContext.request.contextPath}/order/to_today.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>今日订单</cite>
	                  </a>
	              </li >
	              <li>
	                  <a _href="${pageContext.request.contextPath}/order/to_history.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>历史订单</cite>
	                  </a>
	              </li >
	          </ul>
	      </li>
	      <li>
	          <a href="javascript:;">
	              <i class="iconfont">&#xe723;</i>
	              <cite>支付信息</cite>
	              <i class="iconfont nav_right">&#xe697;</i>
	          </a>
	          <ul class="sub-menu">
	              <li>
	                  <a _href="${pageContext.request.contextPath}/payment_record/tolist.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>支付流水</cite>
	                  </a>
	              </li >
	          </ul>
	      </li>
	      <li>
	          <a href="javascript:;">
	              <i class="iconfont">&#xe723;</i>
	              <cite>基本设置</cite>
	              <i class="iconfont nav_right">&#xe697;</i>
	          </a>
	          <ul class="sub-menu">
	              <li>
	                  <a _href="${pageContext.request.contextPath}/parameter/tolist.do">
	                      <i class="iconfont">&#xe6a7;</i>
	                      <cite>参数设置</cite>
	                  </a>
	              </li >
	          </ul>
	      </li>
	  </ul>
	</div>
</div>
<!-- <div class="x-slide_left"></div> -->
