


$('document').ready(function(){
    $('.menu1').fixedMenu();
});

(function($){
    $.fn.fixedMenu=function(){
        return this.each(function(){
            var menu11= $(this);
            menu11.find('ul li > a').bind('hover',function(){
            if ($(this).parent().hasClass('active')){
                $(this).parent().removeClass('active');
            }
            else{
                $(this).parent().parent().find('.active').removeClass('active');
                $(this).parent().addClass('active');
            }
            })
        });
    }
})(jQuery);
