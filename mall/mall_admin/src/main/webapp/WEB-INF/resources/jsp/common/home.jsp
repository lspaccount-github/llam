<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="meta.jsp" %>
<title>Insert title here</title>
</head>
<body>
<!-- 顶部开始 -->
<%@ include file="header.jsp" %>
<!-- 顶部结束 -->
<!-- 左侧菜单开始 -->
<jsp:include   page="menu.jsp" flush="true"/>
<!-- 左侧菜单结束 -->
<!-- 右侧主体开始 -->
    <div class="page-content">
        <div class="layui-tab tab" lay-filter="xbs_tab" lay-allowclose="false">
          <ul class="layui-tab-title">
            <li>我的桌面</li>
          </ul>
          <div class="layui-tab-content">
            <div class="layui-tab-item layui-show">
                <iframe src='./welcome.html' frameborder="0" scrolling="yes" class="x-iframe"></iframe>
            </div>
          </div>
        </div>
    </div>
    <div class="page-content-bg"></div>
    <!-- 右侧主体结束 -->
<!-- 底部开始 -->
<%@ include file="footer.jsp" %>
<!-- 底部结束 -->
</body>
</html>