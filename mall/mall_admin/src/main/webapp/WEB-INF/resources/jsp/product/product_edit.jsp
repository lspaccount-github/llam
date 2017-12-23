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
           <c:if test="${flag=='3'}">
         		<div class="layui-form-item">
	              <label for="username" class="layui-form-label">
	                  <span class="x-red">*</span>商品状态
	              </label>
	              <div class="layui-input-inline">
	                  <input type="text" value="${product.productStatusView}" required="" lay-verify="minBuyNumRequired"
	                  autocomplete="off" class="layui-input" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
	              </div>
	          </div>
          </c:if>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>菜品分类
              </label>
              <div class="layui-input-inline">
                  <select id="classifyId" name="classifyId" lay-verify="classifyIdRequired"  
                  class="valid" required="" autocomplete="off" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
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
                  <input type="text" id="productName" name="productName" value="${product.productName}" required="" lay-verify="productNameRequired"
                  autocomplete="off" class="layui-input" maxlength="10" <c:if test="${flag=='3'}">disabled="disabled"</c:if> >
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                 	<span class="x-red">*</span> 商品描述
              </label>
              <div class="layui-input-block">
              	<c:if test="${product.productRemark!=''}">
              		<textarea  autocomplete="off" maxlength="100"
                  id="productRemark" name="productRemark" class="layui-textarea" lay-verify="productRemarkRequired" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>${product.productRemark}</textarea>
              	</c:if>
                <c:if test="${product.productRemark==''}">
              		<textarea placeholder="请输入商品描述" autocomplete="off" maxlength="100"
                  id="productRemark" name="productRemark" class="layui-textarea" lay-verify="productRemarkRequired" <c:if test="${flag=='3'}">disabled="disabled"</c:if>></textarea>
              	</c:if>
              </div>
          </div>
          <div class="layui-form-item"> 
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品图片
              </label>
              <div class="">
              	<c:if test="${product.pictureUrl !=''}">
              		<img src="${product.pictureUrl}" id="allUrl" alt="" height="100" width="100" class="input-img" style="border: 1px solid #eaeaea; ">
              	</c:if>
              	<c:if test="${product.pictureUrl ==''}">
              		<img src="${pageContext.request.contextPath}/common/images/moRenImage.jpg" id="allUrl" alt="" height="100" width="100" class="input-img" style="border: 1px solid #eaeaea; ">
              	</c:if>
                
                <input type="file" style="margin-left: 30px;" id="pic" name="pic"  lay-verify="pictureUrlRequired"
                  autocomplete="off" onchange="doUpload();" <c:if test="${flag=='3'}">disabled="disabled"</c:if> >
                 <input type="hidden" id="pictureUrl" name="pictureUrl" value="${product.pictureUrl}"/> 
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品单位
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="productUnit" name="productUnit" value="${product.productUnit}" required="" lay-verify="productUnitRequired"
                  autocomplete="off" class="layui-input" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
           <div class="layui-form-item box1">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>最小购买数量
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="minBuyNum" name="minBuyNum" value="${product.minBuyNum}" required="" lay-verify="minBuyNumRequired"
                  autocomplete="off" class="layui-input" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
          <p class="title-p">商品规格</p>
           <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>规格名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="spceName" name="productSpec.spceName" value="${product.productSpecList.get(0).spceName}" required="" lay-verify="spceNameRequired"
                  autocomplete="off" class="layui-input" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>价格
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="price" name="productSpec.price" value="${product.productSpecList.get(0).price}" required="" lay-verify="priceRequired"
                  autocomplete="off" class="layui-input" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>餐盒费
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="lunchFee" name="productSpec.lunchFee" required="" lay-verify="lunchFeeRequired"
                  autocomplete="off" class="layui-input" value="${product.productSpecList.get(0).lunchFee}" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>当前库存
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="currentInventory" name="productSpec.currentInventory" required="" lay-verify="currentInventoryRequired"
                  autocomplete="off" class="layui-input" value="${product.productSpecList.get(0).currentInventory}" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>最大库存
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="maxInventory" name="productSpec.maxInventory" required="" lay-verify="maxInventoryRequired"
                  autocomplete="off" class="layui-input"  value="${product.productSpecList.get(0).maxInventory}" <c:if test="${flag=='3'}">disabled="disabled"</c:if>>
              </div>
          </div>
         <c:if test="${flag!='3'}">
         		<!-- 影藏域 -->
          <input type="hidden" value="${flag}" name="flag"/>
          <input type="hidden" value="${product.productId}" name="productId"/>
          <input type="hidden" value="${product.productSpecList.get(0).spceId}" name="productSpec.spceId"/>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                	<c:if test="${flag=='1'}">新增</c:if>
                 	<c:if test="${flag=='2'}">修改</c:if>
              </button>
          </div>
         </c:if>
      </form>
    </div>
  <%--  <form id='jform' action="${pageContext.request.contextPath}/upload/uploadPic.do"	 method="post"  target='frameFile' enctype="multipart/form-data">
	</form> --%>
	<form id= "uploadForm">  
       <!-- <input type="file" name="pic" onchange="doUpload();"/> -->
</form>  
    <script>
        layui.use(['form','layer'], function(){
            $ = layui.jquery;
          var form = layui.form
          ,layer = layui.layer;
        
          //自定义验证规则
          form.verify({
        	  classifyIdRequired: function(value){
              if(value=="" || value==null || value==undefined ){
                return '请选择商品分类';
              }
            },
            productNameRequired: function(value){
                if(value=="" || value==null || value==undefined ){
                  return '请输入商品名称';
                }
              },
              productRemarkRequired: function(value){
                  if(value=="" || value==null || value==undefined ){
                    return '请输入商品描述';
                  }
                },
                pictureUrlRequired: function(value){
                	var pictureUrl=$("#pictureUrl").val();
                    if(pictureUrl=="" || pictureUrl==null || pictureUrl==undefined ){
                      return '请上传商品图片';
                    }
                  },
                  productUnitRequired: function(value){
                	  if(value=="" || value==null || value==undefined ){
                        return '请输入商品单位';
                      }
                    },
                    minBuyNumRequired: function(value){
                  	  if(value=="" || value==null || value==undefined ){
                          return '请输入商品最小购买数量';
                        }
                      },
                      spceNameRequired: function(value){
                      	  if(value=="" || value==null || value==undefined ){
                              return '请输入商品规格名称';
                            }
                          },
                     priceRequired: function(value){
                           if(value=="" || value==null || value==undefined ){
                                  return '请输入商品价格';
                             }
                        },
                        lunchFeeRequired: function(value){
                              if(value=="" || value==null || value==undefined ){
                                     return '请输入商品餐盒费';
                                }
                           },
                           currentInventoryRequired: function(value){
                               if(value=="" || value==null || value==undefined ){
                                      return '请输入当前库存';
                                 }
                            },
                           currentInventoryRequired: function(value){
                               if(value=="" || value==null || value==undefined ){
                                      return '请输入当前库存';
                                 }
                            },
                            maxInventoryRequired: function(value){
                                if(value=="" || value==null || value==undefined ){
                                       return '请输入最大库存';
                                  }
                             }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            var dataJson=data.field;
            //发异步，把数据提交给php
            $.ajax({
	  		        url : '${pageContext.request.contextPath}/product/editOrAdd.do',
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
   		function doUpload() {  
	   		var fileObj = document.getElementById("pic").files[0]; // js 获取文件对象
	        if (typeof (fileObj) == "undefined" || fileObj.size <= 0) {
	            alert("请选择图片");
	            return;
	        }
	        var formData = new FormData();
	        formData.append("pic", fileObj); //加入文件对象
   		  
   		     $.ajax({  
   		          url: '${pageContext.request.contextPath}/upload/uploadPic.do' ,  
   		          type: 'POST',  
   		          data: formData,  
   		          async: false,  
   		          cache: false,  
   		          contentType: false,  
   		          processData: false,  
   		          success: function (data) {
   		        		//信息框
			        	  layer.open({
			        	    content: "上传成功！"
			        	    ,btn: '确定'
			        	  });
   		        	 // 图片显示地址  
                      $("#allUrl").attr("src", data.url);
                      $("#pictureUrl").val(data.path); 
   		          },  
   		          error: function (returndata) {  
   		        	//信息框
		        	  layer.open({
		        	    content: "上传失败！"
		        	    ,btn: '确定'
		        	  }); 
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