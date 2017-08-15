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
    <jsp:param value="article" name="root" />
</jsp:include>
<div class="main layui-clear">
    <div class="wrap">
        <div class="content">
            <div class="fly-tab fly-tab-index">
                <span> <a ${column == null ?"class=tab-this":""} href="list">全部</a>
                    <c:forEach var="item" items="${columns}">
                        <a ${column == item.code ?"class=tab-this":""} href="list?column=${item.code}">${item.name}</a>
                    </c:forEach>
					</span>
                <form id="searchForm" class="fly-search">
                    <i class="iconfont icon-sousuo"></i> <input class="layui-input search" autocomplete="off"
                                                                placeholder="搜索内容，回车跳转" type="text"
                                                                id="search" name="search">
                </form>
                <a href="add" class="layui-btn jie-add">发布文章</a>
            </div>
            <ul class="fly-list fly-list-top">
                <c:if test="${result.size() == 0 }">
                    <li class="fly-none">没有任何文章</li>
                </c:if>
                <c:forEach var="item" items="${result }" varStatus="items">
                    <li class="fly-list-li"><a href="${pageContext.request.contextPath}/fore/user/detail_${item.userId }" class="fly-list-avatar"> <img
                            src="http://q.qlogo.cn/qqapp/101235792/3F2CF40CCA8313F4CC8C4A7044B2ADB4/100"
                            alt="${item.nickname}">
                    </a>
                        <h2 class="fly-tip">
                            <a href="detail_${item.id }">${item.title }</a> <%--<span class="fly-tip-stick">置顶</span>--%>
                        </h2>
                        <p>
                            <span><a href="${pageContext.request.contextPath}/fore/user/detail_${item.userId }">${item.nickname }</a></span> <span><fmt:formatDate
                                value="${item.releaseTime }" pattern="yyyy-MM-dd"/> </span>
                            <c:forEach var="tag" items="${item.tags}"><span>${tag.name}</span></c:forEach>
                            <span
                                    class="fly-list-hint"> <i class="iconfont" title="回答"></i> ${item.replyNum } <i
                                    class="iconfont" title="人气"></i>
									${item.seeNum }
								</span>
                        </p></li>
                </c:forEach>
            </ul>
            <div style="text-align: center; background-color: #ffffff">
                <div id="pageDiv"></div>
            </div>
        </div>
    </div>
    <div class="edge">
        <div class="fly-panel leifeng-rank">
            <h3 class="fly-panel-title">发帖排行榜 - TOP 12</h3>
            <div class="user-looklog leifeng-rank">
				<span> <c:forEach var="item" items="${top12 }" varStatus="items">
						<a href="${pageContext.request.contextPath}/fore/user/detail_${item.userId }"> <img
                                src="http://q.qlogo.cn/qqapp/101235792/3F2CF40CCA8313F4CC8C4A7044B2ADB4/100"> <cite>${item.nickname }</cite> <i>${item.articleNum }次发帖</i>
						</a>
                </c:forEach>
				</span>
            </div>
        </div>
        <dl class="fly-panel fly-list-one">
            <dt class="fly-panel-title">最近热帖</dt>
            <dd>
                <c:forEach var="item" items="${top15 }" varStatus="items">
                    <a href="detail_${item.id }">${item.title }</a>
                    <span><i class="iconfont">&#xe60b;</i> ${item.replyNum }</span>
                </c:forEach>
            </dd>
        </dl>
        <div class="fly-panel fly-link">
            <h3 class="fly-panel-title">友情链接</h3>
            <dl>
                <dd>
                    <a href="http://www.layui.com/" target="_blank">layui</a>
                </dd>
                <dd>
                    <a href="http://layim.layui.com/" target="_blank">LayIM</a>
                </dd>
                <dd>
                    <a href="http://layer.layui.com/" target="_blank">layer</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/footer_fore.jsp"></jsp:include>
<!-- 公共js -->
<jsp:include page="/WEB-INF/forePage/common/import_js_fore.jsp"></jsp:include>
<!-- 当前页面js -->
<script>

    $('.icon-sousuo').unbind();
    $('.icon-sousuo').bind('click', function () {
        $("#searchForm").submit();
    });
    $('.search').keydown(function(e){
        if(e.keyCode==13){
            $("#searchForm").submit();
        }
    });

    $("#search").val(GetQueryString("search"));
    var url = "list?";
    if (GetQueryString('column') != null) {
        url = url + "&column=" + GetQueryString('column');
        $("#searchForm").append('<input type="text" hidden="hidden" name="column" value="' + GetQueryString('column') + '"/>');
    }
    if (GetQueryString('tag') != null) {
        url = url + "&tag=" + GetQueryString('tag');
        $("#searchForm").append('<input type="text" hidden="hidden" name="tag" value="' + GetQueryString('tag') + '"/>');
    }
    url = url.replace("?&", "?");
    var option = {
        listUrl: url,
        totalPages: ${result.getPages()},
        page: ${result.getPageNum()},
        param: {
            search
        }
    };
    tg_basePage(option);
</script>
<ul class="fly-rbar">
    <li id="F_topbar" class="iconfont icon-top" method="top"></li>
</ul>
</body>
</html>