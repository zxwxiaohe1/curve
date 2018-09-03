// JavaScript Document
$(document).ready(function () {

    // top 会员菜单
    $(".user-login").hover(function () {
        $(this).toggleClass("s-l-hover");
    });

    // footer 二维码
    $(".f-td-n").hover(function () {
        $(this).next('.f-td-ew ').toggleClass('none');
    });

    // 快捷入口
    $(".sk-saix").click(function() {
        $(this).toggleClass("sk-saix-click");
        $(".sk-lei").toggleClass("none");
    });

    // 发需求
    $(".fa-xq").hover(function() {
        $(this).find(".down-list").toggleClass("none");
    });

    // 主导航
    $(".g-nv li").hover(function () {
        $(this).addClass("ft-nv-hover");
        $(this).find(".down-list").removeClass("none");
    }, function () {
        $(this).removeClass("ft-nv-hover");
        $(this).find(".down-list").addClass("none");
    });

    // 主导航 二维码
    $(".i-nv-er").hover(function() {
        $(this).next(".nv-er-pop").removeClass("none");
    }, function() {
        $(this).next(".nv-er-pop").addClass("none");
    });

    $(".sk-k").hover(function () {
        $(".sk-tip").toggleClass("none");
    });

    //头部手机扫二维码
    $(".s-nav-phone").hover(function () {
        $(this).find(".nv-er-pop").toggleClass("none");
    })

});