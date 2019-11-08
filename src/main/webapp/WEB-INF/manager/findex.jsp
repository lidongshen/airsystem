<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>航班信息</title>
<link rel="stylesheet" href="/airsys/assets/layui/css/layui.css" media="all">
<script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
<style type="text/css">
    .layui-form-checkbox i {
        top: 6px;
    }
</style>
</head>
<body style="padding:0 15px;box-sizing: border-box;">

	<table id="demo" class="layui-hide" ></table>
	<script src="/airsys/assets/layui/layui.js"></script>
	<script type="text/html" id="barDemo">
	  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script type="text/html" id="dateTpl">
		{{layui.util.toDateString(new Date(d.BirthDate).getTime(), "yyyy-MM-dd HH:mm:ss") }}
	</script>
	<script src="/airsys/assets/js/findex.js"></script>
</body>
</html>