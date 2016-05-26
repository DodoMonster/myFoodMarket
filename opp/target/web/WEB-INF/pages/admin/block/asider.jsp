<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>溯源推广平台-侧边栏</title>
        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/asider.css">
    </head>
    <body>
        <div class="asider-wrapper">
            <div id="logo">
                <!-- <span>LOGO</span> -->
                <span>H <i class="fa fa-diamond"></i> M E</span>
            </div>
            <!-- <nav class="navbar" role="navigation"> -->
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
                            <a href=""><span class="circle"></span> 水果</a>
                        </li>
                        <li>
                            <a href=""><span class="circle"></span> 蔬菜</a>
                        </li>
                        <li>
                            <a href=""><span class="circle"></span> 肉类</a>
                        </li>
                        <li>
                            <a href=""><span class="circle"></span> 干货</a>
                        </li>
                        <li>
                            <a href=""><span class="circle"></span> 水产</a>
                        </li>
                        <li>
                            <a href="#" onclick="top.location='../addClassify.html'"><i class="fa fa-plus" id="plusBigTag"></i></a>
                        </li>
                    </ul>
                    <li>
                        <a href="#">
                            <i class="fa fa-photo"></i>
                            图片管理
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-search"></i>
                            搜索框
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-sort-amount-desc"></i>
                            底部栏
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-users"></i>
                            商品管理
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-user"></i>
                            用户管理
                        </a>
                    </li>
                </ul>
            <!-- </nav> -->
        </div>

        <script src="${jsPublicPath}/js/jquery-2.1.3.min.js"></script>
        <script src="${layerPath}/layer.js"></script>
        <script type="text/javascript">
            $(function(){
                var $navLi=$('.nav li');
                var $addBtn=$('#plusBigTag');
                $navLi.each(function(){
                    $(this).click(function(){
                        $(this).siblings('li').removeClass('active').end().addClass('active');
                        $(this).next('ul').slideToggle(300);
                    });
                });
            });
        </script>
    </body>
</html>
