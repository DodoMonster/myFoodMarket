<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/base.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>block</title>
        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/block.css">
    </head>
    <body>
        <header>
            <div class="header-wrapper">
                <span class="titleName">我家菜市管理服务系统</span>
                <div class="component">
                    <span class="userName"><i class="fa fa-user"></i> DodoMonster</span>
                    <span><i class="fa fa-gear"></i></span>
                    <span><i class="fa fa-sign-out"></i></span>
                </div>
            </div>
        </header>
        <nav>
            <div class="asider-wrapper">
                <div id="logo">
                    <span>H <i class="fa fa-diamond"></i> M E</span>
                </div>
                <ul class="nav">
                    <li class="active">
                        <a href="javascript:;" class="navbar-toggle" data-toggle="collapse">
                            <i class="fa fa-sort-amount-desc"></i>
                            分类管理
                            <i class="fa fa-sort-desc"></i>
                        </a>
                    </li>
                    <ul id="childUl">
                        <li>
                            <a href="${adminPath}/NavAction/classify?classify=水果" target="adminFrame"><span class="circle"></span> 水果</a>
                        </li>
                        <li>
                            <a href="${adminPath}/NavAction/classify?classify=蔬菜" target="adminFrame"><span class="circle"></span> 蔬菜</a>
                        </li>
                        <li>
                            <a href="${adminPath}/NavAction/classify?classify=肉类" target="adminFrame"><span class="circle"></span> 肉类</a>
                        </li>
                        <li>
                            <a href="${adminPath}/NavAction/classify?classify=干货" target="adminFrame"><span class="circle"></span> 干货</a>
                        </li>
                        <li>
                            <a href="${adminPath}/NavAction/classify?classify=水产" target="adminFrame"><span class="circle"></span> 水产</a>
                        </li>
                        <li>
                            <a href="${adminPath}/NavAction/addClassify" target="adminFrame"><i class="fa fa-plus" id="plusBigTag"></i></a>
                        </li>
                    </ul>
                    <li><a href="#"><i class="fa fa-photo"></i> 图片管理</a></li>
                    <li><a href="#"><i class="fa fa-search"></i> 搜索框</a></li>
                    <li><a href="#"><i class="fa fa-upload"></i> 底部栏</a></li>
                    <li><a href="${adminPath}/CommodityAction/showCommodity" target="adminFrame"><i class="fa fa-users"></i> 商品管理</a></li>
                    <li><a href="#"><i class="fa fa-user"></i> 用户管理</a></li>
                </ul>
            </div>
        </nav>

        <iframe id="adminFrame" src="${adminPath}/NavAction/home" name="adminFrame"  frameborder="0"></iframe>

        <script src="${jsPublicPath}/jquery-2.1.3.min.js"></script>
        <script src="${jsAdminPath}/block.js"></script>
    </body>
</html>
