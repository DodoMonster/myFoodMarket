<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<!DOCTYPE html>
<html lang="zh-cmn-Hans" >
    <head>
        <meta charset="utf-8">
        <title>溯源推广平台</title>
        <link rel="stylesheet" href="${cssAdminPath}/home.css">
    </head>
    <body>
        <div id="welcome">
            欢迎进入我家菜市管理服务系统！
        </div>
        <div id="footer">
            <p>Copyright (c) 2016 Copyright SCAU-809-ZXCK All Rights Reserved.</p>
        </div>

        <script type="text/javascript">
            window.onload=function(){
                var wel=document.getElementById('welcome');
                wel.className='show';
            }
        </script>
    </body>
</html>
