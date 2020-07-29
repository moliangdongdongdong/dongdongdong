<%--
  Created by IntelliJ IDEA.
  User: kgc
  Date: 2020/6/23
  Time: 上午1:01
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
        <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a
                class="crumb-name" href="admin_user.jsp">商品管理</a><span class="crumb-step">&gt;</span><span>新增商品</span>
        </div>
    </div>
    <div class="result-wrap">
        <div class="result-content">
            <form action="${pageContext.request.contextPath}/manage/admin_doproductadd" enctype="multipart/form-data" method="post" id="myform"
                  name="myform">
                <table class="insert-tab" width="100%">
                    <tbody>



                    <tr>
                        <th><i class="require-red">*</i>商品分类：</th>
                        <td>
                            <select class="common-text required" name="parentId"  style="width: 180px; height: 30px">
                                <c:forEach var="flist" items="${flist}">
                                    <option value="${flist.cate_id}" disabled="disabled">>>>${flist.cate_name}</option>

                                    <c:forEach var="clist" items="${clist}">
                                        <c:if test="${clist.cate_parent_id == flist.cate_id}" >
                                             <option value="${flist.cate_id}-${clist.cate_id}" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${clist.cate_name}</option>
                                         </c:if>
                                    </c:forEach>
                                </c:forEach>

                            </select>
                        </td>
                    </tr>

                    <tr>
                        <th><i class="require-red">*</i>商品名称：</th>
                        <td>
                            <input class="common-text required" id="title" name="productname" size="50" value=""
                                   type="text">
                        </td>
                    </tr>

                    <tr>
                        <th><i class="require-red">*</i>商品图片：</th>
                        <td>
                            <input class="common-text required" id="title" name="productphoto" size="50" value=""
                                   type="file" style="height: 30px">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品价格：</th>
                        <td>
                            <input class="common-text required" id="title" name="productprice" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品介绍：</th>
                        <td>
                            <input class="common-text required" id="title" name="productdesc" size="50" value=""
                                   type="text">
                        </td>
                    </tr>
                    <tr>
                        <th><i class="require-red">*</i>商品库存：</th>
                        <td>
                            <input class="common-text required" id="title" name="productstock" size="50" value=""
                                   type="text">
                        </td>
                    </tr>

                    <tr>
                        <th></th>
                        <td>
                            <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                            <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                        </td>
                    </tr>
                    </tbody>
                </table>
            </form>
        </div>
    </div>

</div>
<!--/main-->
</div>
</body>
</html>
