<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
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
<div class="fly-home" style="background-image: url();">
    <img src="http://tp4.sinaimg.cn/1345566427/180/5730976522/0" alt="${result.nickname }">
    <h1>
        ${result.nickname }
        <i class="iconfont icon-nan"></i>
        <!-- <i class="iconfont icon-nv"></i> -->

        <!-- <span style="color:#c00;">（超级码农）</span>
        <span style="color:#5FB878;">（活雷锋）</span>
        <span>（该号已被封）</span> -->
    </h1>
    <p class="fly-home-info">
        <i class="iconfont icon-zuichun" title="飞吻"></i><span style="color: #FF7200;">67206飞吻</span>
        <i class="iconfont icon-shijian"></i><span>2015-06-17 加入</span>
        <i class="iconfont icon-chengshi"></i><span>来自杭州</span>
    </p>
    <p class="fly-home-sign">（人生仿若一场修行）</p>
</div>

<div class="main fly-home-main">
    <div class="layui-inline fly-home-jie">
        <div class="fly-panel">
            <h3 class="fly-panel-title">${result.nickname } 最近的发文</h3>
            <c:if test="${articles.size() == 0 }">
                <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><i style="font-size:14px;">没有发表任何文章</i>
                </div>
            </c:if>
            <c:if test="${articles.size() > 0 }">
                <ul class="jie-row">
                    <c:forEach var="item" items="${articles }" varStatus="items">
                        <li>
                                <%--<span class="fly-jing">精</span>--%>
                            <a href="${pageContext.request.contextPath}/fore/article/detail_${item.id }"
                               class="jie-title">${item.title }</a>
                            <i><fmt:formatDate value="${item.releaseTime }" pattern="yyyy-MM-dd HH:mm:ss"/></i>
                            <em>${item.seeNum }阅/${item.replyNum }答</em>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
            <div id="pageDiv"></div>
        </div>
    </div>
    <div class="layui-inline fly-home-da">
        <div class="fly-panel">
            <h3 class="fly-panel-title">${result.nickname } 最近的评论</h3>
            <c:if test="${replys.size() == 0 }">
                <div class="fly-none" style="min-height: 50px; padding:30px 0; height:auto;"><span>没有评论任何文章</span></div>
            </c:if>
            <c:if test="${replys.size() > 0 }">
                <ul class="home-jieda">
                    <c:forEach var="item" items="${replys }" varStatus="items">
                        <li>
                            <p>
                                <span>1分钟前</span>
                                在<a href="" target="_blank">tips能同时渲染多个吗?</a>中回答：
                            </p>
                            <div class="home-dacontent">
                                尝试给layer.photos加上这个属性试试：
                                <pre>
full: true
</pre>
                                文档没有提及
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>
    </div>

</div>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/footer_fore.jsp"></jsp:include>
<!-- 公共js -->
<jsp:include page="/WEB-INF/forePage/common/import_js_fore.jsp"></jsp:include>
<!-- 当前页面js -->
<script type="text/javascript">
    var arr = window.location.href.split('?');
    var ar = arr[0];
    var option = {
        listUrl: ar + '?',
        totalPages: ${articles.getPages()},
        page: ${articles.getPageNum()},
        param: {}
    };
    tg_basePage(option);
</script>
<ul class="fly-rbar">
    <li id="F_topbar" class="iconfont icon-top" method="top"></li>
</ul>
</body>
</html>