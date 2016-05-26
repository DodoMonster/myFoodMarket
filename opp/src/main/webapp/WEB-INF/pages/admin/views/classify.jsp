<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans" >
    <head>
        <meta charset="utf-8">
        <title>溯源推广平台-分类管理</title>

        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${publicPath}/css/scrollbar.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/classifyAdmin.css">

    </head>
    <body>
        <div class="classify-wrapper">
            <div id="dragSort">
                <span id="dragBtn"><i class="fa fa-external-link-square"></i></span>
                <div id="sortOpt">
                    <span id="confirmDrag" class="sort-opt"><i class="fa fa-check"></i></span>
                    <br>
                    <br>
                    <span id="cancelDrag" class="sort-opt"><i class="fa fa-close"></i></span>
                </div>
            </div>
            <div class="items-container" id="itemsContainer">
              <c:forEach items="${mainNavs}" var="mainNavs">
                <div class="items-wrapper" id="${mainNavs.id}">
                    <div class="content-header">
                        <span class="classify-name" id="${mainNavs.id}">${mainNavs.name}</span>
                        <span class="opt">
                            <i class="fa  fa-pencil edit"></i>
                            <i class="fa fa-plus plus"></i>
                            <i class="fa fa-close delete-big-tag"></i>
                        </span>
                        <div class="opt-btn">
                            <span class="save-btn">保存</span>
                            <span class="cancel-btn">取消</span>
                        </div>
                    </div>
                    <ul class="classify-items">
                        <c:forEach items="${mainNavs.subNavList}" var="list">
                        <li><span class="little-tag-name" id="${list.id}"><a href="javascrit:;" title="${list.name}">${list.name}</a></span><i class="fa fa-close"></i></li>
                        </c:forEach>
                    </ul>
                </div>

              </c:forEach>
                <div class="clear"></div><!--清除浮动-->
            </div>
            <!-- <div class="classify-footer">
                <span class="glyphicon glyphicon-plus"></span>
            </div> -->
            <div id="footer"><p>Copyright (c) 2016 Copyright 809-ZXCK All Rights Reserved.</p></div>
        </div>
        <script src="${jsPublicPath}/jquery-2.1.3.min.js"></script>
        <script src="${layerPath}/layer.js"></script>
        <script src="${jsPublicPath}/mousewheel.min.js"></script>
        <script src="${jsPublicPath}/scrollbar.min.js"></script>
        <script src="${jsPublicPath}/jquery-ui.min.js"></script>
        <script src="${jsAdminPath}/classifyAdmin.js"></script>

    </body>
</html>
