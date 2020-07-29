<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/30
  Time: 上午3:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>『喵喵商城』后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/admin_login.css"/>
</head>
<body>
<div class="admin_login_wrap">
    <h1>后台管理</h1>
    <div class="adming_login_border">
        <div class="admin_input">
            <form action="${pageContext.request.contextPath}/manage/adminlogin" method="post">
                <ul class="admin_items">
                    <li>
                        <label for="user">用户名：</label>
                        <input type="text" name="userName" value="" id="user" size="40" class="admin_input_style"/>
                    </li>
                    <li>
                        <label for="pwd">密码：</label>
                        <input type="password" name="passWord" value="" id="pwd" size="40" class="admin_input_style"/>
                    </li>
                    <li>
                        <input type="submit" tabindex="3" value="提交" class="btn btn-primary"/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
    <p class="admin_copyright"><a tabindex="5" href="#" target="_blank">返回首页</a> 更多商品尽在<a
            href="http://www.miaomiaoShoppingMall.com/" target="_blank">喵喵商城</a></p>
</div>
</body>
</html>
