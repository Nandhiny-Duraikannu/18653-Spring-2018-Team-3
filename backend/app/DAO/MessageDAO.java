package DAO;

import models.*;

import java.util.List;

public class MessageDAO  {

    public List<Message> getReceivedMessages(User receiver) {
        return Message.find.query()
                .fetch("sender")
                .fetch("receiver")
                .where()
                .eq("receiver_id", receiver.getId())
                .orderBy("datetime desc")
                .findList();
    }

    public Message create(User sender, User receiver, String title, String content) {
        Message message = new Message(sender, receiver, title, content);
        message.save();
        return message;
    }
}
