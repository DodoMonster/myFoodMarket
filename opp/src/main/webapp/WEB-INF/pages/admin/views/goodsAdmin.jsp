<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>我家菜市后台管理-商品管理</title>
        <link rel="stylesheet" href="${publicPath}/bootstrap/dist/css/bootstrap.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/goodsAdmin.css">
    </head>
    <body>
        <div class="wrapper">
            <!--start header-->
            <header>
                <!--start head-->
                <div class="head">
                    <span id="pageName">商品列表</span>
                    <div id="searchBox">
                        <span><input type="text" placeholder="请输入商品名称/类" id="inputSearch"></span>
                        <span class="glyphicon glyphicon-search" id="searchBtn"></span>
                    </div>
                    <div class="clear"></div>
                </div>
                <div class="banner">
                    <!--start 下拉菜单-->
                    <div class="btn-group">
                        <span class="selectTitle">商品分类</span>
                        <div class="select-classiy-nav">
                            <button type="button" class="btn btn-default classify-title">全部</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                            </button>
                        </div>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">水果</a></li>
                            <li><a href="#">蔬菜</a></li>
                            <li><a href="#">肉类</a></li>
                            <li><a href="#">干货</a></li>
                            <li><a href="#">水产</a></li>
                        </ul>
                    </div>
                    <div class="btn-group">
                        <span class="selectTitle">商铺名称</span>
                        <div class="select-shopname-nav">
                            <button type="button" class="btn btn-default shopname-title">水果</button>
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                                <span class="caret"></span>
                            </button>
                        </div>

                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">水果</a></li>
                            <li><a href="#">蔬菜</a></li>
                            <li><a href="#">肉类</a></li>
                            <li><a href="#">干货</a></li>
                            <li><a href="#">水产</a></li>
                        </ul>
                    </div>
                    <!--end 下拉菜单-->

                    <!--start 子分类-->
                    <div id="subNav">
                        <span class="glyphicon glyphicon-remove"></span>
                        <span class="all-btn">全部<em class="mainNav">水果</em></span>
                        <ul id="mainNav">
                            <li><a href="#">水果</a></li>
                            <li><a href="#">蔬菜</a></li>
                            <li><a href="#">肉类</a></li>
                            <li><a href="#">干货</a></li>
                            <li><a href="#">水产</a></li>
                        </ul>

                        <div id="fruit" class="subNavDiv">
                            <c:forEach items="${mainNavs}" var="mainNavs" >
                                <div class="subnav">
                                    <p>${mainNavs.name}</p>
                                        <ul>
                                            <c:forEach items="${mainNavs.subNavList}" var="list">
                                                <li id="${list.id}">${list.name}</li>
                                               <!-- <li id="${list.id}"><a href="${adminPath}/CommodityAction/showCommodity?subNavId=${list.id}">${list.name}</a></li> -->
                                            </c:forEach>
                                         </ul>
                                </div>
                            </c:forEach>
                        </div>
                    <!--end 子分类-->
                </div>
                <!--end head-->
            </header>
            <!--end header-->

            <!--end 商品列表table-->
            <section>
                <div id="tableContainer">
                    <table class="table table-striped">
                        <thead>
                            <th id="num">序号</th>
                            <th id="goodsImg">商品图</th>
                            <th id="goodsName">商品名</th>
                            <th id="goodsId">商品编号</th>
                            <th id="price">价格</th>
                            <th id="stock">库存</th>
                            <th id="goodsDesc">商品描述</th>
                            <th id="goodsTag">商品标签</th>
                            <th id="opt"></th>
                        </thead>
                        <tbody>
                            <c:forEach items="${commoditis}" var="commoditis" varStatus="status">
                                <tr id="${commoditis.id}">
                                    <td>${status.count}</td>
                                    <td><img src="${imgAdminPath}/${commoditis.pic}" alt="商品图1"></td>
                                    <td>${commoditis.name}</td>
                                    <td>${commoditis.number}</td>
                                    <td>${commoditis.newPirce}</td>
                                    <td>${commoditis.stock}</td>
                                    <td>${commoditis.descrip}</td>
                                    <td>${label[status.count-1]}</td>
                                    <td><span class="glyphicon glyphicon-remove delete-btn"></span>
                                        <p>
                                            <a href="${adminPath}/CommodityAction/commodityModify?commodityId=${commoditis.id}"><span class="glyphicon glyphicon-pencil edit-btn"></span></a>
                                            <span class="checkbox">

                                            <c:choose>
                                               <c:when test="${commoditis.flag==1}">
                                                     <span class="open-box"></span>
                                               </c:when>
                                               <c:otherwise>
                                                     <span class="close-box"></span>
                                               </c:otherwise>
                                            </c:choose>

                                            </span>
                                        </p>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </section>
            <!--end 商品列表table-->

            <!--start 分页-->
            <div id="pagination">
                <span class"totalNum">共<em id="totalNum">${totelNumber}</em>条</span>
                <span class="pageNum">
                    <em id="nowPage">${index}</em>/<em id="totalPage">${totlePage}</em>
                </span>
                <span id="prevNext">
                    <span id="prevBtn" class="prev-next-btn">＜</span>
                    <span id="nextBtn" class="prev-next-btn">＞</span>
                </span>
                <!-- <ul class="pagination">
                    <li><a href="#">&laquo;</a></li>
                    <li><a href="#" class="active">1</a></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">&raquo;</a></li>
                </ul> -->
                <span class="goto">
                    到第 <input type="text" id="gotoPage"> 页
                    <span id="gotoBtn">GO</span>
                </span><!--需要限制输入只能为>0的数字-->
            </div>
            <!--end 分页-->
        </div>

    </body>
    <script src="${publicPath}/js/jquery-2.1.3.min.js"></script>
    <script src="${publicPath}/layer/layer.js"></script>
    <script src="${publicPath}/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${jsAdminPath}/goodsAdmin.js"></script>
    <!-- <script src="../../../public/js/mousewheel.min.js"></script>
    <script src="../../../public/js/scrollbar.min.js"></script> -->
</html>
