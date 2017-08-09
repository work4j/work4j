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
<jsp:include page="/WEB-INF/forePage/common/nav_fore.jsp"></jsp:include>

<div class="main layui-clear">
    <div class="fly-panel" pad20>
        <h2 class="page-title">发表问题</h2>
        <div class="layui-form layui-form-pane">
            <form action="add" method="post" onsubmit="toHtml()">
                <div class="layui-form-item">
                    <label for="L_title" class="layui-form-label">标题</label>
                    <div class="layui-input-block">
                        <input type="text" id="L_title" name="title" required=""
                               lay-verify="title" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">所在类别</label>
                        <div class="layui-input-block">
                            <select lay-verify="required" name="class">
                                <option></option>
                                <option value="1" >layui框架综合</option>
                                <option value="2" >layui.mobile模块</option>
                                <option value="3" >layer弹出层</option>
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <%--<label class="layui-form-label">悬赏飞吻</label>
                        <div class="layui-input-block">
                            <select name="experience">
                                <option value="5" selected>5</option>
                                <option value="20">20</option>
                                <option value="50">50</option>
                                <option value="100">100</option>
                            </select>
                        </div>--%>
                    </div>
                </div>
                <div class="layui-form-item layui-form-text">
                    <div class="layui-input-block">
                        <textarea id="L_content" name="content" required lay-verify="required" placeholder="请输入内容" class="layui-textarea fly-editor" style="height: 260px;"></textarea>
                    </div>
                    <label for="L_content" class="layui-form-label" style="top: -2px;">描述</label>
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
        ,uid: -1
        ,avatar: '${pageContext.request.contextPath}/resources/others/fly/images/avatar/00.jpg'
        ,experience: 83
        ,sex: '男'
    };
    layui.config({
        version: "2.0.0"
        ,base: '${pageContext.request.contextPath}/resources/others/fly/mods/'
    }).extend({
        fly: 'index'
    }).use('fly');
</script>
</body>
</html>