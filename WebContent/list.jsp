<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index3.css">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function choose(own){
		$("[name=mid]").attr("checked",own.checked);
	}
	function del(mid){
		$.post("delete",{mid:mid},function(flag){
			if(flag){
				alert("删除成功");
				location="list";
			}else{
				alert("删除失败");
			}
		},"json")
	}
	function del(mid){
		$.post("delete",{mid:mid},function(flag){
			if(flag){
				alert("删除成功");
				location="list";
			}else{
				alert("删除失败");
			}
		},"json")
	}
	function dels(){
		var mid = "";
		$("[name=miad]:chekced").attr(function(){
			mid+=","+this.value();
		})
		sid=sid.substring(1);
		$.post("delete",{mid:mid},function(flag){
			if(flag){
				alert("删除成功");
				location="list";
			}else{
				alert("删除失败");
			}
		},"json")
	}
	
	function add(){
		location.href="toAdd";
	}
	
	function upd(mid){
		location.href="upd?mid="+mid;
	}
	
</script>
</head>
<body>
	<form action="list" method="post">
		电影名称:<input type="text" name="mname" value="${mname}"><br>
		电影类型:<c:forEach items="${type}" var="t">
				<input type="checkbox" name="types" <c:if test="${fn:containsIgnoreCase(types, t.tid)}" >checked</c:if> value="${t.tid}">${t.tname}
			  </c:forEach><br>
		<input type="submit" value="查询"><br>
		<input type="button" value="添加" onclick="add()">
		<input type="button" value="批量删除" onclick="dels()">
	</form>
	<table>
		<tr>
			<td>
				<input type="checkbox" onclick="choose(this)">
			</td>
			<td>电影编号</td>
			<td>电影名称</td>
			<td>电影票价</td>
			<td>电影状态</td>
			<td>电影上映时间</td>
			<td>电影类型</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${list}" var="s">
			<tr>
				<td>
					<input type="checkbox" name="mid" value="${s.mid}">
				</td>
				<td>${s.mid}</td>
				<td>${s.mname}</td>
				<td>${s.price}</td>
				<td>${s.type}</td>
				<td>${s.dtime}</td>
				<td>${s.tnames}</td>
				<td>
					<input type="button" value="删除" onclick="del(${s.mid})">
					<input type="button" value="修改" onclick="upd(${s.mid})">
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="20">
				<a href="list?PageNum=1">首页</a>
				<a href="list?PageNum=${PageNum==1?1:PageNum-1}">上一页</a>
				<a href="list?PageNum=${PageNum!=totalPage?PageNum+1:PageNum}">下一页</a>
				<a href="list?PageNum=${totalPage}">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>