<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/23
  Time: 上午1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="admin_menu.jsp"%>
    <!--/sidebar-->
    <div class="main-wrap">
        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>欢迎来到『喵喵商城』，插花的首选网址。</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="insert.html"><i class="icon-font">&#xe001;</i>新增商品</a>
                    <a href="insert.html"><i class="icon-font">&#xe005;</i>新增样式</a>
                    <a href="insert.html"><i class="icon-font">&#xe048;</i>新增商品分类</a>
                    <a href="insert.html"><i class="icon-font">&#xe041;</i>新增样式分类</a>
                    <a href="#"><i class="icon-font">&#xe01e;</i>商品评论</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>系统基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">操作系统</label><span class="res-info">LINUX</span>
                    </li>
                    <li>
                        <label class="res-lab">运行环境</label><span class="res-info">/Tomcat 9.0.35/JDK VERSION 14.0</span>
                    </li>
                    <li>
                        <label class="res-lab">JAVA运行方式</label><span class="res-info">SPRING MVC/MAVEN</span>
                    </li>
                    <li>
                        <label class="res-lab">莫良咚咚咚设计-版本</label><span class="res-info">v-0.1</span>
                    </li>
                    <li>
                        <label class="res-lab">上传附件限制</label><span class="res-info"><<<<>>>></span>
                    </li>
                    <li>
                        <label class="res-lab">北京时间</label><span class="res-info">2020年06月30日 22:18:24</span>
                    </li>
                    <li>
                        <label class="res-lab">服务器域名/IP</label><span class="res-info">localhost [ 192.168.1.113 ]</span>
                    </li>
                    <li>
                        <label class="res-lab">Host</label><span class="res-info">127.0.0.1</span>
                    </li>
                </ul>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>使用帮助</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                    <li>
                        <label class="res-lab">更多商品：</label><span class="res-info"><a href="${pageContext.request.contextPath}/index.jsp" target="_blank">喵喵商城</a></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>
