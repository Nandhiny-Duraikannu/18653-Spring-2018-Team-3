package services.submissions;

import models.Api;
import models.Mashup;
import models.User;

import java.util.ArrayList;

public class SubmissionCache {

    private Api api;
    private Mashup mashup;

    public SubmissionCache () { }

    public void loadCache () {
        this.initializeApi();
        this.initializeMashup();
        this.mashup = new Mashup();
    }

    public Api getApi () {
        return (Api) this.api.clone();
    }

    public Mashup getMashup () {
        return (Mashup) this.mashup.clone();
    }

    private void initializeApi () {
        this.api = new Api();
        this.api.setComments(new ArrayList<>());
        this.api.setDescription("");
        this.api.setEmail("");
        this.api.setEndpoint("");
        this.api.setHomepage("");
        this.api.setId(Long.parseLong("0"));
        this.api.setName("");
        this.api.setScope("");
        this.api.setUser(null);
        this.api.setVersion("0");
        this.api.setSubmissionVersion(1);
    }

    private void initializeMashup () {
        this.mashup = new Mashup();
        this.mashup.setComments(new ArrayList<>());
        this.mashup.setDescription("");
        this.mashup.setEmail("");
        this.mashup.setEndpoint("");
        this.mashup.setHomepage("");
        this.mashup.setId(Long.parseLong("0"));
        this.mashup.setMashups(null);
        this.mashup.setName("");
        this.mashup.setScope("");
        this.mashup.setUser(null);
        this.mashup.setVersion("0");
        this.mashup.setSubmissionVersion(1);
    }

}
