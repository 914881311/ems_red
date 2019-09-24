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
						Welcome!
					</h1>
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
							    头像
							</td>
							<td>
								姓名
							</td>
							<td>
								工资
							</td>
							<td>
								年龄
							</td>
							<td>
								部门名称
							</td>
							<td>
								操作
							</td>
						</tr>
						<c:forEach var="query" items="${poples}">
						<tr class="row1">
							<td>
									${query.id}
							</td>
							 <td>
								 <img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${query.cover}"/>
							</td>

							<td>
								${query.name}
							</td>
							<td>
								${query.salary}
							</td>
							<td>
								${query.age}
							</td>
							<td>
								${query.department.depart_name}
							</td>
							<td>
								<a href="${pageContext.request.contextPath}/pople/deletePop.do?id=${query.id}&department_id=${query.department_id}">delete emp</a>&nbsp;<a href="${pageContext.request.contextPath}/pople/selectById.do?id=${query.id}">update emp</a>
							</td>
						</tr>
						</c:forEach>
					</table>
					<a href="${pageContext.request.contextPath}/user/showAll.do">跳转到主页面</a>
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
