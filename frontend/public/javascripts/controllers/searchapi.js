$(document).ready(function() {

  function renderApis(mashups) {
      var tbody = $('#apiTable tbody');
      tbody.html('');

      mashups.map(mashup => {
          tbody.append('<tr><td>'+mashup.name+'</td><td>'+mashup.user+'</td><td>'+mashup.url+'</td></tr>');
      });
  }

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
        renderApis(data);
        if (data.length) {
          resultArea.show();          
        } else {
          noresult.show();
        }
      }
    });
  });
});