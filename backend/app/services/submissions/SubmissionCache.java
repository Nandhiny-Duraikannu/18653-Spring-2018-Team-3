package services.submissions;

import models.Api;
import models.Mashup;

public class SubmissionCache {

    private Api api;
    private Mashup mashup;

    public SubmissionCache () { }

    public void loadCache () {
        this.api = new Api();
        this.mashup = new Mashup();
    }

    public Api getApi () {
        return (Api) this.api.clone();
    }

    public Mashup getMashup () {
        return (Mashup) this.mashup.clone();
    }

}
