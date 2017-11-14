<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请点餐</title>
<script src="${pageContext.request.contextPath}/common/js/jquery/jquery-1.10.1.js" type="text/javascript"></script>
</head>
<body>
循环商品分类<br/>
<c:forEach items="${productClassifyList}" var="productClassify" varStatus="vs">  
        <a href="javascript:void(0)" onClick="getProduct('${productClassify.classifyId}')">${productClassify.classifyName}</a>
</c:forEach>  
</body>
</html>

<script>
	function getProduct(classifyId){
		var param = {"productClassifyId":classifyId};
		 $.ajax({
		        url : '${pageContext.request.contextPath}/merchantHomePage/getProductByProductClassifyId.do',
		        type : "post",
		        dataType : "json",
		        data : param,
		        cache : false,
		        async : false,
		        success : function(data, textStatus, jqXHR) {
		            if ('success' == textStatus) {
		            	if(data.flag=="0"){
		            		alert(data.message);
		            		return;
		            	}else{
		            		alert("成功！！！");
		            	}
		            }
		        },
		        error : function(XMLHttpRequest, textStatus, errorThrown) {
		            alert("系统异常！！！！");
		        }
		    });
	}
</script>