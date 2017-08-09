<!--/*******底部版权信息等*******/-->
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- list页面js代码 -->
<script type="text/javascript">
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
                        time: 1000,
                        icon: 1
                    });
                }, function () {
                    $("#" + id).prop("checked", true);
                    $("#" + id).next().addClass("layui-form-onswitch");
                    layer.msg('停用失败！', {
                        time: 1000,
                        icon: 2
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
                        time: 1000,
                        icon: 1
                    });
                }, function () {
                    $("#" + id).prop("checked", false);
                    $("#" + id).next().removeClass("layui-form-onswitch");
                    layer.msg('启用失败！', {
                        time: 1000,
                        icon: 2
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
                time: 1000,
                icon: 1
            });
            setTimeout(function () {
                location.reload();
            }, 1000)
        });
    }
</script>