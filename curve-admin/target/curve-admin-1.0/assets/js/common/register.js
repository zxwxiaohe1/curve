/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/18.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
$(document).ready(function() {
    // 用户注册
    $("#userRegisterSubmit").click(function () {
        $.ajax({
            url: apiCtx +'/rest/sys/user/save',// 提交的地址
            type: 'POST',// 提交的方式
            contentType: 'application/json',
            data: JSON.stringify({
                name: $('#name').val(),
                sex: $('#radiosex input:radio[name="sexList"]:checked ').val(),
                loginName: $('#loginName').val(),
                password: $('#password').val(),
                phone: $('#phone').val(),
                email: $('#email').val(),
            }),// 提交的参数
            success: function (data) {
                alert(data.message)
            }
        });
    });
});
