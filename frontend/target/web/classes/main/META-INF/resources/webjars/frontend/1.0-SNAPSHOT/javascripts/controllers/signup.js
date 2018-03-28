$(document).ready(function() {
  let username = $("#username");
  let password = $("#password");
  let password2 = $("#password2");
  let securityQuestionSelect = $("#securityQuestionSelect");
  let answer = $("#answer");

  // error badges
  let usernameRequiredBadge = $("#usernameRequiredBadge");
  let password1RequiredBadge = $("#password1RequiredBadge");
  let password2RequiredBadge = $("#password2RequiredBadge");
  let passwordErrorBadge = $("#passwordErrorBadge");
  let securityQuestionErrorBadge = $("#securityQuestionErrorBadge");
  let answerRequiredBadge = $("#answerRequiredBadge");

  // initialize the select dropdown
  $('select').formSelect();

  // returns a boolean to check if both passwords are identical
  function passwordsMatch () {
    if (password.val() === password2.val()) { return true; }
    else { return false; }
  }

  function displayPasswordErrorMessage () {
    passwordErrorBadge.show();
  }

  function hideAllErrorMessages () {
    usernameRequiredBadge.hide();
    password1RequiredBadge.hide();
    password2RequiredBadge.hide();
    passwordErrorBadge.hide();
    securityQuestionErrorBadge.hide();
    answerRequiredBadge.hide();
  }

  hideAllErrorMessages();

  function registerUser(user) {
    console.log(user);
  }

  function allFieldsAreFilled () {
    if (!username.val()) {
      usernameRequiredBadge.show();
      return false;
    } else if (!password.val()) {
      password1RequiredBadge.show();
      return false;
    } else if (!password2.val()) {
      password2RequiredBadge.show();
      return false;
    } else if (!securityQuestionSelect.val()) {
      securityQuestionErrorBadge.show();
      return false;
    } else if (!answer.val()) {
      answerRequiredBadge.show();
      return false;
    } else {
      return true;
    }
  }

  $("#signupButton").click((e) => {
    e.preventDefault();
    hideAllErrorMessages();

    if (allFieldsAreFilled()) {
      if (passwordsMatch()) {
        $("#signupButton").addClass("disabled").attr("disabled", "disabled");
        registerUser({
          username: username.val(),
          password: password.val(),
          securityQuestion: securityQuestionSelect.val(),
          answer: answer.val()
        });
      } else {
        displayPasswordErrorMessage();
      }
    }
  });
});