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
<!-- 当前页js代码 -->
<script type="text/javascript">
    //分页查询
    $("#search").val(GetQueryString("search"));
    var option = {
        listUrl: "list?",
        totalPages: ${result.getPages()},
        page: ${result.getPageNum()},
        param: {
            search
        }
    };
    tg_basePage(option);
    //分页查询
    form.on('switch(filter)', function (data) {
        var id = data.elem.id;
        if (!$("#" + id).prop("checked")) {
            layer.confirm('您确定要停用此数据吗？', {
                btn: ['确定', '取消']
            }, function () {
                //停用
                tg_simpleAjaxPost('disabled_' + id, null, function () {
                    $("#" + id).next().removeClass("layui-form-onswitch");
                    layer.msg('停用成功！', {
                        time : 1000,
                        icon : 1
                    });
                }, function () {
                    $("#" + id).prop("checked", true);
                    $("#" + id).next().addClass("layui-form-onswitch");
                    layer.msg('停用失败！', {
                        time : 1000,
                        icon : 2
                    });
                });
            }, function () {
                $("#" + id).prop("checked", true);
                $("#" + id).next().addClass("layui-form-onswitch");
            });
        } else if ($("#" + id).prop("checked")) {
            layer.confirm('您确定要启用此数据吗？', {
                btn: ['确定', '取消']
            }, function () {
                //启用
                tg_simpleAjaxPost('enabled_' + data.elem.id, null, function () {
                    $("#" + id).next().addClass("layui-form-onswitch");
                    layer.msg('启用成功！', {
                        time : 1000,
                        icon : 1
                    });
                }, function () {
                    $("#" + id).prop("checked", false);
                    $("#" + id).next().removeClass("layui-form-onswitch");
                    layer.msg('启用失败！', {
                        time : 1000,
                        icon : 2
                    });
                });
            }, function () {
                $("#" + id).prop("checked", false);
                $("#" + id).next().removeClass("layui-form-onswitch");
            });
        }
    });

    function del(url) {
        tg_deleteItem(url, function () {
            layer.msg('删除成功！', {
                time : 1000,
                icon : 1
            });
            setTimeout(function () {
                location.reload();
            }, 1000)
        });
    }
</script>
</body>
</html>