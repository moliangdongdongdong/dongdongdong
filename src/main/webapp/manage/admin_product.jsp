<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/30
  Time: 下午16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入标签库--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<%@ include file="admin_menu.jsp" %>

<!--/sidebar-->
<div class="main-wrap">

    <div class="crumb-wrap">
        <div class="crumb-list"><i class="icon-font"></i><a href="index.html">首页</a><span
                class="crumb-step">&gt;</span><span class="crumb-name">商品管理</span></div>
    </div>

    <div class="result-wrap">
        <form action="${pageContext.request.contextPath}/manage/admin_douserdel" id="myform" method="post">
            <div class="result-title">
                <div class="result-list">
                    <%-- 直接到servlet中访问页面--%>
                    <a href="${pageContext.request.contextPath}/manage/admin_toproductadd"><i class="icon-font"></i>新增商品</a>

                    <%--<a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a>--%>
                </div>
            </div>
            <div class="result-content">
                <table class="result-tab" width="60%">
                    <tr>
                        <th>ID</th>
                        <th>商品名称</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach var="plist" items="${plist}">
                        <tr>
                            <td>${plist.product_id}</td>
                            <td><img src="../images/product/${plist.product_filename}" width="80px" height="80px" />${plist.product_name}</td>
                            <td>
                                <a href="">修改</a>
                                <a href="">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                    <script>
                        function catedel(id) {
                            if (confirm("你确定要删除这个分类吗？")) {
                                location.href = "admin_docatedel?id=" + id;
                            }
                        }
                    </script>
                </table>

                <%--                <div class="list-page" style="font-size: 18px; font-family: 'Arial Black'">--%>
                <%--                    共${tsum}条记录，当前${cpage}/${tpage}页--%>
                <%--                    <a href="${pageContext.request.contextPath}/manage/admin_douserselect?cp=1${searchParams}">首页</a>--%>
                <%--                    <a href="${pageContext.request.contextPath}/manage/admin_douserselect?cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>--%>
                <%--                    <a href="${pageContext.request.contextPath}/manage/admin_douserselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>--%>
                <%--                    <a href="${pageContext.request.contextPath}/manage/admin_douserselect?cp=${tpage}${searchParams}">尾页</a>--%>

                <%--                </div>--%>
            </div>
        </form>
    </div>
</div>
<!--/main-->
</div>
</body>
</html>
