<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index3.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	$(function(){
		var mid = "${param.mid}";
		$.post("getById",{mid:mid},function(map){
			var s = map.movie;
			$("[name=mname]").val(s.mname);
			$("[name=price]").val(s.price);
			$("[name=type][value='"+s.type+"']").attr("checked",true);
			$("[name=dtime]").val(s.dtime);
			var a = map.list;
			for ( var i in a) {
				$("[name=tids][value='"+a[i].tid+"']").attr("checked",true);
			}
			
		},"json")
	})
	
	
	function updates(){
		var param = $("form").serialize();
		$.post("update",param,function(flag){
			if(flag){
				alert("修改成功");
				location="list";
			}else{
				alert("修改失败");
			}
		},"json")
	}
</script>
</head>
<body>
	<form method="post" action="update">
		<input type="hidden" name="mid" value="${param.mid}">
		电影名称:<input type="text" name="mname"><br>
		电影票价:<input type="text" name="price"><br>
		电影状态:<input type="radio" name="type" value="上映">上映<input type="radio" name="type" value="未上映">未上映<br>
		电影上映时间:<input type="date" name="dtime"><br>
		电影类型:<c:forEach items="${list}" var="t">
				<input type="checkbox" name="tids" value="${t.tid}">${t.tname}
			  </c:forEach><br><br>
		<input type="button" value="修改" onclick="updates()"/>	
	</form>
</body>
</html>