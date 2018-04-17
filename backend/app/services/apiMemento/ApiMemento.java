package services.apiMemento;

import models.Api;

public class ApiMemento {

    private Api state;

    public ApiMemento (Api api) {
        this.state = api;
    }

    public Api getState () {
        return this.state;
    }

}
