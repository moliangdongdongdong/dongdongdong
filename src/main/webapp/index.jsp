<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/30
  Time: 上午2:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--jsp首页重定向错误--%>
<%--<% response.sendRedirect(request.getContextPath()+"/index");%>--%>
<html>
<head lang="en">
    <meta charset="utf-8"/>
    <title>喵喵商城</title>
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <link rel="stylesheet" type="text/css" href="css/index.css"/>
</head>
<body><!------------------------------head------------------------------>
<%@ include file="header.jsp"%>

<!-------------------------banner--------------------------->
<div class="block_home_slider">
    <div id="home_slider" class="flexslider">
        <ul class="slides">
            <li>
                <div class="slide"><img src="img/banner2.jpg"/></div>
            </li>
            <li>
                <div class="slide"><img src="img/banner1.jpg"/></div>
            </li>
        </ul>
    </div>
</div><!------------------------------thImg------------------------------>
<div class="thImg">
    <div class="clearfix"><a href="vase_proList.html"><img src="img/i1.jpg"/></a><a href="proList.html"><img
            src="img/i2.jpg"/></a><a href="#2"><img src="img/i3.jpg"/></a></div>
</div><!------------------------------news------------------------------>
<div class="news">
    <div class="wrapper"><h2><img src="img/ih1.jpg"/></h2>
        <div class="top clearfix"><a href="proDetail.html"><img src="img/n1.jpg"/>
            <p></p></a><a href="proDetail.html"><img src="img/n2.jpg"/>
            <p></p></a><a href="proDetail.html"><img src="img/n3.jpg"/>
            <p></p></a></div>
        <div class="bott clearfix"><a href="proDetail.html"><img src="img/n4.jpg"/>
            <p></p></a><a href="proDetail.html"><img src="img/n5.jpg"/>
            <p></p></a><a href="proDetail.html"><img src="img/n6.jpg"/>
            <p></p></a></div>
        <h2><img src="img/ih2.jpg"/></h2>
        <div class="flower clearfix tran"><a href="proDetail.html" class="clearfix">
            <dl>
                <dt><span class="abl"></span><img src="img/flo1.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/flo2.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/flo3.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a></div>
        <div class="flower clearfix tran"><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/flo4.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/flo5.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/flo6.jpg"/><span class="abr"></span></dt>
                <dd>【花艺】七头美丽玫瑰仿真花束</dd>
                <dd><span>¥ 79.00</span></dd>
            </dl>
        </a></div>
    </div>
</div><!------------------------------ad------------------------------><a href="#" class="ad"><img
        src="img/ib1.jpg"/></a><!------------------------------people------------------------------>
<div class="people">
    <div class="wrapper"><h2><img src="img/ih3.jpg"/></h2>
        <div class="pList clearfix tran"><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s7.jpg"/><span class="abr"></span></dt>
                <dd>【最家】不锈钢壁饰墙饰软装</dd>
                <dd><span>￥688.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s10.jpg"/><span class="abr"></span></dt>
                <dd>【最家】小城动物木板画壁挂北欧</dd>
                <dd><span>￥188.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s4.jpg"/><span class="abr"></span></dt>
                <dd>【最家】玄关假山水壁饰背景墙饰挂件创意</dd>
                <dd><span>￥599.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s9.jpg"/><span class="abr"></span></dt>
                <dd>【最家】金属树枝壁饰铜鸟装饰品</dd>
                <dd><span>￥928.00</span></dd>
            </dl>
        </a></div>
        <div class="pList clearfix tran"><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s6.jpg"/><span class="abr"></span></dt>
                <dd>【最家】金属壁饰创意背景墙面挂件创意</dd>
                <dd><span>￥228.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s8.jpg"/><span class="abr"></span></dt>
                <dd>【最家】小城动物木板画壁挂北欧</dd>
                <dd><span>￥199.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s12.jpg"/><span class="abr"></span></dt>
                <dd>【最家】欧式复古挂钟创意餐厅钟表家居挂件</dd>
                <dd><span>￥666.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s1.jpg"/><span class="abr"></span></dt>
                <dd>【最家】客厅地中海欧式现代相片墙创意</dd>
                <dd><span>￥59.80</span></dd>
            </dl>
        </a></div>
        <div class="pList clearfix tran"><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s5.jpg"/><span class="abr"></span></dt>
                <dd>【最家】铁艺荷叶壁挂软装背景墙上装饰品</dd>
                <dd><span>￥800.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s3.jpg"/><span class="abr"></span></dt>
                <dd>【最家】欧式照片墙 创意组合结婚礼物</dd>
                <dd><span>￥189.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s2.jpg"/><span class="abr"></span></dt>
                <dd>【最家】欧式钟表相框墙挂墙创意组合</dd>
                <dd><span>￥148.00</span></dd>
            </dl>
        </a><a href="proDetail.html">
            <dl>
                <dt><span class="abl"></span><img src="img/s11.jpg"/><span class="abr"></span></dt>
                <dd>【最家】小城动物木板画壁挂北欧</dd>
                <dd><span>￥188.00</span></dd>
            </dl>
        </a></div>
    </div>
</div><!--返回顶部-->
<div class="gotop"><a href="cart.html">
    <dl>
        <dt><img src="img/gt1.png"/></dt>
        <dd>去购<br/>物车</dd>
    </dl>
</a><a href="#" class="dh">
    <dl>
        <dt><img src="img/gt2.png"/></dt>
        <dd>联系<br/>客服</dd>
    </dl>
</a><a href="mygxin.html">
    <dl>
        <dt><img src="img/gt3.png"/></dt>
        <dd>个人<br/>中心</dd>
    </dl>
</a><a href="#" class="toptop" style="display: none">
    <dl>
        <dt><img src="img/gt4.png"/></dt>
        <dd>返回<br/>顶部</dd>
    </dl>
</a>
    <p>400-800-8200</p></div><!-------------------login--------------------------><!--footer-->
<div class="footer">
    <div class="top">
        <div class="wrapper">
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot1.png"/></a><span class="fl">7天无理由退货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot2.png"/></a><span class="fl">15天免费换货</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot3.png"/></a><span class="fl">满599包邮</span>
            </div>
            <div class="clearfix"><a href="#2" class="fl"><img src="img/foot4.png"/></a><span class="fl">手机特色服务</span>
            </div>
        </div>
    </div>
    <p class="dibu">最家家居&copy;2013-2017公司版权所有 京ICP备080100-44备0000111000号<br/>
        违法和不良信息举报电话：400-800-8200，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p></div>
<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>
<script src="js/nav.js" type="text/javascript" charset="utf-8"></script>
<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
</body>
</html>
