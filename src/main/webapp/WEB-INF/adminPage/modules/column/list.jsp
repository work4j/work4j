<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>程序员社区后台</title>
    <!-- 头部 -->
    <%@ include file="/WEB-INF/adminPage/common/head_admin.jsp" %>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <!-- 导航栏 -->
    <jsp:include page="/WEB-INF/adminPage/common/nav_admin.jsp"/>
    <!-- 菜单栏  param::root 菜单栏选项卡定位参数 -->
    <jsp:include page="/WEB-INF/adminPage/common/menu_admin.jsp" flush="true">
        <jsp:param value="column" name="root"/>
    </jsp:include>
    <!-- 内容 -->
    <div class="layui-body site-demo">
        <div class="layui-main">
            <!--/***** 面包屑 *****/-->
            <div class="layui-elem-quote" style="margin-top: 10px;">
					<span class="layui-breadcrumb"> <a><cite>栏目管理</cite></a> <a><cite>列表</cite></a>
					</span>
            </div>
            <blockquote class="layui-elem-quote layui-quote-nm" style="color: #FF5722">
                <i class="layui-icon">&#xe60b;</i> 程序员社区栏目列表。
            </blockquote>
            <!--/*******操作*******/-->
            <form action="list" method="get">
                <div class="layui-form-item">
                    <blockquote class="layui-elem-quote layui-quote-nm">
                        <div class="layui-inline">
                            <div class="layui-input-inline">
                                <a href="add" class="layui-btn"><i class="layui-icon">&#xe61f;</i> 新增</a>
                            </div>
                        </div>
                        <div class="layui-inline" style="float: right;">
                            <div class="layui-input-inline" style="width: 200px;">
                                <input type="search" id="search" name="search" placeholder="关键字" autocomplete="off"
                                       class="layui-input">
                            </div>
                            <button class="layui-btn" lay-submit="" lay-filter="searchForm">
                                <i class="layui-icon">&#xe615;</i>
                            </button>
                        </div>
                    </blockquote>
                </div>
            </form>
            <!--/***** 列表 *****/-->
            <table class="layui-table" lay-even="" lay-skin="row">
                <thead id="dataTable">
                <tr>
                    <th style="text-align: center; width: 40px">#</th>
                    <th style="text-align: center;">状态</th>
                    <th style="text-align: center;">名称</th>
                    <th style="text-align: center; width: 140px">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${result == null || result.size() == 0}">
                    <tr>
                        <td colspan="4" style="text-align: center;">暂时没有数据</td>
                    </tr>
                </c:if>
                <c:if test="${result != null && result.size() != 0}">
                    <c:forEach var="item" items="${result}" varStatus="items">
                        <tr>
                            <td style="text-align: center;">${items.count }</td>
                            <td class="layui-form" style="text-align: center;width: 200px">
                                <input lay-filter="filter" id="${item.id}" lay-skin="switch"
                                       type="checkbox" ${item.enabled==1?'checked':''}>
                            </td>
                            <td style="text-align: center;">${item.name }</td>
                            <td style="text-align: center;">
                                <a class="layui-btn layui-btn-small layui-btn-primary"
                                   href="detail_${item.id}">
                                    <i class="layui-icon">&#xe615;</i></a>
                                <a class="layui-btn layui-btn-small"
                                   href="edit_${item.id}">
                                    <i class="layui-icon">&#xe642;</i></a>
                                <a class="layui-btn layui-btn-small layui-btn-normal"
                                   onclick="del('delete_${item.id}')">
                                    <i class="layui-icon"> &#xe640;</i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <div id="pageDiv"></div>
        </div>
    </div>
    <!-- 底部 -->
    <jsp:include page="/WEB-INF/adminPage/common/footer_admin.jsp"/>
    <!-- 公告js文件 -->
    <jsp:include page="/WEB-INF/adminPage/common/import_js_admin.jsp"/>
</div>
<jsp:include page="/WEB-INF/adminPage/common/list_js_admin.jsp"/>
<!-- 当前页js代码 -->
<script type="text/javascript">

</script>
</body>
</html>