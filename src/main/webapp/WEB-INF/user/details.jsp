<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE unspecified PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="text/html;charset=utf-8">
	<title>列出账号</title>
	<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
	
	<style>
		a{
			text-decoration: none;
		}
	</style>

</head>
<body>
	<h3 align="center">航班详情</h3>
	<hr color="red">
	<center>
		<table  border="1px" cellspacing="0" cellpadding="0">
			<tr>
				<th>航班ID</th>
				<th>航班名字</th>
				<th>起始地</th>
				<th>目的地</th>
				<th>票价<th>
				<!-- <th>总座位数</th> -->
				<th>出发时间</th>
				<th>抵达时间</th>
				<th>操作</th>
			</tr>
			
				<tr>
					<td>${oneFlight.fId}</td>
					<td>${oneFlight.fName}</td>
					<td>${oneFlight.fFromcity}</td>
					<td>${oneFlight.fTocity}</td>
					<td>${oneFlight.fMoney}</td>
					<%-- <td>${oneFlight.fseatnum}</td> --%>
					<td>${oneFlight.fStarttime}</td>
					<td>${oneFlight.fEndtime}</td>
					<td>
						<a href="#" onclick=orderTicket(${oneFlight.fId})>订票</a>
					</td>
				</tr>
			
		</table>
		
	</center>
	<script type="text/javascript" src = "/airsys/assets/js/userOrderTicket.js"></script>
</body>

</html>