$(document).ready(function() {

  // let resultArea = $("#resultArea");
  // let noresult = $("#noresult");
  // resultArea.hide();
  // noresult.hide();

  $(".submitFollowButton").click(function () {
    let thisButton = $(this);
    let parentTD = thisButton.parent();
    var apiId = thisButton.attr("data-id");
    $.ajax({
      url: "/follow",
      data: {"apiId": apiId},
      type: "POST",
      success: function (data) {
        parentTD.html("<button class='btn left' type='submit' name='unfollow'>Following<i class='material-icons right'>star</i></button>");
      }
    });
  });
});
