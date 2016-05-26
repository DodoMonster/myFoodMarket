<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="part/base.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title>${_title}</title>
    <link href="${cssPath}/style.css" rel="stylesheet" type="text/css"/>
    <script src="${jsPath}/jquery.min.js" type="text/javascript"></script>
    <script src="${jsPath}/jquery.validate.min.js" type="text/javascript"></script>
    <script src="${jsPath}/cloud.js" type="text/javascript"></script>

    <script language="javascript">
        $(function () {
            $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            $(window).resize(function () {
                $('.loginbox').css({'position': 'absolute', 'left': ($(window).width() - 692) / 2});
            })
        });
    </script>
</head>

<body style="background-color:#1c77ac; background-image:url(${imgPath}/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">


<div id="mainBody">
    <div id="cloud1" class="cloud"></div>
    <div id="cloud2" class="cloud"></div>
</div>


<div class="logintop">
    <span>欢迎登录${_author}后台管理系统</span>
    <%--<ul>--%>
        <%--<li><a href="#">回首页</a></li>--%>
        <%--<li><a href="#">帮助</a></li>--%>
        <%--<li><a href="#">关于</a></li>--%>
    <%--</ul>--%>
</div>

<div class="loginbody">
    <span class="systemlogo"></span>
    <form action="/login" method="post" id="loginForm">
        <div class="loginbox">
            <ul>
                <li>
                    <input id="username" name="username" type="text" class="loginuser" placeholder="用户名" required/>
                </li>
                <li>
                    <input id="passwd" name="passwd" type="text" class="loginpwd"  placeholder="密码" required/>
                </li>
                <li>
                    <input id="loginBtn" type="submit" class="loginbtn" value="登录"/>
                    <%--<label>--%>
                        <%--<input name="rememberMe" type="checkbox" checked="checked"/>记住密码--%>
                    <%--</label>--%>
                    <%--<label>--%>
                        <%--<a href="#">忘记密码？</a>--%>
                    <%--</label>--%>
                    <c:choose>
                        <c:when test="${empty errMsg}">
                            <label>请输入用户名和密码</label>
                        </c:when>
                        <c:otherwise>
                            <label style="color: red">${errMsg}</label>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
        </div>
    </form>
</div>

<div class="loginbm">版权所有 2015 <a href="http://www.zhixingchuangke.com">知行创客</a></div>
</body>
</html>

