$(function() {
    var $navLi = $('.nav li');
    var $addBtn = $('#plusBigTag');
    $navLi.each(function() {
        $(this).click(function() {
            $(this).siblings('li').removeClass(
                'active').end().addClass(
                'active');
            $(this).next('ul').slideToggle(
                300);
        });
    });
});
