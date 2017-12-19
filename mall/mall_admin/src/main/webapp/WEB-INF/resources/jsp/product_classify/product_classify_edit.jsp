<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
</head>
 <body>
    <div class="x-body">
        <form class="layui-form">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>分类名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="classifyName" name="classifyName" required="" lay-verify="classifyName" maxlength="20"
                  autocomplete="off" value="${productClassify.classifyName}" class="layui-input">
              </div>
              <input type="hidden" value="${flag}" name="flag"/>
               <input type="hidden" value="${productClassify.classifyId}" name="classifyId"/>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                 	<c:if test="${flag=='1'}">新增</c:if>
                 	<c:if test="${flag=='2'}">修改</c:if>
              </button>
          </div>
      </form>
    </div>
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
        	  classifyName: function(value){
              if(value=="" || value==null || value==undefined ){
                return '请输入分类名称';
              }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            var dataJson=data.field;
            //发异步，把数据提交给php
            $.ajax({
	  		        url : '${pageContext.request.contextPath}/productClassify/editOrAdd.do',
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
	  		            			// 获得frame索引
	  		                      var index = parent.layer.getFrameIndex(window.name);
	  		                      //关闭当前frame
	  		                      parent.layer.close(index);
	  		                      //刷新父页面
	  		                      parent.location.reload();
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
            
            
            /* layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            }); */
            return false;
          });
          
          
        });
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