function renderFollowers(apis) {
    var tbody = $('#followerTable tbody');
    tbody.html('');

    apis.map(api => {
        api.followers.map(follower => {
            tbody.append('<tr><td>'+follower.username+'</td><td>'+api.name+'</td></tr>');
        });
    });
}

function getAllFollowers() {
    $.ajax({
        url: "/followers",
        type: "GET",
        dataType: 'json',
        success: (data) => {
            console.log(data);
            renderFollowers(data);
        }
    });
}


$(document).ready(function() {

    getAllFollowers();

});