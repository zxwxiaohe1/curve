$(document).ready(function() {
    
    setInterval(function () {  // setInterval() 方法可按照指定的周期（以毫秒计）来不停地调用函数。  直到 clearInterval() 被调用或窗口被关闭。 --HTML DOM
        moveRight();
    }, 5000);

    var slideCount = $('.banner li').length;
    var slideWidth = $('.banner li').outerWidth();
    var sliderUlWidth = slideCount * slideWidth;

    $('.banner').css({ width: sliderUlWidth, marginLeft: -960 });

    $('.banner li:last-child').prependTo('.banner'); 

    function moveRight() {
        $('.banner').animate({
            left: -slideWidth
        }, 500, function () {
            $('.banner li:first-child').appendTo('.banner');	
            $('.banner').css('left', '');
        });
    };
    

})
