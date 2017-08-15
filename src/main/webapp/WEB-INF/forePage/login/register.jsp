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
<jsp:include page="/WEB-INF/forePage/common/nav_fore.jsp"></jsp:include>
<div class="main layui-clear">

    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief">
            <ul class="layui-tab-title">
                <li><a href="login.html">登入</a></li>
                <li class="layui-this">注册</li>
            </ul>
            <div class="layui-form layui-tab-content" id="LAY_ucm" style="padding: 20px 0;">
                <div class="layui-tab-item layui-show">
                    <div class="layui-form layui-form-pane">
                        <form action="register" method="post">
                            <div class="layui-form-item">
                                <label for="L_userName" class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_userName" name="userName" required lay-verify="userName"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">将会成为您唯一的登入名</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_nickname" class="layui-form-label">昵称</label>
                                <div class="layui-input-inline">
                                    <input type="text" id="L_nickname" name="nickname" required lay-verify="required"
                                           autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_pass" class="layui-form-label">密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_pass" name="password" required lay-verify="required|password"
                                           autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid layui-word-aux">6到16个字符</div>
                            </div>
                            <div class="layui-form-item">
                                <label for="L_repass" class="layui-form-label">确认密码</label>
                                <div class="layui-input-inline">
                                    <input type="password" id="L_repass" required lay-verify="repass" autocomplete="off"
                                           class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item">
                                <button class="layui-btn" lay-filter="*" lay-submit>立即注册</button>
                            </div>
                            <div class="layui-form-item fly-form-app">
                                <span>或者直接使用社交账号快捷注册</span> <a onclick="layer.msg('正在开发中')" class="iconfont icon-qq"
                                                               title="QQ登入"></a>
                                <a onclick="layer.msg('正在开发中')"
                                   class="iconfont icon-weibo" title="微博登入"></a>
                            </div>
                        </form>
                    </div>
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
    var t = /^[0-9a-zA-Z]*$/;
    //自定义验证规则
    var rules = {
        userName: function (value) {
            if (value.length < 2 || value.length > 45) {
                return '用户名在2~45个字符之间';
            } else if (!t.test(value)) {
                return '用户名只能为数字、字母或两者组合';
            } else {
                var flag = true;
                $.ajax({
                    url : '${pageContext.request.contextPath}/fore/checkUserName',
                    type: 'post',
                    data: {
                        username: value
                    },
                    dataType: 'json',
                    async: false,
                    success: function (data) {
                        flag = data;
                    }
                });
                if (flag) {
                    return '用户名已存在';
                }
            }
        },
        password: function (value) {
            if (value.length < 6 || value.length > 16) {
                return '密码在6~16个字符之间';
            } else if (!t.test(value)) {
                return '密码只能为数字、字母或两者组合';
            }
        },
        repass: function (value) {
            if (value.length <= 0) {
                return '不能为空';
            } else if (value != $("#L_pass").val()) {
                return '两次密码输入不一致';
            }
        }
    };
    form.verify(rules);
    //监听提交
    form.on('submit(submit1)', function (data) {
    });
</script>
</body>
</html>