<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/30
  Time: 上午2:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<div class="head">
    <div class="wrapper clearfix">
        <div class="clearfix" id="top"><h1 class="fl"><a href="index.jsp"><span
                style="font-family: 'Courier New'; font-size: 30px; color: #da4f49" class="logoMiaoMiao">喵喵商城</span></a>
        </h1>
            <div class="fr clearfix" id="top1">
                <p class="fl">
                    <%-- 在serlet中Login类中做了一个点，直接调用，不等于1,回到登录或注册界面--%>
                    <c:if test="${isLogin != 1}">
                        <a href="login.jsp" id="login">登录</a><a href="reg.jsp" id="reg">注册</a>
                    </c:if>

                    <%--  在serlet中Login类中做了一个点，标记位，直接调用，等于1,还在首页--%>
                    <c:if test="${isLogin == 1}">
                        <b>您好:</b><a href="login.jsp" id="login">${name.user_id}</a><b>欢迎来到喵喵商城！</b>
                    </c:if>

                    <%--  在serlet中后台登录Login类中也做了一个点，标记位置，直接调用，等于1,还在首页--%>
                    <c:if test="${isAdminLogin == 1}">
                        <a href="${pageContext.request.contextPath}/manage/admin_index.jsp" id="login1"><b>进入后台管理</b></a>
                    </c:if>

                </p>
                <form action="#" method="get" class="fl"><input type="text" placeholder="热门搜索：干花花瓶"/><input
                        style="margin-top: -20px;"
                        type="button"/></form>
                <div class="btn fl clearfix"><a href="mygxin.jsp"><img src="img/grzx.png"/></a><a href="#" class="er1">
                    <img src="img/ewm.png"/></a>

                    <c:if test="${isLogin == 1}">
                        <a href="cart.html"><img src="img/gwc.png"/></a>
                    </c:if>


                    <p><a href="#"><img src="img/ewm.png"/></a></p></div>
            </div>
        </div>
        <ul class="clearfix" id="bott">
            <li><a href="${pageContext.request.contextPath}/indexselect" style="font-size: 30px">首页</a></li>
                <c:forEach var="flist" items="${flist}">
                    <li><a href="selectproductlist?fid=${flist.cate_id}">${flist.cate_name}</a>
                        <div class="sList2">
                            <div class="clearfix">
                                <c:forEach var="clist" items="${clist}">
                                    <c:if test="${flist.cate_id == clist.cate_parent_id}">
                                        <a href="selectproductlist?cid=${clist.cate_id}">${clist.cate_name}</a>
                                    </c:if>
                                </c:forEach>
                            </div>
                        </div>
                    </li>
                </c:forEach>

        </ul>
    </div>
</div>
