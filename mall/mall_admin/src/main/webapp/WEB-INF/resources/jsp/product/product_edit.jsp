<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<style>
	.box1{ border-bottom: 1px solid #eaeaea;padding: 10px 0;}
	.title-p{font-size: 20px;}
	.demo--radio{display:none;}
.demo--radioInput{background-color:#fff;border:1px solid #3bb4f2;border-radius:100%;display:inline-block;height:16px;margin-right:10px;margin-top:-1px;vertical-align:middle;width:16px;line-height:1;}
.demo--radio:checked + .demo--radioInput:after{background-color:#3bb4f2;border-radius:100%;content:"";display:inline-block;height:8px;margin:4px;width:8px;}
.demo--checkbox.demo--radioInput,.demo--radio:checked + .demo--checkbox.demo--radioInput:after{border-radius:0;}
.specail{margin-left:100px; } 
.demo--label{margin-right: 40px;}
.btn1{margin:20px 100px;}
.btn1 a{height:30px;line-height:30px;width:60px;display: inline-block;border: 1px solid #3bb4f2;text-align: center;margin-right: 20px;border-radius: 5px;}
.btn1 a:last-child{background:#3bb4f2;color: #fff;}
.abc{height:21px;width:64px;}
</style>
</head>
 <body>
    <div class="x-body">
        <form class="layui-form">
        <p class="title-p">基本信息</p>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>菜品分类
              </label>
              <div class="layui-input-inline">
                  <select id="shipping" name="shipping" class="valid">
                    <option value="">菜品分类</option>
					<c:forEach items="${productClassifyList}" var="item" varStatus="vs">
						<option value="${item.classifyId}" <c:if test="${item.classifyId eq product.classifyId}">selected</c:if> >${item.classifyName}</option>
					</c:forEach>
                  </select>
              </div>
          </div>
          <div class="layui-form-item"> 
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="productName" name="productName" value="${product.productName}" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                 	<span class="x-red">*</span> 商品描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入商品描述" id="productRemark" name="productRemark" class="layui-textarea"></textarea>
              </div>
          </div>
          <div class="layui-form-item"> 
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品图片
              </label>
              <div class="">
               <img src="${pageContext.request.contextPath}/common/images/moRenImage.jpg" id="allUrl" alt="" height="100" width="100" class="input-img" style="border: 1px solid #eaeaea; ">
                <input type="file" style="margin-left: 30px;" id="pic" name="pic"  lay-verify="required"
                  autocomplete="off" onchange="uploadPic();">
                 <input type="hidden" id="pictureUrl" name="pictureUrl" value=""/> 
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品单位
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="productUnit" name="productUnit" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
           <div class="layui-form-item box1">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>最小购买数量
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="minBuyNum" name="minBuyNum" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <p class="title-p">商品规格</p>
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>规格名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="spceName" name="spceName" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>价格
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="price" name="price" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>餐盒费
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="lunchFee" name="lunchFee" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>当前库存
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="currentInventory" name="currentInventory" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>最大库存
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="maxInventory" name="maxInventory" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
         
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                	  增加
              </button>
          </div>
      </form>
    </div>
  <%--  <form id='jform' action="${pageContext.request.contextPath}/upload/uploadPic.do"	 method="post"  target='frameFile' enctype="multipart/form-data">
	</form> --%>
	<form id= "uploadForm">  
      <p >指定文件名： <input type="text" name="filename" value= ""/></p >  
      <p >上传文件： <input type="file" name="pic"/></ p>  
      <input type="button" value="上传" onclick="doUpload()" />  
</form>  
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
            return false;
          });
        });
        
        //上传图片
         /* function uploadPic() {
        	 $('#jform').append($(this).parent().children());
        	$("#jform").submit();
   		 }   */
   		function doUpload() {  
   		     var formData = new FormData($( "#uploadForm" )[0]);  
   		     $.ajax({  
   		          url: '${pageContext.request.contextPath}/upload/uploadPic.do' ,  
   		          type: 'POST',  
   		          data: formData,  
   		          async: false,  
   		          cache: false,  
   		          contentType: false,  
   		          processData: false,  
   		          success: function (data) {  
   		        	 // 图片显示地址  
                      $("#allUrl").attr("src", data.url);
                      $("#pictureUrl").val(data.path); 
   		          },  
   		          error: function (returndata) {  
   		              alert(returndata);  
   		          }  
   		     });  
   		}  
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