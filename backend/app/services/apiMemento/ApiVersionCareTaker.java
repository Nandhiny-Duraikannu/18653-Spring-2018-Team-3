package services.apiMemento;

import DAO.ApiDAO;
import models.Api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApiVersionCareTaker {

    private List<ApiMemento> versions;

    public ApiVersionCareTaker () {
        this.versions = new ArrayList<>();
    }

    public void add(ApiMemento memento) {
        memento.getState().setSubmissionVersion(this.versions.size() + 1);
        if (this.versions.size() != 0) {
            memento.getState().setUser(this.versions.get(0).getState().getUser());
            memento.getState().setState(this.versions.get(0).getState().getState());
        }
        versions.add(memento);
    }

    public ApiMemento get(int index) {
        return versions.get(index);
    }

    public void loadVersions (int apiId) {
        ApiDAO apiDAO = new ApiDAO();
        List<Api> apiVersions = apiDAO.getVersionsOfApi(apiId);

        Iterator<Api> apiIterator = apiVersions.iterator();
        while(apiIterator.hasNext()) {
            ApiMemento memento = new ApiMemento(apiIterator.next());
            this.add(memento);
        }
    }

    public void saveVersions () {
        Iterator<ApiMemento> apiMementoIterator= this.versions.iterator();
        while (apiMementoIterator.hasNext()) {
            ApiMemento memento = apiMementoIterator.next();
            Api api = memento.getState();
            api.save();
        }
    }
}
