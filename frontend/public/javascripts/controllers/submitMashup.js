function submitMashup() {
    $.ajax({
        url: "/mashup",
        type: "POST",
        data: {

        },
        headers: {
            "Content-Type": "application/json"
        },
        dataType: 'json',
        success: (data) => {
            console.log(data);
        }
    });
}

$(document).ready(function() {

});