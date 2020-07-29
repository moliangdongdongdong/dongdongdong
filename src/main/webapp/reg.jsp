<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/28
  Time: 下午4:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/login.css"/>
    <script src="js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="js/Calendar.js"></script>
    <script src="js/function.js"></script>

    <!-- 用户输入的信息现在前端进行验证，验证一些简单的用户输入错误的信息 -->
    <!-- 错误信息提醒error  -->
    <style>
        .reg p .error {
            display: inline-block;
            background-color: #ffe8e0;
            color: #ff0000;
            height: 25px;
            line-height: 25px;
            padding: 0px 20px;
            margin-left: 20px;
        }

        .reg p input[type = "password"] {
            border: 1px solid #dbdbdb;
            font-size: 20px;
            padding-left: 10px;

        }
    </style>
</head>
<body><!-------------------reg-------------------------->
<div class="reg">
    <form action="register" method="post" onsubmit="return checkForm(this)"><h1><a href="index.html"><span style="font-size: 24px; font-family: 'Arial Black'">喵喵商城</span></a>
    </h1>
        <p style="font-size: 30px; background: #ff6600; color: white; text-align: center">用户注册</p>
        <p><b style="font-size: 20px">用&nbsp;&nbsp;户&nbsp;名：</b><input type="text" name="userName" value=""
                                                                       onblur="CheckItem(this)"
                                                                       placeholder="请输入用户名"><span></span>
        </p>

        <p><b style="font-size: 20px">姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</b><input type="text" name="name"
                                                                                              value=""
                                                                                              onfocus="FocusItem(this)"
                                                                                              onblur="CheckItem(this)"
                                                                                              placeholder="请输入姓名"><span></span>
        </p>

        <p><b style="font-size: 20px">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</b><input type="password"
                                                                                              name="passWord" value=""
                                                                                              onfocus="FocusItem(this)"
                                                                                              onblur="CheckItem(this)"
                                                                                              placeholder="请确认密码"><span></span>
        </p>

        <p><b style="font-size: 20px">确认密码：</b><input type="password" name="rePassWord" value=""
                                                      onfocus="FocusItem(this)" onblur="CheckItem(this)"
                                                      placeholder="请确认密码"><span></span>
        </p>

        <p style="font-size: 20px"><b style="font-size: 20px">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</b>
            <input style="width: 15px; height: 15px" type="radio" name="sex" value="T" checked="checked">男
            <input style="width: 15px; height: 15px" type="radio" name="sex" value="F">女
        </p>

        <p><b style="font-size: 20px">出生日期：</b><input type="text" name="birthday" value="" onfocus="calendar.show(this)"
                                                      placeholder="请输入出生日期"><span></span>
        </p>

        <p><b style="font-size: 20px">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱：</b><input type="text" name="email"
                                                                                              value=""
                                                                                              placeholder="请输入邮箱"><span></span>
        </p>

        <p><b style="font-size: 20px">手机号码：</b><input type="text" name="mobile" value="" onfocus="FocusItem(this)"
                                                      onblur="CheckItem(this)" placeholder="请输入手机号码"><span></span>
        </p>

        <p><b style="font-size: 20px">送货地址：</b><input type="text" name="address" value="" onfocus="FocusItem(this)"
                                                      onblur="CheckItem(this)" placeholder="请输入送货地址"><span></span>
        </p>

        <p><b style="font-size: 20px">输入验证码：</b><input class="code" type="text" name="veryCode" value=""
                                                       onfocus="FocusItem(this)" onblur="CheckItem(this)"
                                                       placeholder="验证码">
            <img src="getcode" alt="看不清，换一张" style="padding-top: 15px; margin-bottom: -8px; height: 30px"
                 onclick="change(this)"><span></span></p>
        <p><input type="submit" name="" value="注册"></p>

        <p class="txtL txt">完成此注册，即表明您同意了我们的<a href="#">
            《使用条款和隐私策略》
        </a></p>
        <p class="txt"><a href="#"><span></span>已有账号登录</a></p>
        <!--<a href="#" class="off"><img src="img/temp/off.png"></a>-->
    </form>
</div>
</body>
</html>
