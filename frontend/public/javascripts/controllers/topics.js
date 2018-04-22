function renderTopics(topics) {
    var tbody = $('#classificationTable tbody');
    console.log(topics);
    tbody.html('');

    topics.map(topic => {
            tbody.append('<tr><td>'+topic.topicname+'</td><td>'+topic.apiname+'</td></tr>');
    });
}

function getAllTopics() {
    $.ajax({
        url: "/topics",
        type: "GET",
        dataType: 'json',
        success: (data) => {
            console.log(data);
            renderTopics(data);
        }
    });
}


$(document).ready(function() {

    getAllTopics();

});