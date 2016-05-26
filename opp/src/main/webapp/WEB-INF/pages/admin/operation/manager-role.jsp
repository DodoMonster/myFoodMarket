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

<div class="top">
    <button type="button" class="btn btn-primary" onclick="showEditRole('${user.id}',0)">新增</button>
    <button type="button" class="btn btn-primary" onclick="deleteRoles()">批量删除</button>
    <button type="button" class="btn btn-primary" id="searchBtn" onclick="searchRole(1)">搜索</button>
    <input type="text" class="form-control" id="searchInput" name="searchInput"  placeholder="请输入角色名" />
</div>



<table class="table tableNotInBind">
<tr>
<th></th>
<th>name</th>
<th>description</th>
<th>available</th>
<th>remark</th>
<th>操作</th>
</tr>

<c:forEach items="${result}" var="role">
<tr id="${role.id}" class="flash">
<td><input type="checkbox" name="role" value="${role.id}" /></td>
<td>${role.name}</td>
<td>${role.description}</td>
<td>${role.available}</td>
<td>${role.remark}</td>
<td>
<button type="button" class="btn btn-primary btn-xs" onclick="showEditRole('${role.id}',1)">编辑</button>
<button type="button" class="btn btn-primary btn-xs" onclick="deleteRole('${role.id}')">删除</button>
<button type="button" class="btn btn-primary btn-xs" onclick="showRolePermission('${role.id}')">已有权限</button>
<button type="button" class="btn btn-primary btn-xs" onclick="showRoleBindPermission('${role.id}')">新增权限</button>
</td>
</tr>
</c:forEach>

</table>

<div class="footer-page">
<div style="text-align: center;">
<ul class="pagination" style="margin: 0;">
    <c:if test="${begin > 1}">
        <li><a href="/manager-role?index=${index-1}">&laquo;</a></li>
        <li><a href="/manager-role?index=1">1...</a></li>
    </c:if>
  <c:forEach var="item" begin="${begin}" end="${end}" varStatus="status">
    <li <c:if test="${status.index == index}">class="active"</c:if>><a href="/manager-role?index=${status.index}">${status.index}</a></li>
  </c:forEach>
  <c:if test="${end < pageCount}">
    <li><a href="/manager-role?index=${pageCount}">...${pageCount}</a></li>
    <li><a href="/manager-role?index=${index+1}">&raquo;</a></li>
  </c:if>
  <li><a href="#">第${index}/${pageCount}页</a></li>
</ul>
</div>
</div>
</body>
</html>
