// JavaScript Document
$(document).ready(function () {

    // 导航吸顶
    $(window).scroll(function() {
        if ($(window).scrollTop() >= $(".g-hd").outerHeight() + $(".banner").outerHeight()) {
            $(".g-act-nav").addClass("act-nav-pf");
        } else {
            $(".g-act-nav").removeClass("act-nav-pf");
        };
    });

    // 精彩图集
    $(".wonderful a").hover(function() {
        $(this).find("p").animate({
            bottom:'0px'
        },240);
    }, function() {
        $(this).find("p").animate({
            bottom: '-40px'
        }, 240);
    });

    // 表单
    $(".u-fm").focus(function () {
        $(this).addClass("u-fm-focus");
    });
    $(".u-fm").blur(function () {
        $(this).removeClass("u-fm-focus");
    });

});