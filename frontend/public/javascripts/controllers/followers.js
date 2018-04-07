function renderFollowers(followers) {
    var tbody = $('#followerTable tbody');
    tbody.html('');

    followers.map(follower => {
        tbody.append('<tr><td>'+follower.name+'</td></tr>');
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