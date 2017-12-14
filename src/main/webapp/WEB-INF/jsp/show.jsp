<%--
  Created by IntelliJ IDEA.
  User: heichen
  Date: 2017/12/14
  Time: 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>展示页面</h1>
<shiro:authenticated>用户已经登录显示此内容</shiro:authenticated><br>
<shiro:hasRole name="manager">manager角色登录显示此内容</shiro:hasRole><br>
<shiro:hasRole name="admin">admin角色登录显示此内容</shiro:hasRole><br>
<shiro:hasRole name="normal">normal角色登录显示此内容</shiro:hasRole><br>
<shiro:hasAnyRoles name="manager,admin">** manager or admin 角色用户登录显示此内容**</shiro:hasAnyRoles><br>
<shiro:principal/>显示当前登录用户名<br>
<shiro:hasPermission name="add">add权限用户显示此内容</shiro:hasPermission><br>
<shiro:hasPermission name="user:query">query权限用户显示此内容<shiro:principal/></shiro:hasPermission><br>
<shiro:lacksPermission name="user:add"> 不具有user:del权限的用户显示此内容 </shiro:lacksPermission><br>
</body>
</html>
