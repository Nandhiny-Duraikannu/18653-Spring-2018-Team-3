$(document).ready(function() {

  let sendMessageButton = $("#sendMessageButton");
  let messageContent = $("#messageContent");

  function loadConversations () {
    console.log("loading conversations");
  }

  function loadMessages (converationId) {
    console.log("loading messages for", converationId);
  }

  $(".conversation").click(function () {
    let conversationId = $(this).attr("id");
    loadMessages(conversationId);
    $(".conversation.active").removeClass("active");
    $("#" + conversationId).addClass("active");

  });

  sendMessageButton.click(function () {
    let message = messageContent.val();
    console.log("sending message", message);
    // send message with ajax
  });

  loadConversations();
});