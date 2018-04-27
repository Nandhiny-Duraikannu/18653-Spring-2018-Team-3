package services.command;

import DAO.*;
import models.Mashup;
import models.User;

import java.util.ArrayList;

public class RequestBroker {

    public RequestBroker () { }

    public DAOInterface create (String daoCommand) {
         switch(daoCommand) {
         case "APIDAO" :
            return new ApiDAO();
         case "DONATIONDAO" :
            return new DonationDAO();
         case "LOGMESSAGEDAO" :
            return new LogMessageDAO();
         case "MASHUPDAO" :
            return new MashupDAO();
         case "MESSAGEDAO" :
            return new MessageDAO();
         case "TOPICSDAO" :
            return new TopicsDAO();
         case "USERDAO" :
            return new UserDAO();
         default :
            return null;
         //  System.out.println("Invalid DAO Command");
      }
    }

}
