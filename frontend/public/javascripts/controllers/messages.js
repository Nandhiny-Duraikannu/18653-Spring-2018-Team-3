$(document).ready(function() {
  let readMessageView = $("#readMessageView");
  let writeMessageView = $("#writeMessageView");
  let sendMessageButton = $("#sendMessageButton");
  let messageContentInput = $("#messageContentInput");
  let messageTitle = $(".messageTitle");
  let messageFrom = $(".messageFrom");
  let messageContent = $(".messageContent");
  let conversationList = $(".conversationList");
  let messages = [];
  let users = [];
  let writeMessageButton = $("#writeMessageButton");
  let receiverUsersSelect = $("#receiverUsersSelect");

  function loadConversations () {
    $.ajax({
      url: "/messages/user",
      type: "GET",
      success: (data) => {
        data = JSON.parse(data);
        messages = data;
        let messagesHTML = "";
        for (let i = 0; i < messages.length; i++) {
          messagesHTML += getMessageForSidebar(messages[i]);
        }
        conversationList.html(messagesHTML);
      }
    });
  }

  function loadUsers () {
    $.ajax({
      url: "/users/all",
      type: "GET",
      success: (data) => {
        users = JSON.parse(data);
        console.log(users);
        let usersSelectHTML = receiverUsersSelect.html();
        for (let i = 0; i < users.length; i++) {
          usersSelectHTML += getUserForSelect(users[i]);
        }
        console.log(receiverUsersSelect);
        receiverUsersSelect.html(usersSelectHTML);
        receiverUsersSelect.formSelect();
      }
    });
  }

  function getUserForSelect (user) {
    return "<option value='" + user.id + "'>" + user.username + "</option>";
  }

  function getMessageById (id) {
    for (let i = 0; i < messages.length; i++) {
      if (messages[i].id === parseInt(id)) {
        return messages[i];
      } else {
        continue;
      }
    }
    return null;
  }

  function getMessageTime (time) {
    let date = new Date(time);
    let hours, minutes;
    hours = ("0" + date.getHours()).slice(-2);
    minutes= ("0" + date.getMinutes()).slice(-2);
    return hours + ":" + minutes;
  }

  function getShortMessage (content) {
    let shortLength = 20;
    if (content.length < shortLength) return content;
    else return content.substring(0, shortLength) + "...";
  }

  function getMessageForSidebar (message) {
    let sidebarMessageHTML = "";
    sidebarMessageHTML += "<li class='conversation' id='" + message.id + "'><div" + " class=\"messageSidebarLine\"><div class=\"messageSenderSidebar\">";
    sidebarMessageHTML += message.sender + "</div><div class=\"messageTimeSidebar\">" + getMessageTime(message.datetime);
    sidebarMessageHTML += "</div></div><div class=\"messageShortContent\">" + getShortMessage(message.content) + "</div></li>";
    return sidebarMessageHTML;
  }

  function loadMessage (messageId) {
    let message = getMessageById(messageId);
    messageFrom.html(message.sender);
    messageTitle.html(message.title);
    messageContent.html(message.content);
  }

  writeMessageButton.click(() => {
    readMessageView.hide();
    writeMessageView.show();
    $(".conversation.active").removeClass("active");
    writeMessageButton.css('visibility', 'hidden');
  });

  $(document).on('click', ".conversation", function () {
    let conversationId = $(this).attr("id");
    $(".conversation.active").removeClass("active");
    $("#" + conversationId).addClass("active");
    loadMessage(conversationId);
    readMessageView.show();
    writeMessageView.hide();
    writeMessageButton.css('visibility', 'visible');
  });

  sendMessageButton.click(function () {
    let message = {};
    message.receiver_id = receiverUsersSelect.val();
    message.title = "message title";
    message.content = messageContentInput.val();
    if (message.content != "") {
      $.ajax({
        url: "/messages",
        type: "POST",
        data: message,
        success: (data) => {
          messageContentInput.val("");
        }
      });
    }
  });

  readMessageView.hide();
  writeMessageView.hide();
  loadConversations();
  loadUsers();
});