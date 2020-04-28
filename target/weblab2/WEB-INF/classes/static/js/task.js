$(document).ready(function () {
    $('.btn').click(function () {
        var searchId = $('#searchId').val();
        $.ajax({
            url: "http://localhost:8080/task/" + searchId,
        }).then(function (data) {
            console.log(data);
            $('#info').html(searchId);
            $('#content').html("51431 " + searchId);
        })
    })
})