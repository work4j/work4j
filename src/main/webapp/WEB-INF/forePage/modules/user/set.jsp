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
        <li class="layui-nav-item">
            <a href="index">
                <i class="layui-icon">&#xe612;</i>
                用户中心
            </a>
        </li>
        <li class="layui-nav-item layui-this">
            <a href="set">
                <i class="layui-icon">&#xe620;</i>
                基本设置
            </a>
        </li>
    </ul>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <div class="fly-panel fly-panel-user" pad20>
        <div class="layui-tab layui-tab-brief" lay-filter="user">
            <ul class="layui-tab-title" id="LAY_mine">
                <li class="layui-this" lay-id="info">我的资料</li>
                <li lay-id="avatar">头像</li>
                <li lay-id="pass">密码</li>
            </ul>
            <div class="layui-tab-content" style="padding: 20px 0;">
                <div class="layui-form layui-form-pane layui-tab-item layui-show">
                    <form action="edit" method="post">
                        <div class="layui-form-item">
                            <label for="L_email" class="layui-form-label">邮箱</label>
                            <div class="layui-input-inline">
                                <input value="${result.email}" type="text" id="L_email" name="email" maxlength="200"
                                       required lay-verify="email" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">如果您在邮箱已激活的情况下，变更了邮箱，需<a href="activate.html"
                                                                                               style="font-size: 12px; color: #4f99cf;">重新验证邮箱</a>。
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_username" class="layui-form-label">昵称</label>
                            <div class="layui-input-inline">
                                <input value="${result.nickname}" type="text" id="L_username" name="nickname"
                                       maxlength="45" required lay-verify="required" autocomplete="off"
                                       class="layui-input">
                            </div>
                            <div class="layui-inline">
                                <div class="layui-input-inline">
                                    <input type="radio" name="sex" value="1" ${result.sex==1?'checked':''} title="男">
                                    <input type="radio" name="sex" value="2" ${result.sex==2?'checked':''} title="女">
                                </div>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_city" class="layui-form-label">城市</label>
                            <div class="layui-input-inline">
                                <input maxlength="45" value="${result.city}" type="text" id="L_city" name="city"
                                       autocomplete="off"
                                       class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item layui-form-text">
                            <label for="L_sign" class="layui-form-label">签名</label>
                            <div class="layui-input-block">
                                <textarea placeholder="随便写些什么刷下存在感" id="L_sign" name="sign" autocomplete="off"
                                          class="layui-textarea" style="height: 80px;">${result.sign}</textarea>
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <button class="layui-btn" key="set-mine" lay-filter="info" lay-submit>确认修改</button>
                        </div>
                    </form>
                </div>

                <div class="layui-form layui-form-pane layui-tab-item">
                    <div class="layui-form-item">
                        <div class="avatar-add">
                            <p>建议尺寸168*168，支持jpg、png、gif，最大不能超过30KB</p>
                            <div class="upload-img">
                                <input class="layui-upload-file" type="file" name="file" id="LAY-file" lay-title="上传头像">
                            </div>
                            <img id="headImg" src="${result.head }">
                            <span class="loading"></span>
                        </div>
                    </div>
                </div>

                <div class="layui-form layui-form-pane layui-tab-item">
                    <form action="repass" method="post">
                        <div class="layui-form-item">
                            <label for="L_nowpass" class="layui-form-label">当前密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="L_nowpass" name="nowpass" required lay-verify="required"
                                       autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <label for="L_pass" class="layui-form-label">密码</label>
                            <div class="layui-input-inline">
                                <input type="password" id="L_pass" name="password" required lay-verify="password"
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
                            <button class="layui-btn" key="set-mine" lay-filter="repass" lay-submit>确认修改</button>
                        </div>
                    </form>
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
    form.on('submit(info)', function (data) {
        $.post(data.form.action, data.field, function (d) {
            if (d.success) {
                tg_alertSuccess('修改成功');
                setTimeout(function () {
                    location.reload();
                }, 1000);
            } else {
                tg_alertError('修改失败');
                data.form.reset();
            }
        }, 'json');
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    form.on('submit(info)', function (data) {
        $.post(data.form.action, data.field, function (d) {
            if (d.success) {
                tg_alertSuccess('修改成功');
                setTimeout(function () {
                    location.reload();
                }, 1000);
            } else {
                tg_alertError('修改失败');
                data.form.reset();
            }
        }, 'json');
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    var t = /^[0-9a-zA-Z]*$/;
    //自定义验证规则
    var rules = {
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
    form.on('submit(repass)', function (data) {
        $.post(data.form.action, data.field, function (d) {
            if (d.success) {
                tg_alertSuccess('修改成功');
                data.form.reset();
            } else {
                layer.msg(d.msg);
            }
        }, 'json');
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    layui.use('upload', function () {
        layui.upload({
            url: '${pageContext.request.contextPath}/fore/upload/uploadImage'
            , success: function (res) {
                if(res.code == 0){
                    $("#headImg").attr("src", res.url);
                }else{
                    layer.msg(res.msg, {icon: 5});
                }

            }
        });
    });
</script>
<ul class="fly-rbar">
    <li id="F_topbar" class="iconfont icon-top" method="top"></li>
</ul>
</body>
</html>