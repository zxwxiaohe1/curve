// JavaScript Document
$(document).ready(function () {

    // 导航
    $(".nv2-all").hover(function () {
        $(this).find(".all-nv-more").toggle();
    });

    // 内容居中
    for (i = 0; i < $(".cont-nr").length; i++) {
        var contWidth = $(".cont-nr").eq(i).width();
        var contHeight = $(".cont-nr").eq(i).height();
        $(".cont-nr").eq(i).css({ "margin-top": -contHeight / 2 - 50 + "px", "margin-left": -contWidth / 2 + "px" });
    }

    // 楼层定位
    $(window).scroll(function () {
        var top = $(document).scrollTop();
        var menu = $(".pop-btn");	
        var lists = $(".content-bar");
        var itemId = "";	
        lists.each(function () {
            var m = $(this);
            var listTop = m.offset().top;
            if (top > listTop - 140) {
                itemId = "#" + m.attr("id");
            } else {
                return false;
            };

            var listLink = menu.find(".pop-btn-click");
            if (itemId && listLink.attr("href") != itemId) {
                listLink.removeClass("pop-btn-click");	
                menu.find("[href=" + itemId + "]").addClass("pop-btn-click");
            }
        });
    });

    // 专长选择
    $(".table-zhuanchang a").click(function () {
        $(this).addClass("table-zc-click").siblings().removeClass("table-zc-click");
    });

    // 关键词：多选
    $(".keyword-tag").click(function () {
        $(this).toggleClass("keyword-tag-click");
    });
    // 婚姻状况：添加、选择
    var $holder = $('#key-add-input');
    $(".key-add-btn").click(function () {
        $holder.removeClass("none");
        $('input', $holder).val('');
    });
    $(".key-off").click(function () {
        $holder.addClass("none").data('holder', null);
    });
    $("#key-add").click(function () {
        var $item = $holder.data('holder');
        var keyValue = $("#key-add-input input").val();
        if (keyValue == "") {
            alert("输入不能为空");
        } else {
            if ($item && $item.length > 0) {
                $item.text(keyValue).append("<i class='ico-diag i-diag11'></i>");
                $holder.data('holder', null).addClass("none");
            } else {
                $holder.addClass("none");
                $(this).parents(".table-item").find(".keyword-tag:last").after('<a href="javascript:void(0);" class="keyword-record keyword-tag keyword-tag2 keyword-tag-click keyword-add-val">' + keyValue + '<i class="ico-diag i-diag11"></i></a>');
            }
        }
    });
    $(document).on("click", ".keyword-add-val", function () {
        $holder.removeClass("none").data('holder', $(this));
        $('input', $holder).val($(this).text());
    });

    //  费用：
    $(".charge-line1").click(function () {
        $(this).parents(".charge-line").find(".i-diag18").addClass("charge-1").removeClass("charge-2 , charge-3");
    });
    $(".charge-line2").click(function () {
        $(this).parents(".charge-line").find(".i-diag18").addClass("charge-2").removeClass("charge-1 , charge-3");
    });
    $(".charge-line3").click(function () {
        $(this).parents(".charge-line").find(".i-diag18").addClass("charge-3").removeClass("charge-1 , charge-2");
    });

    // 翻转
    $(".tag-bar").hover(function () {
        $(this).addClass("show-back").removeClass("show-front");
    }, function () {
        $(this).addClass("show-front").removeClass("show-back");
    });

    // 报告模版
    $(".view-btn").click(function () {
        $(this).parents(".view-report").hide();
        $(".report-model").removeClass("none");
    });
    $(".model-btn").click(function () {
        $(this).parents(".report-model").addClass("none");
        $(".view-report").show();
        $(document).scrollTop($(".table-list").offset().top - 50);
    });

    // 增加子女
    var peopleNumber = 9;
    $(".children-add").click(function () {
        peopleNumber--;
        $(this).parents(".table-item")
            .append('<div class="clearfix mt10 children-list"><div class="u-pn fl w305 mr10 z-' + peopleNumber + '"><div class="pn-ct"><span class="pn-on">子女年龄<i class="arrow"></i></span><ul class="pn-more"><li>下拉11</li><li>下拉22</li><li>下拉33</li><li>下拉44</li><li>下拉55</li><li>下拉66</li></ul></div></div><input type="text" placeholder="孩子生活情况描述" class="u-fm u-tx fl mr10" style="width:270px;"></div>');
    });

    // 增加伤亡
    $(".harm-add").click(function () {
        peopleNumber--;
        $(this).parents(".table-item").append('<div class="clearfix mt10"><div class="clearfix"><div class="fl u-fm-tips-bar mr10"><input type="text" class="u-fm u-tx fl" placeholder="年龄" style="width:285px;"><span>岁</span></div><div class="u-pn fl w305 mr10 z-'+peopleNumber+'"><div class="pn-ct"><span class="pn-on">已做伤残鉴<i class="arrow"></i></span><ul class="pn-more"><li>下拉11</li><li>下拉22</li><li>下拉33</li><li>下拉44</li><li>下拉55</li><li>下拉66</li></ul></div></div></div><div class="clearfix mt10"><input type="text" class="u-fm u-tx fl" placeholder="目前财产的继承情况" style="width:602px;"></div></div>');
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
    $(document).on("hover", ".u-pn", function () {
        if ($(this).hasClass("u-pn-disable") || $(this).hasClass("u-pn-click")) {

        } else {
            $(this).toggleClass("u-pn-hover");
        }
    });
    $(document).on("click", ".u-pn", function () {
        if ($(this).hasClass("u-pn-disable")) {

        } else {
            $(this).toggleClass("u-pn-click");
            $(this).find(".arrow").removeClass("arrow-bottom");
        }
    });

});