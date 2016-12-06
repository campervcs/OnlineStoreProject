$(document).ready(function(){
$('.message a').click(function(){
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});
    });
function show_first_block() {
    $('.admin_blocks').css('display', 'none');
    $('#add_product').css('display', 'block');
};

function show_second_block() {
    $('.admin_blocks').css('display', 'none');
    $('#show_users').css('display', 'block');
};

