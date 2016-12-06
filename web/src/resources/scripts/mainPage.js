$(document).ready(function(){
    $(".button a").click(function(){
        $(".overlay").fadeToggle(200);
        $(this).toggleClass('btn-open').toggleClass('btn-close');
    });
});
