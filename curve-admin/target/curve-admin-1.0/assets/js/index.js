// $(document).ready(function() {
//     // 用户注册
//     $("#redirectTask").click(function () {
//         // $.ajax({
//         //     url: apiCtx + '/rest/sys/redirect/target?address=view/memoryTask.html',// 提交的地址
//         //     type: 'GET'// 提交的方式
//         // });
//         var form = new FormData();
//         form.append("address",'view/memoryTask.html');
//         var req = new XMLHttpRequest();
//
//         req.open("post", apiCtx + '/rest/sys/redirect/target', true);
//         req.setRequestHeader('Content-Type','application/json; charset=utf-8')
//         req.send(JSON.stringify(form));
//     });
// });
function redirectTaskHtml() {
    $.ajax({
            url: apiCtx + '/rest/sys/redirect/target?address=view/memoryTask.html',// 提交的地址
            type: 'GET'// 提交的方式
        });
}