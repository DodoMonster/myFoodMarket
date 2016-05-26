<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>我家菜市后台管理-商品信息编辑</title>
        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/editGoods.css">
    </head>
    <body>
        <div class="wrapper">
            <!--start header-->
            <header>
                <h1>商品信息编辑</h1>
            </header>
            <!--end header-->
            <!--start form-->
            <form action="saveCommodity" id="editInfo" enctype="multipart/form-data" method="post">
            <input type="hidden" name="id" value="${commodity.id}">
                <!--start 商品总信息-->
                <div id="totalInfo" class="info-div">
                    <div id="goodsImg">
                        <img src="${imgAdminPath}/${commodity.pic}" alt="商品图">
                        <a href="javascript" class="uploadImg">
                            <input type="file" name="file">点击上传图片
                        </a>
                        <br />
                        <span class="tip showFileName"></span>
                        <span class="tip fileErrorTip"></span>
                    </div>

                    <!--end 商品信息编辑-->
                    <div id="goodsInfo">
                        <p>
                            <label for="goodsName">商品名称</label>
                            <input type="text" id="goodsName" name="goodsName" value="${commodity.name}" />
                        </p>

                        <p>
                            <label for="goodsID">商品编号</label>
                            <input type="text" id="goodsID" name="goodsID" value="${commodity.number}">
                        </p>
                        <p class="short">
                            <label for="goodsPrice">价格</label>
                            <input type="text" id="goodsPrice" name="goodsPrice" value="${commodity.newPirce}">
                            <label for="goodsDiscount">优惠</label>
                            <input type="text" id="goosdDiscount" name="goodsDiscount" value="${commodity.discount}">
                        </p>
                        <p class="short">
                            <label for="minAmount">最低限购</label>

                            <input type="text" id="minAmount" name="minAmount" value="${commodity.minAmount}">

                            <label for="goodsStock">库存</label>
                            <input type="text" id="goodsStock" name="goodsStock" value="${commodity.stock}">
                        </p>
                        <a href="${adminPath}/CommodityAction/IntoCommodityComments?commodityId=${commodity.id}" id="backBtn">商品评论管理</a>
                    </div>
                    <div class="clear"></div>
                </div>
                <!--end 商品总信息-->

                <!--start 返回按钮-->
                <a class="back-btn" href="${adminPath}/CommodityAction/showCommodity"><i class="fa fa-reply"></i></a>
                <!--end 返回按钮-->

                <!--start 商品描述-->
                <div id="goodsDis" class="info-div">
                    <h1>商品描述</h1>
                    <textarea name="goodsDis" id="goodsDiscription" cols="90" rows="5" >${commodity.descrip}</textarea>
                </div>
                <!--end 商品描述-->

                <!--start 商品标签-->
                <div id="goodsTag" class="info-div">
                    <h1>商品标签</h1>
                    <div id="tagsDiv">
                        <ul>
                            <c:forEach items="${labels}" var="label">
                                <li><input type="text" name="name" value="${label}"><i class="fa fa-close"></i></li>
                            </c:forEach>
                        </ul>
                        <i class="fa fa-plus"></i>
                    </div>
                </div>
                <!--end 商品标签-->

                <!--start 商品图片-->
                <div id="goodsImages" class="info-div">
                    <h1>商品图片</h1>
                    <div id="imgDiv">
                        <ul class="img-gallery">
                                <c:forEach items="${commodityPics}" var="commodityPic">
                                    <li>
                                        <img src="${imgAdminPath}/${commodityPic.pic}" alt="商品图1">
                                        <span class="close-btn"><i class="fa fa-close"></i></span>
                                    </li>
                                </c:forEach>
                        </ul>
                        <div class="upload-btn">
                            <a href="javascript:;" class="uploadImg uploadImgs">
                                <input type="file" >上传本地图片
                            </a>
                            <br />
                            <span class="tip showFileName"></span>
                            <span class="tip fileErrorTip"></span>
                        </div>
                    </div>

                </div>
                <!--end 商品图片-->
                <div class="opt-btn">
                    <button type="submit" id="submitBtn">保存</button>
                </div>

            </form>
            <!--end form-->
            <div class="clear"></div>
        </div>

    </body>
    <script src="${publicPath}/js/jquery-2.1.3.min.js"></script>
    <script src="${publicPath}/layer/layer.js"></script>
    <script src="${publicPath}/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="${publicPath}/js/mousewheel.min.js"></script>
    <script src="${publicPath}/js/scrollbar.min.js"></script>
    <script src="${jsAdminPath}/editgoods.js"></script>
</html>
