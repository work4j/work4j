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
    <div class="fly-panel" pad20>
        <h2 class="page-title">发布帖子</h2>
        <div class="layui-form layui-form-pane">
            <form action="add" method="post">
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="title" required=""
                               lay-verify="title" autocomplete="off" class="layui-input" placeholder="请输入标题">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">所属栏目</label>
                    <div class="layui-input-block">
                        <select id="column" lay-verify="required" name="columnId">
                            <option></option>
                        </select>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标签</label>
                    <div class="layui-input-block" id="tags">
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <div class="layui-input-block">
                        <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容"
                                  class="layui-textarea fly-editor" style="height: 260px;"></textarea>
                    </div>
                    <label for="L_content" class="layui-form-label" style="top: -2px;">内容</label>
                </div>
                <div class="layui-form-item">
                    <button class="layui-btn" lay-filter="submit1" lay-submit="">立即发布</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- 导航栏 -->
<jsp:include page="/WEB-INF/forePage/common/footer_fore.jsp"></jsp:include>
<!-- 公共js -->
<jsp:include page="/WEB-INF/forePage/common/import_js_fore.jsp"></jsp:include>
<!-- 当前页面js -->
<script>

    $(function () {
        //获取栏目
        $.ajax({
            url: '${pageContext.request.contextPath}/fore/column/list',
            type: "post",
            data: {},
            dataType: "json",
            success: function (data) {
                $("#column").empty();
                $("#column").append("<option value=''>请选择栏目</option>");
                $.each(data, function (index, column) {
                    $("#column").append("<option value='" + column.id + "'>" + column.name + "</option>");
                });
                form.render('select');
            }
        });
        //获取标签
        $.ajax({
            url: '${pageContext.request.contextPath}/fore/tag/list',
            type: "post",
            data: {},
            dataType: "json",
            success: function (data) {
                $("#tags").empty();
                $.each(data, function (index, tag) {
                    $("#tags").append('<input type="checkbox" value="' + tag.id + '" name="tags" title="' + tag.name + '">');
                });
                form.render('checkbox');
            }
        });
    });

    //自定义验证规则
    var rules = {
        title: function (value) {
            if (value.length < 2 || value.length > 30) {
                return '标题在2~30个字符之间';
            }
        },
        content: function (value) {
            if (value.length < 2 || value.length > 10000) {
                return '内容在2~10000个字符之间';
            }
        }
    };
    form.verify(rules);
    //监听提交
    form.on('submit(submit1)', function (data) {
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
    }).use('fly');
</script>
</body>
</html>