$(document).ready(function() {

  let resultArea = $("#resultArea");
  let noresult = $("#noresult");
  resultArea.hide();
  noresult.hide();

  $("#submitFollowButton").click(function () {
    var apiId = $(this).attr("data-id");
    console.log(apiId);
    $.ajax({
      url: "/follow",
      type: "POST",
      data: apiId,
      headers: {
        "Content-Type": "application/json"
      },
      dataType: 'json',
      success: (data) => {
        console.info(data);
      }
    });
  });
});