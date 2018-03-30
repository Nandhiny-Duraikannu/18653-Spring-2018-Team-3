$(document).ready(function() {
  let username = $("#username");
  let securityQuestionSelect = $("#securityQuestionSelect");
  let answer = $("#answer");
  

  // error badges
  let usernameRequiredBadge = $("#usernameRequiredBadge");
  let securityQuestionErrorBadge = $("#securityQuestionErrorBadge");
  let answerRequiredBadge = $("#answerRequiredBadge");

  // initialize the select dropdown
  $('select').formSelect();

  // returns a boolean to check if both passwords are identical
  function hideAllErrorMessages () {
    usernameRequiredBadge.hide();
    securityQuestionErrorBadge.hide();
    answerRequiredBadge.hide();
  }

  hideAllErrorMessages();

  function resetPwd(user) {
    //console.log(user);
    $.ajax({
      url: "/forgotpassword",
      type: "POST",
      data: JSON.stringify(user),
      headers: {
        "Content-Type": "application/json"
      },
      dataType: 'json',
      success: (data) => {
        console.log(data);
        $("#username").addClass("disabled").attr("disabled", "disabled");
        
      }
    });
  }

  function allFieldsAreFilled () {
    if (!username.val()) {
      usernameRequiredBadge.show();
      return false;
    } else if (!securityQuestionSelect.val()) {
      securityQuestionErrorBadge.show();
      return false;
    }else if (!answer.val()) {
      answerRequiredBadge.show();
      return false;
    } else {
      return true;
    }
  }

  $("#resetButton").click((e) => {
    e.preventDefault();
    hideAllErrorMessages();

    if (allFieldsAreFilled()) {
        $("#resetButton").addClass("disabled").attr("disabled", "disabled");
        resetPwd({
          username: username.val(),
          securityQuestion: securityQuestionSelect.val(),
          answer: answer.val()
        });
    }
  });
});