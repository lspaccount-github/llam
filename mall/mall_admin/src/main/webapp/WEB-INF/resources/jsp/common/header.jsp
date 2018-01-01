<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<div class="container">
    <div class="logo"><a href="${pageContext.request.contextPath}/home.do">北京航天总院订餐管理</a></div>&emsp;
    <div class="left_open">
        <i title="展开左侧栏" class="iconfont">&#xe699;</i>
    </div>
    <!-- <ul class="layui-nav left fast-add" lay-filter="">
      <li class="layui-nav-item">
        <a href="javascript:;">+新增</a>
        <dl class="layui-nav-child"> 二级菜单
          <dd><a onclick="x_admin_show('资讯','http://www.baidu.com')"><i class="iconfont">&#xe6a2;</i>资讯</a></dd>
          <dd><a onclick="x_admin_show('图片','http://www.baidu.com')"><i class="iconfont">&#xe6a8;</i>图片</a></dd>
           <dd><a onclick="x_admin_show('用户','http://www.baidu.com')"><i class="iconfont">&#xe6b8;</i>用户</a></dd>
        </dl>
      </li>
    </ul> -->
    <ul class="layui-nav right" lay-filter="">
      <li class="layui-nav-item">
        <a href="javascript:;">admin</a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
         <!--  <dd><a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a></dd> -->
          <!-- <dd><a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a></dd> -->
          <dd><a href="${pageContext.request.contextPath}/logout.do">退出</a></dd>
        </dl>
      </li>
     <!--  <li class="layui-nav-item">
        <a href="javascript:;">皮肤</a>
        <dl class="layui-nav-child"> 二级菜单
          <dd><a onclick="footer_color();">默认(黑)</a></dd>
          <dd><a onclick="footer_color();">蓝色</a></dd>
          <dd><a onclick="footer_color();">绿色</a></dd>
          <dd><a onclick="footer_color();">红色</a></dd>
        </dl>
      </li> -->
    </ul>
</div>
<script type="text/javascript">
</script>