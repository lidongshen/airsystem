<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>login</title>
    <link rel="stylesheet" href="/airsys/assets/css/bootstrap.css">
    <script src="/airsys/assets/jquery-validation/lib/jquery.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/jquery.validate.min.js"></script>
	<script src="/airsys/assets/jquery-validation/dist/localization/messages_zh.js"></script>
    
    <style>
       .one{
           width:1000px;
           height:500px;
           margin:auto;
       }
       .chaxun{
       margin:auto;
       }
    </style>
</head>
<body>
    <div class="one">
        <form method="post" id="form1" action="search" >
            <fieldset>
                <legend class="chaxun">查询</legend>
                <p>
                    <label for="from">出发地</label>
                    <input id="from" type="text" name="from" required>
                </p>
                <p>
                    <label for="to">目的地</label>
                    <input id="to" type="text" maxlength="12" name="to" required>
                </p>
                <p>
                    <input class="submit" type="submit" value="搜索">
                </p>
            </fieldset>
        </form>

    </div>
</body>
</html>