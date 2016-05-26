<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../../commons/base.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>我家菜市后台管理-添加分类</title>
        <link rel="stylesheet" href="${publicPath}/font-awesome-4.3.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="${publicPath}/css/scrollbar.min.css">
        <link rel="stylesheet" href="${cssAdminPath}/addClassify.css">
    </head>
    <body>
        <div id="addClassifyWrapper">
            <div id="formHeader">
                <p> 添加分类</p>
            </div>
            <form action="" name="addclassify" id="addClassify">
                <div id="formContent">
                    <div id="formInput">
                        <p>
                            <label for="mainClassify">主类：</label>
                            <input type="text" name="mainClassify" id="inputMainClassify"/>
                            <select id="selectClassify" name="selectClassify">
                                <option value="水果">水果</option>
                                <option value="蔬菜">蔬菜</option>
                                <option value="肉类">肉类</option>
                                <option value="干货">干货</option>
                                <option value="水产">水产</option>
                            </select>
                        </p>
                        <p>
                            <label for="sequenceClassify">子类：</label>
                            <input type="text" name="sequenceClassify" id="sequenceClassify"/>
                            <button id="addBtn" type="button"><i class="fa fa-plus"></i></button>
                        </p>
                    </div>
                    <div id="newTagDiv">
                        <p class="newTag">
                            <span>草莓</span>
                            <span class="opt">
                                <i class="fa fa-trash"></i>
                                <i class="fa fa-pencil"></i>
                            </span>
                        </p>
                    </div>
                    <p class="test"></p>
                </div>
                <div id="formBtn">
                    <button type="submit">确定</button>
                    <button type="reset" id="reset">清除</button>
                </div>
                <div class="clear"></div>
            </form>
        </div>
        <script src="${jsPublicPath}/jquery-2.1.3.min.js"></script>
        <script src="${layerPath}/layer.js"></script>
        <script src="${jsPublicPath}/mousewheel.min.js"></script>
        <script src="${jsPublicPath}/scrollbar.min.js"></script>
        <script src="${jsAdminPath}/addClassify.js"></script>
    </body>
</html>
