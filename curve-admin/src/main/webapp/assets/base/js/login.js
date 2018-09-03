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

    // 登陆切换
    $(".m-log-tab a").click(function() {
        var tabIndex = $(this).index();
        $(this).addClass("tab-now").siblings().removeClass("tab-now");
        $(".log-con").eq(tabIndex).removeClass("none").siblings().addClass("none");
    });

    // 下拉
    $(".u-pn").hover(function () {
        if ($(this).hasClass("u-pn-disable") || $(this).hasClass("u-pn-click")) {

        } else {
            $(this).toggleClass("u-pn-hover");
        }
    });
    $(".u-pn").click(function () {
        if ($(this).hasClass("u-pn-disable")) {

        } else {
            $(this).toggleClass("u-pn-click");
            $(this).find(".arrow").removeClass("arrow-bottom");
        }
    });

    // 表单
    $(".u-fm").focus(function () {
        $(this).addClass("u-fm-focus");
    });
    $(".u-fm").blur(function () {
        $(this).removeClass("u-fm-focus");
    });

    // 单选
    $(".radio-sex .radio").click(function() {
        $(this).addClass("radio-ct").siblings().removeClass("radio-ct");
    });

    // 多选
    $(".checkbox").click(function () {
        $(this).toggleClass("checkbox-ct");
    });








});