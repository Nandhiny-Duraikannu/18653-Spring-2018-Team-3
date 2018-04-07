$(document).ready(function() {

  // let resultArea = $("#resultArea");
  // let noresult = $("#noresult");
  // resultArea.hide();
  // noresult.hide();

  $("#submitFollowButton").click(function () {
    var apiId = $(this).attr("data-id");
    console.log("apiId in ajax" +apiId);
    $.ajax({
      url: "/follow",
        dataType: 'json',
        data: {"apiId": apiId},
      type: "POST",
      success: (data) => {
        console.info(data);
      }
    });
  });
});
