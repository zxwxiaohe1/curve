/**
 * @author: Created by heyong.
 * @createtime: on 2018/8/19.
 * @copyright&copy: <a href="http://www.sinux.com.cn">JFusion</a> All rights reserved
 */
$(document).ready(function() {
    // 用户注册
    $("#task-submit").click(function () {
        var linkStr = '';
        $(".keyword-record").each(function(index,item) {
            linkStr = linkStr+"0:"+item.innerText+',';
        });
        $.ajax({
            url: apiCtx +'/rest/sys/task/save',// 提交的地址
            type: 'POST',// 提交的方式
            contentType: 'application/json',
            data: JSON.stringify({
                title: $('#title').val(),
                todo: $('#task-info input:radio[name="todo"]:checked ').val(),
                content: $('#content').val(),
                link: linkStr,
            }),// 提交的参数
            success: function (data) {
                alert(data.message)
            }
        });
    });
});

