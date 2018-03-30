$(document).ready(function() {
  let username = $("#username");
  let password = $("#password");
  

  // error badges
  let usernameRequiredBadge = $("#usernameRequiredBadge");
  let passwordRequiredBadge = $("#passwordRequiredBadge");


  // returns a boolean to check if both passwords are identical
  function hideAllErrorMessages () {
    usernameRequiredBadge.hide();
    passwordRequiredBadge.hide();
  }

  hideAllErrorMessages();

  function loginUser(user) {
    $.ajax({
      url: "/login",
      type: "POST",
      data: JSON.stringify(user),
      headers: {
        "Content-Type": "application/json"
      },
      dataType: 'json',
      success: (data) => {
        console.log(user);
        console.info(data);
      }
    });
  }

  function allFieldsAreFilled () {
    if (!username.val()) {
      usernameRequiredBadge.show();
      return false;
    } else if (!password.val()) {
      passwordRequiredBadge.show();
      return false;
    } else {
      return true;
    }
  }

  $("#loginButton").click((e) => {
    e.preventDefault();
    hideAllErrorMessages();

    if (allFieldsAreFilled()) {
        $("#loginButton").addClass("disabled").attr("disabled", "disabled");
        loginUser({
          username: username.val(),
          password: password.val()
        });
    }
  });
});