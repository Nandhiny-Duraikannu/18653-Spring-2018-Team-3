function renderLogMessages(messages) {
    console.log(messages);
    var tbody = $('#logMessageTable tbody')
    messages.map(message => {
        var date = new Date(message.datetime);
        var datetimeString = date.toLocaleDateString() + ' ' + date.toLocaleTimeString();
        tbody.append('<tr><td>' + datetimeString + '</td><td>' + message.message + '</td></td></tr>')
    })
}

$(document).ready(function() {
    $.ajax({
        url: "/log/messages",
        type: "GET",
        success: function (data) {
            renderLogMessages(JSON.parse(data));
        }
    });
});