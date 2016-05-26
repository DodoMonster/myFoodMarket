<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/base.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
    <link rel="stylesheet" href="${cssPath}/login.css" type="text/css" >

    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="${jsPath}/bootstrap.min.js"></script>
    <script src="${jsPath}/login.js"></script>

</head>
<body>
<div class="">
    <div class="heading">
        <p class="logo">Logo</p>
    </div>
    <div id="div_login">
    <div id="title">登录</div>
        <form action="login" method="post">
            <ul class="login_register">
                <li class="error-message">${info}</li>
                <li><input id="input" class="form-control" name="username" type="text"   placeholder="学号/帐号"></li>
                <li><input id="input" class="form-control" name="password" type="text"   placeholder="请输入密码"></li>
                <li id="fPadding">
                    <a id="forgetPWD" href="#" style="text-decoration: none;">忘记密码？</a>
                </li>

                <li id="top_Padding">
                    <input id="identifying_code" class="form-control" type="text" placeholder="验证码">
                    <label class="control-label" for="identifying_code"><img src="${imgPath}/yan.jpg"></label>
                    <label class="control-label"><a id="changeIC" href="#" style="text-decoration: none;">换一张</a></label>
                </li>
                <li id="noPadding">
                    <div class="checkbox">
                          <label>
                          <input type="checkbox"> 记住我
                          </label>
                       </div>
                </li>
                <li id="btns">
                    <button type="submit" class="login btn btn-primary">登录</button>
                    <a href="${htmlPath}/register.html"><button type="button" class="register btn btn-default">注册</button></a>
                </li>
            </ul>
        </form>
    </div>

    <div class="footer">
    </div>
</div>
</body>
</html>