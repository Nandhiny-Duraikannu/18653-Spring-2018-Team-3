package services.message;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import DAO.*;

import java.util.ArrayList;
import java.util.List;

public interface ChatRoom {
    MessageDAO messageDAO = new MessageDAO();

    Message send(User sender, User receiver, String title, String message);
}
