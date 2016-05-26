<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../commons/base.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
	<meta charset="UTF-8">
	<title>创客空间后台管理系统</title>
	<link rel="stylesheet" href="${publicPath}/public.css">
	<link rel="stylesheet" href="${cssPublicPath}/adminSys.css">
	<script src="${publicPath}/jquery.js"></script>
	<script src="${jsPublicPath}/adminSys.js"></script>
</head>
<body>
	<header>
		<h1>创客空间管理系统</h1>
		<div class="user-box">
			<i class="iconfont icon-white">&#xe653;</i>
            <i class="iconfont icon-dot">&#xe63f;</i>
            <span class="user-name">Cyseria</span>  
            <i class="iconfont icon-pulldown">&#xe671;</i>
		</div>
	</header>
	<nav>
    		<ul>
				<li class="mainnav"><a href="#">管理</a></li>
				<ul class="subnav">
					<li><a href="/manager-user" target="adminFrame">用户管理</a></li>
					<li><a href="/manager-role" target="adminFrame">角色管理</a></li>
					<li><a href="/manager-permission" target="adminFrame">权限管理</a></li>
					<li><a href="/manager-resource" target="adminFrame">资源管理</a></li>
				</ul>
    		</ul>
    	</nav>
	<iframe id="adminFrame" src="" name="adminFrame" scrolling="yes" frameborder="0" >
		
	</iframe>
	<script>
	$('.mainnav').click(function(event) {
		$(this).next('ul').slideToggle();
	});
	</script>
</body>
</html>