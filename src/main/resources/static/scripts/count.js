$(function () {
    setInterval("showCount()", 1000);
});

function showCount() {
    $.ajax({
        type: "POST",
        async: true,
        url: "/getCount",
        dataType: "text",
        success: function (data) {
            $("#online").text(data)
        }
    });
}