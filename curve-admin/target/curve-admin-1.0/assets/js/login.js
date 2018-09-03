/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
$(document).ready(function() {
    // 用户注册
    $("#accountLogin").click(function () {
        var form = new FormData();
        form.append("loginName",'havey');
        form.append("password",'111111x');
        var req = new XMLHttpRequest();
      
        req.open("post", apiCtx +"/rest/sys/user/login", true);
        req.setRequestHeader('Content-Type','application/json; charset=utf-8')
        req.send(JSON.stringify(form));
        // $.ajax({
        //     url: '/rest/sys/user/login',// 提交的地址
        //     type: 'POST',// 提交的方式
        //     contentType: 'application/json',
        //     data: JSON.stringify({
        //         loginName: $('#loginName').val(),
        //         password: $('#password').val(),
        //     }),// 提交的参数
        //     success: function (data) {
        //         alert(data.message)
        //     }
        // });
    });
});
