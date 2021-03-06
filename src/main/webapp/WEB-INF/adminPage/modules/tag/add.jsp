<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>新增标签</title>
    <!-- 头部 -->
    <%@ include file="../../common/head_admin.jsp" %>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <!-- 导航栏 -->
    <jsp:include page="../../common/nav_admin.jsp"/>
    <!-- 菜单栏  param::root 菜单栏选项卡定位参数 -->
    <jsp:include page="../../common/menu_admin.jsp" flush="true">
        <jsp:param value="tag" name="root"/>
    </jsp:include>
    <!-- 内容 -->
    <div class="layui-body site-demo">
        <div class="layui-main">
            <!--/***** 面包屑 *****/-->
            <div class="layui-elem-quote" style="margin-top: 10px;">
					<span class="layui-breadcrumb"> <a><cite>内容管理</cite></a> <a><cite>新增标签</cite></a>
					</span>
            </div>
            <blockquote class="layui-elem-quote layui-quote-nm" style="color: #FF5722">
                <i class="layui-icon">&#xe60b;</i> 啦啦啦，新增标签。
            </blockquote>
            <!--/*******操作*******/-->
            <form action="add" method="post" class="layui-form">
                <fieldset class="layui-elem-field layui-field-title">
                    <legend>新增标签</legend>
                </fieldset>
                <div class="layui-form-item">
                    <label class="layui-form-label">名称：<span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input maxlength="45" type="text" name="name" lay-verify="required" autocomplete="off"
                               placeholder="请输入名称" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">代码：<span style="color: red">*</span></label>
                    <div class="layui-input-block">
                        <input maxlength="45" type="text" name="code" lay-verify="required" autocomplete="off"
                               placeholder="请输入代码" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="submit1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- 底部 -->
    <jsp:include page="../../common/footer_admin.jsp"/>
    <!-- 公告js文件 -->
    <jsp:include page="../../common/import_js_admin.jsp"/>
</div>
<!-- 当前页js代码 -->
<script type="text/javascript">
    //监听提交
    form.on('submit(submit1)', function (data) {
    });
</script>
</body>
</html>