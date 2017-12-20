<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common/meta.jsp"%>
<style>
	.box1{ border-bottom: 1px solid #eaeaea;margin: 0 50px;padding: 10px 0;}
	.box1 p{font-size: 20px;}
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
                 	 商品描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入商品描述" id="productRemark" name="productRemark" class="layui-textarea"></textarea>
              </div>
          </div>
          <div class="layui-form-item"> 
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>商品图片
              </label>
              <div class="layui-input-inline">
               <img class="layui-input" src="" alt="" height="100" width="100" class="input-img">
              </div>
               <input type="file" id="productName" name="productName" value="${product.productName}" required="" lay-verify="required"
                  autocomplete="off" >
          </div>
          
          
          
        <!-- ************************************************************************** -->  
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>收货人
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="x-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="phone" name="phone" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>收货地址
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>配送物流
              </label>
              <div class="layui-input-inline">
                  <select id="shipping" name="shipping" class="valid">
                    <option value="shentong">申通物流</option>
                    <option value="shunfeng">顺丰物流</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="x-red">*</span>支付方式
              </label>
              <div class="layui-input-inline">
                  <select name="contrller">
                    <option>支付方式</option>
                    <option>支付宝</option>
                    <option>微信</option>
                    <option>货到付款</option>
                  </select>
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="x-red">*</span>发票抬头
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="L_email" name="email" required="" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="x-red">*</span>
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                  商品增加
              </label>
              <div class="layui-input-block">
                  <table class="layui-table">
                    <tbody>
                      <tr>
                        <td>haier海尔 BC-93TMPF 93升单门冰箱</div></td>
                        <td>0.01</div></td>
                        <td>984</div></td>
                        <td>1</td>
                        <td>删除</td>
                      </tr>
                      <tr>
                        <td>haier海尔 BC-93TMPF 93升单门冰箱</div></td>
                        <td>0.01</div></td>
                        <td>984</div></td>
                        <td>1</td>
                        <td>删除</td>
                      </tr>
                    </tbody>
                  </table>
              </div>
          </div>
          <div class="layui-form-item layui-form-text">
              <label for="desc" class="layui-form-label">
                 	 描述
              </label>
              <div class="layui-input-block">
                  <textarea placeholder="请输入内容" id="desc" name="desc" class="layui-textarea"></textarea>
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