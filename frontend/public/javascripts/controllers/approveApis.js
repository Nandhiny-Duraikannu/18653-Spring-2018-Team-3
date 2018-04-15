
$(document).ready(function() {

  let approvedApisTableBody = $("#approvedApisTableBody");
  let pendingApisTableBody = $("#pendingApisTableBody");

  let getPendingApiHtml = function (api) {
    let result = "<tr>" +
      "<td><a href=\"apis/" + api.id + "\">" + api.name + "</a></td>" +
      "<td>" + api.description + "</td>" +
      "<td>Pending...</td>" +
      "<td>" +
      "<button class=\"btn left approveApiButton\" type=\"button\" data-id=\"" + api.id + "\">Approve" +
      "<i class=\"material-icons right\">check</i>" +
      "</button>" +
      "</td>" +
      "</tr>";
    return result;
  }

  let getApprovedApiHtml = function (api) {
    let result = "<tr>" +
      "<td><a href=\"apis/" + api.id + "\">" + api.name + "</a></td>" +
      "<td>" + api.description + "</td>" +
      "<td>Approved!</td>"
      "</tr>";
    return result;
  }

  let displayApis = function (apis) {
    apis = JSON.parse(apis);
    let pendingApisHTML = "";
    let approvedApisHTML = "";
    for (let i = 0; i < apis.approvedApis.length; i++) {
      approvedApisHTML += getApprovedApiHtml(apis.approvedApis[i]);
    }
    for (let i = 0; i < apis.pendingApis.length; i++) {
      pendingApisHTML += getPendingApiHtml(apis.pendingApis[i]);
    }
    approvedApisTableBody.html(approvedApisHTML);
    pendingApisTableBody.html(pendingApisHTML);

  };

  let approveApi = function (apiId) {
    $.ajax({
      url: "/apis/approve",
      data: { apiId: apiId },
      type: "POST",
      success: () => {
        getApisPerState();
      }
    });
  };

  let initApproveClick = function () {
    $(".approveApiButton").click(function () {
      let apiId = $(this).attr("data-id");
      approveApi(apiId);
    });
  };

  let getApisPerState = function () {
    $.ajax({
      url: "/apis/state",
      type: "GET",
      success: (data) => {
        displayApis(data);
        initApproveClick();
      }
    });
  };

  getApisPerState();
});