<%@ page import="java.util.Date" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
	<head>
		<title>emplist</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
					<div id="rightheader">
						<p>
							<fmt:formatDate value="<%=new Date()%>" pattern="yyyy-MM-dd"></fmt:formatDate>
							<br />
						</p>
					</div>
					<div id="topheader">
						<h1 id="title">
							<a href="#">main</a>
						</h1>
					</div>
					<div id="navigation">
					</div>
				</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						Welcome!<font>${requestScope.username}</font>
					</h1>
					<p>
						<input type="button" class="button" value="添加员工" onclick="location='${pageContext.request.contextPath}/ems/addEmp.jsp'"/> <input type="button" class="button" value="添加部门" onclick="location='${pageContext.request.contextPath}/ems/addDepartment.jsp'"/>
					</p>
					<table class="table">
						<tr class="table_header">
							<td>
								部门ID
							</td>
							<td>
								部门编号
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>

						<c:forEach var="list" items="${requestScope.users}">
						<tr class="row1">
								<td>
										${list.depart_id}
								</td>

								<td>
										${list.depart_name}
								</td>
								<td>
										${list.depart_number}
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/user/select.do?depart_id=${list.depart_id}">修改</a>&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/pople/selectpopleList.do?department_id=${list.depart_id}">员工列表</a>
								</td>
							</tr>
						</c:forEach>

					</table>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
				ABC@126.com
				</div>
			</div>
		</div>
	</body>
</html>
