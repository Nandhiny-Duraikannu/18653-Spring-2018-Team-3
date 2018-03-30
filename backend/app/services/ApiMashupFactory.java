package services;

import models.Api;

public class ApiMashupFactory {

    public Api createObject(String type)
    {
        if (type.equalsIgnoreCase("api"))
        {
           Api api = new Api();
        api.setObjectType("api");
            return api;

        } else if (type.equalsIgnoreCase("mashup"))
        {
            Api api = new Api();
            api.setObjectType("mashup");
            return null;
        }
        else
            {
            return null;
        }
    }

}
