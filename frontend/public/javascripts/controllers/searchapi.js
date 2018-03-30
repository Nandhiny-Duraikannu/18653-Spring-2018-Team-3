$(document).ready(function() {

  let resultArea = $("#resultArea");
  let noresult = $("#noresult");
  resultArea.hide();
  noresult.hide();

  $("#submitSearchButton").click(function () {
    $.ajax({
      url: "/search",
      type: "GET",
      data: {searchParam: $("#searchParam").val()},
      headers: {
        "Content-Type": "application/json"
      },
      dataType: 'json',
      success: (data) => {
        let list = $("#searchResults");
        list.html("<ul class='collection'>");
        data.map(api => {
          list.append("<li class='collection-item'>" + api.apiname + "</li>");
        });
        list.append("</ul>");
        if (data.length) {
          resultArea.show();          
        } else {
          noresult.show();
        }
      }
    });
  });
});