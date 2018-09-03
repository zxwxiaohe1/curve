// JavaScript Document
$(document).ready(function () {

    // 精彩图集
    $(".g-r4-l a").hover(function () {
        $(this).find("dl").animate({
            bottom: '0px'
        }, 240);
    }, function () {
        $(this).find("dl").animate({
            bottom: '-105px'
        }, 240);
    });

    $(".g-r5 a").hover(function () {
        $(this).find("div").animate({
            bottom: '0px'
        }, 240);
    }, function () {
        $(this).find("div").animate({
            bottom: '-112px'
        }, 240);
    });

});