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
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <a class="logo" href="javacript:void(0);" onclick="layer.msg('欢迎来到程序员社区')"> <img
                    src="${pageContext.request.contextPath}/resources/others/fly/images/logo-1.png" alt="layui">
            </a>
            <ul class="layui-nav">
                <li class="layui-nav-item "><a href="/programer">社区</a></li>
                <li class="layui-nav-item layui-this"><a href="javascript:void(0);">演示</a></li>
                <span class="layui-nav-bar" style="left: 240px; top: 65px; width: 0px; opacity: 0;"></span>
            </ul>
        </div>
    </div>
    <!-- 导航栏 -->
    <!-- 菜单栏  param::root 菜单栏选项卡定位参数 -->
    <jsp:include page="/WEB-INF/adminPage/common/menu_admin.jsp" flush="true">
        <jsp:param value="article" name="root"/>
    </jsp:include>
    <!-- 内容 -->
    <div class="layui-body site-demo">
        <div class="layui-main">
            <!--/***** 面包屑 *****/-->
            <div class="layui-elem-quote" style="margin-top: 10px;">
					<span class="layui-breadcrumb"> <a><cite>文章管理</cite></a> <a><cite>列表</cite></a>
					</span>
            </div>
            <blockquote class="layui-elem-quote layui-quote-nm" style="color: #FF5722">
                <i class="layui-icon">&#xe60b;</i> 程序员社区文章列表。
            </blockquote>
            <!--/*******操作*******/-->
            <form action="showArticleList" method="get">
                <div class="layui-form-item">
                    <blockquote class="layui-elem-quote layui-quote-nm" style="height: 43px">
                        <div class="layui-inline" style="float: right;">
                            <div class="layui-input-inline" style="width: 200px;">
                                <input type="search" id="simpleQueryParam" name="simpleQueryParam" placeholder="关键字"
                                       autocomplete="off" class="layui-input">
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
                    <th style="text-align: center;">标题</th>
                    <th style="text-align: center;">发布人</th>
                    <th style="text-align: center;">发布时间</th>
                    <th style="text-align: center; width: 140px">操作</th>
                </tr>
                </thead>
                <tbody>
                <c:if test="${result == null || result.size() == 0}">
                    <tr>
                        <td colspan="5" style="text-align: center;">暂时没有数据</td>
                    </tr>
                </c:if>
                <c:if test="${result != null && result.size() != 0}">
                    <c:forEach var="item" items="${result}" varStatus="items">
                        <tr>
                            <td style="text-align: center;">${items.count }</td>
                            <td style="text-align: center;">${item.title }</td>
                            <td style="text-align: center;">${item.nickname }</td>
                            <td style="text-align: center;"><fmt:formatDate value="${item.releaseTime }"
                                                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td style="text-align: center;"><a class="layui-btn layui-btn-small layui-btn-normal"
                                                               href="delete_${item.id}"> <i class="layui-icon">
                                &#xe640;</i>
                            </a></td>
                        </tr>
                    </c:forEach>
                </c:if>
                <%-- <tr th:each="item,items:${taskList.records}">
                    <td th:text="${taskList.pageSize*(taskList.page-1)+items.index+1}" style="text-align: center;">序号</td>
                    <td th:text="${#strings.abbreviate(item.title,13)}">类别</td>
                    <td th:text="${#strings.abbreviate(item.content,23)}">内容</td>
                    <td style="text-align: center;" th:text="${item.releaseTimeStr}">发布时间</td>
                    <td style="text-align: center;" th:switch="${item.status}"><span style="color: #009688; font-weight: bold;" th:case="1">进行中</span> <span style="color: #FF0000; font-weight: bold;" th:case="2">超时</span> <span style="color: #1E9FFF; font-weight: bold;" th:case="3">未通过</span> <span
                        style="color: #EEB422; font-weight: bold;" th:case="4">等待审核</span> <span style="color: #B0B0B0; font-weight: bold;" th:case="5">已关闭</span> <span style="font-weight: bold;" th:case="null">未领取</span></td>
                    <td style="text-align: center;"><a class="layui-btn layui-btn-small layui-btn-primary" th:href="@{/manage/m/task/show_{id}.htm(id=${item.id})}"><i class="layui-icon">&#xe615;</i></a><a class="layui-btn layui-btn-small" th:classappend="${item.status==null}?'':'layui-btn-disabled'"
                        th:href="${item.status==null}?@{/manage/m/task/edit_{id}.htm(id=${item.id})}:'javascript:void(0)'"><i class="layui-icon">&#xe642;</i></a>
                        <button class="layui-btn layui-btn-small layui-btn-normal" th:onclick="|deleted('${item.id}')|">
                            <i class="layui-icon">&#xe640;</i>
                        </button></td>
                </tr> --%>
                </tbody>
            </table>
            <div id="pageDiv"></div>
        </div>
        <!-- <fieldset class="layui-elem-field layui-field-title" style="margin-top: 50px;">
            <legend>其它</legend>
        </fieldset> -->
        <div class="layui-elem-quote" style="margin-top: 20px;">
            <p>Layui - 精心为你雕琢</p>
        </div>
    </div>
    <!-- 底部 -->
    <jsp:include page="/WEB-INF/adminPage/common/footer_admin.jsp"/>
    <!-- 公告js文件 -->
    <jsp:include page="/WEB-INF/adminPage/common/import_js_admin.jsp"/>
</div>
<!-- 当前页js代码 -->
<script type="text/javascript">
    $("#simpleQueryParam").val(GetQueryString("simpleQueryParam"));
    var option = {
        listUrl: "showArticleList?",
        totalPages: ${result.getPages()},
        page: ${result.getPageNum()},
        param: {
            simpleQueryParam
        }
    };
    tg_basePage(option);
</script>
</body>
</html>