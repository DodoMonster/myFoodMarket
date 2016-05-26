<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../../commons/base.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>

    <link rel="stylesheet" href="${cssPath}/bootstrap.min.css">
    <link rel="stylesheet" href="${cssPath}/permission.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.4/jquery.min.js"></script>
    <script src="${publicPath}/common.js"></script>
    <script src="${jsPath}/bootstrap.min.js"></script>
    <script src="${layerPath}/layer.js"></script>
    <script src="${jsPath}/permission.js"></script>

</head>


<body>


<c:choose>
    <c:when test="${not empty type}">
    <div>
    </c:when>
    <c:otherwise>
    <div class="top">
        <button type="button" class="btn btn-primary" id="searchBtn" onclick="searchPermission(0)">搜索</button>
        <input type="text" class="form-control" id="searchInput" name="searchInput"  placeholder="请输入权限名" />
    </c:otherwise>
</c:choose>
</div>


<c:choose>
    <c:when test="${not empty type}">
        <table class="table">
    </c:when>
    <c:otherwise>
        <table class="table tableInBind">
    </c:otherwise>
</c:choose>

<tr>
<th></th>
<th>name</th>
<th>description</th>
<th>available</th>
<th>remark</th>
</tr>

<c:forEach items="${result}" var="permission">
<tr id="${permission.id}" class="flash">
<td><input type="checkbox" name="permission" value="${permission.id}" /></td>
<td>${permission.permission}</td>
<td>${permission.description}</td>
<td>${permission.available}</td>
<td>${permission.remark}</td>
</tr>
</c:forEach>

</table>

<div class="btns">
<c:choose>
    <c:when test="${not empty type}">
       <button id="editBtn" type="button" class="btn btn-default" onclick="deleteRoleBindPermission('${roleId}')">删除</button>
    </c:when>
    <c:otherwise>
        <button id="editBtn" type="button" class="btn btn-default" onclick="roleBindPermission('${roleId}')">关联</button>
    </c:otherwise>
</c:choose>
</div>
</body>
</html>
