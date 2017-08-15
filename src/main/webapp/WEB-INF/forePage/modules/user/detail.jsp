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
        <i class="iconfont ${result.sex==1?'icon-nan':'icon-nv'}"></i>
        <!-- <i class="iconfont icon-nv"></i> -->

        <!-- <span style="color:#c00;">（超级码农）</span>
        <span style="color:#5FB878;">（活雷锋）</span>
        <span>（该号已被封）</span> -->
    </h1>
    <p class="fly-home-info">
        <i class="iconfont icon-zuichun" title="飞吻"></i><span style="color: #FF7200;">${result.email }</span>
        <i class="iconfont icon-shijian"></i><span><fmt:formatDate value="${result.registerTime}" pattern="yyyy-MM-dd"/> 加入</span>
        <i class="iconfont icon-chengshi"></i><span>来自${result.city}</span>
    </p>
    <p class="fly-home-sign">（${result.sign == null ?'什么也没有留下':result.sign}）</p>
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
                                <span><fmt:formatDate value="${item.replyTime }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                在<a href="${pageContext.request.contextPath}/fore/article/detail_${item.articleId }"
                                    target="_blank">${item.title }</a>中评论：
                            </p>
                            <div class="home-dacontent">${item.content }</div>
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
    layui.cache.page = 'jie';
    layui.cache.user = {
        username: '游客'
        , uid: -1
        , avatar: '${pageContext.request.contextPath}/resources/others/fly/images/avatar/00.jpg'
        , experience: 83
        , sex: '男'
    };
    layui.config({
        version: "2.0.0"
        , base: '${pageContext.request.contextPath}/resources/others/fly/mods/'
    }).extend({
        fly: 'index'
    }).use('fly', function () {
        var fly = layui.fly;
        $('.home-dacontent').each(function () {
            var othis = $(this), html = othis.html();
            othis.html(fly.content(html));
        });
    });
</script>
<ul class="fly-rbar">
    <li id="F_topbar" class="iconfont icon-top" method="top"></li>
</ul>
</body>
</html>