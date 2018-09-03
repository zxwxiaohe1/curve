$(document).ready(function () {

    alert("sss");
    // 下拉
    $(".pull").hover(function () {
        $(this).addClass("pull-hover");
    });
    $(".pull").click(function () {
        $(this).addClass("pull-click");
    });

})