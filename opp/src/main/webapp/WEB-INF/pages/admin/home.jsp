<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../commons/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>${_title}</title>
</head>
    <frameset cols="183px,*" framesetBorder="0" border=0>
        <frame src="./block/asider.jsp" name="asiderFrame" scrolling="no" noresize="noresize" id="asiderFrame">
        <frameset rows="60px,*">
            <frame src="./block/header.jsp" scrolling="no" noresize="noresize" id="headerFrame">
            <frame src="./views/home.jsp" scrolling="no" noresize="noresize" id="homeFrame">
        </frameset>
    </frameset>
</html>
