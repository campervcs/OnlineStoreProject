$(function () {
    $('.cart').submit(function (e) {
        e.preventDefault();
        var m_method = $(this).attr('method');
        var m_action = $(this).attr('action');
        var m_data = $(this).serialize();
        $.ajax({
            type: m_method,
            url: m_action,
            data: m_data,
            success: function (responseJson) {
                $('#Cart').remove();
                var $table = $("<table id='Cart' class='table table-hover'>").appendTo($(".social"));
           var $thead = $("<thead>").appendTo($($table));
                $("<tr>").appendTo($thead)
                    .append($("<th>").text("ID"))
                    .append($("<th>").text("MODEL"))
                    .append($("<th>").text("PRICE"))
                    .append($("<th>").text("COUNT"));
                $.each(responseJson, function (index, product) {
                   $("<tr>").appendTo($table)
                        .append($("<td>").text(product.id))
                        .append($("<td>").text(product.model))
                        .append($("<td>").text(product.price))
                       .append($("<td>").text(product.count));
                });
            }
        });
    });
});
