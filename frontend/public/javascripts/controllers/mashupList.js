function renderMashups(mashups) {
    var tbody = $('#mashupTable tbody');
    tbody.html('');

    mashups.map(mashup => {
        tbody.append('<tr><td>'+mashup.name+'</td><td>'+mashup.user+'</td><td>'+mashup.url+'</td></tr>');
    });
}

function getAllMashups() {
    $.ajax({
        url: "/mashups/all",
        type: "GET",
        dataType: 'json',
        success: (data) => {
            console.log(data);
            renderMashups(data);
        }
    });
}

function searchMashups() {
    $.ajax({
        url: "/mashups/search?query="+$("#search-input").val(),
        type: "GET",
        dataType: 'json',
        success: (data) => {
            console.log(data);
            renderMashups(data);
        }
    });
}

$(document).ready(function() {

    getAllMashups();

    $("#search-button").click(() => {
        searchMashups();
    });
});