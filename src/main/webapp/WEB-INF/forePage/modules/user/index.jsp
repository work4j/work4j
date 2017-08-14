<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>程序员社区</title>
    <!-- 头部 -->
    <%@ include file="/WEB-INF/forePage/common/head_fore.jsp" %>
</head>
<body>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/nav_fore.jsp" flush="true">
    <jsp:param value="article" name="root"/>
</jsp:include>
<div class="main fly-user-main layui-clear">
    <ul class="layui-nav layui-nav-tree layui-inline" lay-filter="user">
        <li class="layui-nav-item">
            <a href="detail_${sessionScope.currentUser.id }">
                <i class="layui-icon">&#xe609;</i>
                我的主页
            </a>
        </li>
        <li class="layui-nav-item layui-this">
            <a href="index">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="set">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
        <li class="layui-nav-item">
            <a href="message">
                <i class="layui-icon">&#xe611;</i>
                我的消息
            </a>
        </li>
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="fly-panel fly-panel-user" pad20>
        <!--
        <div class="fly-msg" style="margin-top: 15px;">
          您的邮箱尚未验证，这比较影响您的帐号安全，<a href="activate.html">立即去激活？</a>
        </div>
        -->
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this">我发的帖（<span>${result.size() }</span>）</li>
                <li>
                    <a href="${pageContext.request.contextPath}/fore/user/collection">我收藏的帖（<span>${result.size() }</span>）</a>
                </li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <ul class="mine-view jie-row">
                        <c:if test="${result.size() == 0 }">
                            <li class="fly-none">没有任何文章</li>
                        </c:if>
                        <c:forEach var="item" items="${result }" varStatus="items">
                            <li>
                                <a class="jie-title"
                                   href="${pageContext.request.contextPath}/fore/article/detail_${item.id }"
                                   target="_blank">${item.title }</a>
                                <i><fmt:formatDate value="${item.releaseTime }" pattern="yyyy-MM-dd HH:mm:ss"/> </i>
                                <a class="mine-edit"
                                   href="${pageContext.request.contextPath}/fore/article/edit_${item.id }">编辑</a>
                                <em>${item.seeNum }阅/${item.replyNum }答</em>
                            </li>
                        </c:forEach>
                    </ul>
                    <div id="pageDiv"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/footer_fore.jsp"></jsp:include>
<!-- 公共js -->
<jsp:include page="/WEB-INF/forePage/common/import_js_fore.jsp"></jsp:include>
<!-- 当前页面js -->
<script>
    var option = {
        listUrl: "index?",
        totalPages: ${result.getPages()},
        page: ${result.getPageNum()},
        param: {}
    };
    tg_basePage(option);
</script>
<ul class="fly-rbar">
    <li id="F_topbar" class="iconfont icon-top" method="top"></li>
</ul>
</body>
</html>