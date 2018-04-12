package services.message;
import models.*;
import DAO.*;

public class ChatRoom {
    private static MessageDAO messageDAO = new MessageDAO();

    public static Message sendMessage(User sender, User receiver, String title, String message) {
        return messageDAO.create(sender, receiver, title, message);
    }
}
