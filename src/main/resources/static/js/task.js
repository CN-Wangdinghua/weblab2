$(document).ready(function () {
    $('.btn').click(function (e) {
        e.preventDefault();
        var searchId = $('#searchId').val();
        $.ajax({
            url: "http://localhost:8080/task/" + searchId,
        }).then(function (data) {
            $('#info').html(data.id);
            $('#content').html(data.name);
        })
    })
})