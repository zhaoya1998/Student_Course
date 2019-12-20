<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/index_work.css" />
<link href="<%=request.getContextPath()%>/css/index_work.css"
	rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
    function qx() {
		$("[name=ck]").attr("checked",true);
	}
    function qbx() {
		$("[name=ck]").attr("checked",false);
	}
    function fx() {
		$("[name=ck]").each(function(){
			$(this).attr("checked",!$(this).attr("checked"))
		})
	}
    function del(sid) {
		if(confirm("确定要删除sid为"+sid+"吗")){
			$.post(
			   "del",
			   {sid:sid},
			   function(obj) {
				if(obj){
					alert("删除成功");
					location.reload();
				}else{
					alert("删除失败");
					return;
				}
			},
			"json"
			)
		}
	}
    function dels() {
		var sid="";
		$("[name=ck]:checked").each(function(){
			sid+=","+$(this).val();
		})
		sid=sid.substring(1);
		del(sid)
	}
    function toAdd() {
		location.href="toAdd"
	}
    function update(sid) {
		location.href="toUpdate?sid="+sid
	}
</script>
</head>
<body>
<form action="list" method="post"> 
   姓名:<input type="text" name="sname" value="${vo.sname }">
   时间:<input type="text" name="start" value="${vo.start }" onclick="WdatePicker()">--
   <input type="text" name="end" value="${vo.end }" onclick="WdatePicker()">
   <input type="submit" value="查询">
   <input type="button" value="批量删除" onclick="dels()">
   <input type="button" value="增加" onclick="toAdd()">
</form>
	<table>
		<tr>
		<td>
		   <input type="button" value="全选" onclick="qx()">
		   <input type="button" value="全不选" onclick="qbx()">
		   <input type="button" value="反选" onclick="fx()">
		</td>
			<td>编号</td>
			<td>姓名</td>
			<td>密码</td>
			<td>生日</td>
			<td>性别</td>
			<td>课程</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${info.list }" var="stu">
			<tr>
			<td>
			  <input type="checkbox" value="${stu.sid }" name="ck">
			</td>
				<td>${stu.sid }</td>
				<td>${stu.sname }</td>
				<td>${stu.pwd }</td>
				<td>${stu.birthday }</td>
				<td>${stu.sex }</td>
				<td>
				   <c:forEach items="${stu.courses}" var="c">
				     ${c.cname }
				   </c:forEach>
				</td>
				<td>${stu.age }</td>
				<td><input type="button" value="删除" onclick="del(${stu.sid})">
					<input type="button" value="修改" onclick="update(${stu.sid})"></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">当前是${info.pageNum }/${info.pages }页--共${info.total }条数据
				<a href="list?pageNum=1">首页</a> <a
				href="list?pageNum=${info.prePage }">上一页</a> <a
				href="list?pageNum=${info.nextPage }">下一页</a> <a
				href="list?pageNum=${info.pages }">尾页</a>
			</td>
		</tr>
	</table>
</body>
</html>