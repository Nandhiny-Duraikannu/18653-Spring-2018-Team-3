function renderStatusBadge(approved) {
    if (approved) {
        return '<span class="new badge green" data-badge-caption="">Approved</span>';
    }
    return '<span class="new badge blue" data-badge-caption="">Pending</span>';
}

function renderFollowerChip(follower) {
    return '<div class="chip">\n' +
        '    <i class="small material-icons left">person</i>\n' +
                follower.username +
        '  </div>';
}

function renderApiRow(api) {
    var followerChips = api.followers.map((follower) => renderFollowerChip(follower));
    followerChips = followerChips.length == 0 ? '<p>There are no followers for this API.</p>' : followerChips.reduce((a, b) => a + b);

    return '<li>\n' +
        '    <div class="collapsible-header">\n' +
        '      <i class="material-icons">filter_drama</i>\n' +
                api.name + renderStatusBadge(api.approved) +
        '    </div>\n' +
        '    <div class="collapsible-body">' +
        '       <p><b>Description: </b>' + api.description + '</p>' +
        '       <p><b>Followers: </b>' + followerChips + '</p>' +
        '   </div>\n' +
        '  </li>';
}

function renderFollowers(apis) {
    var collapsible = $('#api-collection');
    collapsible.html('');

    apis.map(api => {
        collapsible.append(renderApiRow(api));
    });
}

function getAllFollowers() {
    $.ajax({
        url: "/followers",
        type: "GET",
        dataType: 'json',
        success: (data) => {
            renderFollowers(data);
        }
    });
}


$(document).ready(function() {
    $('.collapsible').collapsible();
    getAllFollowers();
});