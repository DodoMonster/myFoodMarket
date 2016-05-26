<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/base.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>block</title>
    </head>
    <c:if test="${empty shoppingCart}"><h1>空</h1></c:if>
    <c:if test="${not empty shoppingCart}">
    <table align="center">
        <tr>
            <th>店铺名</th>
            <th>商品图片</th>
            <th>商品名</th>
            <th>商品价格</th>
            <th>商品数量</th>
            <th>删除按钮</th>
        </tr>
        <c:forEach  var="i" begin="0" end="${fn:length(shoppingCarts)-1}">
        <tr>
            <td>${shopName[i]}</td>
            <td>${pic[i]}</td>
            <td>${name[i]}</td>
            <td>${price[i]}</td>
            <td>${number[i]}</td>
            <td><form action="deleteShoppingCart" method="post"><input type="hidden" name="id" value="${id[i]}"><input type="submit" value="删除" /></form></td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan="6" align="right" >总计：${sum}<input type="submit" value="结算"></td>
        </tr>
    </table>
        </c:if>
    </body>
</html>
