package services.command;

import DAO.*;
import models.Mashup;
import models.User;

import java.util.ArrayList;

public class RequestBroker {

    DAOInterface command;

    public RequestBroker () { }

    public void setCommand (DAOInterface command) {
        this.command = command;      
    }

    public void executeCommand () {
        command.execute();         
    }

}
