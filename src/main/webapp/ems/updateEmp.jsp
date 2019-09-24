<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.Date" pageEncoding="UTF-8" isELIgnored="false" contentType="text/html; UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
	<head>
		<title>update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/ems/css/style.css" />
        <script type="application/javascript" src="${pageContext.request.contextPath}/ems/js/jquery-1.8.3.js"></script>
        <script type="application/javascript">
            $.ajax({
                url:"${pageContext.request.contextPath}/pople/showAll.do",
                type:"GET",
                dataType:"JSON",
                success:function (departments) {
                    var sel = $("#name");
                    sel.empty();
                    for(var i = 0;i<departments.length;i++){
                        var option=$("<option value="+departments[i].depart_id+">"+departments[i].depart_name+"</option>")
                        $("#name").append(option);
                    }
                }
            })

        </script>
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
								<a href="#">Main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="${pageContext.request.contextPath}/pople/updatePop.do?id=${sessionScope.pople1.id}&department_id=${sessionScope.pople1.department_id}" method="post"  enctype="multipart/form-data">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									id:
								</td>
								<td valign="middle" align="left">
									${sessionScope.pople1.id}
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									头像:
								</td>
								<td valign="middle" align="left">
                                    <img width="40px" height="40px" src="${pageContext.request.contextPath}/upload/${sessionScope.pople1.cover}"/>

                                    <input type="file" name="upload" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="${sessionScope.pople1.name}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									工资:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="${sessionScope.pople1.salary}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									年龄:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="age" value="${sessionScope.pople1.age}"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									部门:
								</td>
								<td valign="middle" align="left">
									<select id="name" name="department_id">

									</select>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="修改" />
						</p>
					</form>
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
