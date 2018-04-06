package services;

import DAO.ApiDAO;
import models.*;

import java.util.List;

public class ApiFactory {
    private ApiDAO apiDAO = new ApiDAO();

    public Api createApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds)
    {
        if (apiType.equalsIgnoreCase("api"))
        {
            Api api = new Api();
            api.setParameters(name,homepage,endpoint,version,scope,description,email);
            return api;

        } else if (apiType.equalsIgnoreCase("mashup"))
        {
            Mashup mashup = new Mashup();
            mashup.setParameters(name,homepage,endpoint,version,scope,description,email);

            for (int apiId: apiIds) {
                Api api = apiDAO.getById(apiId);
                if (api != null)
                    mashup.addApi(api);
//new

            }
            return mashup;
        }
        else
            {
            return null;
        }
    }

    public Follower followApi(Integer user_id, Integer api_id, Integer submitter_id)
        {
            
            Follower follower = new Follower();
            follower.setParameters(user_id,api_id,submitter_id);
            return follower;

        }
    

}
