<%@page import="_CONSTAINT.CONSTAINT"%>
<%@page import="Model.Bean.uploadfile"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Bean.user"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>

<link href="./css/UserProfileStyle.css" rel="stylesheet" type="text/css">
</head>
<body>

	<%
	if (session.getAttribute("message") != null) {
	%>
	<script>alert("<%=session.getAttribute("message")%>
		")
	</script>
	<%
	session.setAttribute("message", null);
	}
	%>

	<%
	user user = (user) session.getAttribute("user");
	ArrayList<uploadfile> files = (ArrayList<uploadfile>) request.getAttribute("Files");
	%>

	<header>
		<nav>
			<ul class="nav_link">
				<li><a href="HomePage.jsp">Home</a></li>
				<li><a href="UserProfileServlet?uid=<%=user.getUid()%>">Profile</a></li>
				<li><a href="LogoutServlet">Logout</a></li>
			</ul>
		</nav>
	</header>

	<div class="Wrapper">
		<div class="left">
			<img src="https://cdn-icons-png.flaticon.com/512/21/21104.png" alt="user" width="100">
			<h4 class="fullname"><%=user.getFullname()%></h4>
		</div>
		<div class="right">
			<div class="info">
				<h3>Profile Account</h3>
				<div class="info_data">
					<div class="data">
						<h4>Email</h4>
						<p><%=user.getEmail()%></p>
					</div>
				</div>
			</div>

			<div class="projects">
				<h3>Projects</h3>
				<table>
					<thead>
						<tr>
							<td class="id"><b>ID</b></td>
							<td class="name"><b>File name</b></td>
							<td class="download"><b>Download</b></td>
						</tr>
					</thead>
					<tbody>
						<%
						for (int i = 0; i < files.size(); i++) {
						%>
						<tr>
							<td><%=i + 1%></td>
							<td><%=files.get(i).getFname()%></td>
							<%
							int fstatus = files.get(i).getFstatus();

							switch (fstatus) {
							case CONSTAINT.PROCESSING:
							%>
							<td>Loading...</td>
							<%
							break;
							case CONSTAINT.CONVERT_ERROR:
							%>
							<td><a style="color: blue;"
								href="ShowErrorServlet?errorCode=<%=CONSTAINT.CONVERT_ERROR%>&uid=<%=user.getUid()%>"><i>Show error</i></a></td>
							<%
							break;
							case CONSTAINT.SUCCESS:
							%>
							<td><a style="color: blue;"
								href="DownloadFileServlet?fid=<%=files.get(i).getFid()%>"><i>Download</i></a></td>
							<%
							break;
							case CONSTAINT.UPLOAD_ERROR:
							%>
							<td><a style="color: blue;"
								href="ShowErrorServlet?errorCode=<%=CONSTAINT.UPLOAD_ERROR%>&uid=<%=user.getUid()%>"><i>Show error</i></a></td>
							<%
							break;
							default:
							%>
							<td><a style="color: blue;"
								href="ShowErrorServlet?errorCode=4&uid=<%=user.getUid()%>"><i>Show error</i></a></td>
							<%
							break;
							}
							%>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</body>
</html>