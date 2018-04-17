package services.factories;

import DAO.ApiDAO;
import models.*;
import services.submissions.SubmissionCache;

import java.util.List;

public class ApiFactory extends AbstractFactory {
    private ApiDAO apiDAO;
    private SubmissionCache submissionCache;

    public ApiFactory () {
        this.apiDAO = new ApiDAO();
        this.submissionCache = new SubmissionCache();
        this.submissionCache.loadCache();
    }

    @Override
    public Api getApi(String apiType, String name, String homepage, String endpoint, String version, String scope, String description, String email, List<Integer> apiIds)
    {
        Long nextId = apiDAO.getNextId();
        if (apiType.equalsIgnoreCase("api"))
        {
            Api api = this.submissionCache.getApi();
            api.setParameters(name,homepage,endpoint,version,scope,description,email);
            api.setId(nextId);
            return api;

        } else if (apiType.equalsIgnoreCase("mashup"))
        {
            Mashup mashup = this.submissionCache.getMashup();
            mashup.setParameters(name,homepage,endpoint,version,scope,description,email);
            mashup.setId(nextId);
            for (int apiId: apiIds) {
                Api api = apiDAO.getById(apiId);
                if (api != null)
                    mashup.addApi(api);
            }
            return mashup;
        }
        else
            {
            return null;
        }
    }

    @Override
    public User getUser(UserType type) {
        return null;
    }
}
