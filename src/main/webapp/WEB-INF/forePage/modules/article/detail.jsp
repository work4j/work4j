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
<div class="main layui-clear">
    <div class="wrap">
        <div class="content detail">
            <div class="fly-panel detail-box">
                <h1>${result.title }</h1>
                <div class="fly-tip fly-detail-hint" data-id="6711">
                    <c:if test="${result.tags.size() == 0}">
                        <span style="background-color: #fff"></span>
                    </c:if>
                    <c:forEach var="item" items="${result.tags }">
                        <span>${item.name} </span>
                    </c:forEach>
                    <div class="fly-list-hint">
                        <i class="iconfont" title="回答"></i> ${result.replyNum } <i class="iconfont"
                                                                                    title="人气"></i> ${result.seeNum }
                    </div>
                </div>
                <div class="detail-about">
                    <a class="jie-user" href="http://fly.layui.com/u/168/"> <img
                            src="http://q.qlogo.cn/qqapp/101235792/3F2CF40CCA8313F4CC8C4A7044B2ADB4/100"
                            alt="${result.nickname }"> <cite> ${result.nickname }
                        <em>发布于<fmt:formatDate value="${result.releaseTime }" pattern="yyyy-MM-dd HH:mm:ss"/></em>
                    </cite>
                    </a>
                    <div class="detail-hits" id="LAY_jieAdmin" data-id="6711">
                        <span style="color: #FF7200">悬赏：5飞吻</span>
                        <c:if test="${!collection}">
                            <span class="layui-btn layui-btn-mini jie-admin " id="${result.id }"
                                  onclick="collection(this)">收藏</span>
                        </c:if>
                        <c:if test="${collection}">
                            <span class="layui-btn layui-btn-mini jie-admin layui-btn-danger" id="${result.id }"
                                  onclick="collection(this)">取消收藏</span>
                        </c:if>
                        <c:if test="${result.userId == sessionScope.currentUser.id}">
                            <a href="edit_${result.id}" class="layui-btn layui-btn-mini jie-admin" type="button">修改</a>
                        </c:if>
                    </div>
                </div>
                <div class="detail-body photos" style="margin-bottom: 20px;">${result.content }</div>
            </div>
            <div class="fly-panel detail-box" style="padding-top: 0;">
                <a name="comment"></a>
                <ul class="jieda photos" id="jieda">
                    <c:if test="${replys.size() == 0 }">
                        <li id="none" class="fly-none">没有任何评论</li>
                    </c:if>
                    <c:forEach var="item" items="${replys }">
                        <li id="${item.id}">
                            <div class="detail-about detail-about-reply">
                                <a class="jie-user" href="javascript:void(0)"> <img
                                        src="http://q.qlogo.cn/qqapp/101235792/3F2CF40CCA8313F4CC8C4A7044B2ADB4/100"
                                        alt="${item.nickname }"
                                        layer-index="1"> <cite> <i>${item.nickname }</i>
                                    <!--  <em style="padding: 0; color: #FF7200;">VIP2</em> -->
                                </cite>
                                </a>
                                <div class="detail-hits">
                                    <span><fmt:formatDate value="${item.replyTime }"
                                                          pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                </div>
                            </div>
                            <c:if test="${item.toReply != null}">
                                <div class="reply_my" style="margin-top: 20px">
                                    <div style="float: left;width: 45px">
                                        回复：
                                    </div>
                                    <div style="overflow: hidden;">
                                        <blockquote class="layui-elem-quote">
                                            <div class="detail-about detail-about-reply">
                                                <a class="jie-user" href="javascript:void(0)"> <img
                                                        src="http://q.qlogo.cn/qqapp/101235792/3F2CF40CCA8313F4CC8C4A7044B2ADB4/100"
                                                        alt="${item.toReply.nickname }"
                                                        layer-index="1"> <cite> <i>${item.toReply.nickname }</i>
                                                    <!--  <em style="padding: 0; color: #FF7200;">VIP2</em> -->
                                                </cite>
                                                </a>
                                                <div class="detail-hits">
                                    <span><fmt:formatDate value="${item.toReply.replyTime }"
                                                          pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                                </div>
                                            </div>
                                            <div class="detail-body jieda-body">${item.toReply.content }</div>
                                        </blockquote>
                                    </div>
                                </div>
                            </c:if>
                            <div class="detail-body jieda-body">${item.content }</div>
                            <div class="jieda-reply-my">
								<span class="jieda-zan " type="zan"> <i class="iconfont icon-zan"></i> <em>0</em>
								</span> <span onclick="reply(this)"> <i class="iconfont icon-svgmoban53"></i> 回复
								</span>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
                <div>
                    <div id="pageDiv"></div>
                </div>
                <div id="replyDiv" style="margin-top: 20px;margin-bottom: 20px;display: none">
                    <div style="float: left;width: 45px">
                        回复：
                    </div>
                    <div style="overflow: hidden;">
                        <span onclick="removeReply(this)" style="float: right; padding: 5px; cursor: pointer">
                            <i class="layui-icon" style="!important;font-size:25px;color: #009688">&#x1007;</i></span>
                        <blockquote class="layui-elem-quote" id="replyContent">
                        </blockquote>
                    </div>
                </div>
                <div class="layui-form layui-form-pane">
                    <form action="${pageContext.request.contextPath}/fore/reply/add" method="post" class="layui-form">
                        <div class="layui-form-item layui-form-text">
                            <div class="layui-input-block">
                                <textarea id="content" name="content" required="" lay-verify="content"
                                          placeholder="我要评论"
                                          class="layui-textarea fly-editor" style="height: 150px;"></textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <input type="hidden" name="articleId" value="${result.id }">
                            <input type="hidden" name="toReplyId" id="toReplyId">
                            <button class="layui-btn" lay-filter="submit1" lay-submit="">提交评论</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="edge">
        <div class="fly-panel leifeng-rank">
            <h3 class="fly-panel-title">发帖排行榜 - TOP 12</h3>
            <div class="user-looklog leifeng-rank">
				<span> <c:forEach var="item" items="${top12 }" varStatus="items">
						<a href="javacript:void(0);" onclick="layer.msg('功能开发中')"> <img
                                src="<%=basePath%>resources/others/layui/images/user03.jpg"> <cite>${item.nickname }</cite> <i>${item.articleNum }次发帖</i>
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
    <%--<div class="edge">
        <h3 class="page-title">最近热帖</h3>
        <ol class="fly-list-one">
            <c:forEach var="item" items="${top15 }" varStatus="items">
                <li><a href="detail_${item.id }">${item.title }</a> <span><i
                        class="iconfont"></i> ${item.replyNum }</span></li>
            </c:forEach>
        </ol>
        <h3 class="page-title">最新帖子</h3>
        <ol class="fly-list-one">
            <c:forEach var="item" items="${new15 }" varStatus="items">
                <li><a href="detail_${item.id }">${item.title }</a> <span><i
                        class="iconfont"></i> ${item.replyNum }</span></li>
            </c:forEach>
        </ol>
    </div>--%>
</div>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/footer_fore.jsp"></jsp:include>
<!-- 公共js -->
<jsp:include page="/WEB-INF/forePage/common/import_js_fore.jsp"></jsp:include>
<!-- 当前页面js -->
<script type="text/javascript">
    function collection(e) {
        if ($(e).hasClass('layui-btn-danger')) {
            $.post('${pageContext.request.contextPath}/fore/collection/delete', {'articleId': $(e).attr('id')}, function (data) {
                if (data.success) {
                    $(e).removeClass('layui-btn-danger');
                    $(e).text('收藏');
                } else {
                    layer.msg(data.msg);
                }
            }, 'json');
        } else {
            $.post('${pageContext.request.contextPath}/fore/collection/add', {'articleId': $(e).attr('id')}, function (data) {
                if (data.success) {
                    $(e).addClass('layui-btn-danger');
                    $(e).text('取消收藏');
                } else {
                    layer.msg(data.msg);
                }
            }, 'json');
        }
    }

    function reply(e) {
        var a = $(e).parents("li").clone();
        a.find(".jieda-reply-my").remove();
        a.find(".reply_my").remove();
        $("#replyContent").html(a.html());
        $("#replyDiv").css("display", "inherit");
        $("#toReplyId").val(a.attr("id"));
        $("#content").focus();
    }

    function removeReply(e) {
        $("#replyDiv").css("display", "none");
        $("#toReplyId").val("");
    }

    var arr = window.location.href.split('?');
    var ar = arr[0];
    var option = {
        listUrl: ar + '?',
        totalPages: ${replys.getPages()},
        page: ${replys.getPageNum()},
        param: {}
    };
    tg_basePage(option);
    //自定义验证规则
    var rules = {
        content: function (value) {
            if (value.length < 1 || value.length > 2000) {
                return '评论在1~2000个字符之间';
            }
        }
    };
    form.verify(rules);
    //监听提交
    form.on('submit(submit1)', function () {
    });
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
        $('.detail-body').each(function () {
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