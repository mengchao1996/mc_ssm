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
	function add(){
		var param = $("form").serialize();
		$.post("add",param,function(flag){
			if(flag){
				alert("添加成功");
				location="list";
			}else{
				alert("添加失败");
			}
		},"json")
	}
</script>
</head>
<body>
	<form>
		电影名称:<input type="text" name="mname"><br>
		电影票价:<input type="text" name="price"><br>
		电影状态:<input type="radio" name="type" value="上映">上映<input type="radio" name="type" value="未上映">未上映<br>
		电影上映时间:<input type="date" name="dtime"><br>
		电影类型:<c:forEach items="${list}" var="t">
				<input type="checkbox" name="tids" value="${t.tid}">${t.tname}
			  </c:forEach><br><br>
		<input type="button" onclick="add()" value="添加">
	</form>
</body>
</html>