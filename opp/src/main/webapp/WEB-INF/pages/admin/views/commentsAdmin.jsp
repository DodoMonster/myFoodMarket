<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>我家菜市后台管理-商品评论管理</title>
        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/commentsAdmin.css">
    </head>
    <body>
        <div class="wrapper">
            <!--start header-->
            <header>
                <h1>商品评论管理</h1>
            </header>
            <!--end header-->

            <!--start 评论comments-header-->
            <div class="comments-header">
                <div class="goods-degree">
                    <p>好评度</p>
                    <span id="degree">${percent}</span>
                </div>
                <div class="buyer-impression">
                    <p>买家印象</p>
                    <ul>
                        <c:forEach items="${labels}" var="labels">
                            <li>${labels}</li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="clear"></div>
            </div>
            <!--end 评论comments-header-->
            
            <!--返回按钮-->
            <a class="back-btn"  href="${adminPath}/CommodityAction/commodityModify?commodityId=${commodityId}"><i class="fa fa-reply"></i></a>

            <!--start replyComments-->
            <div class="reply-comments">
                <!--start 评论导航-->
                <ul class="comments-nav">
                    <li class="on">全部评论(999)</li>
                    <li>晒图（99）</li>
                    <li>好评（99）</li>
                    <li>中评（99）</li>
                    <li>差评（99）</li>
                </ul>
                <!--end 评论导航-->

                <!--start 评论详细列表-->
                <ul class="comments-list">
                    <!--start 评论列表-->
                    <c:forEach items="${commodityComments}" var="comment" varStatus="status">
                        <li class="buyer-comments">
                            <div class="buyer">
                                <img src="${imgAdminPath}/goods-img.jpg" alt="用户头像">
                                <p class="author">${username[status.count-1]}</p>
                                <p class="rank">钻石会员</p>
                            </div>
                            <div class="comments-detail">
                                <p>
                                    <c:forEach begin="1" end="${comment.score}">
                                        <i class="fa fa-star"></i>
                                    </c:forEach>
                                </p>
                                <div class="comments">${comment.comment}</div>
                                <div class="time">
                                    <span>收货后<em>2</em>天后评论</span>
                                    <span>${comment.time}</span>
                                    <span class="reply-btn">回复 <i class="fa fa-angle-down"></i></span>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </li>
                    </c:forEach>
                </ul>
                <!--end 评论详细列表-->
            </div>
            <!--end replyComments-->

            <!--start 分页-->
            <div id="pagination">
                <span class"totalNum">共<em id="totalNum">99</em>条</span>
                <span class="pageNum">
                    <em id="nowPage">1</em>/<em id="totalPage">8</em>
                </span>
                <span id="prevNext">
                    <span id="prevBtn" class="prev-next-btn">＜</span>
                    <span id="nextBtn" class="prev-next-btn">＞</span>
                </span>
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
    <script src="${jsAdminPath}/goodsAdmin.js"></script>
</html>
