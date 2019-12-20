<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
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
</head>
<body>
	<fm:form action="add" method="post" modelAttribute="student">
	编号:<fm:input path="sid" />
		<fm:errors path="sname" cssStyle="color:red"></fm:errors>
		<br>
		<br>
       姓名:<fm:input path="sname" />
		<fm:errors path="sname" cssStyle="color:red"></fm:errors>
		<br>
		<br>
       密码:<fm:input path="pwd" />
		<fm:errors path="pwd" cssStyle="color:red"></fm:errors>
		<br>
		<br>
       出生日期:<fm:input path="birthday" />
		<fm:errors path="birthday" cssStyle="color:red"></fm:errors>
		<br>
		<br>
       性别:<fm:input path="sex" />
		<fm:errors path="sex" cssStyle="color:red"></fm:errors>
		<br>
		<br>
       课程:<fm:checkboxes items="${courses }" path="cids" itemValue="cid"
			itemLabel="cname" />
		<br>
		<br>
		<fm:button>增加</fm:button>
	</fm:form>
</body>
</html>