$(document).ready(function(){
  let apiContainer = $(".apiContainer");
  let getApiCardHtml = function (api) {
    return "<div class=\"col s12\">" +
      "<div class=\"card\">" +
      "<div class=\"card-content\">" +
      "<span class=\"card-title\">" + api.name + "</span>" +
      "<p>Description: " + api.description + "</p>" +
      "<p>Endpoint: " + api.endpoint + "</p>" +
      "<p>Homepage: " + api.homepage + "</p>" +
      "<p>Scope: " + api.scope + "</p>" +
      "<p>Version: " + api.version + "</p>" +
      "<p>Submission date: " + api.date + "</p>" +
      "</div>" +
      "</div>" +
      "</div>";
  };

  let displayCards = function (data) {
    let result = "";
    for (let i = 0; i < data.length; i++) {
      console.log(data[i]);
      result += getApiCardHtml(data[i]);
    }
    apiContainer.html(result);
  };

  let getVersionsOfApi = function () {
    let apiId = $("#hiddenId").html();

    $.ajax({
      url: "/apis/" + apiId + "/versions",
      type: "GET",
      headers: {
        "Content-Type": "application/json"
      },
      success: (data) => {
        data = JSON.parse(data);
        displayCards(data);
      }
    });
  }
  getVersionsOfApi();
});
